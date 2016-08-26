@TH6_MT_REVIEW_GRADE @ReviewGradeMaintenance @MT @integration @LilyHoang
Feature: Review Grade Management
  I want to manage Review Grade in my company
  The function includes Add new, update, delete  Sub Company

  # Create by: Lily Hoang
  Background: 
    Given user login the taskhub system
    And user navigates to "Master Setup>Performance Management>Review Grade" screen

  Scenario Outline: Review Grade Intergration Test
    #Add New
    When I want to create a new Review Grade
    And The Review Grade has new Time period  as the following with Key as "<KEY>"
      | Key | From Year | To Year |
      |  01 | Max       | Max+3   |
    And The Review Grade has new Score information as the following with Key as "<KEY>"
      | Key | Score From | Score To | Grade |
      |  01 |         90 |      100 | A     |
      |  01 |         70 |       89 | B     |
      |  01 |         50 |       69 | C     |
      |  01 |          0 |       49 | D     |
    And The Review Grade has new Review Type information as the following with Key as "<KEY>"
      | Key | Review Type  |
      |  01 | Confirmation |
      |  01 | Annual Appraisal      |
    Then The Review Grade should be displayed on Review Grade List as the followng with Key as "<KEY>"
      | Key | From Year | To Year |
      |  01 |      2015 |    2016 |
    #update
    When I want to update Review Grade
    And The Review Grade has new Time period  as the following with Key as "<KEY>"
      | Key | From Year | To Year |
      |  01 | Max       | Max+3   |
    And The Review Grade has new Score information as the following with Key as "<KEY>"
      | Key | Score From | Score To | Grade |
      |  01 |        190 |      200 | A     |
      |  01 |        170 |      189 | B     |
      |  01 |        150 |      169 | C     |
      |  01 |        100 |      149 | D     |
    And The Review Grade has new Review Type information as the following with Key as "<KEY>"
      | Key | Review Type  |
      |  01 | Confirmation |
      |  01 | Annual Appraisal    |
    Then The Review Grade should be displayed on Review Grade List as the followng with Key as "<KEY>"
      | Key | From Year | To Year |
      |  01 |      2015 |    2016 |

    Examples: 
      | KEY |
      |  01 |
