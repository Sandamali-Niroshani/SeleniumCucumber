package utility;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Hooks {

    private TestContext testContext;

    //Dependency injection. call textContext class inside construtor.
    public Hooks(TestContext testContext){
    this.testContext = testContext;
    }

    private WebDriver driver;


    //BeforeAll belongs to Junit, We are using TestNG but cannot call TestNG annotation here, because Hooks not identified it.
    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        testContext.setDriver(driver); // Store driver in PicoContainer

        System.out.print("driver instance:"+driver.hashCode());
        String baseUrl = ConfigManager.getApplicationURL();
        testContext.getDriver().get(baseUrl);
    }

// driver stored in TestContext should be used for quitting
    @After
    public void quiteDriver() {
        if (testContext.getDriver() != null) {
            testContext.getDriver().quit();
            testContext.setDriver(null); // Ensure it is removed after quitting
        }
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException
    {
        WebDriver driver = testContext.getDriver();
        if(scenario.isFailed())
        {
            //screenshot
            File sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            //convert file format into byte format - use common.io (File utils available in apache common.io package)
            //mention where screenshot is stored under extent.properties file. Take screenshot from that location and attached
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");
        }

    }

}
