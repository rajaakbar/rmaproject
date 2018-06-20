package nsi.NSI.pages;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nsi.BaseClass;

public class Resources extends BaseClass
{

    ResourcesElements ele = new ResourcesElements();

    @Given("^NSI Resources verify Useful Information section visible$")
    public void nsi_Resources_verify_Useful_Information_section_visible() throws Throwable
    {
        ele.usefulInformationDiv.isDisplayed();
        ele.usefulInformationDiv.getText().contains("Useful infomation");
    }

    @When("^NSI Resources submit \"([^\"]*)\" display option$")
    public void nsi_resources_submit_display_option(String option) throws Throwable
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

    @When("^NSI Resources submit \"([^\"]*)\" display tab$")
    public void nsi_resources_submit_display_tab(String tab) throws Throwable
    {
        switch (tab.toLowerCase())
        {
        case "all":
            ele.allTab.click();
            break;
        case "forms":
            ele.formTab.click();
            break;
        case "literature":
            ele.litTab.click();
            break;
        default:
            assertThat("***** could not find " + tab + "element to be able to click", false);
            break;
        }
    }

    @Then("^NSI Resources verify \"([^\"]*)\" of items are displayed$")
    public void nsi_resources_verify_of_items_are_displayed(int correctNoOfRows) throws Throwable
    {
        switch (correctNoOfRows)
        {
        case 4:
            $(By.xpath("//ul[@class='resource-list']")).isDisplayed();
            break;
        case 8:
            $(By.xpath("//ul[@class='resource-list views-row-first views-row-odd']")).isDisplayed();
            $(By.xpath("//ul[@class='resource-list views-row-last views-row-even']")).isDisplayed();
            break;
        default:
            assertThat("***** could not find elements collection for" + correctNoOfRows + "element to be able to click",
                    false);
            break;
        }
    }

    @Given("^NSI Resources submit search text \"([^\"]*)\"$")
    public void nsi_Resources_submit_search_text(String text) throws Throwable
    {
        ele.searchField.setValue(text);
    }

    @Given("^NSI Resources select \"([^\"]*)\" from search drop down$")
    public void nsi_Resources_select_from_search_drop_down(String text) throws Throwable
    {
        ele.dropDown.selectOption(text);
        ele.searchField.click();
    }

    private static class ResourcesElements
    {
        SelenideElement usefulInformationDiv = $(By.id("useful-info"));

        SelenideElement allTab = $(By.id("all"));

        SelenideElement formTab = $(By.id("forms"));

        SelenideElement litTab = $(By.id("lit"));

        SelenideElement mostPopularSwitch = $(By.id("resources-most-popular-switch"));

        SelenideElement aTozSwitch = $(By.id("resources-a-z-switch"));

        SelenideElement dropDown = $(By.id("edit-field-asset-type-tid"));

        SelenideElement searchField = $(By.id("edit-title"));
    }
}
