import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import pojo.data;
import pojo.deserialize;
import pojo.support;

public class SerializerReturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		deserialize ds = new deserialize();
		ds.setPage(12);
		ds.setPer_page(2);
		ds.setTotal(20);
		ds.setTotal_pages(30);
		support st= new support();
		st.setText("master is my beloved");
		st.setUrl("abc@gmail.com");
		ds.setSupport(st);
		List<data> ls = new ArrayList<data>();
		
		data dt= new data();
		dt.setColor("#98B2D1");
		dt.setId("1");
		dt.setName("cerulean");
		dt.setPantone_value("15-4020");
		dt.setYear("2000");
		data dt2= new data();
		dt2.setColor("#98B2w2");
		dt2.setId("2");
		dt2.setName("adbddcsvd");
		dt2.setPantone_value("122-4020");
		dt2.setYear("2001");
		ls.add(dt);
		ls.add(dt2);
		ds.setData(ls);
		
	
		
			// TODO Auto-generated method stub
	RestAssured.baseURI="https://reqres.in";
	

	String ser= given().queryParam("page", "2").body(ds).when().get("https://reqres.in/api/users?page=2")
	.then().assertThat().statusCode(200).extract().response().asString();
	
	System.out.println(ser);

	}

}
