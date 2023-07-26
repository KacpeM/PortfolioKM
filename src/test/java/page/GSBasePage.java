package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GSBasePage {
    public GSBasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"menu-item-128\"]/a")
    WebElement wantedButton;

    public void clickOnWantedButton() {
        wantedButton.click();
    }

    @FindBy(xpath = "//*[@id=\"page\"]/div/div/div[2]/div/ul/li[1]/a[1]/h2")
    WebElement fittBeltsCategory;

    public void clickOnfittBeltsCategory() {
        fittBeltsCategory.click();
    }

    @FindBy(name = "add-to-cart")
    WebElement addCart;

    public void addCartClick() {
        addCart.click();
    }

    @FindBy(className = "top-cart")
    WebElement topCartButton;

    public void topCartButtonClick() {
        topCartButton.click();
    }

    @FindBy(name = "quantity")
    WebElement quantity;

    public void quantityBox() {
        quantity.clear();
        quantity.sendKeys("1");
    }

    @FindBy(xpath = "//*[@id=\"post-6\"]/div[2]/form/table/tbody/tr[1]/td[5]/div/div/a[2]/span")
    WebElement dashiconsPlus;

    public void clickOnDashiconsPlus() {
        dashiconsPlus.click();
    }

    @FindBy(className = "button")
    WebElement updateCart;

    public void clickOnUpdateCartButton() {
        updateCart.click();
    }

    @FindBy(xpath = "//*[@id=\"post-6\"]/div[2]/form/table/tbody/tr[1]/td[6]/span")
    WebElement totalPrice;

    public void totalPriceButton() {
    }


    @FindBy(className = "wc-proceed-to-checkout")
    WebElement checkoutButton;

    public void clickOnCheckOutButton(){
        checkoutButton.click();
    }

    @FindBy (id = "billing_first_name")
    WebElement firstName;

    public void setFirstName(){
        firstName.sendKeys("Kacper");
    }

    @FindBy (id = "billing_last_name")
    WebElement lastName;

    public void setLastName(){
        lastName.sendKeys("Testowy");
    }

    @FindBy (xpath = "//*[@id=\"billing_country\"]/option[177]")
    WebElement country;

    public void selectCountry(){
        country.click();
    }

    @FindBy (id = "billing_address_1")
    WebElement address;

    public void setAddress(){
        address.sendKeys("Dragonery 50");
    }

    @FindBy (id = "billing_address_1")
    WebElement apartment;

    public void setApartmentNo(){
        apartment.sendKeys("69");
    }

    @FindBy (id = "billing_postcode")
    WebElement postCode;

    public void setPostCode(){
        postCode.sendKeys("00-111");
    }

    @FindBy (xpath = "//*[@id=\"billing_city\"]")
    WebElement city;

    public void setCity(){
        city.sendKeys("Mordor");
    }

    @FindBy (xpath = "//*[@id=\"billing_phone\"]")
    WebElement phone;

    public void setPhoneNo(){
        phone.sendKeys("987654321");
    }

    @FindBy (id = "billing_email")
    WebElement email;

    public void setEmailAddress(){
        email.sendKeys("kacper@testowy.test");
    }

    @FindBy (xpath = "//*[@id=\"payment_method_cod\"]")
    WebElement payment;

    public void setPaymentMethod(){
        payment.click();
    }

    @FindBy (id = "place_order")
    WebElement placeOrder;

    public void placeOrderButton(){
        placeOrder.click();
    }





}