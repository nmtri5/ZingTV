package pages.user_info;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.support.PageFactory;
import supports.AndroidCommonFunctions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Operations extends Objects {

    // todo: input search text,
    boolean isLogin = false;

    public Operations(){
        PageFactory.initElements(new AppiumFieldDecorator(AndroidCommonFunctions.getApp()), this);
    }

    public void wait_for_login_successfully (){
        AndroidCommonFunctions.waitForScreenToLoad(AndroidCommonFunctions.getApp(), AndroidCommonFunctions.getElement("id", "tv_login"), 5);

    }

    public void switchTab (String tab){
        if (tab =="trang chủ") {
            trangchu.click();
        } else if (tab =="khám phá"){
            khampha.click();
        } else if (tab =="cá nhân") {
            canhan.click();
        } else if (tab == "thêm") {
            them.click();
        }
    }

    public void login(){

        if (AndroidCommonFunctions.isExisted("id", "tv_login") == true){
            AndroidCommonFunctions.click("id", "tv_login");
            wait_for_login_successfully();
            isLogin = true;
        } else if (AndroidCommonFunctions.isExisted("id", "img_avatar") == true){
            isLogin = true;

        }

    }

    public void recentlyplayed(String name) {
        if (isLogin == false){
            login();
        } else {
            List<AndroidElement> recently_watched = AndroidCommonFunctions.getElements("id", "tv_program_name");
            for (AndroidElement items : recently_watched)
            {

            }
        }
    }
}
