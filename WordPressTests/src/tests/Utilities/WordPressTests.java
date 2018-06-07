package tests.Utilities;

import framework.Selenium.Driver;
import framework.Pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WordPressTests
{

    @BeforeTest
    public void init()
    {
        Driver.Initialize();

        LoginPage.goTo();
        LoginPage.loginAs("admin").usingPassword("password").login();
    }

    @AfterTest
    public void cleanUp()
    {
        Driver.close();
    }


}
