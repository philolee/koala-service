package com.koala.service;


import com.koala.model.FinanceProduct;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class KoalaResource {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<FinanceProduct> getMessage() {
    FinanceProduct product = new FinanceProduct();
    product.setId(1);
    product.setName("test");
    product.setSource("ok");
    List<FinanceProduct> products = new ArrayList<>();
    products.add(product);
    return products;
  }
}
