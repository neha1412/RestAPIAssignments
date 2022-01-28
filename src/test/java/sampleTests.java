import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class sampleTests {

    @Test
    public void toGetAllUsers()
    {

        given()
                .when()
                .get("https://gorest.co.in/public/v1/users")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    public void shouldCreateUsers() {

        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 7af240fb7b557b1314869bc519303f4e79eb90f287818ef0c9b01eef8e85f17a")
                .body("{\n" +
                        "  \"name\": \"Tenali Rama\", \n" +
                        " \"gender\": \"male\", \n" +
                        " \"email\": \"tenali.rama12@gmail.com\",\n" +
                        " \"status\": \"active\"\n" +
                        "}")
                .when()
                .post("https://gorest.co.in/public/v1/users")
                .then()
                .log().body()
                .statusCode(201);
    }
}
