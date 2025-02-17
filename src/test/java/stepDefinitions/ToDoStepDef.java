package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Todos;


public class ToDoStepDef {

    WebDriver driver;
    Todos todos;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        todos = new Todos(driver);
    }

    @Given("I open the TodoMVC application")
    public void iOpenTheTodoMVCApplication() {
        driver.get("https://todomvc.com/examples/react/dist/");
    }

    @When("I add a new todo with name {string}")
    public void iAddANewTodoWithName(String toDoName) {
        todos.addToDos(toDoName);
    }

    @When("user edit added todo Item {string}")
    public void userEditAddedTodoItem(String editToDoName) {
        todos.editToDos(editToDoName);
    }

    @Then("verify edit todo Item {string}")
    public void verifyEditTodoItem(String editToDoName) {
        todos.verifyEditToDos(editToDoName);
    }
}
