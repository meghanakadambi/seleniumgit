import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.path.json.JsonPath;
import parse.payloadclass;

public class sum {
	@Test
	public void sumOfcCourses()
	{
	
		
		JsonPath js= new JsonPath(payloadclass.CoursePrice());
		
		int count	= js.getInt("courses.size()");
		System.out.println(count);
		int sum =0;
		for(int i=0;i<count;i++)
		{
		int price	= js.getInt("courses["+i+"].price");
		int copies	= js.getInt("courses["+i+"].copies");
		int amount = price*copies;
		System.out.println(amount);
		sum = sum+amount;
		}
		int amt =js.get("dashboard.purchaseAmount");
		Assert.assertEquals(sum, 900);
		}
	}
	
	


