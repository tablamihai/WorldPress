package tests.Smoke;

import framework.Pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Utilities.WordPressTests;

public class LoginTest extends WordPressTests
{

    @Test
    public static void main(String[] args)
    {
        Assert.assertTrue(DashboardPage.isAt(), "Failed to login");
    }
}
