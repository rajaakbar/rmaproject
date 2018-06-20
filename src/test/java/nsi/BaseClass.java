package nsi;

import static com.codeborne.selenide.Condition.text;
// import static com.codeborne.selenide.Screenshots.takeScreenShot;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.source;
import static com.codeborne.selenide.WebDriverRunner.url;
import static nsi.ServiceProperties.getProperty;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestRule;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.TextReport;

public abstract class BaseClass
{
    protected static String bCheck = System.getProperty("browser");

    protected boolean mobile = false;

    static
    {
        Locale.setDefault(Locale.ENGLISH);
    }

    // @Rule
    // public ScreenShooter img = ScreenShooter.failedTests().succeededTests();

    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    protected boolean isItMobileOrDesktopBrowser()
    {
        if (bCheck.contains("galaxys") || bCheck.contains("iphone"))
        {
            mobile = true;
        }
        else
        {
            mobile = false;
        }
        return mobile;
    }

    protected void waitForElement(By element)
    {
        Wait().withMessage("Waiting for " + element + " to be displayed").pollingEvery(50, TimeUnit.MILLISECONDS)
                .withTimeout(30, TimeUnit.SECONDS).until(presenceOfElementLocated(element));
    }

    public static String getPageTitle()
    {
        return $(By.className("heading-xlarge")).getText();
    }

    public static String getPageURL()
    {
        return url();
    }

    protected void areElementsVerticallyAligned(SelenideElement ele1, SelenideElement ele2)
    {
        int ele1X = ele1.getCoordinates().onPage().getX();
        int ele2X = ele2.getCoordinates().onPage().getX();
        assertThat("Elements are not vertically aligned", ele1X, equalTo(ele2X));
    }

    protected void areElementsHorizontallyAligned(SelenideElement ele1, SelenideElement ele2)
    {
        int ele1Y = ele1.getCoordinates().onPage().getY();
        int ele2Y = ele2.getCoordinates().onPage().getY();
        assertThat("Elements are not horizontally aligned", ele1Y, equalTo(ele2Y));
    }

    protected void areElementsTheSameHeight(SelenideElement ele1, SelenideElement ele2)
    {
        int ele1Height = ele1.getSize().getHeight();
        int ele2Height = ele2.getSize().getHeight();
        assertThat("Elements are not the same height", ele1Height, equalTo(ele2Height));
    }

    protected void areElementsTheSameWidth(SelenideElement ele1, SelenideElement ele2)
    {
        int ele1Width = ele1.getSize().getWidth();
        int ele2Width = ele2.getSize().getWidth();
        assertThat("Elements are not the same width", ele1Width, equalTo(ele2Width));
    }

    protected void isElementBackgroundColour(SelenideElement ele, String colour)
    {
        String eleColour = Color.fromString(ele.getCssValue("background-color")).asHex();
        System.out.println(eleColour);
        assertThat("Element background colour does not match " + colour.toLowerCase(), eleColour, equalTo(colour));
    }

    protected void switchingBrowserTabs(String tabName)
    {

        switchTo().window(tabName);

    }

    protected void isElementFontColour(SelenideElement ele, String colour)
    {

        String eleColour = Color.fromString(ele.getCssValue("color")).asHex();
        System.out.println(eleColour);
        assertThat("Element font colour does not match " + colour, eleColour, equalTo(colour));
    }

    protected void isElementBorderColour(SelenideElement ele, String colour)
    {

        String eleColour = Color.fromString(ele.getCssValue("color")).asHex();
        System.out.println(eleColour);
        assertThat("Element font colour does not match " + colour, eleColour, equalTo(colour));
    }

    protected String getElementBorderColour(SelenideElement ele)
    {
        String eleColour = Color.fromString(ele.getCssValue("background-color")).asHex();
        return eleColour;
    }

    protected String getElementBackgroundColour(SelenideElement ele)
    {
        String eleColour = Color.fromString(ele.getCssValue("background-color")).asHex();
        return eleColour;
    }

    protected String getElementColour(SelenideElement ele)
    {
        String eleColour = Color.fromString(ele.getCssValue("color")).asHex();
        return eleColour;
    }

    // protected void checkPageForBugs(WebDriver driver)
    // {
    // WebPage webPage = new WebPage(driver);
    // FightingLayoutBugs flb = new FightingLayoutBugs();
    // final Collection<LayoutBug> layoutBugs = flb.findLayoutBugsIn(webPage);
    // System.out.println("Found " + layoutBugs.size() + " layout bug(s).");
    // for (LayoutBug bug : layoutBugs) { System.out.println(bug); }
    // }

    protected void checkPageContent(String contentText)
    {
        // $(By.id("content")).shouldHave(text(contentText));
        assertThat($(By.id("content")).getText(), containsString(contentText));
    }

    protected void printoutpagecontent()
    {
        System.out.println($(By.id("content")));
    }

    protected void checkPageContentShouldNotHave(String contentText)
    {
        $(By.className("main-grid")).shouldNotHave(text(contentText));
    }

    protected void checkHelpPageContent(String contentText)
    {
        // $(By.id("content")).shouldHave(text(contentText));
        assertThat($(By.id("content")).getText(), containsString(contentText));
    }

    protected void sleepFor(int millisecs)
    {
        sleep(millisecs);
    }

    protected void refreshCurrentPage()
    {
        refresh();
    }

    protected void saveHTMLTakeScreenShot() throws Exception
    {
        if ((getProperty(PropertyConstants.SAVE_HTML_Screen).equalsIgnoreCase("y")))
        {
            String here = url();
            final String page = source();
            Path path = Paths.get(here.substring(21));
            String fName = path.toString();
            fName = fName.replace("\\", "-");
            final File f = new File(getProperty(PropertyConstants.SAVE_FOLDER) + fName + ".html");
            FileUtils.writeStringToFile(f, page, "UTF-8");
            Shutterbug.shootPage(WebDriverRunner.getWebDriver(), ScrollStrategy.BOTH_DIRECTIONS).withTitle(title())
                    .withName(fName).save("./target/screenshots/nsi/");
            Log.info("Saved screenshot :- " + fName + ".html to " + getProperty(PropertyConstants.SAVE_FOLDER));
        }
    }

    protected String dateNow()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH_mm");
        Date dn = new Date();
        return sdf.format(dn);
    }

    protected String getAdjustedDOBDay(int adjustDays)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, adjustDays);
        String newDateFormat = sdf.format(cal.getTime());
        String newDay = newDateFormat.split("-")[2];
        return newDay;
    }

    protected String getAdjustedDOBMonth(int adjustDays)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, adjustDays);
        String newDateFormat = sdf.format(cal.getTime());
        String newMonth = newDateFormat.split("-")[1];
        return newMonth;
    }

    protected String getAdjustedDOBYear(int adjustDays)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, adjustDays);
        String newDateFormat = sdf.format(cal.getTime());
        String newYear = newDateFormat.split("-")[0];
        return newYear;
    }

    protected String stringToSentenceCase(String option)
    {
        option = option.toUpperCase();
        char upper = option.charAt(0);
        option = upper + (option.substring(1).toLowerCase());
        return option;
    }

    protected void mobileViewExpandMenu()
    {
        mobile = isItMobileOrDesktopBrowser();
        if (mobile)
        {
            waitForElement(By.xpath("//a[@class='menu-toggle']"));
            $(By.xpath("//a[@class='menu-toggle']")).scrollTo();
            Log.info("Site running in mobile view mode using " + bCheck);
            $(By.xpath("//a[@class='menu-toggle']")).click();
        }
    }
}
