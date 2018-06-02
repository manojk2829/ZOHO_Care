package log4jFile;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class LoginTest extends Log4j_Base_Class{
	private static final Logger log=Logger.getLogger(LoginTest.class.getName());
	@Test
	public void login(){
		log.info("Starting loginTest---");
		log.info("User Name loginTest---");
		log.info("Password on Sign IN---");
		log.info("Clicking on submit IN---");
	}

}
