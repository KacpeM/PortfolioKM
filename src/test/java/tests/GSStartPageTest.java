package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.GSBasePage;


public class GSStartPageTest extends GSBaseTest {
    private GSBasePage gsBasePage;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        gsBasePage = new GSBasePage(driver);
    }

    @Test
    public void ShouldStartPageShowCorrectTitle() {
        Assertions.assertThat(driver.getTitle()).isEqualTo("Generic Shop – Just another web shop");
    }

    @Test
    public void ShouldProductsAddedToTopCart() {
        gsBasePage.clickOnWantedButton();
        gsBasePage.clickOnfittBeltsCategory();
        gsBasePage.addCartClick();
        WebElement topCart = driver.findElement(By.className("top-cart"));
        Assertions.assertThat(topCart.equals("35.00"));
    }

    @Test
    public void ShouldNotSendInvalidBillingDetails(){
        gsBasePage.clickOnWantedButton();
        gsBasePage.clickOnfittBeltsCategory();
        gsBasePage.quantityBox();
        gsBasePage.addCartClick();
        gsBasePage.topCartButtonClick();
        gsBasePage.clickOnDashiconsPlus();
        gsBasePage.clickOnUpdateCartButton();
        gsBasePage.clickOnCheckOutButton();
        gsBasePage.setFirstName();
        gsBasePage.selectCountry();
        gsBasePage.setAddress();
        gsBasePage.setApartmentNo();
        gsBasePage.setPostCode();
        gsBasePage.setCity();
        gsBasePage.setPhoneNo();
        gsBasePage.setEmailAddress();
        gsBasePage.setPaymentMethod();
        gsBasePage.placeOrderButton();
        WebElement alertBox = driver.findElement(By.xpath("//*[@id=\"post-7\"]/div[2]/form[3]/div[1]"));
        Assertions.assertThat(alertBox.isEnabled()).isTrue();
    }

    @Test
    public void ShouldAddQualityBeforePay() {
        gsBasePage.clickOnWantedButton();
        gsBasePage.clickOnfittBeltsCategory();
        gsBasePage.quantityBox();
        gsBasePage.addCartClick();
        gsBasePage.topCartButtonClick();
        gsBasePage.clickOnDashiconsPlus();
        gsBasePage.clickOnUpdateCartButton();
        WebElement totalPrice = driver.findElement(By.xpath("//*[@id=\"post-6\"]/div[2]/form/table/tbody/tr[1]/td[6]/span"));
        Assertions.assertThat(totalPrice.equals(70)).isTrue();
    }

    @Test
    public void IsShoppingCartWorkCorrect() {

        gsBasePage.clickOnWantedButton();
        gsBasePage.clickOnfittBeltsCategory();
        gsBasePage.quantityBox();
        gsBasePage.addCartClick();
        gsBasePage.topCartButtonClick();
        gsBasePage.clickOnDashiconsPlus();
        gsBasePage.clickOnUpdateCartButton();
        gsBasePage.clickOnCheckOutButton();
        gsBasePage.setFirstName();
        gsBasePage.setLastName();
        gsBasePage.selectCountry();
        gsBasePage.setAddress();
        gsBasePage.setApartmentNo();
        gsBasePage.setPostCode();
        gsBasePage.setCity();
        gsBasePage.setPhoneNo();
        gsBasePage.setEmailAddress();
        gsBasePage.setPaymentMethod();
        gsBasePage.placeOrderButton();
        WebElement orderReceived = driver.findElement(By.className("col-md-12"));
        Assertions.assertThat(orderReceived.isEnabled()).isTrue();
    }

}
