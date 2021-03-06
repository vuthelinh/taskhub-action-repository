@vincent @angela @scm @other_create_so_with_multilineitem
Feature: Create SO, LG Out

  Scenario Outline: Create SO, LG Out
    Given user login the taskhub system
    When user navigates to "Processing>Sales>Sales Order" screen
    Given user creates new Sales Order in Draft stage of Sales Order Summary as "<Sales Order KEY>"
      | KEY | Customer Code | Customer Name | Copy From Option | Copy From |
      | 001 | ANGELA        |               |                  |           |
    And user inputs data in Draft stage in Header tab of Sales Order as "<Sales Order KEY>"
      | KEY | Allocate PO to SO |
      | 001 | Yes               |
    And user inputs data in Draft stage in Detail tab of Sales Order as "<Sales Order KEY>"
      | KEY | LI No. | Item Type | Item Code | Qty | Pack Size | No. Of Pack | Unit | PO  | Supplier | Ccy | PO Qty Allocation | Unit Cost | Discount Percent | Discount Amount |
      | 001 | 1.0    | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 2.0    | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 3.0    | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 4.0    | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 5.0    | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 6.0    | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 7.0    | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 8.0    | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 9.0    | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 10.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 11.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 12.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 13.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 14.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 15.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 16.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 17.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 18.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 19.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 20.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 21.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 22.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 23.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 24.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 25.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 26.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 27.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 28.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 29.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 30.0   | I         | A1        | 100 |           |             | 0.1  | Yes | ANGELA   | SGD | 100               |           |                  |                 |
      | 001 | 31.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 32.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 33.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 34.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 35.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 36.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 37.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 38.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 39.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 40.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 41.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 42.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 43.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 44.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 45.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 46.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 47.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 48.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 49.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 50.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 51.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 52.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 53.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 54.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 55.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 56.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 57.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 58.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 59.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 60.0   | I         | 111       | 200 |           |             | 0.1  | Yes | ANGELA   | SGD | 200               |           |                  |                 |
      | 001 | 61.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 62.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 63.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 64.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 65.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 66.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 67.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 68.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 69.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 70.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 71.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 72.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 73.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 74.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 75.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 76.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 77.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 78.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 79.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 80.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 81.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 82.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 83.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 84.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 85.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 86.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 87.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 88.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 89.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 90.0   | I         | A3        | 300 |           |             | 0.1  | Yes | ANGELA   | SGD | 300               |           |                  |                 |
      | 001 | 91.0   | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 92.0   | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 93.0   | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 94.0   | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 95.0   | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 96.0   | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 97.0   | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 98.0   | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 99.0   | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 100.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 101.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 102.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 103.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 104.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 105.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 106.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 107.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 108.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 109.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 110.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 111.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 112.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 113.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 114.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 115.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 116.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 117.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 118.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 119.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 120.0  | I         | SERIAL    | 400 |           |             | 0.1  | Yes | ANGELA   | SGD | 400               |           |                  |                 |
      | 001 | 121.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 122.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 123.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 124.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 125.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 126.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 127.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 128.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 129.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 130.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 131.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 132.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 133.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 134.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 135.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 136.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 137.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 138.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 139.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 140.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 141.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 142.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 143.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 144.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 145.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 146.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 147.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 148.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 149.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 150.0  | I         | SMC1      | 500 |           |             | 0.1  | Yes | ANGELA   | SGD | 500               |           |                  |                 |
      | 001 | 151.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 152.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 153.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 154.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 155.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 156.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 157.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 158.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 159.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 160.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 161.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 162.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 163.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 164.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 165.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 166.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 167.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 168.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 169.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 170.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 171.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 172.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 173.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 174.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 175.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 176.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 177.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 178.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 179.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 180.0  | I         | V_001     | 600 |           |             | 0.1  | Yes | ANGELA   | SGD | 600               |           |                  |                 |
      | 001 | 181.0  | I         | SMC2      | 700 |           |             | 0.1  | Yes | ANGELA   | SGD | 700               |           |                  |                 |
      | 001 | 182.0  | I         | SMC2      | 700 |           |             | 0.1  | Yes | ANGELA   | SGD | 700               |           |                  |                 |
      | 001 | 183.0  | I         | SMC2      | 700 |           |             | 0.1  | Yes | ANGELA   | SGD | 700               |           |                  |                 |
      | 001 | 184.0  | I         | SMC2      | 700 |           |             | 0.1  | Yes | ANGELA   | SGD | 700               |           |                  |                 |
      | 001 | 185.0  | I         | SMC2      | 700 |           |             | 0.1  | Yes | ANGELA   | SGD | 700               |           |                  |                 |
      | 001 | 186.0  | I         | SMC2      | 700 |           |             | 0.1  | Yes | ANGELA   | SGD | 700               |           |                  |                 |
      | 001 | 187.0  | I         | SMC2      | 700 |           |             | 0.1  | Yes | ANGELA   | SGD | 700               |           |                  |                 |
      | 001 | 188.0  | I         | SMC2      | 700 |           |             | 0.1  | Yes | ANGELA   | SGD | 700               |           |                  |                 |
      | 001 | 189.0  | I         | SMC2      | 700 |           |             | 0.1  | Yes | ANGELA   | SGD | 700               |           |                  |                 |
      | 001 | 190.0  | I         | SMC2      | 700 |           |             | 0.1  | Yes | ANGELA   | SGD | 700               |           |                  |                 |
      | 001 | 191.0  | I         | SMC2      | 700 |           |             | 0.1  | Yes | ANGELA   | SGD | 700               |           |                  |                 |
    Then user submits created Sales Order then gets Purchase Order No in Draft stage of Sales Order
    When user navigates to "Processing>Logistics>Active Shipment>Outgoing Shipment>[2]" screen
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary by created Sales Order No.
    Then user resets Shm Qty to zero for All for items in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details
    Then user submits created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary by created Sales Order No.
    Then user resets Shm Qty to zero for All for items in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details
    Then user submits created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary by created Sales Order No.
    Then user resets Shm Qty to zero for All for items in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details
    Then user submits created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary by created Sales Order No.
    Then user resets Shm Qty to zero for All for items in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details
    Then user submits created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary by created Sales Order No.
    Then user resets Shm Qty to zero for All for items in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details
    Then user submits created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary by created Sales Order No.
    Then user resets Shm Qty to zero for All for items in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details
    Then user submits created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary
    Then user opens created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary by created Sales Order No.
    Then user resets Shm Qty to zero for All for items in Detail tab of Logistic Active Outstanding Shipment - Outgoing Shipment Details
    Then user submits created Shipment Voucher No. in Outstanding state of Logistic Outgoing Active Shipment Summary

    Examples: 
      | Sales Order KEY |
      | 001             |
