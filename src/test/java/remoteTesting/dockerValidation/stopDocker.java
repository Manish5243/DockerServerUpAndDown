package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.junit.Assert;
import org.testng.annotations.Test;

public class stopDocker {

	public void stopFile() throws IOException, InterruptedException {
		
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start docker-down.bat");
		
		boolean flag = false;
		String file = "output.txt";
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 45);
		long stopnow = cal.getTimeInMillis();
		Thread.sleep(3000);
		
		while(System.currentTimeMillis()<stopnow)
		{
			if(flag) 
			{
				break;
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currentLine = reader.readLine();
			
			while(currentLine!= null && !flag) {
			
			if(currentLine.contains("Shutdown complete")) {
				System.out.println("found txt to delete");
				flag = true;
				break;
			}
			currentLine = reader.readLine();
		}
			reader.close();
		}
		
		Assert.assertTrue(flag);
		
	}
	
}
