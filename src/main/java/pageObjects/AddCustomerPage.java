package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

    public WebDriver driver;

    public AddCustomerPage(WebDriver driver){
        this.driver = driver;
    }

    private String ADD_NEW_BTN_XPATH = "/html/body/div[3]/div[3]/div/form[1]/div[1]/div/a";
    private String EMAIL_ID = "Email";
    private String PASSWORD_ID = "Password";
    private String FIRST_NAME_ID = "FirstName";
    private String LAST_NAME_ID = "LastName";
    private String RD_MALE_ID = "Gender_Male";
    private String RD_FEMALE_ID = "Gender_Female";
    private String COMPANY_ID = "Company";
    private String MANAGER_VENDOR_ID = "VendorId";
    private String SAVE_BTN_NAME = "save";

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void clickAddNewBtn(){
        driver.findElement(By.xpath(ADD_NEW_BTN_XPATH)).click();
    }

    public void setEmail(String email){
        driver.findElement(By.id(EMAIL_ID)).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(By.id(PASSWORD_ID)).sendKeys(password);
    }

    public void setFirstName(String fName){
        driver.findElement(By.id(FIRST_NAME_ID)).sendKeys(fName);
    }

    public void setLastName(String lName){
        driver.findElement(By.id(LAST_NAME_ID)).sendKeys(lName);
    }

    public void selectGender(String gender){
        if(gender=="M"){
            driver.findElement(By.id(RD_MALE_ID)).click();
        }
        else if(gender=="F"){
            driver.findElement(By.id(RD_FEMALE_ID)).click();
        }
        else {
            driver.findElement(By.id(RD_MALE_ID)).click();
        }
    }

    public void setCompany(String company){
        driver.findElement(By.id(COMPANY_ID)).sendKeys(company);
    }

    public void selectManagerOfVendor(String vendor){
        WebElement vendorManager = driver.findElement(By.id(MANAGER_VENDOR_ID));
        Select select = new Select(vendorManager);
        select.selectByVisibleText(vendor);
    }

    public void clickSaveBtn(){
        driver.findElement(By.name(SAVE_BTN_NAME)).click();
    }
}
