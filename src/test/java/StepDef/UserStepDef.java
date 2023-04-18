package StepDef;

import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import show.constants.FeatureNameConstants;
import show.constants.LogConstants;
import show.ui.CustomersPage;
import show.ui.UsersPage;
import show.util.UtilFactory;

import java.util.List;

import static show.ui.Locators.LoginLocators.PassWord;
import static show.ui.Locators.LoginLocators.UserName;
import static show.ui.Locators.UsersLocators.*;


public class UserStepDef extends PageObject {

    UsersPage usersPage;
    UtilFactory utilFactory;

    private static Logger logger = LoggerFactory.getLogger(UserStepDef.class);

    @Then("User should navigate to Users Page")
    public void userShouldNavigateToUsersPage(List<List<String>> enter_credentials) {
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.info("Users page");
        usersPage.enterdetails(
                utilFactory.readJSON(FeatureNameConstants.USERS, enter_credentials.get(0).get(0), "F_Name", "users.json"),
                utilFactory.readJSON(FeatureNameConstants.USERS, enter_credentials.get(0).get(0), "L_Name", "users.json"),
                utilFactory.readJSON(FeatureNameConstants.USERS, enter_credentials.get(0).get(0), "E_mail", "users.json"),
                utilFactory.readJSON(FeatureNameConstants.USERS, enter_credentials.get(0).get(0), "PHONE_No", "users.json"),
                utilFactory.readJSON(FeatureNameConstants.USERS, enter_credentials.get(0).get(0), "USERNAME", "users.json"),
                utilFactory.readJSON(FeatureNameConstants.USERS, enter_credentials.get(0).get(0), "PASSWORD", "users.json"),
                utilFactory.readJSON(FeatureNameConstants.USERS, enter_credentials.get(0).get(0), "RE_PASSWORD", "users.json")
        );
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
