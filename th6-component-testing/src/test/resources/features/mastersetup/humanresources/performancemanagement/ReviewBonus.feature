@TH6_HR_BONUS_REVIEW @BonusReview @MT @integration @LilyHoang
Feature: Review Bonus Management

  Background: 
    Given user login the taskhub system
    #Pre-condition
    And user navigates to "Master Setup>Performance Management>Review Grade" screen
    And Review Grade is created as in file "LILY_MasterData.xls"
    And user navigates to "Master Setup>Performance Management>Review Bonus/Gratuity & Basic Salary Increment" screen

  Scenario Outline: ListPriceDiscount
    # create new
    When User wants to create a new Review Bonus for a Review grade as the following with Key as "<KEY>"
      | Key | Year From  | Year To             | Employment Type |
      |  01 | MasterData | Master data       6 | Contract        |
      |  02 |          6 |                   7 | Part Time       |
      |  03 |          7 |                   8 | Regular         |
    And The Salary Increment has infomation as the following as "<KEY>"
      | Key | Basic Salary From | Basic Salary To     | Grade | Increment |
      |  01 | Max+1             | Basic Salary From+5 | A     |      1.00 |
      |  01 |                   |                     | B     |      2.00 |
      |  01 |                   |                     | C     |      3.00 |
      |  01 |                   |                     | D     |      4.00 |
      |  01 | Max+1             | Basic Salary From+5 | A     |      1.00 |
      |  01 |                   |                     | B     |      2.00 |
      |  01 |                   |                     | C     |      3.00 |
      |  01 |                   |                     | D     |      4.00 |
      |  01 | Max+1             | Basic Salary From+5 | A     |      1.00 |
      |  01 |                   |                     | B     |      2.00 |
      |  01 |                   |                     | C     |      3.00 |
      |  01 |                   |                     | D     |      4.00 |
      |  01 | Max+1             | Basic Salary From+5 | A     |      1.00 |
      |  01 |                   |                     | B     |      2.00 |
      |  01 |                   |                     | C     |      3.00 |
      |  01 |                   |                     | D     |      4.00 |
    And The Bonus/Gratuity has infomation as the following as "<KEY>"
      | Key | Grade | Bonus Gratuity |
      |  01 | A     |          10.00 |
      |  01 | B     |          20.00 |
      |  01 | C     |          30.00 |
      |  01 | D     |          40.00 |
    Then Review Bonus should be display on the list as following "<KEY>"
      | Key | Year From | Year To | Employment Type |
      |  01 |        43 |      44 | Contract        |
      |  02 |         6 |       7 | Part Time       |
      |  03 |         7 |       8 | Regular         |

    Examples: 
      | KEY |
      |  01 |
