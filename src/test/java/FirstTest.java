import config.TestConfig;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static constans.Constans.Actions.SWAPI_GET_PEOPLE;
import static constans.Constans.Path.SWAPI_PATH;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest extends TestConfig {

  @Test
  public void myFirstTest() {
    given().log().uri().
    when().get(SWAPI_GET_PEOPLE + "1").
    then().log().body().statusCode(200);
  }

  @Test
  public void getSomeFieldInResponceAsserton() {
    given().spec(requestSpecificationForSwapi).log().uri().
    when().get(SWAPI_PATH).
    then().body("people", equalTo("http://swapi.dev/api/people/")).log().body();
  }

  @Test
  public void getSomeFieldInResponceWithIndexAsserton() {
    given().spec(requestSpecificationForSwapi).log().uri().
            when().get(SWAPI_PATH + SWAPI_GET_PEOPLE).
            then().
            body("count", equalTo(82)).
            body("results.name[0]", equalTo("Luke Skywalker")).
            log().body();
  }

  @Test
  public void getAllDataFromRequest() {
    Response response =
            given().spec(requestSpecificationForSwapi).log().uri().
            when().get(SWAPI_PATH).
            then().extract().response();

    String jsonResponceAsString = response.asString();
    System.out.println(jsonResponceAsString);
  }

  @Test
  public void getCookieFromResponce() {
    Response response =
            given().spec(requestSpecificationForSwapi).log().uri().
            when().get(SWAPI_PATH).
            then().extract().response();

    Map<String, String> allCookies = response.getCookies();
    System.out.println(allCookies);

    String someCookie = response.getCookie("_cfduid");
    System.out.println(someCookie);
  }

  @Test
  public void  getHeaderFromResponce() {
    Response response =
            given().spec(requestSpecificationForSwapi).log().uri().
            when().get(SWAPI_PATH).
            then().extract().response();

    Headers headers = response.getHeaders();
    System.out.println(headers);

    String contentType = response.getContentType();
    System.out.println(contentType);
  }

  @Test
  public void validateXmlSchema() {
    given().log().uri().
    when().get("https://maps.googleapis.com/maps/api/place/findplacefromtext/xml?key=AIzaSyA5MXjpNWrUWxOMI1TZVeFaRzEd8hLmVLQ&input=New York&inputtype=textquery&fields=business_status,formatted_address,geometry,icon,name,permanently_closed,photos,place_id,plus_code,types&language=ru").
    then().body(matchesXsdInClasspath("xmlSchema.xsd")).log().body();
  }

  @Test
  public void validateJsonExample() {
    given().log().uri().
    when().get("https://maps.googleapis.com/maps/api/place/findplacefromtext/json?key=AIzaSyA5MXjpNWrUWxOMI1TZVeFaRzEd8hLmVLQ&input=New York&inputtype=textquery&fields=business_status,formatted_address,geometry,icon,name,permanently_closed,photos,place_id,plus_code,types&language=ru").
    then().body(matchesJsonSchemaInClasspath("jsonSchema.json")).log().body();
  }

  @Test
  public void getMapOfElementsWithSomekey() {
    Response response =
            given().spec(requestSpecificationForSwapi).log().uri().
            when().get(SWAPI_PATH + SWAPI_GET_PEOPLE);
    Map<String, ?> someObject = response.
            path("results.find {it.name = 'Obi-Wan Kenobi'}");
    System.out.println(someObject);
  }

    @Test
    public void getSingleElementWithSomekey() {
      Response response =
              given().spec(requestSpecificationForSwapi).log().uri().
              when().get(SWAPI_PATH + SWAPI_GET_PEOPLE);
      String url = response.
              path("results.find {it.name = 'Obi-Wan Kenobi'}.url");
      System.out.println(url);
    }

  @Test
  public void getAllElementsWithSomekey() {
    Response response =
            given().spec(requestSpecificationForSwapi).log().uri().
            when().get(SWAPI_PATH + SWAPI_GET_PEOPLE);
    List<String> films = response.
            path("results.findAll {it.films}.name");
    System.out.println(films);
  }

}
