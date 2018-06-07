package framework.Pages;

import framework.Selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PostPage
{

    public static String title()
    {
        WebElement title = Driver.Instance.findElement(By.className("entry-title"));
        if (title != null)  { return title.getText(); }

        return null;
    }
}
