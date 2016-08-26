Feature: Create AP Credit Note

  Scenario Outline: Create AP Credit Note with feature file
    Given user login the TH6 system
    And user navigates to "Processing>Accounts Payable>AP Credit Note" screen
    When user create AP credit note as "<KEY AP CRN>"
      | KEY AP CRN | Supplier | Currency | Posting Date | Supplier Credit Note No | Credit Note Category | Sales Tax | Location | Supplier Credit Note Date | Default Disc % | Reference No. | Credit Note Justification | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001        | CS       | USD      |              |                         |                      | GST0      |          |                           |                |               |                           | NA        | NA        | NA        | NA        |
      | 002        | SPA      | SGD      |              |                         |                      | GST0      |          |                           |                |               |                           | NA        | NA        | NA        | NA        |
    And AP credit note is added detail as "<KEY AP CRN>"
      | KEY AP CRN | Type | Item Code/Remarks | Qty UOM | Pack Size | Cost Type | Discount %/ | Sales tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      | 001        | S    | ST                | 5       |           | 10000     |             | gst0      | NA        | NA        | NA        | NA        |
      | 002        | S    | ST                | 5       |           | 10000     |             | gst0      | NA        | NA        | NA        | NA        |
    And AP credit note is applied as "<KEY AP CRN>"
    And AP credit note is updated

    Examples: 
      | KEY AP CRN |
      | 001        |
