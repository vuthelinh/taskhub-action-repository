@vincent @adela @scm @check_pr_seq_no_equal_li_no
Feature: Check PR Seq No = LI no.

  Scenario Outline: Check PR Seq No = LI no.
    #Given "vincent" login to "(AUTO5)" company with password is "taskhub"
    Given user login the taskhub system
    When user navigates to "Processing>Project>Costing>Cost Item Enquiry & Request" screen
    Then user opens Project No. in Cost Item Enquiry & Request as "<Project No KEY>"
      | KEY | Project No. | Customer Name | Customer Job No. | Sales Person | Sales Manager | Start Date From | Start Date To | End Date From | End Date To | Subject |
      | 001 | PJE0000005  |               |                  |              |               |                 |               |               |             |         |
    Then user creates blank new request in Cost Item Request Summary of Cost Item Enquiry & Request
    Then user adds new item in Detail tab in Cost Item Request Draft of Cost Item Enquiry & Request as "<Cost Item Request Draft KEY>"
      | KEY | No. | Type | Item Code |
      | 001 | 1   | S    | V_003     |
      | 001 | 2   | S    | V_003     |
      | 001 | 3   | S    | V_003     |
      | 001 | 4   | S    | V_003     |
      | 001 | 5   | S    | V_003     |
      | 001 | 6   | S    | V_002     |
      | 001 | 7   | S    | V_002     |
      | 001 | 8   | S    | V_002     |
      | 001 | 9   | S    | V_002     |
      | 001 | 10  | S    | V_002     |
      | 001 | 11  | S    | V_002     |
      | 001 | 12  | S    | V_002     |
      | 001 | 13  | S    | V_002     |
      | 001 | 14  | S    | V_002     |
      | 001 | 15  | S    | V_002     |
      | 001 | 16  | S    | V_002     |
      | 001 | 17  | S    | V_002     |
    Then user inputs new data in Qty To Request Break Down By Phase in Cost Item Request Draft of Cost Item Enquiry & Request as "<Cost Item Request Draft KEY>"
      | KEY | No. | Phase No. | Qty to Request |
      | 001 | 1   | 1         | 7              |
      | 001 | 2   | 1         | 7              |
      | 001 | 3   | 1         | 10             |
      | 001 | 4   | 1         | 2              |
      | 001 | 5   | 1         | 2              |
      | 001 | 6   | 1         | 10             |
      | 001 | 7   | 1         | 20             |
      | 001 | 8   | 1         | 33             |
      | 001 | 9   | 1         | 1              |
      | 001 | 10  | 1         | 1              |
      | 001 | 11  | 1         | 1              |
      | 001 | 12  | 1         | 1              |
      | 001 | 13  | 1         | 1              |
      | 001 | 14  | 1         | 1              |
      | 001 | 15  | 1         | 1              |
      | 001 | 16  | 1         | 1              |
      | 001 | 17  | 1         | 10             |
    Then user submits Cost Item Request Draft in Cost Item Enquiry & Request
    Then user checks number of records in database as "<SQL Statement KEY>"
      | KEY | SQL Count Statement                                                                                                                                                                                                                                                                                                                                                                                        | Results | Replacement 1 Data Key  | Replacement 2 Data Key |
      | 001 | SELECT COUNT(*) FROM PR_REQ_NEW_DET AS A INNER JOIN PJ_CST_ITM_REQ_HST_DET AS B ON A.SERVICE_CODE = B.SERVICE_CODE AND A.SEQ_NO = B.LINE_ITEM_NO AND A.QTY = B.TOTAL_QTY_TO_REQ INNER JOIN PJ_CST_ITM_REQ_HST_HDR AS C ON B.REQUEST_ID = C.REQUEST_ID AND C.REQUEST_VOUCHER_NO = '@@#2#@@' WHERE A.PURCHASE_REQUISITION_NO = '@@#1#@@' AND A.LINE_ITEM_NO = 1 AND A.SERVICE_CODE = 'V_003' AND A.QTY = 7   | 1       | Purchase Requisition No | Request Voucher No     |
      | 001 | SELECT COUNT(*) FROM PR_REQ_NEW_DET AS A INNER JOIN PJ_CST_ITM_REQ_HST_DET AS B ON A.SERVICE_CODE = B.SERVICE_CODE AND A.SEQ_NO = B.LINE_ITEM_NO AND A.QTY = B.TOTAL_QTY_TO_REQ INNER JOIN PJ_CST_ITM_REQ_HST_HDR AS C ON B.REQUEST_ID = C.REQUEST_ID AND C.REQUEST_VOUCHER_NO = '@@#2#@@' WHERE A.PURCHASE_REQUISITION_NO = '@@#1#@@' AND A.LINE_ITEM_NO = 2 AND A.SERVICE_CODE = 'V_003' AND A.QTY = 7   | 1       | Purchase Requisition No | Request Voucher No     |
      | 001 | SELECT COUNT(*) FROM PR_REQ_NEW_DET AS A INNER JOIN PJ_CST_ITM_REQ_HST_DET AS B ON A.SERVICE_CODE = B.SERVICE_CODE AND A.SEQ_NO = B.LINE_ITEM_NO AND A.QTY = B.TOTAL_QTY_TO_REQ INNER JOIN PJ_CST_ITM_REQ_HST_HDR AS C ON B.REQUEST_ID = C.REQUEST_ID AND C.REQUEST_VOUCHER_NO = '@@#2#@@' WHERE A.PURCHASE_REQUISITION_NO = '@@#1#@@' AND A.LINE_ITEM_NO = 3 AND A.SERVICE_CODE = 'V_003' AND A.QTY = 10  | 1       | Purchase Requisition No | Request Voucher No     |
      | 001 | SELECT COUNT(*) FROM PR_REQ_NEW_DET AS A INNER JOIN PJ_CST_ITM_REQ_HST_DET AS B ON A.SERVICE_CODE = B.SERVICE_CODE AND A.SEQ_NO = B.LINE_ITEM_NO AND A.QTY = B.TOTAL_QTY_TO_REQ INNER JOIN PJ_CST_ITM_REQ_HST_HDR AS C ON B.REQUEST_ID = C.REQUEST_ID AND C.REQUEST_VOUCHER_NO = '@@#2#@@' WHERE A.PURCHASE_REQUISITION_NO = '@@#1#@@' AND A.LINE_ITEM_NO = 4 AND A.SERVICE_CODE = 'V_003' AND A.QTY = 2   | 1       | Purchase Requisition No | Request Voucher No     |
      | 001 | SELECT COUNT(*) FROM PR_REQ_NEW_DET AS A INNER JOIN PJ_CST_ITM_REQ_HST_DET AS B ON A.SERVICE_CODE = B.SERVICE_CODE AND A.SEQ_NO = B.LINE_ITEM_NO AND A.QTY = B.TOTAL_QTY_TO_REQ INNER JOIN PJ_CST_ITM_REQ_HST_HDR AS C ON B.REQUEST_ID = C.REQUEST_ID AND C.REQUEST_VOUCHER_NO = '@@#2#@@' WHERE A.PURCHASE_REQUISITION_NO = '@@#1#@@' AND A.LINE_ITEM_NO = 5 AND A.SERVICE_CODE = 'V_003' AND A.QTY = 2   | 1       | Purchase Requisition No | Request Voucher No     |
      | 001 | SELECT COUNT(*) FROM PR_REQ_NEW_DET AS A INNER JOIN PJ_CST_ITM_REQ_HST_DET AS B ON A.SERVICE_CODE = B.SERVICE_CODE AND A.SEQ_NO = B.LINE_ITEM_NO AND A.QTY = B.TOTAL_QTY_TO_REQ INNER JOIN PJ_CST_ITM_REQ_HST_HDR AS C ON B.REQUEST_ID = C.REQUEST_ID AND C.REQUEST_VOUCHER_NO = '@@#2#@@' WHERE A.PURCHASE_REQUISITION_NO = '@@#1#@@' AND A.LINE_ITEM_NO = 6 AND A.SERVICE_CODE = 'V_002' AND A.QTY = 10  | 1       | Purchase Requisition No | Request Voucher No     |
      | 001 | SELECT COUNT(*) FROM PR_REQ_NEW_DET AS A INNER JOIN PJ_CST_ITM_REQ_HST_DET AS B ON A.SERVICE_CODE = B.SERVICE_CODE AND A.SEQ_NO = B.LINE_ITEM_NO AND A.QTY = B.TOTAL_QTY_TO_REQ INNER JOIN PJ_CST_ITM_REQ_HST_HDR AS C ON B.REQUEST_ID = C.REQUEST_ID AND C.REQUEST_VOUCHER_NO = '@@#2#@@' WHERE A.PURCHASE_REQUISITION_NO = '@@#1#@@' AND A.LINE_ITEM_NO = 7 AND A.SERVICE_CODE = 'V_002' AND A.QTY = 20  | 1       | Purchase Requisition No | Request Voucher No     |
      | 001 | SELECT COUNT(*) FROM PR_REQ_NEW_DET AS A INNER JOIN PJ_CST_ITM_REQ_HST_DET AS B ON A.SERVICE_CODE = B.SERVICE_CODE AND A.SEQ_NO = B.LINE_ITEM_NO AND A.QTY = B.TOTAL_QTY_TO_REQ INNER JOIN PJ_CST_ITM_REQ_HST_HDR AS C ON B.REQUEST_ID = C.REQUEST_ID AND C.REQUEST_VOUCHER_NO = '@@#2#@@' WHERE A.PURCHASE_REQUISITION_NO = '@@#1#@@' AND A.LINE_ITEM_NO = 8 AND A.SERVICE_CODE = 'V_002' AND A.QTY = 33  | 1       | Purchase Requisition No | Request Voucher No     |
      | 001 | SELECT COUNT(*) FROM PR_REQ_NEW_DET AS A INNER JOIN PJ_CST_ITM_REQ_HST_DET AS B ON A.SERVICE_CODE = B.SERVICE_CODE AND A.SEQ_NO = B.LINE_ITEM_NO AND A.QTY = B.TOTAL_QTY_TO_REQ INNER JOIN PJ_CST_ITM_REQ_HST_HDR AS C ON B.REQUEST_ID = C.REQUEST_ID AND C.REQUEST_VOUCHER_NO = '@@#2#@@' WHERE A.PURCHASE_REQUISITION_NO = '@@#1#@@' AND A.LINE_ITEM_NO = 9 AND A.SERVICE_CODE = 'V_002' AND A.QTY = 1   | 1       | Purchase Requisition No | Request Voucher No     |
      | 001 | SELECT COUNT(*) FROM PR_REQ_NEW_DET AS A INNER JOIN PJ_CST_ITM_REQ_HST_DET AS B ON A.SERVICE_CODE = B.SERVICE_CODE AND A.SEQ_NO = B.LINE_ITEM_NO AND A.QTY = B.TOTAL_QTY_TO_REQ INNER JOIN PJ_CST_ITM_REQ_HST_HDR AS C ON B.REQUEST_ID = C.REQUEST_ID AND C.REQUEST_VOUCHER_NO = '@@#2#@@' WHERE A.PURCHASE_REQUISITION_NO = '@@#1#@@' AND A.LINE_ITEM_NO = 10 AND A.SERVICE_CODE = 'V_002' AND A.QTY = 1  | 1       | Purchase Requisition No | Request Voucher No     |
      | 001 | SELECT COUNT(*) FROM PR_REQ_NEW_DET AS A INNER JOIN PJ_CST_ITM_REQ_HST_DET AS B ON A.SERVICE_CODE = B.SERVICE_CODE AND A.SEQ_NO = B.LINE_ITEM_NO AND A.QTY = B.TOTAL_QTY_TO_REQ INNER JOIN PJ_CST_ITM_REQ_HST_HDR AS C ON B.REQUEST_ID = C.REQUEST_ID AND C.REQUEST_VOUCHER_NO = '@@#2#@@' WHERE A.PURCHASE_REQUISITION_NO = '@@#1#@@' AND A.LINE_ITEM_NO = 11 AND A.SERVICE_CODE = 'V_002' AND A.QTY = 1  | 1       | Purchase Requisition No | Request Voucher No     |
      | 001 | SELECT COUNT(*) FROM PR_REQ_NEW_DET AS A INNER JOIN PJ_CST_ITM_REQ_HST_DET AS B ON A.SERVICE_CODE = B.SERVICE_CODE AND A.SEQ_NO = B.LINE_ITEM_NO AND A.QTY = B.TOTAL_QTY_TO_REQ INNER JOIN PJ_CST_ITM_REQ_HST_HDR AS C ON B.REQUEST_ID = C.REQUEST_ID AND C.REQUEST_VOUCHER_NO = '@@#2#@@' WHERE A.PURCHASE_REQUISITION_NO = '@@#1#@@' AND A.LINE_ITEM_NO = 12 AND A.SERVICE_CODE = 'V_002' AND A.QTY = 1  | 1       | Purchase Requisition No | Request Voucher No     |
      | 001 | SELECT COUNT(*) FROM PR_REQ_NEW_DET AS A INNER JOIN PJ_CST_ITM_REQ_HST_DET AS B ON A.SERVICE_CODE = B.SERVICE_CODE AND A.SEQ_NO = B.LINE_ITEM_NO AND A.QTY = B.TOTAL_QTY_TO_REQ INNER JOIN PJ_CST_ITM_REQ_HST_HDR AS C ON B.REQUEST_ID = C.REQUEST_ID AND C.REQUEST_VOUCHER_NO = '@@#2#@@' WHERE A.PURCHASE_REQUISITION_NO = '@@#1#@@' AND A.LINE_ITEM_NO = 13 AND A.SERVICE_CODE = 'V_002' AND A.QTY = 1  | 1       | Purchase Requisition No | Request Voucher No     |
      | 001 | SELECT COUNT(*) FROM PR_REQ_NEW_DET AS A INNER JOIN PJ_CST_ITM_REQ_HST_DET AS B ON A.SERVICE_CODE = B.SERVICE_CODE AND A.SEQ_NO = B.LINE_ITEM_NO AND A.QTY = B.TOTAL_QTY_TO_REQ INNER JOIN PJ_CST_ITM_REQ_HST_HDR AS C ON B.REQUEST_ID = C.REQUEST_ID AND C.REQUEST_VOUCHER_NO = '@@#2#@@' WHERE A.PURCHASE_REQUISITION_NO = '@@#1#@@' AND A.LINE_ITEM_NO = 14 AND A.SERVICE_CODE = 'V_002' AND A.QTY = 1  | 1       | Purchase Requisition No | Request Voucher No     |
      | 001 | SELECT COUNT(*) FROM PR_REQ_NEW_DET AS A INNER JOIN PJ_CST_ITM_REQ_HST_DET AS B ON A.SERVICE_CODE = B.SERVICE_CODE AND A.SEQ_NO = B.LINE_ITEM_NO AND A.QTY = B.TOTAL_QTY_TO_REQ INNER JOIN PJ_CST_ITM_REQ_HST_HDR AS C ON B.REQUEST_ID = C.REQUEST_ID AND C.REQUEST_VOUCHER_NO = '@@#2#@@' WHERE A.PURCHASE_REQUISITION_NO = '@@#1#@@' AND A.LINE_ITEM_NO = 15 AND A.SERVICE_CODE = 'V_002' AND A.QTY = 1  | 1       | Purchase Requisition No | Request Voucher No     |
      | 001 | SELECT COUNT(*) FROM PR_REQ_NEW_DET AS A INNER JOIN PJ_CST_ITM_REQ_HST_DET AS B ON A.SERVICE_CODE = B.SERVICE_CODE AND A.SEQ_NO = B.LINE_ITEM_NO AND A.QTY = B.TOTAL_QTY_TO_REQ INNER JOIN PJ_CST_ITM_REQ_HST_HDR AS C ON B.REQUEST_ID = C.REQUEST_ID AND C.REQUEST_VOUCHER_NO = '@@#2#@@' WHERE A.PURCHASE_REQUISITION_NO = '@@#1#@@' AND A.LINE_ITEM_NO = 16 AND A.SERVICE_CODE = 'V_002' AND A.QTY = 1  | 1       | Purchase Requisition No | Request Voucher No     |
      | 001 | SELECT COUNT(*) FROM PR_REQ_NEW_DET AS A INNER JOIN PJ_CST_ITM_REQ_HST_DET AS B ON A.SERVICE_CODE = B.SERVICE_CODE AND A.SEQ_NO = B.LINE_ITEM_NO AND A.QTY = B.TOTAL_QTY_TO_REQ INNER JOIN PJ_CST_ITM_REQ_HST_HDR AS C ON B.REQUEST_ID = C.REQUEST_ID AND C.REQUEST_VOUCHER_NO = '@@#2#@@' WHERE A.PURCHASE_REQUISITION_NO = '@@#1#@@' AND A.LINE_ITEM_NO = 17 AND A.SERVICE_CODE = 'V_002' AND A.QTY = 10 | 1       | Purchase Requisition No | Request Voucher No     |

    Examples: 
      | Project No KEY | Cost Item Request Draft KEY | SQL Statement KEY |
      | 001            | 001                         | 001               |
