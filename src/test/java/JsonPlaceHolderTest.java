import config.TestConfig;
import org.testng.annotations.Test;

import static constans.Constans.Actions.*;
import static io.restassured.RestAssured.given;

public class JsonPlaceHolderTest extends TestConfig {

  @Test
  public void GET() {
    given().queryParam("postId", 1).log().uri().
    when().get(JASON_PLACEHOLDER_POST).
    then().log().body().statusCode(200);
  }

  @Test
  public void PUT() {

    String putBodyJson = "{\n" +
            "\"id\" : 1,\n" +
            "\"title\" : \"foo\",\n" +
            "\"body\" : \"bar\",\n" +
            "\"userId\" : 1\n" +
            "}";

    given().body(putBodyJson).log().all().
    when().put(JASON_PLACEHOLDER_PUT).
    then().log().body().statusCode(200);

  }

  @Test
  public void DELETE() {
    given().log().uri().
    when().delete(JASON_PLACEHOLDER_DELETE).
    then().log().body().statusCode(200);
  }

  @Test
  public void PostWithJson() {

    String postJasonbBody = "{\n" +
            "\"title\" : \"foo\",\n" +
            "\"body\" : \"bar\",\n" +
            "\"userId\" : 1\n" +
            "}";

    given().body(postJasonbBody).log().all().
            when().post(JASON_PLACEHOLDER_POST).
            then().log().body().statusCode(201);

  }

  @Test
  public void PostWithXML() {

    String postXMLBody = "<Company>\n" +
            "  <Employee>\n" +
            "      <FirstName>Tanmay</FirstName>\n" +
            "      <LastName>Patil</LastName>\n" +
            "      <ContactNo>1234567890</ContactNo>\n" +
            "      <Email>tanmaypatil@xyz.com</Email>\n" +
            "      <Address>\n" +
            "           <City>Bangalore</City>\n" +
            "           <State>Karnataka</State>\n" +
            "           <Zip>560212</Zip>\n" +
            "      </Address>\n" +
            "  </Employee>\n" +
            "</Company>";

    given().spec(requestSpecificationXml).body(postXMLBody).log().all().
            when().post("").
            then().log().body().statusCode(200);

  }

}
