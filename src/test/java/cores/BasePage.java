package cores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebElement getElementByXpath(WebDriver driver, String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public void sendKeysToElement(WebDriver driver, String locator, String value) {
        getElementByXpath(driver, locator).sendKeys(value);
    }

    public String getTextfromElement(WebDriver driver, String locator) {
        return getElementByXpath(driver, locator).getText();
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElementByXpath(driver, locator).click();
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getElementByXpath(driver, locator).isDisplayed();
    }

    public void waitUntilElementVisible(WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public String randomizeString(int size) {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(size);
        System.out.println(AlphaNumericString);

        for (int i = 0; i < size; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public int extractInt(String str) throws NumberFormatException
    {
        // Replacing every non-digit number
        // with a space(" ")
        String str1 = str.replaceAll("[^0-9]", " "); // regular expression

        // Replace all the consecutive white
        // spaces with a single space
        str1 = str1.replaceAll(" +", "");
//        System.out.println("Number:" + str1);
        if (str1.equals(""))
            return -1;

        return Integer.parseInt(str1);
    }

}
