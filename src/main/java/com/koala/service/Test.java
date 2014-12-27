package com.koala.service;

import com.koala.model.FilterParam;
import com.koala.model.FinanceProduct;

import java.util.List;

public class Test {

  public static void main(String[] args) {

    FinanceProductService service = new FinanceProductService();
    FilterParam param = new FilterParam();
    param.setBeginRate(3);
    List<FinanceProduct> products = service.getProductById(param);
    for (FinanceProduct product : products) {
      System.out.println(product.getId());
      System.out.println(product.getName());
      System.out.println(product.getSource());
    }
  }

}
