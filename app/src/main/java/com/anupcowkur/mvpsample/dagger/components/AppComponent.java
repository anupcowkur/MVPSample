package com.anupcowkur.mvpsample.dagger.components;

import com.anupcowkur.mvpsample.dagger.modules.AppModule;
import com.anupcowkur.mvpsample.ui.activities.MainActivity;
import com.anupcowkur.mvpsample.ui.activities.PostsActivity;

import javax.inject.Singleton;

import dagger.Component;


@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(PostsActivity activity);
}
