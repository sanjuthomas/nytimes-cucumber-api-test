Feature: New York Times Book API

  Scenario: List all book categories
    Given a api key "CUArAjKZBk7HHjwAHXqtcztIXXehZeNG"
    When a user list book category using api "https://api.nytimes.com/svc/books/v3/lists/names" in the format "json"
    Then the status code is 200
    And response includes the following
    | status| OK |
    | num_results | 55 |
    And response includes the following in an array
    | results.list_name              | Combined Print and E-Book Fiction |
    | results.display_name           | Combined Print & E-Book Fiction |
    | results.list_name_encoded      | combined-print-and-e-book-fiction |
    | results.oldest_published_date  | 2011-02-13 |
    | results.newest_published_date  | 2019-06-30 |
    | results.updated                | WEEKLY |


