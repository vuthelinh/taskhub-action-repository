package com.synergix.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LaunchBrowsers {

	public WebDriver lauchEdge() {

		// https://msdn.microsoft.com/en-us/library/mt188085(v=vs.85).aspx
		String serverPath = System.getProperty("user.dir") + "\\driver\\MicrosoftWebDriver.exe";
		System.setProperty("webdriver.edge.driver", new File(serverPath).getAbsolutePath());

		EdgeOptions options = new EdgeOptions();
		options.setPageLoadStrategy("edger");

		DesiredCapabilities capabilities = DesiredCapabilities.edge();
		capabilities.setCapability(EdgeOptions.CAPABILITY, options);
		return new EdgeDriver(capabilities);
	}

	public WebDriver lauchFirefox() throws IOException {

		// Save the path of the XPI files as per your saved location
		String firebugPath = System.getProperty("user.dir") + "\\addon\\firebug-2.0.15-fx.xpi";

		// Create a new Profile for the new settings
		FirefoxProfile profile = new FirefoxProfile();
		// Pass the XPIs path to the profile
		profile.addExtension(new File(firebugPath));

		// Set default Firebug preferences and FirePath preferences
		// https://getfirebug.com/wiki/index.php/Firebug_Preferences
		String ext = "extensions.firebug.";

		profile.setPreference(ext + "currentVersion", "2.0.15");
		profile.setPreference(ext + "allPagesActivation", "on");
		profile.setPreference(ext + "defaultPanelName", "net");
		profile.setPreference(ext + "net.enableSites", true);

		/*
		 * The Firefox browser offers hundreds of configuration options, or
		 * Preferences, in its about:config interface. These about:config
		 * entries dictate both beginner and advanced browser behavior.
		 * ttp://browsers.about.com/od/aboutconfigentries/
		 * 
		 */
		profile.setPreference("browser.startup.homepage_override.mstone", "ignore");
		profile.setPreference("startup.homepage_welcome_url.additional", "about:blank");

		/*
		 * How to Use browser.download.folderList The value of
		 * browser.download.folderList can be set to either 0, 1, or 2. When set
		 * to 0, Firefox will save all files downloaded via the browser on the
		 * user's desktop. When set to 1, these downloads are stored in the
		 * Downloads folder. When set to 2, the location specified for the most
		 * recent download is utilized again.
		 * 
		 */

		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.startup.homepage", "https://www.google.co.in");
		profile.setPreference("browser.helperApps.neverAsk.openFile", "application/excel");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/excel");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.dir", "C:\\Users\\jacob\\Download");

		return new FirefoxDriver(profile);
	}

	public WebDriver lauchChrome() {

		String serverPath = System.getProperty("user.dir") + "\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", new File(serverPath).getAbsolutePath());

		return new ChromeDriver();
	}

	public WebDriver lauchPhantomJS() {

		String serverPath = System.getProperty("user.dir") + "\\driver\\phantomjs.exe";
		// System.setProperty("phantomjs.binary.path", new File(serverPath).getAbsolutePath());

		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
		((DesiredCapabilities) caps).setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				serverPath);

		return new PhantomJSDriver(caps);
	}

	public WebDriver lauchIE() {

		String serverPath = System.getProperty("user.dir") + "\\driver\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", new File(serverPath).getAbsolutePath());

		// "Enable Protected Mode" from Security tab for all zone of IE settings.
		DesiredCapabilities capabilitiesIE = DesiredCapabilities.internetExplorer();
		capabilitiesIE.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilitiesIE.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
		
		// https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/ie/InternetExplorerDriver.html
		capabilitiesIE.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "https://testvmm6.partnersonline.com/vmm");
		DesiredCapabilities.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
		// DesiredCapabilities.setCapability("IE.binary", "C:/Program Files (x86)/Internet Explorer/iexplore.exe");
		capabilitiesIE.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilitiesIE.setJavascriptEnabled(true);
		capabilitiesIE.setCapability("requireWindowFocus", true);
		capabilitiesIE.setCapability("enablePersistentHover", false);

		return new InternetExplorerDriver(capabilitiesIE);
	}
}
