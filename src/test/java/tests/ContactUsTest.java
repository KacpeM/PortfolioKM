package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;
import java.time.Duration;

public class ContactUsTest extends BaseTest {
    private BasePage basePage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        basePage = new BasePage(driver);
    }

    @Test
    public void shouldNotSubmitContactFormWhenEmailAddressIsEmpty() {

        basePage.clickOnContactUsButton();
        basePage.clickOnSubmitButton();

        Assertions.assertThat(basePage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test

    public void shouldNotSendContactFormWithInvalidAddressEmail(){
        basePage.clickOnContactUsButton();

        WebElement submit = driver.findElement(By.id("id_contact"));
        submit.click();

        WebElement topic = driver.findElement(By.cssSelector("#id_contact > option:nth-child(2)"));
        topic.click();

        basePage.sendInvalidEmail();
        basePage.sendOrder();
        WebElement massageBox = driver.findElement(By.id("message"));
        massageBox.sendKeys("the button in the SignIn tab does not work properly");
        basePage.clickOnSubmitButton();

        Assertions.assertThat(basePage.isRedAlertBoxDisplayed()).isTrue();
    }

    @Test
    public void shouldSubmitContactFormWithEmptyMessage() {

        basePage.clickOnContactUsButton();
        basePage.sendEmail();
        basePage.sendOrder();
        basePage.clickOnSubmitButton();

        Assertions.assertThat(basePage.isRedAlertBoxDisplayed()).isTrue();

    }

    @Test
    public void contactUsWorksCorrectlyTest() {

        basePage.clickOnContactUsButton();
        WebElement submit = driver.findElement(By.id("id_contact"));
        submit.click();
        WebElement topic = driver.findElement(By.cssSelector("#id_contact > option:nth-child(2)"));
        topic.click();
        basePage.sendEmail();
        basePage.sendOrder();
        WebElement massageBox = driver.findElement(By.id("message"));
        massageBox.sendKeys("the button in the SignIn tab does not work properly");
        basePage.clickOnSubmitButton();
        WebElement greenBox = driver.findElement(By.className("alert-success"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(greenBox));

        Assertions.assertThat(greenBox.isDisplayed()).isTrue();

    }
}