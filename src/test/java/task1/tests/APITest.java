package task1.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.*;


public class APITest {
    private String url = "https://reqres.in/api/users/2";
    private String responseString = "data.first_name";
    private String nameExpected = "Janet";

    @Test
    public void getSingleUserAPITest() {
        given()
                .get(url)
        .then()
                .statusCode(SC_OK)
                .body(responseString, equalTo(nameExpected));
    }
}
