import Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class createUserWithInvaildEmail {

    //Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void shouldnotAllowtoCreateUserWithInvalidEmail()
    {
        String body = "{\n" +
                "  \"name\": \"Sonia K\", \n" +
                " \"gender\": \"female\", \n" +
                " \"email\": \"soniak13gmail.com\",\n" +
                " \"status\": \"active\"\n" +
                "}";
        usersClient.createUsers(body)
                .then()
                .log().body()
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
    }

