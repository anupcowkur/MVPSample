package com.anupcowkur.mvpsample.ui.activities;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.anupcowkur.mvpsample.R;
import com.anupcowkur.mvpsample.events.ErrorEvent;
import com.anupcowkur.mvpsample.events.NewPostsEvent;
import com.anupcowkur.mvpsample.model.pojo.Post;
import com.anupcowkur.mvpsample.utils.ActivityRule;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.greenrobot.event.EventBus;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class PostsActivityTest {

    @Rule
    public final ActivityRule<PostsActivity> rule = new ActivityRule<>(PostsActivity.class);

    PostsActivity postsActivity;

    @Before
    public void init() {
        postsActivity = rule.get();
    }

    @Test
    public void testShouldShowRecyclerViewOnNewPosts() {

        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, 1, "title 1", "body 1"));
        posts.add(new Post(2, 2, "title 2", "body 2"));
        posts.add(new Post(3, 3, "title 3", "body 3"));
        posts.add(new Post(4, 4, "title 4", "body 4"));
        posts.add(new Post(5, 5, "title 5", "body 5"));
        posts.add(new Post(6, 6, "title 6", "body 6"));
        posts.add(new Post(7, 7, "title 7", "body 7"));
        posts.add(new Post(8, 8, "title 8", "body 8"));
        posts.add(new Post(9, 9, "title 9", "body 9"));
        posts.add(new Post(10, 10, "title 10", "body 10"));

        EventBus.getDefault().post(new NewPostsEvent(posts));

        onView(withId(R.id.posts_recycler_view)).check(matches(isDisplayed()));
        onView(withId(R.id.error_view)).check(matches(not(isDisplayed())));

    }

    @Test
    public void testShouldShowErrorViewOnNetworkError() {

        EventBus.getDefault().post(new ErrorEvent());

        onView(withId(R.id.error_view)).check(matches(isDisplayed()));
        onView(withId(R.id.posts_recycler_view)).check(matches(not(isDisplayed())));

    }

}
