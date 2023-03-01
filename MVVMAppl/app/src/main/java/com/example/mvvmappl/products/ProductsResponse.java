package com.example.mvvmappl.products;

import java.util.List;

public class ProductsResponse {

  public List<Products> products;
  public int total;
  public int skip;
  public int limit;

  public List<Products> getProducts(){
    return products;
  }
}
