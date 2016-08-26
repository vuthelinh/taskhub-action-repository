Feature: Accounts Payable

  Scenario Outline: Create Accounts Payable with feature file
    Given user login the taskhub system
    When user navigates to "Opening Balance>Accounts Payable>[1]" screen
    And user create invoice ap as "<KEY OBAPINV>"
      | KEY OBAPINV | Supplier Code | Supplier Invoice No | Supplier Invoice Date | Posting Date | Due Date | Reference No | Currency | Exchange Rate | Total After Tax Amt | Total After Tax Home Amt | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001         | Sup01         |                     |                       |              |          |              | USD      | 1.5           | 15000               |                          | NA        | NA        | NA        | NA        |
    And user create credit note ap as "<KEY OBAPCRN>"
      | KEY OBAPCRN | Supplier Code | Supplier Credit Note No | Supplier Credit Note Date | Posting Date | Reference No | Credit Note Category | Credit Note Justification | Currency | Exchange Rate | Total After Tax Amt | Total After Tax Home Amt | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001         | SUP01         |                         |                           |              |              |                      |                           | USD      | 1.5           | 150000              |                          | NA        | na        | na        | na        |

    Examples: 
      | KEY OBAPINV | KEY OBAPCRN |
      | 001         | 001         |

  Scenario: Create Accounts Payable with excel file
    Given user login the taskhub system
    When user navigates to "Opening Balance>Accounts Payable>[1]" screen
    And user create new invoice accounts payable
    And user create new credit note accounts payable
