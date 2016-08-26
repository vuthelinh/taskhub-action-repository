Feature: Fixed Asset

  Scenario Outline: Create fixed asset class with feature file
    Given user login the taskhub system
    When user navigates to "Global Setup>Fixed Asset>Class" screen
    And user creates fixed asset class as "<KEY FA>"
      | KEY FA | Fixed Asset Class Code | Description               | Fixed Asset GLAN | Depreciation GLAN | Cumulative Depreciation GLAN | Gain Loss Disposal GLAN | Disposal Clearing GLAN | Fixed Asset Clearing GLAN | Project Utilization Glan | Company |
      | 001    | FA1                    | for Synergix Testing ONLY | 11000            | 87040             | 11000                        | 86040                   | 12000                  | Z-100                     |                          |         |
      | 001    | FA2                    | for Synergix Testing ONLY | 11020            | 87070             | 11000                        | 86040                   | 12000                  | Z-100                     |                          |         |
      | 001    | FA3                    | for Synergix Testing ONLY | 11020            | 87070             | 11000                        | 86040                   | 12000                  | Z-100                     |                          |         |

    Examples: 
      | KEY FA |
      | 001    |
      
  Scenario: Delete fixed asset class with feature file
    Given user login the taskhub system
    When user navigates to "Global Setup>Fixed Asset>Class" screen
    And user dlete fixed asset class
      | KEY FA | Fixed Asset Class Code | Description               | Fixed Asset GLAN | Depreciation GLAN | Cumulative Depreciation GLAN | Gain Loss Disposal GLAN | Disposal Clearing GLAN | Fixed Asset Clearing GLAN | Project Utilization Glan | Company |
      | 001    | FA1                    | for Synergix Testing ONLY | 11000            | 87040             | 11000                        | 86040                   | 12000                  | Z-100                     |                          |         |
      | 001    | FA2                    | for Synergix Testing ONLY | 11020            | 87070             | 11000                        | 86040                   | 12000                  | Z-100                     |                          |         |
      | 001    | FA3                    | for Synergix Testing ONLY | 11020            | 87070             | 11000                        | 86040                   | 12000                  | Z-100                     |                          |         |

  Scenario Outline: Create fixed asset category with feature file
    Given user login the taskhub system
    When user navigates to "Global Setup>Fixed Asset>Category" screen
    And user creates fixed asset category as "<KEY FA>"
      | KEY FA | Fixed Asset Category Code | Description               | Company      |
      | 001    | FA-CATE01                 | for Synergix Testing ONLY | AUTO1, AUTO4 |
      | 001    | FA-CATE02                 | for Synergix Testing ONLY | AUTO1, AUTO4 |
      | 001    | FA-CATE03                 | for Synergix Testing ONLY | AUTO1, AUTO4 |

    Examples: 
      | KEY FA |
      | 001    |

  Scenario: Delete fixed asset category with feature file
    Given user login the taskhub system
    When user navigates to "Global Setup>Fixed Asset>Category" screen
    And user delete fixed asset category
      | KEY FA | Fixed Asset Category Code | Description               | Company      |
      | 001    | FA-CATE01                 | for Synergix Testing ONLY | AUTO1, AUTO4 |
      | 001    | FA-CATE02                 | for Synergix Testing ONLY | AUTO1, AUTO4 |
      | 001    | FA-CATE03                 | for Synergix Testing ONLY | AUTO1, AUTO4 |

  Scenario Outline: Create fixed asset location with feature file
    Given user login the taskhub system
    When user navigates to "Global Setup>Fixed Asset>Location" screen
    And user creates fixed asset location as "<KEY FA>"
      | Key  | Fixed Asset Location Code | Fixed Asset Location Name | Company |
      | Key1 | SG                        | Singapore                 |         |
      | Key2 | VN                        | Vietnam                   |         |
      | Key3 | ML                        | Malaysia                  |         |

    Examples: 
      | KEY FA |
      | 001    |

  Scenario: Delete fixed asset location with feature file
    Given user login the taskhub system
    When user navigates to "Global Setup>Fixed Asset>Location" screen
    And user delete fixed asset location
      | Key  | Fixed Asset Location Code | Fixed Asset Location Name | Company |
      | Key1 | SG                        | Singapore                 |         |
      | Key2 | VN                        | Vietnam                   |         |
      | Key3 | ML                        | Malaysia                  |         |

  Scenario Outline: Create Global Fixed Asset with feature file
    Given user login the taskhub system
    When user navigates to "Global Setup>Fixed Asset>Fixed Asset" screen
    And user creates global fixed asset as "<KEY FA>"
      | KEY FA | Fixed Asset Code | Description               | Detailed Specification | Fixed Asset Class | Fixed Asset Category | Depreciation Method      | Rate On Declining Balance | Percentage of Straight Line Rate | Useful Life Year | Useful Life Period | Total Useful Life | Global Status | UOM   | Volume | Gross Weight | Location | Local Info Status | Company |
      | 001    | FA1              | for Synergix Testing ONLY |                        | FA1               |                      | Straight Line per Period |                           |                                  | 1                | 0                  |                   |               | piece |        |              |          |                   |         |

    Examples:
      | KEY FA |
      | 001    |

  Scenario: Detele Global Fixed Asset with feature file
    Given user login the taskhub system
    When user navigates to "Global Setup>Fixed Asset>Fixed Asset" screen
    And user delete global fixed asset
      | KEY FA | Fixed Asset Code | Description               | Detailed Specification | Fixed Asset Class | Fixed Asset Category | Depreciation Method      | Rate On Declining Balance | Percentage of Straight Line Rate | Useful Life Year | Useful Life Period | Total Useful Life | Global Status | UOM   | Volume | Gross Weight | Location | Local Info Status | Company |
      | 001    | FA1              | for Synergix Testing ONLY |                        | FA1               |                      | Straight Line per Period |                           |                                  | 1                | 0                  |                   |               | piece |        |              |          |                   |         |

  Scenario: Create new fixed asset class
    Given user login the taskhub system
    When user navigates to "Global Setup>Fixed Asset>Class" screen
    And user creates new fixed asset class
    And user logout

  Scenario: Create new fixed asset category
    Given user login the taskhub system
    When user navigates to "Global Setup>Fixed Asset>Category" screen
    And user creates new fixed asset category
    And user logout

  Scenario: Create new fixed asset location
    Given user login the taskhub system
    When user navigates to "Global Setup>Fixed Asset>Location" screen
    And user creates new fixed asset location
    And user logout

  Scenario: Create new Global Fixed Asset
    Given user login the taskhub system
    When user navigates to "Global Setup>Fixed Asset>Fixed Asset" screen
    And user creates new global fixed asset
    And user logout
