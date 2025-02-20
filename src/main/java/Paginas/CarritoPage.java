package Paginas;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarritoPage {

    private WebDriver driver;
    
    // Localizadores
    private By laptopsNotebooksMenu = By.linkText("Laptops & Notebooks");
    private By showAllLaptops = By.linkText("Show All Laptops & Notebooks");
    private By macbookProLink = By.xpath("//a[contains(text(),'MacBook Pro')]");
    private By addToCartButton = By.id("button-cart");
    private By successMessage = By.cssSelector(".alert-success");
    private By searchBox = By.name("search");
    private By searchButton = By.cssSelector(".btn-default");
    private By samsungTablet = By.linkText("Samsung Galaxy Tab 10.1");
    
    // Localizador para el carrito
    private By cartIcon = By.id("cart");
    private By removeMacBookProButton = By.xpath("//button[@title='Remove']");
    private By quantityInput = By.name("quantity");
    private By checkoutButton = By.linkText("Checkout");
    private By confirmOrderButton = By.id("button-confirm");
    private By orderConfirmationMessage = By.cssSelector(".alert-success");

    public CarritoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addMacBookProToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Clic en "Laptops & Notebooks"
        WebElement laptopsMenu = wait.until(ExpectedConditions.elementToBeClickable(laptopsNotebooksMenu));
        laptopsMenu.click();
        
        // Clic en "Show All Laptops & Notebooks"
        WebElement showAll = wait.until(ExpectedConditions.elementToBeClickable(showAllLaptops));
        showAll.click();
        
        // Clic en "MacBook Pro"
        WebElement macbookPro = wait.until(ExpectedConditions.elementToBeClickable(macbookProLink));
        macbookPro.click();
        
        // Clic en "Add to Cart"
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCart.click();
    }

    public boolean isProductAdded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }

    public void searchAndAddSamsungTablet() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Buscar "Samsung Galaxy Tab 10.1"
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        search.clear();
        search.sendKeys("Samsung Galaxy Tab 10.1");
        
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchBtn.click();
        
        // Seleccionar "Samsung Galaxy Tab 10.1"
        WebElement samsung = wait.until(ExpectedConditions.elementToBeClickable(samsungTablet));
        samsung.click();
        
        // Añadir al carrito
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCart.click();
    }

    public void removeMacBookProFromCart() {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    	    
    	    // Clic en el ícono del carrito y espera que sea clickeable
    	    wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    	    
    	    // Esperar y hacer clic en el botón de eliminar
    	    wait.until(ExpectedConditions.elementToBeClickable(removeMacBookProButton)).click();
    }

    public void addAnotherSamsungTablet() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        WebElement quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityInput));
        quantity.clear();
        quantity.sendKeys("2");
        
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCart.click();
        
        // Esperar a que el mensaje de éxito sea visible
        WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));
        // O usar presenceOfElementLocated si no es necesario que sea visible:
        // WebElement successAlert = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert-success")));
    }

    public void completeCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Clic en "Checkout"
        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkout.click();
        
        // Confirmar la orden
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton));
        confirmButton.click();
    }

    public boolean isOrderConfirmed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationMessage)).isDisplayed();
    }
}

