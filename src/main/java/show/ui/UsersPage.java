package show.ui;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import show.constants.LogConstants;
import show.ui.Locators.CustomerLocators;
import show.ui.Locators.UsersLocators;
import show.util.UtilFactory;

public class UsersPage extends PageObject {

    private static Logger logger = LoggerFactory.getLogger(UsersPage.class);

    public WebDriver driver;
    private UtilFactory utilFactory;

    public UsersPage() {
        driver = super.getDriver();
        utilFactory = new UtilFactory(driver);
    }
    @FindBy(xpath = UsersLocators.Users)
    private WebElement user;

    @FindBy(xpath = UsersLocators.Add)
    private WebElement add;

    @FindBy(xpath = UsersLocators.FName)
    private WebElement fname;

    @FindBy(xpath = UsersLocators.LName)
    private WebElement lname;

    @FindBy(xpath = UsersLocators.Email)
    private WebElement email;

    @FindBy(xpath = UsersLocators.Phone_No)
    private WebElement phone;

    @FindBy(xpath = UsersLocators.UserName)
    private WebElement username;

    @FindBy(xpath = UsersLocators.Password)
    private WebElement pass;

    @FindBy(xpath = UsersLocators.Re_Password)
    private WebElement re_pass;

    @FindBy(xpath = UsersLocators.Calendar)
    private WebElement cal;

    @FindBy(xpath = UsersLocators.Cal_Table)
    private WebElement cal_table;

    @FindBy(xpath = UsersLocators.TimeZone)
    private WebElement time_zone;

    @FindBy(xpath = UsersLocators.Sel_Timezone)
    private WebElement sel_time_zone;

    @FindBy(xpath = UsersLocators.Save)
    private WebElement save;

public void enterdetails(String F_Name,String L_Name,String E_mail,String PHONE_No,String USERNAME,String PASSWORD,String RE_PASSWORD){
    logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
    utilFactory.highlight(user);
    user.click();
    utilFactory.highlight(add);
    add.click();
    utilFactory.highlight(fname);
    fname.sendKeys(F_Name);
    utilFactory.highlight(lname);
    lname.sendKeys(L_Name);
    utilFactory.highlight(email);
    email.sendKeys(E_mail);
    utilFactory.highlight(phone);
    phone.sendKeys(PHONE_No);
    utilFactory.highlight(username);
    username.sendKeys(USERNAME);
    utilFactory.highlight(pass);
    pass.sendKeys(PASSWORD);
    utilFactory.highlight(re_pass);
    re_pass.sendKeys(RE_PASSWORD);
    utilFactory.highlight(cal);
    cal.click();
    utilFactory.highlight(cal_table);
    cal_table.click();
    utilFactory.highlight(time_zone);
    time_zone.click();
    utilFactory.highlight(sel_time_zone);
    sel_time_zone.click();
    utilFactory.highlight((save));
    save.click();
    logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
}
}
