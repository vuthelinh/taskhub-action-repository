@phoebe_pre_data_7
Feature: Create and maintain Customer

  Scenario Outline: Maintain Customer
    Given user login the taskhub system
    And user navigates to "Global Setup>Party>Customer>Customer" screen
    When user maintains customer as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Prefix Auto Gen Code | Customer Code | Unique Entity No | Customer Name       | Customer Class Code | Party Group Code | Industry Code | Acquired By | Country Of Incorporation | Sales Tax Code | Contra Realized Exch GLAN | Statement Delivery Option | Default Tenor | Discount | Due AR Invoice Correspondence Language | Customer Remarks | Status | Main Customer Code | Customer Short Name | Customer Category Code | Customer Group Code | Customer Type | Main Home Page | GST Registration No | Party Contra GLAN | Default Validity | Default Tenor Term Code | Price Markup Percent | Combine Shm to Invoices | IPT Related | Shipping Marks Code | Company |
      | 1            |                      | Synergix      |                  | Synergix Technology | CLASS-SCM           |                  |               |             |                          | GST0           |                           |                           |               |          |                                        |                  |        |                    |                     |                        |                     |               |                |                     |                   |                  |                         |                      |                         |             |                     |         |
    And customer maintains address as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Address Code | Description | Address | Country Code | State Province | City Town | Postal Code | Inc Type                | Default                 | LRA | Del |
      | 1            | ADD1         | Thanh Xuan  |         |              |                |           |             | Sales, Customer Billing | Sales, Customer Billing |     |     |
    And customer maintains address contact type as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Address Code | Contact Type | Contact Information | Default | Del |
      | 1            | ADD1         | Telephone    | 4556313             | y       |     |
    #CONTACT TAB
    And customer maintains contact as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Party Contact Code | Salutation | First Name | Middle Name | Last Name | Name    | Address Code | Designation | Designation Group | Department | Inc Type                | Default                 | Del |
      | 1            | Contact1           |            |            |             |           | SCMteam |              |             |                   |            | Sales, Customer Billing | Sales, Customer Billing |     |
    And customer maintains contact type as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Party Contact Code | Contact Type | Contact Information | Default | Del |
    # BANK DETAIL TAB
    And customer maintains bank detail as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Bank | Description | Account No | Currency | Default | Del |
    # SBU TAB
    And customer maintains SBU as "<KEY CUSTOMER>"
      | KEY CUSTOMER | SBU | Description | Del |
    #SALES PERSON TAB
    And customer maintains sale person as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Sales Person | Name | Default | D Sales | Del |
    #CURRENCY TAB
    And customer maintains currency as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Currency | Del |
      | 1            | SGD      |     |
    #PAYMENT TAB
    And customer maintains payment as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Operational Currency | Next Credit Review Date |
      | 1            | SGD                  |                         |
    And customer maintains payment option as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Description      | Is Active | Default |
      | 1            | Advance Payment  | Y         |         |
      | 1            | Cash on Delivery | Y         | Y       |
      | 1            | Leasing          | Y         |         |
      | 1            | Open Account     | Y         |         |
      | 1            | Trade Financing  | Y         |         |
    And customer maintains payment term as "<KEY CUSTOMER>"
      | KEY CUSTOMER | OPTION           | Description      | Is Active | Default |
      | 1            | Cash on Delivery | Cash on Delivery | Y         | Y       |
    And customer maintains payment menthod as "<KEY CUSTOMER>"
      | KEY CUSTOMER | OPTION           | TERM             | Description | Is Active | Default |
      | 1            | Cash on Delivery | Cash on Delivery | Cash        | Y         | Y       |
    And customer is updated
    # LOCAL INFO GET DATA FROM BUNCHA SERVER
    # LOCAL - PRICING TAB
    When customer maintains local pricing as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Currency Code | Inventory Price List Code | Service Price List Code |
    When customer maintains local pricing list as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Currency Code | Working Area Code | Inventory Price List Code | Service Price List Code | Del |
    # LOCAL - CREDIT/LIMIT TERM TAB
    When customer maintains local credit limit term as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Operational Currency | Credit Limit Amt | Grace Period |
    # LOCAL - SHIPMENT TERM INFO TAB
    When customer maintains local shipment term as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Inc | Shipping Term | Air | Sea | Road | Rail | Default |
      | 1            | y   | FOB           |     |     |      |      | y       |
    # LOCAL - SHIPMENT PORT INFO TAB
    When customer maintains local shipment port as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Country | Loading | Discharge | Final Dest | Del |
    When customer maintains local detail port as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Country | Port | Loading | Discharge | Final Dest |
    # LOCAL - INVENTORY TAB
    When customer maintains local customer inverntory as "<KEY CUSTOMER>"
      | KEY CUSTOMER | Inventory Brand | Discount Code | Discount |
    And customer is updated

    Examples: 
      | KEY CUSTOMER |
      | 1            |
