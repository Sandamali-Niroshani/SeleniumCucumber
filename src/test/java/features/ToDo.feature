Feature: TodoMVC - Add a Todo Item

  Background:
    Given I open the TodoMVC application

  Scenario: Add a new Todo item
    When I add a new todo with name "Buy Groceries"

  Scenario Outline: Add a new Todo item with parameterization
    When I add a new todo with name "<Item>"
    When user edit added todo Item "<EditItem>"
    Then verify edit todo Item "<EditItem>"

  Examples:
      |Item         |EditItem|
      |Buy Groceries|Buy foods|