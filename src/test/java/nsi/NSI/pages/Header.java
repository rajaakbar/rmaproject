package nsi.NSI.pages;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import cucumber.api.java.en.Given;
import nsi.BaseClass;
import nsi.Log;

public class Header extends BaseClass
{

    HeaderElements ele = new HeaderElements();

    @Given("^NSI Header click link by text \"([^\"]*)\"$")
    public void nsi_header_click_link_by_text(String text)
    {
        mobile = isItMobileOrDesktopBrowser();
        if (mobile)
        {
            mobileViewExpandMenu();
        }
        $(By.linkText(text)).click();

    }

    @Given("^NSI Header click Register$")
    public void nsi_header_click_register()
    {
        $(By.partialLinkText("Register")).click();
    }

    @Given("^NSI Header click NSI Logo$")
    public void nsi_header_click_nsi_logo()
    {
        ele.Logo.scrollTo();
        ele.Logo.click();
    }

    @Given("^NSI Header click home$")
    public void nsi_header_click_home()
    {
        mobile = isItMobileOrDesktopBrowser();
        if (mobile)
        {
            mobileViewExpandMenu();
        }
        ele.Home.click();

    }

    @Given("^NSI Header searchInputField visible$")
    public void nsi_header_searchInputField_visible()
    {
        ele.searchInputField.isDisplayed();
    }

    @Given("^NSI Header submit search \"([^\"]*)\"$")
    public void nsi_header_submit_search(String srchQuery)
    {
        mobile = isItMobileOrDesktopBrowser();
        if (mobile)
        {
            ele.SearchMobile.click();
            ele.searchInputFieldMobile.setValue(srchQuery);
            ele.searchButtonMobile.click();
        }
        else
        {
            ele.SearchDesktop.click();
            ele.searchInputField.setValue(srchQuery);
            sleepFor(750);
            ele.recentSrchList.isDisplayed();
            ele.searchInputField.setValue(srchQuery);
            ele.desktopSearchButton.click();
        }

    }

    @Given("^NSI Header select option \"([^\"]*)\" on the slider$")
    public void nsi_Header_select_option_on_the_slider(int option) throws Throwable
    {
        switch (option)
        {
        case 1:
            $(By.xpath(".//*[@class='flexslider slider-hero']/ol/li[1]/a")).click();
            break;
        case 2:
            $(By.xpath(".//*[@class='flexslider slider-hero']/ol/li[2]/a")).click();
            break;
        case 3:
            $(By.xpath(".//*[@class='flexslider slider-hero']/ol/li[3]/a")).click();
            break;

        }
        Log.info("NOTE - Slider radio clicked for option " + option);
    }

    @Given("^NSI Header click the link on the current slider$")
    public void nsi_Header_click_the_link_on_the_current_slider() throws Throwable
    {
        ele.SliderLink.click();
    }

    @Given("^NSI Header verify hero header contains \"([^\"]*)\"$")
    public void nsi_Header_verify_hero_header_contains(String Text) throws Throwable
    {
        assertThat(ele.heroHeader.getText(), containsString(Text));
    }

    private static class HeaderElements
    {
        SelenideElement Logo = $(By.xpath("//img[@alt='NS&I logo']"));

        SelenideElement SearchMobile = $(By.xpath(".//*[text()='Search']"));

        SelenideElement SearchDesktop = $(By.id("btn-search"));

        SelenideElement Home = $(By.xpath("//a[contains(.,'Home')]"));

        SelenideElement searchInputField = $(By.id("edit-question"));

        SelenideElement searchInputFieldMobile = $(By.id("edit-combine"));

        SelenideElement searchButtonMobile = $(By.id("edit-submit-search"));

        SelenideElement recentSrchList = $(By.xpath("//li[contains(.,'Recent searches')]"));

        // SelenideElement mobileMenuClick = $(By.cssSelector(" a.menu-toggle"));

        SelenideElement SliderLink = $(By.xpath(".//*[@class='flex-active-slide']//a"));

        SelenideElement heroHeader = $(By.xpath(".//*[@class='hero-header']"));

        SelenideElement desktopSearchButton = $(By.id("edit-submit"));
    }
}
