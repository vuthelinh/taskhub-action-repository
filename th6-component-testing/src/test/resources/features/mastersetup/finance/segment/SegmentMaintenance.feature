Feature: Create Segment

  Scenario Outline: Create Segment with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Segment>Segment" screen
    When user create segment as "<KEY SGMT>"
      | KEY SGMT | Segment No | Segment Name |
      | 001      | 1          | Seg 1        |
      | 002      | 2          | Seg 2        |
      | 003      | 3          | Seg 3        |
      | 004      | 4          | Seg 4        |
    And segment is added detail as "<KEY SGMT>"
      | KEY SGMT | Segment Code | Description | Del |
      | 001      | Seg1         | Segment 1   |     |
      | 002      | Seg2         | Segment 2   |     |
      | 003      | Seg3         | Segment 3   |     |
      | 004      | Seg4         | Segment 4   |     |
      | 001      | NA           | Segment 1   |     |
      | 002      | NA           | Segment 2   |     |
      | 003      | NA           | Segment 3   |     |
      | 004      | NA           | Segment 4   |     |

    Examples: 
      | KEY SGMT |
      | 001      |
      | 002      |
      | 003      |
      | 004      |

  Scenario: Delete Segment with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Segment>Segment" screen
    And user delete segment
      | Segment No | Segment Code |
      | 1          | Seg1         |
      | 1          | NA           |

  Scenario: Create Segment with Excel File
    Given user login the TH6 system
    When user navigates to "Master Setup>Segment>Segment" screen
    And user create segment
    And user logout
