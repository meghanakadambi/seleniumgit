//import files.payloadclass;
import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import parse.payloadclass;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js= new JsonPath(payloadclass.CoursePrice());
		
		
				
//Print No of courses returned by API
		// inside getInt give double quotes and give the name of the field correctly 
int count	= js.getInt("courses.size()");
System.out.println(count);

	
	//Print Purchase Amount
	//u can either use get or getInt
int amt =js.get("dashboard.purchaseAmount");
System.out.println(amt);
	
			
			//you can use this directly System.out.println(js.get("dashboard.purchaseAmount"));
			
			// Print Title of the first course
String title = js.getString("courses[0].title");
System.out.println(title);
			
			//String firsttitle = js.get("courses[0].title"); you can use just get 
			
			
			//Print All course titles and their respective Prices
for(int i=0;i<count;i++)
{
	System.out.println(js.get("courses["+i+"].title"));
	System.out.println(js.get("courses["+i+"].price"));
	}


			
    //int courseprice	=js.get("courses["+i+"].price");
   
   
	//System.out.println(courseprice);


//Print no of copies sold by Cypress Course
// dont use semi colon ; in for loop and if condition

for(int i=0;i<count;i++)
{
	String coursetitle = js.get("courses["+i+"].title");
	
		if(coursetitle.equalsIgnoreCase("Cypress"))
		{
		System.out.println(js.get("courses["+i+"].copies"));
			
		}
}


	}	
}		
		
