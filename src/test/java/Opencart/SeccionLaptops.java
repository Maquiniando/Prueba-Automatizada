package Opencart;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Paginas.SeccionLaptopsPage;

public class SeccionLaptops {
    
    private WebDriver driver;
    private SeccionLaptopsPage laptopsPage;
    
    By avanzado = By.id("details-button");
	By acceso = By.linkText("Acceder a opencart.abstracta.us (sitio no seguro)");
	
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opencart.abstracta.us/");
        laptopsPage = new SeccionLaptopsPage(driver);
    }
    
    @Test
    public void testNavigateToLaptops() {
    	
	   driver.findElement(avanzado).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("details-button")));
		
		driver.findElement(acceso).click();
		
        laptopsPage.navigateToLaptopsSection();
        assertTrue("No se mostró la página de laptops", laptopsPage.isLaptopsPageDisplayed());
    }
}