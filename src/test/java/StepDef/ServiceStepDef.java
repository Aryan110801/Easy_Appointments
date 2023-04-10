package StepDef;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import show.constants.LogConstants;
import show.ui.LoginPage;
import show.ui.ServicePage;
import show.util.UtilFactory;

import java.util.concurrent.TimeUnit;

public class ServiceStepDef extends PageObject {
UtilFactory utilFactory = new UtilFactory(super.getDriver());
public WebDriver driver;
LoginPage loginpagebusinesslogic;


    @Managed
    ServicePage servicePage;
    Scenario scenario;

    private static Logger logger = LoggerFactory.getLogger(ServiceStepDef.class);

    @Then("User should navigate to Services Page")
    public void userShouldNavigateToServicesPage() {
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.info("Services page");
        servicePage.enterdetails();
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

}
