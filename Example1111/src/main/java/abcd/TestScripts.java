package abcd;

import java.util.Scanner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.htmlReport;

public class TestScripts extends Courses {
	public static ExtentReports report = htmlReport.getReport();
	public static ExtentTest logger;
	
   
	@BeforeMethod(groups = { "smoke", "Regression","primary","module","secondary","tertiary"})
	public void OpenBrowser()
	{
		openBrowser("msedge");
	}

	@AfterMethod(groups = { "smoke", "Regression","primary","module","secondary","tertiary"})
	public void closeBrowser(){
		driver.quit();
	}

	@BeforeTest(groups = { "smoke", "Regression","primary","module","secondary","tertiary"})
	public void ExReport() {
		report = htmlReport.getReport();
	}

	@AfterTest(groups = { "smoke", "Regression","primary","module","secondary","tertiary"})
	public void endReport() {
		report.flush();
	}
//=================================================================================================//

	  
		//verifying course details 
		
		  @Test(priority =1, groups= {"smoke"}) public void VerifyCourses()throws
		  Exception{ try { logger = report.createTest("TC01_Verification of courses");
		  navigate(); getTitle(); getSearchBar(); getlanguagefilter(); getEnglish();
		  getLevelfilter(); getbeginner(); getCourses(); } catch(Exception e) {
		  FAIL("Verify Courses"); } }
		 
		
			
		//verify fillform
		@Test(priority = 2, groups= {"Regression"})
		public void Form()throws Exception{
			try {
				  logger = report.createTest("TC02_Verification of fillform");
				  navigate();

				  getTitle();
				  getEnterprise();
				  getproducts();
				  getcampus();
				  getFillForm();
				
			}
			catch(Exception e)
			{
				FAIL("verify fill form");
			}
		}
		   //get all levels
	 @Test(priority =3, groups= {"secondary"})
	   public void alllevel() throws Exception {
		   try {
			     logger = report.createTest("TC03_Verification of all levels");
				 navigate();
				 getTitle(); 
				 getSearch();
				 getSubject();
				 getLanguageLearning1();
				 getlanguagefilter();
				 getallLanguages();
				 getLevelfilter();
				 getalllevels();
		   }
		   catch(Exception e)
		   {
		            FAIL("Verify all levels");	   
		   }
	   }

}

