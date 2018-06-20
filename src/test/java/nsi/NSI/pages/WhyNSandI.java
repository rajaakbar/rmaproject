package nsi.NSI.pages;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import cucumber.api.java.en.Given;
import nsi.BaseClass;
import nsi.Log;

public class WhyNSandI extends BaseClass
{

    WhyNSandIElements ele = new WhyNSandIElements();

    @Given("^WhyNSandI clicking find out more for \"([^\"]*)\"$")
    public void whynsandi_clicking_find_out_more_for(String FindOutMore) throws Throwable
    {
        switch (FindOutMore)
        {
        case "OurRole":
            ele.FindOutMoreOurRoleClientsPortfolio.scrollTo();
            ele.FindOutMoreOurRoleClientsPortfolio.click();
            break;
        case "Heritage":
            ele.FindOutMoreHeritage.scrollTo();
            ele.FindOutMoreHeritage.click();
            break;
        case "OurService":
            ele.FindOutMoreOurService.scrollTo();
            ele.FindOutMoreOurService.click();
            break;
        case "OurCustomers":
            ele.FindOutMoreOurCustomers.scrollTo();
            ele.FindOutMoreOurCustomers.click();
            break;
        case "Partnership":
            ele.FindOutMorePartnerships.scrollTo();
            ele.FindOutMorePartnerships.click();
            break;
        default:
            Log.info("ERROR - find out more links not working");
            break;
        }
    }

    private static class WhyNSandIElements
    {
        SelenideElement FindOutMoreOurRoleClientsPortfolio = $(By.xpath("//a[@href='/our-role-clients-portfolio']"));

        SelenideElement FindOutMoreHeritage = $(By.xpath("//a[@href='/heritage']"));

        SelenideElement FindOutMoreOurService = $(By.xpath("//a[@href='/our-services']"));

        SelenideElement FindOutMoreOurCustomers = $(By.xpath("//a[@href='/our-customers']"));

        SelenideElement FindOutMorePartnerships = $(By.xpath("//a[@href='/partnerships']"));
    }
}
