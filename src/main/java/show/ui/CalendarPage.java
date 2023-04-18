package show.ui;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import show.constants.LogConstants;
import show.ui.Locators.CalendarLocators;
import show.ui.Locators.CustomerLocators;
import show.util.UtilFactory;

public class CalendarPage extends PageObject {

    private static Logger logger = LoggerFactory.getLogger(CalendarPage.class);

    public WebDriver driver;
    private UtilFactory utilFactory;

    public CalendarPage() {
        driver = super.getDriver();
        utilFactory = new UtilFactory(driver);
    }

    @FindBy(xpath = CalendarLocators.calendar)
    private WebElement cal;

    @FindBy(xpath = CalendarLocators.appointment)
    private WebElement appoint;

    @FindBy(xpath = CalendarLocators.serve)
    private WebElement ser;

    @FindBy(xpath = CalendarLocators.serve1)
    private WebElement ser1;

    @FindBy(xpath = CalendarLocators.provider)
    private WebElement prov;

    @FindBy(xpath = CalendarLocators.select_provider)
    private WebElement prov1;

    @FindBy(xpath = CalendarLocators.fname)
    private WebElement f_name;

    @FindBy(xpath = CalendarLocators.lname)
    private WebElement l_name;

    @FindBy(xpath = CalendarLocators.email)
    private WebElement mail;

    @FindBy(xpath = CalendarLocators.phone)
    private WebElement phone_no;

    @FindBy(xpath = CalendarLocators.save)
    private WebElement Save;

    @FindBy(xpath = CalendarLocators.close)
    private WebElement Close;

    public void enterdetails(){
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        utilFactory.highlight(cal);
        cal.click();
        utilFactory.highlight(appoint);
        appoint.click();
        utilFactory.highlight(ser);
        ser.click();
        utilFactory.highlight(ser1);
        ser1.click();
        utilFactory.highlight(prov);
        prov.click();
        utilFactory.highlight(prov1);
        prov1.click();
        utilFactory.highlight(f_name);
        f_name.sendKeys("Aryan");
        utilFactory.highlight(l_name);
        l_name.sendKeys("Pandey");
        utilFactory.highlight(mail);
        mail.sendKeys("aryanpandey7308@gmail.com");
        utilFactory.highlight(phone_no);
        phone_no.sendKeys("7096930275");
        utilFactory.highlight(Save);
        Save.click();
        utilFactory.highlight(Close);
        Close.click();
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
