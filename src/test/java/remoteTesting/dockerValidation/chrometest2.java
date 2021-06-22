package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class chrometest2 {
	
	
	@Test
	public void test1() throws MalformedURLException {

			URL url = new URL("http://localhost:4444/wd/hub");
			DesiredCapabilities dc=DesiredCapabilities.firefox();
			RemoteWebDriver driver = new RemoteWebDriver(url, dc);
			driver.get("http://www.fb.com/");
			System.out.println("chrometest2");
			System.out.println(driver.getTitle());
			

		}

}
