package com.anupcowkur.mvpsample.ui.presenters;

import com.anupcowkur.mvpsample.ui.viewinterfaces.MainScreen;

import javax.inject.Inject;

public class MainPresenter {

    @Inject
    public MainPresenter() {
    }

    public void OnShowPostsButtonClick(MainScreen mainScreen) {
        mainScreen.showToast();
        mainScreen.launchPostsActivity();
    }

}
