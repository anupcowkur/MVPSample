package com.anupcowkur.mvpsample.ui.presenters;

import com.anupcowkur.mvpsample.ui.viewinterfaces.MainScreen;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import android.test.suitebuilder.annotation.SmallTest;

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
        MainScreen mainScreen = mock(MainScreen.class);

        mainPresenter.OnShowPostsButtonClick(mainScreen);

        verify(mainScreen, times(1)).showToast();
        verify(mainScreen, times(1)).launchPostsActivity();

    }

}
