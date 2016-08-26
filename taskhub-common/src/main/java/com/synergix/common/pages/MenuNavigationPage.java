package com.synergix.common.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;


public class MenuNavigationPage extends TH5PageObject {
	public MenuNavigationPage(WebDriver driver) {
		super(driver);
	}

	String xPathPageHeader = "//span[@id='formHeaderAtHeader:formTitle']";

	public String get_page_header_title() {
		return waitElementToBePresent(xPathPageHeader).waitUntilVisible().getText();
	}

	public void wait_page_load(String _pageHeader) {
		waitElementToBePresent("//span[@id='formHeaderAtHeader:formTitle' and text()='" + _pageHeader + "']")
				.waitUntilVisible();
	}

	/**
	 * Go to screen in TH5 by menu name.
	 * 
	 * @author Vincent
	 * @param menuLv1
	 *            : name of menu lv1
	 * @param menuLv2
	 *            : name of menu lv2
	 * @param menuLv3
	 *            : name of menu lv3
	 * @param menuLv4
	 *            : name of menu lv4
	 */
	public void goToTH5MenuLevel4(String menuLv1, String menuLv2, String menuLv3, String menuLv4) {
		String xpath = "//*[@id='menuForm:menu']";
		int menuWidth = 10;
		String tempEleId = "";
		// Set xpath lv1
		xpath += "//span[text()='" + menuLv1 + "' and contains(@id,'menuForm:menu')]";

		// click on lv1
		clickOnElement(xpath);
		// Get id of group menu lv1
		xpath = xpath + "/ancestor::div[2]";
		tempEleId = waitElementToBePresent(xpath).getAttribute("id").replace("menuForm:sys_gen", "")
				.replace("menuForm:syn_gen", "");

		// Set xpath lv2
		xpath = "(//*[@id='menuForm:menu']//div[contains(@id,'" + tempEleId + "')]//span[text()='" + menuLv2 + "'])[1]";

		// click on lv2
		clickOnElement(xpath);
		menuWidth = waitElementToBePresent(xpath + "/ancestor::div[2]").getSize().getWidth();
		withAction()
				.moveToElement(waitElementToBePresentThenScrollIntoView(xpath).waitUntilVisible(), 10 + menuWidth, 4)
				.build().perform();
		// get @id of menu lv2
		tempEleId = waitElementToBePresent(xpath).getAttribute("id").replace("menuForm:sys_gen", "")
				.replace("menuForm:syn_gen", "").replace(":anchor", "");
		// Set xpath lv3
		xpath = "(//*[@id='menuForm:menu']//div[contains(@id,'" + tempEleId + "')]//span[text()='" + menuLv3 + "'])[1]";

		// click on xpath lv3
		clickOnElement(xpath);
		menuWidth = waitElementToBePresent(xpath + "/ancestor::div[2]").getSize().getWidth();
		withAction()
				.moveToElement(waitElementToBePresentThenScrollIntoView(xpath).waitUntilVisible(), 10 + menuWidth, 4)
				.build().perform();

		// get @id of menu lv3
		tempEleId = waitElementToBePresent(xpath).getAttribute("id").replace("menuForm:sys_gen", "")
				.replace("menuForm:syn_gen", "").replace(":anchor", "");
		// Set xpath lv4
		xpath = "(//*[@id='menuForm:menu']//div[contains(@id,'" + tempEleId + "')]//span[text()='" + menuLv4
				+ "' and contains(@id,'menuForm:menu_')])[1]";

		// click on xpath lv4
		clickOnElement(xpath);
	}

	/**
	 * Go to screen in TH5 by menu name.
	 * 
	 * @author Vincent
	 * @param menuLv1
	 *            : name of menu lv1
	 * @param menuLv2
	 *            : name of menu lv2
	 * @param menuLv3
	 *            : name of menu lv3
	 * @param menuLv4
	 *            : name of menu lv4
	 * @param menuIndex
	 *            : index of menu to be selected.
	 */
	public void goToTH5MenuLevel4WithIndex(String menuLv1, String menuLv2, String menuLv3, String menuLv4,
			String menuIndex) {
		String xpath = "//*[@id='menuForm:menu']";
		int menuWidth = 10;
		String tempEleId = "";
		// Set xpath lv1
		xpath += "//span[text()='" + menuLv1 + "' and contains(@id,'menuForm:menu')]";
		// click on lv1
		clickOnElement(xpath);
		// Get id of group menu lv1
		xpath = xpath + "/ancestor::div[2]";
		tempEleId = waitElementToBePresent(xpath).getAttribute("id").replace("menuForm:sys_gen", "")
				.replace("menuForm:syn_gen", "");
		// Set xpath lv2
		xpath = "(//*[@id='menuForm:menu']//div[contains(@id,'" + tempEleId + "')]//span[text()='" + menuLv2 + "'])[1]";

		// click on lv2
		clickOnElement(xpath);
		menuWidth = waitElementToBePresent(xpath + "/ancestor::div[2]").getSize().getWidth();
		withAction()
				.moveToElement(waitElementToBePresentThenScrollIntoView(xpath).waitUntilVisible(), 10 + menuWidth, 4)
				.build().perform();
		// get @id of menu lv2
		tempEleId = waitElementToBePresent(xpath).getAttribute("id").replace("menuForm:sys_gen", "")
				.replace("menuForm:syn_gen", "").replace(":anchor", "");
		// Set xpath lv3
		xpath = "(//*[@id='menuForm:menu']//div[contains(@id,'" + tempEleId + "')]//span[text()='" + menuLv3 + "'])[1]";

		// click on xpath lv3
		clickOnElement(xpath);
		menuWidth = waitElementToBePresent(xpath + "/ancestor::div[2]").getSize().getWidth();
		withAction()
				.moveToElement(waitElementToBePresentThenScrollIntoView(xpath).waitUntilVisible(), 10 + menuWidth, 4)
				.build().perform();
		// get @id of menu lv3
		tempEleId = waitElementToBePresent(xpath).getAttribute("id").replace("menuForm:sys_gen", "")
				.replace("menuForm:syn_gen", "").replace(":anchor", "");
		// Set xpath lv4
		xpath = "(//*[@id='menuForm:menu']//div[contains(@id,'" + tempEleId + "')]//span[text()='" + menuLv4
				+ "' and contains(@id,'menuForm:menu_')])[" + menuIndex + "]";

		// click on xpath lv4
		clickOnElement(xpath);
	}

	/**
	 * Go to screen in TH5 by menu name.
	 * 
	 * @author Vincent
	 * @param menuLv1
	 *            : name of menu lv1
	 * @param menuLv2
	 *            : name of menu lv2
	 * @param menuLv3
	 *            : name of menu lv3
	 */
	public void goToTH5MenuLevel3(String menuLv1, String menuLv2, String menuLv3) {
		String xpath = "//*[@id='menuForm:menu']";
		String tempEleId = "";
		int menuWidth = 10;
		// Set xpath lv1
		xpath += "//span[text()='" + menuLv1 + "' and contains(@id,'menuForm:menu')]";

		// click on lv1
		clickOnElement(xpath);
		// Get id of group menu lv1
		xpath = xpath + "/ancestor::div[2]";
		tempEleId = waitElementToBePresent(xpath).getAttribute("id").replace("menuForm:sys_gen", "")
				.replace("menuForm:syn_gen", "");
		// Set xpath lv2
		xpath = "(//*[@id='menuForm:menu']//div[contains(@id,'" + tempEleId + "')]//span[text()='" + menuLv2 + "'])[1]";

		// click on lv2
		clickOnElement(xpath);
		menuWidth = waitElementToBePresent(xpath + "/ancestor::div[2]").getSize().getWidth();
		withAction()
				.moveToElement(waitElementToBePresentThenScrollIntoView(xpath).waitUntilVisible(), 10 + menuWidth, 4)
				.build().perform();
		// get @id of menu lv2
		tempEleId = waitElementToBePresent(xpath).getAttribute("id").replace("menuForm:sys_gen", "")
				.replace("menuForm:syn_gen", "").replace(":anchor", "");
		// Set xpath lv3
		xpath = "(//*[@id='menuForm:menu']//div[contains(@id,'" + tempEleId + "')]//span[text()='" + menuLv3
				+ "' and contains(@id,'menuForm:menu_')])[1]";
		// click on xpath lv3
		clickOnElement(xpath);
	}

	/**
	 * Go to screen in TH5 by menu name.
	 * 
	 * @author Vincent
	 * @param menuLv1
	 *            : name of menu lv1
	 * @param menuLv2
	 *            : name of menu lv2
	 * @param menuLv3
	 *            : name of menu lv3
	 * @param menuIndex
	 *            : index of menu to be selected.
	 */
	public void goToTH5MenuLevel3WithIndex(String menuLv1, String menuLv2, String menuLv3, String menuIndex) {
		String xpath = "//*[@id='menuForm:menu']";
		int menuWidth = 10;
		String tempEleId = "";
		// Set xpath lv1
		xpath += "//span[text()='" + menuLv1 + "' and contains(@id,'menuForm:menu')]";

		// click on lv1
		clickOnElement(xpath);
		// Get id of group menu lv1
		xpath = xpath + "/ancestor::div[2]";
		tempEleId = waitElementToBePresent(xpath).getAttribute("id").replace("menuForm:sys_gen", "")
				.replace("menuForm:syn_gen", "");
		// Set xpath lv2
		xpath = "(//*[@id='menuForm:menu']//div[contains(@id,'" + tempEleId + "')]//span[text()='" + menuLv2 + "'])[1]";

		// click on lv2
		clickOnElement(xpath);
		menuWidth = waitElementToBePresent(xpath + "/ancestor::div[2]").getSize().getWidth();
		withAction()
				.moveToElement(waitElementToBePresentThenScrollIntoView(xpath).waitUntilVisible(), 10 + menuWidth, 4)
				.build().perform();
		// get @id of menu lv2
		tempEleId = waitElementToBePresent(xpath).getAttribute("id").replace("menuForm:sys_gen", "")
				.replace("menuForm:syn_gen", "").replace(":anchor", "");
		// Set xpath lv3
		xpath = "(//*[@id='menuForm:menu']//div[contains(@id,'" + tempEleId + "')]//span[text()='" + menuLv3
				+ "' and contains(@id,'menuForm:menu_')])[" + menuIndex + "]";
		// click on xpath lv3
		clickOnElement(xpath);
	}

	/**
	 * Go to screen in TH5 by menu name.
	 * 
	 * @author Vincent
	 * @param menuLv1
	 *            : name of menu lv1
	 * @param menuLv2
	 *            : name of menu lv2
	 * @param menuLv3
	 *            : name of menu lv3
	 */
	public void goToTH5MenuLevel2(String menuLv1, String menuLv2) {
		String xpath = "//*[@id='menuForm:menu']";
		String tempEleId = "";
		// Set xpath lv1
		xpath += "//span[text()='" + menuLv1 + "' and contains(@id,'menuForm:menu')]";

		// click on lv1
		clickOnElement(xpath);
		// Get id of group menu lv1
		xpath = xpath + "/ancestor::div[2]";
		tempEleId = waitElementToBePresent(xpath).getAttribute("id").replace("menuForm:sys_gen", "")
				.replace("menuForm:syn_gen", "");
		// Set xpath lv2
		xpath = "(//*[@id='menuForm:menu']//div[contains(@id,'" + tempEleId + "')]//span[text()='" + menuLv2
				+ "' and contains(@id,'menuForm:menu_')])[1]";

		// click on lv2
		clickOnElement(xpath);
	}

	/**
	 * Go to screen in TH5 by menu name.
	 * 
	 * @author Vincent
	 * @param menuLv1
	 *            : name of menu lv1
	 * @param menuLv2
	 *            : name of menu lv2
	 * @param menuLv3
	 *            : name of menu lv3
	 * @param menuIndex
	 *            : index of menu to be selected.
	 */
	public void goToTH5MenuLevel2WithIndex(String menuLv1, String menuLv2, String menuIndex) {
		String xpath = "//*[@id='menuForm:menu']";
		String tempEleId = "";
		// Set xpath lv1
		xpath += "//span[text()='" + menuLv1 + "' and contains(@id,'menuForm:menu')]";

		// click on lv1
		clickOnElement(xpath);
		// Get id of group menu lv1
		xpath = xpath + "/ancestor::div[2]";
		tempEleId = waitElementToBePresent(xpath).getAttribute("id").replace("menuForm:sys_gen", "")
				.replace("menuForm:syn_gen", "");
		// Set xpath lv2
		xpath = "(//*[@id='menuForm:menu']//div[contains(@id,'" + tempEleId + "')]//span[text()='" + menuLv2
				+ "' and contains(@id,'menuForm:menu_')])[" + menuIndex + "]";

		// click on lv2
		clickOnElement(xpath);
	}

	/**
	 * Go to screen in TH5 by menu name.
	 * 
	 * @author Vincent
	 * @param menuLv1
	 *            : name of menu lv1
	 */
	public void goToTH5MenuLevel1(String menuLv1) {
		String xpath = "//*[@id='menuForm:menu']";
		// Set xpath lv1
		xpath += "//span[text()='" + menuLv1 + "' and contains(@id,'menuForm:menu')]";

		// click on lv1
		clickOnElement(xpath);
	}

	/**
	 * Go to screen in TH5 by menu name.
	 * 
	 * @author Vincent
	 * @param menuLv1
	 *            : name of menu lv1
	 * @param menuIndex
	 *            : index of menu to be selected.
	 */
	public void goToTH5MenuLevel1WithIndex(String menuLv1, String menuIndex) {
		String xpath = "//*[@id='menuForm:menu']";
		// Set xpath lv1
		xpath += "(//span[text()='" + menuLv1 + "' and contains(@id,'menuForm:menu')]" + ")[" + menuIndex + "]";

		// click on lv1
		clickOnElement(xpath);
	}
}
