package com.anupcowkur.mvpsample.dagger.modules;

import com.anupcowkur.mvpsample.model.PostsAPI;
import com.anupcowkur.mvpsample.ui.presenters.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    PostsAPI providePostsApi() {
        return new PostsAPI();
    }

}
