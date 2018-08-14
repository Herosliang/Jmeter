package com.ofo.test.model;

import com.mysql.fabric.xmlrpc.base.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Transient;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by liangwei on 2018/8/8.
 */
@Entity
@Table(name = "resulte")

public class Result {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "jmx_name" ,nullable=true)
    private String jmx_name;

    @Column(name = "lable")
    private String test_lable;

    @Column(name = "total_num",nullable=true)
    private int total_num;

    @Column(name = "success_num",nullable=true)
    private int success_num;

    @Column(name = "tail_num",nullable=true)
    private int tail_num;

    @Column(name = "resulte",nullable=true)
    private int resulte;

    @Column(name = "create_at",nullable=true)
    @Transient
    private Timestamp create_at;


    public String getJmx_name() {
        return jmx_name;
    }

    public void setJmx_name(String jmx_name) {
        this.jmx_name = jmx_name;
    }

    public String getTest_lable(){
        return test_lable;
    }
    public void setTest_lable(String test_lable){
        this.test_lable=test_lable;
    }

    public int getTotal_num() {
        return total_num;
    }

    public void setTotal_num(int total_num) {
        this.total_num = total_num;
    }

    public int getSuccess_num() {
        return success_num;
    }

    public void setSuccess_num(int success_num) {
        this.success_num = success_num;
    }

    public int getTail_num() {
        return tail_num;
    }

    public void setTail_num(int tail_num) {
        this.tail_num = tail_num;
    }

    public int getResulte() {
        return resulte;
    }

    public void setResulte(int resulte) {
        this.resulte = resulte;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }


/*    @Override
    public String toString(){
        return String.format("User信息：id=%s\njmx_name=%s\n",id,jmx_name);
    }*/
}
