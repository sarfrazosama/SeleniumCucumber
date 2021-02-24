package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage {

    public WebDriver driver;

    public NavigationPage(WebDriver driver){
        this.driver = driver;
    }

    private String ADMIN_AREA = "//*[@id=\"ph-topic\"]/div[2]/div/div[1]/div[2]/div/div/a[1]";

    public void clickAdminArea(){
        driver.findElement(By.xpath(ADMIN_AREA)).click();
    }
}
