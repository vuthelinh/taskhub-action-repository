Feature: Create User Acc and Set Role

  # ADPL
  Scenario Outline: Create User Acc
    Given user login the TH6 system
    And user navigates to "Master Setup>Employee & Approving Officer>Employee>[2]" screen
    When user create new account as "<KEY>"
      | KEY | Employee Code | Employee Name (NRIC/FIN/Bank account) | Date of Birth | Company | User Name    | Password |
      | 002 | gaby2         | Gaby Synergix Team                    |               |         | gaby         | taskhub  |
      | 003 | grace2        | Grace Synergix Team                   |               |         | grace        | taskhub  |
      | 004 | kate2         | Kate Synergix Team                    |               |         | kate         | taskhub  |
      | 005 | jimmy2        | Jimmy Synergix Team                   |               |         | jimmy        | taskhub  |
      | 006 | phoebe2       | Phoebe Synergix Team                  |               |         | phoebe       | taskhub  |
      | 007 | rachel2       | Rachel Synergix Team                  |               |         | rachel       | taskhub  |
      | 008 | hongyong2     | Hong Yong Synergix Team               |               |         | hongyong     | taskhub  |
      | 009 | james2        | James Synergix Team                   |               |         | james        | taskhub  |
      | 010 | adela2        | Adela Synergix Team                   |               |         | adela        | taskhub  |
      | 011 | sophia2       | Sophia Synergix Team                  |               |         | sophia       | taskhub  |
      | 012 | swift2        | Swift Synergix Team                   |               |         | swift        | taskhub  |
      | 013 | angela2       | Angela Synergix Team                  |               |         | angela       | taskhub  |
      | 014 | iris2         | Iris Synergix Team                    |               |         | iris         | taskhub  |
      | 015 | sarah2        | Sarah Synergix Team                   |               |         | sarah        | taskhub  |
      | 016 | nancy1        | Nancy Synergix Team                   |               |         | nancy        | taskhub  |
      | 017 | nancy2        | Nancy Nguyen Synergix Team            |               |         | nancy.nguyen | taskhub  |
      | 018 | raymond2      | Raymond Synergix Team                 |               |         | raymond      | taskhub  |
      | 019 | sean2         | Sean Synergix Team                    |               |         | sean         | taskhub  |
      | 020 | tammy2        | Tammy Synergix Team                   |               |         | tammy        | taskhub  |
      | 021 | tracy2        | Tracy Synergix Team                   |               |         | tracy        | taskhub  |
      | 022 | wendy2        | Wendy Synergix Team                   |               |         | wendy        | taskhub  |

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
      | 015 |
      | 016 |
      | 017 |
      | 018 |
      | 019 |
      | 020 |
      | 021 |
      | 022 |

  Scenario: Set Role
    Given user login the TH6 system
    And user navigates to "Master Setup>Security>User Role Access" screen
    When user set role for user
      | User Name    |
      | gaby         |
      | grace        |
      | kate         |
      | jimmy        |
      | phoebe       |
      | rachel       |
      | hongyong     |
      | james        |
      | adela        |
      | sophia       |
      | swift        |
      | angela       |
      | iris         |
      | sarah        |
      | nancy        |
      | nancy.nguyen |
      | raymond      |
      | sean         |
      | tammy        |
      | tracy        |
      | wendy        |
