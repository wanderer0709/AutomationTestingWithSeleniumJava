package tests;

import cores.BaseTest;
import org.testng.annotations.*;
import pages.pageObjects.AddProductPageObject;
import utils.ExcelUtil;

import java.io.IOException;
import java.lang.reflect.Method;

public class AddProductPage extends BaseTest {

    AddProductPageObject objAdd;

    String path = System.getProperty("user.dir");

    @Parameters("url2")
    @BeforeMethod
    public void setup(String url) {
        driver.get(url);
        objAdd = new AddProductPageObject(driver);
    }


    @DataProvider
    public Object[][] dataProduct(Method m) throws IOException {
        String filePath = path + "\\src\\test\\java\\resources\\testdata.xlsx";
        String sheetName = "Add Product";
        Object[][] testObject = ExcelUtil.readExcel(filePath, sheetName);
        Object[][] testRow = new Object[1][1];
        int j = 0;
        for(int i = 1; i <= testObject.length; i++, j++) {
            if (m.getName().equalsIgnoreCase("TC_0" + i)) {
                testRow[0] = testObject[j];
            }
        }
        return testRow;
    }

    @Test(dataProvider = "dataProduct")
    public void TC_01(String productName, String productType, String introduction,
                    String description,String popular, String price, String sale) throws InterruptedException {

        objAdd.enterProductInfo(productName, productType,
                introduction, description, popular, price, sale);
        objAdd.verifyErrorMessageProductName();
    }

    @Test(dataProvider = "dataProduct")
    public void TC_02(String productName, String productType, String introduction,
                    String description,String popular, String price, String sale) throws InterruptedException {
        objAdd.enterProductInfo(productName, productType, introduction,
                description, popular, price, sale);
        objAdd.verifyErrorMessageProductType();

    }

    @Test(dataProvider = "dataProduct")
    public void TC_03(String productName, String productType, String introduction,
                    String description, String popular, String price, String sale) throws InterruptedException {
        objAdd.enterProductInfo(productName, productType, introduction,
                description, popular, price, sale);
        objAdd.verifyErrorMessageIntroduction();

    }

    @Test(dataProvider = "dataProduct")
    public void TC_04(String productName, String productType, String introduction,
                    String description, String popular, String price, String sale) throws InterruptedException {
        objAdd.enterProductInfo(productName, productType, introduction,
                description, popular, price, sale);
        objAdd.verifyErrorMessagePrice();

    }

    @Test(dataProvider = "dataProduct")
    public void TC_05(String productName, String productType, String introduction,
                    String description, String popular, String price, String sale) throws InterruptedException {
        objAdd.enterProductInfo(productName, productType, introduction,
                description, popular, price, sale);
//        Thread.sleep(1000);
        objAdd.verifyProductNameAlert();
    }

    @Test(dataProvider = "dataProduct")
    public void TC_06(String productName, String productType, String introduction,
                      String description, String popular, String price, String sale) throws InterruptedException {
        objAdd.enterProductInfo(productName, productType, introduction,
                description, popular, price, sale);
//        Thread.sleep(1000);
        objAdd.verifyIntroductionAlert();
    }

    @Test(dataProvider = "dataProduct")
    public void TC_07(String productName, String productType, String introduction,
                      String description, String popular, String price, String sale) throws InterruptedException {
        objAdd.enterProductInfo(productName, productType, introduction,
                description, popular, price, sale);
//        Thread.sleep(1000);
        objAdd.verifyPriceAlert();
    }

    @Test(dataProvider = "dataProduct")
    public void TC_08(String productName, String productType, String introduction,
                      String description, String popular, String price, String sale) throws InterruptedException {
        objAdd.enterProductInfo(productName, productType, introduction,
                description, popular, price, sale);
//        Thread.sleep(1000);
        objAdd.verifyAddProductSuccessful();
    }

    @Test()
    public void TC_09() {
        String filePath = path + "\\src\\test\\java\\resources\\edwards-the-new-drawing-on-the-right-side-of-the-brain-viny.pdf";
        objAdd.uploadFile(filePath);
        objAdd.verifyFileUploadError();
    }


}
