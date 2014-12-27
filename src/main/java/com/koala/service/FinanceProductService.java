package com.koala.service;

import com.koala.mappers.FinanceProductMapper;
import com.koala.model.FilterParam;
import com.koala.model.FinanceProduct;
import org.apache.ibatis.session.SqlSession;

import java.io.File;
import java.util.List;

public class FinanceProductService {

  public List<FinanceProduct> getProductById(FilterParam param) {
    SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
    try{
      FinanceProductMapper productMapper = sqlSession.getMapper(FinanceProductMapper.class);
      return productMapper.getProductById(param);
    }finally{
      sqlSession.close();
    }
  }
}
