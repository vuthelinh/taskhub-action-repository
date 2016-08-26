@n-apinv
Feature: Create AP Invoice

  Scenario Outline: Create AP Invoice with feature file
    Given user login the TH6 system
    And user navigates to "Operations>Accounts Payable>AP Invoice" screen
    When user update AP invoice as "<KEY AP INV>"
      | KEY AP INV | Voucher No. | Supplier | Currency | Posting Date | Supplier Invoice No | Disc Date | Supplier DO No. | Bill Of Lading No. | Custom Tax Invoice | Sales Tax | Due Date | Supplier Invoice Date | Default Discount % | Supplier DO Date | Import Permit No | Reference No. | Inventory Location | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001        | AP000012IN  | Sup01    | SGD      |              |                     |           |                 |                    | No                 | gst7      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
      | 002        |             | Cus02    | USD      |              |                     |           |                 |                    | No                 | gst7      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
      | 003        |             | sup01    | SGD      |              |                     |           |                 |                    | Yes                | gst0      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
      | 004        |             | sup01    | SGD      |              |                     |           |                 |                    | No                 | gst0      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
      | 005        |             | sup01    | SGD      |              |                     |           |                 |                    | No                 | gst0      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
      | 006        |             | sup01    | SGD      |              |                     |           |                 |                    | No                 | gst0      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
      | 007        |             | cus02    | USD      |              |                     |           |                 |                    | No                 | gst7      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
      | 008        |             | cus02    | USD      |              |                     |           |                 |                    | No                 | gst7      |          |                       |                    |                  |                  |               |                    | NA        | NA        | NA        | NA        |
    And AP invoice is added payment information as "<KEY AP INV>"
      | KEY AP INV | Payment Option | Payment Term | Payment Term Tenor | Payment Method | Payment Amount | Payment Party | Payment Address | Payment Contact |
      | 001        |                |              | 1>V_001            |                |                |               |                 |                 |
      | 002        |                |              | 2                  |                |                |               |                 |                 |
      | 003        |                |              | 3                  |                |                |               |                 |                 |
      | 004        |                |              | 4                  |                |                |               |                 |                 |
      | 005        |                |              | 5                  |                |                |               |                 |                 |
      | 006        |                |              | 6                  |                |                |               |                 |                 |
      | 007        |                |              | 7                  |                |                |               |                 |                 |
      | 008        |                |              | 8                  |                |                |               |                 |                 |
    And AP invoice is added detail header as "<KEY AP INV>"
      | KEY AP INV | Type | Item Code/Remarks | Qty UOM | Pack Size | Cost Type | Discount %/ | Total Amt | Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001        | F    | FA1               | 2       |           | 10000     |             |           | gst7      | NA        | NA        | NA        | NA        |
      | 001        | S    | S1                | 10      |           | 10000     |             |           | gst0      | NA        | NA        | NA        | NA        |
      | 007        | F    | FA1               | 2       |           | 10000     |             |           | gst7      | NA        | NA        | NA        | NA        |
      | 007        | S    | S1                | 10      |           | 10000     |             |           | gst0      | NA        | NA        | NA        | NA        |
      | 008        | F    | FA1               | 2       |           | 10000     |             |           | gst7      | NA        | NA        | NA        | NA        |
      | 008        | S    | S1                | 10      |           | 10000     |             |           | gst0      | NA        | NA        | NA        | NA        |
      | 002        | S    | S1                | 10      |           | 10000     |             |           | gst0      | NA        | NA        | NA        | NA        |
      | 003        | S    | S1                | 10      |           | 10000     |             |           | gst0      | NA        | NA        | NA        | NA        |
      | 004        | S    | S1                | 10      |           | 10000     |             |           | gst0      | NA        | NA        | NA        | NA        |
      | 005        | S    | S1                | 10      |           | 10000     |             |           | gst0      | NA        | NA        | NA        | NA        |
      | 006        | S    | S1                | 10      |           | 10000     |             |           | gst0      | NA        | NA        | NA        | NA        |
    And AP invoice is submitted

    Examples: 
      | KEY AP INV |
      | 001        |
