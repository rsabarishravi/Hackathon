package abcd;

import org.openqa.selenium.By;

//import com.google.j2objc.annotations.Property;

public class courseraLocators{
//	driver.findElement()
	//https://www.coursera.org/in
    //public static String Url=prop.getProperty("url");
	//public static String Url="//https://www.coursera.org/in";
	//System.out.println(a);
    public static String ActualTitleofHomePage="Coursera in India | Online Courses & Certificates From Top Institutions";
	
    public static By search =By.xpath("//input[@class='react-autosuggest__input' and @role='textbox']");//search bar
	public static By lan=By.xpath("//div[@class='Select-placeholder' and text()='Language']");//language
	public static By English=By.xpath("//input[@type='checkbox' and @value='English']");//selecting English
	public static By level=By.xpath("//div[@class='Select-placeholder' and text()='Level']");//level
	public static By beginner= By.xpath("//input[@type='checkbox' and @value='Beginner']");//beginner
	public static By contentDiv=By.xpath("//*[@class='ais-InfiniteHits']");//xpath for div
	public static By contentUl=By.xpath("//*[@class='ais-InfiniteHits-list']");//xpath for unorderedlist
	public static By Coursename=By.xpath("//*[@data-e2e='xdp-banner-title']");//xpath for course name
	public static By courserating= By.xpath("//*[@data-test='number-star-rating']");//xpath for course rating
	public static By learninghours=By.xpath("//*[@class='ProductGlance']/div[5]/div[2]/div/span");//xpath for learning hours
	public static By learninghours2=By.xpath("//*[@class='ProductGlance']/div[6]/div[2]/div/span");//xpath for 2nd learning hours
	
	public static By explore=By.className("_r3zeoj");//for Explore
	public static By languageLearning=By.id("language-learning~menu-item");//selecting the Language learning
	public static By certificates=By.xpath("//*[@id=\"rendered-content\"]/div/header/div/div/div/div[1]/div[2]/div/div/nav/div/div/div[2]/div[10]/div/section/div/div[2]/div[1]/div[2]/div/ul/li[3]/a/span");
	//public static By certificates=By.xpath("//*[@id=\"rendered-content\"]/div/header/div/div/div/div[1]/div[2]/div/div/nav/div/div/div[2]/div[10]/div/section/div/div[2]/div[1]/div[2]/div/ul/li[3]/a/span");
	public static By clearcourses=By.className("ais-ClearRefinements-button");//clear the courses
	public static By subject=By.xpath("//*[@class='Select-placeholder' and text()='Subject']");//clicking on subject
	public static By Languagelearning2=By.xpath("//*[@class='_htmk7zm' and @value='Language Learning' and @type='checkbox']");//selecting language learning

	//public static By E=By.xpath("//*[@class='Select-placeholder' and text()='Language']");//click on language filter
	public static By pop=By.xpath("//*[@id=\"rendered-content\"]/div/div[1]/div/div[2]/div[3]/a");
	public static By showall=By.xpath("//*[text()='Show All']");//click on show all
	public static By lanDiv2=By.className("left-section");
	public static By langsclassname=By.className("_htmk7zm");
	public static By lanDiv=By.className("right-section");
	//public static By langsclassname2=By.className("_htmk7zm");
	public static By leftCount=By.xpath("//div[@class=\"left-section\"]//div[@class=\"filter-count\"]");
	public static By rightCount=By.xpath("//div[@class=\"right-section\"]//div[@class=\"filter-count\"]");
	public static By levlcount=By.xpath("//div[@class=\"filter-count\"]");


	
	public static By crossmark=By.xpath("//*[@class='nostyle' and@data-e2e='close-modal-button']");//closing-modal-button
//	public static By s1=By.xpath("//*[@class='Select-placeholder' and text()='Level']");//level
	public static By levelnames=By.className("_htmk7zm");//geting level values

	
	public static By Enterprise=By.id("enterprise-link");//enterprise button
	public static By Products = By.xpath("//*[@id=\"menu-item-9140\"]/a"); //products
	public static By forcampus =By.xpath("//*[@id=\"menu-item-4901\"]/a");//forcampus
	public static By getstarted = By.xpath("/html/body/main/section[3]/div/div[2]/div[1]/p[1]/a");//getstartedbutton
	public static By firstname=By.xpath("/html/body/main/section[8]/div/div/div/form/div[1]/div[1]/div[2]/input");//first name
	public static By lastname=By.xpath("/html/body/main/section[8]/div/div/div/form/div[1]/div[2]/div[2]/input");//last name
	public static By jobfunction =By.xpath("/html/body/main/section[8]/div/div/div/form/div[2]/div[1]/div[2]/select");//jobslection
	public static By jobTitle=By.xpath("//*[@id=\"Title\"]");//job title
	public static By workEmail=By.xpath("//*[@id=\"Email\"]");//work email
	public static By phonenumber=By.xpath("//*[@id=\"Phone\"]");//phone number
	public static By institute=By.xpath("//*[@id=\"Company\"]");//institution name
	
	public static By institutiontype = By.xpath("//*[@id=\"Institution_Type__c\"]");//institutename
	public static By PrimaryDiscipline = By.xpath("//*[@id=\"Primary_Discipline__c\"]");//primaryDiscpline
	public static By country =By.xpath("//*[@id=\"Country\"]");//country
	public static By state = By.xpath("//*[@id=\"State\"]");//state
	public static By submit = By.xpath("//*[@id=\"mktoForm_1512\"]/div[20]/span/button");//submit
	public static By invalid=By.xpath("//*[@id=\"ValidMsgEmail\"]");//invalid 


}

