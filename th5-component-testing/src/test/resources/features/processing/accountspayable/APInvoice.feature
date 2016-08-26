Feature: Create AP Invoice

  Scenario Outline: Create AP Invoice with feature file
    Given user login the taskhub system
    And user navigates to "Processing>Accounts Payable>AP Invoice" screen
    When user create AP invoice as "<KEY AP INV>"
      | KEY AP INV | Supplier | Currency | Posting Date | Supplier Invoice No | Disc Date | Supplier DO No. | Bill Of Lading No. | Custom Tax Invoice | Sales Tax | Due Date | Supplier Invoice Date | Default Discount % | Supplier DO Date | Import Permit No | Reference No. | Inventory Location | Seg1 | Seg2 | Seg3 | Seg4 |
      | 001        | Sup01    | SGD      |              |                     |           |                 |                    | NO                 | gst7      |          |                       |                    |                  |                  |               |                    | NA   | NA   | NA   | NA   |
      | 002        | Cus02    | USD      |              |                     |           |                 |                    | NO                 | gst7      |          |                       |                    |                  |                  |               |                    | NA   | NA   | NA   | NA   |
      | 003        | sup01    | SGD      |              |                     |           |                 |                    | YES                | gst0      |          |                       |                    |                  |                  |               |                    | NA   | NA   | NA   | NA   |
      | 004        | sup01    | SGD      |              |                     |           |                 |                    | NO                 | gst0      |          |                       |                    |                  |                  |               |                    | NA   | NA   | NA   | NA   |
      | 005        | sup01    | SGD      |              |                     |           |                 |                    | NO                 | gst0      |          |                       |                    |                  |                  |               |                    | NA   | NA   | NA   | NA   |
      | 006        | sup01    | SGD      |              |                     |           |                 |                    | NO                 | gst0      |          |                       |                    |                  |                  |               |                    | NA   | NA   | NA   | NA   |
      | 007        | cus02    | USD      |              |                     |           |                 |                    | NO                 | gst7      |          |                       |                    |                  |                  |               |                    | NA   | NA   | NA   | NA   |
      | 008        | cus02    | USD      |              |                     |           |                 |                    | NO                 | gst7      |          |                       |                    |                  |                  |               |                    | NA   | NA   | NA   | NA   |
    And AP invoice is added detail header as "<KEY AP INV>"
      | KEY AP INV | Type | Item Code/Remarks | Qty UOM | Pack Size | Cost Type | Discount %/ | Total Amt | Sales Tax | Seg1 | Seg2 | Seg3 | Seg4 |
      | 001        | F    | FA1               | 2       |           | 10000     |             |           | gst7      | NA   | NA   | NA   | NA   |
      | 001        | S    | S1                | 10      |           | 10000     |             |           | gst0      | NA   | NA   | NA   | NA   |
      | 007        | F    | FA1               | 2       |           | 10000     |             |           | gst7      | NA   | NA   | NA   | NA   |
      | 007        | S    | S1                | 10      |           | 10000     |             |           | gst0      | NA   | NA   | NA   | NA   |
      | 008        | F    | FA1               | 2       |           | 10000     |             |           | gst7      | NA   | NA   | NA   | NA   |
      | 008        | S    | S1                | 10      |           | 10000     |             |           | gst0      | NA   | NA   | NA   | NA   |
      | 002        | S    | S1                | 10      |           | 10000     |             |           | gst0      | NA   | NA   | NA   | NA   |
      | 003        | S    | S1                | 10      |           | 10000     |             |           | gst0      | NA   | NA   | NA   | NA   |
      | 004        | S    | S1                | 10      |           | 10000     |             |           | gst0      | NA   | NA   | NA   | NA   |
      | 005        | S    | S1                | 10      |           | 10000     |             |           | gst0      | NA   | NA   | NA   | NA   |
      | 006        | S    | S1                | 10      |           | 10000     |             |           | gst0      | NA   | NA   | NA   | NA   |
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

    Examples: 
      | KEY AP INV |
      | 001        |

  Scenario Outline: Update AP Invoice with feature file
    Given user login the taskhub system
    And user navigates to "Processing>Accounts Payable>AP Invoice" screen
    When user udpate AP invoice as "<KEY AP INV>"
      | KEY AP INV | Supplier | Currency | Posting Date | Supplier Invoice No | Disc Date | Supplier DO No. | Bill Of Lading No. | Custom Tax Invoice | Sales Tax | Due Date | Supplier Invoice Date | Default Discount % | Supplier DO Date | Import Permit No | Reference No. | Inventory Location | Seg1 | Seg2 | Seg3 | Seg4 |
      | 001        | Sup01    | SGD      |              |                     |           |                 |                    | NO                 | gst7      |          |                       |                    |                  |                  |               |                    | NA   | NA   | NA   | NA   |
      | 002        | Cus02    | USD      |              |                     |           |                 |                    | NO                 | gst7      |          |                       |                    |                  |                  |               |                    | NA   | NA   | NA   | NA   |

    Examples: 
      | KEY AP INV |
      | 001        |
