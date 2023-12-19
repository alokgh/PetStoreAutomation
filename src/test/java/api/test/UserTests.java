package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userpayload;
	
	@BeforeClass
	public void setUpdata() {
		faker = new Faker();
		userpayload = new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test(priority = 1)
	public void testPostUser() {
		Response response = UserEndPoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),200);
	}
	
	@Test(priority = 2)
	public void testGetUserbyName() {
		Response response = UserEndPoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),200);
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints.updateUser(this.userpayload.getUsername(),userpayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),200);
		
		// check updated data
		Response responseAfterUpdate = UserEndPoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(responseAfterUpdate.statusCode(),200);
	}
	
	
	@Test(priority = 4)
	public void testDeleteUserbyName() {
		Response response = UserEndPoints.deleteUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),200);
	}
	
	
}
