import Users.UsersClient;
import Users.create.CreateUserRequestBody;
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

        String email = String.format("%s@gmail.com",UUID.randomUUID());
        String gender = "male";
        String status = "active";
        String name = "Tenali Rama";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name,gender,email,status);
        usersClient.createUsers(requestBody)
                .then()
                .log().body()
                .statusCode(201)
                .body("data.name", Matchers.equalTo("Tenali Rama"));
    }


    @Test
    public void shouldCreateFemaleUsers() {

        String email = String.format("%s@gmail.com",UUID.randomUUID());
        String name = "Sonia K";
        String gender = "female";
        String status = "active";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name,gender,email,status);
        usersClient.createUsers(requestBody)
                .then()
                .log().body()
                .statusCode(201)
                .body("data.name", Matchers.equalTo("Sonia K"));
    }
}
