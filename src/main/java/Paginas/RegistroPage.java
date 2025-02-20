package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistroPage extends Base{

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-telephone")
    private WebElement telephoneInput;

    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(id = "input-confirm")
    private WebElement confirmPasswordInput;

    @FindBy(name = "agree")
    private WebElement privacyPolicyCheckbox;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//p[contains(text(), 'Congratulations!')]")
    private WebElement successMessage;

    public RegistroPage(WebDriver driver) {
        super(driver);
    }

    public void register(String firstName, String lastName, String email, String telephone, String password) {
        sendKeys(firstNameInput, firstName);
        sendKeys(lastNameInput, lastName);
        sendKeys(emailInput, email);
        sendKeys(telephoneInput, telephone);
        sendKeys(passwordInput, password);
        sendKeys(confirmPasswordInput, password);
        click(privacyPolicyCheckbox);
        click(continueButton);
    }

    public boolean isRegistrationSuccessful() {
        return successMessage.isDisplayed();
    }
}