Feature: TodoMVC - Add a Todo Item

  Background:
    //if some step repeat in each scenario
@Regression
  Scenario: Add a new Todo item
    When user add a new todo with name "Buy Groceries"
    Then verify added todo Item "Buy Groceries"

@Regression
  Scenario Outline: Add a new Todo item with parameterization
    When user add a new todo with name "<Item>"
    When user edit added todo Item "<EditItem>"
    Then verify edit todo Item "<EditItem>"

  Examples:
      |Item         |EditItem|
      |Buy Groceries|Buy foods|

