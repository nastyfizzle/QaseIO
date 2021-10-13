package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    @BeforeMethod
    public void setup() {
        //Implicitly wait
        Configuration.timeout = 20000;
        Configuration.pageLoadTimeout = 60000;
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://app.qase.io/";
        Configuration.startMaximized = true;
        Configuration.headless = false;
        //All clicks using JS
        Configuration.clickViaJs = false;
    }

    @AfterMethod (alwaysRun = true)
    public void close() {
        Selenide.closeWebDriver();
    }
}
