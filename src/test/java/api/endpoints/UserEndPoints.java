package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// Created to perform CRUD operations on User API
public class UserEndPoints {

	public static Response createUser(User payload){
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
		return response;
	}
	
	
	public static Response readUser(String username){	
		Response response = given()
			.pathParam("username", username)			
		.when()
			.get(Routes.get_url);
		return response;
	}
	
	
	public static Response updateUser(String username,User payload){	
		Response response = given()
			.pathParam("username", username)	
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.put(Routes.update_url);
		return response;
	}
	
	
	public static Response deleteUser(String username){	
		Response response = given()
			.pathParam("username", username)		
		.when()
			.delete(Routes.delete_url);
		return response;
	}
	
}
