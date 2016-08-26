Feature: Create Bank Book Recurring Template

  Scenario Outline: Create Bank Book Recurring Template with feature file
    Given user login the taskhub system
    And user navigates to "Maintenance Setup>Financial>Accounting>Bank Book Recurring Template" screen
    When user create BK recurring template as "<KEY BK>"
      | KEY BK | Bank Template Code | Template Description | Bank Voucher Description | Recurring Frequency | Recurring Day | Recurrence Start Date | Recurrence End Date | Last Recurred Date | Transaction Type |
      | 001    | BT01               |                      |                          |                     | 3             |                       |                     |                    | Deposit          |
      | 002    | BT02               |                      |                          |                     | 3             |                       |                     |                    | Fund Transfer    |
      | 003    | BT03               |                      |                          |                     | 3             |                       |                     |                    | Withdrawal       |
    And BK recurring template is deposit as "<KEY BK>"
      | KEY BK | Mode of Deposit | Deposit bankk A/c No | Currency | Deposit Slip No | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001    |                 | bank01               | USD      |                 | NA        | NA        | NA        | NA        |
    And BK deposit is added detail as "<KEY BK>"
      | KEY BK | Received From | Cheque No. | Amount | Sales Tax | Document No | Doc Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Del |
      | 001    | s1            | 2          | 10000  |           |             |          | NA        | NA        | NA        | NA        |     |
    And BK recurring template is fund transfer as "<KEY BK>"
      | KEY BK | Remittance Bank A/c No (Code > No.) | Destination Bank A/c No (Code > No.) | Transfer Amount | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 002    | bank01 > 12345                      | bank01 > 54321                       | 10000           | NA        | NA        | NA        | NA        |
    And BK recurring template is withdrawal as "<KEY BK>"
      | KEY BK | Mode of Withdrawal | Withdrawal Bank A/C No | Currency | Withdrawal Slip No | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 003    |                    | bank01                 | SGD      |                    | NA        | NA        | NA        | NA        |
    And BK withdrawal is added detail as "<KEY BK>"
      | KEY BK | Paid to | Cheque No. | Amount | Sales Tax | Document No | Doc Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Del |
      | 003    | s1      | 2          | 1000   |           |             |          | NA        | NA        | NA        | NA        |     |

    Examples: 
      | KEY BK |
      | 001    |
      | 002    |
      | 003    |

  Scenario Outline: Delete Bank Book Recurring Template with feature file
    Given user login the taskhub system
    And user navigates to "Maintenance Setup>Financial>Accounting>Bank Book Recurring Template" screen
    When user delete BK recurring template as "<KEY BK>"
      | KEY BK | Bank Template Code |
      | 001    | NBT01              |
      | 001    | NBT02              |
      | 001    | NBT03              |

    Examples: 
      | KEY BK |
      | 001    |
