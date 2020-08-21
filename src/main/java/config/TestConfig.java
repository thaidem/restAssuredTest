package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseLogSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static constans.Constans.Servers.REQUEST_BIN_URL;
import static constans.Constans.Servers.SWAPI_URL;
import static constans.Constans.runVariable.path;
import static constans.Constans.runVariable.server;

public class TestConfig {

  protected RequestSpecification requestSpecificationForSwapi = new RequestSpecBuilder()
          .setBaseUri(SWAPI_URL)
          .build();

  protected RequestSpecification requestSpecificationXml = new RequestSpecBuilder()
          .addHeader("Content-Type", "application/json")
          .addCookie("testCookieXML")
          .setBaseUri(REQUEST_BIN_URL)
          .build();

  protected RequestSpecification requestSpecificationJson = new RequestSpecBuilder()
          .addHeader("Content-Type", "application/json")
          .addCookie("testCookieJSON")
          .build();

  protected ResponseSpecification responseSpecificationForGet = new ResponseSpecBuilder()
          .expectStatusCode(200)
          .build();

  protected ResponseSpecification responseSpecificationForPost = new ResponseSpecBuilder()
          .expectStatusCode(201)
          .build();


  @BeforeClass
  public void setUp() {
    RestAssured.baseURI = server;
    RestAssured.basePath = path;



  }


}
