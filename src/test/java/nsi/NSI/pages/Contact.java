package nsi.NSI.pages;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import nsi.BaseClass;

public class Contact extends BaseClass
{
    @Given("^NSI Contact verify background colour of element \"([^\"]*)\" is \"([^\"]*)\"$")
    public void nsi_Contact_verify_background_colour_of_element_is(String element, String colour) throws Throwable
    {
        switch (element.toLowerCase())
        {
        case "email us":
            isElementFontColour(ele.emailUsBlock, "#" + colour);
            break;
        case "call us":
            isElementFontColour(ele.callUsBlock, "#" + colour);
            break;
        case "tweet us":
            isElementFontColour(ele.tweetUsBlock, "#" + colour);
            break;
        case "write to us":
            isElementFontColour(ele.writeToUsBlock, "#" + colour);
            break;
        default:
            assertThat("***** could not find " + element + "element with " + colour + "colour to be able to check",
                    false);
            break;
        }
    }

    @Then("^NSI Contact elements are aligned$")
    public void nsi_Contact_elements_are_aligned() throws Throwable
    {
        mobile = isItMobileOrDesktopBrowser();
        if (mobile)
        {
            areElementsVerticallyAligned(ele.emailUsBlock, ele.callUsBlock);
            areElementsVerticallyAligned(ele.tweetUsBlock, ele.writeToUsBlock);
            areElementsVerticallyAligned(ele.emailUsBlock, ele.tweetUsBlock);
            areElementsVerticallyAligned(ele.callUsBlock, ele.writeToUsBlock);
        }
        else
        {
            areElementsHorizontallyAligned(ele.emailUsBlock, ele.callUsBlock);
            areElementsHorizontallyAligned(ele.tweetUsBlock, ele.writeToUsBlock);
            areElementsVerticallyAligned(ele.emailUsBlock, ele.tweetUsBlock);
            areElementsVerticallyAligned(ele.callUsBlock, ele.writeToUsBlock);
        }

    }

    ContactElements ele = new ContactElements();

    private static class ContactElements
    {
        SelenideElement emailUsBlock = $(By.xpath("//li[@class='cta-help cta--duckegg']/h3"));

        SelenideElement callUsBlock = $(By.xpath("//li[@class='cta-help cta--yellow']/h3"));

        SelenideElement tweetUsBlock = $(By.xpath("//li[@class='cta-help cta--skyblue']/h3"));

        SelenideElement writeToUsBlock = $(By.xpath("//li[@class='cta-help cta--pink']/h3"));

        // SelenideElement topFaqsList = $(By.xpath("//ul[@class='menu list-articles']"));

        // SelenideElement relationshipsTeamBlock = $(By.xpath("//section[@class='container advisor-profiles']"));
    }
}
