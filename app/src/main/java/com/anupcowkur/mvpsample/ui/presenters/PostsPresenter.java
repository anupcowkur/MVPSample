package com.anupcowkur.mvpsample.ui.presenters;

import com.anupcowkur.mvpsample.events.ErrorEvent;
import com.anupcowkur.mvpsample.events.NewPostsEvent;
import com.anupcowkur.mvpsample.model.PostsAPI;
import com.anupcowkur.mvpsample.model.pojo.Post;

import javax.inject.Inject;
import java.util.List;

import de.greenrobot.event.EventBus;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PostsPresenter {
    PostsAPI postsAPI;

    @Inject
    public PostsPresenter(PostsAPI postsAPI) {
        this.postsAPI = postsAPI;
    }

    public void loadPostsFromAPI() {
        postsAPI.getPostsObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers
                                                                                     .mainThread())
                .subscribe(new Subscriber<List<Post>>() {
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

                });
    }

}
