package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.SignInPage;

public class SignInTest extends BaseTest {
    private SignInPage signInPage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        signInPage = new SignInPage(driver);
    }


    @Test
    public void shouldSignInWithoutEmail() {

        signInPage.clickOnSignInButton();
        signInPage.setPasswordBox();
        signInPage.clickLogButton();

        Assertions.assertThat(signInPage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    public void shouldSendSignInWithInvalidEmailAddress() {

        signInPage.clickOnSignInButton();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("DemoSingInTest");
        signInPage.setPasswordBox();
        signInPage.clickLogButton();

        Assertions.assertThat(signInPage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    public void shouldSendSignInWithOutPassword() {

        signInPage.clickOnSignInButton();
        signInPage.setEmailBox();
        signInPage.clickLogButton();
        Assertions.assertThat(signInPage.isRedAlertBoxDisplayed()).isTrue();

    }

    @Test
    public void shouldNotCreateNewAccountWithoutEmail() {

        signInPage.clickOnSignInButton();
        signInPage.clickCreateAccount();
        WebElement alertButton = driver.findElement(By.id("create_account_error"));

        Assertions.assertThat(alertButton.isDisplayed()).isFalse();
    }

    @Test
    public void shouldNotCreateNewAccountWithInvalidEmail() {

        signInPage.clickOnSignInButton();
        signInPage.clickCreateAccount();
        WebElement invalidEmail = driver.findElement(By.id("email_create"));
        invalidEmail.sendKeys("test@");
        WebElement alertButton = driver.findElement(By.id("create_account_error"));

        Assertions.assertThat(alertButton.isDisplayed()).isTrue();
    }
}