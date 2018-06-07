package tests.Smoke;

import framework.Pages.NewPostPage;
import framework.Pages.PostPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Utilities.WordPressTests;

public class CreatePostTest extends WordPressTests
{

    @Test
    public void canCreateaBasicPost() throws InterruptedException {

        NewPostPage.goTo();
        NewPostPage.createPost("This is the test post data")
                .withBody("Hi, this is the body")
                .publish();

        NewPostPage.gotoNewPostPage();

        //If exists the last parameter is an error message
        Assert.assertEquals(PostPage.title(), "This is the test post data", "Title did not match");
    }
}
