package com.anupcowkur.mvpsample.dagger;

import com.anupcowkur.mvpsample.dagger.components.AppComponent;
import com.anupcowkur.mvpsample.dagger.components.DaggerAppComponent;
import com.anupcowkur.mvpsample.dagger.modules.AppModule;

public class DaggerInjector {
    private static AppComponent appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();

    public static AppComponent get() {
        return appComponent;
    }
}
