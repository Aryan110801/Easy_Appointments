package show.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class URLConstants {
    private static Logger logger = LoggerFactory.getLogger(URLConstants.class);

//    public static final String dev_url = "https://demo.easyappointments.org/index.php/user/dev";
//    public static final String stage_url = "https://demo.easyappointments.org/index.php/user/stage";
//    public static final String qa_url = "https://demo.easyappointments.org/index.php/user/login";

    public static String setUrl(){
        logger.debug(LogConstants.LOG_ENTER + Thread.currentThread().getStackTrace()[1].getMethodName());
        String launchurl = "";
        if (System.getProperty("env").equals("qa")){
            launchurl = "https://demo.easyappointments.org/index.php/user/login";
        }
        else{
            logger.debug("Incorrect environment");
        }
        logger.debug(LogConstants.LOG_EXIT + Thread.currentThread().getStackTrace()[1].getMethodName());
        return launchurl;
    }
}
