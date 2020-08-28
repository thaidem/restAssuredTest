package tests.google_places.positive;

import base.BaseTest;
import api.models.google_places.GooglePlacesModel;
import io.restassured.http.Method;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTestPositive extends BaseTest {

  @Test(description = "search some object", dataProvider = "")
  public void searchPlaceWithText(String key, String input, String inputtype) {
    GooglePlacesModel.RequestModel requestModel = GooglePlacesModel.RequestModel.builder()
            .key(key)
            .input(input)
            .inputtype(inputtype)
            .build();

    apiManger.getGooglePlacesModel().search(requestModel, Method.GET, 200 );
  }

  @DataProvider
  public Object[] [] searchText() {
    return new Object[][]{
            {"","new york","textquery"}
    };
  }
}
