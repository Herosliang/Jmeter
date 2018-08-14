/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

/////////////////////////////////////////
////////
//////// This code is mostly unused at present
//////// it seems that only notifyListeners()
//////// is used.
////////
//////// However, it does look useful.
//////// And it may one day be used...
////////
/////////////////////////////////////////

package org.apache.jmeter.threads;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.jmeter.samplers.SampleEvent;
import org.apache.jmeter.samplers.SampleListener;
import org.apache.jmeter.testbeans.TestBeanHelper;
import org.apache.jmeter.testelement.TestElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Processes sample events. <br>
 * The current implementation processes events in the calling thread
 * using {@link #notifyListeners(SampleEvent, List)} <br>
 * Thread safe class 
 */
public class ListenerNotifier implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -4861457279068497917L;
    private static final Logger log = LoggerFactory.getLogger(ListenerNotifier.class);


    /**
     * Notify a list of listeners that a sample has occurred.
     *
     * @param res
     *            the sample event that has occurred. Must be non-null.
     * @param listeners
     *            a list of the listeners which should be notified. This list
     *            must not be null and must contain only SampleListener
     *            elements.
     */




    public void notifyListeners(SampleEvent res, List<SampleListener> listeners) {

        for (SampleListener sampleListener : listeners) {
            try {
                TestBeanHelper.prepare((TestElement) sampleListener);
                /// TODO: 2018/7/25 修改保存的中文Unicode问题
                /// TODO: 2018/7/25 jmeter 发送json时编码，展示时未做decode，这里添加decode以方便查看发送请求信息
                ///如果不是http请求的sample不做处理
                if(res.getResult().getURL()!= null) {
                    try {
                        String s2 = new String(res.getResult().getResponseData(), "UTF-8");
                        char aChar;
                        int len = s2.length();
                        StringBuffer outBuffer = new StringBuffer(len);
                        for (int x = 0; x < len; ) {
                            aChar = s2.charAt(x++);
                            if (aChar == '\\') {
                                aChar = s2.charAt(x++);
                                if (aChar == 'u') {
                                    int value = 0;
                                    for (int i = 0; i < 4; i++) {
                                        aChar = s2.charAt(x++);
                                        switch (aChar) {
                                            case '0':
                                            case '1':
                                            case '2':
                                            case '3':
                                            case '4':
                                            case '5':
                                            case '6':
                                            case '7':
                                            case '8':
                                            case '9':
                                                value = (value << 4) + aChar - '0';
                                                break;
                                            case 'a':
                                            case 'b':
                                            case 'c':
                                            case 'd':
                                            case 'e':
                                            case 'f':
                                                value = (value << 4) + 10 + aChar - 'a';
                                                break;
                                            case 'A':
                                            case 'B':
                                            case 'C':
                                            case 'D':
                                            case 'E':
                                            case 'F':
                                                value = (value << 4) + 10 + aChar - 'A';
                                                break;
                                            default:
                                                throw new IllegalArgumentException(
                                                        "Malformed   \\uxxxx  encoding.");
                                        }
                                    }
                                    outBuffer.append((char) value);
                                } else {
                                    if (aChar == 't')
                                        aChar = '\t';
                                    else if (aChar == 'r')
                                        aChar = '\r';
                                    else if (aChar == 'n')
                                        aChar = '\n';
                                    else if (aChar == 'f')
                                        aChar = '\f';
                                    outBuffer.append(aChar);
                                }
                            } else
                                outBuffer.append(aChar);
                        }
//-----------------以上内容为转码过程---------------------------
//将转成中文的响应结果在查看结果树中显示

                        res.getResult().setResponseData(outBuffer.toString());
                        String s3 = URLDecoder.decode(res.getResult().getURL().toString());
                        try {
                            res.getResult().setURL(new URL(s3));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }


                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                sampleListener.sampleOccurred(res);

            } catch (RuntimeException e) {
                log.error("Detected problem in Listener.", e);
                log.info("Continuing to process further listeners");
            }
        }
    }

}
