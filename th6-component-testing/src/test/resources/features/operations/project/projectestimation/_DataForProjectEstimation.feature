@masterdata
Feature: Input data for Project estimation Testing

  Background: 
    Given user is currently logged in to TaskHub System

  Scenario Outline: Create master data
    #Create Gl Accounts
    And user navigates to "Master Setup>Accounting>Chart Of Acc" screen
    And I creates chart of account as "<KEY>"
      | KEY | GL Account Code | Description          |
      | 1   | STEVEGLAN       | GLAN of Steve        |
      | 1   | STEVEOUTPUTGLAN | Output Glan of Steve |
    And user come back to home screen
    #Create Customer Classes
    And user navigates to "Master Setup>Customer>Customer Class" screen
    And I create Customer Class "<KEY>"
      | KEY | Customer Class Code | Receivable GLAN |
      | 1   | STEVECUS            | STEVEGLAN       |

    Examples: 
      | KEY |
      | 1   |

  #Create currencies
  Scenario Outline: Create master data
    And user navigates to "Master Setup>Currency>Currency" screen
    When I create currencies "<KEY>"
      | KEY | Currency | Description | Minimum Bank Rate | Maximum Bank Rate | Maximum Spread % | Spread % Base | Credit Limit Exchange Rate |
      | 1   | THB      | St thb      | 1                 | 1                 | 0                | Buy Rate      | 1                          |
      | 2   | MYR      | St MYR      | 3.14              | 5                 | 10               | Buy Rate      | 3.14                       |
    And user come back to home screen
    And user navigates to "Master Setup>Currency>Exchange Rate" screen
    And I enter exchange rates "<KEY>"
      | KEY | Effective Date From | Effective Date To | % Upwards Variance Allowed | % Downwards Variance Allowed | Bank's Sell Rate | Bank's Buy Rate |
      | 1   | 22/07/2016          | 22/08/2017        | 5                          | 5                            | 1                | 1               |
      | 2   | 22/07/2016          | 22/08/2016        | 5                          | 6                            | 5                | 3.17            |
      | 2   | 23/08/2016          | 23/09/2016        | 100                        | 4                            | 5                | 4.2             |

    Examples: 
      | KEY |
      | 1   |
      | 2   |

  Scenario Outline: Create master data
    #Create SBU
    And user navigates to "Master Setup>Company>Strategic Business Unit" screen
    And I create SBU as "<KEY>"
      | KEY | SBU Code | Description | Detailed Description | CTI Code | Global Status |
      | 1   | STEVESBU | Steve SBU   | Detailed Description | Code     | Active        |
    #Create sales taxes
    And user navigates to "Master Setup>Accounting>Sales Tax" screen
    When I create sales tax with "<KEY>"
      | KEY | Sales Tax Code | Sales Tax % | Input Tax GLAN | Output Tax GLAN |
      | 1   | STV01          | 7           | STEVEGLAN      | STEVEOUTPUTGLAN |
    And user come back to home screen
    #Create customers
    And user navigates to "Master Setup>Customer>Customer" screen
    When I create customer as "<KEY>"
      | KEY | Customer Code    | Customer Name | Customer Class Code | Sales Tax Code | Customer Short Name | Default Tenor Term Code |
      | 1   | STEVE CUSTOMER 1 | Steve Job     | STEVECUS            | STV01          | Steve               |                         |
    #ADDRESS TAB
    And the customer is added address as "<KEY>"
      | KEY | Address Code | Description | Address                         | Country Code | Postal Code | Inc Type             | Default              | LRA |
      | 1   | Add1         | Address     | Nguyen Trai, Thanh Xuan, Ha Noi | SG           | 11          | Sales, Bank, Ship to | Sales, Bank, Ship to | y   |
    And the customer is added address contact type as "<KEY>"
      | KEY | Address Code | Contact Type | Contact Information | Default |
      | 1   | Add1         | Telephone    | 456789              | y       |
    #CONTACT TAB
    And the customer is added contact as "<KEY>"
      | KEY | Party Contact Code | Name           | Department   | Inc Type             | Default              |
      | 1   | STCON              | Contact person | Auto testing | Sales, Bank, Ship to | Sales, Bank, Ship to |
    #CURRENCY TAB
    And the customer is added currency as "<KEY>"
      | KEY | Currency |
      | 1   | THB      |
      | 1   | MYR      |
    And the customer is added payment term as "<KEY>"
      | KEY | OPTION           | Description      | Is Active | Default |
      | 1   | Cash on Delivery | Cash on Delivery | Y         | Y       |
    And the customer is added payment menthod as "<KEY>"
      | KEY | OPTION           | TERM             | Description | Is Active | Default |
      | 1   | Cash on Delivery | Cash on Delivery | Cash        | Y         | Y       |
    And the customer is updated
    #Create project class
    And user navigates to "Master Setup>Project>Project Class>[1]" screen
    When I create a project class as "<KEY>"
      | KEY | Project Class Code | Project Class Description    |
      | 1   | STPJCLASS          | Project Class For Testing PE |
    And user come back to home screen
    And I navigate to "Master Setup>Inventory>Class" screen
    When I create a new inventory class as "<KEY>"
      | KEY | Inventory Class Code | Description           | Costing Method | Inventory GLAN |
      | 1   | STINCLASS            | Steve Inventory Class | FIFO           | STEVEGLAN      |

    Examples: 
      | KEY |
      | 1   |

  Scenario: Create master data
    #Create Project Categories
    And user create Project Category
      | Project Category Code | Description                     |
      | STPJCAT               | Project Category For Testing PE |
    #Create brands
    And user create Brand
      | Inventory Brand Code | Description                      |
      | STITEM1B1            | Inventory Brand Code for STITEM1 |
    #Create Inventory Item
    And user create new Inventory Item
      | Inventory Code   | Description | Base UOM | Inventory Class | Inventory Brand |
      | STEVEITEM1INCODE |             | KG       | STINCLASS       | STITEM1B1       |
    #Create Cost Item Groups
    And user create Cost Item Group
      | Cost Item Group Code | Description           |
      | STEVECOSTITEMGROUP   | Steve cost item group |
    #Create drawing objects
    And user create Drawing Object
      | Drawing Object Code | Description                         | Cost Item Group    | Brand     | Inventory        |
      | STEVEITEM1INCODE    | Steve inventory code for steveitem1 | STEVECOSTITEMGROUP | STITEM1B1 | STEVEITEM1INCODE |
    #Create Service
    And user create Service
      | Service Code  | Description     | Expense GLAN |
      | STEVESERVICE1 | Steve Service 1 | STEVEGLAN    |
    And user add Approving Officer
      | Module Code Desc | Transaction Type Desc | Approving Method             | Employee Code | Approval Home Amount Limit (Per Voucher) |
      | Project Costing  | Quotation             | By Amount (1 Level by Value) | STEVE1        | 100000000                                |
      | Project Costing  | Order/Estimation      | By Amount (1 Level by Value) | STEVE1        | 100000000                                |
      | Project Costing  | Quotation             | By Amount (1 Level by Value) | ZOE1          | 100000000                                |
      | Project Costing  | Order/Estimation      | By Amount (1 Level by Value) | ZOE1          | 100000000                                |
