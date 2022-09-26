package pages.pageUIs;

public class AddProductUI {

    public static final String PRODUCT_NAME = "//body/div[@id='app']/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]";
    public static final String PRODUCT_TYPE = "//input[@placeholder='Chọn danh mục']";
    public static final String INTRODUCTION = "//div[@class='el-form-item is-required']//textarea[@class='el-textarea__inner']";
    public static final String DESCRIPTION = "//div[@class='el-form-item']//textarea[@class='el-textarea__inner']";
    public static final String PRICE = "//body/div[@id='app']/div[1]/div[1]/form[1]/div[6]/div[1]/div[1]/input[1]";
    public static final String SALE = "//div[@class='el-form-item']//input[@type='text']";
    public static final String BTN_SUBMIT = "//button[@class='el-button btn-update el-button--primary']";
    public static final String BTN_RESET = "//button[@class='el-button btn-update el-button--danger']";
    public static final String FILE_UPLOAD = "//input[@id='upload-file']";
    public static final String CHECKBOX = "//span[@class='el-checkbox__input']";

    public static final String DROPDOWN_ITEM1 = "//span[normalize-space()='Electronic Devices']";
    public static final String PRODUCT_NAME_EMPTY = "//div[contains(text(),'Tên sản phẩm là trường bắt buộc')]";
    public static final String PRODUCT_TYPE_EMPTY = "//div[contains(text(),'Danh mục là trường bắt buộc')]";

    public static final String PRODUCT_INTRODUCTION_EMPTY = "//div[contains(text(),'Giới thiệu là trường bắt buộc')]";

    public static final String PRODUCT_NAME_ERROR = "//div[contains(text(),'Tên sản phẩm phải từ 3 - 50 kí tự')]";
    public static final String INTRODUCTION_ERROR = "//div[contains(text(),'Giới thiệu phải từ 10 - 50 kí tự')]";

    public static final String PRICE_ERROR = "//div[contains(text(),'Vui lòng nhập số nguyên')]";
    public static final String ADD_PRODUCT_SUCCESS = "//p[text()='Thêm sản phẩm thành công']";
    public static final String UPLOAD_FILE = "//input[@id='upload-file']";
    public static final String POPUP_UPLOAD = "//div[@aria-label='Sai định dạng file']";
}
