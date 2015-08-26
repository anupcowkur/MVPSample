package com.anupcowkur.mvpsample.ui.presenters;

import com.anupcowkur.mvpsample.ui.viewinterfaces.MainScreen;

public class MainPresenter {

    public void OnShowPostsButtonClick(MainScreen mainScreen) {
        mainScreen.showToast();
        mainScreen.launchPostsActivity();
    }

}
