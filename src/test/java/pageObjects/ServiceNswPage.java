package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ServiceNswPage {

    public WebDriver driver;
    By searchTask = By.xpath("//*[@id=\"edit-contains\"]");
    By searchButton = By.id("edit-submit-site-search");
    By locateUsLink = By.linkText("Locate us");

    /**
     * Constructor to initialise the driver
     * @param driver
     */
    public ServiceNswPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Function to search for "Apply for a number plate"
     * @param task
     */
    public void setSearchTask(String task) {
        driver.findElement(searchTask).sendKeys(task, Keys.TAB);
    }

    /**
     * Function to click on Search Button
     */
    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    /**
     * Function to click on locate us
     */
    public void clickLocateUs() {
        driver.findElement(locateUsLink).click();
    }

}
