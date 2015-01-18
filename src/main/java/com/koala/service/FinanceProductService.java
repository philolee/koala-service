package com.koala.service;

import com.koala.mybatis.generated.dao.FinanceProductMapper;
import com.koala.mybatis.generated.model.FinanceProduct;
import com.koala.mybatis.generated.model.FinanceProductExample;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FinanceProductService {
  private static final Logger LOGGER = LoggerFactory.getLogger(FinanceProductService.class);

  public List<FinanceProduct> search(SearchRequest request) {
    try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
      FinanceProductMapper productMapper = sqlSession.getMapper(FinanceProductMapper.class);
      FinanceProductExample productExample = new FinanceProductExample();
      FinanceProductExample.Criteria criteria = productExample.createCriteria();

      if (request.getRateBegin() != null)
        criteria.andExpectedProfitRateGreaterThanOrEqualTo(request.getRateBegin());
      if (request.getRateEnd() != null)
        criteria.andExpectedProfitRateLessThanOrEqualTo(request.getRateEnd());

      if (request.getInvestCycleBegin() != null)
        criteria.andInvestCycleGreaterThanOrEqualTo(request.getInvestCycleBegin());
      if (request.getInvestCycleEnd() != null)
        criteria.andInvestCycleLessThanOrEqualTo(request.getInvestCycleEnd());

      if (request.getRiskScoreBegin() != null)
        criteria.andRiskScoreGreaterThanOrEqualTo(request.getRiskScoreBegin());
      if (request.getRiskScoreEnd() != null)
        criteria.andRiskScoreLessThanOrEqualTo(request.getRiskScoreEnd());

      LOGGER.info("Search request : {}", request);
      return productMapper.selectByExample(productExample);
    }
  }
}
