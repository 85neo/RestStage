import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static  org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;


public class postMethod {
    
	@Test
	public void postMethodSample() {
		
		String jsonData="{\"name\": \"nitya\", \"job\": \"leader\"}";
		
		given()
			.baseUri("https://reqres.in/api/users")
			.contentType(ContentType.JSON)
			.body(jsonData)
		.when()
			.post()
		.then()
			.assertThat()
			.statusCode(201)
			.body("name", equalTo("nitya"));
			
	}
	
}

/*
{
"name": "morpheus",
"job": "leader",
"id": "64",
"createdAt": "2020-01-10T11:50:29.183Z"
}
*/