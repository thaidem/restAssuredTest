package constans;

import static constans.Constans.Servers.JASON_PLACEHOLDER_URL;

public class Constans {

  public static class runVariable {
    public static String server = Servers.JASON_PLACEHOLDER_URL;
    public static String path = "";
  }
  public static class Servers {
    public static String SWAPI_URL = "https://swapi.dev/";
    public static String JASON_PLACEHOLDER_URL = "https://jsonplaceholder.typicode.com/";
    public static String REQUEST_BIN_URL = "https://2d4f6b8cc1b874f75c2e3bd349212f65.m.pipedream.net";
    public static String GOOGLE_PLACES_URL;
  }

  public static class Path {
    public static String SWAPI_PATH = "api/";
    public static String GOOGLE_PLACES_PATH;
  }

  public static class Actions {
   // swapi
    public static String SWAPI_GET_PEOPLE = "people/";

    // google_places

    // json_holder
    public static String JASON_PLACEHOLDER_GET = "comments/";
    public static String JASON_PLACEHOLDER_PUT = "posts/1/";
    public static String JASON_PLACEHOLDER_DELETE = "posts/1/";
    public static String JASON_PLACEHOLDER_POST = "posts/";


  }


}
