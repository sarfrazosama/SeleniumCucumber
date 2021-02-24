package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private String EMAIL_ID = "Email";
    private String PASSWORD_ID = "Password";
    private String LOGIN_BTN_XPATH = "/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/input";

    public void enterEmail(String userEmail){
        WebElement email = driver.findElement(By.id(EMAIL_ID));
        email.clear();
        email.sendKeys(userEmail);
    }

    public void enterPassword(String UserPassword){
        WebElement password = driver.findElement(By.id(PASSWORD_ID));
        password.clear();
        password.sendKeys(UserPassword);
    }

    public void clickLogin(){
        driver.findElement(By.xpath(LOGIN_BTN_XPATH)).click();
    }

    public void clickLogout(){
        driver.findElement(By.linkText("Logout")).click();
    }
}
