package Opencart;

import static org.junit.Assert.assertTrue;
import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Paginas.LoginPage;

public class Login{
    
    private WebDriver driver;
    private LoginPage loginPage;
    
	By avanzado = By.id("details-button");
	By acceso = By.linkText("Acceder a opencart.abstracta.us (sitio no seguro)");
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        loginPage = new LoginPage(driver);
    }
    
    @Test
    public void testLogin() {
    	
driver.findElement(avanzado).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("details-button")));
		
		driver.findElement(acceso).click();
        loginPage.login("malory@gmail.com", "Prueba123");  
        
        assertTrue("El inicio de sesión fue exitoso", loginPage.isLoginSuccessful());
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


