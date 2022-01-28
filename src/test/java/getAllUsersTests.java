import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getAllUsersTests {

    @Test
    public void toGetAllUsers()
    {

        given()
                .when()
                .get("https://gorest.co.in/public/v1/users")
                .then()
                .statusCode(200)
                .log().body()
                .body("data", Matchers.hasSize(20));
    }


}
