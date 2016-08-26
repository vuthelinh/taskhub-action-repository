Feature: MODI - Deluge: A0-14: Bank Book Allocation by Project

  Scenario Outline: Bank Book Allocation by Project
    Given user login the taskhub system
    And user navigates to "Operations>Bank Book>Transaction Voucher" screen
    When user create BK transaction voucher as "<KEY BK>"
      | KEY BK | Bank Voucher No | Bank Voucher Description | Received From/Payee Name | Transaction Type |
      |    001 | BK00002TRN      |                          | Deposit Received From    | Deposit          |
      |    002 | BK00009TRN      |                          |                          | Fund Transfer    |
      |    003 | BK00011TRN      |                          | Withdrawal Payee Name    | Withdrawal       |
    And BK transaction voucher is deposit as "<KEY BK>"
      | KEY BK | Mode of Deposit | Bank Vch Date | Deposit Slip Date | Bank Party Code | Bank Account No | Currency | Cross Rate | SBU Code | Value Date | Cheque No. | Deposit Slip No | Deposit Bank Exch Rate | Exch Rate | Default Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |    001 |                 |               |                   | Bank01          |           12345 | SGD      |            |          |            |            |                 |                        |           |                   | na        | na        | na        | na        |
    And BK deposit transaction voucher is add detail as "<KEY BK>"
      | KEY BK | Line Items | Credit/Debit | Received From | Amount | Sales Tax | Document No | Doc Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Expected Message |
      |    001 |            |              | S1            |  10000 |           |             |          | na        | na        | na        | na        |                  |
   # And BK transaction voucher is fund transfer as "<KEY BK>"
      | KEY BK | Mode of Transfer | Bank Vch Date | Transfer Advice Date | Remittance Bank A/C Name | Remittance Bank A/C No | Destination Bank A/C Name | Destination Bank A/C No | Transfer Amount | Cross Rate | Value Date | Transfer Advice No | Remittance Bank Exch Rate | Destination Bank Exch Rate | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |    002 |                  |               |                      | Bank01                   |                  12345 | Bank02                    |                   54321 |           10000 |            |            |                123 |                       1.1 |                        1.2 | na        | na        | na        | na        |
    And BK transaction voucher is withdrawal as "<KEY BK>"
      | KEY BK | Mode of Withdrawal | Bank Vch Date | Withdrawal Slip Date | Bank Party Code | Bank Account No | Currency | SBU Code | Value Date | Cheque No. | Withdrawal Slip No | Withdrawal Bank Exch Rate | Exch Rate | Default Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |    003 |                    |               |                      | Bank01          |           12345 | USD      |          |            |            |                    |                           |           |                   | na        | na        | na        | na        |
    And BK withdrawal transaction voucher is add detail as "<KEY BK>"
      | KEY BK | Line Items | Credit/Debit | Paid to | Cheque No. | Amount | Sales Tax | Document No | Doc Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Expected Message |
      |    003 |            |              | S1      |            |  50000 |           |             |          | na        | na        | na        | na        |                  |
    And BK transaction preview report "Standard Bank Voucher"
    And BK transaction is submitted
    #And BK transaction preview at history tab with report name "Standard Bank Voucher"

    Examples: 
      | KEY BK |
      |    001 |
      |    002 |
      |    003 |

  Scenario Outline: MODI - Bank Book Allocation by Project
    Given user login the taskhub system
    And user navigates to "Operations>Bank Book>Transaction Voucher" screen
    When user create BK transaction voucher as "<KEY BK>"
      | KEY BK | Bank Voucher No | Bank Voucher Description | Received From/Payee Name | Transaction Type |
      |    001 |                 | Scenario 1               | Deposit Received From    | Deposit          |
      |    002 |                 | Scenario 2               | Deposit Received From    | Deposit          |
      |    003 |                 | Scenario 3               | Deposit Received From    | Deposit          |
      |    004 |                 | Scenario 4               | Deposit Received From    | Deposit          |
      |    005 |                 | Scenario 5               | Deposit Received From    | Deposit          |
      |    006 |                 | Scenario 6               | Deposit Received From    | Deposit          |
      |    007 |                 | Scenario 7               | Withdrawal Payee Name    | Withdrawal       |
      |    008 |                 | Scenario 8               | Withdrawal Payee Name    | Withdrawal       |
      |    009 |                 | Scenario 9               | Withdrawal Payee Name    | Withdrawal       |
      |    010 |                 | Scenario 10              | Withdrawal Payee Name    | Withdrawal       |
      |    011 |                 | Scenario 11              | Withdrawal Payee Name    | Withdrawal       |
      |    012 |                 | Scenario 12              | Withdrawal Payee Name    | Withdrawal       |
    And BK transaction voucher is deposit as "<KEY BK>"
      | KEY BK | Mode of Deposit | Bank Vch Date | Deposit Slip Date | Bank Party Code | Bank Account No | Currency | Cross Rate | SBU Code | Value Date | Cheque No. | Deposit Slip No | Deposit Bank Exch Rate | Exch Rate | Default Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |    001 | Cash            | 12/07/2016    | 12/07/2016        | Bank01          |           12345 | SGD      |            |          | 12/07/2016 |        123 |                 |                        |           | gst7              | na        | na        | na        | na        |
      |    002 | ePayment        | 12/07/2016    | 12/07/2016        | Bank01          |           12345 | SGD      |            |          | 12/07/2016 |        123 |                 |                        |           | gst7              | na        | na        | na        | na        |
      |    003 | ePayment        | 12/07/2016    | 12/07/2016        | Bank01          |           12345 | SGD      |            |          | 12/07/2016 |        123 |                 |                        |           | gst7              | na        | na        | na        | na        |
      |    004 | ePayment        | 12/07/2016    | 12/07/2016        | Bank01          |           12345 | SGD      |            |          | 12/07/2016 |        123 |                 |                        |           | gst7              | na        | na        | na        | na        |
      |    005 | ePayment        | 12/07/2016    | 12/07/2016        | Bank01          |           12345 | SGD      |            |          | 12/07/2016 |        123 |                 |                        |           | gst7              | na        | na        | na        | na        |
      |    006 | ePayment        | 12/07/2016    | 12/07/2016        | Bank01          |           12345 | SGD      |            |          | 12/07/2016 |        123 |                 |                        |           | gst7              | na        | na        | na        | na        |
    And BK deposit transaction voucher is add detail as "<KEY BK>"
      | KEY BK | Line Items | Credit/Debit | Received From | Amount | Sales Tax | Document No | Doc Date | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Expected Message |
      |      1 |          1 | Credit       | S1            |   1000 | gst0      | Testing     |    42711 | na        | na        | na        | na        | AAAAAA           |
      |      2 |          1 | Credit       | S1            |   1000 | gst0      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      2 |          2 | Debit        | S2            |    800 | gst0      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      3 |          1 | Credit       | S1            |   1000 | gst0      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      3 |          2 | Debit        | S2            |    200 | gst0      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      3 |          3 | Debit        | S1            |    300 | gst0      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      3 |          4 | Debit        | S2            |    400 | gst0      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      4 |          1 | Credit       | S1            |   1000 | gst7      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      4 |          2 | Credit       | S1            |   2000 | gst7      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      4 |          3 | Credit       | S1            |   3000 | gst7      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      5 |          1 | Credit       | S1            |   1000 | gst7      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      5 |          2 | Credit       | S2            |   2000 | gst7      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      5 |          3 | Credit       | S1            |   3000 | gst7      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      5 |          4 | Debit        | S2            |   4000 | gst7      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      6 |          1 | Credit       | S1            |   1000 | gst7      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      6 |          2 | Credit       | S2            |   2000 | gst7      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      6 |          3 | Credit       | S1            |   3000 | gst7      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      6 |          4 | Debit        | S2            |    500 | gst7      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      6 |          5 | Debit        | S1            |   1500 | gst7      | Testing     |    42711 | na        | na        | na        | na        |                  |
      |      6 |          6 | Debit        | S2            |   2500 | gst7      | Testing     |    42711 | na        | na        | na        | na        |                  |
    And BK transaction voucher is withdrawal as "<KEY BK>"
      | KEY BK | Mode of Withdrawal | Bank Vch Date | Withdrawal Slip Date | Bank Party Code | Bank Account No | Currency | SBU Code | Value Date | Cheque No. | Withdrawal Slip No | Withdrawal Bank Exch Rate | Exch Rate | Default Sales Tax | Segment 1 | Segment 2 | Segment 3 | Segment 4 |
      |    007 | Giro               | 12/07/2016    | 13/07/2016           | Bank01          |           12345 | USD      |          | 12/07/2016 |        123 |                    |                       1.1 |       1.2 | gst7              | na        | na        | na        | na        |
      |    008 | Giro               | 12/07/2016    | 13/07/2016           | Bank01          |           12345 | USD      | Code     | 12/07/2016 |            |                    |                           |           | gst7              | na        | na        | na        | na        |
      |    009 | Giro               | 12/07/2016    | 13/07/2016           | Bank01          |           12345 | USD      | Code     | 12/07/2016 |            |                    |                           |           | gst7              | na        | na        | na        | na        |
      |    010 | Giro               | 12/07/2016    | 13/07/2016           | Bank01          |           12345 | USD      | Code     | 12/07/2016 |            |                    |                           |           | gst7              | na        | na        | na        | na        |
      |    011 | Giro               | 12/07/2016    | 13/07/2016           | Bank01          |           12345 | USD      | Code     | 12/07/2016 |            |                    |                           |           | gst7              | na        | na        | na        | na        |
      |    012 | Giro               | 12/07/2016    | 13/07/2016           | Bank01          |           12345 | USD      | Code     | 12/07/2016 |            |                    |                           |           | gst7              | na        | na        | na        | na        |
    And BK withdrawal transaction voucher is add detail as "<KEY BK>"
      | KEY BK | Line Items | Credit/Debit | Paid to | Cheque No. | Amount | Sales Tax | Document No | Doc Date   | Segment 1 | Segment 2 | Segment 3 | Segment 4 | Expected Message |
      |    007 |          1 | Debit        | S1      |          1 |    800 | gst0      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    008 |          1 | Debit        | S1      |          1 |   1500 | gst0      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    008 |          2 | Credit       | S2      |          1 |    800 | gst0      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    009 |          1 | Debit        | S1      |          1 |   2000 | gst0      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    009 |          2 | Credit       | S2      |          1 |    200 | gst0      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    009 |          3 | Credit       | S2      |          1 |    500 | gst0      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    009 |          4 | Credit       | S2      |          1 |   1300 | gst0      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    010 |          1 | Debit        | S1      |          1 |    200 | gst7      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    010 |          2 | Debit        | S1      |          1 |    300 | gst7      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    010 |          3 | Debit        | S1      |          1 |    400 | gst7      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    011 |          1 | Debit        | S1      |          1 |    350 | gst7      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    011 |          2 | Debit        | S1      |          1 |    450 | gst7      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    011 |          3 | Debit        | S1      |          1 |    500 | gst7      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    011 |          4 | Credit       | S2      |          1 |    800 | gst7      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    012 |          1 | Debit        | S2      |          1 |    200 | gst7      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    012 |          2 | Debit        | S2      |          1 |    700 | gst7      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    012 |          3 | Debit        | S2      |          1 |    600 | gst7      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    012 |          4 | Credit       | S1      |          1 |    200 | gst7      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    012 |          5 | Credit       | S1      |          1 |    300 | gst7      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
      |    012 |          6 | Credit       | S1      |          1 |    800 | gst7      | testing     | 12/07/2016 | na        | na        | na        | na        |                  |
    And BK transaction voucher is add allocation as "<KEY BK>"
      | KEY BK | Li No. | Type    | OA Code | Voucher No. | Phase Sequence No. | LI No. | Allocation Amt | Delete | Sel | Expected Message |
      |    002 |      1 | Project |         | PRJ001      |                  1 |        |            400 |        |     |                  |
      |    003 |      1 | Project |         | PRJ001      |                  1 |        |            200 |        |     |                  |
      |    003 |      1 | Project |         | PRJ001      |                  2 |        |            300 |        |     |                  |
      |    003 |      1 | Project |         | PRJ001      |                  3 |        |            500 |        |     |                  |
      |    005 |      3 | Project |         | PRJ001      |                  1 |        |            400 |        |     |                  |
      |    005 |      3 | Project |         | PRJ002      |                  1 |        |            600 |        |     |                  |
      |    005 |      3 | Project |         | PRJ003      |                  1 |        |            800 |        |     |                  |
      |    006 |      2 | Project |         | PRJ001      |                  1 |        |            500 |        |     |                  |
      |    006 |      2 | Project |         | PRJ001      |                  2 |        |           1500 |        |     |                  |
      |    006 |      2 | Project |         | PRJ001      |                  3 |        |           1000 |        |     |                  |
      |    006 |      2 | Project |         | PRJ002      |                  1 |        |            200 |        |     |                  |
      |    006 |      2 | Project |         | PRJ002      |                  2 |        |            400 |        |     |                  |
      |    006 |      2 | Project |         | PRJ002      |                  3 |        |            600 |        |     |                  |
      |    006 |      2 | Project |         | PRJ003      |                  1 |        |            800 |        |     |                  |
      |    006 |      2 | Project |         | PRJ003      |                  2 |        |            500 |        |     |                  |
      |    006 |      2 | Project |         | PRJ003      |                  3 |        |            500 |        |     |                  |
      |    008 |      1 | Project |         | PRJ001      |                  1 |        |            300 |        |     |                  |
      |    008 |      1 | Project |         | PRJ001      |                  2 |        |            600 |        |     |                  |
      |    008 |      1 | Project |         | PRJ001      |                  3 |        |            100 |        |     |                  |
      |    009 |      1 | Project |         | PRJ001      |                  1 |        |            400 |        |     |                  |
      |    009 |      1 | Project |         | PRJ002      |                  1 |        |            800 |        |     |                  |
      |    009 |      1 | Project |         | PRJ003      |                  1 |        |            800 |        |     |                  |
      |    011 |      3 | Project |         | PRJ001      |                  1 |        |             50 |        |     |                  |
      |    011 |      3 | Project |         | PRJ001      |                  2 |        |            100 |        |     |                  |
      |    011 |      3 | Project |         | PRJ001      |                  3 |        |            150 |        |     |                  |
      |    011 |      3 | Project |         | PRJ002      |                  1 |        |            200 |        |     |                  |
      |    011 |      3 | Project |         | PRJ002      |                  2 |        |            250 |        |     |                  |
      |    011 |      3 | Project |         | PRJ002      |                  3 |        |            300 |        |     |                  |
      |    011 |      3 | Project |         | PRJ003      |                  1 |        |            350 |        |     |                  |
      |    011 |      3 | Project |         | PRJ003      |                  2 |        |            400 |        |     |                  |
      |    011 |      3 | Project |         | PRJ003      |                  3 |        |            450 |        |     |                  |
      |    012 |      2 | Project |         | PRJ001      |                  1 |        |            800 |        |     |                  |
    And BK transaction preview report "Standard Bank Voucher"
    And BK transaction is submitted
    Then verify expected result of BK transaction deposit
    Then verify expected result of BK transaction withdrawal

    Examples: 
      | KEY BK |
      |    001 |
      |    007 |
