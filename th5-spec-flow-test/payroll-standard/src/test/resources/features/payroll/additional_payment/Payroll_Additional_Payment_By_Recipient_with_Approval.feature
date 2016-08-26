@vincent @additional_payment_by_recipient_2
Feature: Test for Payroll Additional Payment Standard
  Test-condition:
  Enable Employee Payroll Security - Yes
  Enable Inclusive Sales Tax - Yes
  Overwrite Sales Tax Code - Yes
  Enable Approval For Additional Payment - No

  Scenario Outline: Test for Payroll Additional Payment Standard
    Given user logins to Task Hub as "<Login User KEY>"
      | KEY | User Name | Password | Company |
      | 001 | vincent   | taskhub  | AUTO5   |
    When user navigates to "Maintenance Setup>Module Config>Module Config" screen
    Then user changes Module Config as "<Module Config KEY>"
      | KEY | Module Section                  | Module Name                                                                                                                   | Config Type 1 | Config Value 1 | Config Type 2 | Config Value 2 |
      | 001 | Payroll>Payroll                 | Enable Inclusive Sales Tax                                                                                                    | Radio         | Yes            |               |                |
      | 001 | Payroll>Payroll                 | Enable allocate Additional Payment to different Line Item                                                                     | Radio         | Yes            |               |                |
      | 001 | Payroll>Payroll                 | Overwrite Sales Tax Code                                                                                                      | Radio         | Yes            |               |                |
      | 001 | Payroll>Payroll                 | Enable Approval for Additional Payment (By Recipient).                                                                        | Radio         | No             |               |                |
      | 001 | Project Costing>Project Costing | Enable to Post Project Cost to Expense GLAN/Revenue GLAN of Cost Item instead of Project WIP GLAN (exclude Payroll Timesheet) | Radio         | Yes            |               |                |
      | 003 | Payroll>Payroll                 | Enable Approval for Additional Payment (By Recipient).                                                                        | Radio         | No             |               |                |
      | 004 | Payroll>Payroll                 | Enable allocate Additional Payment to different Line Item                                                                     | Radio         | No             |               |                |
    When user navigates to "Processing>Payroll>Additional Payment" screen
    Then page header shouble be "Additional Payment"
    When user creates new voucher in Draft state of Additional Payment by Recipient
    Then all information in Draft state of Additional Payment by Recipient should be pulled out as "<Additional Payment KEY>"
      | KEY | Voucher No | Voucher Type | Voucher Date | Description |
      | 001 | @NotBlank@ | By Recipient |              | @Blank@     |
    Then user inputs data for new voucher in Draft state of Additional Payment by Recipient as "<Recipient KEY>"
      | KEY | Description               | Voucher Date | Recipients Code | Recipients Name | Payroll Date  |
      | 001 | Test for Add payment by R |              | VINCENT1        |                 | @CurrentDate@ |
    Then user add data for Wage Services in Draft state of Additional Payment by Recipient as "<Wage Services KEY>"
      | KEY | No | Wage Service | Wage Service Description | Voucher Date | Ccy | Exchange Rate | Qty | Unit Price | Inclusive Tax | Sales Tax Code Default | Sales Tax Edit | Nature Amt Before Tax | Nature Amt After Tax | Commission Start Date | Commission End Date | Monthly Commission | Alloc Voucher No | Phase Sequence No | LI No |
      | 001 | 1  | ISALARY      |                          |              | SGD | 1.0           | 1   | 10         | Yes           | GST0                   |                | 10                    | 10                   |                       |                     |                    | PJE0000001       | 1                 |       |
      | 001 | 2  | IBONUS       |                          |              | SGD | 1.0           | 1   | 10         | Yes           | GST0                   |                | 10                    | 10                   |                       |                     |                    | PJE0000001       | 1                 |       |
      | 001 | 3  | ICOMMISSION  |                          |              | SGD | 1.0           | 1   | 20         | Yes           | GST0                   |                | 20                    | 20                   | 02/08/2016            | 02/08/2016          | No                 | PJE0000001       | 1                 |       |
      | 001 | 4  | IDIRECTFEE   |                          |              | SGD | 1.0           | 1   | 30         | Yes           | GST0                   |                | 30                    | 30                   |                       |                     |                    | PJE0000001       | 1                 |       |
      | 001 | 5  | IINSURANCE   |                          |              | SGD | 1.0           | 1   | 30         | No            | GST0                   |                | 30                    | 30                   |                       |                     |                    | PJE0000002       | 1                 |       |
      | 001 | 6  | IPENSIONS    |                          |              | SGD | 1.0           | 1   | 40         | No            | GST0                   |                | 40                    | 40                   |                       |                     |                    | PJE0000002       | 1                 |       |
      | 001 | 7  | ITRANSALLO   |                          |              | SGD | 1.0           | 1   | 30         | Yes           | GST0                   |                | 30                    | 30                   |                       |                     |                    | PJE0000002       | 1                 |       |
      | 001 | 8  | IENTERALLO   |                          |              | SGD | 1.0           | 1   | 55         | Yes           | GST0                   | GST10          | 55                    | 55                   |                       |                     |                    | PJE0000002       | 1                 |       |
      | 001 | 9  | IOTHERALLO   |                          |              | SGD | 1.0           | 1   | 50         | No            | GST0                   | GST10          | 50                    | 55                   |                       |                     |                    |                  |                   |       |
      | 001 | 10 | IGRATUITY    |                          |              | SGD | 1.0           | 1   | 60         | Yes           | GST0                   |                | 60                    | 60                   |                       |                     |                    |                  |                   |       |
      | 001 | 11 | ICOMPENSA    |                          |              | SGD | 1.0           | 1   | 60         | Yes           | GST0                   |                | 60                    | 60                   |                       |                     |                    |                  |                   |       |
      | 001 | 12 | IRETIRE92    |                          |              | SGD | 1.0           | 1   | 70         | Yes           | GST0                   |                | 70                    | 70                   |                       |                     |                    |                  |                   |       |
      | 001 | 13 | IRETIRE93    |                          |              | SGD | 1.0           | 1   | 70         | Yes           | GST0                   |                | 70                    | 70                   |                       |                     |                    |                  |                   |       |
      | 001 | 14 | IPENSIONO    |                          |              | SGD | 1.0           | 1   | 10         | Yes           | GST0                   |                | 10                    | 10                   |                       |                     |                    |                  |                   |       |
      | 001 | 15 | IEXCESSCPF   |                          |              | SGD | 1.0           | 1   | 10         | Yes           | GST0                   |                | 10                    | 10                   |                       |                     |                    |                  |                   |       |
      | 001 | 16 | ISTOCK       |                          |              | SGD | 1.0           | 1   | 10         | Yes           | GST0                   |                | 10                    | 10                   |                       |                     |                    |                  |                   |       |
      | 001 | 17 | IBENEFIT     |                          |              | SGD | 1.0           | 1   | 10         | Yes           | GST0                   |                | 10                    | 10                   |                       |                     |                    |                  |                   |       |
      | 002 | 1  | SALARYY      |                          |              | SGD | 1.0           | 5   | 10         | Yes           | GST0                   |                | 50                    | 50                   |                       |                     |                    |                  |                   |       |
      | 003 | 1  | BONUSY       |                          |              | SGD | 1.0           | 2   | 50         | Yes           | GST0                   |                | 100                   | 100                  |                       |                     |                    |                  |                   |       |
      | 004 | 1  | ISALARY      |                          |              | SGD | 1.0           | 1   | 100        | Yes           | GST0                   |                | 100                   | 100                  |                       |                     |                    |                  |                   |       |
      | 004 | 2  | SALARYY      |                          |              | SGD | 1.0           | 2   | 100        | Yes           | GST0                   |                | 200                   | 200                  |                       |                     |                    | PJE0000001       | 3                 |       |
      | 004 | 3  | SALARYY      |                          |              | SGD | 1.0           | 3   | 100        | Yes           | GST0                   |                | 300                   | 300                  |                       |                     |                    | PJE0000001       | 4                 |       |
      | 004 | 4  | SALARYN      |                          |              | SGD | 1.0           | 4   | 100        | Yes           | GST0                   |                | 400                   | 400                  |                       |                     |                    | PJE0000001       | 1                 |       |
      | 004 | 5  | BONUSY       |                          |              | SGD | 1.0           | 2   | 500        | Yes           | GST0                   |                | 1000                  | 1000                 |                       |                     |                    | PJE0000001       | 5                 |       |
      | 005 | 1  | SALARYN      |                          |              | SGD | 1.0           | 2   | 100        | Yes           | GST0                   |                | 200                   | 200                  |                       |                     |                    | PJE0000001       | 2                 | 1     |
      | 006 | 1  | BONUSY       |                          |              | SGD | 1.0           | 2   | 250        | Yes           | GST0                   |                | 500                   | 500                  |                       |                     |                    | PJE0000001       | 2                 | 2     |
    Then user input Remarks in Draft state of Additional Payment by Recipient as as "<Remarks KEY>"
      | KEY | Internal Remark Code | Internal Remarks          | External Remark Code | External Remarks          |
      | 001 |                      | Internal Remarks for EMP1 |                      | External Remarks for EMP1 |
    Then user submits created voucher in Draft state of Additional Payment by Recipient
    Then user opens created voucher in Pending Approval state of Additional Payment by Recipient
    Given user logins to Task Hub as "<Login User 2nd KEY>"
      | KEY | User Name    | Password | Company |
      | 001 | vincent.tran | taskhub  | AUTO5   |
      | 002 | vincent      | taskhub  | AUTO5   |
    When user navigates to "Processing>Approval>Approval Summary>[2]" screen
    Then user selects Transaction in Approval Summary as "<Approval Summary KEY>"
      | KEY | Module Code Desc | Transaction Type Desc            |
      | 001 | Payroll          | Additional Payment(By Recipient) |
    Then user submits Approval Action for Additional Payment Voucher No. as "<Approval KEY>"
      | KEY | Additional Payment Voucher No. | Payroll Date | Recipient Code | Recipient Name        | Remarks                  | Action  |
      | 001 | @CREATEDADDPAYMENTVOUCHER@     | 02/08/2016   | VINCENT1       | Vincent Synergix Team | Approve Remarks for EMP1 | Approve |
    Then user opens created voucher in Outstanding state of Additional Payment by Recipient
    Then user checks number of records in database as "<SQL Statement KEY>"
      | KEY | SQL Count Statement                                                        | Results | Replacement 1 Data Key        | Index 1 | Replacement 2 Data Key | Index 2 |
      |     | select count(*) from gl_ledger_summary where source_voucher_no = '@@#1#@@' | ?       | Additional Payment Voucher No |         |                        |         |

    Examples: 
      | Login User KEY | Module Config KEY | Additional Payment KEY | Recipient KEY | Wage Services KEY | Remarks KEY | Login User 2nd KEY | Approval KEY |
      | 001            |                   | 001                    | 001           | 001               | 001         | 001                | 001          |
      | 001            |                   | 001                    | 001           | 001               | 001         | 001                | 001          |
      | 001            |                   | 001                    | 001           | 001               | 001         | 001                | 001          |
      | 001            |                   | 001                    | 001           | 001               | 001         | 001                | 001          |
      | 001            |                   | 001                    | 001           | 001               | 001         | 001                | 001          |
      | 001            |                   | 001                    | 001           | 001               | 001         | 001                | 001          |
