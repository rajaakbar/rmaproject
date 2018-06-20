package nsi.ThirdPartySites;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import cucumber.api.java.en.Given;
import nsi.BaseClass;

public class NSICorporateMediaCentre extends BaseClass
{

    NSICorporateMediaCentreElements ele = new NSICorporateMediaCentreElements();

    @Given("^NSICorporateMediaCentre submit continueToCorporatePages$")
    public void NSICorporateMediaCentre_continueToCorporatePages()
    {
        sleep(750);
        ele.continueToCorporatePagesBtn.click();
    }

    @Given("^NSICorporateMediaCentre submit continueToNSIWebsite$")
    public void NSICorporateMediaCentre_continueToNSIWebsite()
    {
        ele.continueToNSIWebsiteBtn.click();
    }

    @Given("^NSICorporateMediaCentre verify pageTitle \"([^\"]*)\"$")
    public void NSICorporateMediaCentre_continueToNSIWebsite(String pageTitle)
    {
        // ele.pageTitle.shouldBe(text(pageTitle));
        $(By.xpath("//h1[contains(.,'" + pageTitle + "')]")).shouldBe(visible);
    }

    @Given("^NSICorporateMediaCentre submit returnToNSI$")
    public void NSICorporateMediaCentre_returnToNSI()
    {
        ele.returnToNSI.click();
    }

    private static class NSICorporateMediaCentreElements
    {
        SelenideElement continueToCorporatePagesBtn = $(By.xpath("//*[@id='landingMessage']/div/p[1]/a"));

        SelenideElement continueToNSIWebsiteBtn = $(By.xpath("//*[@id='landingMessage']/div/p[3]/a"));

        // SelenideElement pageTitle = $(By.xpath("//h1[contains(.,'Media Centre')]"));

        SelenideElement returnToNSI = $(By.xpath("//a[contains(.,'nsandi.com')]"));
    }
}
