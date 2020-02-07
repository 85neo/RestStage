import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class deleteMethod {

	@Test(priority =1)
	public void deleteTest() {
		
		given()
			.baseUri("https://reqres.in/api/users/2")
		.when()
			.delete()
		.then()
			.assertThat()
			.statusCode(204);
		
		
	}
}
