package CRUDOperations;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetUser {
public static void main(String[] args) {
	//SEND THE REQUEST
	RequestSpecification request = RestAssured.given();
	request.header("x-api-key","reqres-free-v1");
//	Response resp = RestAssured.get("https://reqres.in/api/users/2");
	Response resp = request.get("https://reqres.in/api/users/2");
	
	//CAPTURE THE RESPONSE
	resp.then().log().all();
	ResponseBody body = resp.getBody();
}
}
