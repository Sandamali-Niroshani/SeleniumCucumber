package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

//Receives WebDriver from Step Definitions.
public class CompleteTodos {
    private WebDriver ldriver;

    public CompleteTodos(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }

    private static final String PARAMETER = "parameter";
    private String strXpathToDoItem = "//li//label[text()='" + PARAMETER + "']";
    private String strXpathToDoItemRadioButton = "//li//label[text()='" + PARAMETER + "']/preceding-sibling::input";

    @FindBy(id = "todo-input")
    private WebElement txtTodoInputField;

    @FindBy(xpath = "//li[@data-testid='todo-item']")
    private WebElement txtToDoItem;

    @FindBy(xpath = "//li[@data-testid='todo-item']")
    private List<WebElement> txtToDoItemsUnderAllTab;

    @FindBy(xpath = "//li[@data-testid='todo-item']")
    private List<WebElement> txtToDoItemsUnderActiveTab;

    @FindBy(xpath = "//li[@class='completed' and @data-testid='todo-item']")
    private List<WebElement> txtToDoItemsUnderCompleteTab;

    @FindBy(xpath = "//label[text()='Edit Todo Input']//preceding-sibling::input")
    private WebElement txtEditToDoItem;

    @FindBy(xpath = "//a[text()='Active']")
    private WebElement lnkActive;

    @FindBy(xpath = "//a[text()='Completed']")
    private WebElement lnkCompleted;

    @FindBy(xpath = "//a[text()='All']")
    private WebElement lnkAll;

    @FindBy(xpath = "//button[@class='clear-completed']")
    private WebElement btnClearCompleted;

    @FindBy(how= How.XPATH, using= "//div[@class='view']//input[@type='checkbox']")
    private WebElement rdItem;

    @FindBy(xpath = "//div[@class='view']//input[@type='checkbox']")
    private List<WebElement> rdItems;

    @FindBy(xpath = "//button[@class='destroy']")
    private WebElement btnClose;

    @FindBy(xpath = "//button[@class='destroy']")
    private List<WebElement> btnCloseIcons;

    @FindBy(xpath = "//span[@class='todo-count']")
    private WebElement txtToDoActiveCount;

    @FindBy(id = "toggle-all")
    private WebElement chkToggleAll;


    /**
     * This method is used to add a to do item and verify the added item
     *
     * @param toDoItem to do item
     * @return void
     * @autor Niroshani
     * @completed 2025-02-06
     */
    public void markAsComplete(String toDoItem) {
        //First item is marked as completed
        rdItem.click();

        //Verify completed item cannot be displayed under the active tab
        // Assert.assertTrue(waitForElementInvisible(ldriver,strXpathToDoItem.replace(PARAMETER,toDoItem )), "Item is not displayed under active tab as completed");
    }

    public void navigateIntoCompleteTab(){
        //Verify the completed item displayed under complete tab
        lnkCompleted.click();
    }

    public void verifyCompleteItem(String toDoItem){
        String actualToDoItemUnderCompleteTab = txtToDoItemsUnderCompleteTab.get(0).getText();
        Assert.assertEquals(actualToDoItemUnderCompleteTab, toDoItem);

        //Verify the completed item displayed as checked under complete tab
        Assert.assertTrue( rdItem.isSelected(),"Completed item displayed as checked under complete tab");
        // captureScreenshots(ldriver, "completeToDoItemUnderCompleteTab");

    }
}
