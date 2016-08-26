Feature: Create User Acc and Set Role

  #Aglias
  # @n-userRole
  Scenario Outline: Create User Acc
    Given user login the TH6 system
    And user navigates to "Master Setup>Employee & Approving Officer>Employee>[2]" screen
    When user create new account as "<KEY>"
      | KEY | Employee Code | Employee Name (NRIC/FIN/Bank account) | Date of Birth | Company | User Name | Password |
      | 001 | coralie2      | Coralie Synergix Team                 |               |         | coralie   | taskhub  |
      | 002 | haoxun2       | Haoxun Synergix Team                  |               |         | haoxun    | taskhub  |
      | 003 | james2        | James Synergix Team                   |               |         | james     | taskhub  |
      | 004 | jimmy2        | Jimmy Synergix Team                   |               |         | jimmy     | taskhub  |
      | 005 | kate2         | Kate Synergix Team                    |               |         | kate      | taskhub  |
      | 006 | levin2        | Levin Synergix Team                   |               |         | levin     | taskhub  |
      | 007 | mia2          | Mia Synergix Team                     |               |         | mia       | taskhub  |
      | 008 | phoebe2       | Phoebe Synergix Team                  |               |         | phoebe    | taskhub  |
      | 009 | angela2       | Angela Synergix Team                  |               |         | angela    | taskhub  |
      | 010 | grace2        | Grace Synergix Team                   |               |         | grace     | taskhub  |
      | 011 | queenie2      | Queenie Synergix Team                 |               |         | queenie   | taskhub  |
      | 012 | rachel2       | Rachel Synergix Team                  |               |         | rachel    | taskhub  |
      | 013 | sarah2        | Sarah Synergix Team                   |               |         | sarah     | taskhub  |
      | 014 | tammy2        | Tammy Synergix Team                   |               |         | tammy     | taskhub  |

    Examples: 
      | KEY |
      | 001 |
      | 002 |
      | 003 |
      | 004 |
      | 005 |
      | 006 |
      | 007 |
      | 008 |
      | 009 |
      | 010 |
      | 011 |
      | 012 |
      | 013 |
      | 014 |

  Scenario: Set Role
    Given user login the TH6 system
    And user navigates to "Master Setup>Security>User Role Access" screen
    When user set role for user
      | User Name |
      | coralie   |
      | haoxun    |
      | james     |
      | jimmy     |
      | kate      |
      | levin     |
      | mia       |
      | phoebe    |
      | angela    |
      | grace     |
      | queenie   |
      | rachel    |
      | sarah     |
      | tammy     |
