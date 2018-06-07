package framework.Pages;

import framework.CreatePostCommand;
import framework.Selenium.Driver;
import framework.Navigation.LeftNavigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewPostPage
{

    public static String title;

    public static void goTo()
    {
        LeftNavigation.Posts.AddNew.select();

    }

    public static CreatePostCommand createPost(String title)
    {
        return new CreatePostCommand(title);
    }

    public static void gotoNewPostPage()
    {
        WebElement message = Driver.Instance.findElement(By.id("message"));
        WebElement newPostLink = message.findElements(By.tagName("a")).get(1);

        newPostLink.click();
    }

    public static boolean isInEditMode()
    {
        return Driver.Instance.findElement(By.id("icon-edit-pages")) != null;
    }

    public static String title()
    {
        WebElement title = Driver.Instance.findElement(By.id("title"));
        if (title != null) return title.getAttribute("value");

        return null;
    }

}

