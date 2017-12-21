package supports;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by dell on 11/26/2017.
 */
public class AndroidCommonFunctions {
    private static AndroidDriver<AndroidElement> driver;

    public static void launchApp(String whichApp) throws IOException {
        String device_info = null, device_version = null;

            Process process1 = Runtime.getRuntime().exec("adb shell getprop ro.serialno");
            Process process2 = Runtime.getRuntime().exec("adb shell getprop ro.build.version.release");

            BufferedReader in = new BufferedReader(new InputStreamReader(process1.getInputStream()));
            BufferedReader in1 = new BufferedReader(new InputStreamReader(process2.getInputStream()));

            device_info = in.readLine();
            device_version = in1.readLine();
        DesiredCapabilities caps = new DesiredCapabilities();
//        System.setProperty("platformVersion","8.0");

        //TODO: Which device?
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, device_info);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, device_version);

        //TODO: Apps Under Testing
        /**
         * Option 1: using app Package + activity to launch installed app
         */
        if (whichApp.equalsIgnoreCase("calculator")){
            caps.setCapability("appPackage","com.sec.android.app.popupcalculator");
            caps.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
        }
        else if (whichApp.equalsIgnoreCase("contacts")){
            caps.setCapability("appPackage","com.android.contacts");
            caps.setCapability("appActivity", "com.android.contacts.activities.DialtactsActivity");
        }
        else if (whichApp.equalsIgnoreCase("zingtv")){
            caps.setCapability("appPackage","com.zing.tv3");
            caps.setCapability("appActivity", "com.vng.zingtv.activity.MainActivity");
        }
        else System.err.print("Connot find app on your device, please try again");

        /**
         * Option 2: Install app from apk file
         */
//        String path = new File((new FirstTest()).getClass().getClassLoader().getResource("org.wordpress.android.apk").getFile()).getAbsolutePath();
//        caps.setCapability(MobileCapabilityType.APP,"E://CodeWorkspace/Example/AK6/target/classes/org.wordpress.android.apk");
//        caps.setCapability(MobileCapabilityType.APP,"./target/classes/org.wordpress.android.apk");

        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        caps.setCapability(MobileCapabilityType.FULL_RESET,false);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,7200);
        //caps.setCapability("unicodeKeyboard", true);

        //ToDo: How to perform test?
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
    }

    public static AndroidDriver getApp(){
        return driver;
    }

    public static AndroidElement getElement(String how, String locator){
        switch (how){
            case "id":
                return driver.findElement(MobileBy.id(locator));
            case "text":
                return driver.findElement((MobileBy.xpath(String.format(".//*[@text='%s'",locator))));
            case "accessibility":
                return driver.findElementByAccessibilityId(locator);
            case "xpath":
                return driver.findElement(By.xpath(locator));
            case "button":
                return driver.findElement(MobileBy.xpath(String.format(".//android.widget.Button[@text='%s']", locator)));
        }

        return null;
    }

    public static List<AndroidElement> getElements(String how, String locator){
        switch (how){
            case "id":
                return driver.findElements(MobileBy.id(locator));
            case "text":
                return driver.findElements((MobileBy.xpath(String.format(".//*[@text='%s'",locator))));
            case "accessibility":
                return driver.findElementsByAccessibilityId(locator);
            case "xpath":
                return driver.findElements(By.xpath(locator));
            case "button":
                return driver.findElements(MobileBy.xpath(String.format(".//android.widget.Button[@text='%s']", locator)));
        }

        return null;
    }

    public static boolean isExisted(String how, String locator){
        return (getElements(how,locator).size() > 0);
    }

    public static void click(String how, String locator){
        if (isExisted(how, locator)) getElement(how, locator).click();
    }

    public static void fill(String how, String locator, String withText){
        if (isExisted(how, locator)) getElement(how, locator).sendKeys(withText);
    }

    public static String getText(String how, String locator){
        String text = null;
        if (isExisted(how, locator)) {
             text = getElement(how, locator).getText();
        }
        return text;
    }

    public static void back(){
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    public static void home(){
        driver.pressKeyCode(AndroidKeyCode.HOME);
    }

    public static void menu(){
        driver.pressKeyCode(AndroidKeyCode.MENU);
    }

    public static String getResult(String result) {
        String[] abc = result.split("\n");
        String actualResult = abc[1].replace("equal ","");
        System.out.println("Tuong - actualResult la: " + actualResult);
        return actualResult;
    }

    public static void waitForScreenToLoad(AppiumDriver lDriver, WebElement element, int seconds){

        WebDriverWait wait = new WebDriverWait(lDriver,seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
