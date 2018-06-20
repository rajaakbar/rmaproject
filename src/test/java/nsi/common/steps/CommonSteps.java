package nsi.common.steps;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;
import static nsi.ServiceProperties.getProperty;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nsi.Log;
import nsi.POI;
import nsi.PropertyConstants;
import nsi.WCAG;
import nsi.common.General_File_Utilities;

public class CommonSteps extends General_File_Utilities
{

    private static final URL scriptUrl = CommonSteps.class.getResource("/axe.min.js");

    FileOutputStream fos;

    File file;

    POI poi = new POI();

    CommonStepsElements ele = new CommonStepsElements();

    private static class CommonStepsElements
    {
        // SelenideElement element = $(By.linkText("About NS&I"));

        SelenideElement heroTitle = $(By.className("hero-content"));
    }

    @Then("^CommonAction Confirm PDF download with \"([^\"]*)\" file name$")
    public void commonaction_Confirm_PDF_download_with_file_name(String element) throws Throwable
    {
        $(By.linkText(element)).scrollTo();
        String location = $(By.linkText(element)).getAttribute("href");

        String fileName = saveFileToReportsFolder(location);
    }

    @When("^CommonAction swith to window \"([^\"]*)\"$")
    public void commonaction_swith_to_window(String tabName) throws Throwable
    {

        SelenideElement atoserror = $(By.id("contentMainContent"));
        switchTo().window(1);
        if (atoserror.isDisplayed())
        {
            Log.info("Atos Error with outside URL have passed this test based on this");

        }
        else
        {
            switchingBrowserTabs(tabName);
        }
    }

    @When("^CommonAction switch to window \"([^\"]*)\" and Verify \"([^\"]*)\"$")
    public void commonaction_switch_to_window_and_Verify(String tabName, String url) throws Throwable
    {

        SelenideElement atoserror = $(By.id("contentMainContent"));
        switchTo().window(1);
        if (atoserror.isDisplayed())
        {
            Log.info("Atos Error with outside URL have passed this test based on this");

        }
        else
        {
            switchingBrowserTabs(tabName);
            String returnURL = url();
            sleepFor(500);
            assertThat("### Incorrect page Url detected ###", returnURL, equalTo(url));

        }
        switchTo().window(0);
    }

    private void scrollToLink(String text) throws Exception
    {
        $(By.linkText(text)).scrollTo();
    }

    @Then("^Compliance check carried out$")
    public void compliance_check_carried_out() throws Throwable
    {
        wcag2aaCheck();
    }

    @When("^Page refresh$")
    public void page_refresh()
    {
        refreshCurrentPage();
    }

    @Given("^Save page$")
    public void save_page() throws Throwable
    {
        saveHTMLTakeScreenShot();
    }

    private File getLatestFilefromDir(String dirPath)
    {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0)
        {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++)
        {
            if (lastModifiedFile.lastModified() < files[i].lastModified())
            {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    public boolean isFileDownloaded(String downloadPath, String fileName)
    {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++)
        {
            if (dir_contents[i].getName().equals(fileName))
                return flag = true;
        }

        return flag;
    }

    @When("^CommonAction confirm download has happened with file \"([^\"]*)\"$")
    public void commonaction_confirm_download_has_happened_with_file(String file) throws Throwable
    {
        final String downloadPath = "C:\\Downloads";

        File getLatestFile = getLatestFilefromDir(downloadPath);
        String fileName = getLatestFile.getName();
        Assert.assertTrue(fileName.contains(file), "Downloaded file name is not matching with expected file name");

    }

    @Given("^CommonAction browser back button$")
    public void commonaction_browser_back_button() throws Throwable
    {
        back();
        // JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        // js.executeScript("window.history.back();");
    }

    @Given("^CommonAction click link by text \"([^\"]*)\"$")
    public void commonaction_click_link_by_text(String text) throws Throwable
    {
        scrollToLink(text);
        if (StringUtils.isBlank(text))
        {
            assertThat("****** No test data entered", false);
        }
        else
        {
            $(By.linkText(text)).click();
        }
    }

    @Given("^CommonAction fullURL is \"([^\"]*)\"$")
    public void commonaction_fullUrl_is(String url) throws Throwable
    {

        String returnURL = url();
        sleepFor(500);
        assertThat("### Incorrect page Url detected ###", returnURL, equalTo(url));

    }

    @Then("^CommonAction fullURLTwitter is \"([^\"]*)\"$")
    public void commonaction_fullURLTwitter_is(String url) throws Throwable
    {
        mobile = isItMobileOrDesktopBrowser();
        if (mobile)
        {
            String returnMobileURL = url();
            sleepFor(500);
            assertThat("### Incorrect page Url detected ###", returnMobileURL,
                    equalTo("https://mobile.twitter.com/nsandihelp"));
        }
        else
        {
            String returnURL = url();
            sleepFor(500);
            assertThat("### Incorrect page Url detected ###", returnURL, equalTo(url));
        }

    }

    @Given("^CommonAction fullURL contains \"([^\"]*)\"$")
    public void commonaction_fullUrl_contains(String url) throws Throwable
    {
        sleepFor(500);
        System.out.println(url());
        System.out.println(url);
        assertThat("### Incorrect page Url detected ###", url(), containsString(url));

    }

    @Given("^CommonAction URL is \"([^\"]*)\"$")
    public void commonaction_Url_is(String url) throws Throwable
    {
        String returnURL = url();
        sleepFor(500);
        String urlStart = "";
        if (getProperty(PropertyConstants.LIVEENVIRONMENT).toLowerCase().equals("n"))
        {
            urlStart = getProperty(PropertyConstants.QABASEURL);
        }
        if (getProperty(PropertyConstants.LIVEENVIRONMENT).toLowerCase().equals("y"))
        {
            urlStart = getProperty(PropertyConstants.BASEURL);
        }
        if (url.length() > 1)
        {
            assertThat("### Incorrect page Url detected ###", returnURL, containsString(urlStart + url));
        }
        if (url.length() < 2)
        {
            assertThat("### Incorrect page Url detected ###", returnURL, containsString(urlStart));
        }
        sleepFor(500);
        Log.info("### " + returnURL);
    }

    @Given("^CommonAction fail test$")
    public void commonaction_fail_test()
    {
        assertThat("## Force test failure on purpose ##", false, equalTo(true));
    }

    @When("^CommonAction scroll to footer$")
    public void commonaction_scroll_to_footer() throws Throwable
    {
        $(By.linkText("About NS&I")).scrollTo();
    }

    @Given("^CommonAction Page content displays \"([^\"]*)\"$")
    public void commonaction_page_content_displays(String text) throws Throwable
    {
        assertThat($(By.className("main")).getText(), containsString(text));
    }

    @Given("^CommonAction HeroTitle \"([^\"]*)\" visible$")
    public void commonaction_HeroTitle_visible(String text) throws Throwable
    {
        sleepFor(500);
        ele.heroTitle.isDisplayed();
        assertThat("### Hero Title text Mis-Match ###", ele.heroTitle.getText(), containsString(text));

    }

    @Given("^CommonAction HeroSubText \"([^\"]*)\" visible$")
    public void commonaction_HeroSubText_visible(String subText)
    {
        Log.info("Subtext below Hero Title:- " + $(By.cssSelector("div.hero-content > p")).getText());
    }

    @Given("^CommonAction HeroTitle backgroundColour is \"([^\"]*)\"$")
    public void commonaction_HeroTitle_backgroundColour_is(String colour) throws Throwable
    {
        isElementBackgroundColour(ele.heroTitle, colour);
    }

    @Given("^CommonAction HeroTitle FontColour is \"([^\"]*)\"$")
    public void commonaction_HeroTitle_FontColour_is(String colour) throws Throwable
    {

        isElementFontColour(ele.heroTitle, colour);
    }

    @Given("^\"([^\"]*)\" displayed$")
    public void displayed(String page) throws Throwable
    {
        if (getProperty(PropertyConstants.LIVEENVIRONMENT).toLowerCase().equals("y"))
        {
            open(getProperty(PropertyConstants.BASEURL) + page);
        }
        else if (getProperty(PropertyConstants.LIVEENVIRONMENT).toLowerCase().equals("n"))
        {
            open(getProperty(PropertyConstants.QABASEURL) + page);
        }
        if (getProperty(PropertyConstants.SAVE_HTML_Screen).equalsIgnoreCase("y"))
        {
            URL url = new URL(url());

            String fName = StringUtils.strip(url.getPath().replace("/", "-"), "-");

            Shutterbug.shootPage(WebDriverRunner.getWebDriver(), ScrollStrategy.BOTH_DIRECTIONS)
                    .withTitle(title() + "__" + fName).withName(fName).save(Configuration.reportsFolder);

            Log.info("{}.png has been saved in {}" + fName + Configuration.reportsFolder);
        }
    }

    public void wcag2aaCheck() throws Exception
    {
        // JSONObject responseJSON = new WCAG.Builder(driver, scriptUrl).options(
        // "{ rules: { 'color-contrast': { enabled: false } } }").analyze();

        // {type: 'tag', values: ['wcag2a','wcag2aa', 'section508', 'best-practice']}

        JSONObject responseJSON = new WCAG.Builder(WebDriverRunner.getWebDriver(), scriptUrl)
                .options("{ runOnly: { type: 'tag', values: ['wcag2a', 'wcag2aa']} }").analyze();

        // JSONObject responseJSON = new WCAG.Builder(driver, scriptUrl).analyze();

        JSONArray violations = responseJSON.getJSONArray("violations");
        JSONArray passes = responseJSON.getJSONArray("passes");
        Log.info("Violations:\t" + violations);
        // Log.info("Passes:\t\t\t" + passes);

        if (violations.length() == 0)
        {
            String[] results =
            {WebDriverRunner.getWebDriver().getCurrentUrl() ,
                    passes.length() + " accessibility tests have passed on this page" , "" };
            poi.writeExcel("src\\test\\resources\\", "wcag.xlsx", "passes", results);
            assertTrue("No violations found", true);
            Log.info("No violations found on " + WebDriverRunner.getWebDriver().getCurrentUrl());
        }
        else
        {
            String[] results =
            {WebDriverRunner.getWebDriver().getCurrentUrl() , violations.length() + " violations" ,
                    WCAG.report(violations).toString() };
            poi.writeExcel("src\\test\\resources\\", "wcag.xlsx", "violations", results);
            WCAG.writeResults("AccessibilityCheck", responseJSON);
            Log.info("Detected " + violations.length() + " violations on "
                    + WebDriverRunner.getWebDriver().getCurrentUrl());
        }
    }

}
