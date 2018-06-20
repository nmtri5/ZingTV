package packages;

import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homepage.Operations;
import pages.user_info.Objects;
import supports.AndroidCommonFunctions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class TestSuit {


    @BeforeClass
    public void setUp() throws IOException {

        AndroidCommonFunctions.launchApp("zingtv");

    }

    @Test
    public void searchSuccess() { //Testcase ID ZTTQTC_5
        Operations search = new Operations();
        String keyword = "hau due cua than linh";
        search.deAccent(keyword);
        search.perform_search_action(keyword);
        List<AndroidElement> list_search = AndroidCommonFunctions.getElements("id", "tv_title");

        search.switchSearchTab("nổi bật tab");
        String search_item = list_search.get(0).getText();
        search_item = search.deAccent(search_item);
        System.out.println(search_item);
        Assert.assertTrue(search_item.contains(keyword));

        search.switchSearchTab("chương trình tab");
        String search_item1 = list_search.get(0).getText();
        search_item1 = search.deAccent(search_item1);
        System.out.println(search_item1);
        Assert.assertTrue(search_item1.contains(keyword));

        search.switchSearchTab("video tab");
        String search_item2 = list_search.get(0).getText();
        search_item2 = search.deAccent(search_item2);
        System.out.println(search_item2);
        Assert.assertTrue(search_item2.contains(keyword));

        AndroidCommonFunctions.backtoHome();
    }

    @Test
    public void searchFail() { //Testcase ID ZTTQTC_6
        Operations search = new Operations();
        String keyword = "ghasdfwdsfx";
        search.deAccent(keyword);
        search.perform_search_action(keyword);

        search.switchSearchTab("nổi bật tab");
        AndroidCommonFunctions.isExisted("id", "tv_error");

        search.switchSearchTab("chương trình tab");
        AndroidCommonFunctions.isExisted("id", "tv_error");

        search.switchSearchTab("video tab");
        AndroidCommonFunctions.isExisted("id", "tv_error");

        search.switchSearchTab("nghệ sĩ tab");
        AndroidCommonFunctions.isExisted("id", "tv_error");

        AndroidCommonFunctions.backtoHome();
    }

    @Test
    public void searchSpecialChar(){ //Testcase ID ZTTQTC_7
        Operations search = new Operations();
        String keyword = "$%^$^$(";
        search.deAccent(keyword);
        search.perform_search_action(keyword);

        search.switchSearchTab("nổi bật tab");
        AndroidCommonFunctions.isExisted("id", "tv_error");

        search.switchSearchTab("chương trình tab");
        AndroidCommonFunctions.isExisted("id", "tv_error");

        search.switchSearchTab("video tab");
        AndroidCommonFunctions.isExisted("id", "tv_error");

        search.switchSearchTab("nghệ sĩ tab");
        AndroidCommonFunctions.isExisted("id", "tv_error");

        AndroidCommonFunctions.backtoHome();
    }

    @Test
    public void verify_content_homepage() {
        Operations content = new Operations();
        content.verify_content_homepage();
    }

    @Test
    public void verify_recently_played_list() throws InterruptedException {
        pages.user_info.Operations recently_played = new pages.user_info.Operations();
        recently_played.Scroll_to_random_video_and_click(); //Watch a random video to record history
        AndroidCommonFunctions.backtoHome(); //Back to home page
        recently_played.switchTab("cá nhân"); // Change to User info tab
        Assert.assertTrue(recently_played.recentlyplayed()); //Verify if the recently watched video is appeared in the list
    }

    @Test
    public void verify_edit_recently_played_list(){
        pages.user_info.Operations edit_recently_played = new pages.user_info.Operations();
        edit_recently_played.switchTab("cá nhân");

    }


//    public String add(String a, String b) {
//        String[] firstNumber = a.split("");
//        for (String index : firstNumber) {
//            AndroidCommonFunctions.click("button", index);
//        }
//        AndroidCommonFunctions.click("id", "op_add");
//        //input second number
//        String[] secondNumber = b.split("");
//        for (String index : secondNumber) {
//            AndroidCommonFunctions.click("button", index);
//        }
//
//        AndroidCommonFunctions.click("id", "eq");
//
//        return AndroidCommonFunctions.getText("id", "result");
//
//    }


    @AfterMethod
    public void tearDown() {
        AndroidCommonFunctions.getApp();

    }
}