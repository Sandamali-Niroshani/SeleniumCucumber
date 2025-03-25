package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * executed once when the class is loaded into memory — before any object is
 * created or any static method is accessed.
 * JVM guarantees that the static block is executed only once, and it's done in a thread-safe manner.
 */
public class ConfigManager {

    //create object of prperties class
    private static Properties props;

    static {
        // './' mean home directory
        File src = new File("src/test/resources/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            props = new Properties();
            //load complete file
            props.load(fis);
        }catch (Exception e) {
            System.out.println("Exception is "+ e.getMessage());
        }
    }


    //Add different method for each variables in config.properties
    public static String getApplicationURL(){
        String url = props.getProperty("url");
        return url;
    }

    public static String getBrowser(){
        String browser  = props.getProperty("browser");
        return browser;

    }


}
