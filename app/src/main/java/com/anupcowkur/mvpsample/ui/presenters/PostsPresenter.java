package com.anupcowkur.mvpsample.ui.presenters;

import com.anupcowkur.mvpsample.dagger.DaggerInjector;
import com.anupcowkur.mvpsample.model.PostsAPI;
import com.anupcowkur.mvpsample.model.data.Post;
import com.anupcowkur.mvpsample.ui.activities.PostsActivity;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PostsPresenter {

    @Inject
    PostsAPI postsAPI;

    @Inject
    Subscriber<List<Post>> postsSubscriber;

    public void injectDependencies() {
        DaggerInjector.get().inject(this);
    }

    public void initRecyclerView(PostsActivity postsActivity) {

        postsActivity.initRecyclerViewUI();

        postsActivity.initRecyclerViewAdapter();
    }

    public void loadPostsFromAPI() {
        postsAPI.getPostsObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers
                .mainThread()).subscribe(postsSubscriber);
    }

}
