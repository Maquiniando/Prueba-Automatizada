package Opencart;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Paginas.RegistroPage;


public class Registro {
	
	private WebDriver driver;
	private RegistroPage registro;
	
	
	By avanzado = By.id("details-button");
	By acceso = By.linkText("Acceder a opencart.abstracta.us (sitio no seguro)");
	
	@Before
	public void setUp()  {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opencart.abstracta.us/index.php?route=account/register");
		driver.manage().window().maximize();
		registro = new RegistroPage(driver);
	}
	
	
	@Test
	public void registerUser() {
		
		driver.findElement(avanzado).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("details-button")));
		
		driver.findElement(acceso).click();
		
		
		registro.register("Malory", "Quimbayo", "malory" + "@gmail.com",
                "3122978645", "Prueba123");
		
		WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//p[contains(text(), 'Congratulations!')]")));
		
        assertTrue("El registro fue exitoso", registro.isRegistrationSuccessful());
		
	}
	
	 @After
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	
	
}
	
	