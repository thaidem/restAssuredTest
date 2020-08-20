import config.TestConfig;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import static constans.Constans.Actions.JASON_PLACEHOLDER_POST;
//import static io.restassured.RestAssured.given;

public class JsonPlaceHolder extends TestConfig {

    @Test
    public void PostWithJson() {

        String postJasonbBody = "{\n" +
                "\"title\" : foo,\n" +
                "\"body\" : bar,\n" +
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
