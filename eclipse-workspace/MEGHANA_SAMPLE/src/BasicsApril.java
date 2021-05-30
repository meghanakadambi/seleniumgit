import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
//import files.payload;

public class BasicsApril {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
RestAssured.baseURI = "https://rahulshettyacademy.com";
//given should contain queryparameter,header,body
//when should contain post url
//then should contain status code 
String response=given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
.body("{\r\n"
		+ "  \"location\": {\r\n"
		+ "    \"lat\": -38.383494,\r\n"
		+ "    \"lng\": 33.427362\r\n"
		+ "  },\r\n"
		+ "  \"accuracy\": 50,\r\n"
		+ "  \"name\": \"Frontline house\",\r\n"
		+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
		+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
		+ "  \"types\": [\r\n"
		+ "    \"shoe park\",\r\n"
		+ "    \"shop\"\r\n"
		+ "  ],\r\n"
		+ "  \"website\": \"http://google.com\",\r\n"
		+ "  \"language\": \"French-IN\"\r\n"
		+ "}\r\n"
		+ "\r\n"
		+ "").when().post("/maps/api/place/add/json").
  then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

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

String getresponse =given().queryParam("key", "qaclick123").queryParam("place_id",placeid).when().get("/maps/api/place/get/json")
.then().log().all().assertThat().statusCode(200).extract().response().asString();

JsonPath js1= new JsonPath(getresponse);
String actualgetaddress =js1.getString("address");
System.out.println(actualgetaddress);
Assert.assertEquals(actualgetaddress, expectedaddress);
	}
	
}
