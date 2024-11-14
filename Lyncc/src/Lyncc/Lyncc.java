package Lyncc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Lyncc {

	public static void main(String[] args) {
		
	System.setProperty("Webdriver.gecko.driver", "geckodriver.exe");
	
	WebDriver driver = new FirefoxDriver();
	
	//Accessing the Application
	driver.navigate().to("http://lync-reactjs-bucket.s3-website.ap-south-1.amazonaws.com/");
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().window().maximize();
    
	//Login with Valid Credentials
	driver.findElement(By.xpath("//input[@placeholder='EMAIL']")).sendKeys("admin@lyncc.com");
	driver.findElement(By.xpath("//input[@placeholder='PASSWORD']")).sendKeys("admin@098");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
    if (driver.findElement(By.linkText("Dashboard")).isDisplayed())
    {
        System.out.println("TestCase 1 is PASS");
    }else
    {
    	System.out.println("TestCase 1 is FAIL");
    }
   
	driver.findElement(By.xpath("//button[@class='nav-link text-secondary d-flex align-items-center']")).click();

	//Login With Invalid Credentials
	driver.findElement(By.xpath("//input[@placeholder='EMAIL']")).sendKeys("jhjdhjj");
	driver.findElement(By.xpath("//input[@placeholder='PASSWORD']")).sendKeys("adsjhhh@11e1");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	if(driver.findElement(By.xpath("//p[@class='error']")).isDisplayed())
    {
	      System.out.println("TestCase 2  is PASS");
    }else
    {
    	  System.out.println("TestCase 2 is FAIL");
    }
	
	//Login Without Providing Any Credentials
    driver.navigate().refresh();
    driver.findElement(By.xpath("//input[@type='submit']")).click();
    
    if(driver.findElement(By.xpath("//input[@type='submit']")).isDisplayed())
    {
    	System.out.println("TestCase 3 is PASS");
    }else
    {
    	System.out.println("Testcase 3 is Fail");
    }
	driver.findElement(By.xpath("//input[@placeholder='EMAIL']")).sendKeys("admin@lyncc.com");
	driver.findElement(By.xpath("//input[@placeholder='PASSWORD']")).sendKeys("admin@098");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
    
    
    //Search Functionality With Valid Username
    driver.findElement(By.linkText("Users")).click();
	driver.findElement(By.xpath("//button[@class='btn btn-outline-warning ']")).click();
	driver.findElement(By.xpath("//button[@class='btn btn-outline-warning ']")).click();
	driver.findElement(By.xpath("//button[@class='btn btn-outline-warning ']")).click();
	driver.findElement(By.xpath("//input[@placeholder='Search users...']")).sendKeys("Satish Gude");
	if(driver.findElement(By.linkText("User List")).isDisplayed())
	{
		System.out.println("TestCase 4 is PASS");
	}else
	{
		System.out.println("TestCase 4 is FAIL");
	}
	
	//Search Functionaity With Invalid Username
	driver.findElement(By.xpath("//input[@placeholder='Search users...']")).clear();
    driver.findElement(By.xpath("//input[@placeholder='Search users...']")).sendKeys("jhbjhfhhh");
    if (driver.findElement(By.xpath("//div[@style='left: 0px; font-size: 1.2rem; color: red; text-align: center; margin-top: 15px;']")).isDisplayed())
    {
    	System.out.println("TestCase 5 is PASS");
    }else
    {
    	System.out.println("TestCase 5 is FAIL");
    }
    
    //Logout the Application
    driver.findElement(By.xpath("//button[@class='nav-link text-secondary d-flex align-items-center']")).click();
   
	//Close the Application
	driver.close();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
