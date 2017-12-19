package pages.contact;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Objects {

    @AndroidFindBy (id = "floating_action_button")
    public AndroidElement crtBtn;

    @AndroidFindBy (id = "editors")
    public AndroidFindBy namefld;

    @AndroidFindBy (id = "menu_done")
    public AndroidFindBy saveBtn;


}
