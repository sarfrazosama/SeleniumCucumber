package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage {

    public WebDriver driver;

    public NavigationPage(WebDriver driver){
        this.driver = driver;
    }

    private String ADMIN_AREA = "//*[@id=\"ph-topic\"]/div[2]/div/div[1]/div[2]/div/div/a[1]";
    private String CUSTOMERS_MENU_XPATH = "/html/body/div[3]/div[2]/div/ul/li[4]";
    private String CUSTOMERS_MENU_ITEM_XPATH = "/html/body/div[3]/div[2]/div/ul/li[4]/ul/li[1]";

    public void clickAdminArea(){
        driver.findElement(By.xpath(ADMIN_AREA)).click();
    }

    public void navigateCustomersMenu(){
        driver.findElement(By.xpath(CUSTOMERS_MENU_XPATH)).click();
    }

    public void navigateCustomerMenuItem(){
        driver.findElement(By.xpath(CUSTOMERS_MENU_ITEM_XPATH)).click();
    }
}
