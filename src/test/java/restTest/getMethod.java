package restTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static  org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class getMethod {

	@Test
	public void GetBookingIds_VerifyStatusCode() {
		
		given()
			.baseUri("https://reqres.in/")
		.when().
			get("/api/users/2")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.body("data.id",equalTo(2))
		    .body("data.email", equalTo("janet.weaver@reqres.in"))
		    .body("data.first_name", equalTo("Janet"))
		    .body("data.last_name", equalTo("Weaver"));
	
	}
	
}

/*
{
"data": {
    "id": 2,
    "email": "janet.weaver@reqres.in",
    "first_name": "Janet",
    "last_name": "Weaver",
    "avatar": "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"
}
}
*/