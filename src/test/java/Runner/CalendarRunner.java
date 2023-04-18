package Runner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty" }, features = { "C:\\Users\\Aryan.Pandey\\Downloads\\Demo-automation\\Easy_Appointments\\src\\test\\resources\\features\\calendar.feature" }, glue = {"StepDef"})

public class CalendarRunner {
}
