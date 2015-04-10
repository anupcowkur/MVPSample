package com.anupcowkur.mvpsample.ui.presenters;

import com.anupcowkur.mvpsample.ui.activities.MainActivity;

public class MainPresenter {

    public void OnShowPostsButtonClick(MainActivity mainActivity) {
        mainActivity.showToast();
        mainActivity.launchPostsActivity();
    }

}
