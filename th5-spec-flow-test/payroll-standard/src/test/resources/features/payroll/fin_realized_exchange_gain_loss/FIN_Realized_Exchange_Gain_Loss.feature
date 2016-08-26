@realized_exchange_gain_loss
Feature: Realized Exchange Gain/Loss

  Background: Prepare
    Given "rachel" login to "(TRG6)" company with password is "taskhub"
    Given user access DB "jdbc:db2://172.18.0.10:50000/GENMAIN6" with id "db2admin" and password "Taskhub1"

  Scenario: Realized Exchange Gain/Loss
#  Scenario: 1. Ost Receipt applies to invoices after revaluation. All vouchers are of different foreign ccies
    Given user create new AR Invoice
      | Invoice No | Customer | Invoice Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | INV01      | Nina     | 30/06/2016   | USD      | GST0%             | 1.3           | S    | NA        | 1       | 150        | Y      |
      | INV02      | Nina     | 30/06/2016   | MYR      | GST0%             | 0.5           | S    | NA        | 1       | 80         | Y      |
    Given user create new AR Receipt
      | Receipt No | Customer | Receipt Date | Currency | Exchange Rate | Bank Name | Pymt Method | Pymt Amt | Submit |
      | REC01      | Nina     | 30/06/2016   | AUD      | 1.1           | VIB       | Cash        | 100      | Y      |
      | REC02      | Nina     | 30/06/2016   | SGD      | 1             | VIB       | Cash        | 75       | Y      |
    When user do AR revaluation
      | Revaluation Voucher Date | Currency | Exchange Rate |
      | 30/06/2016               | USD      | 1.35          |
      |                          | AUD      | 1.05          |
      |                          | MYR      | 0.5           |
    When user do application
      | Application From | Application To | Rec Amt | Rec Home Amt | Inv Amt | Inv Home Amt | Realized Exch | Submit |
      | REC01            | INV01          | 60      | 66           | 50      | 65           | -1            |        |
      |                  | INV02          | 35      | 38.5         | 80      | 40           | 1.5           | Y      |
    Then system will have to check data as "Scenario 1" with desc "Ost Receipt applies to invoices after revaluation. All vouchers are of different foreign ccies"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | REC01      | AR          | RC                    | E             | MYR           |             | 0.50      | 0            | 0             | 1.50       | 0           |
      |            | AR          | RC                    | E             | USD           |             | 1.30      | 0            | 0             | 0          | 1.00        |
      |            | AR          | RC                    | Q             | AUD           |             | 1.10      | 100          | 0             | 110        | 0           |
      |            | AR          | RC                    | R             | AUD           |             | 1.10      | 0            | 100           | 0          | 110         |
      |            | AR          | RC                    | R             | AUD           |             | 1.10      | 95.00        | 0             | 104.50     | 0           |
      |            | AR          | RC                    | R             | MYR           |             | 0.50      | 0            | 80            | 0          | 38.50       |
      |            | AR          | RC                    | R             | USD           |             | 1.30      | 0            | 50            | 0          | 66.00       |
      |            | AR          | RC                    | R             | MYR           |             | 0.50      | 0            | 0             | 0          | 1.50        |
      |            | AR          | RC                    | R             | USD           |             | 1.30      | 0            | 0             | 1.00       | 0           |
      |            | AR          | RV                    | R             | USD           |             | 1.35      | 0            | 0             | 0          | 2.50        |
      |            | AR          | RV                    | R             | AUD           |             | 1.05      | 0            | 0             | 0          | 4.75        |
      |            | AR          | RV                    | U             | USD           |             | 1.35      | 0            | 0             | 2.50       | 0           |
      |            | AR          | RV                    | U             | AUD           |             | 1.05      | 0            | 0             | 4.75       | 0           |

#  Scenario: 2. New Receipt applies to invoice. Only invoice has been revaluated. Both are of different foreign ccies
    Given user create new AR Receipt
      | Receipt No | Customer | Receipt Date | Currency | Exchange Rate | Bank Name | Pymt Method | Pymt Amt | Submit |
      | REC03      | Nina     | 30/06/2016   | AUD      | 1.2           | VIB       | Cash        | 60       | N      |
    When user do application
      | Application From | Application To | Rec Amt | Rec Home Amt | Inv Amt | Inv Home Amt | Realized Exch | Submit |
      | REC03            | INV01          | 60      | 72           | 50      | 65           | -7            | Y      |
    Then system will have to check data as "Scenario 2" with desc "New Receipt applies to invoice. Only invoice has been revaluated. Both are of different foreign ccies"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | REC03      | AR          | RC                    | E             | USD           |             | 1.30      | 0.00         | 0.00          | 0.00       | 7.00        |
      |            | AR          | RC                    | Q             | AUD           |             | 1.20      | 60.00        | 0.00          | 72.00      | 0.00        |
      |            | AR          | RC                    | R             | AUD           |             | 1.20      | 0.00         | 60.00         | 0.00       | 72.00       |
      |            | AR          | RC                    | R             | AUD           |             | 1.20      | 60.00        | 0.00          | 72.00      | 0.00        |
      |            | AR          | RC                    | R             | USD           |             | 1.30      | 0.00         | 50.00         | 0.00       | 72.00       |
      |            | AR          | RC                    | R             | USD           |             | 1.30      | 0.00         | 0.00          | 7.00       | 0.00        |
      |            | AR          | RV                    | R             | USD           |             | 1.35      | 0.00         | 0.00          | 0.00       | 2.50        |
      |            | AR          | RV                    | U             | USD           |             | 1.35      | 0.00         | 0.00          | 2.50       | 0.00        |

#  Scenario: 3. Payment refund applies to receipt. Only receipt has been revaluated. Both are of same foreign ccies
    Given user create new Payment to Customer
      | Application From | Application To | Payment Voucher Date | Customer | Bank | Currency | Payment Amt | Payment Home Amt | Exchange Rate | Rec Amt | Rec Home Amt | Realized Exch | Submit |
      | PAY01            | REC01          | 30/06/2016           | Nina     | VIB  | AUD      | 5           | 5.4              | 1.08          | 5       | 5.50         | 0.1           | Y      |
    Then system will have to check data as "Scenario 3" with desc "Payment refund applies to receipt. Only receipt has been revaluated. Both are of same foreign ccies"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | PAY01      | AP          | PY                    | C             | AUD           |             | 1.08      | 0.00         | 5.00          | 0.00       | 5.40        |
      |            | AP          | PY                    | E             | AUD           |             | 1.10      | 0.00         | 0.00          | 0.00       | 0.10        |
      |            | AP          | PY                    | R             | AUD           |             | 1.08      | 5.00         | 0.00          | 5.40       | 0.00        |
      |            | AP          | PY                    | R             | AUD           |             | 1.10      | 0.00         | 0.00          | 0.10       | 0.00        |
      |            | AP          | RV                    | R             | AUD           |             | 1.05      | 0.00         | 0.00          | 0.00       | 0.25        |
      |            | AP          | RV                    | U             | AUD           |             | 1.05      | 0.00         | 0.00          | 0.25       | 0.00        |

#  Scenario: 4. Ost Receipt (home ccy) applies to invoice (foreign ccy). Invoice has been revaluated
    When user do application
      | Application From | Application To | Rec Amt | Rec Home Amt | Inv Amt | Inv Home Amt | Cross Rate  | Realized Exch | Submit |
      | REC02            | INV01          | 75      | 75           | 50      | 65           | 0.666666666 | -10           | Y      |
    Then system will have to check data as "Scenario 4" with desc "Ost Receipt (home ccy) applies to invoice (foreign ccy). Invoice has been revaluated"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | REC02      | AR          | RC                    | E             | USD           |             | 1.30      | 0.00         | 0.00          | 0.00       | 10.00       |
      |            | AR          | RC                    | Q             | SGD           |             | 1.00      | 75.00        | 0.00          | 75.00      | 0.00        |
      |            | AR          | RC                    | R             | SGD           |             | 1.00      | 0.00         | 75.00         | 0.00       | 75.00       |
      |            | AR          | RC                    | R             | SGD           |             | 1.00      | 75.00        | 0.00          | 75.00      | 0.00        |
      |            | AR          | RC                    | R             | USD           |             | 1.30      | 0.00         | 50.00         | 0.00       | 75.00       |
      |            | AR          | RC                    | R             | USD           |             | 1.30      | 0.00         | 0.00          | 10.00      | 0.00        |
      |            | AR          | RV                    | R             | USD           |             | 1.35      | 0.00         | 0.00          | 0.00       | 2.50        |
      |            | AR          | RV                    | U             | USD           |             | 1.35      | 0.00         | 0.00          | 2.50       | 0.00        |

#  Scenario: 5. New Invoice applies to receipt. Both are of different foreign ccies. Receipt is cancelled as Wrong Application
    Given user create new AR Receipt
      | Receipt No | Customer | Receipt Date | Currency | Exchange Rate | Bank Name | Pymt Method | Pymt Amt | Submit |
      | REC04      | Nina     | 30/06/2016   | AUD      | 1.1           | VIB       | Cash        | 100      | Y      |
      | REC05      | Nina     | 30/06/2016   | USD      | 1.2           | VIB       | Cash        | 50       | Y      |
    Given user create new AR Invoice
      | Invoice No | Customer | Invoice Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | INV03      | Nina     | 30/06/2016   | USD      | GST0%             | 1.3           | S    | NA        | 1       | 100        | N      |
      | INV04      | Nina     | 30/06/2016   | MYR      | GST0%             | 0.5           | S    | NA        | 1       | 80         | N      |
    When user do application
      | Application From | Application To | Rec Amt | Rec Home Amt | Inv Amt | Inv Home Amt | Realized Exch | Submit |
      | INV04            | REC04          | 35      | 38.5         | 80      | 40           | 1.5           | Y      |
    Then system will have to check data as "Scenario 5-1" with desc "New Invoice applies to receipt. Both are of different foreign ccies. Receipt is cancelled as Wrong Application"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | REC04      | AR          | RC                    | E             | MYR           |             | 0.50      | 0.00         | 0.00          | 1.50       | 0.00        |
      |            | AR          | RC                    | Q             | AUD           |             | 1.10      | 100.00       | 0.00          | 110.00     | 0.00        |
      |            | AR          | RC                    | R             | AUD           |             | 1.10      | 0.00         | 100.00        | 0.00       | 110.00      |
      |            | AR          | RC                    | R             | AUD           |             | 1.10      | 35.00        | 0.00          | 38.50      | 0.00        |
      |            | AR          | RC                    | R             | MYR           |             | 0.50      | 0.00         | 80.00         | 0.00       | 38.50       |
      |            | AR          | RC                    | R             | MYR           |             | 0.50      | 0.00         | 0.00          | 0.00       | 1.50        |
    When user cancel AR Receipt
      | Receipt Cancellation No | Receipt No | Receipt Cancellation Date | Customer | Cancellation Type            | Application Invoice No | Submit |
      | RCC01                   | REC04      | 30/06/2016                | Nina     | Wrong Application to Invoice | INV04                  | Y      |
    Then system will have to check data as "Scenario 5-2" with desc "New Invoice applies to receipt. Both are of different foreign ccies. Receipt is cancelled as Wrong Application"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | RECEIPT_CANCELLATION_TYPE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | RCC01      | AR          | RCC                   | A                         | E             | MYR           | 0003        | 0.50      | 0.00         | 0.00          | 0.00       | 1.50        |
      |            | AR          | RCC                   | A                         | R             | AUD           | 0002        | 1.10      | 0.00         | 35.00         | 0.00       | 38.50       |
      |            | AR          | RCC                   | A                         | R             | MYR           | 0002        | 0.50      | 80.00        | 0.00          | 38.50      | 0.00        |
      |            | AR          | RCC                   | A                         | R             | MYR           | 0002        | 0.50      | 0.00         | 0.00          | 1.50       | 0.00        |

#  Scenario: 6. Same receipt in scenario 5, cancelled as Void Cheque
    When user do application
      | Application From | Application To | Rec Amt | Rec Home Amt | Inv Amt | Inv Home Amt | Realized Exch | Submit |
      | REC04            | INV04          | 35      | 38.5         | 80      | 40           | 1.5           | Y      |
    When user cancel AR Receipt
      | Receipt Cancellation No | Receipt No | Receipt Cancellation Date | Customer | Cancellation Type                 | Application Invoice No | Submit |
      | RCC02                   | REC04      | 30/06/2016                | Nina     | Dishonoured Cheque (Void Receipt) | INV04                  | Y      |
    Then system will have to check data as "Scenario 6" with desc "Same receipt in scenario 5, cancelled as Void Cheque"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | RECEIPT_CANCELLATION_TYPE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | RCC02      | AR          | RCC                   | D                         | E             | MYR           | 0003        | 0.50      | 0.00         | 0.00          | 0.00       | 1.50        |
      |            | AR          | RCC                   | D                         | Q             | AUD           | BANK        | 1.10      | 0.00         | 100.00        | 0.00       | 110.00      |
      |            | AR          | RCC                   | D                         | R             | AUD           | 0002        | 1.10      | 0.00         | 35.00         | 0.00       | 38.50       |
      |            | AR          | RCC                   | D                         | R             | MYR           | 0002        | 0.50      | 80.00        | 0.00          | 38.50      | 0.00        |
      |            | AR          | RCC                   | D                         | R             | MYR           | 0002        | 0.50      | 0.00         | 0.00          | 1.50       | 0.00        |
      |            | AR          | RCC                   | D                         | R             | AUD           | 0002        | 1.10      | 100.00       | 0.00          | 110.00     | 0.00        |

#  Scenario: 7. New Invoice applies to receipt. Both are of same foreign ccies. Receipt is cancelled as Wrong Customer
    When user do application
      | Application From | Application To | Rec Amt | Rec Home Amt | Inv Amt | Inv Home Amt | Realized Exch | Submit |
      | INV03            | REC05          | 50      | 60           | 50      | 65           | 5             | Y      |
    When user cancel AR Receipt
      | Receipt Cancellation No | Receipt No | Receipt Cancellation Date | Customer | Cancellation Type | New Customer | Submit |
      | RCC03                   | REC05      | 30/06/2016                | Nina     | Wrong Customer    | RACHEL       | Y      |
    Then system will have to check data as "Scenario 7" with desc "New Invoice applies to receipt. Both are of same foreign ccies. Receipt is cancelled as Wrong Customer"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | RECEIPT_CANCELLATION_TYPE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | RCC03      | AR          | RCC                   | C                         | E             | USD           | 0003        | 1.30      | 0.00         | 0.00          | 0.00       | 5.00        |
      |            | AR          | RCC                   | C                         | R             | USD           | 0002        | 1.30      | 0.00         | 0.00          | 5.00       | 0.00        |
      |            | AR          | RCC                   | C                         | R             | USD           | 0002        | 1.20      | 50.00        | 0.00          | 60.00      | 0.00        |
      |            | AR          | RCC                   | C                         | R             | USD           | 0001        | 1.20      | 0.00         | 50.00         | 0.00       | 60.00       |

#  Scenario: 8. Ost AR Credit Note applies to invoices after revaluation (similar to Scenario 1)
    Given user create new AR Credit Note
      | Credit No | Customer | Credit Note Date | Currency | Default Sales Tax | Exchange Rate | Bank Name | Pymt Method | Type | Item Code | Qty UOM | Unit Price | Submit |
      | CRN01     | Nina     | 30/06/2016       | AUD      | GST0%             | 1.1           | VIB       | Cash        | S    | NA        | 1       | 100        | Y      |
      | CRN02     | Nina     | 30/06/2016       | USD      | GST0%             | 1.25          | VIB       | Cash        | S    | NA        | 1       | 50         | N      |
    When user do AR revaluation
      | Revaluation Voucher Date | Currency | Exchange Rate |
      | 30/06/2016               | USD      | 1.35          |
      |                          | AUD      | 1.05          |
      |                          | MYR      | 0.5           |
    When user do application
      | Application From | Application To | Rec Amt | Rec Home Amt | Inv Amt | Inv Home Amt | Realized Exch | Submit |
      | CRN01            | INV03          | 60      | 66           | 50      | 65           | -1            |        |
      |                  | INV04          | 35      | 38.5         | 80      | 40           | 1.5           | Y      |
    Then system will have to check data as "Scenario 8" with desc "Ost AR Credit Note applies to invoices after revaluation (similar to Scenario 1)"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | CRN01      | AR          | CN                    | E             | MYR           |             | 0.50      | 0.00         | 0.00          | 1.50       | 0.00        |
      |            | AR          | CN                    | E             | USD           |             | 1.30      | 0.00         | 0.00          | 0.00       | 1.00        |
      |            | AR          | CN                    | L             | AUD           |             | 1.10      | 100.00       | 0.00          | 110.00     | 0.00        |
      |            | AR          | CN                    | R             | AUD           |             | 1.10      | 0.00         | 100.00        | 0.00       | 110.00      |
      |            | AR          | CN                    | R             | AUD           |             | 1.10      | 95.00        | 0.00          | 104.50     | 0.00        |
      |            | AR          | CN                    | R             | MYR           |             | 0.50      | 0.00         | 80.00         | 0.00       | 38.50       |
      |            | AR          | CN                    | R             | USD           |             | 1.30      | 0.00         | 50.00         | 0.00       | 66.00       |
      |            | AR          | CN                    | R             | MYR           |             | 0.50      | 0.00         | 0.00          | 0.00       | 1.50        |
      |            | AR          | CN                    | R             | USD           |             | 1.30      | 0.00         | 0.00          | 1.00       | 0.00        |
      |            | AR          | RV                    | R             | USD           |             | 1.35      | 0.00         | 0.00          | 0.00       | 2.50        |
      |            | AR          | RV                    | R             | AUD           |             | 1.05      | 0.00         | 0.00          | 0.00       | 4.75        |
      |            | AR          | RV                    | U             | USD           |             | 1.35      | 0.00         | 0.00          | 2.50       | 0.00        |
      |            | AR          | RV                    | U             | AUD           |             | 1.05      | 0.00         | 0.00          | 4.75       | 0.00        |

#  Scenario: 9. New AR Credit Note applies to invoice. Similar to Scenario 2 but both are of same foreign ccy
    When user do application
      | Application From | Application To | Rec Amt | Rec Home Amt | Inv Amt | Inv Home Amt | Realized Exch | Submit |
      | CRN02            | INV03          | 50      | 75           | 50      | 65           | -10           | Y      |
    Then system will have to check data as "Scenario 9" with desc "New AR Credit Note applies to invoice. Similar to Scenario 2 but both are of same foreign ccy"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | CRN02      | AR          | CN                    | E             | USD           |             | 1.30      | 0.00         | 0.00          | 2.50       | 0.00        |
      |            | AR          | CN                    | L             | USD           |             | 1.25      | 50.00        | 0.00          | 62.50      | 0.00        |
      |            | AR          | CN                    | R             | USD           |             | 1.30      | 0.00         | 0.00          | 0.00       | 2.50        |
      |            | AR          | CN                    | R             | USD           |             | 1.25      | 0.00         | 50.00         | 0.00       | 62.50       |
      |            | AR          | RV                    | R             | USD           |             | 1.35      | 0.00         | 0.00          | 0.00       | 2.50        |
      |            | AR          | RV                    | U             | USD           |             | 1.35      | 0.00         | 0.00          | 2.50       | 0.00        |

#  Scenario: 10. Payment refund applies to credit note. Both are of different foreign ccies
    Given user create new Payment to Customer
      | Application From | Application To | Payment Voucher Date | Customer | Bank | Currency | Payment Amt | Payment Home Amt | Exchange Rate | Crn Amt | Crn Home Amt | Realized Exch | Submit |
      | PAY02            | CRN01          | 30/06/2016           | Nina     | VIB  | USD      | 4           | 5                | 1.25          | 5       | 5.50         | 0.5           | Y      |
    Then system will have to check data as "Scenario 10" with desc "Payment refund applies to credit note. Both are of different foreign ccies"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | CRN01      | AR          | CN                    | E             | MYR           | 0003        | 0.50      | 0.00         | 0.00          | 1.50       | 0.00        |
      |            | AR          | CN                    | E             | USD           | 0003        | 1.30      | 0.00         | 0.00          | 0.00       | 1.00        |
      |            | AR          | CN                    | L             | AUD           | 0001        | 1.10      | 100.00       | 0.00          | 110.00     | 0.00        |
      |            | AR          | CN                    | R             | AUD           | 0002        | 1.10      | 0.00         | 100.00        | 0.00       | 110.00      |
      |            | AR          | CN                    | R             | AUD           | 0002        | 1.10      | 95.00        | 0.00          | 104.50     | 0.00        |
      |            | AR          | CN                    | R             | MYR           | 0002        | 0.50      | 0.00         | 80.00         | 0.00       | 38.50       |
      |            | AR          | CN                    | R             | USD           | 0002        | 1.30      | 0.00         | 50.00         | 0.00       | 66.00       |
      |            | AR          | CN                    | R             | MYR           | 0002        | 0.50      | 0.00         | 0.00          | 0.00       | 1.50        |
      |            | AR          | CN                    | R             | USD           | 0002        | 1.30      | 0.00         | 0.00          | 1.00       | 0.00        |
      |            | AR          | RV                    | R             | USD           | 0002        | 1.35      | 0.00         | 0.00          | 0.00       | 2.50        |
      |            | AR          | RV                    | R             | AUD           | 0002        | 1.05      | 0.00         | 0.00          | 0.00       | 4.75        |
      |            | AR          | RV                    | U             | USD           | 0004        | 1.35      | 0.00         | 0.00          | 2.50       | 0.00        |
      |            | AR          | RV                    | U             | AUD           | 0004        | 1.05      | 0.00         | 0.00          | 4.75       | 0.00        |

#  new cycle (old vouchers are  fully applied)
#  Scenario: 11. Payment refund applies to credit note and receipt. All are of different foreign ccies
    Given user create new AR Receipt
      | Receipt No | Customer | Receipt Date | Currency | Exchange Rate | Bank Name | Pymt Method | Pymt Amt | Submit |
      | REC06      | Nina     | 30/06/2016   | USD      | 1.3           | VIB       | Cash        | 50       | Y      |
    Given user create new AR Credit Note
      | Credit No | Customer | Credit Note Date | Currency | Default Sales Tax | Exchange Rate | Bank Name | Pymt Method | Type | Item Code | Qty UOM | Unit Price | Submit |
      | CRN03     | Nina     | 30/06/2016       | MYR      | GST0%             | 0.5           | VIB       | Cash        | S    | Na        | 1       | 80         | Y      |
    Given user create new Payment to Customer
      | Application From | Application To | Payment Voucher Date | Customer | Bank | Currency | Cheque Amt | Exchange Rate | Payment Amt | Payment Home Amt | Rec Amt | Rec Home Amt | Realized Exch | Submit |
      | PAY03            | REC06          | 30/06/2016           | Nina     | VIB  | AUD      | 95         | 1.1           | 60          | 66               | 50      | 65           | -1            | N      |
      |                  | CRN03          |                      |          |      |          |            |               | 35          | 38.5             | 80      | 40           | 1.5           | Y      |
    Then system will have to check data as "Scenario 11" with desc "Payment refund applies to credit note and receipt. All are of different foreign ccies"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | PAY03      | AP          | PY                    | C             | AUD           |             | 1.10      | 0.00         | 95.00         | 0.00       | 104.50      |
      |            | AP          | PY                    | E             | MYR           |             | 0.50      | 0.00         | 0.00          | 0.00       | 1.50        |
      |            | AP          | PY                    | E             | USD           |             | 1.30      | 0.00         | 0.00          | 1.00       | 0.00        |
      |            | AP          | PY                    | R             | AUD           |             | 1.10      | 95.00        | 0.00          | 104.50     | 0.00        |
      |            | AP          | PY                    | R             | AUD           |             | 1.10      | 0.00         | 95.00         | 0.00       | 104.50      |
      |            | AP          | PY                    | R             | MYR           |             | 0.50      | 80.00        | 0.00          | 38.50      | 0.00        |
      |            | AP          | PY                    | R             | USD           |             | 1.30      | 50.00        | 0.00          | 66.00      | 0.00        |
      |            | AP          | PY                    | R             | MYR           |             | 0.50      | 0.00         | 0.00          | 1.50       | 0.00        |
      |            | AP          | PY                    | R             | USD           |             | 1.30      | 0.00         | 0.00          | 0.00       | 1.00        |

#  Scenario: 12. Ost Payment applies to invoices after revaluation. All vouchers are of different foreign ccies
    Given user create new AP Invoice
      | Invoice No | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PIN01      | Nina     | 30/06/2016   | USD      | GST0%             | 1.3           | S    | NA        | 1       | 100        | Y      |
      | PIN02      | Nina     | 30/06/2016   | MYR      | GST0%             | 0.5           | S    | NA        | 1       | 80         | Y      |
    Given user create new AP Payment
      | Voucher No | Supplier | Payment Voucher Date | Bank | Currency | Cheque Amt | Exchange Rate | Submit |
      | PAY04      | Nina     | 30/06/2016           | VIB  | AUD      | 95         | 1.1           | Y      |
    When user do AP revaluation
      | Revaluation Voucher Date | Currency | Exchange Rate |
      | 30/06/2016               | USD      | 1.35          |
      |                          | AUD      | 1.05          |
      |                          | MYR      | 0.5           |
    When user do application
      | Application From | Application To | Rec Amt | Rec Home Amt | Inv Amt | Inv Home Amt | Realized Exch | Submit |
      | PAY04            | PIN01          | 60      | 66           | 50      | 65           | -1            | N      |
      |                  | PIN02          | 35      | 38.5         | 80      | 40           | -10           | Y      |
    Then system will have to check data as "Scenario 12" with desc "Ost Payment applies to invoices after revaluation. All vouchers are of different foreign ccies"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | PAY04      | AP          | PY                    | C             | AUD           |             | 1.10      | 0.00         | 95.00         | 0.00       | 104.50      |
      |            | AP          | PY                    | E             | USD           |             | 1.30      | 0.00         | 0.00          | 1.00       | 0.00        |
      |            | AP          | PY                    | E             | MYR           |             | 0.50      | 0.00         | 0.00          | 0.00       | 1.50        |
      |            | AP          | PY                    | P             | AUD           |             | 1.10      | 95.00        | 0.00          | 104.50     | 0.00        |
      |            | AP          | PY                    | P             | AUD           |             | 1.10      | 0.00         | 95.00         | 0.00       | 104.50      |
      |            | AP          | PY                    | P             | USD           |             | 1.30      | 50.00        | 0.00          | 66.00      | 0.00        |
      |            | AP          | PY                    | P             | MYR           |             | 0.50      | 80.00        | 0.00          | 38.50      | 0.00        |
      |            | AP          | PY                    | P             | USD           |             | 1.30      | 0.00         | 0.00          | 0.00       | 1.00        |
      |            | AP          | PY                    | P             | MYR           |             | 0.50      | 0.00         | 0.00          | 1.50       | 0.00        |
      |            | AP          | RV                    | P             | USD           |             | 1.35      | 0.00         | 0.00          | 2.50       | 0.00        |
      |            | AP          | RV                    | P             | AUD           |             | 1.05      | 0.00         | 0.00          | 4.75       | 0.00        |
      |            | AP          | RV                    | U             | USD           |             | 1.35      | 0.00         | 0.00          | 0.00       | 2.50        |
      |            | AP          | RV                    | U             | AUD           |             | 1.05      | 0.00         | 0.00          | 0.00       | 4.75        |

#  Scenario: 13. New Payment applies to invoice. Only invoice has been revaluated. Both are of same foreign ccy
    Given user create new AP Payment
      | Voucher No | Supplier | Payment Voucher Date | Bank | Currency | Cheque Amt | Exchange Rate | Submit |
      | PAY05      | Nina     | 30/06/2016           | VIB  | USD      | 50         | 1.5           | N      |
    When user do application
      | Application From | Application To | Rec Amt | Rec Home Amt | Inv Amt | Inv Home Amt | Realized Exch | Submit |
      | PAY05            | PIN01          | 50      | 75           | 50      | 65           | 10            | Y      |
    Then system will have to check data as "Scenario 13" with desc "New Payment applies to invoice. Only invoice has been revaluated. Both are of same foreign ccy"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | PAY05      | AP          | PY                    | C             | USD           |             | 1.50      | 0.00         | 50.00         | 0.00       | 75.00       |
      |            | AP          | PY                    | E             | USD           |             | 1.30      | 0.00         | 0.00          | 10.00      | 0.00        |
      |            | AP          | PY                    | P             | USD           |             | 1.50      | 50.00        | 0.00          | 75.00      | 0.00        |
      |            | AP          | PY                    | P             | USD           |             | 1.30      | 0.00         | 0.00          | 0.00       | 10.00       |
      |            | AP          | RV                    | P             | USD           |             | 1.35      | 0.00         | 0.00          | 2.50       | 0.00        |
      |            | AP          | RV                    | U             | USD           |             | 1.35      | 0.00         | 0.00          | 0.00       | 2.50        |

#  new cycle (old vouchers are  fully applied)
#  Scenario: 14. Ost AP Credit Note applies to invoices after revaluation. All vouchers are of different foreign ccies
    Given user create new AP Invoice
      | Invoice No | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PIN03      | Nina     | 30/06/2016   | USD      | GST0%             | 1.3           | S    | NA        | 1       | 100        | Y      |
      | PIN04      | Nina     | 30/06/2016   | MYR      | GST0%             | 0.5           | S    | NA        | 1       | 80         | Y      |
    Given user create new AP Credit Note
      | Credit No | Supplier | Posting Date | Currency | Exchange Rate | Default Sales Tax | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PCN01     | Nina     | 30/06/2016   | AUD      | 1.1           | GST0%             | S    | NA        | 1       | 95         | Y      |
    When user do AP revaluation
      | Revaluation Voucher Date | Currency | Exchange Rate |
      | 30/06/2016               | USD      | 1.35          |
      |                          | AUD      | 1.05          |
      |                          | MYR      | 0.5           |
    When user do application
      | Application From | Application To | Rec Amt | Rec Home Amt | Inv Amt | Inv Home Amt | Realized Exch | Submit |
      | PCN01            | PIN03          | 60      | 66           | 50      | 65           | -1            | N      |
      |                  | PIN04          | 35      | 38.5         | 80      | 40           | 1.5           | Y      |
    Then system will have to check data as "Scenario 14" with desc "Ost AP Credit Note applies to invoices after revaluation. All vouchers are of different foreign ccies"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | PCN01      | AP          | CN                    | E             | USD           |             | 1.30      | 0.00         | 0.00          | 1.00       | 0.00        |
      |            | AP          | CN                    | E             | MYR           |             | 0.50      | 0.00         | 0.00          | 0.00       | 1.50        |
      |            | AP          | CN                    | L             | AUD           |             | 1.10      | 0.00         | 95.00         | 0.00       | 104.50      |
      |            | AP          | CN                    | P             | AUD           |             | 1.10      | 95.00        | 0.00          | 104.50     | 0.00        |
      |            | AP          | CN                    | P             | AUD           |             | 1.10      | 0.00         | 95.00         | 0.00       | 104.50      |
      |            | AP          | CN                    | P             | USD           |             | 1.30      | 50.00        | 0.00          | 66.00      | 0.00        |
      |            | AP          | CN                    | P             | MYR           |             | 0.50      | 80.00        | 0.00          | 38.50      | 0.00        |
      |            | AP          | CN                    | P             | USD           |             | 1.30      | 0.00         | 0.00          | 0.00       | 1.00        |
      |            | AP          | CN                    | P             | MYR           |             | 0.50      | 0.00         | 0.00          | 1.50       | 0.00        |
      |            | AP          | RV                    | P             | USD           |             | 1.35      | 0.00         | 0.00          | 2.50       | 0.00        |
      |            | AP          | RV                    | P             | AUD           |             | 1.05      | 0.00         | 0.00          | 4.75       | 0.00        |
      |            | AP          | RV                    | U             | USD           |             | 1.35      | 0.00         | 0.00          | 0.00       | 2.50        |
      |            | AP          | RV                    | U             | AUD           |             | 1.05      | 0.00         | 0.00          | 0.00       | 4.75        |

#  Scenario: 15. New AP Credit Note applies to invoice. Only invoice has been revaluated. Both are of same foreign ccy
    Given user create new AP Credit Note
      | Credit No | Supplier | Posting Date | Currency | Exchange Rate | Default Sales Tax | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PCN02     | Nina     | 30/06/2016   | USD      | 1.5           | GST0%             | S    | NA        | 1       | 50         | N      |
    When user do application
      | Application From | Application To | Rec Amt | Rec Home Amt | Inv Amt | Inv Home Amt | Realized Exch | Submit |
      | PCN02            | PIN03          | 50      | 75           | 50      | 65           | 10            | Y      |
    Then system will have to check data as "Scenario 15" with desc "New AP Credit Note applies to invoice. Only invoice has been revaluated. Both are of same foreign ccy"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | PCN02      | AP          | CN                    | E             | USD           |             | 1.30      | 0.00         | 0.00          | 10.00      | 0.00        |
      |            | AP          | CN                    | L             | USD           |             | 1.50      | 0.00         | 50.00         | 0.00       | 75.00       |
      |            | AP          | CN                    | P             | USD           |             | 1.30      | 0.00         | 0.00          | 0.00       | 10.00       |
      |            | AP          | CN                    | P             | USD           |             | 1.50      | 50.00        | 0.00          | 75.00      | 0.00        |
      |            | AP          | RV                    | P             | USD           |             | 1.35      | 0.00         | 0.00          | 2.50       | 0.00        |
      |            | AP          | RV                    | U             | USD           |             | 1.35      | 0.00         | 0.00          | 0.00       | 2.50        |

#  new cycle (old vouchers are  fully applied)
#  Scenario: 16. Contra: AR Invoice and AP Invoice, not revaluated
    Given user create new AP Invoice
      | Invoice No | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PIN05      | Nina     | 30/06/2016   | USD      | GST0%             | 1.3           | S    | NA        | 1       | 100        | Y      |
      | PIN06      | Nina     | 30/06/2016   | USD      | GST0%             | 1.35          | S    | NA        | 1       | 80         | Y      |
    Given user create new AR Invoice
      | Invoice No | Customer | Invoice Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | INV05      | Nina     | 30/06/2016   | USD      | GST0%             | 1.25          | S    | NA        | 1       | 100        | Y      |
      | INV06      | Nina     | 30/06/2016   | USD      | GST0%             | 1.25          | S    | NA        | 1       | 80         | Y      |
    When user do contra
      | Voucher No | Party | Voucher Date | Currency | Buy Rate | Sell Rate | Invoice No | Inv Amt | Submit |
      | CON01      | Nina  | 30/06/2016   | USD      | 1.3      | 1.4       | INV05      | 50      | N      |
      |            |       |              |          |          |           | PIN05      | 50      | Y      |
    Then system will have to check data as "Scenario 16" with desc "Contra: AR Invoice and AP Invoice, not revaluated"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | CON01      | CT          | AP                    | C             | USD           |             | 1.4       | 0.00         | 50.00         | 0.00       | 70.00       |
      |            | CT          | AP                    | E             | USD           |             | 1.4       | 0.00         | 0.00          | 5.00       | 0.00        |
      |            | CT          | AP                    | P             | USD           |             | 1.4       | 50.00        | 0.00          | 70.00      | 0.00        |
      |            | CT          | AP                    | P             | USD           |             | 1.4       | 0.00         | 0.00          | 0.00       | 5.00        |
      |            | CT          | AR                    | C             | USD           |             | 1.3       | 50.00        | 0.00          | 65.00      | 0.00        |
      |            | CT          | AR                    | E             | USD           |             | 1.3       | 0.00         | 0.00          | 0.00       | 2.50        |
      |            | CT          | AR                    | R             | USD           |             | 1.3       | 0.00         | 50.00         | 0.00       | 65.00       |
      |            | CT          | AR                    | R             | USD           |             | 1.3       | 0.00         | 0.00          | 2.50       | 0.00        |
      |            | CT          | CT                    | C             | USD           |             | 1.3       | 0.00         | 0.00          | 5.00       | 0.00        |
      |            | CT          | CT                    | E             | USD           |             | 1.3       | 0.00         | 0.00          | 0.00       | 5.00        |

#  Scenario: 17. Contra: AR Invoices and AP Invoices, all have been revaluated.
    When user do AP revaluation
      | Revaluation Voucher Date | Currency | Exchange Rate |
      | 30/06/2016               | USD      | 1.35          |
    When user do contra
      | Voucher No | Party | Voucher Date | Currency | Buy Rate | Sell Rate | Invoice No | Inv Amt | Submit |
      | CON01      | Nina  | 30/06/2016   | USD      | 1.3      | 1.4       | PIN05      | 50      | N      |
      |            |       |              |          |          |           | PIN06      | 80      | N      |
      |            |       |              |          |          |           | INV05      | 50      | N      |
      |            |       |              |          |          |           | INV06      | 80      | Y      |
    Then system will have to check data as "Scenario 17" with desc "Contra: AR Invoices and AP Invoices, all have been revaluated"
      | Voucher No | MODULE_CODE | TRANSACTION_TYPE_CODE | GL_ENTRY_TYPE | CURRENCY_CODE | GL_ACC_CODE | EXCH_RATE | NATURE_DEBIT | NATURE_CREDIT | HOME_DEBIT | HOME_CREDIT |
      | CON01      | CT          | AP                    | C             | USD           | 0001        | 1.40      | 0.00         | 130.00        | 0.00       | 182.00      |
      |            | CT          | AP                    | E             | USD           | 0003        | 1.40      | 0.00         | 0.00          | 9.00       | 0.00        |
      |            | CT          | AP                    | P             | USD           | 0002        | 1.40      | 130.00       | 0.00          | 182.00     | 0.00        |
      |            | CT          | AP                    | P             | USD           | 0002        | 1.40      | 0.00         | 0.00          | 0.00       | 9.00        |
      |            | CT          | AR                    | C             | USD           | 0001        | 1.30      | 130.00       | 0.00          | 169.00     | 0.00        |
      |            | CT          | AR                    | E             | USD           | 0003        | 1.30      | 0.00         | 0.00          | 0.00       | 6.50        |
      |            | CT          | AR                    | R             | USD           | 0002        | 1.30      | 0.00         | 130.00        | 0.00       | 169.00      |
      |            | CT          | AR                    | R             | USD           | 0002        | 1.30      | 0.00         | 0.00          | 6.50       | 0.00        |
      |            | CT          | CT                    | C             | USD           | 0001        | 1.30      | 0.00         | 0.00          | 13.00      | 0.00        |
      |            | CT          | CT                    | E             | USD           | 0001        | 1.30      | 0.00         | 0.00          | 0.00       | 13.00       |
      |            | CT          | RV                    | P             | USD           | 0002        | 1.35      | 0.00         | 0.00          | 2.50       | 0.00        |
      |            | CT          | RV                    | U             | USD           | 0004        | 1.35      | 0.00         | 0.00          | 0.00       | 2.50        |

    Then user summarize report for Realized Exchange Gain/Loss
