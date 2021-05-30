import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
// always remember to use this import method 
 
import parse.payloadclass;

public class DynamiCTestNG {
	@Test(dataProvider = "bookdate")
	//if you give public void u dont have to pass parameters , if you give public String then you have to pass parameters
	//when you give public string you have to give return string name at the end else it will give error.
	//and when you dont want to return just give public void 
	public void dynamic(String isbn, String aisle)
	{
		 RestAssured.baseURI= "http://216.10.245.166";
		 String Response = given().header("Content-Type","application/json")
				 .body(payloadclass.DynamicTestNG(isbn, aisle))
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		 
		 JsonPath js= new JsonPath(Response);
		String id =js.getString("ID");
		System.out.println(id);
		
	}

	@DataProvider(name="bookdate")
	public Object[][] bookdata()
	{
		
		 return new Object[][] {{"asd","2233rf"},{"wer","556yh"},{"poi","33rf44"}};
	}

	
}


