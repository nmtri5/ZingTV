package pages.user_info;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.support.PageFactory;
import supports.AndroidCommonFunctions;

public class Operations extends Objects {

    // todo: input search text,
    public Operations(){
        PageFactory.initElements(new AppiumFieldDecorator(AndroidCommonFunctions.getApp()), this);
    }

    public void wait_for_login_successfully (){
        AndroidCommonFunctions.waitForScreenToLoad(AndroidCommonFunctions.getApp(), AndroidCommonFunctions.getElement("id", "tv_login"), 5);

    }

    public void switchTab (String tab){
        if (tab =="chương trình") {
            trangchu.click();
        } else if (tab =="video"){
            khampha.click();
        } else if (tab =="nổi bật tab") {
            canhan.click();
        } else if (tab == "chương trình tab") {
            them.click();
        }
    }

    public void login(){
        boolean isLogin = false;

        if (AndroidCommonFunctions.isExisted("id", "tv_login") == true){
            AndroidCommonFunctions.click("id", "tv_login");
            wait_for_login_successfully();
            isLogin = true;
        } else {
            isLogin = true;

        }

    }
}
