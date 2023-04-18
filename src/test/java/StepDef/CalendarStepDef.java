package StepDef;

import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import show.constants.LogConstants;
import show.ui.CalendarPage;
import show.ui.CustomersPage;

public class CalendarStepDef extends PageObject {

    @Managed
    CalendarPage calendarPage;

    private static Logger logger = LoggerFactory.getLogger(ServiceStepDef.class);

    @Then("User should navigate to Calendar Page")
    public void userShouldNavigateToCalendarPage() {
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.info("Calendar page");
        calendarPage.enterdetails();
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
