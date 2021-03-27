package resttest;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.RestAssured;

public class PingTest {
	@Test
	public void testSingleRecord(){
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

		
		given()
			.log().all()
		.when()
			.get("http://localhost:8080/i2invest/api/ping")
		.then()
			.log().all()
			.statusCode(200)
		;
	}
}
