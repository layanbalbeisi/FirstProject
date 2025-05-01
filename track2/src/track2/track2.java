package track2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
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
@Test(priority = 3, enabled = false)
public void checkbox() {
	WebElement DivOfCheckBox = driver.findElement(By.id("checkbox-example"));
    List<WebElement> allcheckboxes = DivOfCheckBox.findElements(By.tagName("input"));
    int Index = rand.nextInt(allcheckboxes.size());
    allcheckboxes.get(Index).click();
    
    // for(int i = 0; i<allcheckboxes.size();i++) {
    //	allcheckboxes.get(i).click();
    }
@Test(priority = 4, enabled= false)
public void windowexample() {
	WebElement OpenWindow = driver.findElement(By.id("openwindow"));
	OpenWindow.click();
	
	Set<String> handles = driver.getWindowHandles();
	List<String> windowList = new ArrayList<String>(handles);
	driver.switchTo().window(windowList.get(1));
	System.out.println(windowList);
	
	
}
@Test(priority = 5, enabled= false)
public void openwindow() {
	WebElement OpenWindow = driver.findElement(By.id("opentab"));
	OpenWindow.click();
	
	Set<String> handles = driver.getWindowHandles();
	List<String> windowList = new ArrayList<String>(handles);
	driver.switchTo().window(windowList.get(1));
	System.out.println(driver.getTitle());
	
}
@Test (priority = 6, enabled= false)
public void alratbutton() {
	WebElement entername = driver.findElement(By.id("name"));
	entername.sendKeys("layan");
	WebElement AlertButton = driver.findElement(By.id("alertbtn"));
	AlertButton.click();
	driver.switchTo().alert().accept();
	
}
@Test (priority = 7, enabled= true)
public void table() {
	WebElement Table = driver.findElement(By.id("product"));
	List<WebElement> thetable = Table.findElements(By.tagName("tr"));
	for (int i = 0;i<thetable.size();i++) {
		System.out.print(thetable.get(i).getText());
	}
}
}

