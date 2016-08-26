Feature: Accounts Receivable

  Scenario Outline: Create Accounts Receivable with feature file
    Given user login the TH6 system
    When user navigates to "Opening Balance>Accounts Receivable" screen
    And user create invoice ar as "<KEY OBARINV>"
      | KEY OBARINV | Customer Code | Invoice Date | Due Date | Sales Person | Reference No | Currency | Exchange Rate | Total After Tax Amt | Total After Tax Home Amt | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001         | CUS01         |              |          |              |              | SGD      | 1             | 10000               |                          | na        | na        | na        | na        |
    And user create credit note ar as "<KEY OBARCRN>"
      | KEY OBARCRN | Customer Code | Credit Note Date | Sales Person | Reference No | Credit Note Category | Credit Note Justification | Currency | Exchange Rate | Total After Tax Amt | Total After Tax Home Amt | Remarks To Customer | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001         | cus01         |                  |              | 12345        |                      |                           | SGD      | 1             | 130000              |                          |                     | na        | na        | na        | na        |

    Examples: 
      | KEY OBARINV | KEY OBARCRN |
      | 001         | 001         |

  Scenario: Create Accounts Receivable with excel file
    Given user login the TH6 system
    When user navigates to "Opening Balance>Accounts Receivable" screen
    And user create new invoice accounts receivable
    And user create new credit note accounts receivable
