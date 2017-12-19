package pages.calculator;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import supports.AndroidCommonFunctions;

import java.util.List;

public class Operations extends Objects{

    // todo: mul, minus, div, del, plus, validate
    public Operations(){
        PageFactory.initElements(new AppiumFieldDecorator(AndroidCommonFunctions.getApp()), this);
    }

    public void mul(int a, int b){
        inputNumber(Integer.toString(a));
        mulBtn.click();
        inputNumber(Integer.toString(b));
        equalBtn.click();

    }

    public void minus(int a, int b){
        inputNumber(Integer.toString(a));
        subBtn.click();
        inputNumber(Integer.toString(b));
        equalBtn.click();
    }


    public void div(int a, int b){
        inputNumber(Integer.toString(a));
        divBtn.click();
        inputNumber(Integer.toString(b));
        equalBtn.click();
    }


    public void plus(int a, int b){
        inputNumber(Integer.toString(a));
        addBtn.click();
        inputNumber(Integer.toString(b));
        equalBtn.click();
    }

    public void del(){

    }

    public boolean validate(int expected){
        return true;
    }

    public void inputNumber(String a){
        String [] firstnumber = a.split("");
        for (String index: firstnumber)
        {
            AndroidCommonFunctions.click("button", index);
        }
    }
}
