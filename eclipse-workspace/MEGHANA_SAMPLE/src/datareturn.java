

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import pojo.deserialize;
import pojo.data;
import pojo.support;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.testng.Assert;

public class datareturn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
RestAssured.baseURI="https://reqres.in/";
String[] name = {"cerulean","fuchsia rose", "true red","aqua sky","tigerlily","blue turquoise"};

deserialize ds= given().expect().defaultParser(Parser.JSON).when().get("https://reqres.in/api/unknown")
.then().assertThat().extract().response().as(deserialize.class);

System.out.println(ds.getPage());
System.out.println(ds.getPer_page());
System.out.println(ds.getTotal());
System.out.println(ds.getTotal_pages());
System.out.println(ds.getSupport().getUrl());
System.out.println(ds.getSupport().getText());
System.out.println(ds.getData().get(2).getColor());
int count = ds.getData().size();

for (int i=0;i<count;i++)
{
String year= ds.getData().get(i).getYear();
if(year.equalsIgnoreCase("2001"))
		
{
	System.out.println(ds.getData().get(i).getName());
}
}

ArrayList<String> a = new ArrayList<String>(); 
for (int j=0;j<count;j++)
{
	 a.add(ds.getData().get(j).getName());
	
}
List<String> expectedname  = Arrays.asList(name);

Assert.assertEquals(a, expectedname);
	
	}
	
}