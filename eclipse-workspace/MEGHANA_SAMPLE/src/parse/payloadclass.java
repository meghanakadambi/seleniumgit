package parse;

public class payloadclass {

	//REMEMBER DO NOT ADD PUBLIC STATIC VOID MAIN HERE
	//Rememeber why we use static keyword because this course price will be reflected in other class 
	//when you use it otherwise it cannot recognize and it will throw error 
	
		// TODO Auto-generated method stub
	//fsdfsd
		
		public static String CoursePrice()
		{
			return"{\r\n"
					+ "\r\n"
					+ "\"dashboard\": {\r\n"
					+ "\r\n"
					+ "\"purchaseAmount\": 910,\r\n"
					+ "\r\n"
					+ "\"website\": \"rahulshettyacademy.com\"\r\n"
					+ "\r\n"
					+ "},\r\n"
					+ "\r\n"
					+ "\"courses\": [\r\n"
					+ "\r\n"
					+ "{\r\n"
					+ "\r\n"
					+ "\"title\": \"Selenium Python\",\r\n"
					+ "\r\n"
					+ "\"price\": 50,\r\n"
					+ "\r\n"
					+ "\"copies\": 6\r\n"
					+ "\r\n"
					+ "},\r\n"
					+ "\r\n"
					+ "{\r\n"
					+ "\r\n"
					+ "\"title\": \"Cypress\",\r\n"
					+ "\r\n"
					+ "\"price\": 40,\r\n"
					+ "\r\n"
					+ "\"copies\": 4\r\n"
					+ "\r\n"
					+ "},\r\n"
					+ "\r\n"
					+ "{\r\n"
					+ "\r\n"
					+ "\"title\": \"RPA\",\r\n"
					+ "\r\n"
					+ "\"price\": 45,\r\n"
					+ "\r\n"
					+ "\"copies\": 10\r\n"
					+ "\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "]\r\n"
					+ "\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "";
		}
		public static String DynamicTestNG(String isbn, String aisle)
		{
			String Dynamic = "{\r\n"
			+ "\r\n"
			+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
			+ "\"isbn\":\""+isbn+"\",\r\n"
			+ "\"aisle\":\""+aisle+"\",\r\n"
			+ "\"author\":\"John foe\"\r\n"
			+ "}";
			return Dynamic;
		}
		
		
		

	}


