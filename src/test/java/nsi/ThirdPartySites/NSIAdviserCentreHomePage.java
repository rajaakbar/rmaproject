package nsi.ThirdPartySites;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import cucumber.api.java.en.Given;
import nsi.BaseClass;

public class NSIAdviserCentreHomePage extends BaseClass
{

    NSIAdviserHomePageElements ele = new NSIAdviserHomePageElements();

    @Given("^NSIAdviserCentreHomePage submit continueToAdviserCentre$")
    public void NSIAdviserCentreHomePage_submit_continueToAdviserCentre()
    {
        ele.continueToAdviserCentre.click();
    }

    @Given("^NSIAdviserCentreHomePage submit continueToNSIWebSite$")
    public void NSIAdviserCentreHomePage_submit_continueToNSIWebSite()
    {
        ele.continueToNSIWebSite.click();
    }

    @Given("^NSIAdviserCentreHomePage submit returnToMainNSIWebSite$")
    public void NSIAdviserCentreHomePage_submit_returnToMainNSIWebSite()
    {
        ele.returnToMainNSIWebSite.scrollTo();
        ele.returnToMainNSIWebSite.click();
    }

    private static class NSIAdviserHomePageElements
    {
        SelenideElement continueToAdviserCentre = $(By.xpath("//a[contains(.,'Continue toAdviser Centre')]"));

        SelenideElement continueToNSIWebSite = $(By.xpath("//a[contains(.,'Continue to mainNS&I website')]"));

        SelenideElement returnToMainNSIWebSite = $(By.xpath("//a[contains(.,'NS&I main website')]"));
    }
}
