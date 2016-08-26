@phoebe_pre_data_9
Feature: Create and maintain supplier

Scenario Outline: Maintain Supplier
    Given user login the taskhub system
    When user navigates to "Global Setup>Party>Supplier>Supplier" screen
    And user maintains supplier as "<KEY SUPPLIER>"
      | KEY SUPPLIER | isContra | Prefix Auto Gen Code | Supplier | Supplier Name | Supplier Class Code | Party Group Code | Main Home Page | GST Registration No | Country Of Incorporation | Subcon WIP Glan | Sales Tax Code | Default Tenor Term Code | Default Tenor | IPT Related | Status | Unique Entity No | Main Supplier Code | Supplier Short Name | Supplier Category Code | Supplier Rank Code | Purchasing Zone | Party Contra GLAN | Contra Realized Exch GLAN | Default Discount Percent | Combine Shm to Invoices | Remarks | Company |
      | 1            |          |                      | BigC     | BigC          | CLASS2-SCM          |                  |                |                     |                          |                 | GST7           |                         |               |             |        |                  |                    |                     |                        |                    |                 |                   |                           |                          | No                      |         |         |
    # ADDRESS TAB
    And supplier is added address as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Address Code | Description | Address | Country Code | State Province | City Town | Postal Code | Inc Type                               | Default                                | LRA | Del |
      | 1            | ADD          | MyDinh      |         |              |                |           |             | Purchase, Ship to, Payment to Supplier | Purchase, Ship to, Payment to Supplier |     |     |
    And supplier maintains added address contact type as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Address Code | Contact Type | Contact Information | Default | Del |
      | 1            | ADD          | Telephone    | 045678910           | y       |     |
    #CONTACT TAB
    And supplier is added contact as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Party Contact Code | Salutation | First Name | Middle Name | Last Name | Name          | Address Code | Designation | Designation Group | Department | Inc Type                               | Default                                | Del |
      | 1            | OFF                |            |            |             |           | Contactperson |              |             |                   |            | Purchase, Ship to, Payment to Supplier | Purchase, Ship to, Payment to Supplier |     |
    And supplier maintains added contact type as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Party Contact Code | Contact Type      | Contact Information | Default | Del |
      | 1            | OFF                | DID (Direct Line) | 04123569            | y       |     |
    # BANK DETAIL TAB
    And supplier is added bank detail as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Bank | Description | Account No | Currency | Default | Del |
    # SBU TAB
    And supplier is added SBU as "<KEY SUPPLIER>"
      | KEY SUPPLIER | SBU | Description | Del |
    #CURRENCY TAB
    And supplier is added currency as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Currency | Del |
      | 1            | SGD      |     |
    # PAYMENT TAB
    And supplier is added payment as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Operational Currency | Overall Credit Limit |
      | 1            | SGD                  |                      |
    And supplier is added payment option as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Description      | Is Active | Default |
      | 1            | Advance Payment  | Y         |         |
      | 1            | Cash on Delivery | Y         | Y       |
      | 1            | Leasing          | Y         |         |
      | 1            | Open Account     | Y         |         |
      | 1            | Trade Financing  | Y         |         |
    And supplier is added payment term as "<KEY SUPPLIER>"
      | KEY SUPPLIER | OPTION           | Description      | Is Active | Default |
      | 1            | Cash on Delivery | Cash on Delivery | Y         | Y       |
    And supplier is added payment menthod as "<KEY SUPPLIER>"
      | KEY SUPPLIER | OPTION           | TERM             | Description | Is Active | Default |
      | 1            | Cash on Delivery | Cash on Delivery | Cash        | Y         | Y       |
    And supplier is updated
    # LOCAL INFO TAB
    And supplier is added local shipment term as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Inc | Shipping Term | Air | Sea | Road | Rail | Default |
      | 1            | y   | FOB           |     |     |      |      | y       |
    And supplier is added local shipment country as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Country | Loading | Discharge | Final Dest | Del |
    And supplier is added local shipment port as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Country | Port | Loading | Dischange | Final Dest |
    And supplier is added local default setting as "<KEY SUPPLIER>"
      | KEY SUPPLIER | Deduct Charge Flag | Delivery To For nonCC | Delivery Mode |
    And supplier is updated

    Examples: 
      | KEY SUPPLIER |
      | 1            |
