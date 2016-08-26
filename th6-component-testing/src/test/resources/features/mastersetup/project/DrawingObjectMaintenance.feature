@TH6_DRAWING_OBJECT_MAINTENANCE @Drawing_Object_Maintenance @MT @integration @zoe
Feature: Drawing Object Maintenance

  Background: 
    Given user login the taskhub system

  
  Scenario: Drawing object management
     And user navigates to "Master Setup>Project>Drawing Object Maintenance" screen
    #New
    When user creates new drawing object
      | Drawing Object Code | Description | Cost Item Group | Brand | Inventory | Date From  | Date To    | Qty  | UOM  |
      | ZOE_test2           | Zoe test    | CIG005          | IB005 | I010      | 10/08/2016 | 10/10/2016 | 6.00 | U005 |
    #Search
    Then user found down information in the list
      | Drawing Object Code | Description | Cost Item Group | Brand | Inventory | Date From  | Date To    | Qty  | UOM  |
      | ZOE_test2           | Zoe test    | CIG005          | IB005 | I010      | 10/08/2016 | 10/10/2016 | 6.00 | U005 |
    #Delete
     And user delete drawing object then that drawing object is not found in the list
      | Drawing Object Code |
      | ZOE_test2           |
