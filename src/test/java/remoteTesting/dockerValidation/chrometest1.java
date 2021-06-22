package remoteTesting.dockerValidation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class chrometest1 {
	
	@BeforeTest
	public void startDockerScale() throws IOException, InterruptedException {
		File fi = new File("output.txt");
		Thread.sleep(2000);
		if(fi.delete()) {
			System.out.println("Output file is deleted sucessfully");
		}
		startDocker st = new startDocker();
		st.startFile();
	}
	
	@AfterTest
	public void stopDockerDeleteFile() throws IOException, InterruptedException {
		stopDocker sd = new stopDocker();
		sd.stopFile();
	}
	
	@Test
	public void test1() throws MalformedURLException {

			URL url = new URL("http://localhost:4444/wd/hub");
			DesiredCapabilities dc=DesiredCapabilities.firefox();
			RemoteWebDriver driver = new RemoteWebDriver(url, dc);
			driver.get("http://www.google.com/");
			System.out.println("chrometest1");
			System.out.println(driver.getTitle());
			

		}

}
