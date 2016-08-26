@vincent_test_only
Feature: Verify Unit Cost of PO that generated from direct SO - Margin On Off

  Scenario Outline: Test Only
    #Given user login the taskhub system
    When Table A
      | Col1      | Col2      | Col3      | Col4      | Col5      |
      | Row1 Val1 | Row1 Val2 | Row1 Val3 | Row1 Val4 | Row1 Val5 |
      | Row2 Val1 | Row2 Val2 | Row2 Val3 | Row2 Val4 | Row2 Val5 |
      | Row3 Val1 | Row3 Val2 | Row3 Val3 | Row3 Val4 | Row3 Val5 |
    When Table B
      | Col6      | Col1       | Col2       | Col3       | Col4       | Col5      | Col7      |
      | Row1 Val6 | Row1 Val11 | Row1 Val2  | Row1 Val3  | Row1 Val44 | Row1 Val5 | Row1 Val7 |
      | Row2 Val6 | Row2 Val1  | Row2 Val22 | Row2 Val3  | Row2 Val44 | Row2 Val5 | Row2 Val7 |
      | Row3 Val6 | Row3 Val1  | Row3 Val2  | Row3 Val33 | Row3 Val44 | Row3 Val5 | Row3 Val7 |
    When Vincent Test
    Then user previews result of "TEST1" Soft Assertion
    Then user previews result of "TEST2" Soft Assertion
    Then user previews result of "TEST3" Soft Assertion
    Then user previews result of "TEST4" Soft Assertion
    Then user previews failure result of "TEST1" Soft Assertion
    Then user previews failure result of "TEST2" Soft Assertion
    Then user previews failure result of "TEST3" Soft Assertion
    Then user previews failure result of "TEST4" Soft Assertion
    #Then user previews failure result of Soft Assertion
    #Then user verifies failure result of Soft Assertion
    Then user verifies result of "TEST1" Soft Assertion and show failure result

    #Then user clears result of "ABC" Soft Assertion
    #Then user clears result of Soft Assertion
    #Then user previews result of "ABC" Soft Assertion
    #Then user previews result of Soft Assertion
    #Then user verifies result of "ABC" Soft Assertion
    #Then user verifies result of Soft Assertion
    #When Vincent Test Test
    Examples: 
      | Vincent Test KEY |
      | 001              |
