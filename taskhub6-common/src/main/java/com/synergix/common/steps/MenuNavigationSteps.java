package com.synergix.common.steps;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import com.synergix.common.pages.MenuNavigationPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MenuNavigationSteps extends ScenarioSteps
{

    MenuNavigationPage menuNaviPage;

    // Region Vincent

    public void goToTH5MenuLevel3(String menuLv1, String menuLv2, String menuLv3)
    {
        menuNaviPage.goToTH5MenuLevel3(menuLv1, menuLv2, menuLv3);
    }

    public void goToTH5MenuLevel2(String menuLv1, String menuLv2)
    {
        menuNaviPage.goToTH5MenuLevel2(menuLv1, menuLv2);
    }

    public void goToTH5MenuLevel1(String menuLv1)
    {
        menuNaviPage.goToTH5MenuLevel1(menuLv1);
    }

    public void goToTH5MenuLevel3WithIndex(String menuLv1, String menuLv2, String menuLv3, String menuIndex)
    {
        menuNaviPage.goToTH5MenuLevel3WithIndex(menuLv1, menuLv2, menuLv3, menuIndex);
    }

    public void goToTH5MenuLevel2WithIndex(String menuLv1, String menuLv2, String menuIndex)
    {
        menuNaviPage.goToTH5MenuLevel2WithIndex(menuLv1, menuLv2, menuIndex);
    }

    public void goToTH5MenuLevel1WithIndex(String menuLv1, String menuIndex)
    {
        menuNaviPage.goToTH5MenuLevel1WithIndex(menuLv1, menuIndex);
    }

    @Step
    public void verify_page_header(String _pageHeader)
    {
        menuNaviPage.wait_page_load(_pageHeader);
        assertThat("Page header is not correct.", menuNaviPage.get_page_header_title().equals(_pageHeader), is(true));
    }

    @Step
    public void user_navigates_to_screen(String screenMenuPath)
    {
        String[] asMenuPath = screenMenuPath.split(">");
        // Check path contain index
        int numPath = asMenuPath.length;
        String menuIndex = "1";
        boolean bIndexOrNot = false;
        if (asMenuPath[numPath - 1].contains("[") && asMenuPath[numPath - 1].contains("]"))
        {
            bIndexOrNot = true;
            menuIndex = asMenuPath[numPath - 1].replace("[", "").replace("]", "");
        }

        switch (numPath)
        {
            case 1:
                numPath = 1;
            {
                goToTH5MenuLevel1(asMenuPath[0]);
                break;
            }
            case 2:
                numPath = 2;
            {
                if (!bIndexOrNot)
                {
                    goToTH5MenuLevel2(asMenuPath[0], asMenuPath[1]);
                }
                else
                {
                    goToTH5MenuLevel1WithIndex(asMenuPath[0], menuIndex);
                }
                break;
            }
            case 3:
                numPath = 3;
            {
                if (!bIndexOrNot)
                {
                    goToTH5MenuLevel3(asMenuPath[0], asMenuPath[1], asMenuPath[2]);
                }
                else
                {
                    goToTH5MenuLevel2WithIndex(asMenuPath[0], asMenuPath[1], menuIndex);
                }
                break;
            }
            case 4:
                numPath = 4;
            {
                if (bIndexOrNot)
                {
                    goToTH5MenuLevel3WithIndex(asMenuPath[0], asMenuPath[1], asMenuPath[2], menuIndex);
                }
                break;
            }
            default:
                fail("Incorrect menu path format or not support this menu level yet.");
                break;
        }
    }
    // End Region Vincent

    public void user_navigates_to_employee_screen()
    {
        user_navigates_to_screen("Master Setup>Employee & Approving Officer>Employee>[2]");
    }

    public void user_navigates_to_leave_entitlement_screen()
    {
        user_navigates_to_screen("Processing>Leave>Leave Entitlement");
    }

    public void user_navigates_to_global_config()
    {
        user_navigates_to_screen("Global Setup>Global Config>Global Config");
    }

    public void user_navigates_to_leave_type_screen()
    {
        user_navigates_to_screen("Global Setup>Leave>Leave Type");
    }

    public void user_navigates_to_payment_cycle_screen()
    {
        user_navigates_to_screen("Global Setup>Payroll>Payment Cycle");
    }

    public void user_navigates_to_epc_screen()
    {
        user_navigates_to_screen("Global Setup>Administration>Employee>Employee Payroll Category");
    }

    public void user_navigates_to_employee_grade_screen()
    {
        user_navigates_to_screen("Global Setup>Administration>Employee>Employee Grade");
    }

    //Nancy - Click to Home Icon - to Come back Home screen TH6
    public void clickOnHomeIcon()
    {
        menuNaviPage.clickOnHomeIcon();
    }

    public void switchToParentFrame()
    {
        menuNaviPage.switchToParentFrame();
    }

    //Ian - switch to th5iframe
    @Step
    public void switchToTH5iframe()
    {
        menuNaviPage.switchToIFrame();
    }

    @Step
    public String get_page_title()
    {
        return menuNaviPage.get_page_header_title();
    }
}
