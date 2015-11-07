package com.anupcowkur.mvpsample.ui.activities;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.anupcowkur.mvpsample.R;
import com.anupcowkur.mvpsample.utils.ActivityRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    MainActivity mainActivity;

    @Rule
    public final ActivityRule<MainActivity> rule = new ActivityRule<>(MainActivity.class);

    @Before
    public void init() {
        mainActivity = rule.get();
    }

    @Test
    public void testShouldLaunchPostsActivityWhenShowPostsButtonIsClicked() {

        onView(withId(R.id.show_posts_button)).perform(click());

        onView(withId(R.id.posts_recycler_view)).check(matches(isDisplayed()));

    }

}
