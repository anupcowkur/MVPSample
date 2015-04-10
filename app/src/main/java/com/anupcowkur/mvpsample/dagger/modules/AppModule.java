package com.anupcowkur.mvpsample.dagger.modules;

import com.anupcowkur.mvpsample.events.ErrorEvent;
import com.anupcowkur.mvpsample.events.NewPostsEvent;
import com.anupcowkur.mvpsample.model.PostsAPI;
import com.anupcowkur.mvpsample.model.data.Post;
import com.anupcowkur.mvpsample.ui.presenters.MainPresenter;
import com.anupcowkur.mvpsample.ui.presenters.PostsPresenter;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import rx.Subscriber;

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

    @Provides
    PostsPresenter providePostsPresenter() {
        return new PostsPresenter();
    }

    @Provides
    Subscriber<List<Post>> providePostsSubscriber() {
        return new Subscriber<List<Post>>() {
            @Override
            public void onNext(List<Post> newPosts) {
                EventBus.getDefault().post(new NewPostsEvent(newPosts));
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                EventBus.getDefault().post(new ErrorEvent());
            }

        };
    }

}