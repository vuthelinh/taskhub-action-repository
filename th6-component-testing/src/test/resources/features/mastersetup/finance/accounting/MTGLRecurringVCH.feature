Feature: MT GL Recurring Voucher

  Scenario Outline: Create MT GL Recurring Voucher with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Accounting>GL Recurring Voucher" screen
    When user create MT GL Recurring VCH as "<KEY RECURRING>"
      | KEY RECURRING | Recurring Voucher Code | Description  | Currency | Exchange Rate Type | Source Document Type | Source Document No | Recurring Day | Recurring Frequency | Recurrence Start Date | Recurrence End Date | Next Recurrence Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001           | RVC01                  | Auto testing | SGD      |                    |                      |                    |               |                     |                       |                     |                      | NA        | NA        | NA        | NA        |
      | 002           | RVC02                  | Auto testing | SGD      |                    |                      |                    |               |                     |                       |                     |                      | NA        | NA        | NA        | NA        |
    And MT GL recurring vch is add detail as "<KEY RECURRING>"
      | KEY RECURRING | GL Account Code | Description  | Nature Debit | Natural Credit | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001           | 22010           | auto testing | 10000        |                | NA        | NA        | NA        | NA        |
      | 001           | 22020           | auto testing |              | 10000          | NA        | NA        | NA        | NA        |
      | 002           | 22010           | auto testing | 10000        |                | NA        | NA        | NA        | NA        |
      | 002           | 22020           | auto testing |              | 10000          | NA        | NA        | NA        | NA        |
    And user close MT GL Recurring VCH

    Examples: 
      | KEY RECURRING |
      | 001           |
      | 002           |

  Scenario Outline: Delete MT GL Recurring Voucher with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Accounting>GL Recurring Voucher" screen
    When user delete MT GL Recurring VCH as "<KEY RECURRING>"
      | KEY RECURRING | Recurring Voucher Code |
      | 001           | RVC01                  |
      | 001           | RVC02                  |

    Examples: 
      | KEY RECURRING |
      | 001           |

  Scenario Outline: Update MT GL Recurring Voucher with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Accounting>GL Recurring Voucher" screen
    When user update MT GL Recurring VCH as "<KEY RECURRING>"
      | KEY RECURRING | Recurring Voucher Code | Description  | Currency | Exchange Rate Type | Source Document Type | Source Document No | Recurring Day | Recurring Frequency | Recurrence Start Date | Recurrence End Date | Next Recurrence Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001           | RVC01                  | Auto testing | SGD      |                    |                      |                    |               |                     |                       |                     |                      | NA        | NA        | NA        | NA        |
      | 002           | RVC02                  | Auto testing | SGD      |                    |                      |                    |               |                     |                       |                     |                      | NA        | NA        | NA        | NA        |
    And MT GL recurring vch is add detail as "<KEY RECURRING>"
      | KEY RECURRING | GL Account Code | Description  | Nature Debit | Natural Credit | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001           | 22010           | auto testing | 10000        |                | NA        | NA        | NA        | NA        |
      | 001           | 22020           | auto testing |              | 10000          | NA        | NA        | NA        | NA        |
      | 002           | 22010           | auto testing | 10000        |                | NA        | NA        | NA        | NA        |
      | 002           | 22020           | auto testing |              | 10000          | NA        | NA        | NA        | NA        |
    And user close MT GL Recurring VCH

    Examples: 
      | KEY RECURRING |
      | 001           |
      | 002           |

  Scenario: Create MT GL Recurring Voucher
    Given user login the TH6 system
    When user navigates to "Master Setup>Accounting>GL Recurring Voucher" screen
    And user create MT GL Recurring VCH
    And user logout
