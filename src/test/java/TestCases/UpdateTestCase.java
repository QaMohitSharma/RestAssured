package TestCases;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.Auth;
import resources.CommonFunctions;
import resources.ResuableFunctions;

public class UpdateTestCase {
	Properties prop=new Properties();
	@BeforeTest
	public void getProperties() throws IOException {
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\env.properties");
		prop.load(fis);
		prop.get("HOST");
	}

/* this request contains post method to update the data */
	@Test
	public void testPostCall() {
		RestAssured.baseURI=prop.getProperty("HOST");
		Response res=given().queryParam("key", Auth.getAuth()).param("account_balance", 6000)
				.when().post(CommonFunctions.placeUpdateData()).then().statusCode(200).log().all().and().extract().response();
		JsonPath js=ResuableFunctions.rawToJson(res);
		System.out.println(js.get("account_balance"));
	
	}
	

}
