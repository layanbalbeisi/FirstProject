package track1;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class track1 {
	
	WebDriver driver = new FirefoxDriver();
	String THEWEBSITE = "https://www.saucedemo.com/";
	String UserName = "standard_user";
	String Password = "secret_sauce";
	
	@BeforeTest
	public void beforetest() {
		driver.manage().window().maximize();
		driver.get(THEWEBSITE);
		
	}
@Test
public void inTest() {
		WebElement UserNameInput = driver.findElement(By.id("user-name"));

		WebElement PasswordInput = driver.findElement(By.id("password"));

		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UserNameInput.sendKeys(UserName);
		PasswordInput.sendKeys(Password);
		LoginButton.click();;
	}
@Test(priority = 1)
public void addallitem() throws InterruptedException {
	List<WebElement> printFirstLatter = driver.findElements(By.className("inventory_item_name"));
	for(int i = 0; i<printFirstLatter.size();i++) {
		String itemName = printFirstLatter.get(i).getText();
		System.out.println(itemName.charAt(0));
	}
	
	 List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
	
  	 for(int i = 0 ; i<AddToCartButtons.size();i++) {
		AddToCartButtons.get(i).click();
	}
		Thread.sleep(1000);
	}
@Test (priority = 2)
public void removeallitem() throws InterruptedException {
		List<WebElement> RemoveAllItem = driver.findElements(By.className("btn"));
		for(int i = 0; i<RemoveAllItem.size();i++) {
			RemoveAllItem.get(i).click();
			
		}
	}
@Test(enabled = false)
public void logout() throws InterruptedException {
	WebElement BurgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
	BurgerMenu.click();
	Thread.sleep(1000);
	WebElement LogOutButton = driver.findElement(By.id("logout_sidebar_link"));
	LogOutButton.click();

	Thread.sleep(1000);
;
	WebElement loginlogo = driver.findElement(By.className("login_logo"));
	System.out.print(loginlogo.getText());
	}
@AfterTest(enabled = false)
	public void myAfterTest() {

//		driver.quit();
	}

}
