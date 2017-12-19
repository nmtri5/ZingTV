package packages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.text.Element;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class testFunction {
    AndroidDriver driver;


    public void backtoHome() {

        while (driver.findElements(By.id("com.zing.tv3:id/tabs")).isEmpty() && driver.findElements(By.xpath("//android.widget.TextView[@text='Trang chủ']")).isEmpty()) {
            driver.pressKeyCode(AndroidKeyCode.BACK);

        }
    }
    public static boolean compareList(List ls1, List ls2){
        return ls1.containsAll(ls2) && ls1.size() == ls2.size() ? true :false;
    }

    public boolean reachBottom(){
        List <String> compare1 = new ArrayList<String>();
        List <String> compare2 = new ArrayList<String>();
        List <WebElement> check = driver.findElements(By.id("com.zing.tv3:id/tv_title"));

        for (WebElement items: check)
        {
            compare1.add(items.getText());
        }

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(273, 439).moveTo(0, -30).release().perform();

        List <WebElement> check1 = driver.findElements(By.id("com.zing.tv3:id/tv_title"));
        for (WebElement items: check1)
        {
            compare2.add(items.getText());
        }


            if ( compareList(compare1, compare2) == true ) {
                return true;
            } else{

            return false;

            }

        }

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Define what device and what app will run a test
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "920135e8f45b743d");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.VERSION, "6.0.1");
        capabilities.setCapability("appPackage", "com.zing.tv3");
        capabilities.setCapability("appActivity", "com.vng.zingtv.activity.MainActivity");

        //Make app stays in old setting
        capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");

        //Connect to appium server
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

    }

    @Test (priority = 1)
    public void checkCategory() { //Testcase ID: ZTTCTC_3: Kiểm tra giao diện các icon program control

        TouchAction touchAction = new TouchAction(driver);


                touchAction.press(273, 439).moveTo(0, -30).release().perform();
                List<WebElement> thumbnail = driver.findElements(By.id("com.zing.tv3:id/tv_title"));

        for (WebElement items: thumbnail)
              {
                  System.out.println(items.getText());
        }
                for (int i = 0; i <= thumbnail.size() - 1; i++) {
                    driver.findElement(By.xpath("//android.widget.TextView[@text='" + thumbnail.get(i).getText() + "']")).click();

                    backtoHome();
                }




    }}
