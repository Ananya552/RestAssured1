package CRUDOperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class CreateUser {
@Test
//	public static void main(String[] args) {
public void postMethodTest() {	
		// CREATE THE REQUEST BODY IF REQUIRED
		JSONObject j = new JSONObject();
		j.put("name", "morpheus");
		j.put("job", "leader");
		
		// SEND THE REQUEST //When there is a body,given() is used
		RequestSpecification request = RestAssured.given();
		request.body(j);
		request.header("x-api-key","reqres-free-v1");
		request.contentType(ContentType.JSON);
		Response resp = request.post("https://reqres.in/api/users");
		
		//LOG THE RESPONSE
		resp.then().log().all();
		
		ResponseBody body = resp.getBody();
		JsonPath jp=body.jsonPath();
		String name = jp.getString("name");
		Assert.assertEquals("morpheus",name);
		int statusCode=resp.getStatusCode();
		Assert.assertEquals(201,statusCode);
		String responseHeader= resp.getHeader("Content-Length");
		System.out.println(responseHeader);
		Assert.assertEquals("84",responseHeader);
		long respTime = resp.getTime();
		System.out.println(respTime);
		Assert.assertTrue(respTime<2000);
		
	}

}
