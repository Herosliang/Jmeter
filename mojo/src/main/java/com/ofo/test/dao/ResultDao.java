package com.ofo.test.dao;

import com.ofo.test.dao.base.HibnaterDAO;
import com.ofo.test.model.Result;
import jdk.nashorn.api.scripting.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.testng.annotations.Test;


/**
 * Created by liangwei on 2018/8/8.
 */
@Repository
public class ResultDao extends HibnaterDAO<Result> {

    public void saveDAO(Result result){
        System.out.println("保存前");

        save(result);
        System.out.println("保存后");
    }

}
