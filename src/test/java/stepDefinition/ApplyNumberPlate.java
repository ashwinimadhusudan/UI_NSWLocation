package stepDefinition;

import pageObjects.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class ApplyNumberPlate {

    private static WebDriver driver;
    private ServiceNswPage sn;
    private FindServiceLocationPage fsln;

    public ApplyNumberPlate() {
        driver = Hooks.driver;
    }

    @Given("^I navigate to the (.*)$")
    public void iNavigateToThe(String url) {
        driver.get(url);
        Assert.assertTrue("Home | Service NSW".equalsIgnoreCase(driver.getTitle()));
        sn = new ServiceNswPage(driver);
    }

    @When("^I search for (.+?)$")
    public void iSearchFor(String searchTask) {
        sn.setSearchTask(searchTask);
        sn.clickSearchButton();
    }

    @When("^I am in the searched page$")
    public void iAmOnTheSearchedPage() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue("Search Results | Service NSW".equalsIgnoreCase(driver.getTitle()));
    }

    @When("^I click on locate us Button$")
    public void iClickOnLocateUsButton() {
        sn.clickLocateUs();
    }

    @When("^I land on Find a Service NSW Location Page$")
    public void iLandOnFindAServiceNSWLocationPage() {
        fsln = new FindServiceLocationPage(driver);
        Assert.assertTrue("Find a Service NSW location | Service NSW".equalsIgnoreCase(driver.getTitle()));
    }

    @When("^I enter the suburb as (.+?)$")
    public void iEnterTheSuburbAs(String sub) {
        fsln.enterSuburbToSearch(sub);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("^I should see the Available service center as (.+?)$")
    public void seeAvailableServiceCenter(String location) {
        Assert.assertTrue(fsln.verifyServiceLocation(location));
    }
}
