package nsi.NSI.pages;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import nsi.BaseClass;

public class FAQs extends BaseClass
{
    FAQsElements ele = new FAQsElements();

    private static class FAQsElements
    {
        SelenideElement searchField = $(By.id("edit-combine"));

        SelenideElement faqFilterType = $(By.id("edit-field-faq-type-tid"));

        SelenideElement aTozSwitch = $(By.id("faqs-a-z-switch"));

        SelenideElement mostPopularSwitch = $(By.id("faqs-most-popular-switch"));

        SelenideElement loadMoreBtn = $(By.xpath("//a[contains(.,'Load more')]"));

        // ############ ITEMS DISPLAYED ID's ###########

        SelenideElement fiveItemsDisplayed = $(
                By.xpath("//div[@class='view-content faqs-list--dynamic section-highlight']/ul"));

        SelenideElement moreThanFiveItemsDisplayed = $(
                By.xpath("//div[@class='view-content faqs-list--dynamic section-highlight']/ul[2]"));

        SelenideElement moreThanFiveItemsDisplayedFirstSet = $(
                By.xpath("//div[@class='view-content faqs-list--dynamic section-highlight']/ul[1]"));
    }

    @Given("^NSI FAQs verify drop down link text \"([^\"]*)\"$")
    public void nsi_FAQs_verify_drop_down_link_text(String Text) throws Throwable
    {
        ele.fiveItemsDisplayed.getText().contains(Text);
    }

    @Given("^NSI FAQs submit search text with \"([^\"]*)\"$")
    public void nsi_FAQs_submit_search_text_with(String text) throws Throwable
    {
        ele.searchField.setValue(text);
    }

    @Given("^NSI FAQs submit the drop down search with \"([^\"]*)\"$")
    public void nsi_FAQs_submit_the_drop_down_search_with(String text) throws Throwable
    {
        ele.faqFilterType.selectOption(text);
    }

    @Given("^NSI FAQs submit \"([^\"]*)\" display option$")
    public void nsi_FAQs_submit_display_option(String option) throws Throwable
    {
        switch (option.toLowerCase())
        {
        case "alphabetical":
            ele.aTozSwitch.click();
            break;
        case "most popular":
            ele.mostPopularSwitch.click();
            break;
        default:
            assertThat("***** could not find " + option + "element to be able to click", false);
            break;
        }
    }

    @Given("^NSI FAQs verify \"([^\"]*)\" items are displayed$")
    public void nsi_FAQs_verify_items_are_displayed(int number) throws Throwable
    {
        switch (number)
        {
        case 5:
            ele.fiveItemsDisplayed.isDisplayed();
            break;
        case 10:
            ele.moreThanFiveItemsDisplayedFirstSet.isDisplayed();
            ele.moreThanFiveItemsDisplayed.isDisplayed();
            break;
        default:
            assertThat("***** could not find " + number + "items in the list with element to be able to click", false);
            break;
        }
    }

    @Given("^NSI FAQs submit Load more button$")
    public void nsi_FAQs_submit_Load_more_button() throws Throwable
    {
        ele.loadMoreBtn.click();
    }

    @Then("^NSI FAQs searchField and faqFilterType are aligned$")
    public void nsi_FAQs_searchField_and_faqFilterType_are_aligned() throws Throwable
    {
        mobile = isItMobileOrDesktopBrowser();
        if (mobile)
        {
            areElementsVerticallyAligned(ele.searchField, ele.faqFilterType);
        }
        else
        {
            areElementsHorizontallyAligned(ele.searchField, ele.faqFilterType);
        }

    }

    @Then("^NSI FAQs alphabeticalFilterBtb and mostPopularFilterBtn are aligned$")
    public void nsi_FAQs_alphabeticalFilterBtb_and_mostPopularFilterBtn_are_aligned() throws Throwable
    {

        areElementsHorizontallyAligned(ele.aTozSwitch, ele.mostPopularSwitch);

    }
}
