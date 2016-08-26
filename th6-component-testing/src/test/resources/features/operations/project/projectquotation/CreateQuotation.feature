Feature: Create a new quotation
  In order to bid for a project
  As a project coordinator
  I want to create a new quotation
  
  Background:
	Given user is currently logged in to TaskHub System
 
 #####Item Budget Quantity and Labour Budget Quantity of an Inventory Item is calculated correctly
 ###  Item Budget Qty = Drawing Qty * (1 + Est.Wastage %)
 ###  Item Labour Budget Qty = Drawing Qty x Budget Labour Qty
  @ian @project @deluge @integration
  Scenario Outline: Item Budget Quantity and Labour Budget Quantity of an Inventory Item is calculated correctly
	Given I want to create a new quotation for "<PROJECT>"
	  | PROJECT | Customer | Quotation Date | Currency | Exchange Rate | Sales Tax |
	  | 001     | ANTEO1   | 15/08/2016     |          |               |           |
	  | 002     | ANTEO1   | 15/08/2016     |          |               |           |
	  | 003     | ANTEO1   | 15/08/2016     |          |               |           |
	  | 004     | ANTEO1   | 15/08/2016     |          |               |           |
	When I divide the project "<PROJECT>" into phases
	#Key Deluge Phases
	  | PROJECT | Phase No | Phase                                  |
	  | 001     | 1        | Project Engineering / Design / Planing |
	  | 002     | 1        | Project Engineering / Design / Planing |
	  | 003     | 1        | Project Engineering / Design / Planing |
	  | 004     | 1        | Project Engineering / Design / Planing |
	And I add Cost Item in phases in "<PROJECT>"
	  | PROJECT | Phase No | Type | Drawing Object | Item Code Description | Drawing Qty | Est. Wastage % | Item Budget>Unit Cost | Item Budget>Markup % | Labour Budget>Qty | Labour Budget>Unit Cost | Labour Budget>Markup % |
	  | 001     | 1        | I    | Valve          | SS-VALVE              | 0           | 4              |                       |                      |                   |                         |                        |
	  | 002     | 1        | I    | Valve          | SS-VALVE              | 4           | 0              |                       |                      |                   |                         |                        |
	  | 003     | 1        | I    | Valve          | SS-VALVE              | 0           | 0              |                       |                      |                   |                         |                        |
	  | 004     | 1        | I    | Valve          | SS-VALVE              | 4           | 4              |                       |                      |                   |                         |                        |
	Then The Costing Sheet in "<PROJECT>" should be calculated as following
	  | PROJECT | Phase No | Drawing Object No | Item Budget>Qty | Item Budget>Unit Cost | Labour Budget>Qty | Budget Cost |
	  | 001     | 1        | 1                 | 5.2             | 0                     | 0                 |             |
	  | 002     | 1        | 1                 | 4               | 48                    | 48                |             |
	  | 003     | 1        | 1                 | 0               | 0                     | 0                 |             |
	  | 004     | 1        | 1                 | 4.16            | 48                    | 48                |             |
	When I abort the quotation
 
 #    Examples: Drawing Qty = 0 and Est.Wastage % <> 0
 #    Examples: Est.Wastage % = 0 and Drawing Qty <> 0
 #    Examples: Drawing Qty and Est.Wastage = 0
 #    Examples: Drawing Qty and Est.Wastage <> 0
	Examples:
	  | PROJECT |
	  | 001     |
	  | 002     |
	  | 003     |
	  | 004     |
 
 
 #####Budget Cost of an Inventory Item is calculated correctly
 #### Est. Total Cost = Item Est. Qty x Est. Unit Cost x (1 + Markup %) + Labor Est. Qty x Est. Unit Cost x (1 + Markup %)
  @ian @project @deluge @integration
  Scenario Outline: Budget Cost of an Inventory Item is calculated correctly
	Given I want to create a new quotation for "<PROJECT>"
	  | PROJECT | Customer | Quotation Date | Currency | Exchange Rate | Sales Tax |
	  | 001     | ANTEO1   | 15/08/2016     |          |               |           |
	  | 002     | ANTEO1   | 15/08/2016     |          |               |           |
	  | 003     | ANTEO1   | 15/08/2016     |          |               |           |
	  | 004     | ANTEO1   | 15/08/2016     |          |               |           |
	  | 005     | ANTEO1   | 15/08/2016     |          |               |           |
	  | 006     | ANTEO1   | 15/08/2016     |          |               |           |
	
	When I divide the project "<PROJECT>" into phases
	  | PROJECT | Phase No | Phase                                  |
	  | 001     | 1        | Project Engineering / Design / Planing |
	  | 002     | 1        | Project Engineering / Design / Planing |
	  | 003     | 1        | Project Engineering / Design / Planing |
	  | 004     | 1        | Project Engineering / Design / Planing |
	  | 005     | 1        | Project Engineering / Design / Planing |
	  | 006     | 1        | Project Engineering / Design / Planing |
	And I add Cost Item in phases in "<PROJECT>"
	  | PROJECT | Phase No | Type | Drawing Object | Item Code Description | Drawing Qty | Est. Wastage % | Item Budget>Unit Cost | Item Budget>Markup % | Labour Budget>Qty | Labour Budget>Unit Cost | Labour Budget>Markup % |
	  | 001     | 1        | I    | Valve          | SS-VALVE              | 0           |                | 4                     | 6                    | 10                | 7                       | 4                      |
	  | 002     | 1        | I    | Valve          | SS-VALVE              | 10          |                | 0                     | 6                    | 10                | 7                       | 4                      |
	  | 003     | 1        | I    | Valve          | SS-VALVE              | 10          |                | 4                     | 0                    | 10                | 7                       | 4                      |
	  | 004     | 1        | I    | Valve          | SS-VALVE              | 10          |                | 4                     | 6                    | 0                 | 7                       | 4                      |
	  | 005     | 1        | I    | Valve          | SS-VALVE              | 10          |                | 4                     | 6                    | 10                | 0                       | 4                      |
	  | 006     | 1        | I    | Valve          | SS-VALVE              | 10          |                | 4                     | 6                    | 10                | 7                       | 0                      |
	
	Then The Costing Sheet in "<PROJECT>" should be calculated as following
	  | PROJECT | Phase No | Drawing Object No | Item Budget>Qty | Item Budget>Unit Cost | Labour Budget>Qty | Budget Cost |
	  | 001     | 1        | 1                 |                 |                       |                   | 72.8        |
	  | 002     | 1        | 1                 |                 |                       |                   | 72.8        |
	  | 003     | 1        | 1                 |                 |                       |                   | 112.8       |
	  | 004     | 1        | 1                 |                 |                       |                   | 42.4        |
	  | 005     | 1        | 1                 |                 |                       |                   | 42.4        |
	  | 006     | 1        | 1                 |                 |                       |                   | 112.4       |
	When I abort the quotation
 
 #    Examples: Drawing Qty = 0
 #    Examples: Item Unit Cost = 0
 #    Examples: Item Markup = 0
 #    Examples: Labour est = 0
 #    Examples: Labour Unit Cost = 0
 #    Examples: Labour Markup = 0
 #    Examples: Drawing Qty, Item Unit Cost, Item Markup, Labour est, Labour Unit Cost, Labour Markup = 0
 #    Examples: Drawing Qty, Item Unit Cost, Item Markup, Labour est, Labour Unit Cost, Labour Markup <> 0
	Examples:
	  | PROJECT |
	  | 001     |
	  | 002     |
	  | 003     |
	  | 004     |
	  | 005     |
	  | 006     |
 
 
 #####Scenario Outline:  Budget Cost of an Service Item is calculated correctly
 #### Est. Total Cost = Item Est. Qty x Est. Unit Cost x (1 + Markup %) + Labor Est. Qty x Est. Unit Cost x (1 + Markup %)
  @ian @project @deluge @integration
  Scenario Outline:  Budget Cost of an Service Item is calculated correctly
	Given I want to create a new quotation for "<PROJECT>"
	  | PROJECT | Customer | Quotation Date | Currency | Exchange Rate | Sales Tax |
	  | 001     | ANTEO1   | 15/08/2016     |          |               |           |
	  | 002     | ANTEO1   | 15/08/2016     |          |               |           |
	  | 003     | ANTEO1   | 15/08/2016     |          |               |           |
	  | 004     | ANTEO1   | 15/08/2016     |          |               |           |
	  | 005     | ANTEO1   | 15/08/2016     |          |               |           |
	  | 006     | ANTEO1   | 15/08/2016     |          |               |           |
	  | 007     | ANTEO1   | 15/08/2016     |          |               |           |
	  | 008     | ANTEO1   | 15/08/2016     |          |               |           |
	
	When I divide the project "<PROJECT>" into phases
	#Key Deluge Phases
	  | PROJECT | Phase No | Phase                                  |
	  | 001     | 1        | Project Engineering / Design / Planing |
	  | 002     | 1        | Project Engineering / Design / Planing |
	  | 003     | 1        | Project Engineering / Design / Planing |
	  | 004     | 1        | Project Engineering / Design / Planing |
	  | 005     | 1        | Project Engineering / Design / Planing |
	  | 006     | 1        | Project Engineering / Design / Planing |
	  | 007     | 1        | Project Engineering / Design / Planing |
	  | 008     | 1        | Project Engineering / Design / Planing |
	
	And I add Cost Item in phases in "<PROJECT>"
	  | PROJECT | Phase No | Type | Drawing Object | Item Code Description | Item Budget>Qty | Item Budget>Unit Cost | Item Budget>Markup % | Labour Budget>Qty | Labour Budget>Unit Cost | Labour Budget>Markup % |
	  | 001     | 1        | S    |                | AN SERVICE            | 0               | 0                     | 0                    | 0                 | 0                       | 0                      |
	  | 002     | 1        | S    |                | AN SERVICE            | 0               | 5                     | 20                   | 15                | 2                       | 15                     |
	  | 003     | 1        | S    |                | AN SERVICE            | 4               | 0                     | 20                   | 15                | 2                       | 15                     |
	  | 004     | 1        | S    |                | AN SERVICE            | 4               | 5                     | 0                    | 15                | 2                       | 15                     |
	  | 005     | 1        | S    |                | AN SERVICE            | 4               | 5                     | 20                   | 0                 | 2                       | 15                     |
	  | 006     | 1        | S    |                | AN SERVICE            | 4               | 5                     | 20                   | 15                | 0                       | 15                     |
	  | 007     | 1        | S    |                | AN SERVICE            | 4               | 5                     | 20                   | 15                | 2                       | 0                      |
	  | 008     | 1        | S    |                | AN SERVICE            | 4               | 5                     | 20                   | 15                | 2                       | 15                     |
	
	Then The Costing Sheet in "<PROJECT>" should be calculated as following
	  | PROJECT | Phase No | Drawing Object No | Budget Cost |
	  | 001     | 1        | 1                 | 0           |
	  | 002     | 1        | 1                 | 34.5        |
	  | 003     | 1        | 1                 | 34.5        |
	  | 004     | 1        | 1                 | 54.5        |
	  | 005     | 1        | 1                 | 24          |
	  | 006     | 1        | 1                 | 24          |
	  | 007     | 1        | 1                 | 54          |
	  | 008     | 1        | 1                 | 58.5        |
	
	When I abort the quotation
 
 #    Examples: Item Qty = 0
 #    Examples: Item Unit Cost = 0
 #    Examples: Item Markup = 0
 #    Examples: Labour est = 0
 #    Examples: Labour Unit Cost = 0
 #    Examples: Labour Markup = 0
 #    Examples: Drawing Qty, Item Unit Cost, Item Markup, Labour est, Labour Unit Cost, Labour Markup = 0
 #    Examples: Drawing Qty, Item Unit Cost, Item Markup, Labour est, Labour Unit Cost, Labour Markup <> 0
	Examples:
	  | PROJECT |
	  | 001     |
	  | 002     |
	  | 003     |
	  | 004     |
	  | 005     |
	  | 006     |
	  | 007     |
	  | 008     |
  
  @ian @project @deluge @integration
  Scenario Outline: Phase details are correct
	Given I want to create a new quotation for "<PROJECT>"
	  | PROJECT | Customer | Quotation Date | Currency | Exchange Rate | Sales Tax |
	  | 001     | ANTEO1   | 15/08/2016     |          |               |           |
	  | 002     | ANTEO1   | 15/08/2016     |          |               |           |
	When I divide the project "<PROJECT>" into phases
	  | PROJECT | Phase No      | Phase                                  |
	  | 001     | 1             | Project Engineering / Design / Planing |
	  | 002     | 1             | Project Engineering / Design / Planing |
	  | 002     | 1.1           | Sea fastening of loose items           |
	  | 002     | 1.1.1         | Engineering                            |
	  | 002     | 1.1.1.1       | Stowage plan - central laydown area    |
	  | 002     | 1.1.1.1.1     | Phase 5th                              |
	  | 002     | 1.1.1.1.1.1   | Phase 6th                              |
	  | 002     | 1.1.1.1.1.1.1 | Phase 7th                              |
	  | 002     | 1.1.1.2       | Stowage plan - turret area             |
	  | 002     | 1.1.1.2.1     | Phase 1.1.1.2.1                        |
	  | 002     | 1.1.1.2.2     | Phase 1.1.1.2.2                        |
	And I estimate quantity, price and discount for each phase in "<PROJECT>"
	  | PROJECT | Phase No      | Qty | Unit Price | Disc Percent | Disc Amount | Budget Cost | Profit Margin |
	  | 001     | 1             |     |            |              |             |             |               |
	  | 002     | 1             |     |            |              |             |             |               |
	  | 002     | 1.1           |     |            |              |             |             |               |
	  | 002     | 1.1.1         |     |            |              |             |             |               |
	  | 002     | 1.1.1.1       |     |            |              |             |             |               |
	  | 002     | 1.1.1.1.1     |     |            |              |             |             |               |
	  | 002     | 1.1.1.1.1.1   |     |            |              |             |             |               |
	  | 002     | 1.1.1.1.1.1.1 | 7   | 5          | 10           |             | 20          |               |
	  | 002     | 1.1.1.2       |     |            |              |             |             |               |
	  | 002     | 1.1.1.2.1     |     |            |              |             | 40          | 85            |
	  | 002     | 1.1.1.2.2     | 15  | 13         |              |             |             |               |
	And I add Cost Item in phases in "<PROJECT>"
	  | PROJECT | Phase No | Type | Drawing Object          | Item Code Description | Drawing Qty | Est. Wastage % | Item Budget>Qty | Item Budget>Unit Cost | Item Budget>Markup % | Labour Budget>Qty | Labour Budget>Unit Cost | Labour Budget>Markup % |
	  | 001     | 1        | I    | AUTOMATIC SLIDING DOORS |                       | 10          | 0              |                 | 45                    | 5                    | 30                | 45                      | 8                      |
	  | 001     | 1        | I    | FIRE ROLLER SHUTTER     |                       | 15          | 20             |                 | 70                    | 0                    | 12                | 50                      | 10                     |
	  | 001     | 1        | S    |                         | AN SERVICE            |             |                | 30              | 20                    | 10                   | 40                | 60                      | 20                     |
	Then The Costing Sheet in "<PROJECT>" should be calculated as following
	  | PROJECT | Phase No | Drawing Object No | Budget Cost |
	  | 001     | 1        | 1                 | 1930.5      |
	  | 001     | 1        | 2                 | 1920        |
	  | 001     | 1        | 3                 | 3540        |
	And "<PROJECT>" phase budget profit in Costing Sheet Tree should be as following
	  | PROJECT | Phase No | Budget Cost in Costing Sheet Tree |
	  | 001     | 1        | 7390.5                            |
	And "<PROJECT>" phase detail should be as following
	  | PROJECT | Phase No      | Qty | Unit Price | Disc Percent | Disc Amount | Phase Value | Budget Cost | Budget Profit | Profit Margin |
	  | 001     | 1             |     |            |              |             |             | 7390.5      | -7390.5       | -100          |
	  | 002     | 1             | 0   | 0          |              |             | 493.17      | 60          | 433.17        | 87.83         |
	  | 002     | 1.1           | 0   | 0          |              |             | 493.17      | 60          | 433.17        | 87.83         |
	  | 002     | 1.1.1         | 0   | 0          |              |             | 493.17      | 60          | 433.17        | 87.83         |
	  | 002     | 1.1.1.1       | 0   | 0          |              |             | 31.50       | 20          | 11.50         | 36.51         |
	  | 002     | 1.1.1.1.1     | 0   | 0          |              |             | 31.50       | 20          | 11.50         | 36.51         |
	  | 002     | 1.1.1.1.1.1   | 0   | 0          |              |             | 31.50       | 20          | 11.50         | 36.51         |
	  | 002     | 1.1.1.1.1.1.1 | 7   | 5          | 10           | 3.5         | 31.50       | 20          | 11.50         | 36.51         |
	  | 002     | 1.1.1.2       |     |            |              |             | 461.67      | 40          | 421.67        | 91.34         |
	  | 002     | 1.1.1.2.1     |     |            |              |             | 266.67      | 40          | 226.67        | 85            |
	  | 002     | 1.1.1.2.2     | 15  | 13         |              |             | 195.00      | 0           | 195.00        | 100.00        |
	
	When I abort the quotation
 
 #    Examples: Phase has correct budget cost from costing sheet
 #    Examples: Phase has 6 level sub-phases, parent phase correct
	
	Examples:
	  | PROJECT |
	  | 001     |
	  | 002     |
  
  @ian @project @deluge @integration
  Scenario Outline: Phase details are correct when costing sheet is changed
	Given I want to create a new quotation for "<PROJECT>"
	  | PROJECT | Customer | Quotation Date | Currency | Exchange Rate | Sales Tax |
	  | 001     | ANTEO1   | 15/08/2016     |          |               |           |
	When I divide the project "<PROJECT>" into phases
	  | PROJECT | Phase No | Phase                                  |
	  | 001     | 1        | Project Engineering / Design / Planing |
	And I estimate quantity, price and discount for each phase in "<PROJECT>"
	  | PROJECT | Phase No | Qty | Unit Price | Disc Percent | Disc Amount | Budget Cost | Profit Margin |
	  | 001     | 1        |     |            |              |             |             |               |
	And I add Cost Item in phases in "<PROJECT>"
	  | PROJECT | Phase No | Type | Drawing Object          | Item Code Description | Drawing Qty | Est. Wastage % | Item Budget>Qty | Item Budget>Unit Cost | Item Budget>Markup % | Labour Budget>Qty | Labour Budget>Unit Cost | Labour Budget>Markup % |
	  | 001     | 1        | I    | AUTOMATIC SLIDING DOORS |                       | 10          | 0              |                 | 45                    | 5                    | 30                | 45                      | 8                      |
	  | 001     | 1        | I    | FIRE ROLLER SHUTTER     |                       | 15          | 20             |                 | 70                    | 0                    | 12                | 50                      | 10                     |
	  | 001     | 1        | S    |                         | AN SERVICE            |             |                | 30              | 20                    | 10                   | 40                | 60                      | 20                     |
	When I change Cost Item in phases in "<PROJECT>"
	  | Action | PROJECT | Phase No | Drawing Object No | Type | Drawing Object | Item Code Description | Drawing Qty | Est. Wastage % | Item Budget>Qty | Item Budget>Unit Cost | Item Budget>Markup % | Labour Budget>Qty | Labour Budget>Unit Cost | Labour Budget>Markup % |
	  | Edit   | 001     | 1        | 1                 |      |                |                       | 13          |                |                 |                       |                      | 30                |                         |                        |
	  | Delete | 001     | 1        | 2                 |      |                |                       |             |                |                 |                       |                      |                   |                         |                        |
	  | Add    | 001     | 1        |                   | I    | FITTING        |                       | 15          |                |                 | 21                    |                      |                   |                         |                        |
	Then The Costing Sheet in "<PROJECT>" should be calculated as following
	  | PROJECT | Phase No | Drawing Object No | Budget Cost |
	  | 001     | 1        | 1                 | 2072.25     |
	  | 001     | 1        | 2                 | 3540        |
	  | 001     | 1        | 3                 | 315         |
	And "<PROJECT>" phase budget profit in Costing Sheet Tree should be as following
	  | PROJECT | Phase No | Budget Cost in Costing Sheet Tree |
	  | 001     | 1        | 5927.25                           |
	And "<PROJECT>" phase detail should be as following
	  | PROJECT | Phase No | Qty | Unit Price | Disc Percent | Disc Amount | Phase Value | Budget Cost | Budget Profit | Profit Margin |
	  | 001     | 1        |     |            |              |             |             | 5927.25     | -5927.25      | -100          |
	
	When I abort the quotation
 
 #    Examples: Add new Cost Item
 #    Examples: Edit some detail
	
	Examples:
	  | PROJECT |
	  | 001     |
  
  @ian @project @deluge @integration
  Scenario Outline: Phase details are correct when phase details are changed
	Given I want to create a new quotation for "<PROJECT>"
	  | PROJECT | Customer | Quotation Date | Currency | Exchange Rate | Sales Tax |
	  | 001     | ANTEO1   | 15/08/2016     |          |               |           |
	When I divide the project "<PROJECT>" into phases
	  | PROJECT | Phase No | Phase                                  |
	  | 001     | 1        | Project Engineering / Design / Planing |
	  | 001     | 1.1      | Sea fastening of loose items           |
	  | 001     | 1.1.1    | Engineering                            |
	  | 001     | 1.1.1.1  | Stowage plan - central laydown area    |
	  | 001     | 1.1.1.2  | Stowage plan - turret area             |
	  | 001     | 1.1.2    | Engineering                            |
	
	And I estimate quantity, price and discount for each phase in "<PROJECT>"
	  | PROJECT | Phase No | Qty | Unit Price | Disc Percent | Disc Amount | Budget Cost | Profit Margin |
	  | 001     | 1        |     |            |              |             |             |               |
	  | 001     | 1.1      |     |            |              |             |             |               |
	  | 001     | 1.1.1    |     |            |              |             |             |               |
	  | 001     | 1.1.1.1  | 5   | 20         |              |             | 41          |               |
	  | 001     | 1.1.1.2  |     |            |              |             | 70          | 20            |
	  | 001     | 1.1.2    | 10  | 13         |              |             |             |               |
	When I change Phase Details in "<PROJECT>"
	  | Action | PROJECT | Phase No | Phase | Qty | Unit Price | Disc Percent | Disc Amount | Budget Cost | Profit Margin |
	  | Edit   | 001     | 1.1.1.2  |       | 1   | 100        |              |             |             |               |
	  | Edit   | 001     | 1.1.1.1  |       |     |            | 20           |             |             |               |
	  | Delete | 001     | 1.1.2    |       |     |            |              |             |             |               |
	  | Add    | 001     | 1.1.2    |       | 1   | 90         |              |             | 200         |               |
	Then "<PROJECT>" phase detail should be as following
	  | PROJECT | Phase No | Qty | Unit Price | Disc Percent | Disc Amount | Phase Value | Budget Cost | Budget Profit | Profit Margin |
	  | 001     | 1        |     |            |              |             | 270         | 311         | -41           | -15.19        |
	  | 001     | 1.1      |     |            |              |             | 270         | 311         | -41           | -15.19        |
	  | 001     | 1.1.1    |     |            |              |             | 180         | 111         | 69            | 38.33         |
	  | 001     | 1.1.1.1  | 5   | 20         | 20           | 20          | 80          | 41          | 39            | 48.75         |
	  | 001     | 1.1.1.2  | 1   | 100        |              |             | 100         | 70          | 30            | 30            |
	  | 001     | 1.1.2    | 1   | 90         |              |             | 90          | 200         | -110          | -122.22       |
	
	When I abort the quotation
 
 #    Examples: Delete sub-phase
 #    Examples: Add new sub-phase
	
	Examples:
	  | PROJECT |
	  | 001     |
  
  # Project has 2 main phases, phase 1 has 3 level sub-phase, last phase has Item Cost and discount 10$, second main phase discount 20$
  @ian @project @deluge @integration
  Scenario Outline: Quotation Summary is calculate correctly
	Given I want to create a new quotation for "<PROJECT>"
	  | PROJECT | Customer | Quotation Date | Currency | Exchange Rate | Sales Tax |
	  | 001     | ANTEO1   | 15/08/2016     |          |               | GST0      |
	  | 002     | ANTEO1   | 15/08/2016     | USD      | 1.32          | GST0      |
	  | 003     | ANTEO1   | 15/08/2016     |          |               | GST7      |
	  | 004     | ANTEO1   | 15/08/2016     | USD      | 1.5           | GST7      |
	When I divide the project into phases
	  | Phase No | Phase                                  | Workhead Group |
	  | 1        | Project Engineering / Design / Planing | Workhead1      |
	  | 1.1      | Sea fastening of loose items           |                |
	  | 1.1.1    | Engineering                            |                |
	  | 1.1.1.1  | Stowage plan - central laydown area    |                |
	  | 1.1.1.2  | Site inspection                        |                |
	  | 1.1.2    | Site Attendance                        |                |
	  | 1.2      | Phase 7th                              |                |
	  | 2        | Stowage plan - turret area             |                |
	  | 2.1      | Basements                              | Workhead1      |
	  | 2.1.1    | Fire protection systems                |                |
	  | 2.1.2    | Hose Reel System                       |                |
	  | 2.2      | Podium                                 | Workhead2      |
	  | 2.2.1    | Fire protection systems                |                |
	  | 2.2.2    | Design Fire protection systems         |                |
	  | 2.2.3    | Design Fire protection systems         |                |
	And I add Cost Item in phases
	  | Phase No | Type | Drawing Object          | Item Code Description | Drawing Qty | Est. Wastage % | Item Budget>Qty | Item Budget>Unit Cost | Item Budget>Markup % | Labour Budget>Qty | Labour Budget>Unit Cost | Labour Budget>Markup % |
	  | 1.1.1.1  | I    | AUTOMATIC SLIDING DOORS |                       | 15          |                |                 | 87                    |                      | 20                | 200                     | 20                     |
	  | 1.1.1.1  | I    | VALVE                   |                       | 20          | 5              |                 | 90                    | 8                    |                   | 210                     | 10                     |
	  | 1.1.1.2  | S    |                         | AN SERVICE            |             |                | 4               | 78                    | 7                    |                   |                         |                        |
	  | 1.1.1.2  | I    | FITTING                 |                       | 40          | 3              |                 | 87                    |                      | 9                 | 220                     | 14                     |
	  | 1.1.2    | I    | SECURITY DOOR           |                       | 24          |                |                 | 100                   | 10                   | 7                 | 214                     |                        |
	  | 1.2      | S    |                         | AN SERVICE            |             |                | 3               | 102                   |                      | 20                | 275                     |                        |
	  | 2.1.1    | I    | VALVE                   |                       | 13          | 2              |                 | 113                   |                      | 8                 | 245                     |                        |
	  | 2.1.1    | I    | FIRE ROLLER SHUTTER     |                       | 9           | 10             |                 | 145                   |                      | 14                | 206                     |                        |
	  | 2.1.2    | I    | PIPE                    |                       | 20          |                |                 | 154                   | 20                   |                   |                         |                        |
	  | 2.2.1    | I    | PIPE                    |                       | 10          |                |                 | 210                   |                      | 3                 | 190                     |                        |
	And I estimate quantity, price and discount for each phase
	  | Phase No | Qty | Unit Price | Disc Percent | Disc Amount | Budget Cost | Profit Margin |
	  | 1        |     |            |              |             |             |               |
	  | 1.1      |     |            |              |             |             |               |
	  | 1.1.1    |     |            |              |             |             |               |
	  | 1.1.1.1  |     |            | 10           |             |             | 30            |
	  | 1.1.1.2  | 1   | 8700       | 10           |             |             |               |
	  | 1.1.2    | 2   | 4700       |              | 700         |             |               |
	  | 1.2      | 4   | 2000       |              |             |             |               |
	  | 2        |     |            |              |             |             |               |
	  | 2.1      |     |            |              |             |             |               |
	  | 2.1.1    | 15  | 689        |              |             |             |               |
	  | 2.1.2    | 12  | 874        |              |             |             |               |
	  | 2.2      |     |            |              |             |             |               |
	  | 2.2.1    | 1   | 4507       |              |             |             |               |
	  | 2.2.2    |     |            |              |             | 200         | 87            |
	  | 2.2.3    | 1   | 987        |              |             | 487         |               |
	
	Then Quotation Summary in "<PROJECT>" is as following
	  | PROJECT | Title                   | Nature    | Home      |
	  | 001     | Exchange Rate           |           | 1         |
	  | 001     | Project Sum             | 143124.19 | 143124.19 |
	  | 001     | Project Budget Cost     | 94536.52  | 94536.52  |
	  | 001     | Project Budget Profit   | 48587.67  | 48587.67  |
	  | 001     | Sales Tax               | 0         | 0.00      |
	  | 001     | Project Value incl. Tax | 143124.19 | 143124.19 |
	  | 002     | Exchange Rate           |           | 1.32      |
	  | 002     | Project Sum             | 143124.19 | 188923.93 |
	  | 002     | Project Budget Cost     | 94536.52  | 124788.21 |
	  | 002     | Project Budget Profit   | 48587.67  | 64135.72  |
	  | 002     | Sales Tax               | 0.00      | 0.00      |
	  | 002     | Project Value incl. Tax | 143124.19 | 188923.93 |
	  | 003     | Exchange Rate           |           | 1         |
	  | 003     | Project Sum             | 143124.19 | 143124.19 |
	  | 003     | Project Budget Cost     | 94536.52  | 94536.52  |
	  | 003     | Project Budget Profit   | 48587.67  | 48587.67  |
	  | 003     | Sales Tax               | 10018.69  | 10018.69  |
	  | 003     | Project Value incl. Tax | 153142.88 | 48587.67  |
	  | 004     | Exchange Rate           |           | 1.5       |
	  | 004     | Project Sum             | 143124.19 | 214686.29 |
	  | 004     | Project Budget Cost     | 94536.52  | 141804.78 |
	  | 004     | Project Budget Profit   | 48587.67  | 72881.51  |
	  | 004     | Sales Tax               | 10018.69  | 15028.04  |
	  | 004     | Project Value incl. Tax | 153142.88 | 229714.33 |
	
	When I abort the quotation
	
	#    Examples: Currency exchange = 1
	#    Examples: Currency exchange <> 1
   #    Examples: Sales Tax = 0%
   #    Examples: Sales Tax <> 0%
	
	Examples:
	  | PROJECT |
	  | 001     |
	  | 002     |
	  | 003     |
	  | 004     |
  
  @ian @project @deluge @integration
  Scenario Outline: Brand Comparison are show correct Drawing Object, Qty, Brand and Supplier and Cost Price
	Given I want to create a new quotation for "<PROJECT>"
	  | PROJECT | Customer | Quotation Date | Currency | Exchange Rate | Sales Tax |
	  | 001     | ANTEO1   | 15/08/2016     | USD      |               |           |
	  | 002     | ANTEO1   | 15/08/2016     | USD      |               |           |
	  | 003     | ANTEO1   | 15/08/2016     | USD      |               |           |
	When I divide the project "<PROJECT>" into phases
	  | PROJECT | Phase No | Phase                                  | Workhead Group |
	  | 001     | 1        | Project Engineering / Design / Planing | Workhead1      |
	  | 001     | 1.1      | Sea fastening of loose items           |                |
	  | 001     | 1.1.1    | Engineering                            |                |
	  | 001     | 1.1.1.1  | Stowage plan - central laydown area    |                |
	  | 001     | 1.1.1.2  | Site inspection                        |                |
	  | 001     | 1.1.2    | Site Attendance                        |                |
	  | 001     | 1.2      | Phase 7th                              |                |
	  | 001     | 2        | Stowage plan - turret area             |                |
	  | 001     | 2.1      | Basements                              | Workhead1      |
	  | 001     | 2.1.1    | Fire protection systems                |                |
	  | 001     | 2.1.2    | Hose Reel System                       |                |
	  | 001     | 2.2      | Podium                                 | Workhead2      |
	  | 001     | 2.2.1    | Fire protection systems                |                |
	  | 001     | 2.2.2    | Design Fire protection systems         |                |
	  | 001     | 2.2.3    | Design Fire protection systems         |                |
	  | 002     | 1        | Project Engineering / Design / Planing | Workhead1      |
	  | 002     | 1.1      | Sea fastening of loose items           |                |
	  | 002     | 1.1.1    | Engineering                            |                |
	  | 002     | 1.1.1.1  | Stowage plan - central laydown area    |                |
	  | 002     | 1.1.1.2  | Site inspection                        |                |
	  | 002     | 1.1.2    | Site Attendance                        |                |
	  | 002     | 1.2      | Phase 7th                              |                |
	  | 002     | 2        | Stowage plan - turret area             |                |
	  | 002     | 2.1      | Basements                              |                |
	  | 002     | 2.1.1    | Fire protection systems                |                |
	  | 002     | 2.1.2    | Hose Reel System                       |                |
	  | 002     | 2.2      | Podium                                 | Workhead2      |
	  | 002     | 2.2.1    | Fire protection systems                |                |
	  | 002     | 2.2.2    | Design Fire protection systems         |                |
	  | 002     | 2.2.3    | Design Fire protection systems         |                |
	  | 003     | 1        | Project Engineering / Design / Planing |                |
	  | 003     | 1.1      | Sea fastening of loose items           |                |
	  | 003     | 1.1.1    | Engineering                            |                |
	  | 003     | 1.1.1.1  | Stowage plan - central laydown area    |                |
	  | 003     | 1.1.1.2  | Site inspection                        |                |
	  | 003     | 1.1.2    | Site Attendance                        |                |
	  | 003     | 1.2      | Phase 7th                              |                |
	  | 003     | 2        | Stowage plan - turret area             |                |
	  | 003     | 2.1      | Basements                              |                |
	  | 003     | 2.1.1    | Fire protection systems                |                |
	  | 003     | 2.1.2    | Hose Reel System                       |                |
	  | 003     | 2.2      | Podium                                 |                |
	  | 003     | 2.2.1    | Fire protection systems                |                |
	  | 003     | 2.2.2    | Design Fire protection systems         |                |
	  | 003     | 2.2.3    | Design Fire protection systems         |                |
	And I add Cost Item in phases
	  | Phase No | Type | Drawing Object          | Item Code Description | Drawing Qty | Est. Wastage % | Item Budget>Qty | Item Budget>Unit Cost | Item Budget>Markup % | Labour Budget>Qty | Labour Budget>Unit Cost | Labour Budget>Markup % |
	  | 1.1.1.1  | I    | AUTOMATIC SLIDING DOORS |                       | 15          |                |                 | 87                    |                      | 20                | 200                     | 20                     |
	  | 1.1.1.1  | I    | VALVE                   |                       | 20          | 5              |                 | 90                    | 8                    |                   | 210                     | 10                     |
	  | 1.1.1.2  | S    |                         | AN SERVICE            |             |                | 4               | 78                    | 7                    |                   |                         |                        |
	  | 1.1.1.2  | I    | FITTING                 |                       | 40          | 3              |                 | 87                    |                      | 9                 | 220                     | 14                     |
	  | 1.1.2    | I    | SECURITY DOOR           |                       | 24          |                |                 | 100                   | 10                   | 7                 | 214                     |                        |
	  | 1.2      | S    |                         | AN SERVICE            |             |                | 3               | 102                   |                      | 20                | 275                     |                        |
	  | 2.1.1    | I    | VALVE                   |                       | 13          | 2              |                 | 113                   |                      | 8                 | 245                     |                        |
	  | 2.1.1    | I    | FIRE ROLLER SHUTTER     |                       | 9           | 10             |                 | 145                   |                      | 14                | 206                     |                        |
	  | 2.1.2    | I    | PIPE                    |                       | 20          |                |                 | 154                   | 20                   |                   |                         |                        |
	  | 2.2.1    | I    | PIPE                    |                       | 10          |                |                 | 210                   |                      | 3                 | 190                     |                        |
	And I estimate quantity, price and discount for each phase
	  | Phase No | Qty | Unit Price | Disc Percent | Disc Amount | Budget Cost | Profit Margin |
	  | 1        |     |            |              |             |             |               |
	  | 1.1      |     |            |              |             |             |               |
	  | 1.1.1    |     |            |              |             |             |               |
	  | 1.1.1.1  |     |            | 10           |             |             | 30            |
	  | 1.1.1.2  | 1   | 8700       | 10           |             |             |               |
	  | 1.1.2    | 2   | 4700       |              | 700         |             |               |
	  | 1.2      | 4   | 2000       |              |             |             |               |
	  | 2        |     |            |              |             |             |               |
	  | 2.1      |     |            |              |             |             |               |
	  | 2.1.1    | 15  | 689        |              |             |             |               |
	  | 2.1.2    | 12  | 874        |              |             |             |               |
	  | 2.2      |     |            |              |             |             |               |
	  | 2.2.1    | 1   | 4507       |              |             |             |               |
	  | 2.2.2    |     |            |              |             | 200         | 87            |
	  | 2.2.3    | 1   | 987        |              |             | 487         |               |
	Then Brand Comparison in "<PROJECT>" as
	  | PROJECT | Workhead Groups | Cost Item Group | Drawing Object          | Qty | Brand           | Supplier | Cost Price |
	  | 001     | WORKHEAD1       | FPS             | Automatic Sliding Doors | 15  | Secom           | CoopMart | 320        |
	  | 001     |                 |                 | Automatic Sliding Doors |     | Mircom          | Adayroi  | 330        |
	  | 001     |                 |                 | Automatic Sliding Doors |     | Mircom          | Metro    | 335        |
	  | 001     |                 |                 | Automatic Sliding Doors |     | Teletek         | BigC     | 350        |
	  | 001     |                 |                 | Fire Roller Shutter     | 9   | Mircom          | Adayroi  | 678        |
	  | 001     |                 |                 | Fire Roller Shutter     |     | Teletek         | Metro    | 600        |
	  | 001     |                 |                 | Security Door           | 24  | Mircom          | Adayroi  | 500        |
	  | 001     |                 |                 | Security Door           |     | Mircom          | Lotte    | 512        |
	  | 001     |                 |                 | Total                   |     | Secom           | CoopMart | 0          |
	  | 001     |                 |                 | Total                   |     | Mircom          | Adayroi  | 0          |
	  | 001     |                 |                 | Total                   |     | Mircom          | Metro    | 0          |
	  | 001     |                 |                 | Total                   |     | Mircom          | Lotte    | 0          |
	  | 001     |                 |                 | Total                   |     | Teletek         | BigC     | 0          |
	  | 001     |                 |                 | Total                   |     | Teletek         | Metro    | 0          |
	  | 001     |                 | HRS             | Fitting                 | 40  | Seah Steel      | Metro    | 31         |
	  | 001     |                 |                 | Fitting                 |     | Hoa Phat        | Lotte    | 27         |
	  | 001     |                 |                 | Fitting                 |     | Pomina          | Adayroi  | 40         |
	  | 001     |                 |                 | Fitting                 |     | Pomina          | CoopMart | 41         |
	  | 001     |                 |                 | Pipe                    | 20  | Seah Steel      | Metro    | 11         |
	  | 001     |                 |                 | Pipe                    |     | Seah Steel      | Lotte    | 11         |
	  | 001     |                 |                 | Pipe                    |     | Pomina          | Lotte    | 9          |
	  | 001     |                 |                 | Pipe                    |     | Pomina          | Metro    | 9          |
	  | 001     |                 |                 | Valve                   | 33  | Seah Steel      | Lotte    | 90         |
	  | 001     |                 |                 | Valve                   |     | Seah Steel      | BigC     | 60         |
	  | 001     |                 |                 | Valve                   |     | Vina Coperation | BigC     | 85         |
	  | 001     |                 |                 | Total                   |     | Seah Steel      | Metro    | 0          |
	  | 001     |                 |                 | Total                   |     | Seah Steel      | Lotte    | 0          |
	  | 001     |                 |                 | Total                   |     | Seah Steel      | BigC     | 0          |
	  | 001     |                 |                 | Total                   |     | Hoa Phat        | Lotte    | 0          |
	  | 001     |                 |                 | Total                   |     | Pomina          | Adayroi  | 0          |
	  | 001     |                 |                 | Total                   |     | Pomina          | CoopMart | 0          |
	  | 001     |                 |                 | Total                   |     | Pomina          | Lotte    | 0          |
	  | 001     |                 |                 | Total                   |     | Pomina          | Metro    | 0          |
	  | 001     |                 |                 | Total                   |     | Vina Coperation | BigC     | 0          |
	  | 001     | WORKHEAD2       | HRS             | Pipe                    | 10  | Seah Steel      | Lotte    | 11         |
	  | 001     |                 |                 | Pipe                    |     | Seah Steel      | Metro    | 11         |
	  | 001     |                 |                 | Pipe                    |     | Pomina          | Lotte    | 9          |
	  | 001     |                 |                 | Pipe                    |     | Pomina          | Metro    | 9          |
	  | 001     |                 |                 | Total                   |     | Seah Steel      | Lotte    | 0          |
	  | 001     |                 |                 | Total                   |     | Seah Steel      | Metro    | 0          |
	  | 001     |                 |                 | Total                   |     | Pomina          | Lotte    | 0          |
	  | 001     |                 |                 | Total                   |     | Pomina          | Metro    | 0          |
	  | 002     | NONE            | FPS             | Fire Roller Shutter     | 9   | Mircom          | Adayroi  | 678        |
	  | 002     |                 |                 | Fire Roller Shutter     |     | Teletek         | Metro    | 600        |
	  | 002     |                 |                 | Total                   |     | Mircom          | Adayroi  | 0          |
	  | 002     |                 |                 | Total                   |     | Teletek         | Metro    | 0          |
	  | 002     |                 | HRS             | Pipe                    | 20  | Seah Steel      | Metro    | 11         |
	  | 002     |                 |                 | Pipe                    |     | Seah Steel      | Lotte    | 11         |
	  | 002     |                 |                 | Pipe                    |     | Pomina          | Lotte    | 9          |
	  | 002     |                 |                 | Pipe                    |     | Pomina          | Metro    | 9          |
	  | 002     |                 |                 | Valve                   | 33  | Seah Steel      | Lotte    | 90         |
	  | 002     |                 |                 | Valve                   |     | Seah Steel      | BigC     | 60         |
	  | 002     |                 |                 | Valve                   |     | Vina Coperation | BigC     | 85         |
	  | 002     |                 |                 | Total                   |     | Seah Steel      | Metro    | 0          |
	  | 002     |                 |                 | Total                   |     | Seah Steel      | Lotte    | 0          |
	  | 002     |                 |                 | Total                   |     | Seah Steel      | BigC     | 0          |
	  | 002     |                 |                 | Total                   |     | Pomina          | Lotte    | 0          |
	  | 002     |                 |                 | Total                   |     | Pomina          | Metro    | 0          |
	  | 002     |                 |                 | Total                   |     | Vina Coperation | BigC     | 0          |
	  | 002     | WORKHEAD1       | FPS             | Automatic Sliding Doors | 15  | Secom           | CoopMart | 320        |
	  | 002     |                 |                 | Automatic Sliding Doors |     | Mircom          | Adayroi  | 330        |
	  | 002     |                 |                 | Automatic Sliding Doors |     | Mircom          | Metro    | 335        |
	  | 002     |                 |                 | Automatic Sliding Doors |     | Teletek         | BigC     | 350        |
	  | 002     |                 |                 | Security Door           | 24  | Mircom          | Adayroi  | 500        |
	  | 002     |                 |                 | Security Door           |     | Mircom          | Lotte    | 512        |
	  | 002     |                 |                 | Total                   |     | Secom           | CoopMart | 0          |
	  | 002     |                 |                 | Total                   |     | Mircom          | Adayroi  | 0          |
	  | 002     |                 |                 | Total                   |     | Mircom          | Metro    | 0          |
	  | 002     |                 |                 | Total                   |     | Mircom          | Lotte    | 0          |
	  | 002     |                 |                 | Total                   |     | Teletek         | BigC     | 0          |
	  | 002     |                 | HRS             | Fitting                 | 40  | Seah Steel      | Metro    | 31         |
	  | 002     |                 |                 | Fitting                 |     | Hoa Phat        | Lotte    | 27         |
	  | 002     |                 |                 | Fitting                 |     | Pomina          | Adayroi  | 40         |
	  | 002     |                 |                 | Fitting                 |     | Pomina          | CoopMart | 41         |
	  | 002     |                 |                 | Valve                   | 20  | Seah Steel      | Lotte    | 90         |
	  | 002     |                 |                 | Valve                   |     | Seah Steel      | BigC     | 60         |
	  | 002     |                 |                 | Valve                   |     | Vina Coperation | BigC     | 85         |
	  | 002     |                 |                 | Total                   |     | Seah Steel      | Metro    | 0          |
	  | 002     |                 |                 | Total                   |     | Seah Steel      | Lotte    | 0          |
	  | 002     |                 |                 | Total                   |     | Seah Steel      | BigC     | 0          |
	  | 002     |                 |                 | Total                   |     | Hoa Phat        | Lotte    | 0          |
	  | 002     |                 |                 | Total                   |     | Pomina          | Adayroi  | 0          |
	  | 002     |                 |                 | Total                   |     | Pomina          | CoopMart | 0          |
	  | 002     |                 |                 | Total                   |     | Pomina          | Metro    | 0          |
	  | 002     |                 |                 | Total                   |     | Vina Coperation | BigC     | 0          |
	  | 002     | WORKHEAD2       | HRS             | Pipe                    | 10  | Seah Steel      | Lotte    | 11         |
	  | 002     |                 |                 | Pipe                    |     | Seah Steel      | Metro    | 11         |
	  | 002     |                 |                 | Pipe                    |     | Pomina          | Lotte    | 9          |
	  | 002     |                 |                 | Pipe                    |     | Pomina          | Metro    | 9          |
	  | 002     |                 |                 | Total                   |     | Seah Steel      | Lotte    | 0          |
	  | 002     |                 |                 | Total                   |     | Seah Steel      | Metro    | 0          |
	  | 002     |                 |                 | Total                   |     | Pomina          | Lotte    | 0          |
	  | 002     |                 |                 | Total                   |     | Pomina          | Metro    | 0          |
	  | 003     | NONE            | FPS             | Automatic Sliding Doors | 15  | Secom           | CoopMart | 320        |
	  | 003     |                 |                 | Automatic Sliding Doors |     | Mircom          | Adayroi  | 330        |
	  | 003     |                 |                 | Automatic Sliding Doors |     | Mircom          | Metro    | 335        |
	  | 003     |                 |                 | Automatic Sliding Doors |     | Teletek         | BigC     | 350        |
	  | 003     |                 |                 | Fire Roller Shutter     | 9   | Mircom          | Adayroi  | 678        |
	  | 003     |                 |                 | Fire Roller Shutter     |     | Teletek         | Metro    | 600        |
	  | 003     |                 |                 | Security Door           | 24  | Mircom          | Adayroi  | 500        |
	  | 003     |                 |                 | Security Door           |     | Mircom          | Lotte    | 512        |
	  | 003     |                 |                 | Total                   |     | Secom           | CoopMart | 0          |
	  | 003     |                 |                 | Total                   |     | Mircom          | Adayroi  | 0          |
	  | 003     |                 |                 | Total                   |     | Mircom          | Metro    | 0          |
	  | 003     |                 |                 | Total                   |     | Mircom          | Lotte    | 0          |
	  | 003     |                 |                 | Total                   |     | Teletek         | BigC     | 0          |
	  | 003     |                 |                 | Total                   |     | Teletek         | Metro    | 0          |
	  | 003     |                 | HRS             | Fitting                 | 40  | Seah Steel      | Metro    | 31         |
	  | 003     |                 |                 | Fitting                 |     | Hoa Phat        | Lotte    | 27         |
	  | 003     |                 |                 | Fitting                 |     | Pomina          | Adayroi  | 40         |
	  | 003     |                 |                 | Fitting                 |     | Pomina          | CoopMart | 41         |
	  | 003     |                 |                 | Pipe                    | 30  | Seah Steel      | Metro    | 11         |
	  | 003     |                 |                 | Pipe                    |     | Seah Steel      | Lotte    | 11         |
	  | 003     |                 |                 | Pipe                    |     | Pomina          | Lotte    | 9          |
	  | 003     |                 |                 | Pipe                    |     | Pomina          | Metro    | 9          |
	  | 003     |                 |                 | Valve                   | 33  | Seah Steel      | Lotte    | 90         |
	  | 003     |                 |                 | Valve                   |     | Seah Steel      | BigC     | 60         |
	  | 003     |                 |                 | Valve                   |     | Vina Coperation | BigC     | 85         |
	  | 003     |                 |                 | Total                   |     | Seah Steel      | Metro    | 0          |
	  | 003     |                 |                 | Total                   |     | Seah Steel      | Lotte    | 0          |
	  | 003     |                 |                 | Total                   |     | Seah Steel      | BigC     | 0          |
	  | 003     |                 |                 | Total                   |     | Hoa Phat        | Lotte    | 0          |
	  | 003     |                 |                 | Total                   |     | Pomina          | Adayroi  | 0          |
	  | 003     |                 |                 | Total                   |     | Pomina          | CoopMart | 0          |
	  | 003     |                 |                 | Total                   |     | Pomina          | Lotte    | 0          |
	  | 003     |                 |                 | Total                   |     | Pomina          | Metro    | 0          |
	  | 003     |                 |                 | Total                   |     | Vina Coperation | BigC     | 0          |
	
	When I abort the quotation
	
	Examples:
	  | PROJECT |
	  | 001     |
	  | 002     |
	  | 003     |
  
  
  @ian @project @deluge @integration
  Scenario Outline: After select suppliers, the details will be updated
	Given I want to create a new quotation for "<PROJECT>"
	  | PROJECT | Customer | Quotation Date | Currency | Exchange Rate | Sales Tax |
	  | 001     | ANTEO1   | 15/08/2016     | USD      |               |           |
	When I divide the project "<PROJECT>" into phases
	  | PROJECT | Phase No | Phase                                  | Workhead Group |
	  | 001     | 1        | Project Engineering / Design / Planing | Workhead1      |
	  | 001     | 1.1      | Sea fastening of loose items           |                |
	  | 001     | 1.1.1    | Engineering                            |                |
	  | 001     | 1.1.1.1  | Stowage plan - central laydown area    |                |
	  | 001     | 1.1.1.2  | Site inspection                        |                |
	  | 001     | 1.1.2    | Site Attendance                        |                |
	  | 001     | 1.2      | Phase 7th                              |                |
	  | 001     | 2        | Stowage plan - turret area             |                |
	  | 001     | 2.1      | Basements                              | Workhead1      |
	  | 001     | 2.1.1    | Fire protection systems                |                |
	  | 001     | 2.1.2    | Hose Reel System                       |                |
	  | 001     | 2.2      | Podium                                 | Workhead2      |
	  | 001     | 2.2.1    | Fire protection systems                |                |
	  | 001     | 2.2.2    | Design Fire protection systems         |                |
	  | 001     | 2.2.3    | Design Fire protection systems         |                |
	And I add Cost Item in phases
	  | Phase No | Type | Drawing Object          | Item Code Description | Drawing Qty | Est. Wastage % | Item Budget>Qty | Item Budget>Unit Cost | Item Budget>Markup % | Labour Budget>Qty | Labour Budget>Unit Cost | Labour Budget>Markup % |
	  | 1.1.1.1  | I    | AUTOMATIC SLIDING DOORS |                       | 15          |                |                 | 87                    |                      | 20                | 200                     | 20                     |
	  | 1.1.1.1  | I    | VALVE                   |                       | 20          | 5              |                 | 90                    | 8                    |                   | 210                     | 10                     |
	  | 1.1.1.2  | S    |                         | AN SERVICE            |             |                | 4               | 78                    | 7                    |                   |                         |                        |
	  | 1.1.1.2  | I    | FITTING                 |                       | 40          | 3              |                 | 87                    |                      | 9                 | 220                     | 14                     |
	  | 1.1.2    | I    | SECURITY DOOR           |                       | 24          |                |                 | 100                   | 10                   | 7                 | 214                     |                        |
	  | 1.2      | S    |                         | AN SERVICE            |             |                | 3               | 102                   |                      | 20                | 275                     |                        |
	  | 2.1.1    | I    | VALVE                   |                       | 13          | 2              |                 | 113                   |                      | 8                 | 245                     |                        |
	  | 2.1.1    | I    | FIRE ROLLER SHUTTER     |                       | 9           | 10             |                 | 145                   |                      | 14                | 206                     |                        |
	  | 2.1.2    | I    | PIPE                    |                       | 20          |                |                 | 154                   | 20                   |                   |                         |                        |
	  | 2.2.1    | I    | PIPE                    |                       | 10          |                |                 | 210                   |                      | 3                 | 190                     |                        |
	And I estimate quantity, price and discount for each phase
	  | Phase No | Qty | Unit Price | Disc Percent | Disc Amount | Budget Cost | Profit Margin |
	  | 1        |     |            |              |             |             |               |
	  | 1.1      |     |            |              |             |             |               |
	  | 1.1.1    |     |            |              |             |             |               |
	  | 1.1.1.1  |     |            | 10           |             |             | 30            |
	  | 1.1.1.2  | 1   | 8700       | 10           |             |             |               |
	  | 1.1.2    | 2   | 4700       |              | 700         |             |               |
	  | 1.2      | 4   | 2000       |              |             |             |               |
	  | 2        |     |            |              |             |             |               |
	  | 2.1      |     |            |              |             |             |               |
	  | 2.1.1    | 15  | 689        |              |             |             |               |
	  | 2.1.2    | 12  | 874        |              |             |             |               |
	  | 2.2      |     |            |              |             |             |               |
	  | 2.2.1    | 1   | 4507       |              |             |             |               |
	  | 2.2.2    |     |            |              |             | 200         | 87            |
	  | 2.2.3    | 1   | 987        |              |             | 487         |               |
	And I select supplier for Drawing Object in "<PROJECT>" as
	  | PROJECT | Workhead Groups | Cost Item Group | Drawing Object          | Brand           | Supplier |
	  | 001     | WORKHEAD1       | FPS             | Automatic Sliding Doors | Secom           | CoopMart |
	  | 001     |                 |                 | Fire Roller Shutter     | Mircom          | Adayroi  |
	  | 001     |                 |                 | Security Door           | Mircom          | Adayroi  |
	  | 001     | WORKHEAD1       | HRS             | Fitting                 | Hoa Phat        | Lotte    |
	  | 001     |                 |                 | Pipe                    | Pomina          | Lotte    |
	  | 001     |                 |                 | Valve                   | Vina Coperation | BigC     |
	  | 001     | WORKHEAD2       | HRS             | Pipe                    | Seah Steel      | Metro    |
	Then Brand Comparison in "<PROJECT>" as
	  | PROJECT | Workhead Groups | Cost Item Group | Drawing Object | Qty | Brand           | Supplier | Cost Price |
	  | 001     | WORKHEAD1       | FPS             | Total          |     | Secom           | CoopMart | 4800       |
	  | 001     |                 |                 | Total          |     | Mircom          | Adayroi  | 18102      |
	  | 001     | WORKHEAD1       | HRS             | Total          |     | Hoa Phat        | Lotte    | 1080       |
	  | 001     |                 |                 | Total          |     | Pomina          | Lotte    | 180        |
	  | 001     |                 |                 | Total          |     | Vina Coperation | BigC     | 2805       |
	  | 001     | WORKHEAD2       | HRS             | Total          |     | Seah Steel      | Metro    | 110        |
	Then Cost Item Groups in "<PROJECT>" are grouped as
	  | PROJECT | Workhead Groups | Cost Item Group | Selected Brands                     | Budget Cost |
	  | 001     | WORKHEAD1       | FPS             | Mircom , Secom                      | 22902       |
	  | 001     |                 | HRS             | Hoa Phat , Pomina , Vina Coperation | 4065        |
	  | 001     |                 | Total           |                                     | 26967       |
	  | 001     | WORKHEAD2       | HRS             | Seah Steel                          | 110         |
	  | 001     |                 | Total           |                                     | 110         |
	And Workhead Groups in "<PROJECT>" are grouped as
	  | PROJECT | Workhead Groups | Budget Cost |
	  | 001     | WORKHEAD1       | 26967       |
	  | 001     | WORKHEAD2       | 110         |
	  | 001     | Total           | 27077       |
	And "<PROJECT>" phase detail should be as following
	  | PROJECT | Phase No | Qty | Unit Price | Disc Percent | Disc Amount | Phase Value | Budget Cost | Budget Profit | Profit Margin |
	  | 001     | 1        |     |            |              |             |             | 91175.24    | 120198.29     | 24.15         |
	  | 001     | 1.1      |     |            |              |             |             | 85369.24    | 112198.29     | 23.91         |
	  | 001     | 1.1.1    |     |            |              |             |             | 70671.24    | 103498.29     | 31.72         |
	  | 001     | 1.1.1.1  |     |            |              |             |             | 66967.8     | 95668.29      | 30.00         |
	  | 001     | 1.1.1.2  |     |            |              |             |             | 3703.44     | 7830          | 52.70         |
	  | 001     | 1.1.2    |     |            |              |             |             | 14698       | 8700          | -68.94        |
	  | 001     | 1.2      |     |            |              |             |             | 5806        | 8000          | 27.43         |
	  | 001     | 2        |     |            |              |             |             | 16256.3     | 27756.76      | 48.60         |
	  | 001     | 2.1      |     |            |              |             |             | 12899.3     | 20823         | 38.05         |
	  | 001     | 2.1.1    |     |            |              |             |             | 12683.3     | 10335         | -22.72        |
	  | 001     | 2.1.2    |     |            |              |             |             | 216         | 10488         | 97.94         |
	  | 001     | 2.2      |     |            |              |             |             | 3357        | 6933.76       | 80.28         |
	  | 001     | 2.2.1    |     |            |              |             |             | 2670        | 4507          | 84.91         |
	
	And "<PROJECT>" phase budget profit in Costing Sheet Tree should be as following
	  | PROJECT | Phase No | Budget Cost in Costing Sheet Tree |
	  | 001     | 1        | 91175.24                          |
	  | 001     | 1.1      | 85369.24                          |
	  | 001     | 1.1.1    | 70671.24                          |
	  | 001     | 1.1.1.1  | 66967.8                           |
	  | 001     | 1.1.1.2  | 3703.44                           |
	  | 001     | 1.1.2    | 14698                             |
	  | 001     | 1.2      | 5806                              |
	  | 001     | 2        | 16256.3                           |
	  | 001     | 2.1      | 12899.3                           |
	  | 001     | 2.1.1    | 12683.3                           |
	  | 001     | 2.1.2    | 216                               |
	  | 001     | 2.2      | 3357                              |
	  | 001     | 2.2.1    | 2670                              |
	Then The Costing Sheet in "<PROJECT>" should be calculated as following
	  | PROJECT | Phase No | Drawing Object No | Item Budget>Unit Cost | Budget Cost |
	  | 001     | 1.1.1.1  | 1                 | 87                    | 6105        |
	  | 001     | 1.1.1.1  | 2                 | 90                    | 57481       |
	  | 001     | 1.1.1.2  | 2                 | 87                    | 5841.6      |
	  | 001     | 1.1.2    | 1                 | 100                   | 4138        |
	  | 001     | 2.1.1    | 1                 | 113                   | 3458.38     |
	  | 001     | 2.1.1    | 2                 | 145                   | 4319.5      |
	  | 001     | 2.1.2    | 1                 | 154                   | 3696        |
	  | 001     | 2.2.1    | 1                 | 210                   | 2670        |
	
	When I abort the quotation
	
	Examples:
	  | PROJECT |
	  | 001     |
  
  
  @ian @project @deluge @integration
  Scenario Outline: Create quotation successfully
	Given I want to create a new quotation for "<PROJECT>"
	  | PROJECT | Customer | Quotation Date | Currency | Exchange Rate | Sales Tax |
	  | 001     | ANTEO1   | 15/08/2016     | USD      |               |           |
	When I divide the project "<PROJECT>" into phases
	  | PROJECT | Phase No | Phase                                  | Workhead Group |
	  | 001     | 1        | Project Engineering / Design / Planing | Workhead1      |
	  | 001     | 1.1      | Sea fastening of loose items           |                |
	  | 001     | 1.1.1    | Engineering                            |                |
	  | 001     | 1.1.1.1  | Stowage plan - central laydown area    |                |
	  | 001     | 1.1.1.2  | Site inspection                        |                |
	  | 001     | 1.1.2    | Site Attendance                        |                |
	  | 001     | 1.2      | Phase 7th                              |                |
	  | 001     | 2        | Stowage plan - turret area             |                |
	  | 001     | 2.1      | Basements                              | Workhead1      |
	  | 001     | 2.1.1    | Fire protection systems                |                |
	  | 001     | 2.1.2    | Hose Reel System                       |                |
	  | 001     | 2.2      | Podium                                 | Workhead2      |
	  | 001     | 2.2.1    | Fire protection systems                |                |
	  | 001     | 2.2.2    | Design Fire protection systems         |                |
	  | 001     | 2.2.3    | Design Fire protection systems         |                |
	And I add Cost Item in phases
	  | Phase No | Type | Drawing Object          | Item Code Description | Drawing Qty | Est. Wastage % | Item Budget>Qty | Item Budget>Unit Cost | Item Budget>Markup % | Labour Budget>Qty | Labour Budget>Unit Cost | Labour Budget>Markup % |
	  | 1.1.1.1  | I    | AUTOMATIC SLIDING DOORS |                       | 15          |                |                 | 87                    |                      | 20                | 200                     | 20                     |
	  | 1.1.1.1  | I    | VALVE                   |                       | 20          | 5              |                 | 90                    | 8                    |                   | 210                     | 10                     |
	  | 1.1.1.2  | S    |                         | AN SERVICE            |             |                | 4               | 78                    | 7                    |                   |                         |                        |
	  | 1.1.1.2  | I    | FITTING                 |                       | 40          | 3              |                 | 87                    |                      | 9                 | 220                     | 14                     |
	  | 1.1.2    | I    | SECURITY DOOR           |                       | 24          |                |                 | 100                   | 10                   | 7                 | 214                     |                        |
	  | 1.2      | S    |                         | AN SERVICE            |             |                | 3               | 102                   |                      | 20                | 275                     |                        |
	  | 2.1.1    | I    | VALVE                   |                       | 13          | 2              |                 | 113                   |                      | 8                 | 245                     |                        |
	  | 2.1.1    | I    | FIRE ROLLER SHUTTER     |                       | 9           | 10             |                 | 145                   |                      | 14                | 206                     |                        |
	  | 2.1.2    | I    | PIPE                    |                       | 20          |                |                 | 154                   | 20                   |                   |                         |                        |
	  | 2.2.1    | I    | PIPE                    |                       | 10          |                |                 | 210                   |                      | 3                 | 190                     |                        |
	And I estimate quantity, price and discount for each phase
	  | Phase No | Qty | Unit Price | Disc Percent | Disc Amount | Budget Cost | Profit Margin |
	  | 1        |     |            |              |             |             |               |
	  | 1.1      |     |            |              |             |             |               |
	  | 1.1.1    |     |            |              |             |             |               |
	  | 1.1.1.1  |     |            | 10           |             |             | 30            |
	  | 1.1.1.2  | 1   | 8700       | 10           |             |             |               |
	  | 1.1.2    | 2   | 4700       |              | 700         |             |               |
	  | 1.2      | 4   | 2000       |              |             |             |               |
	  | 2        |     |            |              |             |             |               |
	  | 2.1      |     |            |              |             |             |               |
	  | 2.1.1    | 15  | 689        |              |             |             |               |
	  | 2.1.2    | 12  | 874        |              |             |             |               |
	  | 2.2      |     |            |              |             |             |               |
	  | 2.2.1    | 1   | 4507       |              |             |             |               |
	  | 2.2.2    |     |            |              |             | 200         | 87            |
	  | 2.2.3    | 1   | 987        |              |             | 487         |               |
	And I select supplier for Drawing Object in "<PROJECT>" as
	  | PROJECT | Workhead Groups | Cost Item Group | Drawing Object          | Brand           | Supplier |
	  | 001     | WORKHEAD1       | FPS             | Automatic Sliding Doors | Secom           | CoopMart |
	  | 001     |                 |                 | Fire Roller Shutter     | Mircom          | Adayroi  |
	  | 001     |                 |                 | Security Door           | Mircom          | Adayroi  |
	  | 001     | WORKHEAD1       | HRS             | Fitting                 | Hoa Phat        | Lotte    |
	  | 001     |                 |                 | Pipe                    | Pomina          | Lotte    |
	  | 001     |                 |                 | Valve                   | Vina Coperation | BigC     |
	  | 001     | WORKHEAD2       | HRS             | Pipe                    | Seah Steel      | Metro    |
	
	And I submit the quotation
	
	Examples:
	  | PROJECT |
	  | 001     |


