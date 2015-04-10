package com.anupcowkur.mvpsample.ui.presenters;

import android.test.suitebuilder.annotation.SmallTest;

import com.anupcowkur.mvpsample.ui.activities.MainActivity;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(JUnit4.class)
public class MainPresenterTest extends TestCase {

    private MainPresenter mainPresenter;

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();

        mainPresenter = new MainPresenter();

    }

    @Test
    @SmallTest
    public void testShouldShowToastAndLaunchActivityOnShowPostsButtonClick() {
        MainActivity mainActivity = mock(MainActivity.class);

        mainPresenter.OnShowPostsButtonClick(mainActivity);

        verify(mainActivity, times(1)).showToast();
        verify(mainActivity, times(1)).launchPostsActivity();

    }

}
