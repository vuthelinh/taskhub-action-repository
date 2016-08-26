package com.synergix.common.actions;

import com.synergix.common.CONST;
import com.synergix.common.constants.ElementID;
import com.synergix.common.constants.ElementID_TH6;
import com.synergix.utilities.DateTimeUtil;
import com.synergix.utilities.MailBean;
import com.synergix.utilities.ReadBean;
import com.synergix.utilities.SessionData;
import net.serenitybdd.core.Serenity;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

//import org.openqa.selenium.support.ui.FlutWait;

public class PageActions_Base extends net.serenitybdd.core.pages.PageObject
{
    private WebElement       element;
    private List<WebElement> elements;

    private WebDriver driver;
    protected boolean proceedAfterError  = false;
    protected double  progressBarTimeOut = 1;
    protected double  circleTimeOut      = 1;
    protected String  attachScreenShot   = "1";

    { // set the properties file for atu reporter
        //System.setProperty("atu.reporter.config", "atu.properties");
    }

    final int PASSED = 0;
    final int FAILED = 1;

    public PageActions_Base(WebDriver driver)
    {
        super(driver);
    }

    public void setActionDriver_Base(WebDriver driver)
    {
        this.driver = driver;
        setReportInfo();
    }

    public void setReportInfo()
    {
//        ATUReports.setWebDriver(driver);
//        ATUReports.setAuthorInfo("Levin's Automation Test for TH5", DateBean.getTimeNow(), "1.0");
    }

    public void report(String stepDesc, String value, int result)
    {
        //ATUReports.add(stepDesc, value, LogAs, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
//        if (attachScreenShot.equalsIgnoreCase("1"))
//            ReadBean.attachJPG(takeScreenShot());
        print(stepDesc + " : " + value);
    }

    public void report(String stepDesc, String value, int result, Exception e)
    {
        report(stepDesc, value, result);
        if (result == FAILED)
        {
            e.printStackTrace();
            customAssert(e.getMessage());
        }
    }

    public void report(String stepDesc, String value, int result, WebElement element)
    {
        report(stepDesc, value, result);
    }

    public void report(String stepDesc, String value, int result, WebElement element, Exception e)
    {
        report(stepDesc, value, result, e);
    }

    // constructor used for multilogin
    public PageActions_Base(WebDriver dr, String baseURL)
    {
        driver = dr;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    public WebDriver getActionDriver()
    {
        return this.driver;
    }

    public static void print(String s)
    {
        String a = DateTimeUtil.getTimestamp() + " " + s;
        System.out.println(a);
    }

    public String getBaseURL()
    {
        return driver.getCurrentUrl();
    }

    public void refresh()
    {
        driver.navigate().refresh();
    }

    public String getTitle()
    {
        return driver.getTitle();
    }

    public void quit()
    {
        try
        {
            driver.quit();
        } catch (Exception e)
        {
        }
    }

    public void highlightElement(WebElement element) throws Exception
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public void clearCache()
    {
        Actions actionObject = new Actions(driver);
        actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).perform();
    }

    public void ctrlA(String xPathCSS)
    {
        try
        {
            element = getElement(xPathCSS, 1);
            element.click();
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        } catch (Exception e)
        {
            // no exception
        }
    }

    public void sendKey(Keys s)
    {
        element.sendKeys(s);
    }

    public String getTableReport()
    {
        String s = "";
        try
        {
            s = SessionData.generateTbDataReport(CONST.reportKey);
            SessionData.clearTbDataReport(CONST.reportKey);
        } catch (Exception e)
        {
            return "";
        }
        return s;
    }

    public void customAssert(String message)
    {
        if (proceedAfterError)
        {
            SoftAssertions softly = new SoftAssertions();
            softly.assertThat(true).as(message).isFalse();
        }
        else
        {
            String report = getTableReport();
            ReadBean.writeToFile(CONST.REPORT_FILE, report, true);
            if (System.getProperty("send.email") != null)
                if (System.getProperty("send.email").equalsIgnoreCase("Y"))
                {
                    try
                    {
                        // to send email with steps report and exception message
                        String sbj = Serenity.sessionVariableCalled(CONST.FAIL_SUBJECT);
                        String msg = Serenity.sessionVariableCalled(CONST.FAIL_MESSAGE) + "\n" + report + "\n" + message;

//                    String senderID = System.getProperty("email.sender.id");
//                    String senderPwd = System.getProperty("email.sender.password");
//                    String from = System.getProperty("email.from");
//                    String recipient = System.getProperty("email.to");
//                    String cc1 = System.getProperty("email.cc1");
//                    String cc2 = System.getProperty("email.cc2");
//                    String cc3 = System.getProperty("email.cc3");
//
//                    InternetAddress[] to = new InternetAddress[]{new InternetAddress(recipient)};
//                    InternetAddress[] cc = new InternetAddress[]{new InternetAddress(cc1), new InternetAddress(cc2), new InternetAddress(cc3)};
//                    MailBean.sendMail("mail.synergixtech.com", "25", senderID, senderPwd, from, to, cc, sbj, msg, ElementID_TH6.REPORT_FILE);

                        if (notEmpty(sbj) && notEmpty(msg))
                            MailBean.sendEmailToPY(sbj, msg, CONST.REPORT_FILE);
                    } catch (Exception e)
                    {

                    }
                }
            assertTrue(message, false);
        }
    }

    public void getFocus(WebElement element)
    {
        // JavascriptExecutor jse = (JavascriptExecutor) driver;
        // jse.executeScript("document.getElementById('elementid').focus();");
        new Actions(driver).moveToElement(element).click().perform();// get
        // mouse
        // focus
    }

    public void waitForElementToShow(String xPathCSS, long timeOut)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            if (xPathCSS.contains("@") || xPathCSS.contains("//"))
            {// xpath
                // print("Wait
                // for " +
                // xPathCSS);
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathCSS)));
            }
            else
            {// css
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(xPathCSS)));
            }
        } catch (Exception e)
        {
        }
    }

    public void waitForElementToVanish(String xPathCSS, long timeOut)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
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

    public void waitForElementToPresence(String xPathCSS, long timeOut)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            if (xPathCSS.contains("@") || xPathCSS.contains("//"))
            {// xpath
                elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xPathCSS)));
                // System.out.println("Found " + xPathCSS);
            }
            else
            {// css
                elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(xPathCSS)));
                // System.out.println("Found " + xPathCSS);
            }
        } catch (Exception e)
        {
        }
    }

    public void waitForElementToBeClickable(String xPathCSS, long timeOut)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            if (xPathCSS.contains("@") || xPathCSS.contains("//"))
            {// xpath
                print("Wait for " + xPathCSS);
                element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathCSS)));
            }
            else
            {// css
                print("Wait for " + xPathCSS);
                element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(xPathCSS)));
            }
        } catch (Exception e)
        {
        }
    }

    public void waitForElementToShow(WebElement element, long timeOut)
    {
        try
        {
            sleep(0.1);
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            element = wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e)
        {
        }
    }

    public void waitForElementToBeClickable(WebElement element, long timeOut)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            element = wait.until(ExpectedConditions.visibilityOf(element));
            element = wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e)
        {
        }
    }

    // handle textbox when disable or readonly - wait for them to be able to
    // input again
    public boolean waitForElementToBeInputtable(WebElement element, double timeOut)
    {
        try
        {
            String readonly = "";
            String disable = "";
            readonly = element.getAttribute("readonly");
            disable = element.getAttribute("disabled");
            try
            {
                readonly.equals("true");
            } catch (NullPointerException e)
            {
                readonly = "false";
            }
            try
            {
                disable.equals("true");
            } catch (NullPointerException e)
            {
                disable = "false";
            }

            if (timeOut > 0)
            {
                if (readonly.equals("true") || disable.equals("true"))
                {
                    sleep(0.2);
                    waitForElementToBeInputtable(element, timeOut - 0.2);
                    return true;
                }
            }
            return false;
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean waitForElementToBeDisabled(WebElement element)
    {
        try
        {
            String classDis = "";
            classDis = element.getAttribute("class");
            try
            {
                classDis.contains("dsbld");
            } catch (NullPointerException e)
            {
                classDis = "false";
            }

            if (classDis.equals("true"))
            {
                return true;
            }
            else
            {
                sleep(0.2);
                waitForElementToBeDisabled(element);
            }
            return true;

        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean waitForElementToBeInputtable(String xPathCSS)
    {
        try
        {
            element = getElement(xPathCSS, 1);
            String readonly = "";
            String disable = "";
            readonly = element.getAttribute("readonly");
            disable = element.getAttribute("disabled");
            try
            {
                readonly.equals("true");
            } catch (NullPointerException e)
            {
                readonly = "false";
            }
            try
            {
                disable.equals("true");
            } catch (NullPointerException e)
            {
                disable = "false";
            }
            if (readonly.equals("true") || disable.equals("true"))
            {
                sleep(0.2);
                waitForElementToBeInputtable(element, 1);
                return true;
            }
            return false;
        } catch (Exception e)
        {
            return false;
        }
    }

    /**
     * Wait for value in element to show in html after input
     *
     * @param xPathCss xpath of css of the textbox
     * @param timeOut  The time out of method
     * @author Levin
     */
    public void waitForTextValueToShow(String xPathCss, long timeOut)
    {
        try
        {
            waitForElementToShow(element, timeOut);
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            // while
            // (!wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xPathCss),
            // " "))) {
            // sleep(0.2);
            // }
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xPathCss), " "));
        } catch (Exception e)
        {
        }
    }

    public void waitForTextToBePresent(WebElement element, String text, long timeOut)
    {
        try
        {
            waitForElementToShow(element, timeOut);
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            // while
            // (!wait.until(ExpectedConditions.textToBePresentInElementValue(element,
            // text))) {
            // sleep(0.2);
            // }
            wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
            print("Text is inputted: " + text);
        } catch (Exception e)
        {

        }
    }

    // for dropdown option
    public void waitForElementToBeSelected(WebElement element, long timeOut)
    {
        try
        {
            //			WebDriverWait wait = new WebDriverWait(driver, timeOut);
            //			while (!wait.until(ExpectedConditions.elementToBeSelected(element)))
            //			{
            //				sleep(0.2);
            //			}

            while (true)
            {
                if (!isChecked(element))
                {
                    sleep(0.2);
                    timeOut -= 0.2;
                }

                if (isChecked(element))
                    break;

                if (timeOut == 0)
                    break;
            }
        } catch (Exception e)
        {
        }
    }

    public List<WebElement> getElementChildren(WebElement temp, String xPath) throws Exception
    {
        List<WebElement> eles = null;
        // print("Searching for " + xPath);
        if (xPath.startsWith("//"))
        {
            // waitForElementToShow(temp.findElement(By.xpath("." + xPath)),
            // 10);
            eles = temp.findElements(By.xpath("." + xPath));
        }
        else
        {
            // waitForElementToShow(temp.findElement(By.xpath(".//" +
            // xPath)), 10);
            eles = temp.findElements(By.xpath(".//" + xPath));
        }
        if (notNull(eles))
        {
            print("Found element " + xPath);
        }
        else
        {
            print("Not found element " + xPath);
        }
        return eles;
    }

    public List<WebElement> getElementChildrenNoException(List<WebElement> eles, String xPath)
    {
        try
        {
            // print("Searching for children " + xPath);
            for (WebElement ele : eles)
            {
                if (xPath.startsWith("//"))
                {
                    try
                    {
                        elements = ele.findElements(By.xpath("." + xPath));
                    } catch (Exception e)
                    {
                    }
                }
                else
                {
                    try
                    {
                        elements = ele.findElements(By.xpath(".//" + xPath));
                    } catch (Exception e)
                    {
                    }
                }
            }
            if (notNull(elements))
            {
                print("Found " + xPath);
            }
            return elements;
        } catch (Exception e)
        {
            return null;
        }
    }

    public WebElement getElement(String xPathCSS, long timeOut) throws Exception
    {
        if (empty(xPathCSS))
            return null;
        // print("Searching for " + xPathCSS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        waitForElementToPresence(xPathCSS, timeOut);
        waitForAjax((long) 0.5);
        if (xPathCSS.contains("@") || xPathCSS.contains("//"))
        {// xpath
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathCSS)));
        }
        else
        {// css
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(xPathCSS)));
        }
        scrollIntoView(element);
        // element = driver.findElement(By.xpath(xPath));
        print("Found element " + xPathCSS);
        return element;
    }

    public WebElement getHiddenElement(String xPathCSS, long timeOut) throws Exception
    {
        if (empty(xPathCSS))
            return null;
        // print("Searching for " + xPathCSS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        waitForElementToPresence(xPathCSS, timeOut);
        waitForAjax((long) 0.5);
        if (xPathCSS.contains("@") || xPathCSS.contains("//"))
        {// xpath
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathCSS)));
        }
        else
        {// css
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(xPathCSS)));
        }
        scrollIntoView(element);
        // element = driver.findElement(By.xpath(xPath));
        print("Found element " + xPathCSS);
        return element;
    }

    // nothing happens if no elements found
    public WebElement getElementNoException(String xPathCSS, long d)
    {
        try
        {
            // print("Searching for " + xPathCSS);
            WebDriverWait wait = new WebDriverWait(driver, d);
            // waitForElementToShow(xPathCSS, d); // no need, will slow down
            waitForAjax((long) 0.5);
            if (xPathCSS.contains("@") || xPathCSS.contains("//"))
            {// xpath
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathCSS)));
            }
            else
            {// css
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(xPathCSS)));
            }
            if (element != null)
            {
                scrollIntoView(element);
                print("Found " + xPathCSS);
            }
            // element = driver.findElement(By.xpath(xPath));
            return element;
        } catch (Exception e)
        {
            return null;
        }
    }

    public List<WebElement> getElements(String xPathCSS, long timeOut) throws Exception
    {
        return getElements(xPathCSS, timeOut, true);
    }

    public List<WebElement> getElements(String xPathCSS, long timeOut, boolean waitToShow) throws Exception
    {
        // print("Searching for " + xPathCSS);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        if (waitToShow)
            waitForElementToShow(xPathCSS, timeOut);
        waitForAjax(1);
        // must set condition = presence, if set condition = visible, will
        // stuck when there are 2 same name columns in 2 different tabs
        if (xPathCSS.contains("@") || xPathCSS.contains("//"))
        {// xpath
            elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xPathCSS)));
        }
        else
        {// css
            elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(xPathCSS)));
        }
        scrollIntoView(elements.get(0));
        // element = driver.findElement(By.xpath(xPath));
        print("Found elements [" + elements.size() + "] " + xPathCSS);
        return elements;
    }

    // nothing happens if no elements found
    public List<WebElement> getElementsNoException(String xPathCSS, long timeOut)
    {
        try
        {
            // print("Searching for " + xPathCSS);
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            waitForElementToShow(xPathCSS, timeOut);
            waitForAjax((long) 0.5);
            if (xPathCSS.contains("@") || xPathCSS.contains("//"))
            {// xpath
                elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xPathCSS)));
            }
            else
            {// css
                elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(xPathCSS)));
            }
            // element = driver.findElement(By.xpath(xPath));
            scrollIntoView(elements.get(0));
            print("Found " + elements.size() + xPathCSS);
            return elements;
        } catch (Exception e)
        {
            return null;
        }
    }// nothing happens if no elements found

    public List<WebElement> getElementsNoException(String xPathCSS, long timeOut, boolean waitToShow)
    {
        try
        {
            // print("Searching for " + xPathCSS);
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            if (waitToShow)
                waitForElementToShow(xPathCSS, timeOut);
            waitForAjax(1);
            if (xPathCSS.contains("@") || xPathCSS.contains("//"))
            {// xpath
                elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xPathCSS)));
            }
            else
            {// css
                elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(xPathCSS)));
            }
            // element = driver.findElement(By.xpath(xPath));
            print("Found " + elements.size() + xPathCSS);
            return elements;
        } catch (Exception e)
        {
            return null;
        }
    }

    // ------------------------Auto Column Name Handling---------------------//
    public int getElementsCount(String xPathCSS)
    {
        int count = 0;
        try
        {
            // waitForAjax(3);
            elements = getElementsNoException(xPathCSS, (long) 0.5);
            count = elements.size();
        } catch (Exception e)
        {
            count = 0;
        }
        return count;
    }

    public int getColumnCount(String xPathCSS)
    {
        int count = 0;
        try
        {
            waitForAjax((long) progressBarTimeOut);
            elements = driver.findElements(By.xpath(xPathCSS));
            if (notNull(elements))
            {
                count = elements.size() + 1;
            }
            else
            {
                count = 1;
            }
        } catch (Exception e)
        {
        }
        return count == 0 ? count + 1 : count;
    }

    protected String tdCount = "";

    public WebElement getVisibleElement(List<WebElement> eles)
    {
        if (eles == null)
            return null;
        for (WebElement ele : eles)
        {
            if (checkElementVisible(ele))
            {
                print("Element is visible");
                return ele;
            }
        }
        print("Not found visible element, get first element instead");
        return eles.get(0);
    }

    public int getVisibleElementPos(List<WebElement> eles)
    {
        int pos = 0;
        if (eles == null)
            return 0;
        for (WebElement ele : eles)
        {
            if (checkElementVisible(ele))
            {
                print("Child is visible " + (pos + 1));
                return pos + 1;
            }
            pos++;
        }
        print("Element at position " + (pos + 1));
        return pos;
    }

    public void waitPageLoad(int sec)
    {
        try
        {
            driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void sleep(double d)
    {
        try
        {
            Thread.sleep((long) (d * 1000));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void openURL(String URL)
    {
        try
        {
            driver.navigate().to(URL);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void scrollIntoView(WebElement element) throws Exception
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        highlightElement(element);
    }

    public String getText(WebElement element)
    {
        String text = "";
        if (element.getText().equals(""))
            text = element.getAttribute("value");
        else
            text = element.getText();
        if (text == null)
            return "";
        print(text);
        return text;
    }

    public String getTextByXpathCSS(String xPathCSS)
    {
        String text = "";
        try
        {
            element = getElement(xPathCSS, 10);
            if (element.getText().equals(""))
                text = element.getAttribute("value");
            else
                text = element.getText();
            print(text);
        } catch (Exception e)
        {
            report("Get text value from: " + xPathCSS, "", FAILED, e);
        }
        return text;
    }

    public String getTextByXpathCSSNoException(String xPathCSS)
    {
        element = getElementNoException(xPathCSS, 1);
        if (element != null)
        {
            String text = "";
            if (element.getText().equals(""))
                text = element.getAttribute("value");
            else
                text = element.getText();
            print(text);
            return text;
        }
        else
        {
            return "";
        }
    }

    public String getInfoPanelText()
    {
        return getTextByXpathCSSNoException("//*[@class='rich-message-label'] | //*[@class='rich-messages-label']");
    }

    public String getErrorMessages()
    {
        elements = getElementsNoException("//span[@class='error-message']", 1);
        String text = "";
        if (elements != null)
        {
            for (WebElement ele : elements)
            {
                if (ele.getText().equals(""))
                {
                    text += ele.getAttribute("value");
                }
                else
                {
                    text += ele.getText();
                }
                text += "\n";
            }
            print(text);
        }
        else
        {
            return "";
        }
        return text;
    }

    public boolean isInputted(WebElement element, String value)
    {
        try
        {
            String check = element.getAttribute("value");
            try
            {
                check.equals(value);
            } catch (NullPointerException e)
            {
                return false;
            }
            if (equalsValue(check, value))
                return true;
            else
                return false;
        } catch (Exception e)
        {
            return false;
        }
    }

    /**
     * Clear the text with using javascript option (to handle an issue in TH6
     * where the text value auto clear after inputted
     *
     * @author Levin
     */
    public void clearText(WebElement element, boolean JVSmode) throws Exception
    {
        if (JVSmode)
        { // clear text using javascript
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].setAttribute('value', '')", element);
        }
        else
            element.clear();
    }

    public void inputText(WebElement element, String value, boolean JVSmode, boolean isEnter) throws Exception
    {
        inputText_Core(element, value, JVSmode, isEnter, false);
    }

    public void inputText(WebElement element, String value, boolean JVSmode, boolean isEnter, boolean waitAbitThenEnter) throws Exception
    {
        inputText_Core(element, value, JVSmode, isEnter, waitAbitThenEnter);
    }

    /**
     * Input the text value with using javascript option
     *
     * @author Levin
     */

    private void inputText_Core(WebElement element, String value, boolean JVSmode, boolean isEnter, boolean waitAbitThenEnter) throws Exception
    {
        if (JVSmode)

        { // clear text using javascript
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
        }
        else
            element.sendKeys(value);
        if (isEnter)
        {
            if (waitAbitThenEnter)
            {
                WebElement ele = getElementNoException("//*[contains(@class, 'ui-autocomplete-item')]", 1);
                if (ele != null)
                    clickAtElement_JS(ele);
            }
            element.sendKeys(Keys.ENTER);
            //element.sendKeys(Keys.TAB);
        }
    }

    public boolean isChecked(String xPathCSS)
    {
        element = getElementNoException(xPathCSS, 1);
        return isChecked(element);
    }

    public boolean isChecked(WebElement element)
    {
        try
        {
            String check = element.getAttribute("checked");
            try
            {
                check.equals("true");

            } catch (NullPointerException e)
            {// happen when attribute does not
                // exist
                check = "false";
            }
            if (check.equals("true"))
                return true;
            else
            {
                if (element.isSelected())
                    return true;
                else
                    return false;
            }
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean isSelected(WebElement element)
    {
        try
        {
            String check = element.getAttribute("selected");
            try
            {
                check.equals("true");
            } catch (NullPointerException e)
            {// happen when attribute does not
                // exist
                check = "false";
            }
            if (check.equals("true") || check.equals("selected"))
                return true;
            else
            {
                if (element.isSelected())
                    return true;
                else
                    return false;
            }
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean isTagName(WebElement element, String tagName)
    {
        try
        {
            String check = element.getTagName();
            try
            {
                check.equals(tagName);
            } catch (NullPointerException e)
            {// happen when attribute does not
                // exist
                return false;
            }
            if (check.equals(tagName))
                return true;
            else
                return false;
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean isEnable(String xPathCSS, int timeOut)
    {
        element = getElementNoException(xPathCSS, timeOut);
        return isEnable(element);
    }

    public boolean isEnable(WebElement element)
    {
        try
        {
            if (isAttribute(element, "disabled", "true") || isAttribute(element, "readonly", "true") || !element.isEnabled() || element.getAttribute(
                    "class").contains("dsbld"))
                return false;
            else
                return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean isAttribute(WebElement element, String att, String value)
    {
        try
        {
            String attr = element.getAttribute(att);
            try
            {
                attr.equals(value);
            } catch (NullPointerException e)
            {// happen when attribute does not
                // exist
                return false;
            }
            if (attr.equals(value))
                return true;
            else
                return false;
        } catch (Exception e)
        {
            return false;
        }
    }

    public void clickJavaScript(String xPathCSS) throws Exception
    {
        element = getHiddenElement(xPathCSS, 10);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clickAtXpathCSS_Base(String xPathCSS) throws Exception
    {
        element = getElement(xPathCSS, 10);
        clickAtElement(element, 0.5);
    }

    public void clickAtElement(WebElement element, double progressBarTimeOut) throws Exception
    {
        // waitForElementToBeClickable(element, 10);
        if (element.isEnabled() && element.isDisplayed())
        {
            // check if dropdownlist has been selected
            if (isTagName(element, "option"))
            {
                if (!isSelected(element))
                {
                    element.click();
                    //waitForElementToBeSelected(element, 1); // futile, element has been changed
                    waitForAjax((long) progressBarTimeOut);
                }
            }
            // radio, checkbox
            else if (isAttribute(element, "type", "radio") || isAttribute(element, "type", "checkbox"))
            {
                element.click();
                //waitForElementToBeSelected(element, 1); // futile, element has been changed
                waitForAjax((long) progressBarTimeOut);
            }
            // button, tab
            else
            {
                element.click();
                waitForAjax((long) progressBarTimeOut);
            }
        }
        else
        {
            print("Element is not enabled or displayed");
        }
    }

    public void clickAtElement_JS(WebElement element) throws Exception
    {
        // waitForElementToBeClickable(element, 10);
        if (element.isEnabled())
        {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            waitForAjax(1);
        }
        else
        {
            print("Element is not enabled");
        }
    }

    public void setCheckbox(WebElement element, String value, double progressBarTimeOut) throws Exception
    {
        if (notEmpty(value))
        {
            if (value.toLowerCase().equals("true") || value.toLowerCase().equals("check") || value.toLowerCase().equals(
                    "yes") || value.toLowerCase().equals("y"))
            {
                if (!isChecked(element))
                {
                    clickAtElement(element, progressBarTimeOut);
                }
            }
            if (value.toLowerCase().equals("false") || value.toLowerCase().equals("uncheck") || value.toLowerCase().equals(
                    "no") || value.toLowerCase().equals("n"))
            {
                if (isChecked(element))
                {
                    clickAtElement(element, progressBarTimeOut);
                }
            }
        }
    }

    public boolean checkErrorMessage()
    {
        if (checkElementVisible("span[class='error-message']"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkElementVisible(String xPathCSS)
    {
        try
        {
            element = getElementNoException(xPathCSS, 1);
            return checkElementVisible(element);
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean checkElementVisible(WebElement element)
    {
        try
        {
            if (element != null)
            {
                if (element.isDisplayed() && element.isEnabled())
                    return true;
                else
                    return false;
            }
            else
                return false;
        } catch (Exception e)
        {
            return false;
        }
    }

    public String takeScreenShot()
    {
        try
        {
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
            String imgPath = "screenshots/allure/screenlog.jpg";
            FileUtils.copyFile(screenshot, new File(imgPath));
            return imgPath;
        } catch (IOException e)
        {
            return "";
        }
    }

//    public void takeScreenShot(ITestResult result, String className)
//    {
//        WebDriver augmentedDriver = new Augmenter().augment(driver);
//        File      screenshot      = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
//        String    imgPath         = "screenshots/failed/" + DateBean.getTimeTodayNoSlash() + "_" + className + ".jpg";
//        try
//        {
//            FileUtils.copyFile(screenshot, new File("test-output/" + imgPath));// imgPath
//            // in
//            // Reporter
//            // log
//            // has
//            // already
//            // included
//            // test-output
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//
//        print("Took a screen shot at: " + imgPath);
//
//        Reporter.setCurrentTestResult(result);
//        Reporter.log("Failed");
//        Reporter.log("<br> <a href='" + imgPath + "'> <img src='" + imgPath + "' height='500' width='800'/> </a> <br>");
//        Reporter.setCurrentTestResult(null);
//    }

//    public void takeScreenShot(String className)
//    {
//        className = className.replaceAll("[^a-zA-Z0-9]+", "_");
//        WebDriver augmentedDriver = new Augmenter().augment(driver);
//        File      screenshot      = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
//        String    imgPath         = "screenshots/failed/" + DateBean.getTimeTodayNoSlash() + "_" + className + ".jpg";
//        try
//        {
//            FileUtils.copyFile(screenshot, new File("test-output/" + imgPath));// imgPath
//            // in
//            // Reporter
//            // log
//            // has
//            // already
//            // included
//            // test-output
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//
//        print("Took a screen shot at: " + imgPath);
//
//        Reporter.log("Failed");
//        Reporter.log("<br> <a href='" + imgPath + "'> <img src='" + imgPath + "' height='500' width='800'/> </a> <br>");
//    }

//    public File captureElementBitmap(WebElement element) throws Exception
//    {
//        // get the WrapsDriver of the WebElement
//        WrapsDriver wrapsDriver = (WrapsDriver) element;
//        // get the entire screenshot from the driver of passed WebElement
//        File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
//        // create an instance of Buffered Image from captured screenshot
//        BufferedImage img = ImageIO.read(screen);
//        // get the Width and Height of the WebElement using
//        int width  = element.getSize().getWidth();
//        int height = element.getSize().getHeight();
//        // create a rectangle using Width and Height
//        Rectangle rect = new Rectangle(width, height);
//        // get the Location of WebElement in a Point
//        // this will provide X&Y co-ordinates of the WebElementa
//        Point p = element.getLocation();
//        // create image by for element using its location and size
//        // this will give image data specific to the WebElement
//        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
//        // write back the image data for element in File object
//        ImageIO.write(dest, "jpg", screen);
//        // return the File object containing image data
//        return screen;
//    }

    protected static String ajaxMode = ""; // TH5 or TH6

    public void waitForAjax(long timeOut)
    {
        if (ajaxMode.equalsIgnoreCase(ElementID.AJAX_MODE))
        {
            waitForElementToPresence("//span[contains(@id,'_viewRoot:status.start')][contains(@style,'display: none')]", timeOut);
            waitForElementToPresence("//span[contains(@id,'_viewRoot:status.stop')][@style!='display: none;']", 600);
        }
        else if (ajaxMode.equalsIgnoreCase(ElementID_TH6.AJAX_MODE))
        {
            waitForProgressBar(timeOut);
        }
    }

    /**
     * Wait for ajax to finish loading, polling each 0.2sec with timeout = 3sec,
     * after that, wait for Progressbar to vanish
     *
     * @author Levin
     */

    // TH6
    @Deprecated
    public void waitForCircle(long timeOut)
    {
        boolean isAjaxFinished = false;
        while (true)
        {
            sleep(0.2);
            isAjaxFinished = (boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active == 0");
            if (isAjaxFinished)
            {
                break;
            }

            if (timeOut > 0)
                timeOut -= 0.2;
            else if (timeOut == 0)
                break;
        }

        if (timeOut == 0)
        {
            waitForElementToShow(ElementID_TH6.PROGRESS_CIRCLE, (long) circleTimeOut);
            waitForElementToVanish(ElementID_TH6.PROGRESS_CIRCLE, 600);
        }
    }

    /**
     * Wait for page to finish loading data when showing progress bar
     *
     * @author Levin
     */
    public void waitForProgressBar(long timeOut)
    {
        if (ajaxMode.equalsIgnoreCase("TH5"))
        {
            waitForAjax(timeOut);
            waitForElementToShow(ElementID.PROGRESS_PANEL, timeOut);
            waitForElementToVanish(ElementID.PROGRESS_PANEL, 600);// in case
            // progress bar
            // appears, wait
            // for it to
            // load for 10
            // mins
        }
        else if (ajaxMode.equalsIgnoreCase("TH6"))
        {
            waitForElementToShow(ElementID_TH6.AJAX_LOADER, timeOut);
            waitForElementToVanish(ElementID_TH6.AJAX_LOADER, 600);
        }
    }

    // http://stackoverflow.com/questions/9588827/webdriver-switch-to-new-browser-opened-after-click-on-button
    public void switchToNewWindow()
    {
        // Store the current window handle
        // String winHandleBefore = driver.getWindowHandle();
        // Perform the click operation that opens new window
        // Switch to new window opened
        for (String winHandle : driver.getWindowHandles())
        {
            driver.switchTo().window(winHandle);
        }
        // Perform the actions on new window
        // Close the new window, if that window no more required
        // driver.close();
        // Switch back to original browser (first window)
        // driver.switchTo().window(winHandleBefore);
        // continue with original browser (first window)
    }

    public void switchToWindow(String winHandleBefore)
    {
        driver.switchTo().window(winHandleBefore);
    }

    public void close()
    {
        try
        {
            driver.close();
        } catch (Exception e)
        {

        }
    }

    /**
     * Wait for a text string to vanish out of the screen
     *
     * @param text    The text to wait
     * @param timeOut Time out to wait
     * @author Levin
     */
    public void waitForTextToVanish(String text, long timeOut)
    {
        if (text.contains(("\"")))
        {
            waitForElementToVanish("//*[contains(text(),'" + text + "')] | //*[contains(@value,'" + text + "')]", timeOut);
        }
        else
        {
            waitForElementToVanish("//*[contains(text(),\"" + text + "\")] | //*[contains(@value,\"" + text + "\")]", timeOut);
        }
    }

    /**
     * Wait for a text string to show on the screen
     *
     * @param text    The text to wait
     * @param timeOut Time out to wait
     * @author Levin
     */
    public void waitForTextToShow(String text, long timeOut)
    {
        if (text.contains(("\"")))
        {
            waitForElementToShow("//*[contains(text(),'" + text + "')] | //*[contains(@value,'" + text + "')]", timeOut);
        }
        else
        {
            waitForElementToShow("//*[contains(text(),\"" + text + "\")] | //*[contains(@value,\"" + text + "\")]", timeOut);
        }
    }

    /**
     * Wait for a text string to show on the screen
     *
     * @param text    The text to wait
     * @param timeOut Time out to wait
     * @author Levin
     */
    public void waitForTextToPresence(String text, long timeOut)
    {
        if (text.contains(("\"")))
        {
            waitForElementToPresence("//*[contains(text(),'" + text + "')] | //*[contains(@value,'" + text + "')]", timeOut);
        }
        else
        {
            waitForElementToPresence("//*[contains(text(),\"" + text + "\")] | //*[contains(@value,\"" + text + "\")]", timeOut);
        }
    }

    public boolean checkElementExist(String xPatchCss)
    {
        element = getElementNoException(xPatchCss, 1);
        if (element != null)
        {
            print("Element exists: " + xPatchCss);
            return true;
        }
        print("Element does not exist: " + xPatchCss);
        return false;
    }

    public boolean checkValueExist(String value)
    {
        element = getElementNoException("*[value=\"" + value + "\"]", 1);
        if (element != null)
        {
            print("Value exists: " + value);
            return true;
        }
        print("Value does not exist: " + value);
        return false;
    }

    public boolean checkTextExist(String text, boolean exactMatch)
    {
        if (exactMatch)
            return checkElementVisible("//*[text()=\"" + text + "\"]");
        else
            return checkElementVisible("//*[contains(text(), \"" + text + "\")]");
    }

    // Utils
    public boolean empty(String value)
    {
        return ReadBean.empty(value);
    }

    public boolean notEmpty(String value)
    {
        return ReadBean.notEmpty(value);
    }

    public String trim(String value)
    {
        return value.trim();
    }

    public int toInt(Object value)
    {
        return ReadBean.toInt(value);
    }

    public boolean notNull(List<WebElement> eles)
    {
        try
        {
            if (eles.size() > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e)
        {
            return false;
        }
    }

    /**
     * Compare 2 strings, ignoring upper cases
     *
     * @param valueA String to compare
     * @param valueB String to compare
     * @return boolean
     * @author levin
     */
    public boolean equals(String valueA, String valueB)
    {
        return ReadBean.equalsValue(valueA, valueB);
    }

    public boolean equalsValue(String valueA, String valueB)
    {
        return ReadBean.equalsValue(valueA, valueB);
    }

    public void dragAndDropInsidePanel(String xpathPanel, Point[] points)
    {
        WebElement panel = driver.findElement(By.xpath(xpathPanel));
        Actions actions = new Actions(driver);
        for (int i = 0; i < points.length; i++)
        {
            actions = actions.dragAndDropBy(panel, points[i].x, points[i].y);
        }
        actions.build().perform();
    }

    public void writeLog(String filePath) throws FileNotFoundException
    {
        ReadBean.writeLog(filePath);
    }

    public void switchToFrameID(String frameID)
    {
        try
        {
            driver.switchTo().frame(frameID);
            ajaxMode = ElementID.AJAX_MODE;
        } catch (Exception e)
        {

        }
    }

    public void switchToParentFrame()
    {
        try
        {
            driver.switchTo().parentFrame();
            ajaxMode = ElementID_TH6.AJAX_MODE;
        } catch (Exception e)
        {

        }
    }
}