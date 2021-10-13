package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)

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
}
