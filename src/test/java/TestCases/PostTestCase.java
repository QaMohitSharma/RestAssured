package TestCases;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//Commonfunction import
import resources.CommonFunctions;
import resources.Auth;
import resources.ResuableFunctions;
//Static import
import static io.restassured.RestAssured.*;
//File import
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
//TestNG
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PostTestCase {
	Properties prop=new Properties();
	@BeforeTest
	public void getProperties() throws IOException {
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\env.properties");
		prop.load(fis);
		prop.get("HOST");
	}


	@Test
	public void testPostCall() {
		RestAssured.baseURI=prop.getProperty("HOST");
		Response res=given().queryParam("key", Auth.getAuth())
				.when().post(CommonFunctions.placePostData()).then().statusCode(200).log().all().and().extract().response();
		JsonPath js=ResuableFunctions.rawToJson(res);
		System.out.println(js.toString());
		//System.out.println(js.getInt("size()"));
		System.out.println(js.get("invoice_prefix"));
	
	}
	
	
	

}
