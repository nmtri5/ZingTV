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
        search.backtoHome();
    }

    @Test
    public void searchFail() { //Testcase ID ZTTQTC_6
        Operations search = new Operations();
        search.searchNotExist("ahjhjhj");
        search.backtoHome();
    }

    @Test
    public void searchSpecialChar(){ //Testcase ID ZTTQTC_7
        Operations search = new Operations();
        search.searchNotExist("@$%#@^%$&@");
        search.backtoHome();
    }

    @Test
    public void searchSuggestion(){ //Testcase ID ZTTQTC_12
        String keyword = "Hau";
        keyword = keyword.toLowerCase();
        Operations search = new Operations();
        search.perform_search_action(keyword);

        search.switchTab("nổi bật tab");
        Assert.assertTrue(search.verify_content_suggestion(keyword));

        search.switchTab("chương trình tab");
        Assert.assertTrue(search.verify_content_suggestion(keyword));

        search.switchTab("video tab");
        Assert.assertTrue(search.verify_content_suggestion(keyword));

        search.switchTab("nghệ sĩ");
        Assert.assertTrue(search.verify_content_suggestion(keyword));
        search.backtoHome();
    }

    @Test
    public void swipe() throws InterruptedException {
        Operations content = new Operations();
        content.swipeVertical(0.2,0.8,0.5);
        Thread.sleep(2000);
        content.swipeVertical(0.2,0.8,0.5);
        Thread.sleep(2000);
        content.swipeVertical(0.2,0.8,0.5);
        Thread.sleep(2000);
        content.swipeVertical(0.2,0.8,0.5);
        Thread.sleep(2000);
        content.swipeVertical(0.2,0.8,0.5);
        Thread.sleep(2000);
        content.swipeVertical(0.2,0.8,0.5);
        Thread.sleep(2000);
        content.swipeVertical(0.2,0.8,0.5);
        Thread.sleep(2000);
        content.swipeVertical(0.2,0.8,0.5);
        Thread.sleep(2000);
        content.swipeVertical(0.2,0.8,0.5);
        

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