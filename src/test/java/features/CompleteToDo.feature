Feature: TodoMVC - Add a Todo Item

  Scenario Outline: Complete todo item
    When user add a new todo with name "<Item>"
    When user mark item as complete "<Item>"
    Given user navigate to complete tab
    Then verify item display under complete tab "<Item>"

  Examples:
      |Item         |
      |Buy Groceries|

