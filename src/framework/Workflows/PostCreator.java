package framework.Workflows;

import framework.Pages.NewPostPage;

public class PostCreator
{
    public static String previousTitle;
    public static String previousBody;


    public static void createPost() throws InterruptedException {
        NewPostPage.goTo();

        previousTitle = createTitle();
        previousBody = createBody();
        NewPostPage.createPost(previousTitle)
                .withBody(previousBody)
                .publish();
    }

    private static String createBody() {
    }

    private static String createTitle() {
    }
}
