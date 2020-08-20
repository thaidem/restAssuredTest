import config.TestConfig;
import org.testng.annotations.Test;

import static constans.Constans.Actions.SWAPI_GET_PEOPLE;
import static io.restassured.RestAssured.given;

public class FirstTest extends TestConfig {

  @Test
  public void myFirstTest() {
    given().log().uri().
    when().get(SWAPI_GET_PEOPLE + "1").
    then().log().body().statusCode(200);
  }
}
