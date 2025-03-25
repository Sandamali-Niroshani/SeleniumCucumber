

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features="src/test/java/features",
        glue={"stepDefinitions","utility"},
        monochrome=true, //can see console output in plain english
       // tags="@SmokeTest or @RegressionTest",
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"
        }
        )

public class TestNgRunner extends AbstractTestNGCucumberTests {

//to execute scenarios parallel, use AbstractTestNGCucumberTests super class scenario method
    //execute scenario in parallel
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
