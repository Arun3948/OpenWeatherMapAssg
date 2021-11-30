package module;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Module_01 {

	@Test
	public void TC_01() {

		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method
		// URL.
		// This will return the Response from the server. Store the response in a
		// variable.
		//------Response response = httpRequest.request(Method.GET, "/Hyderabad");
		//------Response response = httpRequest.get("/data/2.5/weather?q=Bhopal&appid=54bec0a6bb32ca02b0816f9e1a75fbd6");

		Response response = httpRequest.queryParam("q", "Bhopal") 
                .queryParam("appid", "54bec0a6bb32ca02b0816f9e1a75fbd6") 
                .get("/weather");
		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		int statusCode = response.getStatusCode();
		
		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
		System.out.println("StatusCode =>  " + statusCode);
		
		Headers allHeaders = response.headers();

		// Iterate over all the Headers
		for(Header header : allHeaders)
		{
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}
		
		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
		String name = jsonPathEvaluator.get("name");

		// Let us print the city variable to see what we got
		System.out.println("City received from Response " + name);

		// Validate the response
		Assert.assertEquals(name, "Bhopal", "Correct visibility received in the Response");

		
	}
}
