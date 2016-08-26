@TH6_SALES_RETURN @Sales_Return @SO @integration @zoe
Feature: Sales Return

  Scenario: Sale return management
    Given user login the taskhub system
      And user navigates to "Operations>Sales Return>Sales Return" screen
     When user creates new sales return:
      | Return Request Date | Source Shipment No. |
      | 10/08/2016          | LGO0001965          |

      And user pick Collection Date
      | Collection Date |
      | 10/08/2016      |
      And user chooses Return All in Return Item panel
    #confirmation
    #Header
     Then user should see information for Header as the following:
      | Return Request Date | Source Shipment No | Customer            |
      | 10/08/2016          | LGO0001965         | Adela test, Combine |
    #Shm Info
      And user should see information for Shm Info as the following:
      | Source DO No. | Source SO No. | Customer PO No. | Salesperson | Ship To Address    | Ship To Contact | Actual Shipment Date | Loading Location                 | Collection Address | Collection Contact | Collection Date |
      |      20121233 | SO00009671    | POSO00009671    | Adela       | main\nmain address | Ley             | 19/05/2016           | Adela's Location 1, Sub Location | main address       | Ley                | 10/08/2016      |
    #Return Items
      And user should see Return Qty information as the following:
      | Return Qty |
      |     4.0000 |

    #Remark
      And user should see information at Remarks panel as the following:
      | Internal Remarks                                           | External Remarks                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
      | Appendix A: sample\niiii  1.\nBBBB  2.\nPPPP  3.\nMMMM  4. | Here what we are providing is based on the information that we have been supplied and/or any relevant plans. It relates to the works requested by the client to whom the estimate is addressed. Any changes or alterations to the works completed or to the materials requested by the client may result in additional costs. \nWork will be carried out during normal working hours. Should weekend, holiday or other extraordinary hours be required the client may incur an additional costs. |
      And user delete this Sales Return.
      | Sales Return No. |
      |                  |
