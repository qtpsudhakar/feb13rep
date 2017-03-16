

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WC19WorkingWithElements_MouseKeyboard {

	public static void main(String[] args) throws InterruptedException, AWTException {
		/*
		 * hover
		 * click
		 * doubleclick
		 * rightclick
		 * scroll (javascript executor, or hover)
		 * drag and drop
		 * 
		 * we can use Actions class to perform mouse/keyboard related operations
		 */
		
		// configure browser driver
		System.setProperty("webdriver.chrome.driver",
				"F:\\SeleniumSoftware\\BrowserDrivers\\chromedriver.exe");

		// open new edge window
		WebDriver driver = new ChromeDriver();

		// specify page load time
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		// element wait time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// maximize window
		driver.manage().window().maximize();

		driver.navigate().to("http://opensource.demo.orangehrmlive.com");
		// enter text on username
		driver.findElement(By.xpath("//*[@id='txtUsername']"))
				.sendKeys("admin");

		// enter password
		driver.findElement(By.xpath("//*[@id='txtPassword']"))
				.sendKeys("admin");

		// click on login button
		driver.findElement(By.cssSelector("#btnLogin")).click();

		/*
		 * mouse hover
		 */
		WebElement elm = driver.findElement(By.linkText("PIM"));
		Actions act  = new Actions(driver);
		Thread.sleep(3000);
		act.moveToElement(elm).moveToElement(driver.findElement(By.partialLinkText("Add Employee"))).build().perform();
		
		Thread.sleep(1000);

		// click on AddEmployee link
		//driver.findElement(By.partialLinkText("Add Employee")).click();

		// enter first name
		driver.findElement(By.id("firstName")).sendKeys("selenium");

		// enter last name
		driver.findElement(By.id("lastName")).sendKeys("selenium");

		driver.findElement(By.id("btnSave")).click();
		
		// close the browser
		driver.quit();

	}

}







