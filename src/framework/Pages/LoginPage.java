package framework.Pages;

import framework.Selenium.Driver;
import framework.LoginCommand;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{

    public static void goTo()
    {
        Driver.Instance.navigate().to(Driver.baseAddress + "wp-login.php");
        WebDriverWait wait = new WebDriverWait(Driver.Instance, 10);
        wait.until(d -> d.switchTo().activeElement().getAttribute("id") == "user_login");
    }

    public static LoginCommand loginAs(String username)
    {
        return new LoginCommand(username);
    }
}
