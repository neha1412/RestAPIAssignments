import Users.UsersClient;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class createUserTests {

    //Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldCreateMaleUsers() {

        String email = String.format("%s@gmail.com" , UUID.randomUUID());

        String body = String.format("{\n" +
                "  \"name\": \"Tenali Rama\", \n" +
                " \"gender\": \"male\", \n" +
                " \"email\": \"%s\",\n" +
                " \"status\": \"active\"\n" +
                "}" , email);
        usersClient.createUsers(body)
                .then()
                .log().body()
                .statusCode(201)
                .body("data.name", Matchers.equalTo("Tenali Rama"));
    }


    @Test
    public void shouldCreateFemaleUsers() {

        String email = String.format("%s@gmail.com" , UUID.randomUUID());
        String body = String.format("{\n" +
                "  \"name\": \"Sonia K\", \n" +
                " \"gender\": \"female\", \n" +
                " \"email\": \"%s\",\n" +
                " \"status\": \"active\"\n" +
                "}", email);
        usersClient.createUsers(body)
                .then()
                .log().body()
                .statusCode(201)
                .body("data.name", Matchers.equalTo("Sonia K"));
    }
}
