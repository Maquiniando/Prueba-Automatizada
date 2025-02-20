package Opencart;


import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Paginas.RestablecimientoPage;

public class RestablecimientoContraseña {
    private WebDriver driver;
    private RestablecimientoPage forgotPasswordPage;
    
	By avanzado = By.id("details-button");
	By acceso = By.linkText("Acceder a opencart.abstracta.us (sitio no seguro)");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        forgotPasswordPage = new RestablecimientoPage(driver);
    }

    @Test
    public void testResetPassword() {
    	
driver.findElement(avanzado).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("details-button")));
		
		driver.findElement(acceso).click();
		
        forgotPasswordPage.resetPassword("malory@gmail.com");
        assertTrue("Se envia a correo para restablecer contraseña", forgotPasswordPage.isResetSuccessful());
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
   
}
