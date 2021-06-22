package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class firefoxStandaloneTest2 {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		URL url = new URL("http://localhost:8100/wd/hub");
		DesiredCapabilities dc=DesiredCapabilities.firefox();
		RemoteWebDriver driver = new RemoteWebDriver(url, dc);
		driver.get("http://www.google.com/");
		System.out.println(driver.getTitle());
		

	}

}
