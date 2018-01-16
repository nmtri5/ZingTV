package pages.user_info;


import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class Objects {
    @AndroidFindBy(id = "tv_login")
    public AndroidElement loginBtn;

    @AndroidFindBy(id = "ll_login_zalo")
    public AndroidElement loginzaloBtn;

    @AndroidFindBy(xpath = "//android.support.v7.app.ActionBar$Tab[@index='0']")
    public AndroidElement trangchu;

    @AndroidFindBy(xpath = "//*[@Class='android.support.v7.app.ActionBar$Tab'][@index=1]")
    public AndroidElement khampha;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='0']/android.support.v7.app.ActionBar$Tab[@index='2']")
    public AndroidElement canhan;

    @AndroidFindBy(xpath = "//*[@Class='android.support.v7.app.ActionBar$Tab'][@index=3]")
    public AndroidElement them;
}
