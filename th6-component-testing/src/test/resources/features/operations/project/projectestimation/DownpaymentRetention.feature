@integration @project_order @zoe
Feature: Downpayment and Retention in Project Order

  Background: 
    Given user login the taskhub system
      And user navigates to "Operations>Project>Project Order" screen
      And I am in project estimation page

  #Downpayment
  Scenario Outline: Able to calculate downpayment percent from downpayment amount and vice versa
    Given I create phase as "<KEY>"
      | KEY | Phase No. | Qty | Unit Price |
      |   1 |         1 |   5 |        100 |
      |   2 |         1 |   5 |        100 |
      And the total amount of money the customer has to pay for "<KEY>" is
      | KEY | Project Sum |
      |   1 |      500.00 |
      |   2 |      500.00 |

     When with "<KEY>" the downpayment type entered is
      | KEY | Downpayment Amount | Downpayment Percent |
      |   1 |                400 |                     |
      |   2 |                    |                  50 |

     Then I should see the other downpayment  for "<KEY>" as
      | KEY | Downpayment Amount | Downpayment Percent |
      |   1 |                    |               80.00 |
      |   2 |             250.00 |                     |

    Examples: Calculate downpayment percent from downpayment amount
      | KEY |
      |   1 |

    Examples: Calculate downpayment amount from downpayment percent
      | KEY |
      |   2 |

  #Retention
  Scenario Outline: Able to calculate retention percent from retention amount and vice versa
    Given I create phase as "<KEY>"
      | KEY | Phase No. | Qty | Unit Price |
      |   1 |         1 |   5 |        100 |
      |   2 |         1 |   5 |        100 |
      And the total amount of money the customer has to pay for "<KEY>" is
      | KEY | Project Sum |
      |   1 |      500.00 |
      |   2 |      500.00 |

     When with "<KEY>" the progressive retention entered is
      | KEY | Progressive Retention |
      |   1 |                    10 |
      |   2 |                    10 |

    #Max Project Retention must be less than or equal Retention Percent value.
      And with "<KEY>" the max retention type entered is
      | KEY | Max Retention Amount | Max Retention Percent |
      |   1 |                   20 |                       |
      |   2 |                      |                     5 |

     Then I should see the other max retention type for "<KEY>" as
      | KEY | Retention Amount | Retention Percent |
      |   1 |                  |              4.00 |
      |   2 |            25.00 |                   |

    Examples: Calculate max retention percent from max retention amount
      | KEY |
      |   1 |

    Examples: Calculate max retention amount from max retention percent
      | KEY |
      |   2 |
