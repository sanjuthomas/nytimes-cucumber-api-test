package com.sanjuthomas.nytimes.api.test;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {

  @Before
  public void setup() {
    System.out.println("before every scenario.");
  }

  @After
  public void tearDown() {
    System.out.println("after every scenario.");
  }

}
