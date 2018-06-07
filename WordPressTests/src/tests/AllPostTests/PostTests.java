package tests.AllPostTests;

import framework.Pages.ListPostPage;
import framework.Pages.NewPostPage;
import framework.PostType;
import framework.Workflows.PostCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostTests
{

    @Test
    public void AddedPostaShowUp() throws InterruptedException {
        ListPostPage.goTo(PostType.POSTS);
        ListPostPage.storeCount();

        PostCreator.createPost();

        ListPostPage.goTo(PostType.POSTS);
        Assert.assertEquals(ListPostPage.previousPostCount() + 1, ListPostPage.currentPostCount(), "Count of posts did not increase");

        Assert.assertTrue(ListPostPage.doesPostExistWithTitle(PostCreator.previousTitle));

        ListPostPage.trashPost(PostCreator.previousTitle);
        Assert.assertEquals(ListPostPage.previousPostCount(), ListPostPage.currentPostCount(), "Could not trash post");
    }

    @Test
    public void canSearchPosts() throws InterruptedException {
        NewPostPage.goTo();
        NewPostPage.createPost("Searching Post, title")
                .withBody("searching posts, body")
                .publish();

        ListPostPage.goTo(PostType.POSTS);
        ListPostPage.searchForPost("Searching post, title");


        Assert.assertTrue(ListPostPage.doesPostExistWithTitle("Searching Post, title"));


    }
}
