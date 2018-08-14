package com.ofo.test.bo;

import com.ofo.test.dao.ResultDao;
import com.ofo.test.model.Result;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by liangwei on 2018/8/13.
 */
public class Saveservices {
/*    private String jmx_name;

    private int total_num;

    private int success_num;

    private int tail_num;

    private int resulte;
resulte
    private int create_at;*/

@Test
    public void test (){

        JSONObject obj = new JSONObject();
        obj.put("totalTest", 1);
        obj.put("successTest", 1);
        obj.put("failedTest", 0);
        obj.put("jmx_name","SCN-Base");
        obj.put("label", "测试类别");
        obj.put("isSuccessful",1);
        obj.put("create_at",new Timestamp(System.currentTimeMillis()));
        resulteSave(obj);
    }
    public static void resulteSave(JSONObject obj){

        Result rs = new Result();
        rs.setTest_lable((String)obj.get("label"));
        rs.setTotal_num((Integer) obj.get("totalTest"));
        rs.setTail_num((Integer) obj.get("failedTest"));
        rs.setSuccess_num((Integer) obj.get("successTest"));
        rs.setResulte((Integer) obj.get("isSuccessful"));
        rs.setCreate_at((Timestamp)obj.get("create_at"));
        rs.setJmx_name((String)(obj.get("jmx_name")));

        ResultDao rd = new ResultDao();
        rd.saveDAO(rs);
    }
}
