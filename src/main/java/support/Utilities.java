package support;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Utilities {

    public Logger logger = LogManager.getLogger(Utilities.class);
    String methodName;

    public Map<String,String> readPropertiesFile(String filePath){
        methodName="readPropertisFile";
        Map<String, String> map=new HashMap<String, String>();
        try {
            Properties prop = new Properties();
            FileInputStream inputStream = new FileInputStream(filePath);
            prop.load(inputStream);
            for (final Map.Entry<Object, Object> entry : prop.entrySet()) {
                map.put((String) entry.getKey(), (String) entry.getValue());
            }
        }catch(Exception ex){
            logger.error(String.format("error in method '%s' and its description is '%s'",methodName,ex.getMessage()));
        }
        return map;
    }

}
