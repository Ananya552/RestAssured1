package CRUDOperations;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutUser {
	public static void main(String[] args) {

		// CREATE THE REQUEST BODY IF REQUIRED
		JSONObject j = new JSONObject();
		j.put("name", "morpheus");
		j.put("job", "zion resident");

		// SEND THE REQUEST //When there is a body,given() is used
		RequestSpecification request = RestAssured.given();
		request.body(j);
		request.contentType(ContentType.JSON);
		Response resp = request.put("https://reqres.in/api/users/2");

		// CAPTURE THE RESPONSE
		resp.then().log().all();
		
	}
}
