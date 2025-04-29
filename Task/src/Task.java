import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Task {
	
	String TheWebsite = "http://127.0.0.1:5500/index.html";
	String username = "Layan";
	String Password = "1234@";
	WebDriver driver = new EdgeDriver();
	

	
@Test

public void login() throws InterruptedException {
	driver.get(TheWebsite);
	WebElement name = driver.findElement(By.id("username"));
	name.sendKeys(username);
	
	WebElement password = driver.findElement(By.cssSelector(".jj"));
	password.sendKeys(Password);
	Thread.sleep(1000);	
}

}
