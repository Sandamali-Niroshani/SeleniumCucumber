package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    /**
     *  A static block is used for one-time initialization of static resources when the class is
     *  first loaded into memory.
     *  perfect for driver path setup.
     */

    static {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
    }

    /**
     * TestContext is shared across Step Definitions,
     * it ensures the same WebDriver instance is used throughout a scenario.
     * ThreadLocal is useful when parallel execution is involved,gets its own separate WebDriver instance.
     *
     */

private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

        public static WebDriver getDriver() {

            //browser come from property file
            String browser_properties = ConfigManager.getBrowser();

            //browser come from cmd maven command
            String browser_maven=System.getProperty("browser");

            // result = testCondition ? value1 : value2
            String browser = browser_maven!=null ? browser_maven : browser_properties;

            if (driver.get() == null) {
                if (browser.equalsIgnoreCase("chrome")) {
                    driver.set(new ChromeDriver());
                }
                if (browser.equalsIgnoreCase("firefox")) {
                    driver.set(new FirefoxDriver());
                }
            }
            driver.get().manage().window().maximize();
            return driver.get();
        }


    }


