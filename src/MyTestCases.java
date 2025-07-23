import java.awt.Desktop.Action;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	WebDriver driver = new ChromeDriver();
	String TheURL = "https://codenboxautomationlab.com/practice/";
	
	Connection con ;
	Statement stmt;
	ResultSet rs ;
	String FirstName ;
	String LastName ;
	String Phone ;
	String Company ;
	Random rand = new Random();
	

	@BeforeTest
	public void MySetup() throws SQLException {
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "123456");

		driver.get(TheURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(enabled = false)
	public void RadioButton() {
		WebElement ContainerRadioButton = driver.findElement(By.xpath("//div[@id='radio-btn-example']//fieldset"));
		ContainerRadioButton.findElements(By.tagName("input")).get(0).click();

	}

	@Test(enabled = false)
	public void Dynamic_Dropdown() throws InterruptedException {

		String[] Countries = { "jor", "turk", "irq" };
		WebElement CountryInput = driver.findElement(By.id("autocomplete"));
		CountryInput.sendKeys(Countries[1]);
		Thread.sleep(2000);
		CountryInput.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));
	}

	@Test(enabled = false)
	public void Static_Dropdown() {

		WebElement MySelectTag = driver.findElement(By.id("dropdown-class-example"));
		Select myselect = new Select(MySelectTag);
		myselect.selectByIndex(1);
//		myselect.selectByValue("option3");
//		myselect.selectByVisibleText("Appium");

	}

	@Test(enabled = false)
	public void Checkbox() {
		WebElement CheckboxInput = driver.findElement(By.xpath("//div[@id='checkbox-example']//fieldset"));
		List<WebElement> AllCheckBox = CheckboxInput.findElements(By.tagName("input"));
		for (int i = 0; i < AllCheckBox.size(); i++) {
			AllCheckBox.get(i).click();
		}

	}

	@Test(enabled = false)
	public void Open_window() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,700)");

		WebElement OpenWindow = driver.findElement(By.id("openwindow"));
		OpenWindow.click();
		System.out.println(driver.getTitle());
		Set<String> handles = driver.getWindowHandles();
		List<String> AllTabs = new ArrayList<>(handles);
		driver.switchTo().window(AllTabs.get(1));

		WebElement Contact = driver.findElement(By.xpath("//li[@id='menu-item-9680']//a"));
		Contact.click();
		driver.switchTo().window(AllTabs.get(0));

	}

	@Test(enabled = false)
	public void Open_Tab() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,700)");

		WebElement OpenTab = driver.findElement(By.id("opentab"));
		OpenTab.click();

		System.out.println(driver.getTitle());
		Set<String> handles = driver.getWindowHandles();
		List<String> AllTabs = new ArrayList<>(handles);

		driver.switchTo().window(AllTabs.get(1));
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.switchTo().window(AllTabs.get(0));

	}

	@Test(enabled = false)
	public void AlertAndConfirm() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,700)");
		WebElement SwitchToAlert = driver.findElement(By.id("name"));
		WebElement SwitchToConfirm = driver.findElement(By.id("confirmbtn"));
		SwitchToAlert.sendKeys("Hi Marwan");
		SwitchToConfirm.click();
		driver.switchTo().alert().accept();

	}

	@Test(enabled = false)
	public void TheTable() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,700)");

		WebElement TheTable = driver.findElement(By.id("product"));
		List<WebElement> AllData = TheTable.findElements(By.tagName("tr"));
		for (int i = 0; i < AllData.size(); i++) {
			System.out.println(AllData.get(i).getText());

		}
	}
	
	@Test(enabled = false)
	public void ElementDisplayed() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1500)");

		Thread.sleep(2000);
		
		WebElement TheElementweNeedToHide = driver.findElement(By.id("displayed-text"));
		WebElement ThebuttonToHide = driver.findElement(By.id("hide-textbox"));
		ThebuttonToHide.click();
		System.out.println(TheElementweNeedToHide.isDisplayed());
		Thread.sleep(2000);
		WebElement ThebuttonToShow = driver.findElement(By.id("show-textbox"));
		ThebuttonToShow.click();
		System.out.println(TheElementweNeedToHide.isDisplayed());
	}
	
	@Test(enabled = false)
	public void EnabledAndDisabled() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1500)");

		
		WebElement DisabledInput = driver.findElement(By.id("disabled-button"));
		DisabledInput.click();
		WebElement TheText = driver.findElement(By.id("enabled-example-input"));
		System.out.println(TheText.isEnabled());
		WebElement EnableddInput = driver.findElement(By.id("enabled-button"));
		EnableddInput.click();
		
		System.out.println(TheText.isEnabled());
		
		
	}
	
	@Test(enabled = false)
	public void MouseHover() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1900)");
		
		WebElement MousHover = driver.findElement(By.id("mousehover"));
		Actions action = new Actions(driver);
		action.moveToElement(MousHover).build().perform();
		WebElement TopInput = driver.findElement(By.linkText("Top"));
		TopInput.click();
		WebElement ReloadInput =  driver.findElement(By.linkText("Reload"));
		ReloadInput.click();
		
	}
	@Test
	public void Calendar() throws InterruptedException, SQLException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1900)");
		
		WebElement CalendarInput =  driver.findElement(By.linkText("Booking Calendar"));
		CalendarInput.click();
		
		Set<String> handles = driver.getWindowHandles();
		List<String> AllTabs = new ArrayList<>(handles);
		driver.switchTo().window(AllTabs.get(1));
		
		WebElement NumberOfTheCalendar = driver.findElement(By.linkText("24"));
		NumberOfTheCalendar.click();
		
		Thread.sleep(2000);
		int randomID = rand.nextInt(124,126);
		
		String QueryToRead  = "select * from customers where customerNumber =  "+randomID;
		stmt = con.createStatement();
		rs = stmt.executeQuery(QueryToRead);
		while(rs.next()) {
			FirstName = rs.getString("contactFirstName");
			LastName = rs.getString("contactLastName");
			Phone = rs.getString("phone");
			Company= rs.getString("customerName");
			
		}
		int RandomNumber = rand.nextInt();
		driver.findElement(By.id("name1")).sendKeys(FirstName);
		driver.findElement(By.id("secondname1")).sendKeys(LastName);
		driver.findElement(By.id("email1")).sendKeys(FirstName+LastName+RandomNumber+"@gmail.com");
		driver.findElement(By.id("phone1")).sendKeys(Phone);
		driver.findElement(By.id("details1")).sendKeys(Company);


	}

}
