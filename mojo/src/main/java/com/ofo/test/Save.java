package com.ofo.test;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.mysql.fabric.xmlrpc.base.Data;
import com.ofo.test.dao.ResultDao;
import com.ofo.test.model.Result;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Goal which touches a timestamp file.
 *@Mojo(name = "jmeter-save")
 * @goal save
 * 
 * @phase process-sources
 */

public class Save
    extends AbstractMojo
{
    /**
     * Location of the file.
     * @parameter
     * expression="${project.build.directory}"
     * @required
     */
    private File outputDirectory;

    /**
     * @parameter
     * expression="${res}"
     *
     */
    private String res;

    private String jmx_name;

    private int total_num;

    private int success_num;

    private int tail_num;

    private int resulte;

    private Timestamp create_at;

    public void execute()
        throws MojoExecutionException
    {
        splitString();
        //组装结果对象

        Result result = new Result();
        result.setJmx_name(jmx_name);
        result.setTotal_num(total_num);
        result.setSuccess_num(success_num);
        result.setTail_num(tail_num);
        result.setResulte(resulte);
        result.setCreate_at(create_at);
        ResultDao resultDao = new ResultDao();
        resultDao.save(result);
    }
    //拆分传递过来的数据，String类型或者Json类型
    private void splitString(){
        String s1 = res;
        //拆分传递过来的数据映射到对应字段

        jmx_name="eee";
        total_num=10;
        success_num=10;
        tail_num=0;
        resulte=1;
        create_at=new Timestamp(1);

    }
}
