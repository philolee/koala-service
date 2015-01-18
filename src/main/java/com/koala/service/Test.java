package com.koala.service;


import com.koala.mybatis.generated.model.FinanceProduct;

import java.util.List;

public class Test {

  public static void main(String[] args) {
    FinanceProductService service = new FinanceProductService();
    SearchRequest searchRequest = new SearchRequest();
    searchRequest.setRateBegin(0f);
    List<FinanceProduct> products = service.search(searchRequest);
    for (FinanceProduct product : products) {
      System.out.println(product.getId());
      System.out.println(product.getTitle());
      System.out.println(product.getSource());
    }
  }
}
