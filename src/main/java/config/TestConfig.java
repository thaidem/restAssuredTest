package config;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static constans.Constans.runVariable.path;
import static constans.Constans.runVariable.server;

public class TestConfig {

  @BeforeClass
  public void setUp() {
    RestAssured.baseURI = server;
    RestAssured.basePath = path;
  }
}
