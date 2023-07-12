package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.BasePage;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StartPageTest extends BaseTest {
    private BasePage basePage;
    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        basePage = new BasePage(driver);
    }

    @Test
    public void isPageTitleCorrectTest() {

        Assertions.assertThat(driver.getTitle()).isEqualTo("My Store");

    }

    @Test
    public void isPhoneShopCorrect(){

        WebElement phoneNumber = driver.findElement(By.className("shop-phone"));

        Assertions.assertThat(phoneNumber.getText()).isEqualTo("Call us now: 0123-456-789");

    }

    @Test
    public void isHomePageWorkCorrectTest() {

        List<WebElement> productNames = driver.findElements(By.cssSelector("#homefeatured .product-name"));

        List<WebElement> productsWithEmptyName = productNames.stream()
                .filter(el -> el.getText().isEmpty())
                .collect(Collectors.toList());

        assertThat(productsWithEmptyName).isEmpty();
    }

    @Test
    public void shouldEmptySearchReturnError() {

        basePage.searchButton();
        WebElement orangeAlert = driver.findElement(By.className("alert-warning"));

        Assertions.assertThat(orangeAlert.isDisplayed()).isTrue();
    }

    @Test
    public void shouldSearchWorkCorrectly() {

        WebElement searchBox = driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys("t-shirts");
        basePage.searchButton();

        List<WebElement> productsList = driver.findElements(By.id("center_column"));
        List<WebElement> productWithEmptyPlace = productsList.stream()
                .filter(el -> el.getText().isEmpty())
                .collect(Collectors.toList());
        Assertions.assertThat(productWithEmptyPlace).isEmpty();
    }

}
