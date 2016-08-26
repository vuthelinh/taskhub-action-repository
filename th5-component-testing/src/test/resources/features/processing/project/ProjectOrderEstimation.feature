Feature: Create project estimation

  Scenario Outline: Create Project
    Given user login the taskhub system
    And user navigates to "Processing>Project>Project Order/Estimation" screen
    When user update project estimation as "<PE KEY>"
      | PE KEY | Project No. | Customer | Is Session |
      |    001 | PJ00015668  | CUS03    |            |
      |    002 |             | CUS02    |            |
      |    003 |             | CUS01    |            |
    And project estimation is created with header tab as "<PE KEY>"
      | PE KEY | Currency | Sales Tax | Customer PO No | Reference No. | Estimate Date | Customer Contact | Start Date | End Date   | Sales Manager | Project Class | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Payment Term Tenor |
      |    001 | SGD      | GST7      |                |               |               |                  | 01/01/2015 | 01/01/2017 |               | PJCLASS1      | NA        | NA        | NA        | NA        |                 11 |
      |    002 | SGD      | GST7      |                |               |               |                  | 01/01/2015 | 01/01/2017 |               | PJCLASS2      | NA        | NA        | NA        | NA        |                 12 |
      |    002 | SGD      | GST7      |                |               |               |                  | 01/01/2015 | 01/01/2017 |               | PJCLASS3      | NA        | NA        | NA        | NA        |                 13 |
    And project estimation is created with detail tab with phase as "<PE KEY>"
      | PE KEY | Phase No. | Phase Desc     | Qty | UOM | Unit Price | Disc% | Amount | Budgeted Total Cost | Del |
      |    001 |         1 | Phase 1 Desc   |   7 |     |      11000 |     1 |    100 |                     |     |
      |    001 |         2 | Phase 2 Desc   |   4 |     |      12000 |     2 |    200 |                     |     |
      |    001 |       2.1 | Phase 2.1 Desc |   2 |     |      13000 |     3 |    300 |                     |     |
      |    002 |         1 | Phase 1 Desc   |   7 |     |      14000 |     4 |    400 |                     |     |
      |    002 |       1.1 | Phase 1.1 Desc |   4 |     |      15000 |     5 |    500 |                     |     |
      |    002 |         2 | Phase 2 Desc   |   2 |     |      16000 |     6 |    600 |                     |     |
      |    003 |         1 | Phase 1 Desc   |   7 |     |      11000 |     1 |    100 |                     |     |
      |    003 |       1.1 | Phase 1.1 Desc |   7 |     |      11000 |     1 |    100 |                     |     |
      |    003 |       1.2 | Phase 1.2 Desc |   7 |     |      11000 |     1 |    100 |                     |     |
      |    003 |         2 | Phase 2 Desc   |   4 |     |      12000 |     2 |    200 |                     |     |
      |    003 |       2.1 | Phase 2.1 Desc |   2 |     |      13000 |     3 |    300 |                     |     |
    And project estimation is created with detail tab with item as "<PE KEY>"
      | PE KEY | Phase No. | No. | Type | Item Description | Item Remarks | Qty/UOM | Unit Price | Disc% | Amount | Budgeted Unit Cost | Del |
      |    001 |         1 |     | S    | S1               |              |      10 |            |       |        |                500 |     |
      |    001 |         1 |     | S    | TS               |              |      20 |            |       |        |                500 |     |
      |    001 |       2.1 |     | S    | TS               |              |      30 |            |       |        |                500 |     |
      |    002 |       1.1 |     | S    | TS               |              |      40 |            |       |        |                500 |     |
      |    002 |         2 |     | S    | S1               |              |      50 |            |       |        |                500 |     |
      |    002 |         2 |     | S    | TS               |              |      60 |            |       |        |                500 |     |
      |    003 |       1.1 |     | S    | TS               |              |      60 |            |       |        |                500 |     |
      |    003 |       1.2 |     | S    | S1               |              |      70 |            |       |        |                500 |     |
      |    003 |       1.2 |     | S    | TS               |              |      60 |            |       |        |                500 |     |
      |    003 |       2.1 |     | S    | S1               |              |      60 |            |       |        |                500 |     |
    And project estimation is submitted

    Examples: 
      | PE KEY |
      |    001 |
