package support;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;
import java.util.Map;


public class Base {

    public Utilities utils=new Utilities();
    public static String filePath=System.getProperty("user.dir");
    public Map<String,String> configData=new HashMap<String, String>();
    public static Logger logger = LogManager.getLogger(Base.class);

    @BeforeSuite
    public void beforeSuite(){
        try {
            configData = utils.readPropertiesFile(filePath + "\\src\\main\\resources\\config.properties");
            if (configData.get("Browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", filePath + "\\src\\main\\resources\\drivers\\chromedriver.exe");
            }
        }catch(Exception ex){
            logger.error(ex.getMessage());
        }
    }

}
