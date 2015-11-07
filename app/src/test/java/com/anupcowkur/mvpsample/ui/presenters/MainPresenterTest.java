package com.anupcowkur.mvpsample.ui.presenters;

import com.anupcowkur.mvpsample.ui.screen_contracts.MainScreen;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MainPresenterTest {

    private MainPresenter mainPresenter;

    @Before
    public void setUp() throws Exception {

        mainPresenter = new MainPresenter();

    }

    @Test
    public void testShouldShowToastAndLaunchActivityOnShowPostsButtonClick() {
        MainScreen mainScreen = mock(MainScreen.class);

        mainPresenter.OnShowPostsButtonClick(mainScreen);

        verify(mainScreen).launchPostsActivity();

    }

}
