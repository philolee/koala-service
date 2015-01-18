package com.koala.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.koala.mybatis.generated.dao.FinanceProductMapper;
import com.koala.mybatis.generated.model.FinanceProduct;
import com.koala.service.MyBatisUtil;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DBImporter {
  private static final Pattern PATTERN;
  static {
    PATTERN = Pattern.compile("(\\d+)", Pattern.DOTALL);
  }

  private String dataFilePath;

  public DBImporter(String dbProperties, String dataFile) {
    System.setProperty(MyBatisUtil.MYBATIS_DB_PROPERTIES, dbProperties);
    this.dataFilePath = dataFile;
  }

  private Integer extractNumber(String text) {
    Matcher matcher = PATTERN.matcher(text);
    if (matcher.find()) {
      return Integer.valueOf(matcher.group(1));
    }
    return null;
  }

  public void process() throws IOException {
    List<String> lines = FileUtils.readLines(new File(dataFilePath));
    try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
      FinanceProductMapper productMapper = sqlSession.getMapper(FinanceProductMapper.class);
      int counter = 0;
      for (String line : lines) {
        JSONObject json = JSON.parseObject(line);

        /*
        String titleAll = json.getString("titleAll");
        FinanceProductExample productExample = new FinanceProductExample();
        productExample.createCriteria().andTitleAllEqualTo(titleAll);
        FinanceProduct product = DAOUtils.getFirstOrNull(productMapper.selectByExample(productExample));
        boolean isUpdate = true;
        if (product == null) {
          isUpdate = false;
        }
        */
        FinanceProduct product = new FinanceProduct();
        product.setTitle(json.getString("title"));
        product.setChannelName(json.getString("channelName"));
        product.setChannelNameShort(json.getString("channelNameShort"));
        product.setChannelUrl(json.getString("channelUrl"));
        product.setExpectedProfitName(json.getString("expectedProfitName"));
        product.setExpectedProfitRate(json.getFloat("expectedProfitRate"));

        product.setInvestCycle(extractNumber(json.getString("investCycle")));
        product.setInvestField(json.getString("investField"));

        product.setLowestAmount(extractNumber(json.getString("lowestAmount")));
        product.setProductTypeLabel(json.getString("productTypeLabel"));
        // product.setRawUrl(json.getString("rawUrl"));
        product.setRiskScore(json.getInteger("riskScore"));
        product.setSupplierLogoUrl(json.getString("supplierLogoUrl"));
        product.setSupplierName(json.getString("supplierNameShort"));
        /*
        if (isUpdate) {
          productMapper.updateByPrimaryKey(product);
          System.out.println("update");
          */
        productMapper.insert(product);
        System.out.println(++counter);
      }
      sqlSession.commit();
    }
  }

  public static void main(String[] args) throws IOException {
    String dbProperties = "./config/db.properties";
    String dataFilePath = "./config/data.txt";
    if (args.length == 2) {
      dbProperties = args[0];
      dataFilePath = args[1];
    }
    System.setProperty("log.path", "./log");
    new DBImporter(dbProperties, dataFilePath).process();
  }
}
