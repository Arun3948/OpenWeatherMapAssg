package apiCore;

import org.testng.Assert;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BasicVerification {

	private int RESPONSE_STATUS_CODE_200 = 200;

	/**
	 * Verification method for RESPONSE_STATUS_CODE
	 */
	public void verify_RESPONSE_STATUS_CODE_200(Response response) {
		Assert.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200, "Status code is not 200");
	}
	
	/**
	 * Method to get single Node value from response.
	 * input Parameter : API response, node name
	 */
	public String getNodeValue(Response response, String nodeName) {
		JsonPath jsonPathEvaluator = response.jsonPath();
		return jsonPathEvaluator.get(nodeName);
	}
}
