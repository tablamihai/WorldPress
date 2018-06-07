package framework.Pages;

import framework.Selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage {

    public static boolean isAt() {
         List<WebElement> h2s = Driver.Instance.findElements(By.tagName("h2"));

         if (h2s.size() > 0) {
             return h2s.get(1).getText() == "Dashboard";
         }

         return false;
    }
}
