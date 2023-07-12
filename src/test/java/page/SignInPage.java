package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "login")
    WebElement signInButton;

    public void clickOnSignInButton(){signInButton.click();}

    @FindBy(id = "email")
    WebElement emailBox;

    public void setEmailBox(){emailBox.sendKeys("test@test.pl");}

    @FindBy(id = "passwd")
    WebElement passwordBox;

    public void setPasswordBox(){passwordBox.sendKeys("test");}

    @FindBy(linkText = "Sign in")
    WebElement logButton;

    public void clickLogButton(){logButton.click();}

    @FindBy(id = "SubmitCreate")
    WebElement createAccount;

    public void clickCreateAccount(){createAccount.click();}

    @FindBy(css = ".alert-danger" )
    WebElement redAlertBox;

    public boolean isRedAlertBoxDisplayed(){
        boolean isDisplayed = false;
        try {
            isDisplayed = redAlertBox.isDisplayed();
        } catch (NoSuchElementException e){}
        return isDisplayed;
    }


}
