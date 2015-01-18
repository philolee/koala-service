package com.koala.service;

import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyBatisUtil {
  public static final String MYBATIS_DB_PROPERTIES = "mybatis.db.properties";
  private static final String DB_PROPERTIES = "db.properties";
  private static SqlSessionFactory factory;

  private MyBatisUtil() {
  }

  public static SqlSessionFactory getSqlSessionFactory() {
    if (factory == null) {
      synchronized (MyBatisUtil.class) {
        if (factory == null) {
          try {
            Properties prop = new Properties();
            String path = System.getProperty(MYBATIS_DB_PROPERTIES);
            if (path != null) {
              prop.load(new FileInputStream(path));
            } else {
              prop.load(MyBatisUtil.class.getClassLoader().getResourceAsStream(DB_PROPERTIES));
            }
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(inputStream, prop);
          } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
          }
        }
      }
    }
    return factory;
  }
}
