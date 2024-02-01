package driverFactory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.FunctionLibrary;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class AppTest  extends AppUtil{
	String inputpath="./FileInput/LoginData.xlsx";
	String outputpath="./FileOutput/DataDrivenResults.xlsx";
	@Test
	public void startTest() throws Throwable
	{
		ExcelFileUtil xl= new ExcelFileUtil(inputpath) ;
		int rc=xl.rowCount("Login");
		Reporter.log("no of rows are:::"+rc,true);
		for(int i=1;i<=rc;i++)
		{
			String user=xl.getCellData("Login", i, 0);
			String pass=xl.getCellData("Login", i, 1);
			boolean res=FunctionLibrary.adminLogin(user, pass);
			if(res)
			{
				xl.setCelldata("Login", i, 2,"Login sucess",outputpath);
				xl.setCelldata("Login", i, 3,"pass",outputpath);
			}
			else
			{
				xl.setCelldata("Login",i,2,"Login fail",outputpath);
				xl.setCelldata("Login",i,3,"fail",outputpath);
				
			}
		}
		
	}

}
