import Users.UsersClient;
import Users.create.CreateUserRequestBody;
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

        String name = "Sonia K";
        String gender = "female";
        String email = "soniak13gmail.com";
        String status = "active";

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name(name).gender(gender).email(email).status(status).build();
        usersClient.createUsers(requestBody)
                .then()
                .log().body()
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }
    }

