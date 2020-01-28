import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class postScenario {
	
	@Test(priority=1)
	public void postSuccess1() {
		
		String jsonData ="{\"email\": \"eve.holt@reqres.in\",\"password\": \"pistol\"}";
		
		given()
			.baseUri("https://reqres.in/api/register")
			.contentType(ContentType.JSON)
			.body(jsonData)
		.when()
			.post()
		.then()
			.assertThat()
			.statusCode(200)
			.body("id", equalTo(4));
		
	}
		
		@Test(priority=2)
		public void postFailure() {
			
			String jsonData1 ="{\"email\": \"sydney@fife\"}";
			
			given()
				.baseUri("https://reqres.in/api/register")
				.contentType(ContentType.JSON)
				.body(jsonData1)
			.when()
				.post()
			.then()
				.assertThat()
				.statusCode(400)
				.body("error", equalTo("Missing password"));	
		
	}
		
		@Test(priority=3)
		public void postLoginPass() {
			
			String jsonData2 ="{\"email\": \"eve.holt@reqres.in\",\"password\": \"cityslicka\"}";
			
			given()
				.baseUri("https://reqres.in/api/login")
				.contentType(ContentType.JSON)
				.body(jsonData2)
			.when()
				.post()
			.then()
				.assertThat()
				.statusCode(200)
				.body("token", equalTo("QpwL5tke4Pnpja7X4"));	
		
	}
		
		@Test(priority=4)
		public void postLoginFail() {
			
			String jsonData3 ="{\"email\": \"peter@klaven\"}";
			
			given()
				.baseUri("https://reqres.in/api/login")
				.contentType(ContentType.JSON)
				.body(jsonData3)
			.when()
				.post()
			.then()
				.assertThat()
				.statusCode(400)
				.body("error", equalTo("Missing password"));	
		
	}

}























