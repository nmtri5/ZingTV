package packages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.homepage.Operations;
import supports.AndroidCommonFunctions;

import java.io.IOException;
import java.net.MalformedURLException;

public class TestSuit {


    @BeforeClass
    public void setUp() throws IOException {

        AndroidCommonFunctions.launchApp("zingtv");

    }

    @Test
    public void searchSuccess() { //Testcase ID ZTTQTC_5
        Operations search = new Operations();
        search.searchExist("hau due mat troi");
        AndroidCommonFunctions.backtoHome();
    }

    @Test
    public void searchFail() { //Testcase ID ZTTQTC_6
        Operations search = new Operations();
        search.searchNotExist("ahjhjhj");
        AndroidCommonFunctions.backtoHome();
    }

    @Test
    public void searchSpecialChar(){ //Testcase ID ZTTQTC_7
        Operations search = new Operations();
        search.searchNotExist("@$%#@^%$&@");
        AndroidCommonFunctions.backtoHome();
    }

    @Test
    public void searchSuggestion(){ //Testcase ID ZTTQTC_12
        String keyword = "Hau";
        keyword = keyword.toLowerCase();
        Operations search = new Operations();
        search.perform_search_action(keyword);

        search.switchSearchTab("nổi bật tab");
        Assert.assertTrue(search.verify_content_suggestion(keyword));

        search.switchSearchTab("chương trình tab");
        Assert.assertTrue(search.verify_content_suggestion(keyword));

        search.switchSearchTab("video tab");
        Assert.assertTrue(search.verify_content_suggestion(keyword));

        search.switchSearchTab("nghệ sĩ tab");
        Assert.assertTrue(search.verify_content_suggestion(keyword));
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
    public void testFunction(){
        pages.user_info.Operations test = new pages.user_info.Operations();
        System.out.println(AndroidCommonFunctions.getElement("text","Trang chủ").getAttribute("selected").toString());

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