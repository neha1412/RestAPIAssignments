import Users.UsersClient;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getAllUsersTests {

    //Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
      usersClient = new UsersClient();
    }

    @Test
    public void toGetAllUsers()
    {

    //Act
        usersClient.getAllUsers()
                .then()

    //Assert
                .statusCode(200)
                .log().body()
                .body("data", Matchers.hasSize(20));
    }

}
