package pages.homepage;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Objects {

    // Homepage element
    @AndroidFindBy(id = "tv_search")
    public AndroidElement searchField;

    @AndroidFindBy (id = "img_cover")
    public AndroidElement coverSlider;

    @AndroidFindBy (id = "itemOne")
    public AndroidElement phimTH;

    @AndroidFindBy (id = "itemSecound")
    public AndroidElement hoatHinh;

    @AndroidFindBy (id = "itemThird")
    public AndroidElement tvShow;

    @AndroidFindBy (id = "itemFour")
    public AndroidElement thieuNhi;

    @AndroidFindBy (id = "itemFive")
    public AndroidElement BXH;

    @AndroidFindBy (id = "tvHeader")
    public AndroidElement allResult;

    //Search page element

    @AndroidFindBy(id = "tv_title")
    public AndroidElement firstItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Chương Trình']")
    public AndroidElement program;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video']")
    public AndroidElement video;

    @AndroidFindBy(id = "tv_error")
    public AndroidElement notFound;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Chương trình']")
    public AndroidElement ProgramTab;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Nổi bật']")
    public AndroidElement HighlightTab;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='video']")
    public AndroidElement VideoTab;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Nghệ sĩ']")
    public AndroidElement ArtistTab;


}
