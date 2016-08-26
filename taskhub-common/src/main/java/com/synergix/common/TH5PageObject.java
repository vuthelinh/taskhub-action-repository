package com.synergix.common;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Predicate;
import com.synergix.utilities.ConnectDatabase;
import com.synergix.utilities.DateTimeUtil;
import com.synergix.utilities.LoadObject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @Description A base class representing a WebDriver page object. This class
 *              extends core PageObject class and we can add common methods for
 *              TH5 site. Using likes PageObject class. WARNING: Please,
 *              consider carefully when CRUD this class and set public method.
 *              Don't create specific page here.
 *
 * @author Vincent
 * @version 20151211
 */

public abstract class TH5PageObject extends
		net.serenitybdd.core.pages.PageObject {
	// #Region#Construction
	protected TH5PageObject() {
		super();
		setImplicitTimeout(5, TimeUnit.SECONDS);
		try {
			SETTING = LoadObject.loading_config_sys("serenity.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String xPopupDiv="//div[@id='popupModalPanelContentDiv']";
	
	protected TH5PageObject(WebDriver driver,
			Predicate<? super net.serenitybdd.core.pages.PageObject> callback) {
		super(driver, callback);
		try {
			SETTING = LoadObject.loading_config_sys("serenity.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public TH5PageObject(WebDriver driver, int ajaxTimeout) {
		super(driver, ajaxTimeout);
		try {
			SETTING = LoadObject.loading_config_sys("serenity.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public TH5PageObject(WebDriver driver) {
		super(driver);
		try {
			SETTING = LoadObject.loading_config_sys("serenity.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// #EndRegion#Construction

	// Jacob common

	public void select_date(String ddMMyyyy) {

		if (!ddMMyyyy.isEmpty()) {
			int day = Integer.parseInt(ddMMyyyy.split("/")[0]);
			int month = Integer.parseInt(ddMMyyyy.split("/")[1]);
			int year = Integer.parseInt(ddMMyyyy.split("/")[2]);

			// int cDay = DateTimeUtil.getCurrentDay();
			int cMonth = DateTimeUtil.getCurrentMonth();
			int cYear = DateTimeUtil.getCurrentYear();

			// Reset calendar is today (current)
			$("//div[contains(@onclick,'today')]").waitUntilClickable().click();

			int absYear = cYear - year;
			LogWork.log_debug("absYear " + absYear);
			if (absYear <= 0) {
				absYear = Math.abs(absYear);
				for (int i = 1; i <= absYear; i++)
					$("//div[contains(@onclick,'nextYear')]")
							.waitUntilClickable().click();
				waitForAllJSCompletes();
			} else {
				absYear = Math.abs(absYear);
				for (int i = 1; i <= absYear; i++)
					$("//div[contains(@onclick,'prevYear')]")
							.waitUntilClickable().click();
				waitForAllJSCompletes();
			}

			int absMonth = cMonth - month;
			LogWork.log_debug("Month " + absMonth);
			if (absMonth <= 0) {
				absMonth = Math.abs(absMonth);
				for (int i = 1; i <= absMonth; i++)
					$("//div[contains(@onclick,'nextMonth')]")
							.waitUntilClickable().click();
			} else {
				absMonth = Math.abs(absMonth);
				for (int i = 1; i <= absMonth; i++)
					$("//div[contains(@onclick,'prevMonth')]")
							.waitUntilClickable().click();
			}

			String tempXpath = "//td[text()='" + day + "']";

			$(tempXpath).click();

		}
	}

	public static Properties SETTING = null;

	/**
	 * Search object on the search form, rename from searchAndSelectByInputCode
	 * 
	 * @param label
	 * @param value
	 */
	public boolean search(String label, String value) {

		waitTypeAndEnter(
				xPathInputFieldWithLabel("//table[contains(@id,'search')]",
						label, 1), value);
		setImplicitTimeout(10, TimeUnit.SECONDS);
		if (waitElementToBeVisible(
				"(//form[@id='searchResult_Form']//*[.='No Records Found!'] | //form[@id='searchResult_Form']//td//a[.='"
						+ value + "'])[1]").getText().toLowerCase()
				.contains("no records found")) {
			close_from();
			resetImplicitTimeout();
			return false;
		} else {
			resetImplicitTimeout();
			clickOnElement("//form[@id='searchResult_Form']//td//a[.='" + value
					+ "']");
			waitForAllJSCompletes();
			return true;
		}
	};

	public void close_from() {
		$("//img[@src='/TH5Web/img/close-icon.gif']").waitUntilClickable()
				.click();
		waitForAllJSCompletes();
	}

	// Functional button panel

	public void click_add_new_button_on_functional_panel() {
		waitForAllJSCompletes();
		clickBtn("New");
		waitForAllJSCompletes();
	}

	public void click_update_button_on_functional_panel() {
		clickBtn("Update");
		chooseYesOnUpdateConfirmation();
		chooseOkOnInforPanel();
		waitForAllJSCompletes();
	}

	public void click_submit_button_on_functional_panel() {
		clickBtn("Submit");
		waitForAllJSCompletes();
	}

	public void click_close_button_on_functional_panel() {
		clickBtn("Close");
		waitForAllJSCompletes();
	}

	@FindBy(id = "DetailFrmId:DetailCloseBtnId")
	public WebElementFacade DetailCloseBtnId;

	public void click_back_button_on_functional_panel() {
		DetailCloseBtnId.waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void click_search_button_on_functional_panel() {
		clickBtn("Search");
	}

	public void click_delete_button_on_functional_panel() {
		clickBtn("Delete");
		chooseYesOnUpdateConfirmation();
		chooseOKOnInfoPanel();
	}

	@FindBy(id = "ErrorForm:OKButton")
	public WebElementFacade okBtnErrMsg;

	public WebElementFacade statusPopupPanel_OkButton;

	public void chooseOKOnInforConfirmation() {
		statusPopupPanel_OkButton.waitUntilPresent().waitUntilClickable()
				.click();
		waitForAllJSCompletes();
	}

	public void chooseOKOnInfoPanel() {
		try {
			waitFor(statusPopupPanel_OkButton);
			statusPopupPanel_OkButton.waitUntilPresent().waitUntilClickable()
					.click();
		} catch (Exception ex) {
		}
	}

	// End Jacob common

	// #Region#Common wait
	/**
	 * @Description Wait for A4J complete
	 * @author Vincent
	 * @param _timeoutInSeconds
	 *            Timeout In Seconds
	 */
	public void waitUntilA4JRequestCompletes(int _timeoutInSeconds) {
		withTimeoutOf(_timeoutInSeconds, TimeUnit.SECONDS)
				.waitFor(
						ExpectedConditions.presenceOfElementLocated(By
								.xpath("//span[contains(@id,'_viewRoot:status.start') and contains(@style,'display: none')]")));
	}

	/**
	 * @Description Wait for jQuery complete
	 * @author Vincent
	 * @param _timeoutInSeconds
	 *            Timeout In Seconds
	 */
	public void waitUntiljQueryRequestCompletes(int _timeoutInSeconds) {
		new FluentWait<>(getDriver())
				.withTimeout(_timeoutInSeconds, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS)
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						try {
							JavascriptExecutor jsExec = (JavascriptExecutor) d;
							return (Boolean) jsExec
									.executeScript("return jQuery.active == 0");
						} catch (Exception e) {
							return true;
						}
					}
				});
	}

	/**
	 * @Description Wait for Ajax complete
	 * @author Vincent
	 * @param _timeoutInSeconds
	 *            Timeout In Seconds
	 */
	public void waitUntilAjaxCompletes(int _timeoutInSeconds) {
		new FluentWait<>(getDriver())
				.withTimeout(_timeoutInSeconds, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS)
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						try {
							JavascriptExecutor jsExec = (JavascriptExecutor) d;
							return (Boolean) jsExec
									.executeScript("return Ajax.activeRequestCount == 0");
						} catch (Exception e) {
							return true;
						}
					}
				});
	}

	/**
	 * @Description Wait for HTML ready
	 * @author Vincent
	 * @param _timeoutInSeconds
	 *            Timeout In Seconds
	 */
	public void waitUntilHTMLReady(int _timeoutInSeconds) {
		new FluentWait<>(getDriver())
				.withTimeout(_timeoutInSeconds, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS)
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						try {
							JavascriptExecutor jsExec = (JavascriptExecutor) d;
							return (Boolean) jsExec
									.executeScript("return document.readyState=='complete'");
						} catch (Exception e) {
							return true;
						}
					}
				});
	}

	/**
	 * @Description : Waiting for all HTML, JS, Ajax, A4J in TH5 finish when
	 *              doing any action. Using before or after each action.
	 * @author Vincent
	 */
	public void waitForAllJSCompletes() {
		waitABit(120); // Milliseconds
		waitUntiljQueryRequestCompletes(5);
		waitUntilAjaxCompletes(5);
		waitUntilA4JRequestCompletes(180); // Seconds
		waitUntilAjaxCompletes(5);
		waitUntiljQueryRequestCompletes(5);
		waitForWithRefresh();
	}

	/**
	 * @Description Wait for given text to be present in element value.
	 * @author Vincent
	 * @param wE
	 *            WebElementFacade
	 * @param _value
	 *            Value
	 * @return WebElementFacade
	 */
	public WebElementFacade waitTextToBePresentInElementValue(
			WebElementFacade _wE, String _value) {
		waitForAllJSCompletes();
		waitFor(ExpectedConditions.textToBePresentInElementValue(_wE, _value));
		return _wE;
	}

	/**
	 * @Description Wait for given text to be present in element value.
	 * @author Vincent
	 * @param _xPath
	 *            XPath of web element
	 * @param _value
	 *            Value
	 * @return WebElementFacade
	 */
	public WebElementFacade waitTextToBePresentInElementValue(String _xPath,
			String _value) {
		waitForAllJSCompletes();
		waitFor(ExpectedConditions.textToBePresentInElementValue(
				By.xpath(_xPath), _value));
		return findBy(_xPath);
	}

	/**
	 * @Description Wait for given text to be present in element.
	 * @author Vincent
	 * @param _xPath
	 *            XPath of web element
	 * @param _value
	 *            Value
	 * @return WebElementFacade
	 */
	public WebElementFacade waitTextToBePresentInElement(String _xPath,
			String _value) {
		waitForAllJSCompletes();
		waitFor(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(_xPath), _value));
		return findBy(_xPath);
	}

	/**
	 * @Description Wait for element to be present.
	 * @author Vincent
	 * @param _xPath
	 * @return WebElementFacade
	 */
	public WebElementFacade waitElementToBePresent(String _xPath) {
		waitForAllJSCompletes();
		waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(_xPath)));
		return findBy(_xPath);
	}

	/**
	 * @Description Wait for element to be visible.
	 * @author Vincent
	 * @param _xPath
	 * @return WebElementFacade
	 */
	public WebElementFacade waitElementToBeVisible(String _xPath) {
		waitForAllJSCompletes();
		waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(_xPath)));
		return findBy(_xPath);
	}

	/**
	 * @Description Wait for element to be present then scroll into view of
	 *              element.
	 * @author Vincent
	 * @param _xPath
	 * @return WebElementFacade
	 */
	public WebElementFacade waitElementToBePresentThenScrollIntoView(
			String _xPath) {
		waitForAllJSCompletes();
		waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(_xPath)));
		scrollIntoElementView(_xPath);
		highlightElement(_xPath);
		return findBy(_xPath);
	}

	/**
	 * @Description Scroll into view of element.
	 * @author Vincent
	 * @param _xPath
	 */
	public void scrollIntoElementView(String _xPath) {
		((JavascriptExecutor) getDriver()).executeScript(
				"arguments[0].scrollIntoView(false);", findBy(_xPath));
		waitABit(15);
	}

	/**
	 * @Description Scroll into view of element.
	 * @author Vincent
	 * @param _wE
	 * @return WebElementFacade
	 */
	public WebElementFacade scrollIntoElementView(WebElementFacade _wE) {
		((JavascriptExecutor) getDriver()).executeScript(
				"arguments[0].scrollIntoView(false);", _wE);
		waitABit(15);
		return _wE;
	}

	/**
	 * @Description Wait for element to be clickable.
	 * @author Vincent
	 * @param _xPath
	 * @return WebElementFacade
	 */
	public WebElementFacade waitElementToBeClickable(String _xPath) {
		waitElementToBePresentThenScrollIntoView(_xPath);
		waitFor(ExpectedConditions.elementToBeClickable(By.xpath(_xPath)));
		highlightElement(_xPath);
		return findBy(_xPath);
	}

	/**
	 * @Description Wait for element to be input, type given value and enter
	 *              then wait for element update value and element change state
	 *              to read only.
	 * @author Vincent
	 * @param _xPath
	 *            XPath of web element
	 * @param _value
	 */
	public void waitTypeAndEnterThenUpdateValueReadOnly(String _xPath,
			String _value) {
		waitElementToBePresentThenScrollIntoView(
				_xPath
						+ "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]")
				.waitUntilEnabled().waitUntilVisible().typeAndEnter(_value);
		waitTextToBePresentInElementValue(
				_xPath
						+ "[@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled']",
				_value).shouldBePresent();
		// findBy(xPath).findBy("./self::*[@readonly='readonly']").shouldBePresent();
	}

	/**
	 * @Description Wait for element to be input, type given value and enter
	 *              then wait for element update value or error message display.
	 *              NOTE: if existed value equal to new value, it will keep
	 *              existed value.
	 * @author Vincent
	 * @param _xPath
	 * @param _value
	 */
	public String waitTypeAndEnterThenUpdateValueReadOnlyOrError(String _xPath,
			String _value) {
		String ret = "";
		if (!waitElementToBePresentThenScrollIntoView(_xPath).getTextValue()
				.equals(_value)) {
			waitElementToBePresentThenScrollIntoView(
					_xPath
							+ "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]")
					.waitUntilEnabled().waitUntilVisible().typeAndEnter(_value);
			_xPath += "[@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled']"
					+ "[@value='"
					+ _value
					+ "']|//div[text()='Error Message(s)' and @id='errorModalPanelHeader']/ancestor::table[1]//li[@class='error-message']";
			if (isElementVisible(_xPath, 1)) {
				ret = waitElementToBeVisible(_xPath).getText();
				if (ret.equals(_value)) {
					ret = "";
				}
			}
		}
		return ret;
	}

	/**
	 * @Description Wait for element to be input, type given value and enter
	 *              then wait for element update value and element change state
	 *              to link text.
	 * @author Vincent
	 * @param _xPath
	 * @param _value
	 */
	public void waitTypeAndEnterThenLink(String _xPath, String _value) {
		waitElementToBePresentThenScrollIntoView(
				_xPath
						+ "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]")
				.waitUntilEnabled().waitUntilVisible().typeAndEnter(_value);
		_xPath = _xPath.substring(0, _xPath.lastIndexOf("input"));
		waitElementToBePresent(_xPath + "a[text()='" + _value + "']")
				.shouldBePresent();
	}

	/**
	 * @Description Wait for element to be input, type given value and enter
	 *              then wait for element update value. NOTE: if existed value
	 *              equal to new value, it will keep existed value.
	 * @author Vincent
	 * @param _xPath
	 * @param _value
	 */
	public void waitTypeAndEnterThenUpdateValue(String _xPath, String _value) {
		if (!waitElementToBePresentThenScrollIntoView(_xPath).getTextValue()
				.equals(_value)) {
			waitElementToBePresentThenScrollIntoView(
					_xPath
							+ "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]")
					.waitUntilEnabled().waitUntilVisible().typeAndEnter(_value);
			waitTextToBePresentInElementValue(_xPath, _value);
		}
	}

	/**
	 * @Description Wait for element to be input, type given value and enter
	 *              then wait for element update value or error message display.
	 *              NOTE: if existed value equal to new value, it will keep
	 *              existed value.
	 * @author Vincent
	 * @param _xPath
	 * @param _value
	 */
	public String waitTypeAndEnterThenUpdateValueOrError(String _xPath,
			String _value) {
		String ret = "";
		if (!waitElementToBePresentThenScrollIntoView(_xPath).getTextValue()
				.equals(_value)) {
			waitElementToBePresentThenScrollIntoView(
					_xPath
							+ "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]")
					.waitUntilEnabled().waitUntilVisible().typeAndEnter(_value);
			_xPath += "[@value='"
					+ _value
					+ "']|//div[text()='Error Message(s)' and @id='errorModalPanelHeader']/ancestor::table[1]//li[@class='error-message']";
			ret = waitElementToBeVisible(_xPath).getText();
			if (ret.equals(_value)) {
				ret = "";
			}
		}
		return ret;
	}

	/**
	 * Using for lable auto Upper Value
	 * 
	 * @Description Wait for element to be input, type given value and enter
	 *              then wait for element update value. NOTE: if existed value
	 *              equal to new value, it will keep existed value.
	 * @author Nancy
	 * @param _xPath
	 * @param _value
	 */
	public void waitTypeAndEnterThenUpdateCodeValue(String _xPath, String _value) {
		if (!waitElementToBePresent(_xPath).getTextValue().equals(_value)) {
			waitElementToBePresentThenScrollIntoView(
					_xPath
							+ "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]")
					.waitUntilEnabled().waitUntilVisible().typeAndEnter(_value);
			waitTextToBePresentInElementValue(_xPath, _value.toUpperCase());
		}
	}

	/**
	 * @Description Wait for element to be input, type given value and enter
	 *              then wait for element change to no input element.
	 * @author Vincent
	 * @param _xPath
	 * @param _value
	 */
	public void waitTypeAndEnterThenNoInput(String _xPath, String _value) {
		waitElementToBePresentThenScrollIntoView(
				_xPath
						+ "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]")
				.waitUntilEnabled().waitUntilVisible().typeAndEnter(_value);
		_xPath = _xPath.substring(0, _xPath.lastIndexOf("//input"));
		waitTextToBePresentInElement(_xPath, _value);
	}

	/**
	 * @Description Wait for element to be input, type given value and tab then
	 *              wait for element update value. NOTE: if existed value equal
	 *              to new value, it will keep existed value.
	 * @author Vincent
	 * @param _xPath
	 * @param _value
	 */
	public void waitTypeAndTabThenUpdateValue(String _xPath, String _value) {
		if (!waitElementToBePresent(_xPath).getTextValue().equals(_value)) {
			waitElementToBePresentThenScrollIntoView(
					_xPath
							+ "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]")
					.waitUntilEnabled().waitUntilVisible().typeAndEnter(_value);
			waitTextToBePresentInElementValue(_xPath, _value);
		}
	}

	/**
	 * @Description Wait for element to be input, type given value and tab then
	 *              wait for element update text.
	 * @author Vincent
	 * @param _xPath
	 * @param _value
	 */
	public void waitTypeAndTabThenUpdateText(String _xPath, String _value) {
		waitElementToBePresentThenScrollIntoView(
				_xPath
						+ "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]")
				.waitUntilEnabled().waitUntilVisible().typeAndEnter(_value);
		waitTextToBePresentInElement(_xPath, _value);
	}

	/**
	 * @Description Wait for element to be input, type given value and tab then
	 *              wait for 0.5 second.
	 * @author Vincent
	 * @param _xPath
	 * @param _value
	 */
	public void waitTypeAndTab(String _xPath, String _value) {
		waitElementToBePresentThenScrollIntoView(
				_xPath
						+ "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]")
				.waitUntilEnabled().typeAndTab(_value);
		waitABit(500);
	}

	/**
	 * @Description Wait for element to be input, type given value and enter
	 *              then wait for 0.5 second.
	 * @author Vincent
	 * @param _xPath
	 * @param _value
	 */
	public void waitTypeAndEnter(String _xPath, String _value) {
		waitElementToBePresentThenScrollIntoView(
				_xPath
						+ "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]")
				.waitUntilEnabled().waitUntilVisible().typeAndEnter(_value);
		waitABit(500);
	}

	/**
	 * @Description Check for element exist or not with timeout.
	 * @author Vincent
	 * @param xPath
	 * @param _timeoutInSeconds
	 * @return boolean
	 */
	public boolean isElementExist(String xPath, int _timeoutInSeconds) {
		try {
			setImplicitTimeout(_timeoutInSeconds, TimeUnit.SECONDS);
			waitElementToBePresent("(" + xPath + ")[1]");
			resetImplicitTimeout();
			return true;
		} catch (Exception e) {
			resetImplicitTimeout();
		}
		return false;
	}

	/**
	 * @Description Check for element exist or not with timeout (Not wait for
	 *              A4J).
	 * @author Vincent
	 * @param xPath
	 * @param _timeoutInSeconds
	 * @return boolean
	 */
	public boolean isElementExistNoA4J(String xPath, int _timeoutInSeconds) {
		try {
			setImplicitTimeout(_timeoutInSeconds, TimeUnit.SECONDS);
			waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath("("
					+ xPath + ")[1]")));
			resetImplicitTimeout();
			return true;
		} catch (Exception e) {
			resetImplicitTimeout();
		}
		return false;
	}

	/**
	 * @Description Check for element visible or not with timeout (Not wait for
	 *              A4J).
	 * @author Vincent
	 * @param xPath
	 * @param _timeoutInSeconds
	 * @return boolean
	 */
	public boolean isElementVisibleNoA4J(String xPath, int _timeoutInSeconds) {
		try {
			setImplicitTimeout(_timeoutInSeconds, TimeUnit.SECONDS);
			waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("("
					+ xPath + ")[1]")));
			resetImplicitTimeout();
			return true;
		} catch (Exception e) {
			resetImplicitTimeout();
		}
		return false;
	}

	/**
	 * @Description Check for element visible or not with timeout.
	 * @author Vincent
	 * @param xPath
	 * @param _timeoutInSeconds
	 * @return boolean
	 */
	public boolean isElementVisible(String xPath, int _timeoutInSeconds) {
		try {
			setImplicitTimeout(_timeoutInSeconds, TimeUnit.SECONDS);
			waitElementToBeVisible("(" + xPath + ")[1]");
			resetImplicitTimeout();
			return true;
		} catch (Exception e) {
			resetImplicitTimeout();
		}
		return false;
	}

	/**
	 * @Description Check for element clickable or not with timeout.
	 * @author Vincent
	 * @param xPath
	 * @param _timeoutInSeconds
	 * @return boolean
	 */
	public boolean isElementClickable(String xPath, int _timeoutInSeconds) {
		try {
			setImplicitTimeout(_timeoutInSeconds, TimeUnit.SECONDS);
			waitElementToBeClickable("(" + xPath + ")[1]");
			resetImplicitTimeout();
			return true;
		} catch (Exception e) {
			resetImplicitTimeout();
		}
		return false;
	}

	/**
	 * @Description Check for element exist or not with default timeout is 2
	 *              seconds.
	 * @author Vincent
	 * @param xPath
	 * @return boolean
	 */
	public boolean isElementExist(String xPath) {
		return isElementExist(xPath, 2);
	}

	// #EndRegion#Common wait

	// #Region Drop Down List
	/**
	 * @Description Select Drop Down List option by text.
	 * @author Vincent
	 * @param _xPathDll
	 * @param _value
	 */
	public void selectDdlByText(String _xPathDll, String _value) {
		if (!waitElementToBeVisible(_xPathDll).getSelectedVisibleTextValue()
				.equals(_value)) {
			waitElementToBePresentThenScrollIntoView(_xPathDll)
					.selectByVisibleText(_value);
			waitForAllJSCompletes();
			waitElementToBePresent(_xPathDll).shouldContainSelectedOption(
					_value);
		}
	}

	/**
	 * @Description Get xPath of Drop Down List besides Label
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @param _resOrder
	 * @return
	 */
	public String xPathDdlWithLabel(String _parentXpath, String _labelName,
			int _resOrder) {
		return "(" + _parentXpath + "//td//descendant-or-self::*[text()='"
				+ _labelName
				+ "']/ancestor-or-self::td[1]/following-sibling::td//select)["
				+ _resOrder + "]";
	}

	/**
	 * @Description Get xPath of Drop Down List besides Label
	 * @author Vincent
	 * @param _labelName
	 * @param _resOrder
	 * @return
	 */
	public String xPathDdlWithLabel(String _labelName, int _resOrder) {
		return xPathDdlWithLabel("", _labelName, _resOrder);
	}

	/**
	 * @Description Get xPath of Drop Down List besides Label
	 * @author Vincent
	 * @param _labelName
	 * @return
	 */
	public String xPathDdlWithLabel(String _labelName) {
		return xPathDdlWithLabel("", _labelName, 1);
	}

	/**
	 * @Description Select option of Drop Down List besides Label by text.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @param _resOrder
	 * @param _value
	 */
	public void selectDdlWithLabelByText(String _parentXpath,
			String _labelName, int _resOrder, String _value) {
		selectDdlByText(xPathDdlWithLabel(_parentXpath, _labelName, _resOrder),
				_value);
	}

	/**
	 * @Description Select option of Drop Down List besides Label by text.
	 * @author Vincent
	 * @param _labelName
	 * @param _resOrder
	 * @param _value
	 */
	public void selectDdlWithLabelByText(String _labelName, int _resOrder,
			String _value) {
		selectDdlByText(xPathDdlWithLabel("", _labelName, _resOrder), _value);
	}

	/**
	 * @Description Select option of Drop Down List besides Label by text.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @param _value
	 */
	public void selectDdlWithLabelByText(String _parentXpath,
			String _labelName, String _value) {
		selectDdlByText(xPathDdlWithLabel(_parentXpath, _labelName, 1), _value);
	}

	/**
	 * @Description Select option of Drop Down List besides Label by text.
	 * @author Vincent
	 * @param _labelName
	 * @param _value
	 */
	public void selectDdlWithLabelByText(String _labelName, String _value) {
		selectDdlByText(xPathDdlWithLabel("", _labelName, 1), _value);
	}

	// #EndRegion Drop Down List

	// #Region Tab.
	// BEGIN: switch tab
	/**
	 * @Description Find tab by given tab name and parent xPath. Return first
	 *              element if find out more than one element.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _tabName
	 * @return WebElementFacade
	 */
	public WebElementFacade findTabWithTabName(String _parentXpath,
			String _tabName) {
		String xpath = "(" + _parentXpath + "//td[contains(text(),'" + _tabName
				+ "') and contains(@class,'rich-tab-header')])[1]";
		return waitElementToBePresentThenScrollIntoView(xpath);
	}

	/**
	 * @Description Find tab by given tab name, parent xPath and the order of
	 *              same element definition.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _tabName
	 * @param _tabOrder
	 * @return WebElementFacade
	 */
	public WebElementFacade findTabWithTabName(String _parentXpath,
			String _tabName, int _tabOrder) {
		String xpath = "(" + _parentXpath + "//td[contains(text(),'" + _tabName
				+ "') and contains(@class,'rich-tab-header')])[" + _tabOrder
				+ "]";
		return waitElementToBePresentThenScrollIntoView(xpath);
	}

	/**
	 * @Description Find tab by given tab name.Return first element if find out
	 *              more than one element.
	 * @author Vincent
	 * @param _tabName
	 * @return WebElementFacade
	 */
	public WebElementFacade findTabWithTabName(String _tabName) {
		String xpath = "(//td[contains(text(),'" + _tabName
				+ "') and contains(@class,'rich-tab-header')])[1]";
		return waitElementToBePresentThenScrollIntoView(xpath);
	}

	/**
	 * @Description Finding tab by given tab name and the order of same element
	 *              definition .
	 * @author Vincent
	 * @param _tabName
	 * @param _tabOrder
	 * @return WebElementFacade
	 */
	public WebElementFacade findTabWithTabName(String _tabName, int _tabOrder) {
		String xpath = "(//td[contains(text(),'" + _tabName
				+ "') and contains(@class,'rich-tab-header')])[" + _tabOrder
				+ "]";
		return waitElementToBePresentThenScrollIntoView(xpath);
	}

	/**
	 * @Description Finding active tab by given tab name and parent xPath.
	 *              Return first element if find out more than one element. This
	 *              uses for verify opened tab.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _tabName
	 * @return WebElementFacade
	 */
	public WebElementFacade findActiveTabWithTabName(String _parentXpath,
			String _tabName) {
		String xpath = "("
				+ _parentXpath
				+ "//td[contains(text(),'"
				+ _tabName
				+ "') and contains(@class,'rich-tab-header') and contains(@class,'rich-tab-active')])[1]";
		return waitElementToBePresentThenScrollIntoView(xpath);
	}

	/**
	 * @Description Finding active tab by given tab name. Return first element
	 *              if find out more than one element. This uses for verify
	 *              opened tab.
	 * @author Vincent
	 * @param _tabName
	 * @return WebElementFacade
	 */
	public WebElementFacade findActiveTabWithTabName(String _tabName) {
		String xpath = "(//td[contains(text(),'"
				+ _tabName
				+ "') and contains(@class,'rich-tab-header') and contains(@class,'rich-tab-active')])[1]";
		return waitElementToBePresentThenScrollIntoView(xpath);
	}

	/**
	 * @Description Finding active tab by given tab name and parent xPath and
	 *              the order of same element definition. This uses for verify
	 *              opened tab.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _tabName
	 * @param _tabOrder
	 * @return WebElementFacade
	 */
	public WebElementFacade findActiveTabWithTabName(String _parentXpath,
			String _tabName, int _tabOrder) {
		String xpath = _parentXpath + "(//td[contains(text(),'" + _tabName
				+ "') and contains(@class,'rich-tab-header')])[" + _tabOrder
				+ "][contains(@class,'rich-tab-active')]";
		return waitElementToBePresentThenScrollIntoView(xpath);
	}

	/**
	 * @Description Check current active tab
	 * @author Vincent
	 * @param _tabName
	 * @return
	 */
	public boolean isTabActive(String _tabName) {
		String xpath = "(//td[contains(text(),'"
				+ _tabName
				+ "') and contains(@class,'rich-tab-header') and contains(@class,'rich-tab-active')])[1]";
		return isElementExist(xpath, 1);
	}

	/**
	 * @Description Check current active tab
	 * @author Vincent
	 * @param _parentXpath
	 * @param _tabName
	 * @return
	 */
	public boolean isTabActive(String _parentXpath, String _tabName) {
		String xpath = "("
				+ _parentXpath
				+ "//td[contains(text(),'"
				+ _tabName
				+ "') and contains(@class,'rich-tab-header') and contains(@class,'rich-tab-active')])[1]";
		return isElementExist(xpath, 1);
	}

	/**
	 * @Description Finding active tab by given tab name and the order of same
	 *              element definition. This uses for verify opened tab.
	 * @author Vincent
	 * @param _tabName
	 * @param _tabOrder
	 * @return WebElementFacade
	 */
	public WebElementFacade findActiveTabWithTabName(String _tabName,
			int _tabOrder) {
		String xpath = "(//td[contains(text(),'" + _tabName
				+ "') and contains(@class,'rich-tab-header')])[" + _tabOrder
				+ "][contains(@class,'rich-tab-active')]";
		return waitElementToBePresentThenScrollIntoView(xpath);
	}

	/**
	 * @Description Switching to tab by given tab name and parent xPath. If
	 *              there are more than one tab have the same definition, first
	 *              tab will be switched to.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _tabName
	 */
	public void switch_to_tab(String _parentXpath, String _tabName) {
		findTabWithTabName(_parentXpath, _tabName).waitUntilClickable().click();
		findActiveTabWithTabName(_parentXpath, _tabName).shouldBePresent();
	}

	/**
	 * @Description Switching to tab by given tab name. If there are more than
	 *              one tab have the same definition, first tab will be switched
	 *              to.
	 * @author Vincent
	 * @param _tabName
	 */
	public void switch_to_tab(String _tabName) {
		findTabWithTabName(_tabName).waitUntilClickable().click();
		findActiveTabWithTabName(_tabName).shouldBePresent();
	}

	/**
	 * @Description Switching to tab by given tab name, parent xPath and the
	 *              order of same tab definition.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _tabName
	 * @param _tabOrder
	 */
	public void switch_to_tab(String _parentXpath, String _tabName,
			int _tabOrder) {
		findTabWithTabName(_parentXpath, _tabName, _tabOrder)
				.waitUntilClickable().click();
		findActiveTabWithTabName(_parentXpath, _tabName, _tabOrder)
				.shouldBePresent();
	}

	/**
	 * @Description Switching to tab by given tab name and the order of same tab
	 *              definition.
	 * @author Vincent
	 * @param _tabName
	 * @param _tabOrder
	 */
	public void switch_to_tab(String _tabName, int _tabOrder) {
		findTabWithTabName(_tabName, _tabOrder).waitUntilClickable().click();
		findActiveTabWithTabName(_tabName, _tabOrder).shouldBePresent();
	}

	// END: switch tab
	// #EndRegion Tab.

	// #Region Button.
	/**
	 * @Description xPath of Button by button name
	 * @author Vincent
	 * @param _parentXpath
	 * @param _btnName
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathBtn(String _parentXpath, String _btnName, int _resOrder) {
		String xPath = "("
				+ _parentXpath
				+ "//input[@value='"
				+ _btnName
				+ "' and (@type='button'or @class='button' or @type='submit')])["
				+ _resOrder + "]";
		return xPath;
	}

	/**
	 * @Description xPath of Button by button name
	 * @author Vincent
	 * @param _parentXpath
	 * @param _btnName
	 * @return xPath
	 */
	public String xPathBtn(String _parentXpath, String _btnName) {
		return xPathBtn(_parentXpath, _btnName, 1);
	}

	/**
	 * @Description xPath of Button by button name
	 * @author Vincent
	 * @param _btnName
	 * @return xPath
	 */
	public String xPathBtn(String _btnName) {
		return xPathBtn("", _btnName, 1);
	}

	/**
	 * @Description xPath of Button by button name
	 * @author Vincent
	 * @param _btnName
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathBtn(String _btnName, int _resOrder) {
		return xPathBtn("", _btnName, _resOrder);
	}

	/**
	 * @Description Finding button by button name
	 * @author Vincent
	 * @param _parentXpath
	 * @param _btnName
	 * @param _resOrder
	 * @return WebElementFacade
	 */
	public WebElementFacade findBtn(String _parentXpath, String _btnName,
			int _resOrder) {
		return waitElementToBePresentThenScrollIntoView(xPathBtn(_parentXpath,
				_btnName, _resOrder));
	}

	/**
	 * @Description Finding button by button name
	 * @author Vincent
	 * @param _btnName
	 * @return WebElementFacade
	 */
	public WebElementFacade findBtn(String _btnName) {
		return waitElementToBePresentThenScrollIntoView(xPathBtn(_btnName));
	}

	/**
	 * @Description Finding button by button name
	 * @author Vincent
	 * @param _btnName
	 * @param _resOrder
	 * @return WebElementFacade
	 */
	public WebElementFacade findBtn(String _btnName, int _resOrder) {
		return waitElementToBePresentThenScrollIntoView(xPathBtn(_btnName,
				_resOrder));
	}

	/**
	 * @Description Finding button by button name
	 * @author Vincent
	 * @param _parentXpath
	 * @param _btnName
	 * @return WebElementFacade
	 */
	public WebElementFacade findBtn(String _parentXpath, String _btnName) {
		return waitElementToBePresentThenScrollIntoView(xPathBtn(_parentXpath,
				_btnName));
	}

	/**
	 * @Description Click on button by button name
	 * @author Vincent
	 * @param _btnName
	 */
	public void clickBtn(String _parentXpath, String _btnName, int _resOrder) {
		waitElementToBeClickable(xPathBtn(_parentXpath, _btnName, _resOrder))
				.click();
	}

	/**
	 * @Description Click on button by button name
	 * @author Vincent
	 * @param _btnName
	 */
	public void clickBtn(String _btnName) {
		clickBtn("", _btnName, 1);
	}

	/**
	 * @Description Click on button by button name
	 * @author Vincent
	 * @param _btnName
	 * @param _resOrder
	 */
	public void clickBtn(String _btnName, int _resOrder) {
		clickBtn("", _btnName, _resOrder);
	}

	/**
	 * @Description Click on button by button name
	 * @author Vincent
	 * @param _parentXpath
	 * @param _btnName
	 */
	public void clickBtn(String _parentXpath, String _btnName) {
		clickBtn(_parentXpath, _btnName, 1);
	}

	// #EndRegion Button

	// #Region Input Field, TEXT AREA with Label and Search Icon
	/**
	 * @Description xPath of Input Field besides Label
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathInputFieldWithLabel(String _parentXpath,
			String _labelName, int _resOrder) {
		return "("
				+ _parentXpath
				+ "//td//descendant-or-self::*["
				+ sSpecialTextPredicates(_labelName)
				+ "]/ancestor-or-self::td[1]/following-sibling::td//input[@type='text'])["
				+ _resOrder + "]";
	}

	/**
	 * @Description xPath of Input Field besides Fixed Label (by length)
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @return xPath
	 */
	public String xPathInputFieldWithFixedLabel(String _parentXpath,
			String _labelName) {
		return "("
				+ _parentXpath
				+ "//td//descendant-or-self::*["
				+ sSpecialTextPredicates(_labelName)
				+ "][string-length()<="
				+ _labelName.length()
				+ "]/ancestor-or-self::td[1]/following-sibling::td//input[@type='text'])[1]";
	}

	/**
	 * @Description xPath of Input Field besides Label
	 * @author Vincent
	 * @param _labelName
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathInputFieldWithLabel(String _labelName, int _resOrder) {
		return xPathInputFieldWithLabel("", _labelName, _resOrder);
	}

	/**
	 * @Description xPath of Input Field besides Label
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @return xPath
	 */
	public String xPathInputFieldWithLabel(String _parentXpath,
			String _labelName) {
		return xPathInputFieldWithLabel(_parentXpath, _labelName, 1);
	}

	/**
	 * @Description xPath of Input Field besides Label
	 * @author Vincent
	 * @param _labelName
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathInputFieldWithLabel(String _labelName) {
		return xPathInputFieldWithLabel("", _labelName, 1);
	}

	/**
	 * @Description xPath of Input Text Area besides Label
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathInputTextAreaWithLabel(String _parentXpath,
			String _labelName, int _resOrder) {
		return "(" + _parentXpath + "//td//descendant-or-self::*["
				+ sSpecialTextPredicates(_labelName)
				+ "]/ancestor-or-self::td[1]/following-sibling::td//textarea)["
				+ _resOrder + "]";
	}

	/**
	 * @Description xPath of Input Text Area besides Label
	 * @author Vincent
	 * @param _labelName
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathInputTextAreaWithLabel(String _labelName, int _resOrder) {
		return xPathInputTextAreaWithLabel("", _labelName, _resOrder);
	}

	/**
	 * @Description xPath of Input Text Area besides Label
	 * @author Vincent
	 * @param _labelName
	 * @return xPath
	 */
	public String xPathInputTextAreaWithLabel(String _labelName) {
		return xPathInputTextAreaWithLabel("", _labelName, 1);
	}

	/**
	 * @Description xPath of Calendar selector besides Label
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathCalendarWithLabel(String _parentXpath,
			String _labelName, int _resOrder) {
		return "("
				+ _parentXpath
				+ "//td//descendant-or-self::*["
				+ sSpecialTextPredicates(_labelName)
				+ "]/ancestor-or-self::td[1]/following-sibling::td//img[@class='rich-calendar-button'])["
				+ _resOrder + "]";
	}

	/**
	 * @Description xPath of Calendar selector besides Label
	 * @author Vincent
	 * @param _labelName
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathCalendarWithLabel(String _labelName, int _resOrder) {
		return xPathSearchIconWithLabel("", _labelName, _resOrder);
	}

	/**
	 * @Description xPath of Calendar selector besides Label
	 * @author Vincent
	 * @param _labelName
	 * @return xPath
	 */
	public String xPathCalendarWithLabel(String _labelName) {
		return xPathCalendarWithLabel("", _labelName, 1);
	}

	/**
	 * @Description xPath of Remarks Icon besides Label
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @param _labelResOrder
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathRemarksWithLabel(String _parentXpath, String _labelName,
			int _labelResOrder, int _resOrder) {
		return "("
				+ _parentXpath
				+ "//td//descendant-or-self::*["
				+ sSpecialTextPredicates(_labelName)
				+ "]/ancestor-or-self::td["
				+ _labelResOrder
				+ "]/following-sibling::td//img[contains(@src,'remarks.gif')])["
				+ _resOrder + "]";
	}

	/**
	 * @Description xPath of Search Icon besides Label
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathSearchIconWithLabel(String _parentXpath,
			String _labelName, int _resOrder) {
		return "("
				+ _parentXpath
				+ "//td//descendant-or-self::*["
				+ sSpecialTextPredicates(_labelName)
				+ "]/ancestor-or-self::td[1]/following-sibling::td//img[contains(@src, 'lookup')])["
				+ _resOrder + "]";
	}

	/**
	 * @Description xPath of Search Icon besides Label
	 * @author Vincent
	 * @param _labelName
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathSearchIconWithLabel(String _labelName, int _resOrder) {
		return xPathSearchIconWithLabel("", _labelName, _resOrder);
	}

	/**
	 * @Description xPath of Text besides Label
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathTextWithLabel(String _parentXpath, String _labelName,
			int _resOrder) {
		if (_parentXpath.isEmpty()) {
			return "(//*[contains(@id,'main') or contains(@id,'mainPnl')]//td//descendant-or-self::*["
					+ sSpecialTextPredicates(_labelName)
					+ "]/ancestor-or-self::td[1]/following-sibling::td)["
					+ _resOrder + "]/descendant-or-self::*[last()]";
		} else {
			return "(" + _parentXpath + "//td//descendant-or-self::*["
					+ sSpecialTextPredicates(_labelName)
					+ "]/ancestor-or-self::td[1]/following-sibling::td)["
					+ _resOrder + "]/descendant-or-self::*[last()]";
		}
	}

	/**
	 * @Description xPath of Text besides Label
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @return xPath
	 */
	public String xPathTextWithLabel(String _parentXpath, String _labelName) {
		return xPathTextWithLabel(_parentXpath, _labelName, 1);
	}

	/**
	 * @Description xPath of Text besides Label
	 * @author Vincent
	 * @param _labelName
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathTextWithLabel(String _labelName, int _resOrder) {
		return xPathTextWithLabel("", _labelName, _resOrder);
	}

	/**
	 * @Description xPath of Text besides Label
	 * @author Vincent
	 * @param _labelName
	 * @return xPath
	 */
	public String xPathTextWithLabel(String _labelName) {
		return xPathTextWithLabel("", _labelName, 1);
	}

	/**
	 * @Description Get Text besides Label
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @param _resOrder
	 * @return String
	 */
	public String getTextWithLabel(String _parentXpath, String _labelName,
			int _resOrder) {
		return waitElementToBePresent(
				xPathTextWithLabel(_parentXpath, _labelName, _resOrder))
				.getText();
	}

	/**
	 * @Description Get Text Value besides Label
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @param _resOrder
	 * @return String
	 */
	public String getTextValueWithLabel(String _parentXpath, String _labelName,
			int _resOrder) {
		return waitElementToBePresent(
				xPathTextWithLabel(_parentXpath, _labelName, _resOrder))
				.getTextValue();
	}

	/**
	 * @Description Get Text besides Label
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @return String
	 */
	public String getTextWithLabel(String _parentXpath, String _labelName) {
		return waitElementToBePresent(
				xPathTextWithLabel(_parentXpath, _labelName, 1)).getText();
	}

	/**
	 * @Description Get Text besides Label
	 * @author Vincent
	 * @param _labelName
	 * @param _resOrder
	 * @return String
	 */
	public String getTextWithLabel(String _labelName, int _resOrder) {
		return waitElementToBePresent(
				xPathTextWithLabel("", _labelName, _resOrder)).getText();
	}

	/**
	 * @Description Get Text Value besides Label
	 * @author Vincent
	 * @param _labelName
	 * @param _resOrder
	 * @return String
	 */
	public String getTextValueWithLabel(String _labelName, int _resOrder) {
		return waitElementToBePresent(
				xPathTextWithLabel("", _labelName, _resOrder)).getTextValue();
	}

	/**
	 * @Description Get Text Value besides Label
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @return String
	 */
	public String getTextValueWithLabel(String _parentXpath, String _labelName) {
		return waitElementToBePresent(
				xPathTextWithLabel(_parentXpath, _labelName, 1)).getTextValue();
	}

	/**
	 * @Description Get Text besides Label
	 * @author Vincent
	 * @param _labelName
	 * @return String
	 */
	public String getTextWithLabel(String _labelName) {
		return waitElementToBePresent(xPathTextWithLabel(_labelName)).getText();
	}

	/**
	 * @Description Get Text besides Label
	 * @author Vincent
	 * @param _labelName
	 * @return String
	 */
	public String getTextValueWithLabel(String _labelName) {
		return waitElementToBePresent(xPathTextWithLabel(_labelName))
				.getTextValue();
	}

	/**
	 * @Description Enter value into Text Area besides Label, tab then wait in
	 *              0.5 second.
	 * @author Vincent
	 * @param _labelName
	 * @param _value
	 */
	public void enterTextAreaWithLabel(String _labelName, String _value) {
		waitTypeAndTab(xPathInputTextAreaWithLabel(_labelName, 1), _value);
	}

	/**
	 * @Description Enter value into Text Area besides Label, tab then wait in
	 *              0.5 second.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @param _value
	 */
	public void enterTextAreaWithLabel(String _parentXpath, String _labelName,
			String _value) {
		waitTypeAndTab(
				xPathInputTextAreaWithLabel(_parentXpath, _labelName, 1),
				_value);
	}

	/**
	 * @Description Enter value into Input Field besides Label, enter then wait
	 *              for updating value.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @param _value
	 * @param _resOrder
	 */
	public void enterInputFieldWithLabel(String _parentXpath,
			String _labelName, String _value, int _resOrder) {
		waitTypeAndEnterThenUpdateValue(
				xPathInputFieldWithLabel(_parentXpath, _labelName, _resOrder),
				_value);
	}

	/**
	 * @Description Enter value into Input Field besides Label, enter then wait
	 *              for updating value.
	 * @author Vincent
	 * @param _labelName
	 * @param _value
	 */
	public void enterInputFieldWithLabel(String _labelName, String _value) {
		waitTypeAndEnterThenUpdateValue(
				xPathInputFieldWithLabel(_labelName, 1), _value);
	}

	/**
	 * @Description Enter value into Input Field besides Label, no wait for
	 *              update value
	 * @author Henry
	 * @param _labelName
	 * @param _value
	 */
	public void enterInputFieldWithLabelAndNoUpdate(String _labelName,
			String _value) {
		waitTypeAndEnter(xPathInputFieldWithLabel(_labelName, 1), _value);
	}

	/**
	 * @Description Enter value into Input Field besides Label, enter then wait
	 *              for updating value.
	 * @author Vincent
	 * @param _labelName
	 * @param _value
	 * @param _resOrder
	 */
	public void enterInputFieldWithLabel(String _labelName, String _value,
			int _resOrder) {
		waitTypeAndEnterThenUpdateValue(
				xPathInputFieldWithLabel(_labelName, _resOrder), _value);
	}

	/**
	 * @Description Enter value into Input Field besides Label, enter then wait
	 *              for updating value.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @param _value
	 */
	public void enterInputFieldWithLabel(String _parentXpath,
			String _labelName, String _value) {
		waitTypeAndEnterThenUpdateValue(
				xPathInputFieldWithLabel(_parentXpath, _labelName, 1), _value);
	}

	/**
	 * Using for lable auto Upper Value
	 * 
	 * @Description Enter value into Input Field besides Label, enter then wait
	 *              for updating value.
	 * @author Nancy
	 * @param _parentXpath
	 * @param _labelName
	 * @param _value
	 */
	public void enterInputFieldCodeWithLabel(String _parentXpath,
			String _labelName, String _value) {
		waitTypeAndEnterThenUpdateValue(
				xPathInputFieldWithLabel(_parentXpath, _labelName, 1),
				_value.toUpperCase());
	}

	/**
	 * @Description Click on Search Icon besides Label
	 * @author Vincent
	 * @param _labelName
	 */
	public void clickSearchIconWithLabel(String _labelName) {
		waitElementToBePresent(xPathSearchIconWithLabel(_labelName, 1))
				.waitUntilClickable().click();
	}

	/**
	 * @Description Click on Search Icon besides Label
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 */
	public void clickSearchIconWithLabel(String _parentXpath, String _labelName) {
		clickOnElement(xPathSearchIconWithLabel(_parentXpath, _labelName, 1));
	}

	/**
	 * @Description Click on Search Icon besides Label
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @param _resOrder
	 */
	public void clickSearchIconWithLabel(String _parentXpath,
			String _labelName, int _resOrder) {
		clickOnElement(xPathSearchIconWithLabel(_parentXpath, _labelName,
				_resOrder));
	}

	/**
	 * Using with the lable auto UPPER text
	 * 
	 * @author Nancy
	 * @param _labelName
	 * @param _value
	 */
	public void enterInputFieldCodeWithLabel(String _labelName, String _value) {
		String xPath = xPathInputFieldWithLabel(_labelName, 1);
		waitElementToBePresentThenScrollIntoView(
				xPath
						+ "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]")
				.waitUntilEnabled().waitUntilVisible().typeAndEnter(_value);
		waitElementToBePresent(xPath);
		waitFor(ExpectedConditions.textToBePresentInElementValue(
				By.xpath(xPath), _value.toUpperCase()));
	}

	/**
	 * Using with the lable auto UPPER text, No verify after fill text to lable
	 * 
	 * @author Nancy
	 * @param _labelName
	 * @param _value
	 */
	public void enterInputFieldWithLabelNoVerify(String _labelName,
			String _value) {
		String xPath = xPathInputFieldWithLabel(_labelName, 1);
		waitElementToBePresentThenScrollIntoView(
				xPath
						+ "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]")
				.waitUntilEnabled().waitUntilVisible().typeAndEnter(_value);
		waitElementToBePresent(xPath);
	}

	public void enterInputFieldWithLabelNoVerify(String _xPathParent,
			String _labelName, String _value) {
		String xPath = xPathInputFieldWithLabel(_xPathParent, _labelName, 1);
		waitElementToBePresentThenScrollIntoView(
				xPath
						+ "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]")
				.waitUntilEnabled().waitUntilVisible().typeAndEnter(_value);
		waitElementToBePresent(xPath);
	}

	// #EndRegion Input Field with Label and Search Icon

	// #Region Radio Button with Label
	/**
	 * @Description xPath of Radio Button besides Label or Text.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathRadioBtnWithLabel(String _parentXpath,
			String _labelName, int _resOrder) {
		String xpath = "(" + _parentXpath + "//*["
				+ sSpecialTextPredicates(_labelName)
				+ "]//preceding::input[contains(@type,'radio')][1])["
				+ _resOrder + "]";
		return xpath;
	}

	/**
	 * @Description xPath of Radio Button besides Label or Text.
	 * @author Vincent
	 * @param _labelName
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathRadioBtnWithLabel(String _labelName, int _resOrder) {
		return xPathRadioBtnWithLabel("", _labelName, _resOrder);
	}

	/**
	 * @Description xPath of Radio Button besides Label or Text.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @return xPath
	 */
	public String xPathRadioBtnWithLabel(String _parentXpath, String _labelName) {
		return xPathRadioBtnWithLabel(_parentXpath, _labelName, 1);
	}

	/**
	 * @Description xPath of Radio Button besides Label or Text.
	 * @author Vincent
	 * @param _labelName
	 * @return xPath
	 */
	public String xPathRadioBtnWithLabel(String _labelName) {
		return xPathRadioBtnWithLabel("", _labelName, 1);
	}

	/**
	 * @Description Finding Radio Button besides Label or Text.
	 * @author Vincent
	 * @param _labelName
	 * @return WebElementFacade
	 */
	public WebElementFacade findRadioBtnByLabel(String _labelName) {
		return waitElementToBePresentThenScrollIntoView(xPathRadioBtnWithLabel(
				"", _labelName, 1));
	}

	/**
	 * @Description Finding Radio Button besides Label or Text.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _labelName
	 * @return WebElementFacade
	 */
	public WebElementFacade findRadioBtnByLabel(String _parentXpath,
			String _labelName) {
		return waitElementToBePresentThenScrollIntoView(xPathRadioBtnWithLabel(
				_parentXpath, _labelName, 1));
	}

	public WebElementFacade findRadioBtnByLabel(WebElementFacade _wEParent,
			String _radioBtnLabel) {
		return _wEParent.findBy(".//*["
				+ sSpecialTextPredicates(_radioBtnLabel)
				+ "]//preceding::input[contains(@type,'radio')][1]");
	}

	public void selectRadioButton(WebElementFacade wE) {
		waitForAllJSCompletes();
		wE.waitUntilPresent().waitUntilClickable().click();
	}

	/**
	 * @Description Select Radio Button By xPath
	 * @author Vincent
	 * @param _xPathRadioBtn
	 */
	public void selectRadioButton(String _xPathRadioBtn) {
		WebElementFacade wE = waitElementToBeClickable(_xPathRadioBtn);
		highlightElement(_xPathRadioBtn + "//ancestor-or-self::td[1]");
		wE.click();
		waitElementToBePresent(_xPathRadioBtn);
	}

	/**
	 * @Description xPath of Radio Button insides Group of Radio Button
	 * @author Vincent
	 * @param _parentXpath
	 * @param _groupLabelName
	 * @param _labelName
	 * @return xPath
	 */
	public String xPathRadioBtnWithGroupLabel(String _parentXpath,
			String _groupLabelName, String _labelName) {
		String xPath = _parentXpath + "//td//descendant-or-self::*["
				+ sSpecialTextPredicates(_groupLabelName)
				+ "]//ancestor-or-self::td[1]//following-sibling::td//*["
				+ sSpecialTextPredicates(_labelName)
				+ "]//preceding::input[contains(@type,'radio')][1]";
		return xPath;
	}

	/**
	 * @Description xPath of Radio Button insides Group of Radio Button
	 * @author Vincent
	 * @param _parentXpath
	 * @param _groupLabelName
	 * @param _groupLabelResIndex
	 * @param _labelName
	 * @return xPath
	 */
	public String xPathRadioBtnWithGroupLabel(String _parentXpath,
			String _groupLabelName, int _groupLabelResIndex, String _labelName) {
		String xPath = _parentXpath + "//td//descendant-or-self::*["
				+ sSpecialTextPredicates(_groupLabelName)
				+ "]//ancestor-or-self::td[" + _groupLabelResIndex
				+ "]//following-sibling::td//*["
				+ sSpecialTextPredicates(_labelName)
				+ "]//preceding::input[contains(@type,'radio')][1]";
		return xPath;
	}

	/**
	 * @Description xPath of Radio Button insides Group of Radio Button
	 * @author Vincent
	 * @param _groupLabelName
	 * @param _labelName
	 * @return xPath
	 */
	public String xPathRadioBtnWithGroupLabel(String _groupLabelName,
			String _labelName) {
		return xPathRadioBtnWithGroupLabel("", _groupLabelName, _labelName);
	}

	/**
	 * @Description Finding Radio Button insides Group of Radio Button
	 * @author Vincent
	 * @param _groupLabelName
	 * @param _labelName
	 * @return WebElementFacade
	 */
	public WebElementFacade findRadioBtnByGroupLabel(String _groupLabelName,
			String _labelName) {
		waitElementToBePresentThenScrollIntoView(xPathRadioBtnWithGroupLabel(
				_groupLabelName, _labelName));
		return findBy(xPathRadioBtnWithGroupLabel(_groupLabelName, _labelName));
	}

	/**
	 * @Description Finding Radio Button insides Group of Radio Button
	 * @author Vincent
	 * @param _parentXpath
	 * @param _groupLabelName
	 * @param _labelName
	 * @return WebElementFacade
	 */
	public WebElementFacade findRadioBtnByGroupLabel(String _parentXpath,
			String _groupLabelName, String _labelName) {
		return waitElementToBePresentThenScrollIntoView(xPathRadioBtnWithGroupLabel(
				_parentXpath, _groupLabelName, _labelName));
	}

	/**
	 * @Description Select Radio Button insides Group of Radio Button. NOTE:
	 *              some radio button not change value after click, use other
	 *              function.
	 * @author Vincent
	 * @param _groupLabelName
	 * @param _radioBtnLabel
	 */
	public void selectRadioButton(String _groupLabelName, String _radioBtnLabel) {
		selectRadioButton(xPathRadioBtnWithGroupLabel(_groupLabelName,
				_radioBtnLabel));
	}

	/**
	 * @Description Select Radio Button insides Group of Radio Button. NOTE:
	 *              some radio button not change value after click, use other
	 *              function.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _groupLabelName
	 * @param _radioBtnLabel
	 */
	public void selectRadioButton(String _parentXpath, String _groupLabelName,
			String _radioBtnLabel) {
		selectRadioButton(xPathRadioBtnWithGroupLabel(_parentXpath,
				_groupLabelName, _radioBtnLabel));
	}

	// #EndRegion Radio Button with Label

	// #Region Check Box
	/**
	 * @Description Check the Check Box.
	 * @author Vincent
	 * @param _xPathCheckBox
	 */
	public void checkChkbox(String _xPathCheckBox) {
		if (waitElementToBePresent(_xPathCheckBox).getAttribute("checked") == null) {
			highlightElement(_xPathCheckBox + "//ancestor-or-self::td[1]");
			clickOnElement(_xPathCheckBox);
			waitElementToBePresent(_xPathCheckBox + "[@checked='checked']")
					.shouldBeVisible();
		} else {
			highlightElement(_xPathCheckBox + "//ancestor-or-self::td[1]");
		}
	}

	/**
	 * @Description Uncheck the Check Box.
	 * @author Vincent
	 * @param _xPathCheckBox
	 */
	public void uncheckChkbox(String _xPathCheckBox) {
		if (waitElementToBePresent(_xPathCheckBox).getAttribute("checked") != null) {
			highlightElement(_xPathCheckBox + "//ancestor-or-self::td[1]");
			clickOnElement(_xPathCheckBox);
			waitElementToBePresent(
					_xPathCheckBox + "[not (@checked='checked')]")
					.shouldBeVisible();
		} else {
			highlightElement(_xPathCheckBox + "//ancestor-or-self::td[1]");
		}
	}

	/**
	 * @Description Set Check Box into checked or unchecked by given
	 *              value.[true|yes] means checked and otherwise.
	 * @author Vincent
	 * @param _xPathCheckBox
	 * @param _value
	 */
	public void setChkbox(String _xPathCheckBox, String _value) {
		if (_value.toLowerCase().equals("true")
				|| _value.toLowerCase().equals("yes")
				|| _value.toLowerCase().equals("y")) {
			checkChkbox(_xPathCheckBox);
		} else {
			uncheckChkbox(_xPathCheckBox);
		}
	}

	/**
	 * @Description xPath of Check Box insides Group of Check Box.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _groupLabelName
	 * @param _chkboxLabel
	 * @return xPath
	 */
	public String xPathChkboxWithGroupLabel(String _parentXpath,
			String _groupLabelName, String _chkboxLabel) {
		String xPath = _parentXpath
				+ "//td//descendant-or-self::*["
				+ sSpecialTextPredicates(_groupLabelName)
				+ "]//ancestor-or-self::td[1]/following-sibling::td//input[following::text()='"
				+ _chkboxLabel + "'][contains(@type,'checkbox')]";
		if (_chkboxLabel.isEmpty()) {
			xPath = _parentXpath
					+ "//td//descendant-or-self::*["
					+ sSpecialTextPredicates(_groupLabelName)
					+ "]//ancestor-or-self::td[1]/following-sibling::td//input[contains(@type,'checkbox')]";
		}
		return "(" + xPath + ")[last()]";
	}

	/**
	 * @Description xPath of Check Box inside Group of Check Box.
	 * @author Vincent
	 * @param _groupLabelName
	 * @param _chkboxLabel
	 * @return xPath
	 */
	public String xPathChkboxWithGroupLabel(String _groupLabelName,
			String _chkboxLabel) {
		return xPathChkboxWithGroupLabel("", _groupLabelName, _chkboxLabel);
	}

	/**
	 * @Description xPath of Check Box besides Label.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _chkboxLabel
	 * @param _resOrder
	 * @return
	 */
	public String xPathChkboxWithLabel(String _parentXpath,
			String _chkboxLabel, int _resOrder) {
		String xpath = "(" + _parentXpath + "//*["
				+ sSpecialTextPredicates(_chkboxLabel)
				+ "]//preceding::input[contains(@type,'checkbox')][1])["
				+ _resOrder + "]";
		return xpath;
	}

	/**
	 * @Description xPath of Check Box besides Label.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _chkboxLabel
	 * @return
	 */
	public String xPathChkboxWithLabel(String _parentXpath, String _chkboxLabel) {
		return xPathChkboxWithLabel(_parentXpath, _chkboxLabel, 1);
	}

	/**
	 * @Description xPath of Check Box besides Label.
	 * @author Vincent
	 * @param _chkboxLabel
	 * @return
	 */
	public String xPathChkboxWithLabel(String _chkboxLabel) {
		return xPathChkboxWithLabel("", _chkboxLabel, 1);
	}

	// #EndRegion Check Box

	// #Region Confirm Message - Error Message - InforPanel Message.
	// BEGIN: Confirm Update?
	// @author: Vincent
	private String xPathPanelConfirmUpdate = "//div[text()='Confirm Update?' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";
	private String xPathBtnYesConfirmUpdate = "//div[text()='Confirm Update?' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]//input[@type='button' and @value='Yes']";
	private String btnNoConfirmUpdate = "//div[text()='Confirm Update?' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]//input[@type='button' and @value='No']";

	public void clickBtnYesOnConfirmUpdate() {
		waitElementToBePresent(xPathPanelConfirmUpdate).shouldBeVisible();
		waitElementToBeClickable(xPathBtnYesConfirmUpdate).click();
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmUpdate);
	}

	public void clickBtnNoOnConfirmUpdate() {
		waitElementToBePresent(xPathPanelConfirmUpdate).shouldBeVisible();
		waitElementToBePresentThenScrollIntoView(btnNoConfirmUpdate).click();
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmUpdate);
	}

	// END: Confirm Update?
	// BEGIN: Confirm Delete?
	// @author: Vincent
	private String xPathPanelConfirmDelete = "//div[contains(text(),'Delete') and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";

	public void clickBtnYesOnConfirmDelete() {
		waitElementToBePresent(xPathPanelConfirmDelete).shouldBeVisible();
		clickBtn(xPathPanelConfirmDelete, "Yes");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmDelete);
	}

	public void clickBtnNoOnConfirmDelete() {
		waitElementToBePresent(xPathPanelConfirmDelete).shouldBeVisible();
		clickBtn(xPathPanelConfirmDelete, "No");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPanelConfirmDelete);
	}

	// END: Confirm Delete?
	// BEGIN: Info Panel
	// @author: Vincent
	@FindBy(xpath = "//div[text()='Info Panel'][@id='StatusMessagePopupHeader']/ancestor::table[1]")
	private WebElementFacade infoPanel;
	// @FindBy(xpath = "//div[text()='Info
	// Panel'][@id='StatusMessagePopupHeader']/ancestor::table[1]//span[@class='rich-messages-label']")
	@FindBy(xpath = "//div[text()='Info Panel'][@id='StatusMessagePopupHeader']/ancestor::table[1]//span")
	private List<WebElementFacade> infoPanelMessages;

	@FindBy(xpath = "//div[text()='Info Panel'][@id='StatusMessagePopupHeader']/ancestor::table[1]//input[@type='button' and @value='OK']")
	private WebElementFacade btnOkInfoPanel;

	public String getInfoPanelMessagesThenClickOK() {
		setImplicitTimeout(2, TimeUnit.SECONDS);
		if (infoPanel.isVisible()) {
			String message = "";
			for (WebElementFacade el : infoPanelMessages) {
				message += el.getText() + System.getProperty("line.separator");
			}
			btnOkInfoPanel.click();
			setImplicitTimeout(5, TimeUnit.SECONDS);
			LogWork.log_debug(message);
			return message;
		} else {
			setImplicitTimeout(5, TimeUnit.SECONDS);
			return null;
		}
	}

	public void chooseOkOnInforPanel() {
		btnOkInfoPanel.click();
	}

	// END: Info Panel
	// BEGIN: Error Message(s)
	private String xPathPanelErrorMessages = "//div[text()='Error Message(s)' and @id='errorModalPanelHeader']/ancestor::table[1]";

	@FindBy(xpath = "//div[text()='Error Message(s)' and @id='errorModalPanelHeader']/ancestor::table[1]//li[@class='error-message']")
	private List<WebElementFacade> contentErrorMessages;

	@FindBy(xpath = "//div[text()='Error Message(s)' and @id='errorModalPanelHeader']/ancestor::table[1]//input[@value='OK' and @type='button']")
	private WebElementFacade btnOKErrorMessages;

	public String getErrorMessagesThenClickOK() {
		if (isElementVisible(xPathPanelErrorMessages, 1)) {
			String message = "";
			for (WebElementFacade el : contentErrorMessages) {
				message += el.getText() + System.getProperty("line.separator");
			}
			btnOKErrorMessages.click();
			LogWork.log_debug("***** INFO ***** Error Message: " + message);

			return message;
		} else {
			return null;
		}
	}

	// END: Error Message(s)
	@FindBy(id = "confirmationPanel_Form:confirmationPanel_YesButton")
	public WebElementFacade yesBtn;

	/**
	 * click YES button when Delete or Update record
	 */
	public void chooseYesOnUpdateConfirmation() {
		try {
			if (yesBtn.isDisplayed()) {
				yesBtn.waitUntilPresent().waitUntilClickable().click();
				waitForAllJSCompletes();
			}
		} catch (NoSuchElementException e) {
			LogWork.log_debug(yesBtn + "Element Not Found");
		}
	}

	@FindBy(id = "confirmationPanel_Form:confirmationPanel_NoButton")
	public WebElementFacade cancelBtn;

	public void chooseNoOnUpdateConfirmation() {
		cancelBtn.waitUntilPresent().waitUntilClickable().click();
	}

	// #End Region Confirm Message - Error Message - InforPanel Message.

	// #Region HTML TABLE.
	// @author: Vincent
	/**
	 * @Description xPath of Table Header Cell contains all kind of text
	 *              presented in cell (separated by space).
	 * @author Vincent
	 * @param _parentXpath
	 * @param _headerText
	 * @param _headerOrder
	 * @return xPath
	 */
	public String xPathTbHeaderCell(String _parentXpath, String _headerText,
			int _resOrder) {
		String[] aHeaderText = _headerText.split(" ");
		String sSearchPattern = "";
		int numText = aHeaderText.length;
		if (numText > 1) {
			sSearchPattern = "descendant-or-self::*[contains(*,'"
					+ aHeaderText[0] + "') or contains(text(),'"
					+ aHeaderText[0] + "') or contains(.,'" + aHeaderText[0]
					+ "')]";
			for (int i = 1; i < numText; i++) {
				sSearchPattern += " and descendant-or-self::*[contains(*,'"
						+ aHeaderText[i] + "') or contains(text(),'"
						+ aHeaderText[i] + "') or contains(.,'"
						+ aHeaderText[i] + "')]";
			}
			return "(" + _parentXpath + "//thead//descendant-or-self::th["
					+ sSearchPattern + "])[" + _resOrder + "]";
		} else {
			sSearchPattern = "[contains(*,'" + _headerText
					+ "') or contains(text(),'" + _headerText
					+ "') or contains(.,'" + _headerText + "')]";
			return "(" + _parentXpath + "//thead//descendant-or-self::th"
					+ sSearchPattern + ")[" + _resOrder + "]";
		}
	}

	/**
	 * @Description xPath of Table Header Cell contains all kind of text
	 *              presented in cell (separated by space).
	 * @author Vincent
	 * @param _headerText
	 * @return xPath
	 */
	public String xPathTbHeaderCell(String _headerText) {
		return xPathTbHeaderCell("", _headerText, 1);
	}

	/**
	 * @Description xPath of Table Header Cell contains all kind of text
	 *              presented in cell (separated by space).
	 * @author Vincent
	 * @param _headerText
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathTbHeaderCell(String _headerText, int _resOrder) {
		return xPathTbHeaderCell("", _headerText, _resOrder);
	}

	/**
	 * @Description xPath of Table Header Cell contains all kind of text
	 *              presented in cell (separated by space).
	 * @author Vincent
	 * @param _parentXpath
	 * @param _headerText
	 * @return xPath
	 */
	public String xPathTbHeaderCell(String _parentXpath, String _headerText) {
		return xPathTbHeaderCell(_parentXpath, _headerText, 1);
	}

	/**
	 * @Description xPath of Table Header Cell contains Check Box.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathTbHeaderChkbox(String _parentXpath, int _resOrder) {
		return ("(" + _parentXpath + "//thead//th//input[@type='checkbox'])["
				+ _resOrder + "]");
	}

	/**
	 * @Description xPath of Table Header Cell contains Check Box.
	 * @author Vincent
	 * @return xPath
	 */
	public String xPathTbHeaderChkbox() {
		return xPathTbHeaderChkbox("", 1);
	}

	/**
	 * @Description xPath of Table Header Cell contains Check Box.
	 * @author Vincent
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathTbHeaderChkbox(int _resOrder) {
		return xPathTbHeaderChkbox("", _resOrder);
	}

	/**
	 * @Description xPath of Table Header Cell contains Check Box.
	 * @author Vincent
	 * @param _parentXpath
	 * @return xPath
	 */
	public String xPathTbHeaderChkbox(String _parentXpath) {
		return xPathTbHeaderChkbox(_parentXpath, 1);
	}

	/**
	 * @Description xPath of Table Header Cell contains Check Box with Label.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _chkboxText
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathTbHeaderChkboxWithLabel(String _parentXpath,
			String _chkboxText, int _resOrder) {
		String[] aHeaderText = _chkboxText.split(" ");
		String sSearchPattern = "";
		int numText = aHeaderText.length;
		if (numText > 1) {
			sSearchPattern = "descendant-or-self::*[contains(*,'"
					+ aHeaderText[0] + "') or contains(text(),'"
					+ aHeaderText[0] + "')]";
			for (int i = 1; i < numText; i++) {
				sSearchPattern += " and descendant-or-self::*[contains(*,'"
						+ aHeaderText[i] + "') or contains(text(),'"
						+ aHeaderText[i] + "')]";
			}
			return "(" + _parentXpath + "//thead//descendant-or-self::th["
					+ sSearchPattern + "]//input[@type='checkbox'])["
					+ _resOrder + "]";
		} else {
			sSearchPattern = "[contains(*,'" + _chkboxText
					+ "') or contains(text(),'" + _chkboxText + "')]";
			return "(" + _parentXpath + "//thead//descendant-or-self::th"
					+ sSearchPattern + ")//input[@type='checkbox']["
					+ _resOrder + "]";
		}
	}

	/**
	 * @Description xPath of Table Header Cell contains Check Box with Label.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _chkboxText
	 * @return
	 */
	public String xPathTbHeaderChkboxWithLabel(String _parentXpath,
			String _chkboxText) {
		return xPathTbHeaderChkboxWithLabel(_parentXpath, _chkboxText, 1);
	}

	/**
	 * @Description xPath of Header Cell contains Check Box with Label.
	 * @author Vincent
	 * @param _chkboxText
	 * @return
	 */
	public String xPathTbHeaderChkboxWithLabel(String _chkboxText) {
		return xPathTbHeaderChkboxWithLabel("", _chkboxText, 1);
	}

	/**
	 * @Description Get Table Column Header index by xPath of Header Cell.
	 *              Return 0 if not found.
	 * @author Vincent
	 * @param _xPathHeaderCell
	 * @return int
	 */
	public int getTbColHeaderIndex(String _xPathHeaderCell) {
		waitElementToBePresent(_xPathHeaderCell);
		try {
			return findAll(_xPathHeaderCell + "/preceding-sibling::th").size() + 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * @Description Get Table Column Header index by Text insides Header Cell.
	 *              Return 0 if not found.
	 * @author Vincent
	 * @param _headerText
	 * @return
	 */
	public int getTbColHeaderIndexByText(String _headerText) {
		return getTbColHeaderIndex(xPathTbHeaderCell(_headerText));
	}

	/**
	 * @Description Get Table Column Header index by Text insides Header Cell.
	 *              Return 0 if not found.
	 * @author Vincent
	 * @param _headerText
	 * @param _resOrder
	 * @return
	 */
	public int getTbColHeaderIndex(String _headerText, int _resOrder) {
		return getTbColHeaderIndex(xPathTbHeaderCell(_headerText, _resOrder));
	}

	/**
	 * @Description Get Table Column Header index by Text insides Header Cell.
	 *              Return 0 if not found.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _headerText
	 * @return index
	 */
	public int getTbColHeaderIndex(String _parentXpath, String _headerText) {
		return getTbColHeaderIndex(xPathTbHeaderCell(_parentXpath, _headerText));
	}

	/**
	 * @Description Get Table Column Header index by Text insides Header Cell.
	 *              Return 0 if not found.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _headerText
	 * @param _resOrder
	 * @return index
	 */
	public int getTbColHeaderIndex(String _parentXpath, String _headerText,
			int _resOrder) {
		return getTbColHeaderIndex(xPathTbHeaderCell(_parentXpath, _headerText,
				_resOrder));
	}

	/**
	 * @Description xPath of all Table Data Rows.
	 * @author Vincent
	 * @return xPath
	 */
	public String xPathTbGetAllDataRows() {
		return "//descendant-or-self::tbody/tr";
	}

	/**
	 * @Description xPath of all Table Data Rows.
	 * @author Vincent
	 * @param _parentXpath
	 * @return xPath
	 */
	public String xPathTbGetAllDataRows(String _parentXpath) {
		return "(" + _parentXpath
				+ "//descendant-or-self::tbody[tr[@class]][1])/tr";
	}

	/**
	 * @Description xPath of Last Table Data Cell in Column by Header Cell
	 *              index.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _headerIndex
	 * @return
	 */
	public String xPathTbGetLastDataCellByHeaderIndex(String _parentXpath,
			int _headerIndex) {
		return "(" + _parentXpath
				+ "//tbody//tr//td[contains(@class,'rich-table-cell')]["
				+ _headerIndex + "])[last()]";
	}

	/**
	 * @Description xPath of Table Data Cells in same Column by Header Cell
	 *              index.
	 * @author Vincent
	 * @param _headerIndex
	 * @return xPath
	 */
	public String xPathTbGetAllDataCellsByHeaderIndex(int _headerIndex) {
		return "//tbody//tr//td[contains(@class,'rich-table-cell')]["
				+ _headerIndex + "]";
	}

	/**
	 * @Description xPath of Table Data Cells in same Column by Header Cell
	 *              index.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _headerIndex
	 * @return xPath
	 */
	public String xPathTbGetAllDataCellsByHeaderIndex(String _parentXpath,
			int _headerIndex) {
		return _parentXpath
				+ "//tbody//tr//td[contains(@class,'rich-table-cell')]["
				+ _headerIndex + "]";
	}

	/**
	 * @Description Finding Table Data Cells in same Column by Header Cell
	 *              index.
	 * @author Vincent
	 * @param _headerIndex
	 * @return WebElementFacade(s)
	 */
	public List<WebElementFacade> findTbAllDataCellsByHeaderIndex(
			int _headerIndex) {
		return waitElementToBePresent(
				xPathTbGetAllDataCellsByHeaderIndex(_headerIndex)).thenFindAll(
				xPathTbGetAllDataCellsByHeaderIndex(_headerIndex));
	}

	/**
	 * @Description Finding Table Data Cells in same Column by Header Cell
	 *              index.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _headerIndex
	 * @return WebElementFacade(s)
	 */
	public List<WebElementFacade> findTbAllDataCellsByHeaderIndex(
			String _parentXpath, int _headerIndex) {
		return waitElementToBePresent(
				xPathTbGetAllDataCellsByHeaderIndex(_parentXpath, _headerIndex))
				.thenFindAll(
						xPathTbGetAllDataCellsByHeaderIndex(_parentXpath,
								_headerIndex));
	}

	/**
	 * @Description Finding all Table Data Rows.
	 * @author Vincent
	 * @return WebElementFacades
	 */
	public List<WebElementFacade> findTbAllDataRows() {
		return waitElementToBePresent(xPathTbGetAllDataRows()).thenFindAll(
				xPathTbGetAllDataRows());
	}

	/**
	 * @Description Finding all Table Data Rows.
	 * @author Vincent
	 * @param _parentXpath
	 * @return WebElementFacade(s)
	 */
	public List<WebElementFacade> findTbAllDataRows(String _parentXpath) {
		return waitElementToBePresent(xPathTbGetAllDataRows(_parentXpath))
				.thenFindAll(xPathTbGetAllDataRows(_parentXpath));
	}

	/**
	 * @Description Count the number of data row in table.
	 * @author Vincent
	 * @param _parentXpath
	 * @return int
	 */
	public int getTbCountDataRow(String _parentXpath) {
		return findTbAllDataRows(_parentXpath).size();
	}

	/**
	 * @Description Finding Table Data Row By Row Index.
	 * @author Vincent
	 * @param _rowIndex
	 * @return WebElementFacade
	 */
	public WebElementFacade findTbDataRowByIndex(int _rowIndex) {
		return findTbAllDataRows().get(_rowIndex);
	}

	/**
	 * @Description Finding Table Data Row By Row Index.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _rowIndex
	 * @return WebElementFacade
	 */
	public WebElementFacade findTbDataRowByIndex(String _parentXpath,
			int _rowIndex) {
		return findTbAllDataRows(_parentXpath).get(_rowIndex);
	}

	/**
	 * @Description xPath of Table Data Rows by any given text insides Data Row
	 * @author Vincent
	 * @param _parentXpath
	 * @param _givenText
	 * @return xPath
	 */
	public String xPathTbDataRowsByAnyText(String _parentXpath,
			String _givenText) {
		String[] aGivenText = _givenText.split(" ");
		String sSearchPattern = "";
		int numText = aGivenText.length;
		if (numText > 1) {
			sSearchPattern = "descendant-or-self::*[contains(@value,'"
					+ aGivenText[0] + "') or contains(text(),'" + aGivenText[0]
					+ "')]";
			for (int i = 1; i < numText; i++) {
				sSearchPattern += " and descendant-or-self::*[contains(@value,'"
						+ aGivenText[i]
						+ "') or contains(text(),'"
						+ aGivenText[i] + "')]";
			}
			return "("
					+ _parentXpath
					+ "//tbody//descendant-or-self::tr[contains(@class,'row')]["
					+ sSearchPattern + "])";
		} else {
			sSearchPattern = "[descendant-or-self::*[contains(@value,'"
					+ _givenText + "') or contains(text(),'" + _givenText
					+ "')]]";
			return "(" + _parentXpath
					+ "//tbody//descendant-or-self::tr[contains(@class,'row')]"
					+ sSearchPattern + ")";
		}
	}

	/**
	 * @Description xPath of Table Data Rows by any given text insides Data Rows
	 * @author Vincent
	 * @param _givenText
	 * @return xPath
	 */
	public String xPathTbDataRowsByAnyText(String _givenText) {
		return xPathTbDataRowsByAnyText("", _givenText);
	}

	/**
	 * @Description xPath of Table Data Row by any given text insides Data Row.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _givenText
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathTbDataRowByAnyText(String _parentXpath,
			String _givenText, int _resOrder) {
		String[] aGivenText = _givenText.split(" ");
		String sSearchPattern = "";
		int numText = aGivenText.length;
		if (numText > 1) {
			sSearchPattern = "descendant-or-self::*[contains(@value,'"
					+ aGivenText[0] + "') or contains(text(),'" + aGivenText[0]
					+ "')]";
			for (int i = 1; i < numText; i++) {
				sSearchPattern += " and descendant-or-self::*[contains(@value,'"
						+ aGivenText[i]
						+ "') or contains(text(),'"
						+ aGivenText[i] + "')]";
			}
			return "("
					+ _parentXpath
					+ "//tbody//descendant-or-self::tr[contains(@class,'row')]["
					+ sSearchPattern + "])[" + _resOrder + "]";
		} else {
			sSearchPattern = "[descendant-or-self::*[contains(@value,'"
					+ _givenText + "') or contains(text(),'" + _givenText
					+ "')]]";
			return "(" + _parentXpath
					+ "//tbody//descendant-or-self::tr[contains(@class,'row')]"
					+ sSearchPattern + ")[" + _resOrder + "]";
		}

	}

	/**
	 * @Description xPath of Table Data Row by any given text insides Data Row.
	 * @author Vincent
	 * @param _givenText
	 * @return xPath
	 */
	public String xPathTbDataRowByAnyText(String _givenText) {
		return xPathTbDataRowByAnyText("", _givenText, 1);
	}

	/**
	 * @Description xPath of Table Data Row by any given text insides Data Row.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _givenText
	 * @return xPath
	 */
	public String xPathTbDataRowByAnyText(String _parentXpath, String _givenText) {
		return xPathTbDataRowByAnyText(_parentXpath, _givenText, 1);
	}

	/**
	 * @Description xPath of Table Data Row by any given text insides Data Row.
	 * @author Vincent
	 * @param _givenText
	 * @param _rowOrder
	 * @return xPath
	 */
	public String xPathTbDataRowByAnyText(String _givenText, int _rowOrder) {
		return xPathTbDataRowByAnyText("", _givenText, _rowOrder);
	}

	/**
	 * @Description xPath of Table Data Cell by any given text insides Data
	 *              Cell.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _givenText
	 * @param _cellOrder
	 * @return xPath
	 */
	public String xPathTbDataCellByText(String _parentXpath, String _givenText,
			int _cellOrder) {
		String[] aGivenText = _givenText.split(" ");
		String sSearchPattern = "";
		int numText = aGivenText.length;
		if (numText > 1) {
			sSearchPattern = "descendant-or-self::*[contains(@value,'"
					+ aGivenText[0] + "') or contains(text(),'" + aGivenText[0]
					+ "')]";
			for (int i = 1; i < numText; i++) {
				sSearchPattern += " and descendant-or-self::*[contains(@value,'"
						+ aGivenText[i]
						+ "') or contains(text(),'"
						+ aGivenText[i] + "')]";
			}
			return "("
					+ _parentXpath
					+ "//tbody//descendant-or-self::td[contains(@class,'rich-table-cell')]["
					+ sSearchPattern + "])[" + _cellOrder + "]";
		} else {
			sSearchPattern = "[descendant-or-self::*[contains(@value,'"
					+ _givenText + "') or contains(text(),'" + _givenText
					+ "')]]";
			return "("
					+ _parentXpath
					+ "//tbody//descendant-or-self::td[contains(@class,'rich-table-cell')]"
					+ sSearchPattern + ")[" + _cellOrder + "]";
		}
	}

	/**
	 * @Description xPath of Table Data Cell by any given text insides Data
	 *              Cell.
	 * @author Vincent
	 * @param _givenText
	 * @return xPath
	 */
	public String xPathTbDataCellByText(String _givenText) {
		return xPathTbDataCellByText("", _givenText, 1);
	}

	/**
	 * @Description xPath of Table Data Cell by any given text insides Data
	 *              Cell.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _givenText
	 * @return xPath
	 */
	public String xPathTbDataCellByText(String _parentXpath, String _givenText) {
		return xPathTbDataCellByText(_parentXpath, _givenText, 1);
	}

	/**
	 * @Description xPath of Table Data Cell by any given text insides Data
	 *              Cell.
	 * @author Vincent
	 * @param _givenText
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathTbDataCellByText(String _givenText, int _resOrder) {
		return xPathTbDataCellByText("", _givenText, _resOrder);
	}

	/**
	 * @Description xPath of Table Data Cell by equal Text insides Data Cell.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _givenText
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathTbDataCellByTextEqual(String _parentXpath,
			String _givenText, int _resOrder) {
		String sSearchPattern = "[descendant-or-self::*[*='" + _givenText
				+ "' or text()='" + _givenText + "']]";
		return "("
				+ _parentXpath
				+ "//tbody//descendant-or-self::td[contains(@class,'rich-table-cell')]"
				+ sSearchPattern + ")[" + _resOrder + "]";
	}

	/**
	 * @Description xPath of Table Data Cell by equal Text insides Data Cell.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _givenText
	 * @return xPath
	 */
	public String xPathTbDataCellByTextEqual(String _parentXpath,
			String _givenText) {
		return xPathTbDataCellByTextEqual(_parentXpath, _givenText, 1);
	}

	/**
	 * @Description xPath of Table Data Cell by equal Text insides Data Cell.
	 * @author Vincent
	 * @param _givenText
	 * @return xPath
	 */
	public String xPathTbDataCellByTextEqual(String _givenText) {
		return xPathTbDataCellByTextEqual("", _givenText, 1);
	}

	/**
	 * @Description xPath of Table Data Cell by equal Text insides Data Cell.
	 * @author Vincent
	 * @param _givenText
	 * @param _resOrder
	 * @return xPath
	 */
	public String xPathTbDataCellByTextEqual(String _givenText, int _resOrder) {
		return xPathTbDataCellByTextEqual("", _givenText, _resOrder);
	}

	/**
	 * @Description xPath of Table Data Cell by position of Data Cell (Row and
	 *              Column Index).
	 * @author Vincent
	 * @param _parentXpath
	 * @param _rowIndex
	 * @param _headerIndex
	 * @return xPath
	 */
	public String xPathTbDataCellByPosition(String _parentXpath, int _rowIndex,
			int _headerIndex) {
		return "(("
				+ _parentXpath
				+ "//tbody[preceding::thead][not(ancestor::tfoot)])[1]//tr/td[contains(@class,'rich-table-cell')]["
				+ _headerIndex + "])[" + _rowIndex + "]";
	}

	/**
	 * @Description xPath of Table Data Cell by position of Data Cell (Row and
	 *              Column Index) and exactly tbody index of table.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _tbodyIndex
	 * @param _rowIndex
	 * @param _headerIndex
	 * @return xPath
	 */
	public String xPathTbDataCellByPositionAndBodyIndex(String _parentXpath,
			int _tbodyIndex, int _rowIndex, int _headerIndex) {
		return "((" + _parentXpath + "//tbody[preceding::thead])["
				+ _tbodyIndex + "]/tr/td[contains(@class,'cell')]["
				+ _headerIndex + "])[" + _rowIndex + "]";
	}

	/**
	 * @Description xPath of Table Data Cell by position of Data Cell (Row and
	 *              Column Index) and exactly tbody predicate of table.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _tbodyPredicate
	 * @param _rowIndex
	 * @param _headerIndex
	 * @return xPath
	 */
	public String xPathTbDataCellByPositionAndBodyPredicate(
			String _parentXpath, String _tbodyPredicate, int _rowIndex,
			int _headerIndex) {
		return "((" + _parentXpath + "//tbody[preceding::thead])["
				+ _tbodyPredicate + "]/tr/td[contains(@class,'cell')]["
				+ _headerIndex + "])[" + _rowIndex + "]";
	}

	/**
	 * @Description
	 * @author Vincent
	 * @param _parentXpath
	 * @param _givenText
	 * @param _resOrder
	 * @param _headerIndex
	 * @return
	 */
	public String xPathTbDataCellByTextInCol(String _parentXpath,
			String _givenText, int _resOrder, int _headerIndex) {
		String[] aGivenText = _givenText.split(" ");
		String sSearchPattern = "";
		int numText = aGivenText.length;
		if (numText > 1) {
			sSearchPattern = "descendant-or-self::*[contains(*,'"
					+ aGivenText[0] + "') or contains(text(),'" + aGivenText[0]
					+ "') or contains(@value,'" + aGivenText[0] + "')]";
			for (int i = 1; i < numText; i++) {
				sSearchPattern += " and descendant-or-self::*[contains(*,'"
						+ aGivenText[i] + "') or contains(text(),'"
						+ aGivenText[i] + "') or contains(@value,'"
						+ aGivenText[0] + "')]";
			}
			return "("
					+ _parentXpath
					+ "//tbody//tr/descendant-or-self::td[contains(@class,'cell')]["
					+ _headerIndex + "][" + sSearchPattern + "])[" + _resOrder
					+ "]";
		} else {
			sSearchPattern = "[descendant-or-self::*[contains(*,'" + _givenText
					+ "') or contains(text(),'" + _givenText
					+ "') or contains(@value,'" + _givenText + "')]]";
			return "("
					+ _parentXpath
					+ "//tbody//tr/descendant-or-self::td[contains(@class,'cell')]["
					+ _headerIndex + "]" + sSearchPattern + ")[" + _resOrder
					+ "]";
		}
	}

	/**
	 * @Description
	 * @author Vincent
	 * @param _parentXpath
	 * @param _givenText
	 * @param _resOrder
	 * @param _headerIndex
	 * @return
	 */
	public String xPathTbDataCellByTextEqualInCol(String _parentXpath,
			String _givenText, int _resOrder, int _headerIndex) {
		String sSearchPattern = "[descendant-or-self::*[@*='" + _givenText
				+ "' or text()='" + _givenText + "']]";
		return "("
				+ _parentXpath
				+ "//tbody//tr/descendant-or-self::td[contains(@class,'cell')]["
				+ _headerIndex + "]" + sSearchPattern + ")[" + _resOrder + "]";
	}

	/**
	 * @Description xPath of all data cell in specific column of table
	 * @author Vincent
	 * @param _parentXpath
	 * @param _headerIndex
	 * @return xPath
	 */
	public String xPathTbDataCellsInCol(String _parentXpath, int _headerIndex) {
		return "(" + _parentXpath + "//tbody//td[contains(@class,'cell')]["
				+ _headerIndex + "])";
	}

	/**
	 * @Description
	 * @author Vincent
	 * @param _parentXpath
	 * @param _givenText
	 * @param _resDataOrder
	 * @param _headerText
	 * @param _headerResOrder
	 * @return
	 */
	public String xPathTbDataCellByTextEqualInCol(String _parentXpath,
			String _givenText, int _resDataOrder, String _headerText,
			int _headerResOrder) {
		int headerIndex = getTbColHeaderIndex(_headerText, _headerResOrder);
		String sSearchPattern = "[descendant-or-self::*[@*='" + _givenText
				+ "' or text()='" + _givenText + "']]";
		return "(" + _parentXpath + "//tbody//td[contains(@class,'cell')]["
				+ headerIndex + "]" + sSearchPattern + ")[" + _resDataOrder
				+ "]";
	}

	/**
	 * @Description
	 * @author Vincent
	 * @param _parentXpath
	 * @param _givenText
	 * @param _resDataOrder
	 * @param _headerText
	 * @param _headerResOrder
	 * @return
	 */
	public WebElementFacade findTbDataCellByTextEqualInCol(String _parentXpath,
			String _givenText, int _resDataOrder, String _headerText,
			int _headerResOrder) {
		return waitElementToBePresent(xPathTbDataCellByTextEqualInCol(
				_parentXpath, _givenText, _resDataOrder, _headerText,
				_headerResOrder));
	}

	/**
	 * @Description Get Column Index of Table Data Cell. NOTE: Return 0 if not
	 *              found.
	 * @author Vincent
	 * @param _XpathDataCell
	 * @return
	 */
	public int getTbColIndexOfDataCell(String _XpathDataCell) {
		waitElementToBePresent(_XpathDataCell);
		try {
			return findAll(_XpathDataCell + "/preceding-sibling::td").size() + 1;
		} catch (Exception e) {
			return 0;
		}
	}

	// return 0 if not found
	/**
	 * @Description Get Row Index of Table Data Cell. NOTE: Return 0 if not
	 *              found.
	 * @author Vincent
	 * @param _XpathDataCell
	 * @return
	 */
	public int getTbRowIndexOfDataCell(String _XpathDataCell) {
		waitElementToBePresent(_XpathDataCell);
		try {
			return findAll(
					_XpathDataCell + "/ancestor::tr[1]/preceding-sibling::tr")
					.size() + 1;
		} catch (Exception e) {
			return 0;
		}
	}

	// Common TABLE action
	/**
	 * @Description Filter data by input text into Table by Header Filter Cell.
	 * @author Vincent
	 * @param xPathHeaderCell
	 * @param _value
	 */
	public void filterDataByHeader(String xPathHeaderCell, String _value) {
		waitTypeAndEnterThenUpdateValue(xPathHeaderCell
				+ "//input[@type='text']", _value);
	}

	/**
	 * @Description Filter data in Table by Date (From , To).
	 * @author Vincent
	 * @param xPathHeaderCell
	 * @param _valueFrom
	 * @param _valueTo
	 */
	public void filterDataByHeaderDate(String xPathHeaderCell,
			String _valueFrom, String _valueTo) {
		waitTypeAndEnterThenUpdateValue(
				"("
						+ xPathHeaderCell
						+ "//input[@type='text' and contains(@class, 'rich-calendar-input')])[1]",
				_valueFrom);
		waitTypeAndEnterThenUpdateValue(
				"("
						+ xPathHeaderCell
						+ "//input[@type='text' and contains(@class, 'rich-calendar-input')])[2]",
				_valueTo);
	}

	/**
	 * @Description Set Check Box that insides Table Header Cell.
	 * @author Vincent
	 * @param xPathHeaderChkBox
	 * @param _value
	 */
	public void setHeaderCheckbox(String xPathHeaderChkBox, String _value) {
		setChkbox(xPathHeaderChkBox, _value);
	}

	/**
	 * @Description Click on green arrow in first column of table data.
	 * @author Vincent
	 * @param _parentXpath
	 * @param _rowIndex
	 */
	public void clickGreenArrow(String _parentXpath, int _rowIndex) {
		// Click on green arrow
		waitElementToBeClickable(
				xPathTbDataCellByPosition(_parentXpath, _rowIndex, 1)
						+ "//img[contains(@src,'greenarrow')]").click();
	}

	// #EndRegion HTML TABLE.

	// COMMON ACTION
	public void clickOnElement(String _xPath) {
		waitElementToBeClickable(_xPath).click();
	}

	public void highlightElement(String _xPath) {
		try {
			((JavascriptExecutor) getDriver())
					.executeScript("arguments[0].style.border='3px solid red'",
							findBy(_xPath));
		} catch (Exception e) {
		}
	}

	/**
	 * @Description Get login user name display besides Logout link.
	 * @author Vincent
	 * @return
	 */
	public String getLoginUserName() {
		try {
			String sUserName = "";
			sUserName = waitElementToBePresent(
					"(//body//form[a[text()='Logout']])[1]").getText();
			Charset.forName("UTF-8").encode(sUserName);
			sUserName = sUserName.substring(sUserName.indexOf("\n") + 1,
					sUserName.indexOf("|")).trim();
			LogWork.log_debug("Login User Name: " + sUserName);
			return sUserName;
		} catch (Exception e) {
			LogWork.log_debug("***ERROR***: Can not get Login User Name");
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * @Description Get current window handle
	 * @author Vincent
	 * @return
	 */
	public String getCurrentWindowHandle() {
		return getDriver().getWindowHandle();
	}

	/**
	 * @Description Switch to window
	 * @author Vincent
	 * @return
	 */
	public boolean switchToWindowHandle(String _handle) {
		try {
			getDriver().switchTo().window(_handle);
			return true;
		} catch (Exception e) {
			LogWork.log_debug("Switch to window this window unsuccessfully : "
					+ _handle);
			return false;
		}
	}

	// BEGIN Calendar
	private String xPathCalendarMonthButton = "//td[@class='rich-calendar-month']//div";
	private String xPathCalendarTodayButton = "//div[@class='rich-calendar-tool-btn'][text()='Today']";
	private String xPathCalendarEditorButton = "//div[@class='rich-calendar-editor-btn']";
	private String xPathCalendarOkButton = "//span[text()='OK']";

	/**
	 * @Description Pick up date from Calendar. Pre-condition: Calendar must
	 *              already be opened.
	 * @author Vincent
	 * @param ddMMyyyy
	 */
	public void calendarSetDate(String ddMMyyyy) {// dd//MM/yyyy
		String tempXpath = "";
		if (!ddMMyyyy.isEmpty()) {
			String day = ddMMyyyy.split("/")[0];
			String month = ddMMyyyy.split("/")[1];
			String year = ddMMyyyy.split("/")[2];
			if (Integer.parseInt(month) == 1)
				month = "Jan";
			else if (Integer.parseInt(month) == 2)
				month = "Feb";
			else if (Integer.parseInt(month) == 3)
				month = "Mar";
			else if (Integer.parseInt(month) == 4)
				month = "Apr";
			else if (Integer.parseInt(month) == 5)
				month = "May";
			else if (Integer.parseInt(month) == 6)
				month = "Jun";
			else if (Integer.parseInt(month) == 7)
				month = "Jul";
			else if (Integer.parseInt(month) == 8)
				month = "Aug";
			else if (Integer.parseInt(month) == 9)
				month = "Sep";
			else if (Integer.parseInt(month) == 10)
				month = "Oct";
			else if (Integer.parseInt(month) == 11)
				month = "Nov";
			else if (Integer.parseInt(month) == 12)
				month = "Dec";
			try {
				clickOnElement(xPathCalendarMonthButton);
				// click at Year
				tempXpath = xPathCalendarEditorButton + "[text()='" + month
						+ "']";
				if (isElementExist(tempXpath, 1))
					clickOnElement(tempXpath);
				// if not found that means the button has already been selected,
				// proceed
				// click at Year
				tempXpath = xPathCalendarEditorButton + "[text()='" + year
						+ "']";
				if (isElementExist(tempXpath, 1))
					clickOnElement(tempXpath);
				// if not found that means the button has already been selected,
				// proceed
				else {
					// if the desired year is larger than the year in the list,
					// proceed to next year tab
					if (Integer.parseInt(year) > Calendar.getInstance().get(
							Calendar.YEAR)) {
						WebElementFacade elementTemp = waitElementToBePresent(xPathCalendarEditorButton
								+ "[text()='>']");
						while (true) {
							elementTemp.click();
							tempXpath = xPathCalendarEditorButton + "[text()='"
									+ year + "']";
							if (!isElementExist(tempXpath, 1)) {
								clickOnElement(tempXpath);
								break;
							}
						}
					} else if (Integer.parseInt(year) < Calendar.getInstance()
							.get(Calendar.YEAR)) {
						WebElementFacade elementTemp = waitElementToBePresent(xPathCalendarEditorButton
								+ "[text()='<']");
						while (true) {
							elementTemp.click();
							tempXpath = xPathCalendarEditorButton + "[text()='"
									+ year + "']";
							if (!isElementExist(tempXpath, 1)) {
								clickOnElement(tempXpath);
								break;
							}
						}
					}
				}
				clickOnElement(xPathCalendarOkButton);// choose day next
				int dayI = Integer.parseInt(day);
				// check if day has already been selected
				tempXpath = "//td[text()='"
						+ dayI
						+ "'][@class='rich-calendar-cell-size rich-calendar-cell "
						+ "rich-calendar-select' "
						+ "or @class='rich-calendar-cell-size rich-calendar-cell "
						+ "rich-calendar-today rich-calendar-select']";
				if (!isElementExist(tempXpath, 1))
					clickOnElement("//div[@class='rich-calendar-tool-btn'][text()='x']");
				else {
					List<WebElementFacade> elements = findAll("//td[text()='"
							+ dayI
							+ "'][contains(@class, 'rich-calendar-cell-size')]");
					if (elements.size() == 1)
						elements.get(0).click();
					else {
						if (Integer.parseInt(day) < 20)
							elements.get(0).click();
						if (Integer.parseInt(day) > 20)
							elements.get(1).click();
					}
				}
				LogWork.log_debug("Input calendar date: " + day + "/" + month
						+ "/" + year);
			} catch (Exception e) {
				LogWork.log_debug("Input calendar date failed: " + day + "/"
						+ month + "/" + year + ". With exception: "
						+ e.getMessage());
			}
		}
	}

	/**
	 * @Description Pick today date from Calendar. Pre-condition: Calendar must
	 *              already be opened.
	 * @author Vincent
	 */
	public void calendarSetToday() {
		// Click on Today
		clickOnElement(xPathCalendarTodayButton);
		waitForAllJSCompletes();
		if (isElementExist(
				"//div[@class='rich-calendar-tool-btn'][text()='x']", 1)) {
			// Close Calendar
			clickOnElement("//div[@class='rich-calendar-tool-btn'][text()='x']");
		}
	}

	/**
	 * @Description Pick today date from Calendar besides label text.
	 * @author Vincent
	 */
	public void calendarSetTodayWithLabel(String labelText) {
		// Open Calendar
		clickOnElement(xPathCalendarWithLabel(labelText));
		calendarSetToday();
	}

	// END Calendar
	// BEGIN Text Utilities
	/**
	 * @Description Create text predicates with text contains special
	 *              characters. Note: It's not include [].
	 * @author Vincent
	 * @param _givenText
	 * @return
	 */
	public String sSpecialTextPredicates(String _givenText) {
		String[] tokens = _givenText.split("\"|\\'");
		int numText = tokens.length;
		String sSearchPattern = "";
		if (numText > 1) {
			sSearchPattern = "contains(text(),'" + tokens[0] + "')";
			for (int i = 1; i < numText; i++) {
				sSearchPattern += " and contains(text(),'" + tokens[i] + "')";
			}
			return sSearchPattern;
		} else {
			return "text()='" + _givenText + "'";
		}
	}

	// END Text Utilities

	// BEGIN Input Remark by click on Remark Icon
	/**
	 * @Description Enter remarks by click on Remark Icon to open Remarks Popup.
	 * @author Vincent
	 * @param _xPathRemarksIcon
	 * @param _value
	 */
	public void enterRemarkByClickIcon(String _xPathRemarksIcon, String _value) {
		clickOnElement(_xPathRemarksIcon);
		String xPathPopupRemarks = "(//div[(contains(@id,'RemarksPopupHeader') or contains(@id,'remarksModalPanelHeader')) and text()='Remarks']//ancestor::table[1])[last()]";
		waitElementToBePresent(xPathPopupRemarks).shouldBeVisible();
		waitTypeAndTab(xPathPopupRemarks + "//textarea", _value);
		clickOnElement(xPathPopupRemarks
				+ "//input[@*='button' and (@value='Close' or @value='Ok')]");
		waitForAllJSCompletes();
		waitForAbsenceOf(xPathPopupRemarks);
	}

	// END Input Remark by click on Remark Icon

	// BEGIN Tag company

	public void switch_to_tab_company() {
		switch_to_tab("Company");
	}

	public void chooseCompany(String _companyName) {
		if (!_companyName.isEmpty()) {
			if (_companyName.contains(",")) {
				String[] listCompany = _companyName.split(",");
				for (String company : listCompany) {
					String xRowSelected = "//table[contains(@id, 'tblCompanyList')]/tbody/tr[child::td[1 and descendant-or-self::*[text()='"
							+ company.trim() + "']]]//input[@type='checkbox']";
					if (!$(xRowSelected).isSelected()) {
						clickOnElement(xRowSelected);
						waitForAllJSCompletes();
					}
				}
			} else {
				String xRowSelected = "//table[contains(@id, 'tblCompanyList')]/tbody/tr[child::td[1 and descendant-or-self::*[text()='"
						+ _companyName.trim() + "']]]//input[@type='checkbox']";
				if (!$(xRowSelected).isSelected()) {
					clickOnElement(xRowSelected);
					waitForAllJSCompletes();
				}
			}
		}

	}

	public void chooseCompany(String _xPathTbCompanyTag, String _companyName) {
		filterDataByHeader(
				xPathTbHeaderCell(_xPathTbCompanyTag, "Company Name"),
				_companyName);
		setChkbox(
				xPathTbDataCellByPosition(
						_xPathTbCompanyTag,
						getTbRowIndexOfDataCell(xPathTbDataCellByTextEqual(
								_xPathTbCompanyTag, _companyName, 1)), 2)
						+ "//input[@type='checkbox']", "true");
		filterDataByHeader(
				xPathTbHeaderCell(_xPathTbCompanyTag, "Company Name"), "");
	}

	/**
	 * Using check all Company
	 * 
	 * @author Nancy
	 */
	private String xPathTagCheckbox = "//*[text()='Tag']/*[@type='checkbox']";

	public void chooseAllCompany() {
		if (!$(xPathTagCheckbox).isSelected()) {
			waitElementToBePresent(xPathTagCheckbox).click();
		}
	}

	// END Tag company

	// BEGIN Search Panel
	public void enterSearchByInputField(String _parentXpath, String _labelName,
			String _value, int _resOrder) {
		enterInputFieldWithLabel(_parentXpath, _labelName, _value, _resOrder);
	}

	public void enterSearchByInputField(String _labelName, String _value) {
		enterInputFieldWithLabel("//table[contains(@id,'search')]", _labelName,
				_value, 1);
	}

	// END Search Panel
	// BEGIN Search In MultiPage
	private static final String SCROLL_TABLE_FIRST_BUTTON = "//*[contains(@class, 'rich-datascr-button')][text()='««'][not(contains(@class,'dsbld'))]";
	private static final String SCROLL_TABLE_PREVIOUS_BUTTON = "//*[contains(@class, 'rich-datascr-button')][text()='«'][not(contains(@class,'dsbld'))]";
	private static final String SCROLL_TABLE_LAST_BUTTON = "//*[contains(@class, 'rich-datascr-button')][text()='»»'][not(contains(@class,'dsbld'))]";
	private static final String SCROLL_TABLE_NEXT_BUTTON = "//*[contains(@class, 'rich-datascr-button')][text()='»'][not(contains(@class,'dsbld'))]";

	public int searchInTbMultiPage(String _parentXpath, String _headerText,
			int _colResOrder, String _value, boolean _searchFromFirstPage) {
		String btnNav1 = "";
		String btnNav2 = "";
		if (_searchFromFirstPage == false) {
			btnNav1 = _parentXpath + SCROLL_TABLE_LAST_BUTTON;
			btnNav2 = _parentXpath + SCROLL_TABLE_PREVIOUS_BUTTON;
		} else {
			btnNav1 = _parentXpath + SCROLL_TABLE_FIRST_BUTTON;
			btnNav2 = _parentXpath + SCROLL_TABLE_NEXT_BUTTON;
		}
		// Go to last page or first list
		if (isElementExist(btnNav1, 1)) {
			clickOnElement(btnNav1);
		}

		while (true) {
			// Get column index of value to search
			int colIndex = getTbColHeaderIndex(_parentXpath, _headerText,
					_colResOrder);
			// Get all data cells
			List<WebElementFacade> dataCellResults = withTimeoutOf(200,
					TimeUnit.MILLISECONDS).findAll(
					xPathTbDataCellsInCol(_parentXpath, colIndex));
			// Check all data cell results
			for (int i = 0; i < dataCellResults.size(); i++) {
				if (dataCellResults.get(i).containsOnlyText(_value)) {
					return i + 1;
				}
				int k = i + 1;
				List<WebElementFacade> subDataCellResults = withTimeoutOf(200,
						TimeUnit.MILLISECONDS).findAll(
						"(" + xPathTbDataCellsInCol(_parentXpath, colIndex)
								+ ")[" + k + "]//*");
				// LogWork.log_debugln("(" + xPathTbDataCellsInCol(_parentXpath,
				// colIndex) + ")[" + k + "]//*");
				for (int j = 0; j < subDataCellResults.size(); j++) {
					try {
						if (subDataCellResults.get(j).getText().equals(_value)
								|| subDataCellResults.get(j).getValue()
										.equals(_value)) {
							return i + 1;
						}
					} catch (Exception e) {
						// Do nothing
					}
				}
				try {
					if (isElementVisible(
							"(" + xPathTbDataCellsInCol(_parentXpath, colIndex)
									+ ")[" + k + "]//*[@value = '" + _value
									+ "']", 0)) {
						return i + 1;
					}
				} catch (Exception e) {
				}
			}

			{ // next page
				if (isElementExist(btnNav2, 0)) {
					clickOnElement(btnNav2);
				} else {
					return 0;// Only one page
				}
			} // loop
		}
	}

	// END Search In MultiPage
	/**
	 * count Row of Table
	 * 
	 * @author Nancy
	 */
	public int getTbRowsCount(String nameTable) {
		String xPath = "((//*[contains(@class, 'header')][text()='" + nameTable
				+ "']/ancestor::table)[last()]/tbody/tr)";
		return findAll(By.xpath(xPath)).size();
	}

	/**
	 * Get result search at row=rowIndex
	 * 
	 * @author Nancy
	 */

	public void getResultSearch(String labelName, String valueSearch, int row) {
		String xPathLable = "(//table[@id='searchModalPanelContentTable']//*[text()='"
				+ labelName
				+ "']//ancestor::td)[last()]/following-sibling::td//input[@type='text']";
		String xPathsearch = "(//table[@id='searchModalPanelContentTable']//*[text()='"
				+ labelName
				+ "']//ancestor::td)[last()]/following-sibling::td//input[@type='button']";
		$(xPathLable).typeAndTab(valueSearch);
		$(xPathsearch).waitUntilClickable().click();
		String xPathFirstRow = "(//tbody[@id='searchResult_Form:searchResult_Table:tb']/tr["
				+ row + "]//a[@href])[1]";
		$(xPathFirstRow).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	/**
	 * Check Segment in Taskhub
	 * 
	 * @author Nancy
	 */
	public List<String> listSegment() {
		List<String> onSegment = new ArrayList<>();
		List<String> offSegment = new ArrayList<>();
		offSegment.add("N");
		onSegment.addAll(Arrays.asList("Y", "Y", "Y", "Y"));
		return offSegment;
		// return onSegment;
	}

	public boolean isSegment() {
		return false;
	}

	public void setSegment(List<String> dataSegment) {
		List<String> configSegment = listSegment();
		int size = configSegment.size();
		if (size > 1) {
			for (int j = 0; j < size; j++) {
				if (configSegment.get(j).equals("Y"))
					enterInputFieldWithLabelNoVerify("Segment " + (j + 1),
							dataSegment.get(j));
			}
		}
	}
	
	public void setSegment(String xParent, List<String> dataSegment) {
		List<String> configSegment = listSegment();
		int size = configSegment.size();
		if (size > 1) {
			for (int j = 0; j < size; j++) {
				if (configSegment.get(j).equals("Y"))
					enterInputFieldWithLabelNoVerify(xParent, "Segment "
							+ (j + 1), dataSegment.get(j));
			}
		}
	}
	
	public void setSegment(List<String> dataSegment, int rowIndex) {
		setSegment("", dataSegment, rowIndex);
	}


	/**
	 * @Description: using to set segment in the table
	 * @parameter: parentXpath = "" => default find segment in the first table.
	 */
	public void setSegment(String parentXpath, List<String> dataSegment,
			int rowIndex) {
		String xParentPopUp = "//table[@id='popupModalPanelContentTable']";
		if (parentXpath.equals("")) {
			List<String> configSegment = listSegment();
			int size = configSegment.size();
			if (size > 1) {
				int colIndex = getTbColHeaderIndex("Sgmts");
				parentXpath = "(//table[child::thead[descendant-or-self::th[contains(*,'Sgmts') or contains(text(),'Sgmts')]]])[1]";
				clickOnElement(xPathTbDataCellByPositionAndBodyIndex(
						parentXpath, 1, rowIndex, colIndex));

				for (int j = 0; j < size; j++) {
					if (configSegment.get(j).equals("Y"))
						enterInputFieldCodeWithLabel(xParentPopUp, "Segment "
								+ (j + 1), dataSegment.get(j));
				}
				waitForAllJSCompletes();
				clickBtn(xParentPopUp, "Done");
			}
		} else {
			List<String> configSegment = listSegment();
			int size = configSegment.size();
			if (size > 1) {
				int colIndex = getTbColHeaderIndex(parentXpath, "Sgmts");
				clickOnElement(xPathTbDataCellByPosition(parentXpath, rowIndex,
						colIndex));
				for (int j = 0; j < size; j++) {
					if (configSegment.get(j).equals("Y"))
						enterInputFieldCodeWithLabel(xParentPopUp, "Segment "
								+ (j + 1), dataSegment.get(j));
				}
				waitForAllJSCompletes();
				clickBtn(xParentPopUp, "Done");
			}

		}
	}

	// Selenium Action Base
	public String getInputFieldByText(String labelElement) {
		return "(//*[@id='mainPanel']//*[text()='"
				+ labelElement
				+ "']/ancestor-or-self::td/following-sibling::td//input[@type='text'])[1]"
				+ " | (//*[text()='"
				+ labelElement
				+ "']/ancestor-or-self::td/following-sibling::td//input[@type='text'])[1]";
	}

	public String getValue(String labelElement) {
		return $(getInputFieldByText(labelElement)).getAttribute("value");
	}

	public void typeAndWait(String labelElement, String value) {
		String xpathElement = getInputFieldByText(labelElement);
		$(xpathElement).typeAndTab(value);
		waitForAllJSCompletes();
	}

	public String getXpathRadioByText(String rowTitle, String optionText) {
		return "(//*[text()='" + rowTitle + "']/ancestor-or-self"
				+ "::td/following-sibling" + "::td//label[text()='"
				+ optionText + "']/preceding-sibling" + "::input)[1]";
	}

	public boolean getChecked(String rowTitle, String optionText) {
		String valueCheck = $(getXpathRadioByText(rowTitle, optionText))
				.getAttribute("checked");

		if (valueCheck != null)
			return true;
		else
			return false;
	}

	public void checkRadio(String rowTitle, String optionText) {
		String xpathElement = getXpathRadioByText(rowTitle, optionText);
		$(xpathElement).click();
		waitForAllJSCompletes();
	}

	public String getXpathCheckboxByText(String checkboxOption) {
		return "(((//*[text()='"
				+ checkboxOption
				+ "']//ancestor::td)[last()])/preceding-sibling::td)[last()]//input[@type='checkbox']";
	}

	public void selectCheckbox(String listCheckbox) {
		if (listCheckbox != null) {
			String[] checkboxes = listCheckbox.split(",");
			for (int i = 0; i < checkboxes.length; i++) {
				LogWork.log_debug(">> debug: | Select Checkbox | "
						+ checkboxes[i]);
				String xpathElement = getXpathCheckboxByText(checkboxes[i]
						.trim());
				if ($(xpathElement).getAttribute("checked") == null)
					$(xpathElement).click();
			}
		}
		waitForAllJSCompletes();
	}

	// swicth tab
	public String getTabByText(String labelTab) {
		String element = "//table[@class='rich-tabpanel']//*[text()='"
				+ labelTab + "']";
		findBy(element).waitUntilPresent().waitUntilEnabled();
		return element;
	}

	public boolean getStatusOfTab(String labelText) {
		String element = getTabByText(labelText);
		return $(element).getAttribute("class").contains(
				"rich-tab-header rich-tab-inactive");
	}

	/***
	 * @param _companies
	 *            = all => check all company _companies = mull => check default
	 *            company _companies = a list company => check company follow
	 *            list
	 * @author nancy
	 */
	public void selectCompany(List<String> _companies) {
		if (_companies.size() > 0) {
			if (_companies.size() == 1
					&& _companies.get(0).trim().toLowerCase().equals("all")) {
				$("//*[.='Tag']/input").click();
				waitForAllJSCompletes();
			} else {
				for (int i = 0; i < _companies.size(); i++) {
					chooseCompany(_companies.get(i));
				}
			}
		}
	}

	/**
	 * Get result search at row=rowIndex
	 * 
	 * @author Nancy
	 */
	// xPath of Model Panel Window
	private String xModelPanel = "//table[@id='searchModalPanelContentTable']";

	public boolean getResultSearch(String labelName, String valueSearch) {
		String xPathFirstRow = "//tbody[@id='searchResult_Form:searchResult_Table:tb']//*[text()='"
				+ valueSearch.toUpperCase() + "']";
		if (findAll(xPathFirstRow).size() > 0) {
			if ($(xPathFirstRow).getText().toLowerCase()
					.equals(valueSearch.toLowerCase())) {
				$(xPathFirstRow).waitUntilClickable().click();
				waitForAllJSCompletes();
				return true;
			}
		}
		return false;
	}

	/**
	 * @param searchBtnName
	 * @param labelName
	 * @param valueDelete
	 * @author nancy
	 */
	public void deleteValueBySearchBtn(String searchBtnName, String labelName,
			String valueDelete) {
		clickBtn(searchBtnName);
		if (getResultSearch(labelName, valueDelete)) {
			clickBtn("Delete");
			chooseYesOnUpdateConfirmation();
			chooseOKOnInfoPanel();
		} else {
			String xCloseIcon = xModelPanel
					+ "/preceding-sibling::div//a[@href]";
			$(xCloseIcon).waitUntilClickable().click();
			waitForAllJSCompletes();
		}
	}

	public void chooseOkInErrorMessage() {
		String xOkBtn = "//*[@id='ErrorForm:OKButton']";
		clickOnElement(xOkBtn);
		waitForAllJSCompletes();
	}

	// nancy
	public String getToday() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	// nancy
	public String autoGenCode(String prefix) {
		return autoGenCode(prefix, 12);
	}

	public String autoGenCode(String prefix, int addmore) {
		if (addmore == 8) {
			String a = new SimpleDateFormat("dd/MM HH:mm").format(new Date());
			prefix += a.replace("/", "").replace(":", "").replace(" ", "")
					.trim();
			return prefix;
		} else if (addmore == 10) {
			String a = new SimpleDateFormat("dd/MM HH:mm:ss")
					.format(new Date());
			prefix += a.replace("/", "").replace(":", "").replace(" ", "")
					.trim();
			return prefix;
		} else {
			String a = new SimpleDateFormat("dd/MM/yy HH:mm:ss")
					.format(new Date());
			prefix += a.replace("/", "").replace(":", "").replace(" ", "")
					.trim();
			return prefix;
		}
	}

	public void switchToIFrame(String idIFrame) {
		getDriver().switchTo().frame(idIFrame);
		waitABit(300);
	}

	public void switchToIFrame() {
		switchToIFrame("th5frame");
	}

	/**
	 * @Description: To switch out default iframe
	 * @author Nancy
	 */
	public void switchOutDefaultIFrame() {
		getDriver().switchTo().defaultContent();
	}

	/**
	 * Check function Preview in History Tab
	 * 
	 * @author Nancy
	 */
	public void clickPreviewHST(String colName, String noVCH) {
		clickPreviewHST(colName, noVCH, "");
	}

	public void clickPreviewHST(String colName, String noVCH, String nameReport) {
		waitForAllJSCompletes();
		switch_to_tab("History");
		waitForAllJSCompletes();
		setTextTableFilter(colName, noVCH);
		waitForAllJSCompletes();
		clickPreviewBtn(nameReport);
		clickBtn("Done");
		waitForAllJSCompletes();
		clickBtn("Back To Summary");
	}

	public void clickPreviewBtn(String nameReport) {
		clickBtn("Preview");
		waitForAllJSCompletes();

		String xReportTb = "//form[@id='reportSelectionForm']";

		String xReport = "";
		String xDoneBtn = xReportTb
				+ "//input[@type='button' and @value='Done']";
		if (nameReport.equals("")) {
			xReport = "(" + xReportTb + "//tbody//a[@href and text()])[1]";
		} else {
			xReport = "(" + xReportTb + "//tbody//a[text()='" + nameReport
					+ "' and @href])[1]";
		}
		if (isElementExist(xReport)) {
			clickOnElement(xReport);
			clickOnElement(xDoneBtn);
		}
		waitForAllJSCompletes();
	}

	public void clickPreviewBtn() {
		clickPreviewBtn("");
	}

	/**
	 * Radio element is checked or unchecked
	 * 
	 * @author Jacob
	 * @param lableText
	 * @param value
	 * @return String
	 */
	public String isChecked(String lableText, String value) {
		String expect = $(
				"//*[text()='" + lableText + "']/following::label[text()='"
						+ value + "']/preceding-sibling::input[last()]")
				.getAttribute("checked");

		if (expect.equals("true"))
			return "checked";
		else
			return "unchecked";
	}

	/**
	 * Verify record has already exists in database
	 * 
	 * @param Table
	 *            Name
	 * @param Col
	 *            Name
	 * @param Value
	 * @return
	 */
	public String check_database_exist(String table, String codeCol,
			String value) {
		String sql_query = "SELECT * FROM " + table + " WHERE " + codeCol
				+ " = '" + value + "'";
		ResultSet rs = null;
		ConnectDatabase.connect();
		rs = ConnectDatabase.executeQuery(sql_query);

		String result = "";
		try {
			while (rs.next()) {
				result = rs.getString(codeCol);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectDatabase.close();
		return result;
	}

	public boolean searchAndSelectByInputCode(String labelName, String _value) {
		waitTypeAndEnter(
				xPathInputFieldWithLabel("//table[contains(@id,'search')]",
						labelName, 1), _value);
		setImplicitTimeout(10, TimeUnit.SECONDS);
		//WebElementFacade ret = waitElementToBeVisible("(//form[@id='searchResult_Form']//*[.='No Records Found!'] | //form[@id='searchResult_Form']//td//a | //form[@id='searchResult_Form']//td//a//span)[1]");
		setImplicitTimeout(2, TimeUnit.SECONDS);
		List<WebElementFacade> results = findAll("//form[@id='searchResult_Form']//*[.='No Records Found!'] | //form[@id='searchResult_Form']//td//a | //form[@id='searchResult_Form']//td//a//span");

		int count = results.size();

		for (int j = 0; j < count; j++) {
			String text = "";
			String value = "";
			try {
				text = results.get(j).getText();
			} catch (Exception e) {
				text = "";
			}
			try {
				value = results.get(j).getValue();
			} catch (Exception e) {
				value = "";

			}
			if ((text != null) && text.contains("no records found")) {
				return false;
			} else {
				if (((text != null) && text.equals(_value))
						|| ((value != null) && value.equals(_value))) {
					clickOnElement("//form[@id='searchResult_Form']//td//a[.='"
							+ _value + "']");
					return true;
				}
			}
		}
		return false;
	}
		
	public void closePopup() {
		String xCloseIcon = xPopupDiv
				+ "//a[@href][child::img[contains(@src,'/TH5Web/img/close-icon.')]]";
		$(xCloseIcon).waitUntilClickable().click();
		waitForAllJSCompletes();
	}
	
	public boolean compareData(List<List<String>> actualTable,
			List<List<String>> expectedTable) {
		boolean result = false;
		int flag = 0;
		for (int i = 1; i < expectedTable.size(); i++) {
			List<String> rowActual = actualTable.get(i);
			List<String> rowExpected = expectedTable.get(i);

			for (int j = 0; j < rowExpected.size(); j++) {
				if (!rowActual.get(j).toUpperCase()
						.equals(rowExpected.get(j).toUpperCase())) {
					flag += 1;
				}
			}
		}
		if (flag > 0)
			result = false;
		else
			result = true;
		return result;
	}
	/**
	 * @Description: Delete Value
	 * @param nameSearchBtn
	 *            - Name Btn to Search
	 * @param labelName
	 *            - Name label to type value and search
	 * @param valueSearch
	 * @author Nancy
	 */
	public void deleteValueByFilter(String filterNameCol, String valueDelete) {
		String xHeaderCell = xPathTbHeaderCell(filterNameCol);
		int colIndex = getTbColHeaderIndex(xHeaderCell);

		filterDataByHeader(xHeaderCell, valueDelete);
		waitForAllJSCompletes();
		String xFirstRow = xHeaderCell
				+ "/ancestor::thead/following-sibling::tbody/tr[1]/td["
				+ colIndex + "]/a[@href]";
		if (findAll(xFirstRow).size() > 0) {
			if ($(xFirstRow).getText().toLowerCase()
					.equals(valueDelete.toLowerCase())) {
				$(xFirstRow).waitUntilClickable().click();
				waitForAllJSCompletes();
				clickBtn("Delete");
				chooseYesOnUpdateConfirmation();
			}
		}
	}
	/**
	 * Add/Subtract day to the Date
	 * 
	 * @param days
	 *            > 0 is add more; days < 0 is subtract
	 * 
	 * */
	public String addDays(String sDate, int days) {
		return DateTimeUtil.addDays(sDate, days);
	}

	/**
	 * 
	 * @author Nancy
	 */
	public void clickPreviewHST(String xParentTb, String colName, String noVCH,
			String nameReport) {
		waitForAllJSCompletes();
		switch_to_tab("History");
		waitForAllJSCompletes();
		if (setTextTableFilter(xParentTb, colName, noVCH)) {
			waitForAllJSCompletes();
			clickPreviewBtn(nameReport);
			waitForAllJSCompletes();
			clickBtn("Back To Summary");
		}
	}

	/**
	 * 
	 * @author Nancy
	 */
	public void clickPreviewBtn2(String nameReport) {
		clickBtn("Preview");
		waitForAllJSCompletes();

		String xReportTb = "//form[@id='reportSelectionForm']";

		String xReportName = "(" + xReportTb + "//tbody//a[text()='"
				+ nameReport + "' and @href])[1]";

		if (findAll(xReportTb).size() > 0) {
			clickOnElement(xReportName);
			clickBtn(xReportTb, "Done");
			waitForAllJSCompletes();
		}
	}
	
	/**
	 *
	 * @author Nancy
	 */
	public boolean setTextTableFilter(String colName, String value) {
		return setTextTableFilter("", colName, value);
	}

	public boolean setTextTableFilter(String xParentTb, String colName,
			String value) {
		int colIndex = getTbColHeaderIndex(xParentTb, colName);
		waitTypeAndEnter("(" + xPathTbHeaderCell(xParentTb, colName)
				+ "//input)[1]", value);
		waitForAllJSCompletes();
		String xRowSelect = xParentTb + "/tbody/tr[child::td[" + colIndex
				+ " and descendant-or-self::*[text()='" + value.toUpperCase()
				+ "']]]/td[" + colIndex + "]//a[@href]";
		try {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
			return true;
		} catch (Exception ex) {
			System.out.println("***[ERROR MESSAGE]***" + ex);
			return false;
		}
	}

	/**
	 * @Desc: Using to search Bank after click Search Button If Bank Account No
	 *        is blank, default select the first search result list
	 * @author Nancy
	 */
	public boolean searchBankAccount(String bankPartyCode, String bankAccountNo) {
		String xParent = "//table[@id='searchModalPanelContentTable']";
		String xSearchResultTb = "//table[@id='searchResult_Form:searchResult_Table']";
		String xClose = "//div[following-sibling::" + xParent + "]//a[@href]";

		enterInputFieldWithLabel(xParent, "Bank Party Code", bankPartyCode);
		waitForAllJSCompletes();

		int colBankCode = getTbColHeaderIndex(xSearchResultTb,
				"Bank Party Code");
		String xRowSelect = "";
		if (bankAccountNo.isEmpty()) {
			xRowSelect = xSearchResultTb + "/tbody/tr[child::td[" + colBankCode
					+ " and descendant-or-self::*[text()='"
					+ bankPartyCode.toUpperCase() + "']]][1]";

		} else {
			int colBankNo = getTbColHeaderIndex(xSearchResultTb,
					"Bank Account No");
			xRowSelect = xSearchResultTb + "/tbody/tr[child::td[" + colBankCode
					+ " and descendant-or-self::*[text()='"
					+ bankPartyCode.toUpperCase() + "']] and child::td["
					+ colBankNo + " and descendant-or-self::*[text()='"
					+ bankAccountNo.toUpperCase() + "']]]";
		}
		try {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
			return true;
		} catch (Exception ex) {
			System.out.println("***[ERROR MESSAGE]*** " + ex);
			clickOnElement(xClose);
			waitForAllJSCompletes();
			return false;
		}
	}

	/**
	 * 
	 * @author Nancy
	 */
	public boolean searchBankAccount(String bankPartyCode) {
		return searchBankAccount(bankPartyCode, "");
	}

	/**
	 * @Desc: Using to filter data in the table
	 * @param xParentTable
	 *            is xPath Table
	 * @param columnName
	 * @param value
	 * @author Nancy
	 */
	public boolean searchByFilter(String xParentTable, String columnName,
			String value, int resOder) {
		int colIndex = getTbColHeaderIndex(xParentTable, columnName);
		waitTypeAndEnter("(" + xPathTbHeaderCell(xParentTable, columnName)
				+ "//input[@type='text'])[" + resOder + "]", value);

		String xRowSelect = xParentTable + "/tbody/tr[child::td[" + colIndex
				+ " and descendant-or-self::*[text()='" + value.toUpperCase()
				+ "']]]//a[@href]";
		if (findAll(xRowSelect).size() > 0) {
			clickOnElement(xRowSelect);
			waitForAllJSCompletes();
			return true;
		}
		return false;
	}

	/**
	 * @Desc: Using to filter data in the table
	 * @param xParentTable
	 *            is xPath Table
	 * @param columnName
	 * @param value
	 * @author Nancy
	 */
	public boolean searchByFilter(String xParentTable, String columnName,
			String value) {
		return searchByFilter(xParentTable, columnName, value, 1);
	}

	/**
	 * 
	 * @author Nancy
	 */
	public void setDataToNewSession(String data, String ssSessionKey) {
		List<String> list = new ArrayList<>();
		list.add(data);
		Serenity.setSessionVariable(ssSessionKey).to(list);
	}

	/**
	 * 
	 * @author Nancy
	 */
	public void setDataToSession(String data, String ssSessionKey) {
		List<String> list = new ArrayList<>();
		list = Serenity.sessionVariableCalled(ssSessionKey);
		if (list==null)
			list = new ArrayList<>();
		list.add(data);
		Serenity.setSessionVariable(ssSessionKey).to(list);
	}

	/**
	 * 
	 * @author Nancy
	 */
	public String getDataWithSession(String ssSessionKey, int index) {
		List<String> listNo = new ArrayList<>();
		listNo = Serenity.sessionVariableCalled(ssSessionKey);
		if(index==999){
			index=listNo.size()-1;
		}
		return listNo.get(index).trim();
	}

	/**
	 * 
	 * @author Nancy
	 */
	public List<String> getDataWithSession(String ssSessionKey) {
		List<String> listNo = new ArrayList<>();
		listNo = Serenity.sessionVariableCalled(ssSessionKey);
		return listNo;
	}
}