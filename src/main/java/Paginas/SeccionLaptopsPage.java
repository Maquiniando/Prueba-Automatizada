package Paginas;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeccionLaptopsPage extends Base {
    
    private By laptopsMenu = By.linkText("Laptops & Notebooks");
    private By showAllLaptops = By.linkText("Show All Laptops & Notebooks");
    
    public SeccionLaptopsPage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateToLaptopsSection() {
        WebElement laptopsElement = driver.findElement(laptopsMenu);
        Actions actions = new Actions(driver);
        actions.moveToElement(laptopsElement).perform();
        driver.findElement(showAllLaptops).click();
    }
    
    public boolean isLaptopsPageDisplayed() {
        return driver.getTitle().contains("Laptops & Notebooks");
    }
}
