package pages.homepage;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import supports.AndroidCommonFunctions;

import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;

public class Operations extends Objects {

        // todo: input search text,
        public Operations(){
            PageFactory.initElements(new AppiumFieldDecorator(AndroidCommonFunctions.getApp()), this);
}

        public void backtoHome(){
            while(!AndroidCommonFunctions.isExisted("id", "tv_search") && !AndroidCommonFunctions.isExisted("id", "img_cover"))
                AndroidCommonFunctions.back();
        }

        public static String deAccent(String str) {
            String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(nfdNormalizedString).replaceAll("");
        }

        public void verifyContentSuggestion(String s){
            List<AndroidElement> a = AndroidCommonFunctions.getElements("id", "tv_title");
            if (a == null) {

                AndroidCommonFunctions.isExisted("id", "tv_error");
            } else {

                for (AndroidElement items : a) {
                    items.getText().contentEquals(s);

                }
            }
        }

        public void inputText(String a) {
            AndroidCommonFunctions.fill("id", "et_search_bar", a);
        }

        public void searchExist(String keyword) {
            searchField.click();
            inputText(keyword);
            allResult.click();
            String compare = AndroidCommonFunctions.getElement("id", "tv_title").getText();
            Assert.assertEquals(deAccent(keyword).toLowerCase(), deAccent(compare).toLowerCase());
            switchTab("video");
            Assert.assertEquals(deAccent(keyword).toLowerCase(), deAccent(compare).toLowerCase());
        }

        public void switchTab (String tab){
            switch (tab) {
                case "chương trình":
                    program.click();
                case "video":
                    video.click();
                case "nổi bật tab":
                    HighlightTab.click();
                case "chương trình tab":
                    ProgramTab.click();
                case "video tab":
                    VideoTab.click();
                case "nghệ sĩ":
                    ArtistTab.click();
            }
        }



        public void searchNotExist (String keyword) {
            searchField.click();
            inputText(keyword);
            allResult.click();
            AndroidCommonFunctions.isExisted("id", "tv_error");
            switchTab("video");
            AndroidCommonFunctions.isExisted("id", "tv_error");
        }

        public void searchSuggestionList (String keyword) {
            searchField.click();
            inputText(keyword);

        }




    }



