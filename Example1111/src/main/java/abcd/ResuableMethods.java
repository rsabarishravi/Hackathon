package abcd;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
//import hackthon.TestScripts;
//import hackthon.Courses;

public class ResuableMethods extends writedata{
	static WebDriver driver;
	WebElement element;

	/******************* Invoke the Browser ********************/
	public void openBrowser(String browser) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--disable-notifications");
			 Courses.driver = new ChromeDriver(option);
			 
			} else if (browser.equalsIgnoreCase("msedge")) {
				System.setProperty("webdriver.edge.driver",
			    System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\msedgedriver.exe");
			    Courses.driver = new EdgeDriver();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	

	/******************* sleep method ********************/
	public void waitfor(int sec) {
		try {
			Thread.sleep(sec * 500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/******************* clicking on Button 
	 * @throws Exception ********************/
	public void Click(By Loc, String Obj) throws Exception {
		try
		{
			waitfor(2);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(Loc).click();
		waitfor(2);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//BusinessFlow.PASSNoImg("clicked on "+Obj);
		}catch(Exception e)
		{
			Courses.FAIL("Unable to click");
		}
	}

	/******************* sending Text to input field ********************/
	public void input(By loc, String search) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		element = driver.findElement(loc);
		element.sendKeys(search);
		element.sendKeys(Keys.ENTER);
	}

	/******************* getting Title of the page 
	 * @throws IOException 
	 * @throws InvalidFormatException ********************/
	public String GetTitle() throws InvalidFormatException, IOException {
		String tit = driver.getTitle();
		System.out.println("Title is  " + tit);
		writedata.writeExcel(tit);
		return tit;
	}

	public static String SScapture(WebDriver driver,String str) throws Exception {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imgPath = "./ExReport/Screenshots/"+str+"-"+System.currentTimeMillis()+ ".png";
		File path = new File(imgPath);
		FileUtils.copyFile(srcFile, path);
		return imgPath;
	}
/******************* Reporting Function ********************/
	
	//public 
	
	public static void FAIL(String ActionStep) throws Exception {
		TestScripts.logger.fail(ActionStep,MediaEntityBuilder.createScreenCaptureFromPath("."+SScapture(driver,"fail")).build());
	}
	public static void PASSNoImg(String ActionStep) throws Exception {
		TestScripts.logger.pass(ActionStep);
	}
	public static void PASS(String ActionStep) throws Exception {
		TestScripts.logger.pass(ActionStep,MediaEntityBuilder.createScreenCaptureFromPath("."+SScapture(driver,"pass")).build());
	}
/************************/

}

