package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.NavigationPage;

public class Steps extends Base{

    //*************************************Login to the Application*****************************************************
    @Given("Launch chrome browser")
    public void launch_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        login = new LoginPage(driver);
    }

    @When("Open nop commerce home page {string}")
    public void open_nop_commerce_home_page(String url) {
        driver.get(url);
    }

    @When("User enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        login.enterEmail(email);
        login.enterPassword(password);
    }

    @When("Click on Login")
    public void click_on_login() {
        login.clickLogin();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            Assert.assertTrue(false);
        }
        else {
            Assert.assertEquals(title,driver.getTitle());
        }
    }

    @When("User click on Logout")
    public void user_click_on_logout() throws InterruptedException {
        login.clickLogout();
        Thread.sleep(3000);
    }

    @Then("Close the browser")
    public void close_the_browser() {
        driver.quit();
    }

    //**********************************************Add New Customer****************************************************
    @Then("User can view dashboard")
    public void user_can_view_dashboard() {
        addCustomer = new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addCustomer.getPageTitle());
    }

    @When("User click on Customers menu")
    public void user_click_on_customers_menu() throws InterruptedException {
        nav = new NavigationPage(driver);
        nav.navigateCustomersMenu();
        Thread.sleep(3000);
    }

    @When("Click on Customers Menu Item")
    public void click_on_customers_menu_item() throws InterruptedException {
        nav.navigateCustomerMenuItem();
        Thread.sleep(2000);
    }

    @When("Click on Add New button")
    public void click_on_add_new_button() throws InterruptedException {
        addCustomer.clickAddNewBtn();
        Thread.sleep(2000);
    }

    @Then("User can view Add New Customer Page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration",addCustomer.getPageTitle());
    }

    @When("User enter Customer Info")
    public void user_enter_customer_info() {
        addCustomer.setEmail(randomString()+"@gmail.com");
        addCustomer.setPassword(randomString()+"2134");
        addCustomer.setFirstName("Roger");
        addCustomer.setLastName("Drake");
        addCustomer.selectGender("M");
        addCustomer.setCompany("Samsung");
        addCustomer.selectManagerOfVendor("Vendor 1");
    }

    @When("Click on Save button")
    public void click_on_save_button() {
        addCustomer.clickSaveBtn();
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String confirmation) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(confirmation));

    }

}
