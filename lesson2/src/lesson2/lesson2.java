package lesson2;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Random;
public class lesson2 {
	
	
	WebDriver driver =new ChromeDriver();
	Random rand = new Random();
@BeforeTest
public void start() {
	driver.get("https://codenboxautomationlab.com/practice/");
	driver.manage().window().maximize();
	
@Test
public void myTest() {
	
	
}
		
		
	}

}
