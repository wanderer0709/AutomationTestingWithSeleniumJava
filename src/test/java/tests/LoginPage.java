package tests;

import cores.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.pageObjects.HomePageObject;
import pages.pageObjects.LoginPageObject;
import pages.pageUIs.LoginPageUI;
import utils.ExcelUtil;

import java.io.IOException;
import java.lang.reflect.Method;

public class LoginPage extends BaseTest {

    LoginPageObject objLogin;
    HomePageObject objHome;
    String path = System.getProperty("user.dir");

    @Parameters("url1")
    @BeforeMethod
    public void setup(String url) {
        driver.get(url);
        objLogin = new LoginPageObject(driver);
        objHome = new HomePageObject(driver);
    }
    @DataProvider
    public Object[][] dataLogin(Method m) throws IOException {
        String filePath = path + "\\src\\test\\java\\resources\\testdata.xlsx";
        String sheetName = "Login";
        String[][] testObject = ExcelUtil.readExcel(filePath, sheetName);
        Object[][] testRow = new Object[1][1];
        int j = 0;
        for(int i = 1; i <= testObject.length; i++, j++) {
            if (m.getName().equalsIgnoreCase("TC_0" + i)) {
                testRow[0] = testObject[j];
            }
        }
        return testRow;
    }

    @Test(dataProvider = "dataLogin")
    public void TC_01(String userName, String password) throws InterruptedException {
        objLogin.signIn(userName, password);
        objHome.verifyAddNewProductDisplayed();
    }

    @Test(dataProvider = "dataLogin")
    public void TC_02(String userName, String password) {
        objLogin.signIn(userName, password);
        objLogin.waitUntilElementVisible(driver, LoginPageUI.EMPTY_EMAIL);
        objLogin.verifyErrorMessage(LoginPageUI.EMPTY_EMAIL);
        objLogin.verifyErrorMessage(LoginPageUI.EMPTY_PASSWORD);
    }
}
