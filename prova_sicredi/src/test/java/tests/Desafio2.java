package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Desafio2 {

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

		// Desafio 1
		Select dropdown = new Select(driver.findElement(By.id("switch-version-select")));
		dropdown.selectByValue("bootstrap_theme_v4");
		WebElement addCustomerBtn = driver.findElement(By.xpath("//a[@class='btn btn-default btn-outline-dark']"));
		addCustomerBtn.click();
		WebElement nameTb = driver.findElement(By.xpath("//input[@id='field-customerName']"));
		nameTb.sendKeys("Teste Sicredi");
		WebElement lastNameTb = driver.findElement(By.xpath("//input[@id='field-contactLastName']"));
		lastNameTb.sendKeys("Teste");
		WebElement contactFirstNameTb = driver.findElement(By.xpath("//input[@id='field-contactFirstName']"));
		contactFirstNameTb.sendKeys("Leandro");
		WebElement phoneTb = driver.findElement(By.xpath("//input[@id='field-phone']"));
		phoneTb.sendKeys("51 9999-9999");
		WebElement addressLine1Tb = driver.findElement(By.xpath("//input[@id='field-addressLine1']"));
		addressLine1Tb.sendKeys("Av Assis Brasil, 3970");
		WebElement addressLine2Tb = driver.findElement(By.xpath("//input[@id='field-addressLine2']"));
		addressLine2Tb.sendKeys("Torre D");
		WebElement cityTb = driver.findElement(By.xpath("//input[@id='field-city']"));
		cityTb.sendKeys("Porto Alegre");
		WebElement stateTb = driver.findElement(By.xpath("//input[@id='field-state']"));
		stateTb.sendKeys("RS");
		WebElement postalCodeTb = driver.findElement(By.xpath("//input[@id='field-postalCode']"));
		postalCodeTb.sendKeys("91000-000");
		WebElement countryTb = driver.findElement(By.xpath("//input[@id='field-country']"));
		countryTb.sendKeys("Brasil");
		WebElement employerCb = driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/a/span"));
		employerCb.click();
		WebElement employerOptionCb = driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/div/input"));
		employerOptionCb.sendKeys("Fixter");
		WebElement creditLimitTb = driver.findElement(By.xpath("//input[@id='field-creditLimit']"));
		creditLimitTb.sendKeys("200");
		WebElement saveBtn = driver.findElement(By.xpath("//button[@id='form-button-save']"));
		saveBtn.click();
		Thread.sleep(1000);
		String message = driver.findElement(By.xpath("//*[@id='report-success']")).getText();
		Assert.assertTrue(message.contains("Your data has been successfully stored into the database."));
		
		// Desafio 2
		// 1. Clique no link Go back to list
		WebElement goBackLink = driver.findElement(By.xpath("//*[@id='report-success']/p/a[contains(text(),'Go back to list')]"));
		goBackLink.click();
		
		// 2. Clique no ícone da lupa (pesquisa) e digite o conteúdo do Name (Teste Sicredi)
		WebElement searchBtn = driver.findElement(By.xpath("//*[@id='gcrud-search-form']/div[1]/div[2]/a[3]/i"));
		searchBtn.click();
		WebElement searchTb = driver.findElement(By.xpath("//input[@name='search']"));
		searchTb.sendKeys("Teste Sicredi");
		searchTb.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		// 3. Clicar no checkbox abaixo da palavra Actions
		WebElement checkAll = driver.findElement(By.xpath("//*[@class='select-all-none']"));
		checkAll.click();
		
		// 4. Clicar no botão Delete
		WebElement deleteBtn = driver.findElement(By.xpath("//*[@id='gcrud-search-form']//a/span[contains(text(),'Delete')]"));
		deleteBtn.click();
		
		// 5. Validar o texto "Are you sure that you want to delete this 1 item?" através de uma asserção para a popup que será apresentada 
		Thread.sleep(1000);
		String messageDel = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[2]/text()/../..")).getText();
		Assert.assertTrue(messageDel.equals("Are you sure that you want to delete this 1 item?"));
		
		// 6. Clicar no botão Delete da popup
		WebElement deletePopUpBtn = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[contains(text(),'Delete')]"));
		deletePopUpBtn.click();
		
		// 7. Aparecerá uma mensagem dentro de um box verde na parte superior direito da tela.
		//    Adicione uma asserção na mensagem "Your data has been successfully deleted from the database."
		Thread.sleep(1000);
		String messagePopUpDel = driver.findElement(By.xpath("//*[contains(text(),'Your data has been successfully deleted from the database.')]")).getText();
		Assert.assertTrue(messagePopUpDel.contains("Your data has been successfully deleted from the database."));
	}
}