import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import models.User;

import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.Form;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.WS;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class Scala_functest {
	
	
	@Test
	public void callIndex(){
		Result result = callAction(
				controllers.routes.ref.User.create()
				);
		 assertThat(status(result)).isEqualTo(OK);
		    assertThat(contentType(result)).isEqualTo("text/html");
		    assertThat(charset(result)).isEqualTo("utf-8");
		    assertThat(contentAsString(result)).contains("FullName");
	}

	@Test
	public void routeTest(){
		Result result = routeAndCall (fakeRequest(GET, "/registration"));
		assertThat(result).isNotNull();
	}
	@Test
	public void testInServer(){
		running(testServer(3333), new Runnable(){
			public void run(){
				assertThat(
						WS.url("http://localhost:3333").get().get().getStatus()).isEqualTo(OK);
			
			}
		});
		
	}
	
	@Test
	public void runInBrowser() {
	    running(testServer(9000), HTMLUNIT, new Callback<TestBrowser>() {
	        public void invoke(TestBrowser browser) {
	          
	        
	           browser.goTo("http://localhost:9000/registration");
	           assertThat(browser.$("#title").getTexts().get(0)).isEqualTo("GATI: Signup");
	           browser.fill("#fullname").with("Murali");
	           browser.fill("#company").with("Juhomi");
	           browser.fill("#email").with("ukmurali@gmial.com");
	           browser.fill("#password").with("password");
	           
	           browser.$("#button_create").click();
	           
	           
	           assertThat(browser.url()).isEqualTo("http://localhost:9000/users");
	         //  assertThat(browser.$("#regForm", 0).getText()).isEqualTo("GATI: Signup");
	           assertThat(browser.$("#userlist").getText()).contains("Murali");
	        }
	    });
	}
				
			
					
					
	}
				
	

