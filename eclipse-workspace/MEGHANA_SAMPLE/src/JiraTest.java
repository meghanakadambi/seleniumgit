import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class JiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "http://localhost:8080";
		SessionFilter session = new SessionFilter();
String response = given().header("Content-Type","application/json").body("{\"username\": \"meghana.sahaj\", \"password\": \"Carmen@123\" }")
.filter(session).when().post("rest/auth/1/session").then().log().all().extract().response().asString();
JsonPath js = new JsonPath(response);
String value= js.getString("session.value");
System.out.println(value);
SessionFilter session1 = new SessionFilter();
String responseone= given().pathParam("Key", "RES-10").header("Content-Type","application/json").body("{\r\n"
		+ "    \"body\": \"added a commenton april.\",\r\n"
		+ "    \"visibility\": {\r\n"
		+ "        \"type\": \"role\",\r\n"
		+ "        \"value\": \"Administrators\"\r\n"
		+ "    }\r\n"
		+ "}").filter(session).filter(session1).when().post("/rest/api/2/issue/{Key}/comment")
.then().log().all().assertThat().statusCode(201).extract().response().asString();
System.out.println(responseone);
JsonPath js1 = new JsonPath(responseone);
String id =js1.getString("id");
System.out.println(id);

/*
given().pathParam("Key", "RES-9").pathParam("id", id).header("Content-Type","application/json").body("{\r\n"
		+ "    \"body\": \"updated the comment.\",\r\n"
		+ "    \"visibility\": {\r\n"
		+ "        \"type\": \"role\",\r\n"
		+ "        \"value\": \"Administrators\"\r\n"
		+ "    }\r\n"
		+ "}").filter(session).when().post("/rest/api/2/issue/{Key}/comment/{id}")
.then().log().all().assertThat().statusCode(200);

*/
String issuedetails= given().pathParam("Key", "RES-10").queryParam("fields", "comment")
.filter(session).log().all().get("/rest/api/2/issue/{Key}").then().log().all().extract().response().asString();


JsonPath js3= new JsonPath(issuedetails);
int count = js3.getInt("fields.comment.comments.size()");
for (int i=0;i<count;i++)
{
	String actualid = js3.get("fields.comment.comments["+i+"].id");
	if(actualid.equalsIgnoreCase(id)) /* always first put actualid and then equals to expected id .if not then it will give error */
	{
		String expectedbody = js3.get("fields.comment.comments["+i+"].body");
		System.out.println("the expected body is" +expectedbody);
	}
	}
}
}




