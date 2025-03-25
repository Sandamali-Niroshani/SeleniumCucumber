package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CompleteTodos;
import pages.PagesManger;
import utility.TestContext;


public class CompleteToDoStepDef {

    private WebDriver driver;
    private PagesManger pagesManager;
    private CompleteTodos completeTodos;

    //retrive webdriver from TestContext
    public CompleteToDoStepDef(TestContext testContext){
       driver = testContext.getDriver();
       pagesManager = new PagesManger(driver);
       completeTodos = pagesManager.getCompleteTodos();

    }
    @When("user mark item as complete {string}")
    public void userMarkItemAsComplete(String item) {
        completeTodos.markAsComplete(item);
    }

    @Given("user navigate to complete tab")
    public void userNavigateToCompleteTab() {
        completeTodos.navigateIntoCompleteTab();
    }

    @Then("verify item display under complete tab {string}")
    public void verifyItemDisplayUnderCompleteTab(String item) {
        completeTodos.verifyCompleteItem(item);
    }


}
