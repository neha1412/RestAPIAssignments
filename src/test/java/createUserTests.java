import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class createUserTests {
    @Test
    public void shouldCreateMaleUsers() {

        String body = "{\n" +
                "  \"name\": \"Tenali Rama\", \n" +
                " \"gender\": \"male\", \n" +
                " \"email\": \"tenali.rama17@gmail.com\",\n" +
                " \"status\": \"active\"\n" +
                "}";
        createUsers(body)
                .then()
                .log().body()
                .statusCode(201)
                .body("data.name", Matchers.equalTo("Tenali Rama"));
    }

    private Response createUsers(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 7af240fb7b557b1314869bc519303f4e79eb90f287818ef0c9b01eef8e85f17a")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }

    @Test
    public void shouldCreateFemaleUsers() {

        String body = "{\n" +
                "  \"name\": \"Sonia K\", \n" +
                " \"gender\": \"female\", \n" +
                " \"email\": \"soniak13@gmail.com\",\n" +
                " \"status\": \"active\"\n" +
                "}";
        createUsers(body)
                .then()
                .log().body()
                .statusCode(201)
                .body("data.name", Matchers.equalTo("Sonia K"));
    }
}
