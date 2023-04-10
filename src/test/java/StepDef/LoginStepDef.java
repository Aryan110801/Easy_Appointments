package StepDef;

import io.cucumber.java.en.*;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import show.constants.FeatureNameConstants;
import show.constants.LogConstants;
//import show.ui.DashboardPage;
import show.ui.LoginPage;
import show.util.UtilFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LoginStepDef extends PageObject {
//WebDriver driver;

    private static Logger logger = LoggerFactory.getLogger(LoginStepDef.class);
//    @Steps
//    StepLoginPage stepLoginPage;
//
//    @Steps
//    StepDashboardPage stepDashboardPage;



    public WebDriver driver;
    LoginPage loginPageBusinessLogic;
//    DashboardPage dashboardPage;
    UtilFactory utilFactory;

    public LoginStepDef(){
        driver = super.getDriver();
        new UtilFactory(driver);
    }

    @Given("User is on home page of website")
    public void userIsOnHomePageOfWebsite() {
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.info("User is on home page of website");
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());

        System.out.println("hello");
    }

    @When("User enters username and password")
    public void user_enters_username_and_password(List<List<String>> login_credentials) {
        loginPageBusinessLogic.openUrl();
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        loginPageBusinessLogic.enterUserCredentials(
                utilFactory.readJSON(FeatureNameConstants.LOGIN, login_credentials.get(0).get(0), "username", "login.json"),
                utilFactory.readJSON(FeatureNameConstants.LOGIN, login_credentials.get(0).get(0), "password", "login.json"));
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @And("User clicks on Login button")
    public void user_clicks_on_button(){
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        loginPageBusinessLogic.getLoginButton();
//        stepLoginPage.login();
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Then("User gets alert message")
    public void user_gets_alert_message(List<List<String>> message){
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.info("Scenario Name  :: " + message.get(0).get(0));
        String a = message.get(0).get(0);
        if (a.equals("Alert")) {
            String expectedMessage = utilFactory.readJSON(FeatureNameConstants.LOGIN, message.get(0).get(0),
                    "message", "login.json");
            assertEquals(expectedMessage, loginPageBusinessLogic.getMessage(expectedMessage));
        } else if (a.equals("Invalid credentials")) {
            String expectedMessage = utilFactory.readJSON(FeatureNameConstants.LOGIN, message.get(0).get(0),
                "message", "login.json");
        assertEquals(expectedMessage, loginPageBusinessLogic.pop_up(expectedMessage));
        }
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

//    @Then("User gets pop-up message")
//    public void user_gets_pop_up_message(List<List<String>> message){
//        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
//        logger.info("Scenario Name  :: " + message.get(0).get(0));
//        String expectedMessage = utilFactory.readJSON(FeatureNameConstants.LOGIN, message.get(0).get(0),
//                "message", "login.json");
//        assertEquals(expectedMessage, loginPageBusinessLogic.pop_up(expectedMessage));
////        stepLoginPage.alert_msg();
//        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
//    }

//    @Then("User should successfully login")
//    public void userShouldSuccessfullyLogin() throws InterruptedException {
////        stepDashboardPage.success();
//    }

    @Then("User should successfully login")
    public void successfull() {
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        loginPageBusinessLogic.success();
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

}