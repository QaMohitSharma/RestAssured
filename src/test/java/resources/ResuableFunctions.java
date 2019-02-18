package resources;

import java.io.FileInputStream;
import java.io.IOException;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ResuableFunctions {
	

		public static JsonPath rawToJson(Response r) {
			String rest1=r.asString();
			//System.out.println(rest1);
			JsonPath x =new JsonPath(rest1);
			return x;
			
		}
		public static XmlPath rawToXml(Response r) {
			String rest1=r.asString();
			//System.out.println(rest1);
			XmlPath x =new XmlPath(rest1);
			return x;
			
		}
		
}
