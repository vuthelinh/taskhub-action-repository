package com.synergix.common.pages;

import com.synergix.common.TH6PageObject;
import org.openqa.selenium.WebDriver;

public class MenuNavigationPage extends TH6PageObject
{
    public MenuNavigationPage(WebDriver driver)
    {
        super(driver);
    }

    String xPathPageHeader = "(//div[@id='navibar']//span[@class='ui-menuitem-text'])[2]";

    public String get_page_header_title()
    {
        return waitElementToBePresent(xPathPageHeader).waitUntilVisible().getText();
    }

    public void wait_page_load(String _pageHeader)
    {
        waitElementToBePresent("(//div[@id='navibar']//span[@class='ui-menuitem-text'])[2 and text()='" + _pageHeader + "']").waitUntilVisible();
    }

    /**
     * Go to screen in TH6 by menu name.
     *
     * @param menuLv1 : name of menu lv1
     * @param menuLv2 : name of menu lv2
     * @param menuLv3 : name of menu lv3
     * @author Vincent
     */
    public void goToTH5MenuLevel3(String menuLv1, String menuLv2, String menuLv3)
    {
        // Set xpath lv1
        String xLevel1 = "//*[@id='centerPane']//a[@href and text()='" + menuLv1 + "']";
        $(xLevel1).waitUntilClickable().click();
        waitForAllJSCompletes();

        // set xPath lv2
        String xLevel2 = "//div[@aria-hidden='false']//div[contains(@class, 'menu-level3')]/*[text()='" + menuLv2 + "']";
        $(xLevel2).waitUntilClickable().click();
        waitForAllJSCompletes();

        // set xpath lv3
        String xLevel3 = "//*[contains(@id, 'menuItemPanel')]//div[contains(@class, 'menu-level5')]/*[text()='" + menuLv3 + "']";
        $(xLevel3).waitUntilClickable().click();
        waitForAllJSCompletes();

    }

    /**
     * Go to screen in TH5 by menu name.
     *
     * @param menuLv1   : name of menu lv1
     * @param menuLv2   : name of menu lv2
     * @param menuLv3   : name of menu lv3
     * @param menuIndex : index of menu to be selected.
     * @author Vincent
     */
    public void goToTH5MenuLevel3WithIndex(String menuLv1, String menuLv2, String menuLv3, String menuIndex)
    {
        // Set xpath lv1
        String xLevel1 = "//*[@id='centerPane']//a[@href and text()='" + menuLv1 + "']";
        waitElementToBeClickable(xLevel1).click();
        waitForAllJSCompletes();

        // set xPath lv2
        String xLevel2 = "//div[@aria-hidden='false']//div[contains(@class, 'menu-level3')]/*[text()='" + menuLv2 + "']";
        waitElementToBeClickable(xLevel2).click();

        waitForAllJSCompletes();

        // set xpath lv3
        String xLevel3 = "(//*[contains(@id, 'menuItemPanel')]//div[contains(@class, 'menu-level5')]/*[text()='" + menuLv3 + "'])[" + menuIndex + "]";
        waitElementToBeClickable(xLevel3).click();
        waitForAllJSCompletes();

    }

    /**
     * Go to screen in TH5 by menu name.
     *
     * @param menuLv1 : name of menu lv1
     * @param menuLv2 : name of menu lv2
     * @param menuLv3 : name of menu lv3
     * @author Vincent
     */
    public void goToTH5MenuLevel2(String menuLv1, String menuLv2)
    {
        // Set xpath lv1
        String xLevel1 = "//*[@id='centerPane']//a[@href and text()='" + menuLv1 + "']";
        waitElementToBeClickable(xLevel1).click();
        waitForAllJSCompletes();

        String xLevel2 = "//div[@aria-hidden='false']//div[contains(@class, 'menu-level3')]/*[text()='" + menuLv2 + "']";
        waitElementToBeClickable(xLevel2).click();
        waitForAllJSCompletes();

    }

    /**
     * Go to screen in TH5 by menu name.
     *
     * @param menuLv1   : name of menu lv1
     * @param menuLv2   : name of menu lv2
     * @param menuLv3   : name of menu lv3
     * @param menuIndex : index of menu to be selected.
     * @author Vincent
     */
    public void goToTH5MenuLevel2WithIndex(String menuLv1, String menuLv2, String menuIndex)
    {
        // Set xpath lv1
        String xLevel1 = "//*[@id='centerPane']//a[@href and text()='" + menuLv1 + "']";
        waitElementToBeClickable(xLevel1).click();
        waitForAllJSCompletes();

        String xLevel2 = "(//div[@aria-hidden='false']//div[contains(@class, 'menu-level3')]/*[text()='" + menuLv2 + "'])[" + menuIndex + "]";
        waitElementToBeClickable(xLevel2).click();
        waitForAllJSCompletes();

    }

    /**
     * Go to screen in TH5 by menu name.
     *
     * @param menuLv1 : name of menu lv1
     * @author Vincent
     */
    public void goToTH5MenuLevel1(String menuLv1)
    {
        String xLevel1 = "//*[@id='centerPane']//a[@href and text()='" + menuLv1 + "']";
        waitElementToBeClickable(xLevel1).click();
        waitForAllJSCompletes();

    }

    /**
     * Go to screen in TH5 by menu name.
     *
     * @param menuLv1   : name of menu lv1
     * @param menuIndex : index of menu to be selected.
     * @author Vincent
     */
    public void goToTH5MenuLevel1WithIndex(String menuLv1, String menuIndex)
    {
        // Set xpath lv1
        String xLevel1 = "(//*[@id='centerPane']//a[@href and text()='" + menuLv1 + "'])[" + menuIndex + "]";
        waitElementToBeClickable(xLevel1).click();
        waitForAllJSCompletes();

    }
	public void clickOnHomeIcon() {
		String xHomeIcon = "//form[@id='navigationForm']//li[@role='menuitem']/a[@href]";
		if (findAll(xHomeIcon).size() > 0) {
			clickOnElement(xHomeIcon);
			waitForAllJSCompletes();
		}
	}
}
