package com.koala.service.controller;

import com.koala.mybatis.generated.model.FinanceProduct;
import com.koala.service.FinanceProductService;
import com.koala.service.SearchRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/rest")
public class KoalaController {
  private static FinanceProductService service = new FinanceProductService();

  @RequestMapping(value = "/search", method = RequestMethod.GET)
  @ResponseBody
  public List<FinanceProduct> search(SearchRequest request) {
    return service.search(request);
  }
}
