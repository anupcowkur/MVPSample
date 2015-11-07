package com.anupcowkur.mvpsample.ui.presenters;

import com.anupcowkur.mvpsample.ui.screen_contracts.MainScreen;

import javax.inject.Inject;

public class MainPresenter {

    @Inject
    public MainPresenter() {
    }

    public void OnShowPostsButtonClick(MainScreen mainScreen) {
        mainScreen.launchPostsActivity();
    }

}
