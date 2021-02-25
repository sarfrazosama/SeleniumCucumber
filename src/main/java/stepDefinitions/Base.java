package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.NavigationPage;

public class Base {

    public WebDriver driver;
    public LoginPage login;
    public NavigationPage nav;
    public AddCustomerPage addCustomer;

    //Created for generating random string for unique email id
    public static String randomString(){
        String stringGen = RandomStringUtils.randomAlphabetic(5);
        return stringGen;
    }
}
