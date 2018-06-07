package framework.Pages;

import framework.Selenium.Driver;
import framework.Navigation.LeftNavigation;
import framework.PostType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ListPostPage
{

    private static int lastConut;

    public static void goTo(PostType post)
    {
        switch (post) {
            case PAGE:
                LeftNavigation.Pages.AllPages.select();
                break;

            case POSTS:
                LeftNavigation.Posts.AllPosts.select();
                break;
        }
    }

    public static void selectPost(String title)
    {
        WebElement postLink = Driver.Instance.findElement(By.linkText("Sample Text"));
        postLink.click();
    }


    public static void storeCount()
    {
        lastConut = getPostCount();
        
    }

    private static int getPostCount()
    {
        String countText = Driver.Instance.findElement(By.className("displaying-num")).getText();
        return Integer.valueOf(countText.split(" ")[0]);
    }

    public static int previousPostCount()
    {
        return lastConut;
    }

    public static int currentPostCount()
    {
        return getPostCount();
    }

    public static boolean doesPostExistWithTitle(String title)
    {
        return Driver.Instance.findElements(By.linkText(title)) != null;
    }

    public static void trashPost(String title)
    {
        List<WebElement> rows = Driver.Instance.findElements(By.tagName("tr"));

        for (WebElement row : rows)
        {
            AtomicReference<List<WebElement>> links = null;
            Driver.noWait(() -> links.set(row.findElements(By.linkText(title))));

            if (links.get().size() > 0)
            {
                Actions action = new Actions(Driver.Instance);
                action.moveToElement((links).get().get(0));
                action.perform();
                row.findElement(By.className("submitdelete")).click();
                return;
            }

        }
    }

    public static void searchForPost(String searchString)
    {
        WebElement searchBox = Driver.Instance.findElement(By.id("post-search-input"));
        searchBox.sendKeys(searchString);

        WebElement searchButton = Driver.Instance.findElement(By.id("search-submit"));
        searchButton.submit();

    }
}
