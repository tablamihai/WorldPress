package tests.Smoke;

import framework.Pages.ListPostPage;
import framework.Pages.NewPostPage;
import framework.PostType;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Utilities.WordPressTests;

public class PageTest extends WordPressTests
{

    @Test
    public void CanEditAPage() throws InterruptedException {

        ListPostPage.goTo(PostType.PAGE);
        ListPostPage.selectPost("Sample Page");

        Assert.assertTrue(NewPostPage.isInEditMode(), "Wasn't in edit mode");
        Assert.assertEquals("Sample Page", NewPostPage.title(), "Title did not match");
    }
}
