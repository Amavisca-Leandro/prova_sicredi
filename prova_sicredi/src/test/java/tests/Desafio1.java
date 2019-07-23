package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Desafio1 {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		// Acesse a página https://www.grocerycrud.com/demo/bootstrap_theme
		System.setProperty("webdriver.chrome.driver", "/home/leandro/WebDrivers/chromedriver");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {		
		driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
		driver.manage().window().maximize();

		// Mude o valor da combo Select version para "Bootstrap V4 Theme"
		Select dropdown = new Select(driver.findElement(By.id("switch-version-select")));
		dropdown.selectByValue("bootstrap_theme_v4");

		// Clique no botão Add Customer
		WebElement addCustomerBtn = driver.findElement(By.xpath("//a[@class='btn btn-default btn-outline-dark']"));
		addCustomerBtn.click();

		// Name
		WebElement nameTb = driver.findElement(By.xpath("//input[@id='field-customerName']"));
		nameTb.sendKeys("Teste Sicredi");
		// Last Name
		WebElement lastNameTb = driver.findElement(By.xpath("//input[@id='field-contactLastName']"));
		lastNameTb.sendKeys("Teste");
		// ContactFirstName
		WebElement contactFirstNameTb = driver.findElement(By.xpath("//input[@id='field-contactFirstName']"));
		contactFirstNameTb.sendKeys("Leandro");
		// Phone
		WebElement phoneTb = driver.findElement(By.xpath("//input[@id='field-phone']"));
		phoneTb.sendKeys("51 9999-9999");
		// AddressLine1
		WebElement addressLine1Tb = driver.findElement(By.xpath("//input[@id='field-addressLine1']"));
		addressLine1Tb.sendKeys("Av Assis Brasil, 3970");
		// AddressLine2
		WebElement addressLine2Tb = driver.findElement(By.xpath("//input[@id='field-addressLine2']"));
		addressLine2Tb.sendKeys("Torre D");
		// City
		WebElement cityTb = driver.findElement(By.xpath("//input[@id='field-city']"));
		cityTb.sendKeys("Porto Alegre");
		// State
		WebElement stateTb = driver.findElement(By.xpath("//input[@id='field-state']"));
		stateTb.sendKeys("RS");
		// PostalCode
		WebElement postalCodeTb = driver.findElement(By.xpath("//input[@id='field-postalCode']"));
		postalCodeTb.sendKeys("91000-000");
		// Country
		WebElement countryTb = driver.findElement(By.xpath("//input[@id='field-country']"));
		countryTb.sendKeys("Brasil");
		// from Employeer
		WebElement employerCb = driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/a/span"));
		employerCb.click();
		WebElement employerOptionCb = driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/div/input"));
		employerOptionCb.sendKeys("Fixter");
		// CreditLimit
		WebElement creditLimitTb = driver.findElement(By.xpath("//input[@id='field-creditLimit']"));
		creditLimitTb.sendKeys("200");

		// Save Button
		WebElement saveBtn = driver.findElement(By.xpath("//button[@id='form-button-save']"));
		saveBtn.click();
	
		// Message Validation
		Thread.sleep(1000);
		String message = driver.findElement(By.xpath("//*[@id='report-success']")).getText();
		Assert.assertTrue(message.contains("Your data has been successfully stored into the database."));
	}
}