package support;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;
import pages.LoginPage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.lang.System.exit;


public class Base {

    public static Utilities utils=new Utilities();
    public static String currentFilePath=System.getProperty("user.dir")+"\\src\\main\\resources\\";
    public static Map<String,String> configData=new HashMap<String, String>();
    public Logger logger = LogManager.getLogger(Base.class);
    String  methodName;
    public static WebDriver driver;


    @BeforeSuite
    public void beforeSuite(){
        try {
            methodName="beforeSuite";
            configData = utils.readPropertiesFile(currentFilePath + "config.properties");
            logger.info(String.format("successfully read config properties file %s",methodName));
            if (configData.get("Browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", currentFilePath+"drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                logger.info(String.format("browser successfully initialized in %s",methodName));
            }
        }catch(Exception ex){
            logger.error(String.format("error in method '%s' and its description is '%s'",methodName,ex.getMessage()));
            exit(0);
        }
    }

    @BeforeClass
    public void beforeClass(){
        methodName="beforeClass";
        try{
            String url=configData.get("URL");
            driver.get(url);
            logger.info(String.format("opened %s in %s",url,methodName));
            LoginPage.enterUserName();
            LoginPage.enterPassword();
            LoginPage.clickLogin();
        }catch(Exception ex){
            logger.error(String.format("error in method '%s' and its description is '%s'",methodName,ex.getMessage()));
        }
    }

    @AfterClass
    public void afterClass(){
        methodName="afterClass";
        try{
            HomePage.clickLogout();
            logger.info("Logged out successfully");
        }catch(Exception ex){
            logger.error(String.format("error in method '%s' and its description is '%s'",methodName,ex.getMessage()));
        }
    }

    @AfterSuite
    public void afterSuite(){
        methodName="afterSuite";
        try {
            driver.quit();
            logger.info("Browser closed successfully");
        }
        catch(Exception ex){
            logger.error(String.format("error in method '%s' and its description is '%s'",methodName,ex.getMessage()));
        }
    }
}
