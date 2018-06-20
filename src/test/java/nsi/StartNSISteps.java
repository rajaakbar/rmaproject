package nsi;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import static nsi.ServiceProperties.getProperty;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class StartNSISteps extends BaseClass
{
    public static String BROWSER = System.getProperty("browser");

    public static String IS_GRID_ON = System.getProperty("gridon");

    public static String BASE_URL = System.getProperty("urlbase");

    public static String headlessBrowser = getProperty(PropertyConstants.HEADLESS).toString();

    public static String BROWSER_NAME = "";

    public static String ENVIRONMENT = "";

    public static String IS_HEADLESS = "";

    public static final String HTTP_PROXY_HOST = "https.proxyHost";

    public static final String HTTP_PROXY_PORT = "https.proxyPort";

    public static final String PROXY_ADDRESS = "proxy-uk.glb.my-it-solutions.net";

    public static final String PROXY_PORT = "84";

    @Before
    public void setup(Scenario sc)
    {
        Log.startTestCase(" Scenario: " + sc.getName().toString());
        baseConfig();
        setProxySettings();
    }

    @After
    public void shutdown(Scenario sc) throws MalformedURLException
    {
        if (sc.getStatus().toString().contains("failed"))
        {
            URL url = new URL(url());

            String fName = StringUtils.strip(url.getPath().replace("/", "-"), "-");

            Shutterbug.shootPage(WebDriverRunner.getWebDriver(), ScrollStrategy.BOTH_DIRECTIONS)
                    .withTitle(title() + "__" + fName).withName(fName).save(Configuration.reportsFolder);

            Log.info("{}.png has been saved in {}" + fName + Configuration.reportsFolder);
        }

        if (IS_GRID_ON.equalsIgnoreCase("y"))
        {
            WebDriverRunner.getWebDriver().close();
            WebDriverRunner.getWebDriver().quit();
        }
        Log.endTestCase("Scenario: " + sc.getName().toString() + " has " + sc.getStatus().toString());
    }

    public void setProxySettings()
    {
        System.setProperty(HTTP_PROXY_HOST, PROXY_ADDRESS);
        System.setProperty(HTTP_PROXY_PORT, PROXY_PORT);
    }

    protected void baseConfig()
    {
        Configuration.driverManagerEnabled = false;

        switch (headlessBrowser.toLowerCase())
        {
        case "y":
            Configuration.headless = true;
            IS_HEADLESS = "headless";
            break;
        case "n":
            Configuration.headless = false;
            IS_HEADLESS = "visible";
            break;
        default:
            Configuration.headless = false;
        }
        Configuration.fastSetValue = true;
        Configuration.savePageSource = false;
        Configuration.reportsFolder = "target/screenshots/";
        Configuration.assertionMode.equals("SOFT");
    }

    @Given("^I open a browser at \"([^\"]*)\"$")
    public void i_open_a_browser_at(String url) throws Throwable
    {
        driverFactory();

        if (getProperty(PropertyConstants.LIVEENVIRONMENT).toLowerCase().equals("y"))
        {
            open("https://www.google.com/");
            clearBrowserLocalStorage();
            clearBrowserCookies();
            open(getProperty(PropertyConstants.BASEURL));
            Log.info("#");
            Log.info("NOTE:- Opening Live NSandI Adviser site");
            Log.info("#");
        }
        else if (getProperty(PropertyConstants.LIVEENVIRONMENT).toLowerCase().equals("n"))
        {
            open("https://www.google.com/");
            clearBrowserCookies();
            open(getProperty(PropertyConstants.QABASEURL));
            Log.info("");
            Log.info("#");
            Log.info("NOTE:- Opening Test NSandI Adviser site");
            Log.info("#");
        }

        else
        {

            Log.info("");
            Log.info("#");
            Log.info("Note:- Opening site at URL - " + url);
            Log.info("#");
        }
    }

    protected void driverFactory() throws MalformedURLException
    {
        WebDriver driver;
        DesiredCapabilities caps;
        if (BROWSER == null)
        {
            BROWSER = getProperty(PropertyConstants.BROWSERTYPE);
        }

        if (IS_GRID_ON == null)
        {
            IS_GRID_ON = getProperty(PropertyConstants.ISGRID);
        }

        if (IS_GRID_ON.equalsIgnoreCase("y"))
        {
            switch (BROWSER.toLowerCase())
            {
            case "chrome":
                driver = new RemoteWebDriver(new URL(getProperty(PropertyConstants.GRIDHOST) + ":"
                        + getProperty(PropertyConstants.GRIDPORT) + "/wd/hub"), DesiredCapabilities.chrome());
                BROWSER_NAME = "windows";
                ENVIRONMENT = "desktop";
                break;

            case "ie":

                driver = new RemoteWebDriver(new URL(getProperty(PropertyConstants.GRIDHOST) + ":"
                        + getProperty(PropertyConstants.GRIDPORT) + "/wd/hub"), DesiredCapabilities.internetExplorer());
                BROWSER_NAME = "windows";
                ENVIRONMENT = "desktop";
                break;

            case "firefox":
                driver = new RemoteWebDriver(new URL(getProperty(PropertyConstants.GRIDHOST) + ":"
                        + getProperty(PropertyConstants.GRIDPORT) + "/wd/hub"), DesiredCapabilities.firefox());
                BROWSER_NAME = "windows";
                ENVIRONMENT = "desktop";
                break;

            case "iphone7":
                Map<String, Object> iphonedeviceMetrics = new HashMap<>();
                iphonedeviceMetrics.put("width", 375);
                iphonedeviceMetrics.put("height", 667);
                iphonedeviceMetrics.put("pixelRatio", 2.0);

                Map<String, Object> iphonemobileEmulation = new HashMap<>();
                iphonemobileEmulation.put("deviceMetrics", iphonedeviceMetrics);
                iphonemobileEmulation.put("userAgent",
                        "Mozilla/5.0 (iPhone; CPU iPhone OS 10_0_1 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) Version/10.0 Mobile/14A403 Safari/602.1");

                ChromeOptions iphonechromeOptions = new ChromeOptions();
                iphonechromeOptions.setExperimentalOption("mobileEmulation", iphonemobileEmulation);
                caps = DesiredCapabilities.chrome();
                caps.setCapability(ChromeOptions.CAPABILITY, iphonechromeOptions);
                driver = new RemoteWebDriver(new URL(getProperty(PropertyConstants.GRIDHOST) + ":"
                        + getProperty(PropertyConstants.GRIDPORT) + "/wd/hub"), caps);
                BROWSER_NAME = "safari mobile";
                ENVIRONMENT = "selenium grid";
                break;

            case "galaxys7":
                Map<String, Object> androiddeviceMetrics = new HashMap<>();
                androiddeviceMetrics.put("width", 360);
                androiddeviceMetrics.put("height", 640);
                androiddeviceMetrics.put("pixelRatio", 4.0);

                Map<String, Object> androidmobileEmulation = new HashMap<>();
                androidmobileEmulation.put("deviceMetrics", androiddeviceMetrics);
                androidmobileEmulation.put("userAgent",
                        "Mozilla/5.0 (Linux; Android 7.0; SAMSUNG SM-G930F Build/NRD90M) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/6.2 Chrome/56.0.2924.87 Mobile Safari/537.36");

                ChromeOptions androidchromeOptions = new ChromeOptions();
                androidchromeOptions.setExperimentalOption("mobileEmulation", androidmobileEmulation);
                caps = DesiredCapabilities.chrome();
                caps.setCapability(ChromeOptions.CAPABILITY, androidchromeOptions);
                driver = new RemoteWebDriver(new URL(getProperty(PropertyConstants.GRIDHOST) + ":"
                        + getProperty(PropertyConstants.GRIDPORT) + "/wd/hub"), caps);
                BROWSER_NAME = "android mobile";
                ENVIRONMENT = "selenium grid";
                break;

            case "safari10":
                Map<String, Object> safarideviceMetrics = new HashMap<>();
                safarideviceMetrics.put("width", 1400);
                safarideviceMetrics.put("height", 900);
                safarideviceMetrics.put("pixelRatio", 1.0);

                Map<String, Object> safarimobileEmulation = new HashMap<>();
                safarimobileEmulation.put("deviceMetrics", safarideviceMetrics);
                safarimobileEmulation.put("userAgent",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13) AppleWebKit/603.1.13 (KHTML, like Gecko) Version/10.1 Safari/603.1.13");

                ChromeOptions safarichromeOptions = new ChromeOptions();
                safarichromeOptions.setExperimentalOption("mobileEmulation", safarimobileEmulation);
                caps = DesiredCapabilities.chrome();
                caps.setCapability(ChromeOptions.CAPABILITY, safarichromeOptions);
                driver = new RemoteWebDriver(new URL(getProperty(PropertyConstants.GRIDHOST) + ":"
                        + getProperty(PropertyConstants.GRIDPORT) + "/wd/hub"), caps);
                BROWSER_NAME = "safari desktop";
                ENVIRONMENT = "selenium grid";
                break;

            default:
                driver = new RemoteWebDriver(new URL(getProperty(PropertyConstants.GRIDHOST) + ":"
                        + getProperty(PropertyConstants.GRIDPORT) + "/wd/hub"), DesiredCapabilities.chrome());
                BROWSER_NAME = "windows";
                ENVIRONMENT = "selenium grid";
                break;
            }
            WebDriverRunner.setWebDriver(driver);
        }
        else
        {

            Configuration.browser = BROWSER;
            Configuration.startMaximized = true;
            BROWSER_NAME = "windows";
            ENVIRONMENT = "desktop";
        }
    }
}
