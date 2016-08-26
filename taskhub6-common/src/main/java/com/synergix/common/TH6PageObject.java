package com.synergix.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;
import com.synergix.utilities.LoadObject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Vincent
 * @version 20151211
 * @Description A base class representing a WebDriver page object. This class
 * extends core PageObject class and we can add common methods for
 * TH5 site. Using likes PageObject class. WARNING: Please,
 * consider carefully when CRUD this class and set public method.
 * Don't create specific page here.
 */
public abstract class TH6PageObject extends PageObject
{

    // #Region#Construction
    protected TH6PageObject()
    {
        super();
        setImplicitTimeout(5, TimeUnit.SECONDS);
        try
        {
            SETTING = LoadObject.loading_config_sys("serenity.properties");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    protected TH6PageObject(WebDriver driver, Predicate<? super net.serenitybdd.core.pages.PageObject> callback)
    {
        super(driver, callback);
        try
        {
            SETTING = LoadObject.loading_config_sys("serenity.properties");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public TH6PageObject(WebDriver driver, int ajaxTimeout)
    {
        super(driver, ajaxTimeout);
        try
        {
            SETTING = LoadObject.loading_config_sys("serenity.properties");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public TH6PageObject(WebDriver driver)
    {
        super(driver);
        try
        {
            SETTING = LoadObject.loading_config_sys("serenity.properties");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    // #EndRegion#Construction

    /**
     * Jacob common
     * Use to move tab on Employee screen
     */
    public void moveToTab(String _tabNameOfEmployeeScreen)
    {
        String xTab = "//button[child::*[text()='" + _tabNameOfEmployeeScreen + "']]";
        $(xTab).waitUntilClickable().click();
        waitForAllJSCompletes();
    }

    public void back_to_summary()
    {
        clickBtn("Back To Summary");
        waitForAllJSCompletes();
    }

    public static Properties SETTING = null;

    // End Jacob common

    // #Region#Common wait

    /**
     * @param _timeoutInSeconds Timeout In Seconds
     * @Description Wait for A4J complete
     * @author Vincent
     */
    public void waitUntilA4JRequestCompletes(int _timeoutInSeconds)
    {

    }

    /**
     * @param _timeoutInSeconds Timeout In Seconds
     * @Description Wait for jQuery complete
     * @author Vincent
     */
    public void waitUntiljQueryRequestCompletes(int _timeoutInSeconds)
    {
        new FluentWait<WebDriver>(getDriver()).withTimeout(_timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).until(
                new ExpectedCondition<Boolean>()
                {
                    public Boolean apply(WebDriver d)
                    {
                        try
                        {
                            JavascriptExecutor jsExec = (JavascriptExecutor) d;
                            return (Boolean) jsExec.executeScript("return jQuery.active == 0");
                        } catch (Exception e)
                        {
                            return true;
                        }
                    }
                });
    }

    /**
     * @param _timeoutInSeconds Timeout In Seconds
     * @Description Wait for Ajax complete
     * @author Vincent
     */
    public void waitUntilAjaxCompletes(int _timeoutInSeconds)
    {
        new FluentWait<WebDriver>(getDriver()).withTimeout(_timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).until(
                new ExpectedCondition<Boolean>()
                {
                    public Boolean apply(WebDriver d)
                    {
                        try
                        {
                            JavascriptExecutor jsExec = (JavascriptExecutor) d;
                            return (Boolean) jsExec.executeScript("return Ajax.activeRequestCount == 0");
                        } catch (Exception e)
                        {
                            return true;
                        }
                    }
                });
    }

    /**
     * @param _timeoutInSeconds Timeout In Seconds
     * @Description Wait for HTML ready
     * @author Vincent
     */
    public void waitUntilHTMLReady(int _timeoutInSeconds)
    {
        new FluentWait<WebDriver>(getDriver()).withTimeout(_timeoutInSeconds, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).until(
                new ExpectedCondition<Boolean>()
                {
                    public Boolean apply(WebDriver d)
                    {
                        try
                        {
                            JavascriptExecutor jsExec = (JavascriptExecutor) d;
                            return (Boolean) jsExec.executeScript("return document.readyState=='complete'");
                        } catch (Exception e)
                        {
                            return true;
                        }
                    }
                });
    }

    /**
     * @Description : Waiting for all HTML, JS, Ajax, A4J in TH5 finish when
     * doing any action. Using before or after each action.
     * @author ???
     */
    public void waitForAllJSCompletes()
    {
        String xPro = "//img[contains(@src, 'ajax-loader')]";
        if (isElementVisible(xPro, 120))
        {
            waitForElementToVanish(xPro, 600);
        }
    }

    /**
     * @param wE     WebElementFacade
     * @param _value Value
     * @return WebElementFacade
     * @Description Wait for given text to be present in element value.
     * @author Vincent
     */
    public WebElementFacade waitTextToBePresentInElementValue(WebElementFacade _wE, String _value)
    {
        waitForAllJSCompletes();
        waitFor(ExpectedConditions.textToBePresentInElementValue(_wE, _value));
        return _wE;
    }

    /**
     * @param _xPath XPath of web element
     * @param _value Value
     * @return WebElementFacade
     * @Description Wait for given text to be present in element value.
     * @author Vincent - Tested
     */
    public WebElementFacade waitTextToBePresentInElementValue(String _xPath, String _value)
    {
        waitFor(ExpectedConditions.textToBePresentInElementValue(By.xpath(_xPath), _value));
        return findBy(_xPath);
    }

    /**
     * @param _xPath XPath of web element
     * @param _value Value
     * @return WebElementFacade
     * @Description Wait for given text to be present in element.
     * @author Vincent
     */
    public WebElementFacade waitTextToBePresentInElement(String _xPath, String _value)
    {
        waitForAllJSCompletes();
        waitFor(ExpectedConditions.textToBePresentInElement(By.xpath(_xPath), _value));
        return findBy(_xPath);
    }

    /**
     * @param _xPath
     * @return WebElementFacade
     * @Description Wait for element to be present.
     * @author Vincent - Tested
     */
    public WebElementFacade waitElementToBePresent(String _xPath)
    {
        waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(_xPath)));
        return findBy(_xPath);
    }

    /**
     * @param _xPath
     * @return WebElementFacade
     * @Description Wait for element to be visible.
     * @author Vincent - Tested
     */
    public WebElementFacade waitElementToBeVisible(String _xPath, int timeOut)
    {
        setImplicitTimeout(timeOut, TimeUnit.MILLISECONDS);
        findBy(_xPath).waitUntilVisible();
        resetImplicitTimeout();
        return findBy(_xPath);
    }

    /**
     * @author ???
     */

    public void waitForElementToVanish(String xPathCSS, long timeOut)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
            if (xPathCSS.contains("@") || xPathCSS.contains("//"))
            {// xpath
                while (!wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xPathCSS))))
                {
                    sleep(0.2);
                    
                }
            }
            else
            {// css
                while (!wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(xPathCSS))))
                {
                    sleep(0.2);
                }
            }
        } catch (Exception e)
        {
        }
    }

    private void sleep(double d)
    {
        try
        {
            Thread.sleep((long) d);
        } catch (Exception e)
        {

        }

    }

    /**
     * @param _xPath
     * @return WebElementFacade
     * @Description Wait for element to be present then scroll into view of
     * element.
     * @author Vincent - Tested
     */
    public WebElementFacade waitElementToBePresentThenScrollIntoView(String _xPath)
    {
        waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(_xPath)));
        scrollIntoElementView(_xPath);
        highlightElement(_xPath);
        return findBy(_xPath);
    }

    /**
     * @param _xPath
     * @Description Scroll into view of element.
     * @author Vincent - Tested
     */
    public void scrollIntoElementView(String _xPath)
    {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(false);", findBy(_xPath));
        waitABit(15);
    }

    /**
     * @param _wE
     * @return WebElementFacade
     * @Description Scroll into view of element.
     * @author Vincent
     */
    public WebElementFacade scrollIntoElementView(WebElementFacade _wE)
    {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(false);", _wE);
        waitABit(15);
        return _wE;
    }

    /**
     * @param _xPath
     * @return WebElementFacade
     * @Description Wait for element to be clickable.
     * @author Vincent - Tested
     */
    public WebElementFacade waitElementToBeClickable(String _xPath)
    {
        waitElementToBePresentThenScrollIntoView(_xPath);
        waitFor(ExpectedConditions.elementToBeClickable(By.xpath(_xPath)));
        highlightElement(_xPath);
        return findBy(_xPath);
    }

    /**
     * @param _xPath XPath of web element
     * @param _value
     * @Description Wait for element to be input, type given value and enter
     * then wait for element update value and element change state
     * to read only.
     * @author Vincent
     */
    public void waitTypeAndEnterThenUpdateValueReadOnly(String _xPath, String _value)
    {
        waitElementToBePresentThenScrollIntoView(
                _xPath + "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]").waitUntilEnabled().waitUntilVisible().typeAndEnter(
                _value);
        waitTextToBePresentInElementValue(_xPath + "[@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled']",
                                          _value).shouldBePresent();
        // findBy(xPath).findBy("./self::*[@readonly='readonly']").shouldBePresent();
    }

    /**
     * @param _xPath
     * @param _value
     * @Description Wait for element to be input, type given value and enter
     * then wait for element update value and element change state
     * to link text.
     * @author Vincent
     */
    public void waitTypeAndEnterThenLink(String _xPath, String _value)
    {
        waitElementToBePresentThenScrollIntoView(
                _xPath + "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]").waitUntilEnabled().waitUntilVisible().typeAndEnter(
                _value);
        _xPath = _xPath.substring(0, _xPath.lastIndexOf("input"));
        waitElementToBePresent(_xPath + "a[text()='" + _value + "']").shouldBePresent();
    }

    /**
     * @param _xPath
     * @param _value
     * @Description Using with label is Date Wait for element to be input, type
     * given value and enter then wait for element update value.
     * NOTE: if existed value equal to new value, it will keep
     * existed value.
     * @author Nancy
     */
    public void waitTypeAndEnterThenUpdateDate(String _xPath, String _value)
    {
        if (!waitElementToBePresentThenScrollIntoView(_xPath).getTextValue().equals(_value))
        {
            waitElementToBePresentThenScrollIntoView(
                    _xPath + "[not(@readonly='readonly' or @readonly='true' or	 @disabled='true' or @disabled='disabled')]").waitUntilEnabled().waitUntilVisible().click();
            if (!$(_xPath).getAttribute("value").isEmpty())
            {
                $(_xPath).sendKeys(Keys.chord(Keys.CONTROL, "a"));
                $(_xPath).sendKeys(Keys.DELETE);
            }

            waitElementToBePresentThenScrollIntoView(
                    _xPath + "[not(@readonly='readonly' or @readonly='true' or	 @disabled='true' or @disabled='disabled')]").waitUntilEnabled().waitUntilVisible().sendKeys(
                    _value);
            waitElementToBePresentThenScrollIntoView(
                    _xPath + "[not(@readonly='readonly' or @readonly='true' or	 @disabled='true' or @disabled='disabled')]").waitUntilEnabled().waitUntilVisible().sendKeys(
                    Keys.TAB);
            waitTextToBePresentInElementValue(_xPath, _value);
        }
        waitForAllJSCompletes();
    }
	 /**
     * @param _xPath
     * @param _value
     * @Description Using with label is Date Wait for element to be input, type
     * given value and enter then wait for element update value.
     * NOTE: if existed value equal to new value, it will keep
     * existed value.
     * @author Lily
     */
    public void waitTypeAndTabEnterThenUpdateDate(String _xPath, String _value)
    {
        if (!waitElementToBePresentThenScrollIntoView(_xPath).getTextValue().equals(_value))
        {
            waitElementToBePresentThenScrollIntoView(
                    _xPath + "[not(@readonly='readonly' or @readonly='true' or	 @disabled='true' or @disabled='disabled')]").waitUntilEnabled().waitUntilVisible().click();
            if (!$(_xPath).getAttribute("value").isEmpty())
            {
                $(_xPath).sendKeys(Keys.chord(Keys.CONTROL, "a"));
                $(_xPath).sendKeys(Keys.DELETE);
            }

            waitElementToBePresentThenScrollIntoView(
                    _xPath + "[not(@readonly='readonly' or @readonly='true' or	 @disabled='true' or @disabled='disabled')]").waitUntilEnabled().waitUntilVisible().sendKeys(
                    _value);
            waitElementToBePresentThenScrollIntoView(
                    _xPath + "[not(@readonly='readonly' or @readonly='true' or	 @disabled='true' or @disabled='disabled')]").waitUntilEnabled().waitUntilVisible().sendKeys(
                    Keys.ENTER);
            waitTextToBePresentInElementValue(_xPath, _value);
        }
        waitForAllJSCompletes();
    }

    /**
     * @param _xPath
     * @param _value
     * @Description Wait for element to be input, type given value and enter
     * then wait for element update value. NOTE: if existed value
     * equal to new value, it will keep existed value.
     * @author Vincent - Tested
     */
    public void waitTypeAndEnterThenUpdateValue(String _xPath, String _value)
    {
        if (!waitElementToBePresentThenScrollIntoView(_xPath).getTextValue().equals(_value))
        {
            waitElementToBePresentThenScrollIntoView(
                    _xPath + "[not(@readonly='readonly' or @readonly='true' or	 @disabled='true' or @disabled='disabled')]").waitUntilEnabled().waitUntilVisible().typeAndEnter(
                    _value);
            waitTextToBePresentInElementValue(_xPath, _value);
        }
        waitForAllJSCompletes(); // Nancy Add
    }

    /**
     * Using for lable auto Upper Value
     *
     * @param _xPath
     * @param _value
     * @Description Wait for element to be input, type given value and enter
     * then wait for element update value. NOTE: if existed value
     * equal to new value, it will keep existed value.
     * @author Nancy
     */
    public void waitTypeAndEnterThenUpdateCodeValue(String _xPath, String _value)
    {
        if (!waitElementToBePresent(_xPath).getTextValue().equals(_value))
        {
            waitElementToBePresentThenScrollIntoView(
                    _xPath + "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]").waitUntilEnabled().waitUntilVisible().type(
                    _value);
            waitTextToBePresentInElementValue(_xPath, _value.toUpperCase());
        }
        waitForAllJSCompletes();// Nancy Add
    }

    /**
     * @param _xPath
     * @param _value
     * @Description Wait for element to be input, type given value and enter
     * then wait for element change to no input element.
     * @author Vincent
     */
    public void waitTypeAndEnterThenNoInput(String _xPath, String _value)
    {
        waitElementToBePresentThenScrollIntoView(
                _xPath + "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]").waitUntilEnabled().waitUntilVisible().typeAndEnter(
                _value);
        _xPath = _xPath.substring(0, _xPath.lastIndexOf("//input"));
        waitTextToBePresentInElement(_xPath, _value);
    }

    /**
     * @param _xPath
     * @param _value
     * @Description Wait for element to be input, type given value and tab then
     * wait for element update value. NOTE: if existed value equal
     * to new value, it will keep existed value.
     * @author Vincent - Tested
     */
    public void waitTypeAndTabThenUpdateValue(String _xPath, String _value)
    {
        if (!waitElementToBePresent(_xPath).getTextValue().equals(_value))
        {
            waitElementToBePresentThenScrollIntoView(
                    _xPath + "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]").waitUntilEnabled().waitUntilVisible().typeAndTab(
                    _value);
            waitTextToBePresentInElementValue(_xPath, _value);
        }
        waitForAllJSCompletes();// Nancy Add
    }

    /**
     * @param _xPath
     * @param _value
     * @Description Wait for element to be input, type given value and tab then
     * wait for element update text.
     * @author Vincent
     */
    public void waitTypeAndTabThenUpdateText(String _xPath, String _value)
    {
        waitElementToBePresentThenScrollIntoView(
                _xPath + "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]").waitUntilEnabled().waitUntilVisible().typeAndEnter(
                _value);
        waitTextToBePresentInElement(_xPath, _value);
        waitForAllJSCompletes();// Nancy Add
    }

    /**
     * @param _xPath
     * @param _value
     * @Description Wait for element to be input, type given value and tab then
     * wait for 0.5 second.
     * @author Vincent
     */
    public void waitTypeAndTab(String _xPath, String _value)
    {
        waitElementToBePresentThenScrollIntoView(
                _xPath + "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]").waitUntilEnabled().typeAndTab(
                _value);
        waitABit(500);
    }

    /**
     * @param _xPath
     * @param _value
     * @Description Wait for element to be input, type given value and enter
     * then wait for 0.5 second.
     * @author Vincent - Tested
     */
    public void waitTypeAndEnter(String _xPath, String _value)
    {
        waitElementToBePresentThenScrollIntoView(
                _xPath + "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]").waitUntilEnabled().waitUntilVisible().typeAndEnter(
                _value);
        waitABit(500);
    }

    /**
     * @param xPath
     * @param _timeoutInSeconds
     * @return boolean
     * @Description Check for element exist or not with timeout.
     * @author Vincent
     */
    public boolean isElementExist(String xPath, int _timeoutInSeconds)
    {
        // return !withTimeoutOf(_timeoutInSeconds,
        // TimeUnit.SECONDS).findAll(xPath).isEmpty();
        try
        {
            setImplicitTimeout(_timeoutInSeconds, TimeUnit.SECONDS);
            waitElementToBePresent("(" + xPath + ")[1]");
            resetImplicitTimeout();
            return true;
        } catch (Exception e)
        {
            resetImplicitTimeout();
        }
        return false;
    }

    /**
     * @param xPath
     * @param _timeoutInSeconds
     * @return boolean
     * @Description Check for element exist or not with timeout (Not wait for
     * A4J).
     * @author Vincent
     */
    public boolean isElementExistNoA4J(String xPath, int _timeoutInSeconds)
    {
        try
        {
            setImplicitTimeout(_timeoutInSeconds, TimeUnit.SECONDS);
            waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath("(" + xPath + ")[1]")));
            resetImplicitTimeout();
            return true;
        } catch (Exception e)
        {
            resetImplicitTimeout();
        }
        return false;
    }

    /**
     * @param xPath
     * @param _timeoutInSeconds
     * @return boolean
     * @Description Check for element visible or not with timeout (Not wait for
     * A4J).
     * @author Vincent
     */
    public boolean isElementVisibleNoA4J(String xPath, int _timeoutInSeconds)
    {
        try
        {
            setImplicitTimeout(_timeoutInSeconds, TimeUnit.SECONDS);
            waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("(" + xPath + ")[1]")));
            resetImplicitTimeout();
            return true;
        } catch (Exception e)
        {
            resetImplicitTimeout();
        }
        return false;
    }

    /**
     * @param xPath
     * @param _timeoutInSeconds
     * @return boolean
     * @Description Check for element visible or not with timeout.
     * @author Vincent - Tested
     */
    public boolean isElementVisible(String xPath, int _timeoutInSeconds)
    {
        try
        {
            waitElementToBeVisible("(" + xPath + ")[1]", _timeoutInSeconds);
            return true;
        } catch (Exception e)
        {
            resetImplicitTimeout();
        }
        return false;
    }

    /**
     * @param xPath
     * @return boolean
     * @Description Check for element exist or not with default timeout is 2
     * seconds.
     * @author Vincent - Tested
     */
    public boolean isElementExist(String xPath)
    {
        return isElementExist(xPath, 2);
    }

    // #EndRegion#Common wait

    // #Region Drop Down List

    /**
     * @param _xPathDll
     * @param _value
     * @Description Select Drop Down List option by text.
     * @author Vincent
     */
    public void selectDdlByText(String _xPathDll, String _value)
    {
        if (!waitElementToBePresent(_xPathDll).getSelectedVisibleTextValue().equals(_value))
        {
            waitElementToBePresentThenScrollIntoView(_xPathDll).selectByVisibleText(_value);
            waitElementToBePresent(_xPathDll).shouldContainSelectedOption(_value);
        }
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @param _resOrder
     * @return
     * @Description Get xPath of Drop Down List besides Label
     * @author Vincent
     */
    public String xPathDdlWithLabel(String _parentXpath, String _labelName, int _resOrder)
    {
        return "(" + _parentXpath + "//td//descendant-or-self::*[text()='" + _labelName + "']/ancestor-or-self::td[1]/following-sibling::td//select)[" + _resOrder + "]";
    }

    /**
     * @param _labelName
     * @param _resOrder
     * @return
     * @Description Get xPath of Drop Down List besides Label
     * @author Vincent
     */
    public String xPathDdlWithLabel(String _labelName, int _resOrder)
    {
        return xPathDdlWithLabel("", _labelName, _resOrder);
    }

    /**
     * @param _labelName
     * @return
     * @Description Get xPath of Drop Down List besides Label
     * @author Vincent
     */
    public String xPathDdlWithLabel(String _labelName)
    {
        return xPathDdlWithLabel("", _labelName, 1);
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @param _resOrder
     * @param _value
     * @Description Select option of Drop Down List besides Label by text.
     * @author Vincent
     */
    public void selectDdlWithLabelByText(String _parentXpath, String _labelName, int _resOrder, String _value)
    {
        selectDdlByText(xPathDdlWithLabel(_parentXpath, _labelName, _resOrder), _value);
    }

    /**
     * @param _labelName
     * @param _resOrder
     * @param _value
     * @Description Select option of Drop Down List besides Label by text.
     * @author Vincent
     */
    public void selectDdlWithLabelByText(String _labelName, int _resOrder, String _value)
    {
        selectDdlByText(xPathDdlWithLabel("", _labelName, _resOrder), _value);
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @param _value
     * @Description Select option of Drop Down List besides Label by text.
     * @author Vincent
     */
    public void selectDdlWithLabelByText(String _parentXpath, String _labelName, String _value)
    {
        selectDdlByText(xPathDdlWithLabel(_parentXpath, _labelName, 1), _value);
    }

    /**
     * @param _labelName
     * @param _value
     * @Description Select option of Drop Down List besides Label by text.
     * @author Vincent
     */
    public void selectDdlWithLabelByText(String _labelName, String _value)
    {
        selectDdlByText(xPathDdlWithLabel("", _labelName, 1), _value);
    }

    // #EndRegion Drop Down List

    // #Region Tab.
    // BEGIN: switch tab

    /**
     * @param _parentXpath
     * @param _tabName
     * @return WebElementFacade
     * @Description Find tab by given tab name and parent xPath. Return first
     * element if find out more than one element.
     * @author Vincent
     */
    public WebElementFacade findTabWithTabName(String _parentXpath, String _tabName)
    {
        String xpath = "(" + _parentXpath + "//td[contains(text(),'" + _tabName + "') and contains(@class,'rich-tab-header')])[1]";
        return waitElementToBePresentThenScrollIntoView(xpath);
    }

    /**
     * @param _parentXpath
     * @param _tabName
     * @param _tabOrder
     * @return WebElementFacade
     * @Description Find tab by given tab name, parent xPath and the order of
     * same element definition.
     * @author Vincent
     */
    public WebElementFacade findTabWithTabName(String _parentXpath, String _tabName, int _tabOrder)
    {
        String xpath = "(" + _parentXpath + "//td[contains(text(),'" + _tabName + "') and contains(@class,'rich-tab-header')])[" + _tabOrder + "]";
        return waitElementToBePresentThenScrollIntoView(xpath);
    }

    /**
     * @param _tabName
     * @return WebElementFacade
     * @Description Find tab by given tab name.Return first element if find out
     * more than one element.
     * @author Vincentn - Tested
     */
    public WebElementFacade findTabWithTabName(String _tabName)
    {
        String xpath = "//*[child::*[text()='" + _tabName + "']]";
        return findBy(xpath);
    }

    /**
     * @param _tabName
     * @param _tabOrder
     * @return WebElementFacade
     * @Description Finding tab by given tab name and the order of same element
     * definition .
     * @author Vincent
     */
    public WebElementFacade findTabWithTabName(String _tabName, int _tabOrder)
    {
        String xpath = "(//td[contains(text(),'" + _tabName + "') and contains(@class,'rich-tab-header')])[" + _tabOrder + "]";
        return waitElementToBePresentThenScrollIntoView(xpath);
    }

    /**
     * @param _parentXpath
     * @param _tabName
     * @return WebElementFacade
     * @Description Finding active tab by given tab name and parent xPath.
     * Return first element if find out more than one element. This
     * uses for verify opened tab.
     * @author Vincent
     */
    public WebElementFacade findActiveTabWithTabName(String _parentXpath, String _tabName)
    {
        String xpath = "(" + _parentXpath + "//td[contains(text(),'" + _tabName + "') and contains(@class,'rich-tab-header') and contains(@class,'rich-tab-active')])[1]";
        return waitElementToBePresentThenScrollIntoView(xpath);
    }

    /**
     * @param _tabName
     * @return WebElementFacade
     * @Description Finding active tab by given tab name. Return first element
     * if find out more than one element. This uses for verify
     * opened tab.
     * @author Vincent - Tested
     */
    public WebElementFacade findActiveTabWithTabName(String _tabName)
    {
        String xpath = "//li[child::a[@href] [text()='" + _tabName + "']][contains(@class, 'state-active')]";
        return findBy(xpath);
    }

    /**
     * @param _parentXpath
     * @param _tabName
     * @param _tabOrder
     * @return WebElementFacade
     * @Description Finding active tab by given tab name and parent xPath and
     * the order of same element definition. This uses for verify
     * opened tab.
     * @author Vincent
     */
    public WebElementFacade findActiveTabWithTabName(String _parentXpath, String _tabName, int _tabOrder)
    {
        String xpath = _parentXpath + "(//td[contains(text(),'" + _tabName + "') and contains(@class,'rich-tab-header')])[" + _tabOrder + "][contains(@class,'rich-tab-active')]";
        return waitElementToBePresentThenScrollIntoView(xpath);
    }

    /**
     * @param _tabName
     * @param _tabOrder
     * @return WebElementFacade
     * @Description Finding active tab by given tab name and the order of same
     * element definition. This uses for verify opened tab.
     * @author Vincent
     */
    public WebElementFacade findActiveTabWithTabName(String _tabName, int _tabOrder)
    {
        String xpath = "(//td[contains(text(),'" + _tabName + "') and contains(@class,'rich-tab-header')])[" + _tabOrder + "][contains(@class,'rich-tab-active')]";
        return waitElementToBePresentThenScrollIntoView(xpath);
    }

    /**
     * @param _parentXpath
     * @param _tabName
     * @Description Switching to tab by given tab name and parent xPath. If
     * there are more than one tab have the same definition, first
     * tab will be switched to.
     * @author Vincent
     */
    public void switch_to_tab(String _parentXpath, String _tabName)
    {
        findTabWithTabName(_parentXpath, _tabName).waitUntilClickable().click();
        findActiveTabWithTabName(_parentXpath, _tabName).shouldBePresent();
    }

    /**
     * @param _tabName
     * @Description Switching to tab by given tab name. If there are more than
     * one tab have the same definition, first tab will be switched
     * to. A list TabName split by ">" will be switched one by one.
     * @author Vincent. - Updated by Nancy
     */
    public void switch_to_tab(String _tabName)
    {
        if (!_tabName.contains(">"))
        {
            findTabWithTabName(_tabName).waitUntilClickable().click();
            findActiveTabWithTabName(_tabName).shouldBePresent();
            waitForAllJSCompletes();
        }
        else
        { // Nancy
            String[] tab = _tabName.split(">");
            for (int i = 0; i < tab.length; i++)
            {
                findTabWithTabName(tab[i]).waitUntilClickable().click();
                findActiveTabWithTabName(tab[i]).shouldBePresent();
                waitForAllJSCompletes();
            }
        }
    }

    /**
     * @param _parentXpath
     * @param _tabName
     * @param _tabOrder
     * @Description Switching to tab by given tab name, parent xPath and the
     * order of same tab definition.
     * @author Vincent
     */
    public void switch_to_tab(String _parentXpath, String _tabName, int _tabOrder)
    {
        findTabWithTabName(_parentXpath, _tabName, _tabOrder).waitUntilClickable().click();
        findActiveTabWithTabName(_parentXpath, _tabName, _tabOrder).shouldBePresent();
    }

    /**
     * @param _tabName
     * @param _tabOrder
     * @Description Switching to tab by given tab name and the order of same tab
     * definition.
     * @author Vincent
     */
    public void switch_to_tab(String _tabName, int _tabOrder)
    {
        findTabWithTabName(_tabName, _tabOrder).waitUntilClickable().click();
        findActiveTabWithTabName(_tabName, _tabOrder).shouldBePresent();
    }
    // END: switch tab
    // #EndRegion Tab.

    // #Region Button.

    /**
     * @param _parentXpath
     * @param _btnName
     * @param _resOrder
     * @return xPath
     * @Description xPath of Button by button name
     * @author Nancy
     */
    public String xPathBtn(String _parentXpath, String _btnName, int _resOrder)
    {
        String xPath = "(" + _parentXpath + "//button[child::span[text()='" + _btnName + "' or @value='" + _btnName + "']])[" + _resOrder + "]";
        return xPath;
    }

    /**
     * @param _parentXpath
     * @param _btnName
     * @return xPath
     * @Description xPath of Button by button name
     * @author Vincent - Tested
     */
    public String xPathBtn(String _parentXpath, String _btnName)
    {
        return xPathBtn(_parentXpath, _btnName, 1);
    }

    /**
     * @param _btnName
     * @return xPath
     * @Description xPath of Button by button name
     * @author Vincent - Tested
     */
    public String xPathBtn(String _btnName)
    {
        return xPathBtn("", _btnName, 1);
    }

    /**
     * @param _btnName
     * @param _resOrder
     * @return xPath
     * @Description xPath of Button by button name
     * @author Vincent - Tested
     */
    public String xPathBtn(String _btnName, int _resOrder)
    {
        return xPathBtn("", _btnName, _resOrder);
    }

    /**
     * @param _parentXpath
     * @param _btnName
     * @param _resOrder
     * @return WebElementFacade
     * @Description Finding button by button name
     * @author Vincent - Tested
     */
    public WebElementFacade findBtn(String _parentXpath, String _btnName, int _resOrder)
    {
        return waitElementToBePresentThenScrollIntoView(xPathBtn(_parentXpath, _btnName, _resOrder));
    }

    /**
     * @param _btnName
     * @return WebElementFacade
     * @Description Finding button by button name
     * @author Vincent
     */
    public WebElementFacade findBtn(String _btnName)
    {
        return waitElementToBePresentThenScrollIntoView(xPathBtn(_btnName));
    }

    /**
     * @param _btnName
     * @param _resOrder
     * @return WebElementFacade
     * @Description Finding button by button name
     * @author Vincent
     */
    public WebElementFacade findBtn(String _btnName, int _resOrder)
    {
        return waitElementToBePresentThenScrollIntoView(xPathBtn(_btnName, _resOrder));
    }

    /**
     * @param _parentXpath
     * @param _btnName
     * @return WebElementFacade
     * @Description Finding button by button name
     * @author Vincent
     */
    public WebElementFacade findBtn(String _parentXpath, String _btnName)
    {
        return waitElementToBePresentThenScrollIntoView(xPathBtn(_parentXpath, _btnName));
    }

    /**
     * @param _btnName
     * @Description Click on button by button name
     * @author Vincent - Tested
     */
    public void clickBtn(String _parentXpath, String _btnName, int _resOrder)
    {
        waitElementToBeClickable(xPathBtn(_parentXpath, _btnName, _resOrder)).click();
    }

    /**
     * @param _btnName
     * @Description Click on button by button name
     * @author Vincent - Tested
     */
    public void clickBtn(String _btnName)
    {
        clickBtn("", _btnName, 1);
    }

    /**
     * @param _btnName
     * @param _resOrder
     * @Description Click on button by button name
     * @author Vincent
     */
    public void clickBtn(String _btnName, int _resOrder)
    {
        clickBtn("", _btnName, _resOrder);
    }

    /**
     * @param _parentXpath
     * @param _btnName
     * @Description Click on button by button name
     * @author Vincent
     */
    public void clickBtn(String _parentXpath, String _btnName)
    {
        clickBtn(_parentXpath, _btnName, 1);
    }
    // #EndRegion Button

    // #Region Input Field, TEXT AREA with Label and Search Icon

    /**
     * @param _parentXpath
     * @param _labelName
     * @param _resOrder
     * @return xPath
     * @Description xPath of Input Field besides Label
     * @author Nancy
     */
    public String xPathInputFieldWithLabel(String _parentXpath, String _labelName, int _resOrder)
    {
        return "(" + _parentXpath + "//div[preceding-sibling::div[text()='" + _labelName + "']]/descendant::input)[" + _resOrder + "]";
    }

    /**
     * @param _labelName
     * @param _resOrder
     * @return xPath
     * @Description xPath of Input Field besides Label
     * @author Vincent - Tested
     */
    public String xPathInputFieldWithLabel(String _labelName, int _resOrder)
    {
        return xPathInputFieldWithLabel("", _labelName, _resOrder);
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @return xPath
     * @Description xPath of Input Field besides Label
     * @author Vincent
     */
    public String xPathInputFieldWithLabel(String _parentXpath, String _labelName)
    {
        return xPathInputFieldWithLabel(_parentXpath, _labelName, 1);
    }

    /**
     * @param _labelName
     * @param _resOrder
     * @return xPath
     * @Description xPath of Input Field besides Label
     * @author Vincent
     */
    public String xPathInputFieldWithLabel(String _labelName)
    {
        return xPathInputFieldWithLabel("", _labelName, 1);
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @param _resOrder
     * @return xPath
     * @Description xPath of Input Text Area besides Label
     * @author Nancy
     */
    public String xPathInputTextAreaWithLabel(String _parentXpath, String _labelName, int _resOrder)
    {
        return "(" + _parentXpath + "//div[preceding-sibling::div[text()='" + _labelName + "']]/descendant::textarea)[" + _resOrder + "]";
    }

    /**
     * @param _labelName
     * @param _resOrder
     * @return xPath
     * @Description xPath of Input Text Area besides Label
     * @author Vincent - Tested
     */
    public String xPathInputTextAreaWithLabel(String _labelName, int _resOrder)
    {
        return xPathInputTextAreaWithLabel("", _labelName, _resOrder);
    }

    /**
     * @param _labelName
     * @return xPath
     * @Description xPath of Input Text Area besides Label
     * @author Vincent - Tested
     */
    public String xPathInputTextAreaWithLabel(String _labelName)
    {
        return xPathInputTextAreaWithLabel("", _labelName, 1);
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @param _resOrder
     * @return xPath
     * @Description xPath of Calendar selector besides Label
     * @author Vincent
     */
    public String xPathCalendarWithLabel(String _parentXpath, String _labelName, int _resOrder)
    {
        return "(" + _parentXpath + "//td//descendant-or-self::*[" + sSpecialTextPredicates(
                _labelName) + "]/ancestor-or-self::td[1]/following-sibling::td//img[@class='rich-calendar-button'])[" + _resOrder + "]";
    }

    /**
     * @param _labelName
     * @param _resOrder
     * @return xPath
     * @Description xPath of Calendar selector besides Label
     * @author Vincent
     */
    public String xPathCalendarWithLabel(String _labelName, int _resOrder)
    {
        return xPathSearchIconWithLabel("", _labelName, _resOrder);
    }

    /**
     * @param _labelName
     * @return xPath
     * @Description xPath of Calendar selector besides Label
     * @author Vincent
     */
    public String xPathCalendarWithLabel(String _labelName)
    {
        return xPathCalendarWithLabel("", _labelName, 1);
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @param _labelResOrder
     * @param _resOrder
     * @return xPath
     * @Description xPath of Remarks Icon besides Label
     * @author Vincent
     */
    public String xPathRemarksWithLabel(String _parentXpath, String _labelName, int _labelResOrder, int _resOrder)
    {
        return "(" + _parentXpath + "//td//descendant-or-self::*[" + sSpecialTextPredicates(
                _labelName) + "]/ancestor-or-self::td[" + _labelResOrder + "]/following-sibling::td//img[contains(@src,'remarks.gif')])[" + _resOrder + "]";
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @param _resOrder
     * @return xPath
     * @Description xPath of Search Icon besides Label
     * @author Vincent
     */
    public String xPathSearchIconWithLabel(String _parentXpath, String _labelName, int _resOrder)
    {
        return "(" + _parentXpath + "//td//descendant-or-self::*[" + sSpecialTextPredicates(
                _labelName) + "]/ancestor-or-self::td[1]/following-sibling::td//img[contains(@src, 'lookup')])[" + _resOrder + "]";
    }

    /**
     * @param _labelName
     * @param _resOrder
     * @return xPath
     * @Description xPath of Search Icon besides Label
     * @author Vincent
     */
    public String xPathSearchIconWithLabel(String _labelName, int _resOrder)
    {
        return xPathSearchIconWithLabel("", _labelName, _resOrder);
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @param _resOrder
     * @return xPath
     * @Description xPath of Text besides Label
     * @author Vincent
     */
    public String xPathTextWithLabel(String _parentXpath, String _labelName, int _resOrder)
    {
        if (_parentXpath.isEmpty())
        {
            return "(//*[contains(@id,'mainPanel')]//td//descendant-or-self::*[" + sSpecialTextPredicates(
                    _labelName) + "]/ancestor-or-self::td[1]/following-sibling::td)[" + _resOrder + "]/descendant-or-self::*[last()]";
        }
        else
        {
            return "(" + _parentXpath + "//td//descendant-or-self::*[" + sSpecialTextPredicates(
                    _labelName) + "]/ancestor-or-self::td[1]/following-sibling::td)[" + _resOrder + "]/descendant-or-self::*[last()]";
        }
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @return xPath
     * @Description xPath of Text besides Label
     * @author Vincent
     */
    public String xPathTextWithLabel(String _parentXpath, String _labelName)
    {
        return xPathTextWithLabel(_parentXpath, _labelName, 1);
    }

    /**
     * @param _labelName
     * @param _resOrder
     * @return xPath
     * @Description xPath of Text besides Label
     * @author Vincent
     */
    public String xPathTextWithLabel(String _labelName, int _resOrder)
    {
        return xPathTextWithLabel("", _labelName, _resOrder);
    }

    /**
     * @param _labelName
     * @return xPath
     * @Description xPath of Text besides Label
     * @author Vincent
     */
    public String xPathTextWithLabel(String _labelName)
    {
        return xPathTextWithLabel("", _labelName, 1);
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @param _resOrder
     * @return String
     * @Description Get Text besides Label
     * @author Vincent
     */
    public String getTextWithLabel(String _parentXpath, String _labelName, int _resOrder)
    {
        return waitElementToBePresent(xPathTextWithLabel(_parentXpath, _labelName, _resOrder)).getText();
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @param _resOrder
     * @return String
     * @Description Get Text Value besides Label
     * @author Vincent
     */
    public String getTextValueWithLabel(String _parentXpath, String _labelName, int _resOrder)
    {
        return waitElementToBePresent(xPathTextWithLabel(_parentXpath, _labelName, _resOrder)).getTextValue();
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @return String
     * @Description Get Text besides Label
     * @author Vincent
     */
    public String getTextWithLabel(String _parentXpath, String _labelName)
    {
        return waitElementToBePresent(xPathTextWithLabel(_parentXpath, _labelName, 1)).getText();
    }

    /**
     * @param _labelName
     * @param _resOrder
     * @return String
     * @Description Get Text besides Label
     * @author Vincent
     */
    public String getTextWithLabel(String _labelName, int _resOrder)
    {
        return waitElementToBePresent(xPathTextWithLabel("", _labelName, _resOrder)).getText();
    }

    /**
     * @param _labelName
     * @param _resOrder
     * @return String
     * @Description Get Text Value besides Label
     * @author Vincent
     */
    public String getTextValueWithLabel(String _labelName, int _resOrder)
    {
        return waitElementToBePresent(xPathTextWithLabel("", _labelName, _resOrder)).getTextValue();
    }

    /**
     * @param _labelName
     * @return String
     * @Description Get Text besides Label
     * @author Vincent
     */
    public String getTextWithLabel(String _labelName)
    {
        return waitElementToBePresent(xPathTextWithLabel(_labelName)).getText();
    }

    /**
     * @param _labelName
     * @return String
     * @Description Get Text besides Label
     * @author Vincent
     */
    public String getTextValueWithLabel(String _labelName)
    {
        return waitElementToBePresent(xPathTextWithLabel(_labelName)).getTextValue();
    }

    /**
     * @param _labelName
     * @param _value
     * @Description Enter value into Text Area besides Label, tab then wait in
     * 0.5 second.
     * @author Vincent
     */
    public void enterTextAreaWithLabel(String _labelName, String _value)
    {
        waitTypeAndTab(xPathInputTextAreaWithLabel(_labelName, 1), _value);
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @param _value
     * @Description Enter value into Text Area besides Label, tab then wait in
     * 0.5 second.
     * @author Vincent - Tested
     */
    public void enterTextAreaWithLabel(String _parentXpath, String _labelName, String _value)
    {
        waitTypeAndTab(xPathInputTextAreaWithLabel(_parentXpath, _labelName, 1), _value);
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @param _value
     * @param _resOrder
     * @Description Enter value into Input Field besides Label, enter then wait
     * for updating value.
     * @author Vincent - Tested
     */
    public void enterInputFieldWithLabel(String _parentXpath, String _labelName, String _value, int _resOrder)
    {
        waitTypeAndEnterThenUpdateValue(xPathInputFieldWithLabel(_parentXpath, _labelName, _resOrder), _value);
    }

    /**
     * @param _labelName
     * @param _value
     * @Description Enter value into Input Field besides Label, enter then wait
     * for updating value.
     * @author Vincent - Tested
     */
    public void enterInputFieldWithLabel(String _labelName, String _value)
    {
        waitTypeAndTabThenUpdateValue(xPathInputFieldWithLabel(_labelName, 1), _value);
    }

    /**
     * @param _labelName
     * @param _value
     * @param _resOrder
     * @Description Enter value into Input Field besides Label, enter then wait
     * for updating value.
     * @author Vincent - Tested
     */
    public void enterInputFieldWithLabel(String _labelName, String _value, int _resOrder)
    {
        waitTypeAndEnterThenUpdateValue(xPathInputFieldWithLabel(_labelName, _resOrder), _value);
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @param _value
     * @Description Enter value into Input Field besides Label, enter then wait
     * for updating value.
     * @author Vincent - Tested
     */
    public void enterInputFieldWithLabel(String _parentXpath, String _labelName, String _value)
    {
        waitTypeAndEnterThenUpdateValue(xPathInputFieldWithLabel(_parentXpath, _labelName, 1), _value);
    }

    /**
     * Using for lable auto Upper Value
     *
     * @param _parentXpath
     * @param _labelName
     * @param _value
     * @Description Enter value into Input Field besides Label, enter then wait
     * for updating value.
     * @author Nancy
     */
    public void enterInputFieldCodeWithLabel(String _parentXpath, String _labelName, String _value)
    {
        waitTypeAndEnterThenUpdateValue(xPathInputFieldWithLabel(_parentXpath, _labelName, 1), _value.toUpperCase());
    }

    /**
     * @param _labelName
     * @Description Click on Search Icon besides Label
     * @author Vincent
     */
    public void clickSearchIconWithLabel(String _labelName)
    {
        waitElementToBePresent(xPathSearchIconWithLabel(_labelName, 1)).waitUntilClickable().click();
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @Description Click on Search Icon besides Label
     * @author Vincent
     */
    public void clickSearchIconWithLabel(String _parentXpath, String _labelName)
    {
        clickOnElement(xPathSearchIconWithLabel(_parentXpath, _labelName, 1));
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @param _resOrder
     * @Description Click on Search Icon besides Label
     * @author Vincent
     */
    public void clickSearchIconWithLabel(String _parentXpath, String _labelName, int _resOrder)
    {
        clickOnElement(xPathSearchIconWithLabel(_parentXpath, _labelName, _resOrder));
    }

    /**
     * Using with the lable auto UPPER text
     *
     * @param _labelName
     * @param _value
     * @author Nancy
     */
    public void enterInputFieldCodeWithLabel(String _labelName, String _value)
    {
        String xPath = xPathInputFieldWithLabel(_labelName, 1);
        waitElementToBePresentThenScrollIntoView(
                xPath + "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]").waitUntilEnabled().waitUntilVisible().typeAndEnter(
                _value);
        waitElementToBePresent(xPath);
        waitFor(ExpectedConditions.textToBePresentInElementValue(By.xpath(xPath), _value.toUpperCase()));
        waitForAllJSCompletes();
    }

    /**
     * Using with the lable auto UPPER text, No verify after fill text to lable
     *
     * @param _labelName
     * @param _value
     * @author Nancy
     */
    public void enterInputFieldWithLabelNoVerify(String _labelName, String _value)
    {
        String xPath = xPathInputFieldWithLabel(_labelName, 1);
        waitElementToBePresentThenScrollIntoView(
                xPath + "[not(@readonly='readonly' or @readonly='true' or @disabled='true' or @disabled='disabled')]").waitUntilEnabled().waitUntilVisible().typeAndEnter(
                _value);
        waitElementToBePresent(xPath);
    }
    // #EndRegion Input Field with Label and Search Icon

    // #Region Radio Button with Label

    /**
     * @param _parentXpath
     * @param _labelName
     * @param _resOrder
     * @return xPath
     * @Description xPath of Radio Button besides Label or Text.
     * @author Nancy
     */
    public String xPathRadioBtnWithLabel(String _parentXpath, String _labelName, int _resOrder)
    {
        String xpath = "(" + _parentXpath + "//input[contains(@type,'radio') and following-sibling::*[" + sSpecialTextPredicates(
                _labelName) + "]][1])[" + _resOrder + "]";
        return xpath;
    }

    /**
     * @param _labelName
     * @param _resOrder
     * @return xPath
     * @Description xPath of Radio Button besides Label or Text.
     * @author Vincent - Tested
     */
    public String xPathRadioBtnWithLabel(String _labelName, int _resOrder)
    {
        return xPathRadioBtnWithLabel("", _labelName, _resOrder);
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @return xPath
     * @Description xPath of Radio Button besides Label or Text.
     * @author Vincent - Tested
     */
    public String xPathRadioBtnWithLabel(String _parentXpath, String _labelName)
    {
        return xPathRadioBtnWithLabel(_parentXpath, _labelName, 1);
    }

    /**
     * @param _labelName
     * @return xPath
     * @Description xPath of Radio Button besides Label or Text.
     * @author Vincent - Tested
     */
    public String xPathRadioBtnWithLabel(String _labelName)
    {
        return xPathRadioBtnWithLabel("", _labelName, 1);
    }

    /**
     * @param _labelName
     * @return WebElementFacade
     * @Description Finding Radio Button besides Label or Text.
     * @author Vincent - Tested
     */
    public WebElementFacade findRadioBtnByLabel(String _labelName)
    {
        return waitElementToBePresentThenScrollIntoView(xPathRadioBtnWithLabel("", _labelName, 1));
    }

    /**
     * @param _parentXpath
     * @param _labelName
     * @return WebElementFacade
     * @Description Finding Radio Button besides Label or Text.
     * @author Vincent - Tested
     */
    public WebElementFacade findRadioBtnByLabel(String _parentXpath, String _labelName)
    {
        return waitElementToBePresentThenScrollIntoView(xPathRadioBtnWithLabel(_parentXpath, _labelName, 1));
    }

    public WebElementFacade findRadioBtnByLabel(WebElementFacade _wEParent, String _radioBtnLabel)
    {
        return _wEParent.findBy(".//*[" + sSpecialTextPredicates(_radioBtnLabel) + "]//preceding::input[contains(@type,'radio')][1]");
    }

    public void selectRadioButton(WebElementFacade wE)
    {
        waitForAllJSCompletes();
        wE.waitUntilPresent().waitUntilClickable().click();
    }

    /**
     * @param _xPathRadioBtn
     * @Description Select Radio Button By xPath
     * @author Vincent - Tested
     */
    public void selectRadioButton(String _xPathRadioBtn)
    {
        WebElementFacade wE = waitElementToBeClickable(_xPathRadioBtn);
        highlightElement(_xPathRadioBtn + "//ancestor-or-self::td[1]");
        wE.click();
        // String xpath = _xPathRadioBtn + "[@checked='checked']";
        waitElementToBePresent(_xPathRadioBtn).isSelected();
    }

    /**
     * @param _parentXpath
     * @param _groupLabelName
     * @param _labelName
     * @return xPath
     * @Description xPath of Radio Button insides Group of Radio Button
     * @author Nancy
     */

    public String xPathRadioBtnWithGroupLabel(String _parentXpath, String _groupLabelName, String _labelName)
    {
        String xPath = "(" + _parentXpath + "//div[preceding-sibling::div[text()='" + _groupLabelName + "']]/descendant::input[following-sibling::label[text()='" + _labelName + "']][@type='radio'])[1]";
        return xPath;
    }

    /**
     * @param _parentXpath
     * @param _groupLabelName
     * @param _groupLabelResIndex
     * @param _labelName
     * @return xPath
     * @Description xPath of Radio Button insides Group of Radio Button
     * @author Vincent
     */
    public String xPathRadioBtnWithGroupLabel(String _parentXpath, String _groupLabelName, int _groupLabelResIndex, String _labelName)
    {
        String xPath = _parentXpath + "//td//descendant-or-self::*[" + sSpecialTextPredicates(
                _groupLabelName) + "]//ancestor-or-self::td[" + _groupLabelResIndex + "]//following-sibling::td//*[" + sSpecialTextPredicates(
                _labelName) + "]//preceding::input[contains(@type,'radio')][1]";
        return xPath;
    }

    /**
     * @param _groupLabelName
     * @param _labelName
     * @return xPath
     * @Description xPath of Radio Button insides Group of Radio Button
     * @author Vincent - Tested
     */
    public String xPathRadioBtnWithGroupLabel(String _groupLabelName, String _labelName)
    {
        return xPathRadioBtnWithGroupLabel("", _groupLabelName, _labelName);
    }

    /**
     * @param _groupLabelName
     * @param _labelName
     * @return WebElementFacade
     * @Description Finding Radio Button insides Group of Radio Button
     * @author Vincent
     */
    public WebElementFacade findRadioBtnByGroupLabel(String _groupLabelName, String _labelName)
    {
        waitElementToBePresentThenScrollIntoView(xPathRadioBtnWithGroupLabel(_groupLabelName, _labelName));
        return findBy(xPathRadioBtnWithGroupLabel(_groupLabelName, _labelName));
    }

    /**
     * @param _parentXpath
     * @param _groupLabelName
     * @param _labelName
     * @return WebElementFacade
     * @Description Finding Radio Button insides Group of Radio Button
     * @author Vincent - Tested
     */
    public WebElementFacade findRadioBtnByGroupLabel(String _parentXpath, String _groupLabelName, String _labelName)
    {
        return waitElementToBePresentThenScrollIntoView(xPathRadioBtnWithGroupLabel(_parentXpath, _groupLabelName, _labelName));
    }

    /**
     * @param _groupLabelName
     * @param _radioBtnLabel
     * @Description Select Radio Button insides Group of Radio Button. NOTE:
     * some radio button not change value after click, use other
     * function.
     * @author Vincent - Tested
     */
    public void selectRadioButton(String _groupLabelName, String _radioBtnLabel)
    {
        selectRadioButton(xPathRadioBtnWithGroupLabel(_groupLabelName, _radioBtnLabel));
    }

    /**
     * @param _parentXpath
     * @param _groupLabelName
     * @param _radioBtnLabel
     * @Description Select Radio Button insides Group of Radio Button. NOTE:
     * some radio button not change value after click, use other
     * function.
     * @author Vincent - Tested
     */
    public void selectRadioButton(String _parentXpath, String _groupLabelName, String _radioBtnLabel)
    {
        selectRadioButton(xPathRadioBtnWithGroupLabel(_parentXpath, _groupLabelName, _radioBtnLabel));
    }

    // #EndRegion Radio Button with Label

    // #Region Check Box

    /**
     * @param _xPathCheckBox
     * @Description Check the Check Box.
     * @author Vincent - Tested
     */
    public void checkChkbox(String _xPathCheckBox)
    {
        if (waitElementToBePresent(_xPathCheckBox).getAttribute("checked") == null)
        {
            highlightElement(_xPathCheckBox + "//ancestor-or-self::td[1]");
            clickOnElement(_xPathCheckBox);
            waitElementToBePresent(_xPathCheckBox + "[@checked='checked']").shouldBeVisible();
        }
        else
        {
            highlightElement(_xPathCheckBox + "//ancestor-or-self::td[1]");
        }
    }

    /**
     * @param _xPathCheckBox
     * @Description Uncheck the Check Box.
     * @author Vincent - Tested
     */
    public void uncheckChkbox(String _xPathCheckBox)
    {
        if (waitElementToBePresent(_xPathCheckBox).getAttribute("checked") != null)
        {
            highlightElement(_xPathCheckBox + "//ancestor-or-self::td[1]");
            clickOnElement(_xPathCheckBox);
            waitElementToBePresent(_xPathCheckBox + "[not (@checked='checked')]").shouldBeVisible();
        }
        else
        {
            highlightElement(_xPathCheckBox + "//ancestor-or-self::td[1]");
        }
    }

    /**
     * @param _xPathCheckBox
     * @param _value
     * @Description Set Check Box into checked or unchecked by given
     * value.[true|yes] means checked and otherwise.
     * @author Vincent - Tested
     */
    public void setChkbox(String _xPathCheckBox, String _value)
    {
        if (_value.toLowerCase().equals("true") || _value.toLowerCase().equals("yes") || _value.toLowerCase().equals("y"))
        {
            checkChkbox(_xPathCheckBox);
        }
        else
        {
            uncheckChkbox(_xPathCheckBox);
        }
    }

    /**
     * @param _parentXpath
     * @param _groupLabelName
     * @param _chkboxLabel
     * @return xPath
     * @Description xPath of Check Box insides Group of Check Box.
     * @author Vincent
     */
    public String xPathChkboxWithGroupLabel(String _parentXpath, String _groupLabelName, String _chkboxLabel)
    {
        String xPath = _parentXpath + "//td//descendant-or-self::*[" + sSpecialTextPredicates(
                _groupLabelName) + "]//ancestor-or-self::td[1]/following-sibling::td//input[following::text()='" + _chkboxLabel + "'][contains(@type,'checkbox')]";
        if (_chkboxLabel.isEmpty())
        {
            xPath = _parentXpath + "//td//descendant-or-self::*[" + sSpecialTextPredicates(
                    _groupLabelName) + "]//ancestor-or-self::td[1]/following-sibling::td//input[contains(@type,'checkbox')]";
        }
        return "(" + xPath + ")[last()]";
    }

    /**
     * @param _groupLabelName
     * @param _chkboxLabel
     * @return xPath
     * @Description xPath of Check Box inside Group of Check Box.
     * @author Vincent
     */
    public String xPathChkboxWithGroupLabel(String _groupLabelName, String _chkboxLabel)
    {
        return xPathChkboxWithGroupLabel("", _groupLabelName, _chkboxLabel);
    }

    /**
     * @param _parentXpath
     * @param _chkboxLabel
     * @param _resOrder
     * @return
     * @Description xPath of Check Box besides Label.
     * @author Vincent
     */
    public String xPathChkboxWithLabel(String _parentXpath, String _chkboxLabel, int _resOrder)
    {
        String xpath = "(" + _parentXpath + "//*[" + sSpecialTextPredicates(
                _chkboxLabel) + "]//preceding::input[contains(@type,'checkbox')][1])[" + _resOrder + "]";
        return xpath;
    }

    /**
     * @param _parentXpath
     * @param _chkboxLabel
     * @return
     * @Description xPath of Check Box besides Label.
     * @author Vincent
     */
    public String xPathChkboxWithLabel(String _parentXpath, String _chkboxLabel)
    {
        return xPathChkboxWithLabel(_parentXpath, _chkboxLabel, 1);
    }

    /**
     * @param _chkboxLabel
     * @return
     * @Description xPath of Check Box besides Label.
     * @author Vincent
     */
    public String xPathChkboxWithLabel(String _chkboxLabel)
    {
        return xPathChkboxWithLabel("", _chkboxLabel, 1);
    }

    // #EndRegion Check Box

    // #Region Confirm Message - Error Message - InforPanel Message.
    // BEGIN: Confirm Update?
    // @author: Vincent
    private String xPathPanelConfirmUpdate  = "//div[text()='Confirm Update?' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]";
    //private String xPathBtnYesConfirmUpdate = "//div[text()='Confirm Update?' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]//input[@type='button' and @value='Yes']";
    private String btnNoConfirmUpdate       = "//div[text()='Confirm Update?' and @class='rich-mpnl-text rich-mpnl-header']/ancestor::table[1]//input[@type='button' and @value='No']";

    public void clickBtnNoOnConfirmUpdate()
    {
        waitElementToBePresent(xPathPanelConfirmUpdate).shouldBeVisible();
        waitElementToBePresentThenScrollIntoView(btnNoConfirmUpdate).click();
        waitForAllJSCompletes();
        waitForAbsenceOf(xPathPanelConfirmUpdate);
    }

    // END: Confirm Update?

    // BEGIN: Info Panel
    // @author: Vincent
    @FindBy(xpath = "//div[text()='Info Panel'][@id='StatusMessagePopupHeader']/ancestor::table[1]")
    private WebElementFacade       infoPanel;
    // @FindBy(xpath = "//div[text()='Info
    // Panel'][@id='StatusMessagePopupHeader']/ancestor::table[1]//span[@class='rich-messages-label']")
    @FindBy(xpath = "//div[text()='Info Panel'][@id='StatusMessagePopupHeader']/ancestor::table[1]//span")
    private List<WebElementFacade> infoPanelMessages;

    @FindBy(xpath = "//div[text()='Info Panel'][@id='StatusMessagePopupHeader']/ancestor::table[1]//input[@type='button' and @value='OK']")
    private WebElementFacade btnOkInfoPanel;

    public String getInfoPanelMessagesThenClickOK()
    {
        setImplicitTimeout(2, TimeUnit.SECONDS);
        if (infoPanel.isVisible())
        {
            String message = "";
            for (WebElementFacade el : infoPanelMessages)
            {
                message += el.getText() + System.getProperty("line.separator");
            }
            btnOkInfoPanel.click();
            setImplicitTimeout(5, TimeUnit.SECONDS);
            System.out.print(message);
            return message;
        }
        else
        {
            setImplicitTimeout(5, TimeUnit.SECONDS);
            return null;
        }
    }

    public void chooseOkOnInforPanel()
    {
        btnOkInfoPanel.click();
    }

    // END: Info Panel
    // BEGIN: Error Message(s)
    private String xPathPanelErrorMessages = "//div[text()='Error Message(s)' and @id='errorModalPanelHeader']/ancestor::table[1]";

    @FindBy(xpath = "//div[text()='Error Message(s)' and @id='errorModalPanelHeader']/ancestor::table[1]//li[@class='error-message']")
    private List<WebElementFacade> contentErrorMessages;

    @FindBy(xpath = "//div[text()='Error Message(s)' and @id='errorModalPanelHeader']/ancestor::table[1]//input[@value='OK' and @type='button']")
    private WebElementFacade btnOKErrorMessages;

    public String getErrorMessagesThenClickOK()
    {
        if (isElementVisible(xPathPanelErrorMessages, 1))
        {
            String message = "";
            for (WebElementFacade el : contentErrorMessages)
            {
                message += el.getText() + System.getProperty("line.separator");
            }
            btnOKErrorMessages.click();
            System.out.print(message);
            return message;
        }
        else
        {
            return null;
        }
    }

    // END: Error Message(s)

    // Nancy
    @FindBy(xpath = "//button[contains(@id, 'globalConfirmationForm')][child::span[text()='Yes']]")
    public WebElementFacade yesBtn;

    public void chooseYesOnUpdateConfirmation()
    {
        try
        {
                yesBtn.waitUntilPresent().waitUntilClickable().click();
                waitForAllJSCompletes();
        } catch (NoSuchElementException e){  e.getStackTrace();     }
    }

    @FindBy(id = "confirmationPanel_Form:confirmationPanel_NoButton")
    public WebElementFacade cancelBtn;

    public void chooseNoOnUpdateConfirmation()
    {
        cancelBtn.waitUntilPresent().waitUntilClickable().click();
    }

    // #End Region Confirm Message - Error Message - InforPanel Message.

    // #Region HTML TABLE.
    // @author: Vincent

    /**
     * @param _parentXpath
     * @param _headerText
     * @param _headerOrder
     * @return xPath
     * @Description xPath of Table Header Cell contains all kind of text
     * presented in cell (separated by space).
     * @author Vincent - Tested
     */
    public String xPathTbHeaderCell(String _parentXpath, String _headerText, int _resOrder)
    {
        String[] aHeaderText = _headerText.split(" ");
        String sSearchPattern = "";
        int numText = aHeaderText.length;
        if (numText > 1)
        {
            sSearchPattern = "descendant-or-self::*[contains(*,'" + aHeaderText[0] + "') or contains(text(),'" + aHeaderText[0] + "')]";
            for (int i = 1; i < numText; i++)
            {
                sSearchPattern += " and descendant-or-self::*[contains(*,'" + aHeaderText[i] + "') or contains(text(),'" + aHeaderText[i] + "')]";
            }
            return "(" + _parentXpath + "//thead//descendant-or-self::th[" + sSearchPattern + "])[" + _resOrder + "]";
        }
        else
        {
            sSearchPattern = "[contains(*,'" + _headerText + "') or contains(text(),'" + _headerText + "')]";
            return "(" + _parentXpath + "//thead//descendant-or-self::th" + sSearchPattern + ")[" + _resOrder + "]";
        }
    }

    /**
     * @param _headerText
     * @return xPath
     * @Description xPath of Table Header Cell contains all kind of text
     * presented in cell (separated by space).
     * @author Vincent - Tested
     */
    public String xPathTbHeaderCell(String _headerText)
    {
        return xPathTbHeaderCell("", _headerText, 1);
    }

    /**
     * @param _headerText
     * @param _resOrder
     * @return xPath
     * @Description xPath of Table Header Cell contains all kind of text
     * presented in cell (separated by space).
     * @author Vincent - Tested
     */
    public String xPathTbHeaderCell(String _headerText, int _resOrder)
    {
        return xPathTbHeaderCell("", _headerText, _resOrder);
    }

    /**
     * @param _parentXpath
     * @param _headerText
     * @return xPath
     * @Description xPath of Table Header Cell contains all kind of text
     * presented in cell (separated by space).
     * @author Vincent - Tested
     */
    public String xPathTbHeaderCell(String _parentXpath, String _headerText)
    {
        return xPathTbHeaderCell(_parentXpath, _headerText, 1);
    }

    /**
     * @param _parentXpath
     * @param _resOrder
     * @return xPath
     * @Description xPath of Table Header Cell contains Check Box.
     * @author Vincent
     */
    public String xPathTbHeaderChkbox(String _parentXpath, int _resOrder)
    {
        return ("(" + _parentXpath + "//thead//th//input[@type='checkbox'])[" + _resOrder + "]");
    }

    /**
     * @return xPath
     * @Description xPath of Table Header Cell contains Check Box.
     * @author Vincent
     */
    public String xPathTbHeaderChkbox()
    {
        return xPathTbHeaderChkbox("", 1);
    }

    /**
     * @param _resOrder
     * @return xPath
     * @Description xPath of Table Header Cell contains Check Box.
     * @author Vincent
     */
    public String xPathTbHeaderChkbox(int _resOrder)
    {
        return xPathTbHeaderChkbox("", _resOrder);
    }

    /**
     * @param _parentXpath
     * @return xPath
     * @Description xPath of Table Header Cell contains Check Box.
     * @author Vincent
     */
    public String xPathTbHeaderChkbox(String _parentXpath)
    {
        return xPathTbHeaderChkbox(_parentXpath, 1);
    }

    /**
     * @param _parentXpath
     * @param _chkboxText
     * @param _resOrder
     * @return xPath
     * @Description xPath of Table Header Cell contains Check Box with Label.
     * @author Vincent
     */
    public String xPathTbHeaderChkboxWithLabel(String _parentXpath, String _chkboxText, int _resOrder)
    {
        String[] aHeaderText = _chkboxText.split(" ");
        String sSearchPattern = "";
        int numText = aHeaderText.length;
        if (numText > 1)
        {
            sSearchPattern = "descendant-or-self::*[contains(*,'" + aHeaderText[0] + "') or contains(text(),'" + aHeaderText[0] + "')]";
            for (int i = 1; i < numText; i++)
            {
                sSearchPattern += " and descendant-or-self::*[contains(*,'" + aHeaderText[i] + "') or contains(text(),'" + aHeaderText[i] + "')]";
            }
            return "(" + _parentXpath + "//thead//descendant-or-self::th[" + sSearchPattern + "]//input[@type='checkbox'])[" + _resOrder + "]";
        }
        else
        {
            sSearchPattern = "[contains(*,'" + _chkboxText + "') or contains(text(),'" + _chkboxText + "')]";
            return "(" + _parentXpath + "//thead//descendant-or-self::th" + sSearchPattern + ")//input[@type='checkbox'][" + _resOrder + "]";
        }
    }

    /**
     * @param _parentXpath
     * @param _chkboxText
     * @return
     * @Description xPath of Table Header Cell contains Check Box with Label.
     * @author Vincent
     */
    public String xPathTbHeaderChkboxWithLabel(String _parentXpath, String _chkboxText)
    {
        return xPathTbHeaderChkboxWithLabel(_parentXpath, _chkboxText, 1);
    }

    /**
     * @param _chkboxText
     * @return
     * @Description xPath of Header Cell contains Check Box with Label.
     * @author Vincent
     */
    public String xPathTbHeaderChkboxWithLabel(String _chkboxText)
    {
        return xPathTbHeaderChkboxWithLabel("", _chkboxText, 1);
    }

    /**
     * @param _xPathHeaderCell
     * @return int
     * @Description Get Table Column Header index by xPath of Header Cell.
     * Return 0 if not found.
     * @author Vincent - Tested
     */
    public int getTbColHeaderIndex(String _xPathHeaderCell)
    {
        waitElementToBePresent(_xPathHeaderCell);
        try
        {
            return findAll(_xPathHeaderCell + "/preceding-sibling::th").size() + 1;
        } catch (Exception e)
        {
            return 0;
        }
    }

    /**
     * @param _headerText
     * @return
     * @Description Get Table Column Header index by Text insides Header Cell.
     * Return 0 if not found.
     * @author Vincent - Tested
     */
    public int getTbColHeaderIndexByText(String _headerText)
    {
        return getTbColHeaderIndex(xPathTbHeaderCell(_headerText));
    }

    /**
     * @param _headerText
     * @param _resOrder
     * @return
     * @Description Get Table Column Header index by Text insides Header Cell.
     * Return 0 if not found.
     * @author Vincent - Tested
     */
    public int getTbColHeaderIndex(String _headerText, int _resOrder)
    {
        return getTbColHeaderIndex(xPathTbHeaderCell(_headerText, _resOrder));
    }

    /**
     * @param _parentXpath
     * @param _headerText
     * @return index
     * @Description Get Table Column Header index by Text insides Header Cell.
     * Return 0 if not found.
     * @author Vincent - Tested
     */
    public int getTbColHeaderIndex(String _parentXpath, String _headerText)
    {
        return getTbColHeaderIndex(xPathTbHeaderCell(_parentXpath, _headerText));
    }

    /**
     * @param _parentXpath
     * @param _headerText
     * @param _resOrder
     * @return index
     * @Description Get Table Column Header index by Text insides Header Cell.
     * Return 0 if not found.
     * @author Vincent - Tested
     */
    public int getTbColHeaderIndex(String _parentXpath, String _headerText, int _resOrder)
    {
        return getTbColHeaderIndex(xPathTbHeaderCell(_parentXpath, _headerText, _resOrder));
    }

    /**
     * @return xPath
     * @Description xPath of all Table Data Rows.
     * @author Vincent
     */
    public String xPathTbGetAllDataRows()
    {
        return "//descendant-or-self::tbody/tr";
    }

    /**
     * @param _parentXpath
     * @return xPath
     * @Description xPath of all Table Data Rows.
     * @author Vincent
     */
    public String xPathTbGetAllDataRows(String _parentXpath)
    {
        return "(" + _parentXpath + "//descendant-or-self::tbody[tr[@class]][1])/tr";
    }

    /**
     * @param _parentXpath
     * @param _headerIndex
     * @return
     * @Description xPath of Last Table Data Cell in Column by Header Cell
     * index.
     * @author Vincent
     */
    public String xPathTbGetLastDataCellByHeaderIndex(String _parentXpath, int _headerIndex)
    {
        return "(" + _parentXpath + "//tbody//tr//td[contains(@class,'cell')][" + _headerIndex + "])[last()]";
    }

    /**
     * @param _headerIndex
     * @return xPath
     * @Description xPath of Table Data Cells in same Column by Header Cell
     * index.
     * @author Vincent
     */
    public String xPathTbGetAllDataCellsByHeaderIndex(int _headerIndex)
    {
        return "//tbody//tr//td[contains(@class,'cell')][" + _headerIndex + "]";
    }

    /**
     * @param _parentXpath
     * @param _headerIndex
     * @return xPath
     * @Description xPath of Table Data Cells in same Column by Header Cell
     * index.
     * @author Vincent
     */
    public String xPathTbGetAllDataCellsByHeaderIndex(String _parentXpath, int _headerIndex)
    {
        return _parentXpath + "//tbody//tr//td[contains(@class,'cell')][" + _headerIndex + "]";
    }

    /**
     * @param _headerIndex
     * @return WebElementFacade(s)
     * @Description Finding Table Data Cells in same Column by Header Cell
     * index.
     * @author Vincent
     */
    public List<WebElementFacade> findTbAllDataCellsByHeaderIndex(int _headerIndex)
    {
        return waitElementToBePresent(xPathTbGetAllDataCellsByHeaderIndex(_headerIndex)).thenFindAll(
                xPathTbGetAllDataCellsByHeaderIndex(_headerIndex));
    }

    /**
     * @param _parentXpath
     * @param _headerIndex
     * @return WebElementFacade(s)
     * @Description Finding Table Data Cells in same Column by Header Cell
     * index.
     * @author Vincent
     */
    public List<WebElementFacade> findTbAllDataCellsByHeaderIndex(String _parentXpath, int _headerIndex)
    {
        return waitElementToBePresent(xPathTbGetAllDataCellsByHeaderIndex(_parentXpath, _headerIndex)).thenFindAll(
                xPathTbGetAllDataCellsByHeaderIndex(_parentXpath, _headerIndex));
    }

    /**
     * @return WebElementFacades
     * @Description Finding all Table Data Rows.
     * @author Vincent
     */
    public List<WebElementFacade> findTbAllDataRows()
    {
        return waitElementToBePresent(xPathTbGetAllDataRows()).thenFindAll(xPathTbGetAllDataRows());
    }

    /**
     * @param _parentXpath
     * @return WebElementFacade(s)
     * @Description Finding all Table Data Rows.
     * @author Vincent
     */
    public List<WebElementFacade> findTbAllDataRows(String _parentXpath)
    {
        return waitElementToBePresent(xPathTbGetAllDataRows(_parentXpath)).thenFindAll(xPathTbGetAllDataRows(_parentXpath));
    }

    /**
     * @param _parentXpath
     * @return int
     * @Description Count the number of data row in table.
     * @author Vincent
     */
    public int getTbCountDataRow(String _parentXpath)
    {
        return findTbAllDataRows(_parentXpath).size();
    }

    /**
     * @param _rowIndex
     * @return WebElementFacade
     * @Description Finding Table Data Row By Row Index.
     * @author Vincent
     */
    public WebElementFacade findTbDataRowByIndex(int _rowIndex)
    {
        return findTbAllDataRows().get(_rowIndex);
    }

    /**
     * @param _parentXpath
     * @param _rowIndex
     * @return WebElementFacade
     * @Description Finding Table Data Row By Row Index.
     * @author Vincent
     */
    public WebElementFacade findTbDataRowByIndex(String _parentXpath, int _rowIndex)
    {
        return findTbAllDataRows(_parentXpath).get(_rowIndex);
    }

    /**
     * @param _parentXpath
     * @param _givenText
     * @return xPath
     * @Description xPath of Table Data Rows by any given text insides Data Row
     * @author Vincent
     */
    public String xPathTbDataRowsByAnyText(String _parentXpath, String _givenText)
    {
        String[] aGivenText = _givenText.split(" ");
        String sSearchPattern = "";
        int numText = aGivenText.length;
        if (numText > 1)
        {
            sSearchPattern = "descendant-or-self::*[contains(@value,'" + aGivenText[0] + "') or contains(text(),'" + aGivenText[0] + "')]";
            for (int i = 1; i < numText; i++)
            {
                sSearchPattern += " and descendant-or-self::*[contains(@value,'" + aGivenText[i] + "') or contains(text(),'" + aGivenText[i] + "')]";
            }
            return "(" + _parentXpath + "//tbody//descendant-or-self::tr[contains(@class,'row')][" + sSearchPattern + "])";
        }
        else
        {
            sSearchPattern = "[descendant-or-self::*[contains(@value,'" + _givenText + "') or contains(text(),'" + _givenText + "')]]";
            return "(" + _parentXpath + "//tbody//descendant-or-self::tr[contains(@class,'row')]" + sSearchPattern + ")";
        }
    }

    /**
     * @param _givenText
     * @return xPath
     * @Description xPath of Table Data Rows by any given text insides Data Rows
     * @author Vincent
     */
    public String xPathTbDataRowsByAnyText(String _givenText)
    {
        return xPathTbDataRowsByAnyText("", _givenText);
    }

    /**
     * @param _parentXpath
     * @param _givenText
     * @param _resOrder
     * @return xPath
     * @Description xPath of Table Data Row by any given text insides Data Row.
     * @author Vincent
     */
    public String xPathTbDataRowByAnyText(String _parentXpath, String _givenText, int _resOrder)
    {
        String[] aGivenText = _givenText.split(" ");
        String sSearchPattern = "";
        int numText = aGivenText.length;
        if (numText > 1)
        {
            sSearchPattern = "descendant-or-self::*[contains(@value,'" + aGivenText[0] + "') or contains(text(),'" + aGivenText[0] + "')]";
            for (int i = 1; i < numText; i++)
            {
                sSearchPattern += " and descendant-or-self::*[contains(@value,'" + aGivenText[i] + "') or contains(text(),'" + aGivenText[i] + "')]";
            }
            return "(" + _parentXpath + "//tbody//descendant-or-self::tr[contains(@class,'row')][" + sSearchPattern + "])[" + _resOrder + "]";
        }
        else
        {
            sSearchPattern = "[descendant-or-self::*[contains(@value,'" + _givenText + "') or contains(text(),'" + _givenText + "')]]";
            return "(" + _parentXpath + "//tbody//descendant-or-self::tr[contains(@class,'row')]" + sSearchPattern + ")[" + _resOrder + "]";
        }

    }

    /**
     * @param _givenText
     * @return xPath
     * @Description xPath of Table Data Row by any given text insides Data Row.
     * @author Vincent
     */
    public String xPathTbDataRowByAnyText(String _givenText)
    {
        return xPathTbDataRowByAnyText("", _givenText, 1);
    }

    /**
     * @param _parentXpath
     * @param _givenText
     * @return xPath
     * @Description xPath of Table Data Row by any given text insides Data Row.
     * @author Vincent
     */
    public String xPathTbDataRowByAnyText(String _parentXpath, String _givenText)
    {
        return xPathTbDataRowByAnyText(_parentXpath, _givenText, 1);
    }

    /**
     * @param _givenText
     * @param _rowOrder
     * @return xPath
     * @Description xPath of Table Data Row by any given text insides Data Row.
     * @author Vincent
     */
    public String xPathTbDataRowByAnyText(String _givenText, int _rowOrder)
    {
        return xPathTbDataRowByAnyText("", _givenText, _rowOrder);
    }

    /**
     * @param _parentXpath
     * @param _givenText
     * @param _cellOrder
     * @return xPath
     * @Description xPath of Table Data Cell by any given text insides Data
     * Cell.
     * @author Vincent
     */
    public String xPathTbDataCellByText(String _parentXpath, String _givenText, int _cellOrder)
    {
        String[] aGivenText = _givenText.split(" ");
        String sSearchPattern = "";
        int numText = aGivenText.length;
        if (numText > 1)
        {
            sSearchPattern = "descendant-or-self::*[contains(@value,'" + aGivenText[0] + "') or contains(text(),'" + aGivenText[0] + "')]";
            for (int i = 1; i < numText; i++)
            {
                sSearchPattern += " and descendant-or-self::*[contains(@value,'" + aGivenText[i] + "') or contains(text(),'" + aGivenText[i] + "')]";
            }
            return "(" + _parentXpath + "//tbody//descendant-or-self::td[contains(@class,'cell')][" + sSearchPattern + "])[" + _cellOrder + "]";
        }
        else
        {
            sSearchPattern = "[descendant-or-self::*[contains(@value,'" + _givenText + "') or contains(text(),'" + _givenText + "')]]";
            return "(" + _parentXpath + "//tbody//descendant-or-self::td[contains(@class,'cell')]" + sSearchPattern + ")[" + _cellOrder + "]";
        }
    }

    /**
     * @param _givenText
     * @return xPath
     * @Description xPath of Table Data Cell by any given text insides Data
     * Cell.
     * @author Vincent
     */
    public String xPathTbDataCellByText(String _givenText)
    {
        return xPathTbDataCellByText("", _givenText, 1);
    }

    /**
     * @param _parentXpath
     * @param _givenText
     * @return xPath
     * @Description xPath of Table Data Cell by any given text insides Data
     * Cell.
     * @author Vincent
     */
    public String xPathTbDataCellByText(String _parentXpath, String _givenText)
    {
        return xPathTbDataCellByText(_parentXpath, _givenText, 1);
    }

    /**
     * @param _givenText
     * @param _resOrder
     * @return xPath
     * @Description xPath of Table Data Cell by any given text insides Data
     * Cell.
     * @author Vincent
     */
    public String xPathTbDataCellByText(String _givenText, int _resOrder)
    {
        return xPathTbDataCellByText("", _givenText, _resOrder);
    }

    /**
     * @param _parentXpath
     * @param _givenText
     * @param _resOrder
     * @return xPath
     * @Description xPath of Table Data Cell by equal Text insides Data Cell.
     * @author Vincent
     */
    public String xPathTbDataCellByTextEqual(String _parentXpath, String _givenText, int _resOrder)
    {
        String sSearchPattern = "[descendant-or-self::*[*='" + _givenText + "' or text()='" + _givenText + "']]";
        return "(" + _parentXpath + "//tbody//descendant-or-self::td[contains(@class,'cell')]" + sSearchPattern + ")[" + _resOrder + "]";
    }

    /**
     * @param _parentXpath
     * @param _givenText
     * @return xPath
     * @Description xPath of Table Data Cell by equal Text insides Data Cell.
     * @author Vincent
     */
    public String xPathTbDataCellByTextEqual(String _parentXpath, String _givenText)
    {
        return xPathTbDataCellByTextEqual(_parentXpath, _givenText, 1);
    }

    /**
     * @param _givenText
     * @return xPath
     * @Description xPath of Table Data Cell by equal Text insides Data Cell.
     * @author Vincent
     */
    public String xPathTbDataCellByTextEqual(String _givenText)
    {
        return xPathTbDataCellByTextEqual("", _givenText, 1);
    }

    /**
     * @param _givenText
     * @param _resOrder
     * @return xPath
     * @Description xPath of Table Data Cell by equal Text insides Data Cell.
     * @author Vincent
     */
    public String xPathTbDataCellByTextEqual(String _givenText, int _resOrder)
    {
        return xPathTbDataCellByTextEqual("", _givenText, _resOrder);
    }

    /**
     * @param _parentXpath
     * @param _rowIndex
     * @param _headerIndex
     * @return xPath
     * @Description xPath of Table Data Cell by position of Data Cell (Row and
     * Column Index).
     * @author Henry
     */
    public String xPathTbDataCellByPosition(String _parentXpath, int _rowIndex, int _headerIndex)
    {
        // return "(" + _parentXpath +
        // "//tbody[preceding::thead]//tr/td[contains(@class,'cell')][" +
        // _headerIndex + "])["
        // + _rowIndex + "]";
        return "((" + _parentXpath + "//tbody[preceding::thead])[1]//tr/td[" + _headerIndex + "])[" + _rowIndex + "]";
    }

    /**
     * @param _parentXpath
     * @param _tbodyIndex
     * @param _rowIndex
     * @param _headerIndex
     * @return xPath
     * @Description xPath of Table Data Cell by position of Data Cell (Row and
     * Column Index) and exactly tbody index of table.
     * @author Vincent
     */
    public String xPathTbDataCellByPositionAndBodyIndex(String _parentXpath, int _tbodyIndex, int _rowIndex, int _headerIndex)
    {
        return "((" + _parentXpath + "//tbody[preceding::thead])[" + _tbodyIndex + "]/tr/td[contains(@class,'cell')][" + _headerIndex + "])[" + _rowIndex + "]";
    }

    /**
     * @param _parentXpath
     * @param _colName     Column Name has filter
     * @return xPath
     * @Description xPath of Table Data Filter Cell by Column Name
     * @author Nancy
     */
    public String xPathTbHeaderFilterCell(String _parentXpath, String _colName)
    {
        return _parentXpath + "//input[preceding-sibling::span[text()='" + _colName + "']]";
    }

    /**
     * @param _parentXpath
     * @param _givenText
     * @param _resOrder
     * @param _headerIndex
     * @return
     * @Description
     * @author Vincent
     */
    public String xPathTbDataCellByTextInCol(String _parentXpath, String _givenText, int _resOrder, int _headerIndex)
    {
        String[] aGivenText = _givenText.split(" ");
        String sSearchPattern = "";
        int numText = aGivenText.length;
        if (numText > 1)
        {
            sSearchPattern = "descendant-or-self::*[contains(*,'" + aGivenText[0] + "') or contains(text(),'" + aGivenText[0] + "')]";
            for (int i = 1; i < numText; i++)
            {
                sSearchPattern += " and descendant-or-self::*[contains(*,'" + aGivenText[i] + "') or contains(text(),'" + aGivenText[i] + "')]";
            }
            return "(" + _parentXpath + "//tbody//descendant-or-self::td[contains(@class,'cell')][" + _headerIndex + "][" + sSearchPattern + "])[" + _resOrder + "]";
        }
        else
        {
            sSearchPattern = "[descendant-or-self::*[contains(*,'" + _givenText + "') or contains(text(),'" + _givenText + "')]]";
            return "(" + _parentXpath + "//tbody//descendant-or-self::td[contains(@class,'cell')][" + _headerIndex + "]" + sSearchPattern + ")[" + _resOrder + "]";
        }
    }

    /**
     * @param _parentXpath
     * @param _givenText
     * @param _resOrder
     * @param _headerIndex
     * @return
     * @Description
     * @author Vincent
     */
    public String xPathTbDataCellByTextEqualInCol(String _parentXpath, String _givenText, int _resOrder, int _headerIndex)
    {
        String sSearchPattern = "[descendant-or-self::*[@*='" + _givenText + "' or text()='" + _givenText + "']]";
        return "(" + _parentXpath + "//tbody//descendant-or-self::td[contains(@class,'cell')][" + _headerIndex + "]" + sSearchPattern + ")[" + _resOrder + "]";
    }

    /**
     * @param _parentXpath
     * @param _headerIndex
     * @return xPath
     * @Description xPath of all data cell in specific column of table
     * @author Vincent
     */
    public String xPathTbDataCellsInCol(String _parentXpath, int _headerIndex)
    {
        return "(" + _parentXpath + "//tbody//td[contains(@class,'cell')][" + _headerIndex + "])";
    }

    /**
     * @param _parentXpath
     * @param _givenText
     * @param _resDataOrder
     * @param _headerText
     * @param _headerResOrder
     * @return
     * @Description
     * @author Henry
     */
    public String xPathTbDataCellByTextEqualInCol(String _parentXpath, String _givenText, int _resDataOrder, String _headerText, int _headerResOrder)
    {
        int headerIndex = getTbColHeaderIndex(_headerText, _headerResOrder);
        String sSearchPattern = "[descendant-or-self::*[@*='" + _givenText + "' or text()='" + _givenText + "']]";
        return "(" + _parentXpath + "//tbody//td[" + headerIndex + "]" + sSearchPattern + ")[" + _resDataOrder + "]";
    }

    /**
     * @param _parentXpath
     * @param _givenText
     * @param _resDataOrder
     * @param _headerText
     * @param _headerResOrder
     * @return
     * @Description
     * @author Vincent
     */
    public WebElementFacade findTbDataCellByTextEqualInCol(String _parentXpath, String _givenText, int _resDataOrder, String _headerText,
                                                           int _headerResOrder)
    {
        return waitElementToBePresent(xPathTbDataCellByTextEqualInCol(_parentXpath, _givenText, _resDataOrder, _headerText, _headerResOrder));
    }

    /**
     * @param _XpathDataCell
     * @return
     * @Description Get Column Index of Table Data Cell. NOTE: Return 0 if not
     * found.
     * @author Vincent
     */
    public int getTbColIndexOfDataCell(String _XpathDataCell)
    {
        waitElementToBePresent(_XpathDataCell);
        try
        {
            return findAll(_XpathDataCell + "/preceding-sibling::td").size() + 1;
        } catch (Exception e)
        {
            return 0;
        }
    }

    // return 0 if not found

    /**
     * @param _XpathDataCell
     * @return
     * @Description Get Row Index of Table Data Cell. NOTE: Return 0 if not
     * found.
     * @author Vincent
     */
    public int getTbRowIndexOfDataCell(String _XpathDataCell)
    {
        waitElementToBePresent(_XpathDataCell);
        try
        {
            return findAll(_XpathDataCell + "//ancestor::tr[1]/preceding-sibling::tr").size() + 1;
        } catch (Exception e)
        {
            return 0;
        }
    }

    // Common TABLE action

    /**
     * @param xPathHeaderCell
     * @param _value
     * @Description Filter data by input text into Table by Header Filter Cell.
     * @author Vincent - Tested
     */
    public void filterDataByHeader(String xPathHeaderCell, String _value)
    {
        waitTypeAndEnterThenUpdateValue(xPathHeaderCell + "//input[@role='textbox']", _value);
    }

    /**
     * @param xPathHeaderCell
     * @param _valueFrom
     * @param _valueTo
     * @Description Filter data in Table by Date (From , To).
     * @author Vincent
     */
    public void filterDataByHeaderDate(String xPathHeaderCell, String _valueFrom, String _valueTo)
    {
        waitTypeAndEnterThenUpdateValue("(" + xPathHeaderCell + "//input[@type='text' and contains(@class, 'rich-calendar-input')])[1]", _valueFrom);
        waitTypeAndEnterThenUpdateValue("(" + xPathHeaderCell + "//input[@type='text' and contains(@class, 'rich-calendar-input')])[2]", _valueTo);
    }

    /**
     * @param xPathHeaderChkBox
     * @param _value
     * @Description Set Check Box that insides Table Header Cell.
     * @author Vincent
     */
    public void setHeaderCheckbox(String xPathHeaderChkBox, String _value)
    {
        setChkbox(xPathHeaderChkBox, _value);
    }

    /**
     * @param _parentXpath
     * @param _rowIndex
     * @Description Click on green arrow in first column of table data.
     * @author Vincent
     */
    public void clickGreenArrow(String _parentXpath, int _rowIndex)
    {
        // Click on green arrow
        waitElementToBeClickable(xPathTbDataCellByPosition(_parentXpath, _rowIndex, 1) + "//img[contains(@src,'greenarrow')]").click();
    }
    // #EndRegion HTML TABLE.

    // COMMON ACTION
    // - Tested
    public void clickOnElement(String _xPath)
    {
        waitElementToBeClickable(_xPath).click();
    }

    // - Tested
    public void highlightElement(String _xPath)
    {
        try
        {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'", findBy(_xPath));
        } catch (Exception e)
        {
        }
    }

    /**
     * @return
     * @Description Get login user name display besides Logout link.
     * @author Vincent
     */
    public String getLoginUserName()
    {
        try
        {
            String sUserName = "";
            sUserName = waitElementToBePresent("(//body//form[a[text()='Logout']])[1]").getText();
            Charset.forName("UTF-8").encode(sUserName);
            sUserName = sUserName.substring(sUserName.indexOf("\n") + 1, sUserName.indexOf("|")).trim();
            System.out.println("Login User Name: " + sUserName);
            return sUserName;
        } catch (Exception e)
        {
            System.out.println("***ERROR***: Can not get Login User Name");
            e.printStackTrace();
            return "";
        }
    }

    /**
     * @return
     * @Description Get current window handle
     * @author Vincent
     */
    public String getCurrentWindowHandle()
    {
        return getDriver().getWindowHandle();
    }

    /**
     * @return
     * @Description Switch to window
     * @author Vincent
     */
    public boolean switchToWindowHandle(String _handle)
    {
        try
        {
            getDriver().switchTo().window(_handle);
            return true;
        } catch (Exception e)
        {
            System.out.println("Switch to window this window unsuccessfully : " + _handle);
            return false;
        }
    }

    // BEGIN Calendar
    //private String xPathCalendarButton       = "//img[@class='rich-calendar-button']";
    private String xPathCalendarMonthButton  = "//td[@class='rich-calendar-month']//div";
    private String xPathCalendarTodayButton  = "//div[@class='rich-calendar-tool-btn'][text()='Today']";
    private String xPathCalendarEditorButton = "//div[@class='rich-calendar-editor-btn']";
    private String xPathCalendarOkButton     = "//span[text()='OK']";
    //private String xPathCalendarToolButton   = "//td[class='rich-calendar-tool']//div";

    /**
     * @param ddMMyyyy
     * @Description Pick up date from Calendar. Pre-condition: Calendar must
     * already be opened.
     * @author Vincent
     */
    public void calendarSetDate(String ddMMyyyy)
    {// dd//MM/yyyy
        String tempXpath = "";
        if (!ddMMyyyy.isEmpty())
        {
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
            try
            {
                clickOnElement(xPathCalendarMonthButton);
                // click at Year
                tempXpath = xPathCalendarEditorButton + "[text()='" + month + "']";
                if (isElementExist(tempXpath, 1))
                    clickOnElement(tempXpath);
                // if not found that means the button has already been selected,
                // proceed
                // click at Year
                tempXpath = xPathCalendarEditorButton + "[text()='" + year + "']";
                if (isElementExist(tempXpath, 1))
                    clickOnElement(tempXpath);
                    // if not found that means the button has already been selected,
                    // proceed
                else
                {
                    // if the desired year is larger than the year in the list,
                    // proceed to next year tab
                    if (Integer.parseInt(year) > Calendar.getInstance().get(Calendar.YEAR))
                    {
                        WebElementFacade elementTemp = waitElementToBePresent(xPathCalendarEditorButton + "[text()='>']");
                        while (true)
                        {
                            elementTemp.click();
                            tempXpath = xPathCalendarEditorButton + "[text()='" + year + "']";
                            if (!isElementExist(tempXpath, 1))
                            {
                                clickOnElement(tempXpath);
                                break;
                            }
                        }
                    }
                    else if (Integer.parseInt(year) < Calendar.getInstance().get(Calendar.YEAR))
                    {
                        WebElementFacade elementTemp = waitElementToBePresent(xPathCalendarEditorButton + "[text()='<']");
                        while (true)
                        {
                            elementTemp.click();
                            tempXpath = xPathCalendarEditorButton + "[text()='" + year + "']";
                            if (!isElementExist(tempXpath, 1))
                            {
                                clickOnElement(tempXpath);
                                break;
                            }
                        }
                    }
                }
                clickOnElement(xPathCalendarOkButton);// choose day next
                int dayI = Integer.parseInt(day);
                // check if day has already been selected
                tempXpath = "//td[text()='" + dayI + "'][@class='rich-calendar-cell-size rich-calendar-cell " + "rich-calendar-select' " + "or @class='rich-calendar-cell-size rich-calendar-cell " + "rich-calendar-today rich-calendar-select']";
                if (!isElementExist(tempXpath, 1))
                    clickOnElement("//div[@class='rich-calendar-tool-btn'][text()='x']");
                else
                {
                    List<WebElementFacade> elements = findAll("//td[text()='" + dayI + "'][contains(@class, 'rich-calendar-cell-size')]");
                    if (elements.size() == 1)
                        elements.get(0).click();
                    else
                    {
                        if (Integer.parseInt(day) < 20)
                            elements.get(0).click();
                        if (Integer.parseInt(day) > 20)
                            elements.get(1).click();
                    }
                }
                System.out.println("Input calendar date: " + day + "/" + month + "/" + year);
            } catch (Exception e)
            {
                Assert.fail("Input calendar date failed: " + day + "/" + month + "/" + year + ". With exception: " + e);
            }
        }
    }

    /**
     * @Description Pick today date from Calendar. Pre-condition: Calendar must
     * already be opened.
     * @author Vincent
     */
    public void calendarSetToday()
    {
        // Click on Today
        clickOnElement(xPathCalendarTodayButton);
        if (isElementExist("//div[@class='rich-calendar-tool-btn'][text()='x']", 1))
        {
            // Close Calendar
            clickOnElement("//div[@class='rich-calendar-tool-btn'][text()='x']");
        }
    }

    /**
     * @Description Pick today date from Calendar besides label text.
     * @author Vincent
     */
    public void calendarSetTodayWithLabel(String labelText)
    {
        // Open Calendar
        clickOnElement(xPathCalendarWithLabel(labelText));
        calendarSetToday();
    }

    // END Calendar
    // BEGIN Text Utilities

    /**
     * @param _givenText
     * @return
     * @Description Create text predicates with text contains special
     * characters. Note: It's not include [].
     * @author Vincent - Tested
     */
    public String sSpecialTextPredicates(String _givenText)
    {
        String[] tokens = _givenText.split("\"|\\'");
        int numText = tokens.length;
        String sSearchPattern = "";
        if (numText > 1)
        {
            sSearchPattern = "contains(text(),'" + tokens[0] + "')";
            for (int i = 1; i < numText; i++)
            {
                sSearchPattern += " and contains(text(),'" + tokens[i] + "')";
            }
            return sSearchPattern;
        }
        else
        {
            return "text()='" + _givenText + "'";
        }
    }

    // END Text Utilities

    // BEGIN Input Remark by click on Remark Icon

    /**
     * @param _xPathRemarksIcon
     * @param _value
     * @Description Enter remarks by click on Remark Icon to open Remarks Popup.
     * @author Vincent
     */
    public void enterRemarkByClickIcon(String _xPathRemarksIcon, String _value)
    {
        clickOnElement(_xPathRemarksIcon);
        String xPathPopupRemarks = "(//div[(contains(@id,'RemarksPopupHeader') or contains(@id,'remarksModalPanelHeader')) and text()='Remarks']//ancestor::table[1])[last()]";
        waitElementToBePresent(xPathPopupRemarks).shouldBeVisible();
        waitTypeAndTab(xPathPopupRemarks + "//textarea", _value);
        clickOnElement(xPathPopupRemarks + "//input[@*='button' and (@value='Close' or @value='Ok')]");
        waitForAllJSCompletes();
        waitForAbsenceOf(xPathPopupRemarks);
    }
    // END Input Remark by click on Remark Icon

    // BEGIN Tag company
    //private String xPathTbCompanyTag = "(//table[contains(@id, 'tblCompanyList')])[1]";

    public void switch_to_tab_company()
    {
        switch_to_tab("Company");
    }

    /**
     * Using check all Company
     *
     * @author Nancy
     */
    //private String xPathTagCheckbox = "//th[contains(@id,'companyTab')]//input[@type='checkbox']";
    private String xParentCompanyTb = "//table[child::thead[contains(@id, 'companyTable_head') and descendant-or-self::*[text()='Company Name']]]";

    public void chooseAllCompany()
    {
        String xAllCompanyCbx = xParentCompanyTb + "/thead//*[@type='checkbox']";
        if (waitElementToBePresent(xAllCompanyCbx).getAttribute("checked") == null)
        {
            xAllCompanyCbx += "/parent::div/following-sibling::div/span";
            waitElementToBePresent(xAllCompanyCbx).click();
            waitForAllJSCompletes();
        }
    }

    /**
     * @Desciption: choose Company is listed in "listCompanyNameSplitByComma'
     * @author Nancy
     */
    public void chooseCompany(String listCompanyNameSplitByComma)
    {
        try
        {
            if (listCompanyNameSplitByComma.contains(","))
            { // a List Company
                // Name
                String[] companyName = listCompanyNameSplitByComma.split(",");
                for (int i = 0; i < companyName.length; i++)
                {
                    String xPathCbx = xParentCompanyTb + "/tbody/tr[child::td[descendant-or-self::*[text()='" + companyName[i].trim() + "']]]/td[2]//div[contains(@class,'ui-chkbox')]";
                    if (isElementExist(xPathCbx))
                    {
                        $(xPathCbx).waitUntilClickable().click();
                        // withAction().moveToElement($(xPathCbx), 1,
                        // 1).click().build().perform();
                    }
                }
            }
            else
            { // not a List Company Name
                String xPathCbx = xParentCompanyTb + "/tbody/tr[child::td[descendant-or-self::*[text()='" + listCompanyNameSplitByComma.trim() + "']]]/td[2]//div[contains(@class,'ui-chkbox')]";
                if (isElementExist(xPathCbx))
                    $(xPathCbx).click();
            }
            waitForAllJSCompletes();
        } catch (Exception ex)
        {
            System.out.println("Exception occurs: " + ex);
        }
    }
    // END Tag company

    // BEGIN Search Panel
    public void enterSearchByInputField(String _parentXpath, String _labelName, String _value, int _resOrder)
    {
        enterInputFieldWithLabel(_parentXpath, _labelName, _value, _resOrder);
    }

    /**
     * @description Type to Fields with Label in the same row
     * @author Nancy
     */
    public void enterSearchByInputField(String _labelName, String _value)
    {
        String xInputFieldWithLabel = "(//table[contains(@id,'search')]//td[preceding-sibling::td[descendant-or-self::*[text()='" + _labelName + "']]]//input[@type='text'])[1]";
        waitTypeAndEnterThenUpdateValue(xInputFieldWithLabel, _value);
    }

    public boolean searchAndSelectByInputCode(String _labelName, String _value)
    {
        enterSearchByInputField(_labelName, _value);
        String xRowValue = "//form[@id='searchResultsForm']//a[child::span[.='" + _value + "']]";
        if (isElementExist(xRowValue))
        {
            clickOnElement(xRowValue);
            return true;
        }
        else
            return false;
    }

    // END Search Panel
    // BEGIN Search In MultiPage
    private static final String SCROLL_TABLE_FIRST_BUTTON    = "//*[contains(@class, 'rich-datascr-button')][text()='««'][not(contains(@class,'dsbld'))]";
    private static final String SCROLL_TABLE_PREVIOUS_BUTTON = "//*[contains(@class, 'rich-datascr-button')][text()='«'][not(contains(@class,'dsbld'))]";
    private static final String SCROLL_TABLE_LAST_BUTTON     = "//*[contains(@class, 'rich-datascr-button')][text()='»»'][not(contains(@class,'dsbld'))]";
    private static final String SCROLL_TABLE_NEXT_BUTTON     = "//*[contains(@class, 'rich-datascr-button')][text()='»'][not(contains(@class,'dsbld'))]";

    public int searchInTbMultiPage(String _parentXpath, String _headerText, int _colResOrder, String _value, boolean _searchFromFirstPage)
    {
        String btnNav1 = "";
        String btnNav2 = "";
        if (_searchFromFirstPage == false)
        {
            btnNav1 = _parentXpath + SCROLL_TABLE_LAST_BUTTON;
            btnNav2 = _parentXpath + SCROLL_TABLE_PREVIOUS_BUTTON;
        }
        else
        {
            btnNav1 = _parentXpath + SCROLL_TABLE_FIRST_BUTTON;
            btnNav2 = _parentXpath + SCROLL_TABLE_NEXT_BUTTON;
        }
        // Go to last page or first list
        if (isElementExist(btnNav1, 1))
        {
            clickOnElement(btnNav1);
        }

        while (true)
        {
            // Get column index of value to search
            int colIndex = getTbColHeaderIndex(_parentXpath, _headerText, _colResOrder);
            // Get all data cells
            List<WebElementFacade> dataCellResults = findAll(xPathTbDataCellsInCol(_parentXpath, colIndex));
            // Check all data cell results
            for (int i = 0; i < dataCellResults.size(); i++)
            {
                if (dataCellResults.get(i).containsOnlyText(_value))
                {
                    return i + 1;
                }
            }

            { // next page
                if (isElementExist(btnNav2, 1))
                {
                    clickOnElement(btnNav2);
                }
                else
                {
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
    public int getTbRowsCount(String nameTable)
    {
        String xPath = "((//*[contains(@class, 'header')][text()='" + nameTable + "']/ancestor::table)[last()]/tbody/tr)";
        return findAll(By.xpath(xPath)).size();
    }

    /**
     * Get result search at row=rowIndex
     *
     * @author Nancy
     */

    public void getResultSearch(String labelName, String valueSearch, int row)
    {
        String xPathLable = "(//table[contains(@id,'search')]//*[text()='" + labelName + "']//ancestor::td)[last()]/following-sibling::td//input[@type='text']";
        String xPathsearch = "(//table[contains(@id,'search')]//*[text()='" + labelName + "']//ancestor::td)[last()]/following-sibling::td//input[@type='button']";
        $(xPathLable).typeAndTab(valueSearch);
        $(xPathsearch).waitUntilClickable().click();

        String xPathFirstRow = "(//tbody[@id='searchResult_Form:searchResult_Table:tb']/tr[" + row + "]//a[@href])[1]";
        $(xPathFirstRow).waitUntilClickable().click();
        waitForAllJSCompletes();
    }

    /**
     * @Description: To switch in a iframe
     * @author Nancy
     */
    public void switchToIFrame(String idIFrame)
    {
        getDriver().switchTo().frame(idIFrame);
    }

    public void switchToIFrame()
    {
    	String idIFrame="th5frame";
        getDriver().switchTo().frame(idIFrame);
    }

    /**
     * @Description: To switch out default iframe
     * @author Nancy
     */
    public void switchOutDefaultIFrame()
    {
        getDriver().switchTo().defaultContent();
    }

    /**
     * @Description: To switch out parent iframe
     * @author Nancy
     */
    public void switchOutParentIFrame()
    {
        getDriver().switchTo().parentFrame();
    }

    /**
     * @description: Delete value using filter at table
     * @author Nancy
     */
    public void deleteValueByFilter(String xParent, String colFilterName, String valueDelete)
    {
        String xHeaderFilterCell = xPathTbHeaderFilterCell(xParent, colFilterName);
        if (!isElementExist(xHeaderFilterCell))
        {
            clickBtn("Back To Summary");
            waitForAllJSCompletes();
        }
        int filterColIndex = getTbColHeaderIndexByText(colFilterName);
        String xFirstRow = xHeaderFilterCell + "/ancestor::table[1]/tbody/tr[1]/td[" + filterColIndex + "]//*[@href]";
        waitTypeAndEnter(xHeaderFilterCell, valueDelete);
        waitForAllJSCompletes();
        if (findAll(xFirstRow).size() > 0)
        {
            $(xFirstRow).waitUntilClickable().click();
            waitForAllJSCompletes();
            clickBtn("Delete");
            chooseYesOnUpdateConfirmation();
        }

    }

    /**
     * @param searchBtnName - Button name to Search
     * @description: Delete value using filter at table
     * @author Nancy
     */
    public void deleteValueBySearchBtn(String searchBtnName, String labelName, String valueDelete, String colName)
    {

    }

    /**
     * @author Nancy
     */
    public void verifyMesg(List<String> listA, List<String> listB)
    {
        SoftAssertions softly = new SoftAssertions();
        int sizeListA = listA.size();
        int sizeListB = listB.size();

        if (sizeListA <= sizeListB)
        {
            int i;
            for (i = 0; i < sizeListA; i++)
            {
                softly.assertThat(listA.get(i)).as("Parameter " + i).isEqualTo(listB.get(i));
            }
            for (; i < sizeListB; i++)
            {
                softly.assertThat("").as("Parameter " + i).isEqualTo(listB.get(i));
            }
        }
        else
        {
            int i;
            for (i = 0; i < sizeListB; i++)
            {
                softly.assertThat(listA.get(i)).as("Parameter " + i).isEqualTo(listB.get(i));
            }
            for (; i < sizeListA; i++)
            {
                softly.assertThat(listA.get(i)).as("Parameter " + i).isEqualTo("");
            }
        }
        softly.assertAll();
    }

    public void verifyMesg(List<String> listA, String stringB)
    {
        List<String> listB = new ArrayList<>();
        int sizeListA = listA.size();
        for (int i = 0; i < sizeListA; i++)
        {
            listB.add(stringB);
        }
        verifyMesg(listA, listB);
    }

    public void verifyMesg(String stringA, String stringB)
    {
        assertThat(stringA.equals(stringB)).isTrue();
    }

    /**
     * @Description: Use to convert date,
     * @parameter: Type=1 >> from format dd/mm/yyyy to format yyyy-mm-dd
     * @parameter: Type=2 >> from format yyyy-mm-dd to format dd/mm/yyyy
     * @author: Nancy
     */
    public String convertDate(String date, int type)
    {
        String result = "";
        String[] sDate;
        switch (type)
        {
            case 1:
                sDate = date.split("/");
                result = sDate[2] + "-" + sDate[1] + "-" + sDate[0];
                break;
            case 2:
                sDate = date.split("-");
                result = sDate[2] + "/" + sDate[1] + "/" + sDate[0];
                break;
        }
        return result;
    }

    public void verifyMessage(String sessionKey, int colActualMessage, int colExpectedMessage)
    {
        SoftAssertions softly = new SoftAssertions();
        List<List<String>> tbReport = new ArrayList<>();
        List<String> lineMessage;
        tbReport = Serenity.sessionVariableCalled(sessionKey);
        if (tbReport == null)
            tbReport = new ArrayList<>();

        for (int i = 1; i < tbReport.size(); i++)
        {
            lineMessage = new ArrayList<>();
            lineMessage = tbReport.get(i);
            String actualMess = lineMessage.get(colActualMessage).trim();
            String expectedMess = lineMessage.get(colExpectedMessage).trim();
            softly.assertThat(actualMess).as(i + ". Message").isEqualTo(expectedMess);
        }
        softly.assertAll();

    }

    public String hasPopupMessage()
    {
        String xPopup = "//div[@id='message-code']//span[@message-code]";
        if (isElementExist(xPopup))
        {
            return $(xPopup).getText();
        }
        return null;
    }

    /**
     * @Description: date must be formated is dd/mm/yyy
     * @author Nancy
     */
    public String previousDay(String ddMMyyyy)
    {
        try
        {
            Date nextDateFrom = new SimpleDateFormat("dd/MM/yyyy").parse(ddMMyyyy);

            Date dateTo = new Date(nextDateFrom.getTime() - (24 * 3600000));
            String newstring = new SimpleDateFormat("dd/MM/yyyy").format(dateTo);
            return newstring;
        } catch (ParseException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String nextsDay(String ddMMyyyy)
    {
        try
        {
            Date nextDateFrom = new SimpleDateFormat("dd/MM/yyyy").parse(ddMMyyyy);
            Date dateTo = new Date(nextDateFrom.getTime() + (24 * 3600000));
            String newstring = new SimpleDateFormat("dd/MM/yyyy").format(dateTo);
            return newstring;
        } catch (ParseException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean clickOnIconWithLabel(String labelName)
    {
        String xIcon = "//div[preceding-sibling::div[text()='" + labelName + "']]//button";
        if (isElementExist(xIcon))
        {
            $(xIcon).click();
            waitForAllJSCompletes();
            return true;
        }
        return false;
    }

    public void clickOnCloseIcon(String tableName)
    {
        waitForAllJSCompletes();
        String xCloseIcon = "//a[@href][preceding-sibling::span[text()='" + tableName + "']]/span";
        $(xCloseIcon).waitUntilClickable().click();
        waitForAllJSCompletes();
    }

    /**
     * Nancy copy from Levin
     */
    public static String getToday()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    public void switchToParentFrame()
    {
        getDriver().switchTo().parentFrame();
    }
    
    /** Fill date time 
     * @param dd/MM/yyyy
     */
    public static final String DATE_PICKER = "//div[contains(@class,'ui-datepicker-header ui')]";
    public void setCalendarDate(String ddMMyyyy)
    {
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

        waitElementToBeVisible(DATE_PICKER, 3);

        // select month
        clickOnElement("//select[@class='ui-datepicker-month'][@data-handler='selectMonth']");
        clickOnElement("//select[@class='ui-datepicker-month']/option[text()='" + month + "']");
        // select year
        clickOnElement("//select[@class='ui-datepicker-year'][@data-handler='selectYear']");
        clickOnElement("//select[@class='ui-datepicker-year']/option[text()='" + year + "']");
        // select day
        String dayS = Integer.parseInt(day) + "";
        clickOnElement("//*[@data-handler='selectDay']//a[text()='" + dayS + "']");
    }

}
