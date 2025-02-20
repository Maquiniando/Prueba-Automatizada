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
import Paginas.CarritoPage;

public class Carrito {

    private WebDriver driver;
    private CarritoPage carritoPage;

    By avanzado = By.id("details-button");
    By acceso = By.linkText("Acceder a opencart.abstracta.us (sitio no seguro)");

    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opencart.abstracta.us/");
        carritoPage = new CarritoPage(driver);
    }

    @Test
    public void testCompletePurchase() {
        driver.findElement(avanzado).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(acceso)).click();

        // Agregar MacBook Pro y buscar Tablet Samsung
        carritoPage.addMacBookProToCart();
        assertTrue("La MacBook Pro no se agregó correctamente", carritoPage.isProductAdded());

        carritoPage.searchAndAddSamsungTablet();
        assertTrue("La Tablet Samsung no se agregó correctamente", carritoPage.isProductAdded());

        // Eliminar MacBook Pro del carrito
        carritoPage.removeMacBookProFromCart();

        // Agregar otra unidad de la Tablet Samsung
        carritoPage.addAnotherSamsungTablet();

        // Completar el proceso de compra
        carritoPage.completeCheckout();

        // Verificar confirmación de la orden
        assertTrue("La orden no fue confirmada", carritoPage.isOrderConfirmed());
    }
}

