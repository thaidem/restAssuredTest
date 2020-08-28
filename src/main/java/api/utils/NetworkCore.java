package api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

import static io.restassured.RestAssured.given;


public class NetworkCore {

  protected Response responce;
  protected RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
  protected JSONObject  responceBody;

  public void sentRequestAndGetResponce(Method method, int code) {
    responce = given().spec(requestSpecBuilder.build()).log().uri().log().parameters()
            .when().request(method);
    responce.then().assertThat().statusCode(code);

    try {
      responceBody = new JSONObject(responce.getBody().asString());
    } catch (Exception e) {
      Assert.fail("Can't get responce body");
    }

  }
}
