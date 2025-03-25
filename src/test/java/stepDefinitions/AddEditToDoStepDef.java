package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AddEditTodos;
import pages.PagesManger;
import utility.TestContext;


public class AddEditToDoStepDef {

    private WebDriver driver;
    private PagesManger pagesManager;
    private AddEditTodos addEditTodos;


    public AddEditToDoStepDef(TestContext testContext) {
        this.driver = testContext.getDriver(); //Get the SAME WebDriver from Hooks
        pagesManager = new PagesManger(driver);
        this.addEditTodos = pagesManager.getAddEditTodos();
    }


    @When("user add a new todo with name {string}")
    public void userAddANewTodoWithName(String toDoName) {

        addEditTodos.addToDos(toDoName);
    }

    @When("user edit added todo Item {string}")
    public void userEditAddedTodoItem(String editToDoName) {
        addEditTodos.editToDos(editToDoName);
    }

    @Then("verify edit todo Item {string}")
    public void verifyEditTodoItem(String editToDoName) {

        addEditTodos.verifyEditToDos(editToDoName);
    }

    @Then("verify added todo Item {string}")
    public void verifyAddedTodoItem(String addToDoName) {

        addEditTodos.verifyAddToDos(addToDoName);
    }

}
