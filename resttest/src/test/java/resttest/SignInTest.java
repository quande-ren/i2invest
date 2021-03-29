package resttest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.i2invest.domain.DtoJsonWrapper;
import com.i2invest.domain.request.BaseRequest;
import com.i2invest.domain.request.UserSignInRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SignInTest {
	@Test
	public void testSinInFail(){
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		UserSignInRequest pingRequest=new UserSignInRequest("123","abc");

		given()
			.contentType(ContentType.JSON)
			.body(getPayload(pingRequest))
			.log().all()
		.when()
			.post("http://localhost:8080/i2invest/api/postJson3")
		.then()
			.log().all()
			.statusCode(200)
			.body("success", equalTo(false))
			.body("errorCode", equalTo("103"))
			.body("errorMessage", equalTo("Invalid Credential"))
		;
	}

	@Test
	public void testSinInSuccess(){
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		UserSignInRequest pingRequest=new UserSignInRequest("quande.ren@gmail.com","Yanmei123");

		given()
			.contentType(ContentType.JSON)
			.body(getPayload(pingRequest))
			.log().all()
		.when()
			.post("http://localhost:8080/i2invest/api/postJson3")
		.then()
			.log().all()
			.statusCode(200)
			.body("success", equalTo(true))
			.body("user.firstName", equalTo("Quande"))
		;
	}

	public static String getPayload(BaseRequest pingRequest) {
		DtoJsonWrapper wrapper = pingRequest.toWrapper();
		
		String payload=wrapper.toJson();
		
		System.out.println("Payload="+payload);
		return payload;
	}

}
