package show.util;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import io.cucumber.java.Scenario;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import show.constants.LogConstants;
import show.constants.ResourcePathConstants;
//import show.ui.Locators.CommonLocators;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class UtilFactory extends PageObject {

    public WebDriver driver;
    String browser;

    public String getFeatureName(Scenario scenario) {
        String featureFilePath = String.valueOf(scenario.getUri());
        return featureFilePath.substring((featureFilePath.lastIndexOf('/') + 1), featureFilePath.indexOf('.'));
    }

    private static Logger logger = LoggerFactory.getLogger(UtilFactory.class);
    DesiredCapabilities capability = new DesiredCapabilities();

    public UtilFactory(WebDriver driver) {
        driver = super.getDriver();
    }

    public void waitForElementToBeVisible(String webElement, String elementType) {
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        WebDriverWait wait = new WebDriverWait(super.getDriver(), Duration.ofSeconds(5));
        if (elementType.equals("xpath")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElement)));
        } else if (elementType.equals("css")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(webElement)));
        } else if (elementType.equals("id")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(webElement)));
        }
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void highlight(WebElement element) {
        driver = super.getDriver();
        executeScript(driver, "arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid red;");
    }

    public Object executeScript(WebDriver driver, String javascriptToExecute, Object... parameters) {
        return ((JavascriptExecutor) driver).executeScript(javascriptToExecute, parameters);
    }

    public void scrollToElement(WebElement element) {
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        driver = super.getDriver();
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void scrollToTop() {
        driver = super.getDriver();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-300)");
    }

    public String readJSON(String featureName, String scenarioNo, String key, String fileName) {
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        JSONParser parser = new JSONParser();
        try {
            String dataFileEnvPath = ResourcePathConstants.JSON_DATA_FILE_PATH + System.getProperty("env");
            String dataFilePath = dataFileEnvPath + "/" + fileName;
            java.io.File dataFile = new java.io.File(dataFilePath);
            if (!dataFile.exists()) {
                logger.error("Given environment data file not found at location = " + dataFilePath);
                Assert.fail("Given environment data file not found at location=" + dataFilePath);
            }
            Object objectFromDataFile = parser.parse(new FileReader(dataFilePath));
            JSONObject jsonObjectFromDataFile = (JSONObject) objectFromDataFile;
            JSONObject featureObject = (JSONObject) jsonObjectFromDataFile.get(featureName);
            System.out.println("featureObject----->" + featureObject);
            JSONObject scenarioObject = (JSONObject) featureObject.get(scenarioNo);
            logger.info("Feature Name: " + featureName + " Scenario No: " + scenarioNo + " Key: " + key
                    + " value returned: " + (String) scenarioObject.get(key));
            logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
            return (String) scenarioObject.get(key);
        } catch (FileNotFoundException e) {
            logger.error(LogConstants.FILE_NOT_FOUND_EXCEPTION + e
                    + Thread.currentThread().getStackTrace()[1].getMethodName());
        } catch (IOException e) {
            logger.error(LogConstants.IO_EXCEPTION + e + Thread.currentThread().getStackTrace()[1].getMethodName());
        } catch (ParseException e) {
            logger.error(LogConstants.PARSE_EXCEPTION + e + Thread.currentThread().getStackTrace()[1].getMethodName());
        }
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
        return "Error while getting json value";
    }

//    public String readTestDataFromJSON(Scenario scenario, String scenarioNo, String key) {
//        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
//        String fileName = ResourcePathConstants.JSON_DATA_FILE_PATH + System.getProperty("env") + "/"
//                + getFeatureName(scenario) + ".json";
//        java.io.File dataFile = new java.io.File(fileName);
//        if (!dataFile.exists()) {
//            logger.error("Given environment data file not found at location = " + fileName);
//            Assert.fail("Given environment data file not found at location=" + fileName);
//        }
//        JSONParser parser = new JSONParser();
//        try {
//            Object objectFromDataFile = parser.parse(new FileReader(fileName));
//            JSONObject jsonObjectFromDataFile = (JSONObject) objectFromDataFile;
//            JSONObject scenarioObject = (JSONObject) jsonObjectFromDataFile.get(scenarioNo);
//            logger.info(" Scenario No: " + scenarioNo + " Key: " + key + " value returned: " + scenarioObject.get(key));
//            logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
//            return (String) scenarioObject.get(key);
//        } catch (FileNotFoundException e) {
//            logger.error(LogConstants.FILE_NOT_FOUND_EXCEPTION + e
//                    + Thread.currentThread().getStackTrace()[1].getMethodName());
//        } catch (IOException e) {
//            logger.error(LogConstants.IO_EXCEPTION + e + Thread.currentThread().getStackTrace()[1].getMethodName());
//        } catch (ParseException e) {
//            logger.error(LogConstants.PARSE_EXCEPTION + e + Thread.currentThread().getStackTrace()[1].getMethodName());
//        }
//        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
//        return "Error while getting json value";
//    }
}
//    public void scrollToRight() {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            logger.error(
//                    LogConstants.INTERRUPT_EXCEPTION + e + Thread.currentThread().getStackTrace()[1].getMethodName());
//        }
//        WebElement myElement = (new WebDriverWait(super.getDriver(),Duration.ofSeconds(5)))
//                .until(ExpectedConditions.elementToBeClickable(By.xpath(CommonLocators.SCROLL_HARIZONTAL)));
//        Actions move = new Actions(super.getDriver());
//        move.dragAndDropBy(myElement, 200, 18).build().perform();
//    }


//    public void waitUntilLoaderGoes() {
//        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
//        try {
//            WebElementFacade loader = find(By.xpath(CommonLocators.LOADER_PATH));
//            if (loader.isCurrentlyVisible()) {
//                loader.waitUntilNotVisible();
//            }
//        } catch (Exception e) {
//            logger.warn("NO LOADER FOUND");
//        }
//        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
//    }

//    public void scrollElement(WebElementFacade element) {
//        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
//        while (!element.isCurrentlyVisible()) {
//            scrollToRight();
//        }
//        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//}