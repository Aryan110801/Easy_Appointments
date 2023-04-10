package show.ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import show.constants.LogConstants;
import show.ui.Locators.CustomerLocators;
import show.ui.Locators.ServiceLocators;
import show.util.UtilFactory;

public class CustomersPage extends PageObject {

    private static Logger logger = LoggerFactory.getLogger(CustomersPage.class);

    public WebDriver driver;
    private UtilFactory utilFactory;

    public CustomersPage() {
        driver = super.getDriver();
        utilFactory = new UtilFactory(driver);
    }

    @FindBy(xpath = CustomerLocators.Customers)
    private WebElement customer;

    @FindBy(xpath = CustomerLocators.Add)
    private WebElement add;

    @FindBy(xpath = CustomerLocators.F_Name)
    private WebElement f_name;

    @FindBy(xpath = CustomerLocators.L_Name)
    private WebElement l_name;

    @FindBy(xpath = CustomerLocators.Email)
    private WebElement email;

    @FindBy(xpath = CustomerLocators.Phone)
    private WebElement phone;

    @FindBy(xpath = CustomerLocators.Address)
    private WebElement address;

    @FindBy(xpath = CustomerLocators.City)
    private WebElement city;

    @FindBy(xpath = CustomerLocators.Zip_Code)
    private WebElement pin_code;

    @FindBy(xpath = CustomerLocators.Language)
    private WebElement language;

    @FindBy(xpath = CustomerLocators.TimeZone)
    private WebElement time_zone;

    @FindBy(xpath = CustomerLocators.Save)
    private WebElement save;

    public void enterdetails(){
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        utilFactory.highlight(customer);
        customer.click();
        utilFactory.highlight(add);
        add.click();
        utilFactory.highlight(f_name);
        f_name.clear();
        f_name.sendKeys("Aryan");
        utilFactory.highlight(l_name);
        l_name.clear();
        l_name.sendKeys("Pandey");
        utilFactory.highlight(email);
        email.clear();
        email.sendKeys("aryanpandey7308@gmail.com");
        utilFactory.highlight(phone);
        phone.sendKeys("7096930275");
        utilFactory.highlight(address);
        address.sendKeys("F-102,Vatrak,Sardar Heights,Tithal Road,Valsad");
        utilFactory.highlight(city);
        city.clear();
        city.sendKeys("Valsad");
        utilFactory.highlight((pin_code));
        pin_code.clear();
        pin_code.sendKeys("396001");
        utilFactory.highlight(language);
        language.click();
        utilFactory.highlight(time_zone);
        time_zone.click();
        utilFactory.highlight(save);
        save.click();
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
