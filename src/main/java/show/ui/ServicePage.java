package show.ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import show.constants.LogConstants;
import show.ui.Locators.ServiceLocators;
import show.util.UtilFactory;

public class ServicePage extends PageObject {

    private static Logger logger = LoggerFactory.getLogger(ServicePage.class);

    public WebDriver driver;
    private UtilFactory utilFactory;

    public ServicePage() {
        driver = super.getDriver();
        utilFactory = new UtilFactory(driver);
    }


    @FindBy(xpath = ServiceLocators.Services)
    private WebElement service;

    @FindBy(xpath = ServiceLocators.Add)
    private WebElement add;

    @FindBy(xpath = ServiceLocators.Name)
    private WebElement name;

    @FindBy(xpath = ServiceLocators.Duration)
    private WebElement duration;

    @FindBy(xpath = ServiceLocators.Price)
    private WebElement price;

    @FindBy(xpath = ServiceLocators.Currency)
    private WebElement currency;

    @FindBy(xpath = ServiceLocators.Category)
    private WebElement category;

    @FindBy(xpath = ServiceLocators.Select_Category)
    private WebElement select_category;

    @FindBy(xpath = ServiceLocators.Availabilities)
    private WebElement availability;

    @FindBy(xpath = ServiceLocators.Availability_Type)
    private WebElement availability_type;

    @FindBy(xpath = ServiceLocators.Attendants)
    private WebElement attendants;

    @FindBy(xpath = ServiceLocators.Location)
    private WebElement location;

    @FindBy(xpath = ServiceLocators.Description)
    private WebElement description;

    @FindBy(xpath = ServiceLocators.Save)
    private WebElement save;

    @FindBy(xpath = ServiceLocators.Cancel)
    private WebElement cancel;

public void enterdetails(){
    logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
    utilFactory.highlight(service);
    service.click();
    utilFactory.highlight(add);
    add.click();
    utilFactory.highlight(name);
    name.clear();
    name.sendKeys("Aryan");
    utilFactory.highlight(duration);
    duration.clear();
    duration.sendKeys("30");
    utilFactory.highlight(price);
    price.clear();
    price.sendKeys("500");
//    utilFactory.highlight(category);
//    category.click();
//    utilFactory.highlight(select_category);
//    select_category.click();
    utilFactory.highlight(availability);
    availability.click();
    utilFactory.highlight(availability_type);
    availability_type.click();
    utilFactory.highlight(attendants);
    attendants.clear();
    attendants.sendKeys("2");
    utilFactory.highlight((location));
    location.clear();
    location.sendKeys("Valsad");
    utilFactory.highlight(save);
    save.click();
    logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
}
}
