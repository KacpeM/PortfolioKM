package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {


    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "alert-danger" )
    WebElement redAlertBox;

    public boolean isRedAlertBoxDisplayed(){
        boolean isDisplayed = false;
        try {
            isDisplayed = redAlertBox.isDisplayed();
        } catch (NoSuchElementException e){}
        return isDisplayed;
    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsButton;

    public void clickOnContactUsButton(){
        contactUsButton.click();
    }

    @FindBy(id = "submitMessage")
    WebElement submitButton;

    public void  clickOnSubmitButton(){submitButton.click();}

    @FindBy(id  = "email")
    WebElement email;

    public void sendEmail(){email.sendKeys("demoTest@test.test");}

    @FindBy(id = "email")
    WebElement invalidEmail;

    public void sendInvalidEmail(){invalidEmail.sendKeys("demoTest@");}

    @FindBy(id = "id_order")
    WebElement order;

    public void sendOrder(){order.sendKeys("SignInProblem");}

    @FindBy(className = "button-search")
    WebElement search;

    public void searchButton(){search.click();}
}


