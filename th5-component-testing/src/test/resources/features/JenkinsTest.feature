Feature: Test Jenkins

  @jenkins
  Scenario: Login to taskhub System
    * user is currently logged in to TaskHub System
    
    * user navigates to "Global Setup>Global Config>Global Config" screen
    * user changes Module Config
      | Module Section       | Module Name                                  | Config Type | Config Value |
      | Global Configuration | Enable Send Email                            | Radio       | No           |
      | Global Configuration | Enable Year Of Service                       | Radio       | Yes          |
      | Global Configuration | Enable other options for leave type          | Radio       | No           |
      | Global Configuration | Pay hourly rate employee if leave is applied | Radio       | Yes          |
    
    * user navigates to "Maintenance Setup>Module Config>Module Config" screen
    * user changes Module Config
      | Module Section | Module Name                                       | Config Type | Config Value |
      | Leave          | Enable validation based on leave application date | Radio       | Yes          |
    
    * user logout
    * check database connection with pass parameter in command line
