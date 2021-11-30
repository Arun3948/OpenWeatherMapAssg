package apiCore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIBase {

	// Defining few parameter.
	public static String BASE_URL; 
	public static Properties properties;
	private final String propertyFilePath= "config//Configuration.properties";
	BufferedReader reader;
	
	/**
	 *    Defining Property file for reading in Default constructor.
	*/
	public APIBase() {
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} 
	}
	
	/**
	 *    Setting URL in setBASEURL method.
	*/
	public void setBASEURL(String propertyKey) {
		BASE_URL = properties.getProperty(propertyKey);
	}

	/**
	 *    Defining GET Method with Query Parameter
	*/
	public Response callGetMethod(HashMap<String, String> queryParam) {
		// Getting Request
		RestAssured.baseURI = BASE_URL;
		RequestSpecification httpRequest = RestAssured.given();

		// Specifying  Query Parameter
		for (Map.Entry<String, String> entry : queryParam.entrySet()) {
			httpRequest.queryParam(entry.getKey(), entry.getValue());
		}

		// Calling GET method
		Response response = httpRequest.get("/weather");
		return response;
	}
}
