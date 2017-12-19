package pages.calculator;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import supports.AndroidCommonFunctions;

public class Objects {
    @AndroidFindBy(id = "bt_mul")
    public AndroidElement mulBtn;

    @AndroidFindBy(id = "bt_div")
    public AndroidElement divBtn;

    @AndroidFindBy(id = "bt_add")
    public AndroidElement addBtn;

    @AndroidFindBy(id = "bt_sub")
    public AndroidElement subBtn;

    @AndroidFindBy(id = "bt_equal")
    public AndroidElement equalBtn;

    @AndroidFindBy(id = "bt_backspace")
    public AndroidElement bckBtn;

    @AndroidFindBy(id = "txtCalc")
    public AndroidElement resultLbl;


    public AndroidElement numBtn(String num){
        //return (AndroidElement) AndroidCommonFunctions.getApp().findElements(MobileBy.xpath(String.format(".//*[@text='%s']", num)));

        return AndroidCommonFunctions.getElement("button", num);
    }
}
