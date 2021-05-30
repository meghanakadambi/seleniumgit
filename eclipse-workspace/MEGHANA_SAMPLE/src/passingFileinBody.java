//import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;

import org.testng.Assert;



import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class passingFileinBody {

	public static void main(String[] args) throws IOException {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		//given should contain queryparameter,header,body
		//when should contain post url
		//then should contain status code 
		String response=given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\18677\\Documents\\Postman\\qaclick.json"))))		
				.when().post("/maps/api/place/add/json").
		  then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
/*
		//update the person address
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String placeid =js.getString("place_id");
		System.out.println(placeid);
		String expectedaddress = "70 Summer walk, ";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body("{\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"address\":\""+expectedaddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().log().all().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));

		//Get method
/*
		String getresponse =given().queryParam("key", "qaclick123").queryParam("place_id",placeid).when().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();

		JsonPath js1= new JsonPath(getresponse);
		String actualgetaddress =js1.getString("address");
		System.out.println(actualgetaddress);
		Assert.assertEquals(actualgetaddress, expectedaddress);
		*/
			}
			
		}

		// TODO Auto-generated method stub

