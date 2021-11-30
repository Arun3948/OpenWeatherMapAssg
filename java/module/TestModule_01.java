package module;

import java.util.HashMap;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import apiCore.APIBase;
import apiCore.BasicVerification;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import pojoClasses.Example;
import utility.TestLogs;

public class TestModule_01 {
	APIBase objAPIBase;
	BasicVerification objBaseVerf;
	Response response;
	public static final Logger logger = Logger.getLogger(TestLogs.class.getName());
	
	/**
	 * Default constructor
	 */
	public TestModule_01() {
		// Initializing required class Objects
		objAPIBase = new APIBase();
		objBaseVerf = new BasicVerification();
		objAPIBase.setBASEURL("URL");
	}

	/**
	 * Test_01 : Calling GET method for Bhopal city and perforing below verification from GET API call response
	 * 1. Status Code
	 * 2. City
	 * 3. One of the Node from response body, for example here the Wind-->Speed 
	 */
	@Test
	public void Test_01() {

		logger.info("Preparing query parameter in HashMap");
		HashMap<String, String> queryParam = new HashMap();
		String cityName = "Bhopal";
		queryParam.put("q", cityName);
		queryParam.put("appid", "54bec0a6bb32ca02b0816f9e1a75fbd6");

		logger.info("Calling GET method for the OpenWeatherMap API");
		response = objAPIBase.callGetMethod(queryParam);

		logger.info("Verifying Response Status Code");
		objBaseVerf.verify_RESPONSE_STATUS_CODE_200(response);
		
		logger.info("Verifying City name in Response");
		String actCityName = objBaseVerf.getNodeValue(response, "name");
		Assert.assertEquals(cityName, actCityName, "City received in the Response is wrong.");

		logger.info("Checking Wind-->Speed value is present in Response body.");
		Example mainObject = response.getBody().as(Example.class);
		logger.info("Wind-->Speed : " + mainObject.wind.speed);
		Assert.assertTrue(Objects.nonNull(mainObject.wind.speed), "Speed value is not present in Response.");
	}
}
