@payment_cancellation
Feature: Deluge: A0:13 - AP Payment Cancellation ID:100028481

  Background: Prepare
    Given "rachel" login to "GENMAIN 6" company with password is "taskhub"
    Given user access DB "jdbc:db2://172.18.0.10:50000/GENMAIN6" with id "db2admin" and password "Taskhub1"

  Scenario: AP Payment Cancellation
#  Scenario 1: Wrong application in current period with Home Ccy (Hst Payment)
    Given user navigates to "Operations>Accounts Payable>AP Invoice" screen
    Given user switches to TH5
    Given user create new AP Invoice
      | Invoice No | Period  | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PIN001     | Current | Nina     | 30/06/2016   | SGD      | GST0%             | 1             | S    | NA        | 1       | 150        | Y      |
    Given user navigates to "Operations>Accounts Payable>AP Credit Note" screen
    Given user switches to TH5
    Given user create new AP Credit Note
      | Credit No | Period  | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PCN001    | Current | Nina     | 30/06/2016   | SGD      | GST0%             | 1             | S    | NA        | 1       | 50         | Y      |
    When user do application
      | Application Date | Application From | Application To | Rec Amt | Rec Home Amt | Inv Amt | Inv Home Amt | Realized Exch | Submit |
      | 30/06/2016       | PCN001           | PIN001         | 50      |              | 50      |              |               | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment" screen
    Given user switches to TH5
    Given user create new AP Payment
      | Voucher No | Period  | Supplier | Payment Voucher Date | Bank | Currency | Cheque Amt | Exchange Rate | Submit |
      | PAY001     | Current | Nina     | 30/06/2016           | VIB  | SGD      | 100        | 1             | Y      |
    When user do application
      | Application Date | Application From | Application To | Rec Amt | Inv Amt | Submit |
      | 30/06/2016       | PAY001           | PIN001         | 100     | 100     | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Payment Cancellation Date | Period  | Cancellation Type            | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC001                  | 30/06/2016                | Current | Wrong Application To Invoice | Nina     | PAY001             | 000       |         | PIN001     | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 1" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PIN001     |
      | PCN001     |
      | PAY001     |
      | PYC001     |

#  Scenario 15: Cancel the payment in Scenario 1 in current period
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Period  | Payment Cancellation Date | Cancellation Type                | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC015                  | Current | 30/06/2016                | Dishonoured Cheque(Void Payment) | Nina     | PAY001             | 000       |         |            | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 15" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PIN001     |
      | PCN001     |
      | PAY001     |
      | PYC015     |

#  Scenario 2: Wrong application in current period with Home Ccy (Ost Payment)
    Given user navigates to "Operations>Accounts Payable>AP Invoice" screen
    Given user switches to TH5
    Given user create new AP Invoice
      | Invoice No | Period   | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PIN002     | Previous | Nina     | 30/05/2016   | SGD      | GST0%             | 1             | S    | NA        | 1       | 50         | Y      |
      | PIN003     | Current  | Nina     | 30/06/2016   | SGD      | GST0%             | 1             | S    | NA        | 1       | 135        | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment" screen
    Given user switches to TH5
    Given user create new AP Payment
      | Voucher No | Period   | Supplier | Payment Voucher Date | Bank | Currency | Cheque Amt | Exchange Rate | Submit |
      | PAY002     | Previous | Nina     | 30/05/2016           | VIB  | SGD      | 200        | 1             | Y      |
    When user do application
      | Application Date | Application From | Application To | Rec Amt | Inv Amt | Submit |
      | 30/06/2016       | PAY002           | PIN002         | 50      | 50      | N      |
      |                  |                  | PIN003         | 130     | 130     | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Payment Cancellation Date | Period  | Cancellation Type            | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC002                  | 30/06/2016                | Current | Wrong Application To Invoice | Nina     | PAY002             | 000       |         | PIN002     | N      |
      |                         |                           |         |                              |          |                    |           |         | PIN003     | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 2" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PIN002     |
      | PIN003     |
      | PAY002     |
      | PYC002     |

#  Scenario 3: Wrong application in Previous period with Home Ccy (Hst Payment)
    Given user navigates to "Operations>Accounts Payable>AP Invoice" screen
    Given user switches to TH5
    Given user create new AP Invoice
      | Invoice No | Period    | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PIN004     | Last Year | Nina     | 30/06/2015   | SGD      | GST0%             | 1             | S    | NA        | 1       | 150        | Y      |
      | PIN005     | Previous  | Nina     | 30/05/2016   | SGD      | GST0%             | 1             | S    | NA        | 1       | 50         | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment" screen
    Given user switches to TH5
    Given user create new AP Payment
      | Voucher No | Period    | Supplier | Payment Voucher Date | Bank | Currency | Cheque Amt | Exchange Rate | Submit |
      | PAY003     | Last Year | Nina     | 30/06/2015           | VIB  | SGD      | 200        | 1             | Y      |
    When user do application
      | Application Date | Application From | Application To | Rec Amt | Inv Amt | Submit |
      | 30/05/2016       | PAY003           | PIN004         | 150     | 150     | N      |
      |                  |                  | PIN005         | 50      | 50      | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Payment Cancellation Date | Period   | Cancellation Type            | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC003                  | 30/05/2016                | Previous | Wrong Application To Invoice | Nina     | PAY003             | 000       |         | PIN004     | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 3" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PIN004     |
      | PIN005     |
      | PAY003     |
      | PYC003     |

#  Scenario 6: Cancel the Payment in Scenario 3 as Wrong application (INV2)
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Payment Cancellation Date | Period  | Cancellation Type            | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC006                  | 30/06/2016                | Current | Wrong Application To Invoice | Nina     | PAY003             | 000       |         | PIN005     | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 6" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PIN004     |
      | PIN005     |
      | PAY003     |
      | PYC006     |

#  Scenario 18: Cancel the payment in Scenario 6 as Void Cheque in previous period
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Period   | Payment Cancellation Date | Cancellation Type                | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC018                  | Previous | 30/05/2016                | Dishonoured Cheque(Void Payment) | Nina     | PAY003             | 000       |         |            | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 18" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PIN004     |
      | PIN005     |
      | PAY003     |
      | PYC018     |

#  Scenario 4: Wrong application in Previous period with application to Foreign Ccies (Ost Payment)
    Given user navigates to "Operations>Accounts Payable>AP Invoice" screen
    Given user switches to TH5
    Given user create new AP Invoice
      | Invoice No | Period   | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PIN006     | Previous | Nina     | 30/05/2016   | MYR      | GST0%             | 0.38          | S    | NA        | 1       | 100        | Y      |
      | PIN007     | Current  | Nina     | 30/06/2016   | USD      | GST0%             | 1.23          | S    | NA        | 1       | 50         | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment" screen
    Given user switches to TH5
    Given user create new AP Payment
      | Voucher No | Period   | Supplier | Payment Voucher Date | Bank | Currency | Cheque Amt | Exchange Rate | Submit |
      | PAY004     | Previous | Nina     | 30/05/2015           | VIB  | SGD      | 120        | 1             | Y      |
    When user do application
      | Application Date | Application From | Application To | Rec Amt | Inv Amt | Submit |
      | 30/06/2016       | PAY004           | PIN006         | 40      | 40      | N      |
      |                  |                  | PIN007         | 60      | 50      | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Payment Cancellation Date | Period  | Cancellation Type            | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC004                  | 30/06/2016                | Current | Wrong Application To Invoice | Nina     | PAY004             | 000       |         | PIN006     | N      |
      |                         |                           |         |                              |          |                    |           |         | PIN007     | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 4" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PIN006     |
      | PIN007     |
      | PAY004     |
      | PYC004     |

#  Scenario 16: Cancel the payment in Scenario 4 in current period
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Period  | Payment Cancellation Date | Cancellation Type                | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC016                  | Current | 30/06/2016                | Dishonoured Cheque(Void Payment) | Nina     | PAY004             | 000       |         |            | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 16" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PIN006     |
      | PIN007     |
      | PAY004     |
      | PYC016     |

#  Scenario 5: Wrong application in Last Yr period with Foreign Ccy and Foreign Ccies applications (Hst Payment)
    Given user navigates to "Operations>Accounts Payable>AP Invoice" screen
    Given user switches to TH5
    Given user create new AP Invoice
      | Invoice No | Period    | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PIN008     | Last Year | Nina     | 30/06/2015   | AUD      | GST0%             | 1.68          | S    | NA        | 1       | 100        | Y      |
      | PIN009     | Last Year | Nina     | 30/06/2015   | USD      | GST0%             | 1.23          | S    | NA        | 1       | 50         | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment" screen
    Given user switches to TH5
    Given user create new AP Payment
      | Voucher No | Period    | Supplier | Payment Voucher Date | Bank | Currency | Cheque Amt | Exchange Rate | Submit |
      | PAY005     | Last Year | Nina     | 30/06/2015           | VIB  | USD      | 185        | 1.25          | Y      |
    When user do application
      | Application Date | Application From | Application To | Rec Amt | Inv Amt | Cross Rate  | Submit |
      | 30/06/2015       | PAY005           | PIN008         | 135     | 168.75  | 0.740740700 | N      |
      |                  |                  | PIN009         | 50      | 62.5    |             | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Payment Cancellation Date | Period    | Cancellation Type            | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC005                  | 30/06/2015                | Last Year | Wrong Application To Invoice | Nina     | PAY005             | 000       |         | PIN008     | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 5" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PIN008     |
      | PIN009     |
      | PAY005     |
      | PYC005     |

#  Scenario 17: Cancel the payment in Scenario 5 in last year period
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Period    | Payment Cancellation Date | Cancellation Type                | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC017                  | Last Year | 30/06/2015                | Dishonoured Cheque(Void Payment) | Nina     | PAY005             | 000       |         |            | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 17" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PIN008     |
      | PIN009     |
      | PAY005     |
      | PYC017     |

#  Scenario 7: Void Cheque in current period with Home Ccy (Hst Payment)
    Given user navigates to "Operations>Accounts Payable>Payment" screen
    Given user switches to TH5
    Given user create new AP Payment
      | Voucher No | Period  | Supplier | Payment Voucher Date | Bank | Currency | Cheque Amt | Exchange Rate | Submit |
      | PAY007     | Current | Nina     | 30/06/2016           | VIB  | USD      | 150        | 1             | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Payment Cancellation Date | Period  | Cancellation Type                | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC007                  | 30/06/2016                | Current | Dishonoured Cheque(Void Payment) | Nina     | PAY007             | 000       |         |            | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 7" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PAY007     |
      | PYC007     |

#  Scenario 8: Void Payment in current period with Home Ccy (Ost Payment)
    Given user navigates to "Operations>Accounts Payable>AP Invoice" screen
    Given user switches to TH5
    Given user create new AP Invoice
      | Invoice No | Period   | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PIN010     | Previous | Nina     | 30/05/2016   | SGD      | GST0%             | 1             | S    | NA        | 1       | 50         | Y      |
      | PIN011     | Current  | Nina     | 30/06/2016   | SGD      | GST0%             | 1             | S    | NA        | 1       | 135        | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment" screen
    Given user switches to TH5
    Given user create new AP Payment
      | Voucher No | Period   | Supplier | Payment Voucher Date | Bank | Currency | Cheque Amt | Exchange Rate | Submit |
      | PAY008     | Previous | Nina     | 30/05/2016           | VIB  | SGD      | 200        | 1             | Y      |
    When user do application
      | Application Date | Application From | Application To | Rec Amt | Inv Amt | Submit |
      | 30/06/2016       | PAY008           | PIN010         | 50      |         | N      |
      |                  |                  | PIN011         | 130     |         | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Payment Cancellation Date | Period  | Cancellation Type                | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC008                  | 30/06/2016                | Current | Dishonoured Cheque(Void Payment) | Nina     | PAY008             | 000       |         | PIN010     |        |
      |                         |                           |         |                                  |          |                    |           |         | PIN011     | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 8" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PIN010     |
      | PIN011     |
      | PAY008     |
      | PYC008     |

#  Scenario 9: Void Payment in Previous period with Home Ccy (Hst Payment)
    Given user navigates to "Operations>Accounts Payable>AP Invoice" screen
    Given user switches to TH5
    Given user create new AP Invoice
      | Invoice No | Period    | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PIN012     | Last Year | Nina     | 30/06/2015   | SGD      | GST0%             | 1             | S    | NA        | 1       | 50         | Y      |
      | PIN013     | Previous  | Nina     | 30/05/2016   | SGD      | GST0%             | 1             | S    | NA        | 1       | 150        | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment" screen
    Given user switches to TH5
    Given user create new AP Payment
      | Voucher No | Period    | Supplier | Payment Voucher Date | Bank | Currency | Cheque Amt | Exchange Rate | Submit |
      | PAY009     | Last Year | Nina     | 30/06/2015           | VIB  | SGD      | 200        | 1             | Y      |
    When user do application
      | Application Date | Application From | Application To | Rec Amt | Inv Amt | Submit |
      | 30/05/2016       | PAY009           | PIN012         | 50      |         | N      |
      |                  |                  | PIN013         | 150     |         | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Payment Cancellation Date | Period   | Cancellation Type                | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC009                  | 30/05/2016                | Previous | Dishonoured Cheque(Void Payment) | Nina     | PAY009             | 000       |         | PIN012     |        |
      |                         |                           |          |                                  |          |                    |           |         | PIN013     | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 9" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PIN012     |
      | PIN013     |
      | PAY009     |
      | PYC009     |

#  Scenario 10: Void Payment in current period with application to Foreign Ccies (Ost Payment)
    Given user navigates to "Operations>Accounts Payable>AP Invoice" screen
    Given user switches to TH5
    Given user create new AP Invoice
      | Invoice No | Period   | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PIN014     | Previous | Nina     | 30/05/2016   | MYR      | GST0%             | 0.38          | S    | NA        | 1       | 100        | Y      |
      | PIN015     | Current  | Nina     | 30/06/2016   | USD      | GST0%             | 1.23          | S    | NA        | 1       | 50         | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment" screen
    Given user switches to TH5
    Given user create new AP Payment
      | Voucher No | Period   | Supplier | Payment Voucher Date | Bank | Currency | Cheque Amt | Exchange Rate | Submit |
      | PAY010     | Previous | Nina     | 30/05/2016           | VIB  | SGD      | 120        | 1             | Y      |
    When user do application
      | Application Date | Application From | Application To | Rec Amt | Inv Amt | Submit |
      | 30/06/2016       | PAY010           | PIN014         | 40      | 40      | N      |
      |                  |                  | PIN015         | 60      | 50      | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Payment Cancellation Date | Period  | Cancellation Type                | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC010                  | 30/06/2016                | Current | Dishonoured Cheque(Void Payment) | Nina     | PAY010             | 000       |         | PIN014     |        |
      |                         |                           |         |                                  |          |                    |           |         | PIN015     | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 10" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PIN014     |
      | PIN015     |
      | PAY010     |
      | PYC010     |

#  Scenario 11: Void Payment in Last Yr period with Foreign Ccy applied to Foreign Ccies (Hst Payment)
    Given user navigates to "Operations>Accounts Payable>AP Invoice" screen
    Given user switches to TH5
    Given user create new AP Invoice
      | Invoice No | Period    | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PIN016     | Last Year | Nina     | 30/06/2015   | AUD      | GST0%             | 1.68          | S    | NA        | 1       | 100        | Y      |
      | PIN017     | Last Year | Nina     | 30/06/2015   | USD      | GST0%             | 1.23          | S    | NA        | 1       | 50         | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment" screen
    Given user switches to TH5
    Given user create new AP Payment
      | Voucher No | Period    | Supplier | Payment Voucher Date | Bank | Currency | Exchange Rate | Cheque Amt | Submit |
      | PAY011     | Last Year | Nina     | 30/06/2015           | VIB  | USD      | 1.25          | 185        | Y      |
    When user do application
      | Application Date | Application From | Application To | Rec Amt | Inv Amt | Cross Rate  | Submit |
      | 30/06/2015       | PAY011           | PIN016         | 135     |         | 0.740740700 |        |
      |                  |                  | PIN017         | 50      |         |             | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Period    | Payment Cancellation Date | Cancellation Type                | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC011                  | Last Year | 30/06/2015                | Dishonoured Cheque(Void Payment) | Nina     | PAY011             | 000       |         | PIN016     |        |
      |                         |           |                           |                                  |          |                    |           |         | PIN017     | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 11" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PIN016     |
      | PIN017     |
      | PAY011     |
      | PYC011     |

#  Scenario 12: Void Payment in Current period with Credit Note application, Home Ccy (Ost Payment)
    Given user navigates to "Operations>Accounts Payable>AP Invoice" screen
    Given user switches to TH5
    Given user create new AP Invoice
      | Invoice No | Period  | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PIN018     | Current | Nina     | 30/06/2016   | SGD      | GST0%             | 1             | S    | NA        | 1       | 150        | Y      |
    Given user navigates to "Operations>Accounts Payable>AP Credit Note" screen
    Given user switches to TH5
    Given user create new AP Credit Note
      | Credit No | Period  | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PCN002    | Current | Nina     | 30/06/2016   | SGD      | GST0%             | 1             | S    | NA        | 1       | 120        | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment" screen
    Given user switches to TH5
    Given user create new AP Payment
      | Voucher No | Period  | Supplier | Payment Voucher Date | Bank | Currency | Exchange Rate | Cheque Amt | Submit |
      | PAY012     | Current | Nina     | 30/06/2016           | VIB  | SGD      | 1             | 100        | Y      |
    When user do application
      | Application Date | Application From | Application To | Amt to Pay in Inv Ccy | Rec Amt | Inv Amt | Submit |
      | 30/06/2016       | PAY012           | PIN018         | 150                   |         |         |        |
      |                  |                  | PCN002         |                       | 100     |         | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Period  | Payment Cancellation Date | Cancellation Type                | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC012                  | Current | 30/06/2016                | Dishonoured Cheque(Void Payment) | Nina     | PAY012             | 000       |         | PIN018     |        |
      |                         |         |                           |                                  |          |                    |           |         | PCN002     | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 12" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PIN018     |
      | PCN002     |
      | PAY012     |
      | PYC012     |

#  Scenario 13: Void Payment in Previous period with Home Ccy and application to Foreign Ccy Invoice with Credit Note applications (Hst Payment)
    Given user navigates to "Operations>Accounts Payable>AP Invoice" screen
    Given user switches to TH5
    Given user create new AP Invoice
      | Invoice No | Period   | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PIN019     | Previous | Nina     | 30/05/2016   | SGD      | GST0%             | 1             | S    | NA        | 1       | 50         | Y      |
      | PIN020     | Previous | Nina     | 30/05/2016   | USD      | GST0%             | 1.23          | S    | NA        | 1       | 100        | Y      |
    Given user navigates to "Operations>Accounts Payable>AP Credit Note" screen
    Given user switches to TH5
    Given user create new AP Credit Note
      | Credit No | Period   | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PCN003    | Previous | Nina     | 30/05/2016   | USD      | GST0%             | 1.25          | S    | NA        | 1       | 10         | Y      |
      | PCN004    | Previous | Nina     | 30/05/2016   | USD      | GST0%             | 1.21          | S    | NA        | 1       | 20         | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment" screen
    Given user switches to TH5
    Given user create new AP Payment
      | Voucher No | Period   | Supplier | Payment Voucher Date | Bank | Currency | Exchange Rate | Cheque Amt | Submit |
      | PAY013     | Previous | Nina     | 30/05/2016           | VIB  | SGD      | 1             | 135        | Y      |
    When user do application
      | Application Date | Application From | Application To | Amt to Pay in Inv Ccy | Rec Amt | Inv Amt | Submit |
      | 30/05/2016       | PAY013           | PIN019         | 50                    |         |         | Y      |
    When user do application
      | Application Date | Application From | Application To | Amt to Pay in Inv Ccy | Rec Amt | Inv Amt | Submit |
      | 30/05/2016       | PAY013           | PIN020         | 85                    |         |         |        |
      |                  |                  | PCN003         |                       | 10      | 12.3    |        |
      |                  |                  | PCN004         |                       | 20      | 24.6    | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Period  | Payment Cancellation Date | Cancellation Type                | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC013                  | Current | 30/06/2016                | Dishonoured Cheque(Void Payment) | Nina     | PAY013             | 000       |         | PIN019     |        |
      |                         |         |                           |                                  |          |                    |           |         | PIN020     |        |
      |                         |         |                           |                                  |          |                    |           |         | PCN003     |        |
      |                         |         |                           |                                  |          |                    |           |         | PCN004     | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 13" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PIN019     |
      | PIN020     |
      | PCN003     |
      | PCN004     |
      | PAY013     |
      | PYC013     |

#  Scenario 14: Void Payment in Previous period with Foreign Ccy and application to Foreign Ccy Invoices with Credit Note applications (Ost Payment)
    Given user navigates to "Operations>Accounts Payable>AP Invoice" screen
    Given user switches to TH5
    Given user create new AP Invoice
      | Invoice No | Period   | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PIN021     | Previous | Nina     | 30/05/2016   | SGD      | GST0%             | 1             | S    | NA        | 1       | 50         | Y      |
      | PIN022     | Previous | Nina     | 30/05/2016   | USD      | GST0%             | 1.23          | S    | NA        | 1       | 100        | Y      |
      | PIN023     | Previous | Nina     | 30/05/2016   | AUD      | GST0%             | 1.68          | S    | NA        | 1       | 100        | Y      |
    Given user navigates to "Operations>Accounts Payable>AP Credit Note" screen
    Given user switches to TH5
    Given user create new AP Credit Note
      | Credit No | Period   | Supplier | Posting Date | Currency | Default Sales Tax | Exchange Rate | Type | Item Code | Qty UOM | Unit Price | Submit |
      | PCN005    | Previous | Nina     | 30/05/2016   | USD      | GST0%             | 1.25          | S    | NA        | 1       | 10         | Y      |
      | PCN006    | Previous | Nina     | 30/05/2016   | AUD      | GST0%             | 1.65          | S    | NA        | 1       | 20         | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment" screen
    Given user switches to TH5
    Given user create new AP Payment
      | Voucher No | Period   | Supplier | Payment Voucher Date | Bank | Currency | Exchange Rate | Cheque Amt | Submit |
      | PAY014     | Previous | Nina     | 30/05/2016           | VIB  | USD      | 1.24          | 250        | Y      |
    When user do application
      | Application Date | Application From | Application To | Amt to Pay in Inv Ccy | Rec Amt | Inv Amt | Submit |
      | 30/05/2016       | PAY014           | PIN021         |                       | 40      | 49.6    | Y      |
    When user do application
      | Application Date | Application From | Application To | Amt to Pay in Inv Ccy | Rec Amt | Inv Amt | Submit |
      | 30/05/2016       | PAY014           | PIN022         |                       | 80      |         |        |
      |                  |                  | PCN005         |                       | 10      | 12.3    | Y      |
    When user do application
      | Application Date | Application From | Application To | Amt to Pay in Inv Ccy | Rec Amt | Inv Amt | Submit |
      | 30/05/2016       | PAY014           | PIN023         |                       | 110     |         |        |
      |                  |                  | PCN006         |                       | 20      | 33.6    | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Period   | Payment Cancellation Date | Cancellation Type                | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC014                  | Previous | 30/05/2016                | Dishonoured Cheque(Void Payment) | Nina     | PAY014             | 000       |         | PIN021     |        |
      |                         |          |                           |                                  |          |                    |           |         | PIN022     |        |
      |                         |          |                           |                                  |          |                    |           |         | PIN023     |        |
      |                         |          |                           |                                  |          |                    |           |         | PCN005     |        |
      |                         |          |                           |                                  |          |                    |           |         | PCN006     | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 14" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PIN021     |
      | PIN022     |
      | PIN023     |
      | PCN005     |
      | PCN006     |
      | PAY014     |
      | PYC014     |

#  Scenario 19: Cancel Home Ccy Payment with Bank Charge in current period, the Payment is being considered for reconciliation
    Given user navigates to "Operations>Accounts Payable>Payment" screen
    Given user switches to TH5
    Given user create new AP Payment
      | Voucher No | Period  | Supplier | Payment Voucher Date | Bank | Currency | Exchange Rate | Cheque Amt | Bank Charge | Bank Charge Amt | Submit |
      | PAY019     | Current | Nina     | 30/06/2016           | VIB  | SGD      | 1             | 150        | SGD         | 5               |        |
      |            |         |          |                      |      |          |               |            | USD         | 2               | Y      |
    Given user navigates to "Operations>Bank Book>Reconciliation Voucher" screen
    Given user switches to TH5
    When user do reconciliation
      | Reconciliation No | Reconciliation Voucher Date | Bank Statement Date | Bank | Currency | Bank Statement No | Bank Statement Amount | Voucher No | Submit |
      | REC001            | 30/06/2016                  | 30/06/2016          | VIB  | SGD      | REC001            |                       | PAY019     | N      |
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Period  | Payment Cancellation Date | Cancellation Type                | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC019                  | Current | 30/06/2016                | Dishonoured Cheque(Void Payment) | Nina     | PAY019             | 000       |         |            | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 19" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PAY019     |
      | REC001     |
      | PYC019     |
    Given user navigates to "Operations>Bank Book>Reconciliation Voucher" screen
    Given user switches to TH5
    Then user abort reconciliation
      | Reconciliation No |
      | REC001            |

#  Scenario 20: Cancel Foreign Ccy Payment with Bank Charge in previous period, the Payment had already been reconciled
    Given user navigates to "Operations>Accounts Payable>Payment" screen
    Given user switches to TH5
    Given user create new AP Payment
      | Voucher No | Period   | Supplier | Payment Voucher Date | Bank | Currency | Exchange Rate | Cheque Amt | Bank Charge | Bank Charge Amt | Submit |
      | PAY020     | Previous | Nina     | 30/05/2016           | VIB  | USD      | 1.25          | 150        | SGD         | 5               |        |
      |            |          |          |                      |      |          |               |            | USD         | 2               |        |
      |            |          |          |                      |      |          |               |            | AUD         | 2               | Y      |
    Given user navigates to "Operations>Bank Book>Reconciliation Voucher" screen
    Given user switches to TH5
    When user do reconciliation
      | Reconciliation No | Reconciliation Voucher Date | Bank Statement Date | Bank | Currency | Bank Statement No | Bank Statement Amount | Voucher No | Submit |
      | REC002            | 30/05/2016                  | 30/05/2016          | VIB  | USD      | REC002            |                       | PAY020     | Y      |
    Given user navigates to "Operations>Accounts Payable>Payment Cancellation" screen
    When user create new payment cancellation
      | Payment Cancellation No | Period   | Payment Cancellation Date | Cancellation Type                | Supplier | Payment Voucher No | Cheque No | Remarks | Invoice No | Submit |
      | PYC020                  | Previous | 30/05/2016                | Dishonoured Cheque(Void Payment) | Nina     | PAY020             | 000       |         |            | Y      |
    Then system will have to pullout data for Payment Cancellation as "Scenario 20" follow "PYC_SQLCheck.xls"
      | Voucher No |
      | PAY020     |
      | REC002     |
      | PYC020     |

     # Compare data
    Then user compares data for Payment Cancellation
      | Expected File                                                | Sheet       | Scenario Description                                                                                                                 |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 1  | Wrong application in current period with Home Ccy (Hst Payment)                                                                      |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 15 | Cancel the payment in Scenario 1 in current period                                                                                   |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 2  | Wrong application in current period with Home Ccy (Ost Payment)                                                                      |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 3  | Wrong application in Previous period with Home Ccy (Hst Payment)                                                                     |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 6  | Cancel the Payment in Scenario 3 as Wrong application (INV2)                                                                         |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 18 | Cancel the payment in Scenario 6 as Void Cheque in previous period                                                                   |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 4  | Wrong application in Previous period with application to Foreign Ccies (Ost Payment)                                                 |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 16 | Cancel the payment in Scenario 4 in current period                                                                                   |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 5  | Wrong application in Last Yr period with Foreign Ccy and Foreign Ccies applications (Hst Payment)                                    |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 17 | Cancel the payment in Scenario 5 in last year period                                                                                 |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 7  | Void Cheque in current period with Home Ccy (Hst Payment)                                                                            |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 8  | Void Payment in current period with Home Ccy (Ost Payment)                                                                           |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 9  | Void Payment in Previous period with Home Ccy (Hst Payment)                                                                          |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 10 | Void Payment in current period with application to Foreign Ccies (Ost Payment)                                                       |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 11 | Void Payment in Last Yr period with Foreign Ccy applied to Foreign Ccies (Hst Payment)                                               |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 12 | Void Payment in Current period with Credit Note application, Home Ccy (Ost Payment)                                                  |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 13 | Void Payment in Previous period with Home Ccy and application to Foreign Ccy Invoice with Credit Note applications (Hst Payment)     |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 14 | Void Payment in Previous period with Foreign Ccy and application to Foreign Ccy Invoices with Credit Note applications (Ost Payment) |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 19 | Cancel Home Ccy Payment with Bank Charge in current period, the Payment is being considered for reconciliation                       |
      | FIN_Payment_Cancellation_Output_Data_21_07_2016_expected.xls | Scenario 20 | Cancel Foreign Ccy Payment with Bank Charge in previous period, the Payment had already been reconciled                              |