Feature: Service

  Scenario Outline: Create Service with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Service>Service" screen
    When user create service as "<KEY SERVICE>"
      | KEY SERVICE | Service Code | Service Description                  | Service Category | UOM   | Track Qty in Project | Budget Category Code | Service Type                                     | Revenue Status | Revenue GLAN | Unearned Revenue GLAN | Sales Accrual GLAN | Report Grouping | Default Sales Tax | Intercompany Sales Tax | Expense Status | Expense GLAN | Accrued Cost GLAN | Overhead GLAN | Company      |
      | 001         | S1           | Service 01 for Synergix Testing ONLY |                  | PIECE |                      |                      | Expense (Additional Payment),Revenue (Deduction) | Active         | 51040        | 21020                 |                    |                 | gst0              |                        | Active         | 60030        | 43010             |               | AUTO4, AUTO1 |
      | 002         | S2           | Service 02 for Synergix Testing ONLY |                  | PieCE |                      |                      | Expense (Additional Payment),Revenue (Deduction) | Active         | 51040        | 21020                 |                    |                 | gst0              |                        | Active         | 60030        | 43010             |               | AUTO4, AUTO1 |
    And service is added service relation as "<KEY SERVICE>"
      | KEY SERVICE | Party Type Group | Party Type        | Revenue | Expense |
      | 001         | Customer         | Products/Services | y       | y       |
      | 001         | Customer         | Retailer          | y       | y       |
      | 001         | Service Vendor   | Services          | y       | y       |
      | 001         | Supplier         | Retail            | y       | y       |
      | 001         | Supplier         | Supplier          | y       | y       |
      | 002         | Customer         | Products/Services | y       | y       |
      | 002         | Customer         | Retailer          | y       | y       |
      | 002         | Service Vendor   | Services          | y       | y       |
      | 002         | Supplier         | Retail            | y       | y       |
      | 002         | Supplier         | Supplier          | y       | y       |
    And service is updated

    Examples: 
      | KEY SERVICE |
      | 001         |
      | 002         |

  Scenario Outline: Update Service with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Service>Service" screen
    When user udpate service as "<KEY SERVICE>"
      | KEY SERVICE | Service Code | Service Description                  | Service Category | UOM   | Track Qty in Project | Budget Category Code | Service Type                                     | Revenue Status | Revenue GLAN | Unearned Revenue GLAN | Sales Accrual GLAN | Report Grouping | Default Sales Tax | Intercompany Sales Tax | Expense Status | Expense GLAN | Accrued Cost GLAN | Overhead GLAN | Company      |
      | 001         | S1           | Service 01 for Synergix Testing ONLY |                  | PIECE |                      |                      | Expense (Additional Payment),Revenue (Deduction) | Active         | 51040        | 21020                 |                    |                 | gst0              |                        | Active         | 60030        | 43010             |               | AUTO4, AUTO1 |
    And service is added service relation as "<KEY SERVICE>"
      | KEY SERVICE | Party Type Group | Party Type        | Revenue | Expense |
      | 001         | Customer         | Products/Services | y       | y       |
      | 001         | Customer         | Retailer          | y       | y       |
      | 001         | Service Vendor   | Services          | y       | y       |
      | 001         | Supplier         | Retail            | y       | y       |
      | 001         | Supplier         | Supplier          | y       | y       |
    And service is updated

    Examples: 
      | KEY SERVICE |
      | 001         |

  Scenario: Delete Service
    Given user login the TH6 system
    When user navigates to "Master Setup>Service>Service" screen
    And user delete service
      | KEY SERVICE | Service Code |
      | 001         | S1           |
      | 002         | S2           |

  Scenario: Create Service
    Given user login the TH6 system
    When user navigates to "Master Setup>Service>Service" screen
    And user create new service
    And user logout
