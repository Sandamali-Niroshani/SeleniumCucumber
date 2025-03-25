package utility;

import org.openqa.selenium.WebDriver;

//Acts as a container to store objects that need to be shared across different step definition classes.
//TestContext makes dependency injection smoother.
//Hold shared instances
public class TestContext {

    private WebDriver driver;
    public WebDriver getDriver(){
        return driver;
    }
    public void setDriver(WebDriver driver){
        this.driver = driver;
    }



}
