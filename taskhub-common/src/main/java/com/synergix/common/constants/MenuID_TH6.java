package com.synergix.common.constants;

import java.lang.reflect.Field;

public class MenuID_TH6
{
    // -----------------Operations-----------------//
    public static final String OP_PERFORMANCE_MANAGEMENT = "Operations>Performance Management>Performance Management";
    public static final String OP_BONUS_REVIEW           = "Operations>Performance Management>Bonus Review";

    // -----------------Master Setup-----------------//
    public static final String MS_GLOBAL_EMPLOYEE                 = "Master Setup>Employee & Approving Officer>Global Employee";
    public static final String MS_HR_REVIEW_GRADE_MAINTENANCE     = "Master Setup>Review>Review Grade Maintenance";
    public static final String MS_HR_REVIEW_GRATUITY_BASIC_SALARY = "Master Setup>Review>Review Bonus/Gratuity & Basic Salary Increment Maintenance";

    // -----------------Opening Balance-----------------//

    public static String getMenuName(String menuID)
    {
        MenuID_TH6 menu   = new MenuID_TH6();
        Field[]    fields = MenuID_TH6.class.getFields();
        for (Field field : fields)
        {
            try
            {
                if (field.get(menu).toString().equals(menuID))
                {
                    return field.getName();
                }
            } catch (IllegalArgumentException | IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
        return "";
    }
}
