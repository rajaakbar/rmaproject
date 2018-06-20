package nsi.NSI.pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nsi.BaseClass;

public class Footer extends BaseClass
{

    FooterElements ele = new FooterElements();

    private static class FooterElements
    {

        // SelenideElement footer = $(By.xpath("//footer[@class='footer']"));

        // SelenideElement newsUpdateContainer = $(By.xpath("//div[@class='sub-form-container clear']"));

        SelenideElement newsUpdateLeftColour = $(By.xpath("//div[@class='column-1-3 sg-column form-info']"));

        SelenideElement newsUpdateForenameError = $(By.xpath("//span[@for='edit-forename']"));

        SelenideElement newsUpdateSurnameError = $(By.xpath("//span[@for='edit-surname']"));

        SelenideElement newsUpdateEmailError = $(By.xpath("//span[@for='edit-email']"));

        SelenideElement newsUpdateSubscribeBtn = $(By.id("test_sub"));

        SelenideElement newsUpdateForename = $(By.id("edit-forename"));

        SelenideElement newsUpdateSurname = $(By.id("edit-surname"));

        SelenideElement newsUpdateCompany = $(By.id("edit-company"));

        SelenideElement newsUpdateEmail = $(By.id("edit-email"));

        SelenideElement newsUpdateJobtitle = $(By.id("edit-job-title"));

    }

    @When("^NSI Footer NewsUpdates submit subscribe button$")
    public void nsi_Footer_NewsUpdates_submit_subscribe_button() throws Throwable
    {
        ele.newsUpdateSubscribeBtn.click();
    }

    @Then("^NSI Footer NewsUpdates error messages displayed as \"([^\"]*)\"$")
    public void nsi_Footer_NewsUpdates_error_messages_displayed_as(String text) throws Throwable
    {
        ele.newsUpdateForenameError.getText().contains(text);
        ele.newsUpdateSurnameError.getText().contains(text);
        ele.newsUpdateEmailError.getText().contains(text);
    }

    @When("^NSI Footer NewsUpdates colour check$")
    public void nsi_Footer_NewsUpdates_colour_check() throws Throwable
    {
        isElementBackgroundColour(ele.newsUpdateLeftColour, "#444444");
    }

    @When("^NSI Footer NewsUpdates alignment check$")
    public void nsi_Footer_NewsUpdates_alignment_check() throws Throwable
    {
        mobile = isItMobileOrDesktopBrowser();
        if (mobile)
        {
            areElementsVerticallyAligned(ele.newsUpdateForename, ele.newsUpdateSurname);
            areElementsVerticallyAligned(ele.newsUpdateCompany, ele.newsUpdateJobtitle);
            areElementsVerticallyAligned(ele.newsUpdateForename, ele.newsUpdateCompany);
            areElementsVerticallyAligned(ele.newsUpdateEmail, ele.newsUpdateCompany);
            areElementsVerticallyAligned(ele.newsUpdateSurname, ele.newsUpdateJobtitle);
        }
        else
        {
            areElementsHorizontallyAligned(ele.newsUpdateForename, ele.newsUpdateSurname);
            areElementsHorizontallyAligned(ele.newsUpdateCompany, ele.newsUpdateJobtitle);
            areElementsVerticallyAligned(ele.newsUpdateForename, ele.newsUpdateCompany);
            areElementsVerticallyAligned(ele.newsUpdateEmail, ele.newsUpdateCompany);
            areElementsVerticallyAligned(ele.newsUpdateSurname, ele.newsUpdateJobtitle);
        }

    }
}
