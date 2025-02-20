package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestablecimientoPage extends Base {
    
    private By forgotPasswordLink = By.linkText("Forgotten Password");
    private By emailInput = By.id("input-email");
    private By continueButton = By.xpath("//input[@value='Continue']");
    private By confirmationMessage = By.cssSelector(".alert-success");

    public RestablecimientoPage(WebDriver driver) {
        super(driver);
    }

    public void resetPassword(String email) {
        driver.findElement(forgotPasswordLink).click();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(continueButton).click();
    }

    public boolean isResetSuccessful() {
        return driver.findElement(confirmationMessage).isDisplayed();
    }
}

