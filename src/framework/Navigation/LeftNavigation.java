package framework.Navigation;

import framework.Selenium.Driver;
import org.openqa.selenium.By;

public class LeftNavigation
{
    public static class Posts
    {
        public static class AddNew
        {
            public static void select()
            {
                MenuSelector.select("menu-posts", "Add New");
            }
        }

        public static class AllPosts
        {

            public static void select()
            {
                MenuSelector.select("menu-posts", "All Posts");
            }
        }

    }

    public static class Pages
    {
        public static class AllPages
        {
            public static void select()
            {
                Driver.Instance.findElement(By.id("menu-pages")).click();
                Driver.Instance.findElement(By.linkText("All pages")).click();
            }
        }
    }

}
