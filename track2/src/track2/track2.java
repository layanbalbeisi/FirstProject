package track2;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class track2 {
	WebDriver driver= new ChromeDriver();
	Random rand = new Random();
	
@BeforeTest
public void start() {
	driver.get("https://codenboxautomationlab.com/practice/");
	driver.manage().window().maximize();
}

@Test (priority = 1, enabled = false)
public void mytest() throws InterruptedException {
	WebElement autoselect = driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']"));
	String [] randomselect = {"Jo", "Sy","USA","KSA","IR"};
	int index = rand.nextInt(randomselect.length);
	autoselect.sendKeys(randomselect[index]);
	System.out.println(index);
	Thread.sleep(1000);
	autoselect.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));
}

@Test(priority = 2, enabled = false)
public void myselector() {
	WebElement selecttag = driver.findElement(By.id("dropdown-class-example"));
	Select myselect = new Select(selecttag);
	//myselect.selectByIndex(1);
	myselect.selectByVisibleText("Appium");
	//myselect.selectByValue("Selenium");
}
@Test
public void checkbox() {
	WebElement DivOfCheckBox = driver.findElement(By.id("checkbox-example"));
    List<WebElement> allcheckboxes = DivOfCheckBox.findElements(By.tagName("input"));
    int Index = rand.nextInt(allcheckboxes.size());
    allcheckboxes.get(Index).click();
    
    // for(int i = 0; i<allcheckboxes.size();i++) {
    //	allcheckboxes.get(i).click();
    }
}

