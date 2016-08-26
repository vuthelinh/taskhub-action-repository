Feature: Fixed Asset

  Scenario Outline: Create Fixed Asset for Opening Balance with feature file
    Given user login the TH6 system
    And user navigates to "Opening Balance>Fixed Asset" screen
    When user create fixed asset for opening balance as "<KEY OBFA>"
      | KEY OBFA | Voucher No. | Fixed Asset Code | Transaction Date | Supplier | Supplier Invoice No | Supplier Invoice Date | Subject | Description | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001      | FA000003OB  | FA1              |                  | Sup01    |                     |                       |         | testing     | na        | na        | na        | na        |
      | 002      | FA000002OB  | FA1              |                  | Sup01    |                     |                       |         | testing     | na        | na        | na        | na        |
    And fixed asset for opening balance is added detail as "<KEY OBFA>"
      | KEY OBFA | Serial No | Location | Asset Cost | Residual Value | Last Depreciation Date | No of Depreciation | Remaining Useful Life | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001      | A0001     | SG       | 12000      |                |                        | 5                  |                       | na        | na        | na        | na        |
      | 001      | A0002     | SG       | 12000      |                |                        | 6                  |                       | na        | na        | na        | na        |
      | 001      | A0003     | SG       | 12000      |                |                        | 5                  |                       | na        | na        | na        | na        |
      | 001      | A0004     | SG       | 12000      |                |                        | 6                  |                       | na        | na        | na        | na        |
      | 001      | A0005     | SG       | 12000      |                |                        | 5                  |                       | na        | na        | na        | na        |
      | 001      | A0006     | SG       | 12000      |                |                        | 6                  |                       | na        | na        | na        | na        |
    And fixed asset for opening balance is updated

    Examples: 
      | KEY OBFA |
      | 001      |

  Scenario Outline: Update Fixed Asset for Opening Balance with feature file
    Given user login the TH6 system
    And user navigates to "Opening Balance>Fixed Asset" screen
    When user update fixed asset for opening balance as "<KEY OBFA>"
      | KEY OBFA | Voucher No. | Fixed Asset Code | Transaction Date | Supplier | Supplier Invoice No | Supplier Invoice Date | Subject | Description | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001      | FA000003OB  | FA1              |                  | Sup01    |                     |                       |         | testing     | na        | na        | na        | na        |
      | 002      | FA000002OB  | FA1              |                  | Sup01    |                     |                       |         | testing     | na        | na        | na        | na        |
    And fixed asset for opening balance is added detail as "<KEY OBFA>"
      | KEY OBFA | Serial No | Location | Asset Cost | Residual Value | Last Depreciation Date | No of Depreciation | Remaining Useful Life | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001      | A0001     | SG       | 12000      |                |                        | 5                  |                       | na        | na        | na        | na        |
      | 001      | A0002     | SG       | 12000      |                |                        | 6                  |                       | na        | na        | na        | na        |
      | 001      | A0003     | SG       | 12000      |                |                        | 5                  |                       | na        | na        | na        | na        |
      | 001      | A0004     | SG       | 12000      |                |                        | 6                  |                       | na        | na        | na        | na        |
      | 001      | A0005     | SG       | 12000      |                |                        | 5                  |                       | na        | na        | na        | na        |
      | 001      | A0006     | SG       | 12000      |                |                        | 6                  |                       | na        | na        | na        | na        |
    And fixed asset for opening balance is updated

    Examples: 
      | KEY OBFA |
      | 001      |

  Scenario: Create Fixed Asset for Opening Balance with excel file
    Given user login the TH6 system
    When user navigates to "Opening Balance>Fixed Asset" screen
    And user create new fixed asset for opening balance
