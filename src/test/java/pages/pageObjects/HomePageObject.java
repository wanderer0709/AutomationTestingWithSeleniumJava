package pages.pageObjects;

import cores.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyAddNewProductDisplayed() throws InterruptedException {
        waitUntilElementVisible(driver, HomePageUI.ADD_NEW_PROD_LINK);
        Assert.assertEquals(isElementDisplayed(driver, HomePageUI.ADD_NEW_PROD_LINK), true);
    }

    public void clickOnAddProduct() {
        waitUntilElementVisible(driver, HomePageUI.ADD_NEW_PROD_LINK);
        clickToElement(driver, HomePageUI.ADD_NEW_PROD_LINK);
    }
}
