package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static constans.Constans.Servers.REQUEST_BIN_URL;
import static constans.Constans.runVariable.path;
import static constans.Constans.runVariable.server;

public class TestConfig {



  protected RequestSpecification requestSpecificationXml = new RequestSpecBuilder()
          .addHeader("Content-Type", "application/json")
          .addCookie("testCookieXML")
          .setBaseUri(REQUEST_BIN_URL)
          .build();


  @BeforeClass
  public void setUp() {
    RestAssured.baseURI = server;
    RestAssured.basePath = path;

    RequestSpecification requestSpecificationJson = new RequestSpecBuilder()
            .addHeader("Content-Type", "application/json")
            .addCookie("testCookieJSON")
            .build();

    RestAssured.requestSpecification = requestSpecificationJson;

  }


}
