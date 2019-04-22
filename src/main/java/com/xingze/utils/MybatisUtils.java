package com.xingze.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import java.io.Reader;

public class MybatisUtils {

  private static SqlSessionFactory sqlSessionFactory = null;
  //初始化 SqlSessionFactory 对象
  static {
      try{
          //1 读取配置文件
          String resource ="mybatis-config.xml";
          Reader reader = Resources.getResourceAsReader(resource);
          sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
  } 

  //获取 SqlSession 对象的静态方法
  public static SqlSession getSession()
  {
      return sqlSessionFactory.openSession();
  }

}

