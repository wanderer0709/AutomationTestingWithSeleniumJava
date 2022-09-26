package pages.pageUIs;

public class LoginPageUI {
    //final: ngăn cản giá trị mới
    //static: biến tĩnh, cho phép 1 class khác truy cập đến biến của class này
    //static final: hằng số
    public static final String TXT_EMAIL = "//input[@type='text']";
    public static final String TXT_PASSWORD = "//input[@type='password']";
    public static final String BTN_LOGIN = "//button[@type='button']//following-sibling::span";

    public static final String EMPTY_EMAIL = "//label[text()='Email']//following-sibling::div//div[@class='el-form-item__error']";

    public static final String EMPTY_PASSWORD = "//label[text()='Password']//following-sibling::div//div[@class='el-form-item__error']";

}
