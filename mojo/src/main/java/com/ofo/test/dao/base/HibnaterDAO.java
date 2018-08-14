package com.ofo.test.dao.base;

import com.ofo.test.model.Result;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by liangwei on 2018/8/11.
 */
public class HibnaterDAO<T> {
    private Class<T> entityClass;
    static Configuration conf;
    static SessionFactory sf ;
    static Session session ;
    static Transaction ts;

    public HibnaterDAO(){
        try {
            Type genType = getClass().getGenericSuperclass();
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            entityClass = (Class) params[0];
        } catch (Exception ex) {
        }
    }

    private void getConn(){
        conf = new Configuration().configure();
        sf = conf.buildSessionFactory();
        session = sf.getCurrentSession();
        ts = session.beginTransaction();
    }

    public  void save(Object T){
        getConn();
        try {
            session.save(T);
            ts.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            ts.rollback();
        }finally {
            if (session.isOpen()){
                session.close();
            }
            if (!sf.isClosed()){
                sf.close();
            }

        }
    }

    public void update(Object T){
        getConn();
        try {
            session.update(T);
            ts.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            ts.rollback();
        }finally {
            session.close();
            sf.close();
        }
    }

    public void delete(Object T){
        getConn();
        try {
            session.delete(T);
            ts.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            ts.rollback();
        }finally {
            session.close();
            sf.close();
        }
    }

    public void select (Object T){
        getConn();
        try {
            String table = entityClass.getName().substring(
                    entityClass.getName().lastIndexOf(".")+1);
            System.out.println(table);

            List<T> results =  session.createQuery("from "+table).list();
            for (int i=0;i<results.size();i++){
                System.out.println(results.get(i));
            }
        }catch (HibernateException e){
            e.printStackTrace();
            ts.rollback();
        }finally {
            session.close();
            sf.close();
        }
    }
}
