package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FindServiceLocationPage {

    public WebDriver driver;
    By searchSuburb = By.id("locatorTextSearch");

    /**
     * Constructor to initialise the driver
     * @param driver
     */
    public FindServiceLocationPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Function to enter the Suburb
     * @param sub
     */
    public void enterSuburbToSearch(String sub) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchSuburb));
        driver.findElement(searchSuburb).sendKeys(sub, Keys.TAB);
        driver.findElement(searchSuburb).sendKeys(Keys.ENTER);
    }

    /**
     * Function to verify the location retrieved
     * @param serviceLocation
     * @return
     */
    public boolean verifyServiceLocation(String serviceLocation) {
        List<WebElement> locations = driver.findElements(By.xpath(("//*[@id=\"locatorListView\"]/div/div/div/div")));
        for (int i = 1; i <= locations.size(); i++) {
            String href = driver.findElement(By.xpath("//*[@id=\"locatorListView\"]/div/div/div/div[" + i + "]/a")).getText();
            if (serviceLocation.equalsIgnoreCase(href))
                return true;
        }
        return false;
    }
}
