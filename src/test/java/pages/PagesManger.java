package pages;

import org.openqa.selenium.WebDriver;

public class PagesManger {

    private WebDriver driver;
    private AddEditTodos addEditTodos;
    private CompleteTodos completeTodos;
    public PagesManger(WebDriver driver){
        this.driver = driver;
    }

    public AddEditTodos getAddEditTodos(){
        addEditTodos = new AddEditTodos(driver);
        return addEditTodos;
    }

    public CompleteTodos getCompleteTodos(){
        completeTodos = new CompleteTodos(driver);
        return completeTodos;
    }

}
