package nsi.NSI.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nsi.BaseClass;
import nsi.Log;

public class HomePage extends BaseClass
{

    HomePageElements ele = new HomePageElements();

    // OBJECTS
    private static class HomePageElements
    {
        SelenideElement acceptCookieBtn = $(By.id("btn--cookie"));

        SelenideElement SearchField = $(By.id("edit-search-block-form--2"));

        SelenideElement GoButton = $(By.id("pb_checker_button"));

        SelenideElement continueToAdviserSite = $(By.xpath("//a[contains(.,'Adviser Centre')]"));

        SelenideElement keyProductListItemOne = $(By.xpath(
                "//ul[@class='list list--products list--products-switchable grid-by-default remove-margin list--grid-view']/li[1]/div[1]"));

        SelenideElement keyProductListItemTwo = $(By.xpath(
                "//ul[@class='list list--products list--products-switchable grid-by-default remove-margin list--grid-view']/li[2]/div[1]"));

        SelenideElement keyProductListItemThree = $(By.xpath(
                "//ul[@class='list list--products list--products-switchable grid-by-default remove-margin list--grid-view']/li[3]/div[1]"));

        SelenideElement keyProdcutOneRadioSelector = $(By.xpath("//*[@id='block-system-main']//li[1]/ol/li[2]/a"));

        SelenideElement keyProdcutTwoRadioSelector = $(By.xpath("//*[@id='block-system-main']//li[2]/ol/li[2]/a"));

        SelenideElement keyProductThreeRadioSelector = $(By.xpath("//*[@id='block-system-main']//li[3]/ol/li[2]/a"));

        SelenideElement promoPannelLeft = $(
                By.xpath("//div[@class='promo-panel promo--inline promo--inline-1-2 promo-panel-left']/div[1]"));

        SelenideElement promoPannelRight = $(
                By.xpath("//div[@class='promo-panel promo--inline promo--inline-1-2 promo-panel-right']/div[1]"));

        SelenideElement shareThisPageFindAService = $(By.id("at-expanded-menu-filter"));

    }

    @Given("^NSI HomePage CurrentPoll is visible$")
    public void nsi_HomePage_CurrentPoll_is_visible() throws Throwable
    {
        $(By.id("block-poll-recent")).isDisplayed();
    }

    @Given("^NSI HomePage ShareThisPage click \"([^\"]*)\" icon$")
    public void nsi_HomePage_ShareThisPage_click_icon(String icon) throws Throwable
    {
        switch (icon.toLowerCase())
        {
        case "facebook":
            $(By.id("at-svg-facebook-1")).click();
            break;
        case "print":
            $(By.id("at-svg-print-2")).click();
            break;
        case "twitter":
            $(By.id("at-svg-twitter-3")).click();
            break;
        case "email":
            $(By.id("at-svg-email-4")).click();
            break;
        case "add more":
            $(By.id("at-svg-addthis-5")).click();
            break;
        default:
            break;
        }
    }

    @Given("^NSI HomePage ShareThisPage \"([^\"]*)\" icon visible$")
    public void nsi_HomePage_ShareThisPage_icon_visible(String icon) throws Throwable
    {
        switch (icon.toLowerCase())
        {
        case "facebook":
            $(By.id("at-svg-facebook-1")).isDisplayed();
            break;
        case "print":
            $(By.id("at-svg-print-2")).isDisplayed();
            break;
        case "twitter":
            $(By.id("at-svg-twitter-3")).isDisplayed();
            break;
        case "email":
            $(By.id("at-svg-email-4")).isDisplayed();
            break;
        case "add more":
            $(By.id("at-svg-addthis-5")).isDisplayed();
            break;
        default:
            break;
        }
    }

    @Given("^NSI HomePage ShareThisPage Find a service visible$")
    public void nsi_HomePage_ShareThisPage_Find_a_service_visible() throws Throwable
    {
        ele.shareThisPageFindAService.isDisplayed();
    }

    @When("^NSI HomePage SupportPanel click on logo position \"([^\"]*)\"$")
    public void nsi_HomePage_SupportPanel_click_on_logo_position(String logoPostion) throws Throwable
    {
        switch (logoPostion.toLowerCase())
        {
        case "one":
            $(By.xpath("//*[@id='sponsor-logo-cont']/li[1]")).click();
            break;
        case "two":
            $(By.xpath("//*[@id='sponsor-logo-cont']/li[2]")).click();

            break;
        case "three":
            $(By.xpath("//*[@id='sponsor-logo-cont']/li[3]")).click();
            break;
        case "four":
            $(By.xpath("//*[@id='sponsor-logo-cont']/li[4]")).click();
            break;
        case "five":
            $(By.xpath("//*[@id='sponsor-logo-cont']/li[5]")).click();
            break;
        default:
            assertThat("***** Could not find a product in postion " + logoPostion + " to be able to click", false);

            break;
        }
    }

    @Given("^NSI HomePage PromoPanel verify colour of item one \"([^\"]*)\" item two \"([^\"]*)\"$")
    public void nsi_HomePage_PromoPanel_verify_colour_of_item_one_item_two(String itemOne, String itemTwo)
            throws Throwable
    {
        isElementBackgroundColour(ele.promoPannelLeft, "#" + itemOne);

        isElementBackgroundColour(ele.promoPannelRight, "#" + itemTwo);
    }

    @Then("^NSI HomePage PromoPanel clicking product \"([^\"]*)\"$")
    public void nsi_HomePage_PromoPanel_clicking_product(String product) throws Throwable
    {
        switch (product.toLowerCase())
        {
        case "one":
            ele.promoPannelLeft.click();
            break;
        case "two":
            ele.promoPannelRight.click();
            break;

        default:
            assertThat("***** Could not find a product in postion " + product + " to be able to click", false);

            break;
        }
    }

    @Given("^NSI HomePage PromoPanel is aligned$")
    public void nsi_HomePage_PromoPanel_is_aligned() throws Throwable
    {
        mobile = isItMobileOrDesktopBrowser();
        if (mobile)
        {
            areElementsVerticallyAligned(ele.promoPannelLeft, ele.promoPannelRight);
        }
        else
        {
            areElementsHorizontallyAligned(ele.promoPannelLeft, ele.promoPannelRight);
        }

    }

    @Then("^NSI HomePage KeyProduct clicking product \"([^\"]*)\"$")
    public void nsi_HomePage_KeyProduct_clicking_product(String product) throws Throwable
    {

        switch (product.toLowerCase())
        {
        case "one":
            ele.keyProductListItemOne.click();
            break;
        case "two":
            ele.keyProductListItemTwo.click();
            break;
        case "three":
            ele.keyProductListItemThree.click();
            break;
        default:
            assertThat("***** Could not find a product in postion " + product + " to be able to click", false);

            break;
        }
    }

    @Given("^NSI HomePage KeyProducts scroll to$")
    public void nsi_homepage_keyproducts_scroll_to() throws Throwable
    {
        ele.keyProductListItemOne.scrollTo();
    }

    @Given("^NSI HomePage KeyProducts are aligned$")
    public void nsi_HomePage_KeyProducts_are_aligned() throws Throwable
    {
        mobile = isItMobileOrDesktopBrowser();
        if (mobile)
        {
            areElementsVerticallyAligned(ele.keyProductListItemOne, ele.keyProductListItemTwo);
            areElementsVerticallyAligned(ele.keyProductListItemTwo, ele.keyProductListItemThree);
            areElementsVerticallyAligned(ele.keyProductListItemThree, ele.keyProductListItemOne);
        }
        else
        {
            areElementsHorizontallyAligned(ele.keyProductListItemOne, ele.keyProductListItemTwo);
            areElementsHorizontallyAligned(ele.keyProductListItemTwo, ele.keyProductListItemThree);
            areElementsHorizontallyAligned(ele.keyProductListItemThree, ele.keyProductListItemOne);
        }

    }

    @Given("^NSI HomePage KeyProduct verify colour of item one \"([^\"]*)\" item two \"([^\"]*)\" item three \"([^\"]*)\"$")
    public void nsi_HomePage_KeyProduct_verify_colour_of_item_one_item_two_item_three(String itemOne, String itemTwo,
            String itemThree) throws Throwable
    {
        isElementBackgroundColour(ele.keyProductListItemOne, "#" + itemOne);
        isElementBackgroundColour(ele.keyProductListItemTwo, "#" + itemTwo);
        isElementBackgroundColour(ele.keyProductListItemThree, "#" + itemThree);
    }

    @Then("^NSI HomePage KeyProduct \"([^\"]*)\" contains text \"([^\"]*)\"$")
    public void nsi_HomePage_KeyProduct_contains_text(String product, String text) throws Throwable
    {
        switch (product.toLowerCase())
        {
        case "one":
            ele.keyProductListItemOne.getText().contains(text);
            break;
        case "two":
            ele.keyProductListItemTwo.getText().contains(text);
            break;
        case "three":
            ele.keyProductListItemThree.getText().contains(text);
            break;
        default:
            assertThat("***** Could not find a product in postion " + product + "that contains the text " + text,
                    false);
            break;
        }
    }

    @When("^NSI HomePage KeyProduct submit radio option two$")
    public void nsi_HomePage_KeyProduct_submit_radio_option_two() throws Throwable
    {
        ele.keyProdcutOneRadioSelector.click();
        ele.keyProdcutTwoRadioSelector.click();
        ele.keyProductThreeRadioSelector.click();
    }

    @Given("^NSI HomePage I accept cookies$")
    public void nis_homepage_i_accept_cookies() throws Throwable
    {
        if (ele.acceptCookieBtn.isDisplayed())
        {
            ele.acceptCookieBtn.click();
        }
        else
        {
            Log.info("*** - Accept cookie link not available **Not an Issue**");
        }
        refresh();
    }

    @Given("^NSI HomePage submit continue to adviser centre$")
    public void nsi_HomePage_submit_continue_to_adviser_centre() throws Throwable
    {
        if (ele.continueToAdviserSite.isDisplayed())
        {
            ele.continueToAdviserSite.click();
        }
        else
        {
            Log.info("*** - Continue to adviser site option not available **Not an issue**");
        }
    }

    @Given("^NSI HomePage Send search with \"([^\"]*)\" text$")
    public void nsi_HomePage_Send_search_with_text(String text) throws Throwable
    {
        ele.SearchField.setValue(text);
        ele.GoButton.click();
    }
}
