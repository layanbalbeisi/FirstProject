package lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyTest {
	
	WebDriver driver = new ChromeDriver();
	
	String TheWebsite = "https://www.saucedemo.com/";
	String Username = "standard_user";
	String Password = "secret_sauce";
	
	
	@BeforeTest
	public void mySetup() {

		driver.manage().window().maximize();

		driver.get(TheWebsite);

	}
	@AfterTest
	public void myAfterTest() {

//		driver.quit();
	}
	

	}
