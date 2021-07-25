package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.junit.Assert;
import org.testng.annotations.Test;

public class startDocker {
	public void startFile() throws IOException, InterruptedException {
		
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start docker-up.bat");
		
		boolean flag = false;
		String file = "output.txt";
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 60);
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
			
			if(currentLine.contains("The node is registered to the hub and ready to use")) {
				System.out.println("found txt");
				flag = true;
				break;
			}
			currentLine = reader.readLine();
		}
			reader.close();
		}
		
		Assert.assertTrue(flag);
		runtime.exec("cmd /c start firefoxScale.bat");
		Thread.sleep(15000);
	}
	
}
