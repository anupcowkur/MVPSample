package com.anupcowkur.mvpsample.dagger.modules;

import com.anupcowkur.mvpsample.model.PostsAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    PostsAPI providePostsApi() {
        return new PostsAPI();
    }

}
