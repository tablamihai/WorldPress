package framework;

import framework.Selenium.Driver;
import org.openqa.selenium.By;

public class CreatePostCommand
{
    private String title;
    private String body;

    public CreatePostCommand(String  title)
    {
        this.title = title;
    }

    public CreatePostCommand withBody(String body)
    {
        this.body = body;
        return this;
    }

    public void publish() throws InterruptedException {
         Driver.Instance.findElement(By.id("title")).sendKeys(title);

         Driver.Instance.switchTo().frame("content_ifr");
         Driver.Instance.switchTo().activeElement().sendKeys(body);
         Driver.Instance.switchTo().defaultContent();

         Driver.waita(1L);

         Driver.Instance.findElement(By.id("publish")).click();

    }
}