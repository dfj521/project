package com.dfj.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * 封装了创建SqlSessionFactory和SqlSession
 */
public class MybatisUtil {
    private static SqlSessionFactory ssf;
    static {
        //加载配置文件
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        ssf = sqlSessionFactoryBuilder.build(MybatisUtil.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml"));
    }

    public static SqlSession getSqlSession() {
        return ssf.openSession();
    }
}
