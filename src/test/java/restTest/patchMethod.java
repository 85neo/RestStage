import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class patchMethod {

	@Test
	public void patchScenario() {
		
		String jsonData=" {\"name\": \"morpheus\",\"job\": \"zion resident\"}";
		
		given()
			.baseUri("https://reqres.in/api/users/2")
			.contentType(ContentType.JSON)
			.body(jsonData)
		.when()
			.patch()
		.then()
		    .assertThat()
		    .statusCode(200)
		    .body("name", Matchers.equalTo("morpheus"))
		    .body("job",  Matchers.equalTo("zion resident"));
		
		
	}
}
