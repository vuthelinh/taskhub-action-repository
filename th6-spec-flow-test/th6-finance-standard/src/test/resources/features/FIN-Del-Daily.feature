@n-del-fin-daily
Feature: Nancy del master data daily for FIN

  ###############################################################################
  ###############################################################################
  # ~~~~~~~~~~~~~~~~~~~~~~~~~~ Master Setup ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario Outline: 1. Delete Exchange Rate with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Currency>Exchange Rate" screen
    When user delete exchange rate as "<KEY RATE>"
      | KEY RATE | Currency |
      | 001      | N04      |
      | 001      | N05      |
      | 001      | N06      |

    Examples: 
      | KEY RATE |
      | 001      |

  Scenario: 2. Delete Segment with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Segment>Segment" screen
    And user delete segment
      | Segment No | Segment Code |
      | 1          | NSEG1        |
      | 1          | NNA          |
      | 2          | NSEG2        |
      | 2          | NNA          |
      | 3          | NSEG3        |
      | 3          | NNA          |
      | 4          | NSEG4        |
      | 4          | NNA          |

  Scenario Outline: 3. Delete Bank Book Recurring Template with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Accounting>Bank Book Recurring Template" screen
    When user delete BK recurring template as "<KEY BK>"
      | KEY BK | Bank Template Code |
      | 001    | NBT01              |
      | 001    | NBT02              |
      | 001    | NBT03              |

    Examples: 
      | KEY BK |
      | 001    |

  Scenario: 4. Delete MT GL Revaluation with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Accounting>GL Revaluation" screen
    And user delete GL revaluation
      | GL Account Code |
      | n11020          |
      | n10040          |
      | nZ-400          |
      | nZ-500          |

  Scenario Outline: 5. Delete MT GL Recurring Voucher with feature file
    Given user login the TH6 system
    And user navigates to "Master Setup>Accounting>GL Recurring Voucher" screen
    When user delete MT GL Recurring VCH as "<KEY RECURRING>"
      | KEY RECURRING | Recurring Voucher Code |
      | 001           | NRVC01                 |
      | 001           | NRVC02                 |

    Examples: 
      | KEY RECURRING |
      | 001           |

  ###############################################################################
  ###############################################################################
  # ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ GLOBAL SETUP ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Scenario: 6. Delete FA
    Given user login the TH6 system
    When user navigates to "Master Setup>Fixed Asset>Fixed Asset>[1]" screen
    And user delete global fixed asset
      | Fixed Asset Code |
      | NFA1             |
    When user navigates to "Master Setup>Fixed Asset>Location" screen
    And user delete fixed asset location
      | Fixed Asset Location Code |
      | nsg                       |
      | nvn                       |
      | nml                       |
    When user navigates to "Master Setup>Fixed Asset>Category" screen
    And user delete fixed asset category
      | Fixed Asset Category Code |
      | NFA-CATE01                |
      | NFA-CATE02                |
      | NFA-CATE03                |
    When user navigates to "Master Setup>Fixed Asset>Class" screen
    And user delete fixed asset class
      | Fixed Asset Class Code |
      | NFA1                   |
      | NFA2                   |
      | NFA3                   |

  Scenario: 7. Delete Unit of Measurement
    Given user login the TH6 system
    When user navigates to "Master Setup>Inventory>Unit of Measurement" screen
    And user delete unit of measurement
      | KEY UOM | UOM Code |
      | 001     | nauto    |
      | 001     | nbox     |
      | 001     | nkm      |
      | 001     | npiece   |

  Scenario: 8. Delete Service
    Given user login the TH6 system
    When user navigates to "Master Setup>Service>Service" screen
    And user delete service
      | KEY SERVICE | Service Code |
      | 001         | NS1          |
      | 002         | NS2          |

  Scenario: 9. Delete Customer Class
    Given user login the TH6 system
    When user navigates to "Master Setup>Customer>Customer Class" screen
    And user delete customer class
      | Customer Class Code |
      | ncuscl01            |
      | ncuscl02            |
      | ncuscl03            |
      | ncuscl04            |
      | ncuscl05            |

  Scenario: 10. Delete Supplier Class
    Given user login the TH6 system
    When user navigates to "Master Setup>Supplier>Supplier Class" screen
    And user delete supplier class
      | Supplier Class Code |
      | nsupcl01            |
      | nsupcl02            |
      | nsupcl03            |
      | nsupcl04            |

  Scenario: 11. Delete Currency with feature file
    Given user login the TH6 system
    When user navigates to "Master Setup>Currency>Currency" screen
    When user delete currency
      | KEY CURRENCY | Currency |
      | 001          | N04      |
      | 001          | N05      |
      | 001          | N06      |

  Scenario: 12. Del Chart Of Account Daily
    Given user login the TH6 system
    And user navigates to "Master Setup>Accounting>Chart Of Acc" screen
    When user delete chart of account daily
      | GL Account Code | Description                            | Account Type       | Status | For Sub Ledger Account | Company |
      | 10000           | Plant & Machinery                      | Balance Sheet Item | Active | No                     | all     |
      | 10010           | Motor Vehicles                         | Balance Sheet Item | Active | No                     | all     |
      | 10020           | Office Equipment                       | Balance Sheet Item | Active | No                     | all     |
      | 10030           | Furniture & Fittings                   | Balance Sheet Item | Active | No                     | all     |
      | 10040           | IT Hardware & Software                 | Balance Sheet Item | Active | No                     | all     |
      | 10050           | Renovation                             | Balance Sheet Item | Active | No                     | all     |
      | 11000           | Cumulative Depn-Plant & Mchinery       | Balance Sheet Item | Active | No                     | all     |
      | 11010           | Cumulative Depn-Motor Vehicles         | Balance Sheet Item | Active | No                     | all     |
      | 11020           | Cumulative Depn-Office Equipment       | Balance Sheet Item | Active | No                     | all     |
      | 11040           | Cumulative Depn-IT Hardware & Software | Balance Sheet Item | Active | No                     | all     |
      | 12000           | FA Disposal Clearing                   | Balance Sheet Item | Active | No                     | all     |
      | Z-100           | Fixed Asset Clearing                   | Balance Sheet Item | Active | No                     | all     |
      | Z-200           | Inventory Clearing                     | Balance Sheet Item | Active | No                     | all     |
      | Z-300           | Receivable Clearing                    | Balance Sheet Item | Active | No                     | all     |
      | Z-400           | Payable Clearing                       | Balance Sheet Item | Active | No                     | all     |
      | Z-500           | Bank Clearing                          | Balance Sheet Item | Active | No                     | all     |
