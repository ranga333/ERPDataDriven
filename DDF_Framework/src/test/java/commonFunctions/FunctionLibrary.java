package commonFunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Reporter;

import config.AppUtil;

public class FunctionLibrary extends AppUtil {
	public static boolean adminLogin(String username,String password)
	{
		driver.get(conpro.getProperty("Url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath(conpro.getProperty("ObjReset"))).click();
		driver.findElement(By.xpath(conpro.getProperty("ObjUser"))).sendKeys(username);
		driver.findElement(By.xpath(conpro.getProperty("ObjPass"))).sendKeys(password);
		driver.findElement(By.xpath(conpro.getProperty("ObjLogin"))).click();
		String Expected="dashboard";
		String Actual=	driver.getCurrentUrl();
		if(Actual.contains(Expected))
		{
			Reporter.log("username and password are valid:::"+Expected+"  "+Actual,true);
			driver.findElement(By.xpath(conpro.getProperty("ObjLogoutLink"))).click();
			return true;
		}
		else
		{
			String Error_msg=driver.findElement(By.xpath(conpro.getProperty("ObjError_Message"))).getText();
			driver.findElement(By.xpath(conpro.getProperty("ObjOkButton"))).click();
			Reporter.log("username and password are inavalid:::"+Expected+"  "+Actual,true);

		}
		return false;
	}

}
