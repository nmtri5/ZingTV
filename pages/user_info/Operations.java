package pages.user_info;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import supports.AndroidCommonFunctions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Operations extends Objects {

    // todo: Test all operations in UserInfo tab

    String video_name = "";

    public Operations(){
        PageFactory.initElements(new AppiumFieldDecorator(AndroidCommonFunctions.getApp()), this);
    }

    public void wait_for_login_successfully (){
        AndroidCommonFunctions.waitForScreenToLoad(AndroidCommonFunctions.getApp(), AndroidCommonFunctions.getElement("id", "img_avatar"), 5);

    }

    public void switchTab (String tab){
        if (tab =="trang chủ") {
            trangchu.click();
//        } else if (tab =="khám phá"){
//            khampha.click();
        } else if (tab =="cá nhân") {
            canhan.click();
        } else if (tab == "thêm") {
            them.click();
        }
    }

    public void login(){

        switchTab("cá nhân");
        if (AndroidCommonFunctions.isExisted("id", "tv_login") == true){
            AndroidCommonFunctions.click("id", "tv_login");
            wait_for_login_successfully();
            AndroidCommonFunctions.backtoHome();
        }
    }

    public void logout(){
        switchTab("thêm");
        if (AndroidCommonFunctions.isExisted("id", "tv_log_out") == true) {
            AndroidCommonFunctions.click("id", "tv_log_out");
        } else {
            AndroidCommonFunctions.scrollAndClick("Đăng xuất");

        }
        AndroidCommonFunctions.backtoHome();
    }

    public void swipeVertical(double startPercentage, double finalPercentage, double anchorPercentage) {

        Dimension size = AndroidCommonFunctions.getApp().manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * finalPercentage);

        new TouchAction(AndroidCommonFunctions.getApp())
                .press(anchor, startPoint)
                .moveTo(-50, -50)
                .release().perform();
    }

    public void Scroll_to_random_video_and_click() throws InterruptedException {

        while (AndroidCommonFunctions.isExisted("id", "tv_title") == false){
            swipeVertical(0.2,0.8,0.5);
        }
        List<AndroidElement> list_video = AndroidCommonFunctions.getElements("id", "tv_title");
        video_name = list_video.get(0).getText();
        list_video.get(0).click();
        if (AndroidCommonFunctions.isExisted("id", "fab_play")){
            AndroidCommonFunctions.click("id","fab_play");
            Thread.sleep(5000);
            AndroidCommonFunctions.backtoHome();
        }
        Thread.sleep(5000);

    }

    public boolean recentlyplayed() {
            login(); //login first
            List<AndroidElement> recently_watched = AndroidCommonFunctions.getElements("id", "tv_program_name"); //get list recently played


        if (recently_watched.get(0).getText().equals(video_name)){
            return true;
        } else {
            return false;
        }

        }
    }

