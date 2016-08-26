Feature: Create a new quotation
  In order to bid for a project
  As a project coordinator
  I want to create a new quotation

  Background:
    Given I want to create a new quotation for a project at "ANGELA"

  @quotation
  Scenario Outline: Create a new quotation for customer with details
    When I divide the project "<PROJECT>" into phases
      | PROJECT | Phase No | Phase                                  |
      | 001     | 1        | Project Engineering / Design / Planing |
      | 001     | 1.1      | Sea fastening of loose items           |
      | 001     | 1.1.1    | Engineering                            |
      | 001     | 1.1.1.1  | Stowage plan - central laydown area    |
      | 001     | 1.1.1.2  | Stowage plan - turret area             |
      | 001     | 1.1.2    | Site Attendence                        |
      | 001     | 2        | Fire Protection Systems                |
      | 001     | 2.1      | Basements                              |
      | 001     | 2.1.1    | Hose Real System                       |
      | 001     | 2.1.1.1  | Hose real pipe work with valves        |

    And I estimate quantity, price and discount for each phase in "<PROJECT>"
      | PROJECT | Phase No. | Qty | Price | Disc Percent | Disc Amount |
      | 001     | 1         | 4   |       |              |             |
      | 001     | 1.1.1.1   | 3   | 2     | 10           |             |
      | 001     | 1.1.1.2   | 2   | 3     |              |             |
      | 001     | 2.1.1.1   | 8   | 7     |              | 20          |
    Then "<PROJECT>" phase detail should be as following
      | PROJECT | Phase No. | Total Amount | Estimate Cost | Estimate Profit |
      | 001     | 1         | 11.4         | 0             | 11.4            |
      | 001     | 1.1.1.1   | 5.4          | 0             | 5.4             |
      | 001     | 1.1.1.2   | 6            | 0             | 6               |
      | 001     | 2.1.1.1   | 36           | 0             | 36              |
    Examples:
      | PROJECT |
      | 001     |

    