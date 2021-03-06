package support;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Events extends Base{
    public static Logger logger = LogManager.getLogger(Events.class);

    public static void setText(String locator, String text, String elementName){
        try{
            WebElement ele = driver.findElement(By.xpath(locator));
            ele.sendKeys(text);
            logger.info("Entered text in "+elementName);
        }catch(Exception ex){
            logger.error(String.format("error in enter text in '%s' and error description is '%s'",elementName,ex.getMessage()));
        }
    }


    public static void click(String locator, String elementName){
        try{
            WebElement ele = driver.findElement(By.xpath(locator));
            ele.click();
            logger.info("Clicked on "+elementName);
        }catch(Exception ex){
            logger.error(String.format("error while clicking on '%s' and error description is '%s'",elementName,ex.getMessage()));
        }
    }

}
