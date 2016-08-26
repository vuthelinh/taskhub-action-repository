Feature: Create and maintain processing numbering scheme
  Maintain Processing Numbering														
  Add new data for Processing Numbering

  @Create @Maintain
  Scenario Outline: Maintain Processing Numbering
    Given user login the taskhub system
    When user navigates to "Maintenance Setup>Administration>Document Numbering>Processing Numbering>[2]" screen
    Then page header shouble be "Processing Numbering"
    Then user selects Transaction in Processing Numbering as "<Transaction KEY>"
      | KEY | Module Code | Module Desc | Transaction Type Code | Transaction Type Desc | Auto Number |
      | 1   | PR          |             | REQ                   |                       |             |
      |     |             |             |                       |                       |             |
      | 2   | PR          |             | CCF                   |                       |             |
      |     |             |             |                       |                       |             |
      | 3   | PO          |             | PO                    |                       |             |
      |     |             |             |                       |                       |             |
      | 4   | LG          |             | PSH                   |                       |             |
      |     |             |             |                       |                       |             |
      | 5   | LG          |             | ARI                   |                       |             |
      |     |             |             |                       |                       |             |
      | 6   | LG          |             | SSH                   |                       |             |
      |     |             |             |                       |                       |             |
      | 7   | LG          |             | API                   |                       |             |
    Then user maintains Numbering Scheme Code as "<Numbering Scheme KEY>"
      | KEY | Numbering Scheme Code | Description | Auto Number | Is manual Numbering | Last Number | Prefix | Suffix | Fill Character | Maximum Length of Code | Length of Code | Allow User to Overwrite | Device ID |
      | 1   | REQ                   |             |             |                     |             | PR     |        |                |                        | 10             |                         |           |
      |     |                       |             |             |                     |             |        |        |                |                        |                |                         |           |
      | 2   | CCF                   |             |             |                     |             | PR     |        |                |                        | 10             |                         |           |
      |     |                       |             |             |                     |             |        |        |                |                        |                |                         |           |
      | 3   | PO                    |             |             |                     |             | PO     |        |                |                        | 10             |                         |           |
      |     |                       |             |             |                     |             |        |        |                |                        |                |                         |           |
      | 4   | PSH                   |             |             |                     |             | LGI    |        |                |                        | 10             |                         |           |
      |     |                       |             |             |                     |             |        |        |                |                        |                |                         |           |
      | 5   | ARI                   |             |             |                     |             | AR     |        |                |                        | 10             |                         |           |
      |     |                       |             |             |                     |             |        |        |                |                        |                |                         |           |
      | 6   | SSH                   |             |             |                     |             | LGO    |        |                |                        | 10             |                         |           |
      |     |                       |             |             |                     |             |        |        |                |                        |                |                         |           |
      | 7   | API                   |             |             |                     |             | AP     |        |                |                        | 10             |                         |           |
    Then user tags user to Numbering Scheme as "<User KEY>"
      | KEY | User ID From | User ID To | User ID | User Name From | User Name To | User Name | Employee Code | Employee Name |
      #| 1   |              |            | Phoebe  |                |              |           |               |               |
			| 1   |              |            |  U000000421 |                |              |           |               |               |
    Examples: 
      | Transaction KEY | Numbering Scheme KEY | User KEY |
      | 1               | 1                    | 1        |
      | 2               | 2                    | 1        |
      | 3               | 3                    | 1        |
      | 4               | 4                    | 1        |
      | 5               | 5                    | 1        |
      | 6               | 6                    | 1        |
      | 7               | 7                    | 1        |
