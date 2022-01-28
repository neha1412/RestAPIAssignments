import Users.UsersClient;
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
                " \"email\": \"tenali.rama18@gmail.com\",\n" +
                " \"status\": \"active\"\n" +
                "}";
        new UsersClient().createUsers(body)
                .then()
                .log().body()
                .statusCode(201)
                .body("data.name", Matchers.equalTo("Tenali Rama"));
    }


    @Test
    public void shouldCreateFemaleUsers() {

        String body = "{\n" +
                "  \"name\": \"Sonia K\", \n" +
                " \"gender\": \"female\", \n" +
                " \"email\": \"soniak14@gmail.com\",\n" +
                " \"status\": \"active\"\n" +
                "}";
        new UsersClient().createUsers(body)
                .then()
                .log().body()
                .statusCode(201)
                .body("data.name", Matchers.equalTo("Sonia K"));
    }
}
