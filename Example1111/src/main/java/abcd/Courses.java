package abcd;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import com.aventstack.extentreports.Status;

import org.openqa.selenium.interactions.Actions;



public class Courses extends ResuableMethods {
	static int k=0;
	
	Properties prop=new Properties();
	{
		try {
			prop.load(new FileInputStream(
					"E:\\github Hackathon\\Hackathon\\Example1111\\config.properties"));
			} catch (Exception e) {
			e.printStackTrace();
			}
	}
	String parentWindow;
	List<WebElement> languages;
	List<WebElement> langs;
	
	
    //navigate to Coursera url
	public void navigate() throws Exception {
		try {
			String baseurl = prop.getProperty("url");
			driver.get(baseurl);
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
			PASSNoImg("Navigated to URL");
			ResuableMethods.SScapture(driver, "URL PAGE");
       
		} catch (Exception e) {
			FAIL("Unable to navigate");
		}
	}
	
	//verify page title
		public void getTitle() throws Exception {
			try {
				String Title = GetTitle();
				Assert.assertEquals(Title, courseraLocators.ActualTitleofHomePage);
				PASSNoImg("getTitle");
				ResuableMethods.SScapture(driver, "TITLE");
			} catch (Exception e) {
				FAIL("Unable to get Title");

			}
		}
		
	//seearch for search bar
		public void getSearchBar()throws Exception {
			try {
				WebElement search1 =driver.findElement(courseraLocators.search);
				search1.sendKeys(readdata.readingExcel()+Keys.ENTER);
				//writedata.writeExcel(parentWindow);
				Thread.sleep(3000);
				ResuableMethods.SScapture(driver, "SEARCH FOR COURSE");
			}
			catch (Exception e) {
				FAIL("Unable to get searchbar");
			}
		}
		public void getSearch()throws Exception{
			try {
				//Click(courseraLocators.search,"search");
				WebElement search1 =driver.findElement(courseraLocators.search);
				search1.sendKeys(Keys.ENTER); 
				Thread.sleep(3000);
				ResuableMethods.SScapture(driver, "SEARCH");
			}
			catch (Exception e) {
				FAIL("Unable to get searchbar");
			}
		}
     
		//selecting language
		public void getlanguagefilter()throws Exception {
			try {
				Click(courseraLocators.lan, "Languages");
				//Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
				PASSNoImg("Clicked on language");
				ResuableMethods.SScapture(driver, "Language option");
			}
				
			catch (Exception e) {
				FAIL("Unable to get language");
		}
     }
		//selecting English
		public void getEnglish()throws Exception {
		    try {
				 Click(courseraLocators.English, "English");
				 Thread.sleep(3000);
				 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
					PASSNoImg("Clicked on english");
					//ResuableMethods.SScapture(driver, "Opening the url page");
				}
					
				catch (Exception e) {
					FAIL("Unable to click on English");
			}
		}
		//selecting level
		public void getLevelfilter()throws Exception {
		  try {
				Click(courseraLocators.level, "Level");
				Thread.sleep(3000);
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
				PASSNoImg("Clicked on level");
				ResuableMethods.SScapture(driver, "Choosing level");
			  }
			  catch (Exception e) {
			  FAIL("Unable to get level");
			}
		}
		//selecting beginner level
		public void getbeginner() throws Exception{
		  try {
			  Click(courseraLocators.beginner,"Beginner");
			  Thread.sleep(3000);
			  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
			  PASSNoImg("Clicked on Beginner");
		  }
		  catch(Exception e)
		  {FAIL("Unable to select beginner"); }
		  }
		public void getCourses() throws Exception {
			List<String>l1=new ArrayList<String>();
			List<String>l2=new ArrayList<String>();
			
			ArrayList<String>cou=new ArrayList<String>();

			try {
			String parent=driver.getWindowHandle();//getting windpw handle
			WebElement contentDiv=driver.findElement(courseraLocators.contentDiv);//xpath for div
			WebElement contentUl=contentDiv.findElement(courseraLocators.contentUl);//xpath for unorderedlist
			List<WebElement>li = contentUl.findElements(By.tagName("li"));//xpath for listed items
			for(int i=0;i<2;i++)
			{
			WebElement select=li.get(i);//selecting 'i'th displayed course
			select.click();
			Set<String>win =driver.getWindowHandles();//getting all windowhandles
			for(String child:win)
			{
			if(!child.equals(parent))
			{
			driver.switchTo().window(child);
			WebElement name=driver.findElement(courseraLocators.Coursename);//xpath for course name
			WebElement rating= driver.findElement(courseraLocators.courserating);//xpath for course rating
			PASSNoImg("collected all details of courses");
			System.out.println("Course no is " + (i));
			//writedata.writeExcel((String)i);
			System.out.println(" Course name is: " +name.getText());
			l1.add(name.getText());
			//writedata.writeExcel(name.getText());
			System.out.println(" Rating is "+rating.getText());
			l2.add(rating.getText());
			//writedata.writeExcel(rating.getText());
			TestScripts.logger.log(Status.INFO, name.getText());
			TestScripts.logger.log(Status.INFO, rating.getText());
			//writedata.writeExcel(name.getText(), q);
			//writedata.writeExcel(rating.getText(), q++);
			
			
			
			WebElement product1=driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div[2]/div/div"));
			List<WebElement> dhan=product1.findElements(By.tagName("span"));
						for(WebElement p:dhan)
			{
				if(p.getText().contains("complete")){
				System.out.println(p.getText());
				//writedata.writeExcel(p.getText());
				cou.add(p.getText());
		
				}
			}
			//System.out.println(cou);
			
				Thread.sleep(3000);
			driver.close();
			}
			driver.switchTo().window(parent);
			}




			}
			}
			catch(Exception e)
			{FAIL("Unable to select beginner"); }
			writedata.writeExcel("The first two courses and rating are:");
			for(int m=0;m<l1.size();m++) { 
				writedata.writeExcel("course:"+m+" "+l1.get(m)+" "+l2.get(m));
				//writedata.writeExcel(l2.get(m));
				writedata.writeExcel("timing to complete the course for course :"+m+cou.get(m));
			}
			
			System.out.println(l2);
			System.out.println(cou);
			}

   //click on enterprises
		public void getEnterprise() throws Exception {
			try {
				Click(courseraLocators.Enterprise,"for Enterprise");
				//Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
				PASSNoImg("Clicked on for Enterprise");
				ResuableMethods.SScapture(driver, "Enterprise");
			}
			catch(Exception e)
			{
				FAIL("Unable to click on Enterprise");
			}
		}
	//click on	products
		public void getproducts() throws Exception {
			try {
				//Click(courseraLocators.Products,"Products");
				parentWindow=	driver.getWindowHandle();	
				Actions as=new Actions(driver);
				WebElement products=driver.findElement(courseraLocators.Products);
				as.moveToElement(products).build().perform();
				//Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
				PASSNoImg("Clicked on Products");
				ResuableMethods.SScapture(driver, "Products");
			}
			catch(Exception e)
			{
				FAIL("Unable to click on products");
			}
		}
    //click on for campus
		public void getcampus() throws Exception {
			try {
				Click(courseraLocators.forcampus,"Products");
				PASSNoImg("Clicked on Products");
				parentWindow=driver.getWindowHandle();
				Thread.sleep(3000);
				Set<String>win =driver.getWindowHandles();//getting all window handles
	    		for(String child:win)
	    		{
	    		if(!child.equals(parentWindow))
	    		{
	    		driver.switchTo().window(child);
	    		//Thread.sleep(4000);
	    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

			}
	    		}
			}
			catch(Exception e)
			{
				FAIL("Unable to click on campus");
			}
		}
	//navigating new window
	    public void getFillForm() throws Exception {
	    	String d = null;
	    	try {
	    	    JavascriptExecutor js1=(JavascriptExecutor)driver;
	    		js1.executeScript("window.scrollBy(0,350)");//for scrolling down
	    		WebElement getstarted = driver.findElement(courseraLocators.getstarted);
	    		js1.executeScript("arguments[0].click();", getstarted);//get started 
	    		
	    		driver.findElement(courseraLocators.firstname).sendKeys(readdata.readingExcel());//first name
	    		PASSNoImg(" sentkeys to firstname");
	    		driver.findElement(courseraLocators.lastname).sendKeys(readdata.readingExcel());//last name
	    		PASSNoImg("sentkeys to lastname");
	    		WebElement jobfunction = driver.findElement(courseraLocators.jobfunction);
	    		ISelect jobfun=new Select(jobfunction);
	    		jobfun.selectByValue(readdata.readingExcel());//job function
	    		PASSNoImg("selected other option");
	    		
	    		driver.findElement(courseraLocators.jobTitle).sendKeys(readdata.readingExcel());//job title
	    		PASSNoImg("sentkeys to jobtitle");
	    		driver.findElement(courseraLocators.workEmail).sendKeys(readdata.readingExcel());//work email
	    		PASSNoImg("sentkeys to workmail");
	    		driver.findElement(courseraLocators.phonenumber).sendKeys("9999999999");//phone number
	    		PASSNoImg("sentkeys toohone number");
	    		driver.findElement(courseraLocators.institute).sendKeys(readdata.readingExcel());//institution name
	    		PASSNoImg("sent keys to company or institute");
	    		
	    		WebElement institutiontype = driver.findElement(courseraLocators.institutiontype);
	    		ISelect instype=new Select(institutiontype);
	    	    instype.selectByValue(readdata.readingExcel());//institution type
	    	    PASSNoImg("selected private University");
	    	    WebElement PrimaryDiscipline = driver.findElement(courseraLocators.PrimaryDiscipline);
	    		ISelect pridis=new Select(PrimaryDiscipline);
	    	    pridis.selectByValue(readdata.readingExcel());//Primary Discipline
	    	    PASSNoImg("selected other in primary discipline");
	    	    WebElement country = driver.findElement(courseraLocators.country);
	    		ISelect coun=new Select(country);
	    	    coun.selectByValue(readdata.readingExcel());//country
	    	    PASSNoImg("selected india ");
	    	    WebElement state = driver.findElement(courseraLocators.state);
	    		ISelect sta=new Select(state);
	    	    sta.selectByValue(readdata.readingExcel());//state
	    	    PASSNoImg("selected Andhra Pradesh");
	    	    WebElement submit = driver.findElement(courseraLocators.submit);
	    		js1.executeScript("arguments[0].click();", submit);//submit
	    		PASSNoImg("Clicked on Submit");
	    		js1.executeScript("window.scrollBy(0,-80)");
	    		PASS("invalid input screenshot");SScapture(driver,"Invalid Input");
	    		Actions tk=new Actions(driver);
	    		WebElement invalid=driver.findElement(courseraLocators.invalid);
	    		
	    		tk.moveToElement(invalid).click().perform();
	    		String actual_error=invalid.getAttribute("innerHTML");
	    		Assert.assertTrue(actual_error.contains("Invalid Input"));//error msg
	    		System.out.println(actual_error);
	    		d=actual_error;
	    		//writedata.writeExcel(actual_error);
	    			

	    	}catch(Exception e)
			{
				FAIL("Unable to fill form");
			}
	    	writedata.writeExcel(d);
	    }
	    
//	    //clicking on exploer
//	    public void getExplore() throws Exception {
//	    	try {
//	    	       WebElement w=driver.findElement(courseraLocators.explore);
//	    		   w.click();
//	    		   Thread.sleep(3000);
//	    		   PASSNoImg("Clicked on explore");
//	    	}catch(Exception e) {
//	    		FAIL("Unable to click on explore");}
//	    	}
//	    
//	    //selecting language learning
//	    public void getLanguageLearning() throws Exception {
//	    	try {
//	    		   WebElement w1=driver.findElement(courseraLocators.languageLearning);
//				   w1.click();
//				   Thread.sleep(2000);
//				   PASSNoImg("Clicked on language learning ");
//	    	    }
//	    	catch(Exception e){
//	    		FAIL("Unable to click on language learning");
//	    	}
//	    }
//	    
//	    //clicking on viewallcertificates
//	    public void getViewallCertificates() throws Exception {
//	    	try {
//	    		WebElement w2=driver.findElement(courseraLocators.certificates);
//				w2.click();
//                Thread.sleep(3000);
//                PASSNoImg("Clicked on view all certificates ");
//	    	}
//	    	catch(Exception e) {
//	    		FAIL("Unable to click on ViewallCertificates");
//	    	}
//	    }
//	    //clearing filters
//	    public void clear() throws Exception {
//	    	try {
//	    		WebElement w3=driver.findElement(By.className("ais-ClearRefinements-button"));
//				w3.click();
//				PASSNoImg("Clicked on clear filters");
//	    	}
//	    	catch(Exception e) {
//	    		FAIL("unable to clear filters");
//	    	}
//	    }
	    //click on subject
	    public void getSubject() throws Exception {
	    	try {
	    		WebElement search1 =driver.findElement(courseraLocators.search);
				search1.sendKeys(" "+Keys.ENTER); 
	    		WebElement S=driver.findElement(courseraLocators.subject);
				S.click();
				//Thread.sleep(2000);
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
				PASSNoImg("Clicked on subject");
	    	}
	    	catch(Exception e) {
	    		FAIL("unable to click on Subject");
	    	}
	    }
	    //clicking on language learniing
	    public void getLanguageLearning1() throws Exception {
	    	try {
	    		WebElement L=driver.findElement(courseraLocators.Languagelearning2);
				L.click();
				//Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
				PASSNoImg("Clicked on language learning");
	    	}
	    	catch(Exception e) {
	    		FAIL("Unable to click on language learning");
	    	}
	    }
	    
//getting all languages
public void getallLanguages() throws Exception {
	//String s1,s2,s3;
	List<String>s1=new ArrayList<String>();
	List<String>s2=new ArrayList<String>();
	
try {
driver.findElement(courseraLocators.showall).click();
ResuableMethods.SScapture(driver, "list of languages");
List <WebElement> languageLeft = driver.findElements(By.xpath("//div[@class=\"left-section\"]//label//span[2]//div[1]"));//leftdise name
List <WebElement> languageRight = driver.findElements(By.xpath("//div[@class=\"right-section\"]//label//span[2]//div[1]"));//rightsidde names
List<WebElement> leftCount = driver.findElements(By.xpath("//div[@class=\"left-section\"]//div[@class=\"filter-count\"]"));//count 1
List<WebElement> rightCount = driver.findElements(By.xpath("//div[@class=\"right-section\"]//div[@class=\"filter-count\"]"));//count 2
//System.out.println("Total languages counts is "+(langs1.size()+langs.size()));
//int sum=0;

for(int i=0;i<languageLeft.size();i++) {
System.out.println(languageLeft.get(i).getText() +" : " +leftCount.get(i).getText());
//s1=languageLeft.get(i).getText()+leftCount.get(i).getText();
//writedata.writeExcel(s1);
s1.add(languageLeft.get(i).getText()+leftCount.get(i).getText());

TestScripts.logger.log(Status.INFO, languageLeft.get(i).getText() +" : " +leftCount.get(i).getText());//in report
//writedata.writeExcel(s1);
}
for(int j=0;j<languageRight.size();j++) {
System.out.println(languageRight.get(j).getText() +" : " +rightCount.get(j).getText());
s2.add(languageRight.get(j).getText() +" : " +rightCount.get(j).getText());
//writedata.writeExcel(s2);
TestScripts.logger.log(Status.INFO, languageRight.get(j).getText() +" : " +rightCount.get(j).getText());
//writedata.writeExcel(s2);
}
PASSNoImg("Fetched all languages");
//ResuableMethods.SScapture(driver, "Opening the url page");
WebElement w4=driver.findElement(courseraLocators.crossmark);
w4.click();
}
catch(Exception e) {
FAIL("Unable to fetch all languages");
}
//writedata.writeExcel(s1);
for(int m=0;m<s1.size();m++)
{
	writedata.writeExcel(s1.get(m));
}
for(int m=0;m<s2.size();m++)
{
	writedata.writeExcel(s2.get(m));
}
}
//getting all levels
public void getalllevels() throws Exception {
	List<String>s3=new ArrayList<String>();
try {
	List <WebElement> levelText = driver.findElements(By.xpath("//div[@class=\"checkboxText\"]"));
	List <WebElement> levelCount = driver.findElements(By.xpath("//div[@class=\"filter-count\"]"));
System.out.println(levelText.size());

for(int k=0;k<levelText.size();k++) {
System.out.println(levelText.get(k).getText() +" : " +levelCount.get(k).getText());
s3.add(levelText.get(k).getText() +" : " +levelCount.get(k).getText());
//writedata.writeExcel(s3);
TestScripts.logger.log(Status.INFO, levelText.get(k).getText() +" : " +levelCount.get(k).getText());
//writedata.writeExcel(s3);
}

}
catch(Exception e) {
FAIL("Unable to fetch all levels");
}
for(int m=0;m<s3.size();m++)
{
	writedata.writeExcel(s3.get(m));
}
}

public void popups() throws Exception {
	try {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(courseraLocators.pop).click();
	} catch(Exception e) {
		FAIL("Unable to close popup");
	}
	
}
}



