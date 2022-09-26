package pages.pageObjects;

import cores.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {

    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmailTxt(String value) {
        sendKeysToElement(driver, LoginPageUI.TXT_EMAIL, value);
    }

    public void enterPasswordTxt(String value) {
        sendKeysToElement(driver, LoginPageUI.TXT_PASSWORD, value);
    }

    public void clickLoginBtn() {
        clickToElement(driver, LoginPageUI.BTN_LOGIN);
    }

    public void signIn(String email, String password) {
        enterEmailTxt(email);
        enterPasswordTxt(password);
        clickLoginBtn();
    }

    public void verifyErrorMessage(String locator) {
        Assert.assertEquals(isElementDisplayed(driver, locator), true);
    }
}
