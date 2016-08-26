Feature: Create AP Credit Note

  Scenario Outline: Create AP Credit Note with feature file
    Given user login the taskhub system
    And user navigates to "Processing>Accounts Payable>AP Credit Note" screen
    When user create AP credit note as "<KEY AP CRN>"
      | KEY AP CRN | Supplier | Currency | Posting Date | Supplier Credit Note No | Credit Note Category | Sales Tax | Location | Supplier Credit Note Date | Default Disc % | Reference No. | Credit Note Justification | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001        | SUP01    | USD      |              |                         |                      | GST0      |          |                           |                |               |                           | NA        | NA        | NA        | NA        |
      | 002        | SUP02    | SGD      |              |                         |                      | GST0      |          |                           |                |               |                           | NA        | NA        | NA        | NA        |
    And AP credit note is added detail as "<KEY AP CRN>"
      | KEY AP CRN | Type | Item Code/Remarks | Qty UOM | Pack Size | Cost Type | Discount %/ | Sales tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001        | S    | S1                | 5       |           | 10000     |             | gst0      | NA        | NA        | NA        | NA        |
      | 002        | S    | S1                | 5       |           | 10000     |             | gst0      | NA        | NA        | NA        | NA        |
    And AP credit note is applied as "<KEY AP CRN>"
      | KEY AP CRN | Inv No.    | Sup Inv No | Inv Date | Due Date | Inv Ccy Ref No. | Apl Crn Amt Home Amt | Apply Full |
      | 001        | AP000003IN |            |          |          |                 | 1000                 | y          |
      | 001        |            |            |          |          |                 |                      |            |
      | 001        |            |            |          |          |                 |                      |            |
    And AP credit note is previewed report ""
    And AP credit note is submitted
    And AP credit note is applied outstanding as "<>"
      | KEY AP CRN | Inv No.    | Sup Inv No | Inv Date | Due Date | Inv Ccy Ref No. | Apl Crn Amt Home Amt | Apply Full |
      | 001        | AP000004IN |            |          |          |                 | 1000                 | y          |
      | 001        |            |            |          |          |                 |                      |            |
      | 001        |            |            |          |          |                 |                      |            |

    Examples: 
      | KEY AP CRN |
      | 001        |
