package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {

	User userpayload;
	
	@Test(priority = 1,dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String userID,String userName,String fname,String lname,String email,String password,String phone) {
		
		userpayload = new User();		
		userpayload.setId(Integer.parseInt(userID));
		userpayload.setUsername(userName);
		userpayload.setFirstName(fname);
		userpayload.setLastName(lname);
		userpayload.setEmail(email);
		userpayload.setPassword(password);
		userpayload.setPhone(phone);
		Response response = UserEndPoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),200);
	}
	
	
	
	
}
