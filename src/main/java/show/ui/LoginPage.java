package show.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import show.constants.LogConstants;
//import show.constants.URLConstants;
import show.constants.URLConstants;
import show.ui.Locators.LoginLocators;
import show.util.UtilFactory;

//@NamedUrls(
//        {
//                @NamedUrl(name = "dev.url", url = URLConstants.dev_url),
//                @NamedUrl(name = "stage.url", url = URLConstants.stage_url),
//                @NamedUrl(name = "qa.url", url = URLConstants.qa_url)
//        }
//)
public class LoginPage extends PageObject {

    private static Logger logger = LoggerFactory.getLogger(LoginPage.class);

    public WebDriver driver;
    private UtilFactory utilFactory;

    public LoginPage(){
        driver = super.getDriver();
        utilFactory = new UtilFactory(driver);
    }

    @FindBy(xpath = LoginLocators.UserName)
    private WebElement Username;

    @FindBy(xpath = LoginLocators.PassWord)
    private WebElement Password;

    @FindBy(xpath = LoginLocators.Login)
    private WebElement Login;

    @FindBy(xpath = LoginLocators.Home_Page)
    private WebElement home_page;

    public void openUrl() {
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
//        open(System.getProperty("env")+".url",withParameters("login"));
        logger.info(URLConstants.setUrl());
        super.openUrl(URLConstants.setUrl());
//        common.waitForPageLoaded(super.getDriver());
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void enterUserCredentials(String username, String password) {
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        Username.clear();
        Password.clear();
        utilFactory.highlight(Username);
        utilFactory.highlight(Password);
        Username.click();
        Username.sendKeys(username);
        String a = getDriver().findElement(By.xpath(LoginLocators.UserName)).getText();
        System.out.println("UserPass"+a);
        Password.click();
        Password.sendKeys(password);
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void getLoginButton() {
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        utilFactory.highlight(Login);
        Login.click();
        try {
            java.util.concurrent.TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        common.waitForPageLoaded(super.getDriver());
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
    public String getMessage(String messageData) {
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        utilFactory.waitForElementToBeVisible(LoginLocators.Error, "xpath");
        WebElementFacade message = find(By.xpath(LoginLocators.Error));
        utilFactory.highlight(message);
        String messageText = message.getText();
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
        return messageText;
    }

    public String pop_up(String messageInvalid) {
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        utilFactory.waitForElementToBeVisible(LoginLocators.PopUp, "xpath");
        WebElementFacade message = find(By.xpath(LoginLocators.PopUp));
        utilFactory.highlight(message);
        String messageText = message.getText();
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
        return messageText;
    }

    public void success(){
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        home_page.click();
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
