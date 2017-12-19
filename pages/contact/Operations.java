package pages.contact;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pages.contact.Objects;
import supports.AndroidCommonFunctions;

public class Operations extends Objects {

    // todo: create, edit, delete,
    public Operations(){
        PageFactory.initElements(new AppiumFieldDecorator(AndroidCommonFunctions.getApp()), this);
    }

    public void inputText(String a) {

    }
    public void createContact(String a) {
        crtBtn.click();

    }
}

