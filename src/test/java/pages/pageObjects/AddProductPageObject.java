package pages.pageObjects;

import cores.BasePage;
import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.pageUIs.AddProductUI;

public class AddProductPageObject extends BasePage {

    WebDriver driver;

    public AddProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterProductName(String value) {
        sendKeysToElement(driver, AddProductUI.PRODUCT_NAME, value);
    }

    public void chooseProductType(String value) {
        if (value.equals("")) return;
        clickToElement(driver, AddProductUI.PRODUCT_TYPE);
        switch (value) {
            case "Electronic devices":
                clickToElement(driver, AddProductUI.DROPDOWN_ITEM1);
                break;
            default:
                break;
        }
    }

    public void enterIntroduction(String value) {
        sendKeysToElement(driver, AddProductUI.INTRODUCTION, value);
    }

    public void enterDescription(String value) {
        sendKeysToElement(driver, AddProductUI.DESCRIPTION, value);
    }

    public void enterPrice(String value) {
        sendKeysToElement(driver, AddProductUI.PRICE, value);
    }

    public void enterSale(String value) {
        sendKeysToElement(driver, AddProductUI.SALE, value);
    }

    public void enterProductInfo(String productName, String productType,
                                 String introduction, String description,
                                 String popular, String price, String sale) {
        if (introduction.contains("random")) {
            introduction = randomizeString(extractInt(introduction));
        }
        if ( description.contains("random")) {
            description = randomizeString(extractInt(description));
        }
        if (productName.contains("random")) {
            productName = randomizeString(extractInt(productName));
        }
        if (price.contains("random")) {
            price = randomizeString(extractInt(price));
        }
        waitUntilElementVisible(driver, AddProductUI.PRODUCT_TYPE);
        enterProductName(productName);
        chooseProductType(productType);
        enterIntroduction(introduction);
        enterDescription(description);
        enterPrice(price);
        enterSale(sale);
        if (popular.equalsIgnoreCase("true")) clickCheckBox();

        clickAddBt();
    }

    public void clickAddBt() {
        clickToElement(driver, AddProductUI.BTN_SUBMIT);
    }

    public void clickResetBt() {
        clickToElement(driver, AddProductUI.BTN_RESET);
    }

    public void clickCheckBox() {
        clickToElement(driver, AddProductUI.CHECKBOX);
    }

    public void verifyErrorMessageProductName() {
        Assert.assertEquals(isElementDisplayed(driver, AddProductUI.PRODUCT_NAME_EMPTY), true);
    }
    public void verifyErrorMessageProductType() {
        Assert.assertEquals(isElementDisplayed(driver, AddProductUI.PRODUCT_TYPE_EMPTY), true);
    }
    public void verifyErrorMessageIntroduction() {
        Assert.assertEquals(isElementDisplayed(driver, AddProductUI.PRODUCT_INTRODUCTION_EMPTY), true);
    }

    public void verifyErrorMessagePrice() {
        Assert.assertEquals(isElementDisplayed(driver, AddProductUI.PRICE), true);
    }

    public void verifyProductNameAlert() {
        Assert.assertEquals(isElementDisplayed(driver, AddProductUI.PRODUCT_NAME_ERROR), true);
    }

    public void verifyIntroductionAlert() {
        Assert.assertEquals(isElementDisplayed(driver, AddProductUI.INTRODUCTION_ERROR), true);
    }

    public void verifyPriceAlert() {
        Assert.assertEquals(isElementDisplayed(driver, AddProductUI.PRICE_ERROR), true);
    }

    public void verifyAddProductSuccessful() {
        waitUntilElementVisible(driver, AddProductUI.ADD_PRODUCT_SUCCESS);
        Assert.assertEquals(isElementDisplayed(driver, AddProductUI.ADD_PRODUCT_SUCCESS), true);
    }

    public void uploadFile(String filePath) {
        sendKeysToElement(driver, AddProductUI.FILE_UPLOAD, filePath);
    }

    public void verifyFileUploadError() {
        waitUntilElementVisible(driver, AddProductUI.POPUP_UPLOAD);
        Assert.assertEquals(isElementDisplayed(driver, AddProductUI.POPUP_UPLOAD), true);
    }
}
