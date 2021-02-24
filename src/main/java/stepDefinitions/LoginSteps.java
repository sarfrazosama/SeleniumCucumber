package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;
import pageObjects.NavigationPage;

public class LoginSteps {

    public WebDriver driver;
    public LoginPage login;

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

}
