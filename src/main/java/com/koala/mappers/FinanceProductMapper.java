package com.koala.mappers;

import com.koala.model.FilterParam;
import com.koala.model.FinanceProduct;

import java.util.List;

public interface FinanceProductMapper {
  public List<FinanceProduct> getProductById(FilterParam param);
}
