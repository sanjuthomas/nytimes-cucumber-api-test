package com.sanjuthomas.nytimes.api.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"com.sanjuthomas.nytimes.api.test"},
        features = {"src/test/resources/"})
public class CucumberTest {

}