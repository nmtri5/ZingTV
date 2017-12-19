package packages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import supports.AndroidCommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.*;
import java.net.URL;


public class SauceLabs {

    public static final String USERNAME = "trivip93";
    public static final String ACCESS_KEY = "17c29a11-e34e-406f-a2d4-c50160ce7ee6";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability("appiumVersion", "1.7.1");
        caps.setCapability("deviceName","Samsung Galaxy S4 GoogleAPI Emulator");
        caps.setCapability("deviceOrientation", "portrait");
        caps.setCapability("browserName", "Browser");
        caps.setCapability("platformVersion", "4.4");
        caps.setCapability("platformName","Android");
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
/**
 * Test Actions here...
 *

 */
        driver.get("https://testing.vn");
        driver.quit();
    }
}
