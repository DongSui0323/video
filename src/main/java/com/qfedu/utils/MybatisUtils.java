package com.qfedu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtils {
    private  static SqlSessionFactory factory = null;
    static {
        Reader reader = null;
        try {
            //读取主配置文件
            reader = Resources.getResourceAsReader("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取配置文件构造出 SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(reader);
    }
    public static SqlSession getSession() {
        //返回一个sqlsession对象
        return factory.openSession();
    }

}
