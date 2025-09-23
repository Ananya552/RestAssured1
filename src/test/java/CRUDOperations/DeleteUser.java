package CRUDOperations;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteUser {
	public static void main(String[] args) {
		
		// SEND THE REQUEST
		Response resp = RestAssured.delete("https://reqres.in/api/users/2");

		// CAPTURE THE RESPONSE
		resp.then().log().all();
	}
}
