package framework.Navigation;

import framework.Selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MenuSelector
{

    public static void select(String topLevelMenuId, String subMenuLevelText)
    {
        WebElement menuPost = Driver.Instance.findElement(By.id(topLevelMenuId));
        menuPost.click();

        WebElement addNew = Driver.Instance.findElement(By.linkText(subMenuLevelText));
        addNew.click();
    }
}