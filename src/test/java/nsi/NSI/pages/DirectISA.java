package nsi.NSI.pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import cucumber.api.java.en.Then;
import nsi.BaseClass;

public class DirectISA extends BaseClass
{

    @Then("^DirectISA confirm tabs are displayed$")
    public void directisa_confirm_tabs_are_displayed() throws Throwable
    {
        ele.tabs_all.isDisplayed();
        ele.tabs_faq.isDisplayed();
        ele.tabs_forms.isDisplayed();
        ele.tabs_literature.isDisplayed();
        ele.tabs_videos.isDisplayed();
    }

    DirectISAElements ele = new DirectISAElements();

    private static class DirectISAElements
    {

        SelenideElement tabs_all = $(By.id("all"));

        SelenideElement tabs_forms = $(By.id("forms"));

        SelenideElement tabs_literature = $(By.id("lit"));

        SelenideElement tabs_videos = $(By.id("vid"));

        SelenideElement tabs_faq = $(By.id("faq"));

    }
}
