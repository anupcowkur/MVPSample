package com.anupcowkur.mvpsample.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.anupcowkur.mvpsample.R;
import com.anupcowkur.mvpsample.dagger.DaggerInjector;
import com.anupcowkur.mvpsample.events.ErrorEvent;
import com.anupcowkur.mvpsample.events.NewPostsEvent;
import com.anupcowkur.mvpsample.ui.adapters.PostsListAdapter;
import com.anupcowkur.mvpsample.ui.decorators.DividerItemDecoration;
import com.anupcowkur.mvpsample.ui.presenters.PostsPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.greenrobot.event.EventBus;

public class PostsActivity extends Activity {

    @Inject
    PostsPresenter postsPresenter;

    @InjectView(R.id.posts_recycler_view)
    RecyclerView postsRecyclerView;

    @InjectView(R.id.error_view)
    TextView errorView;

    PostsListAdapter postsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_posts);

        DaggerInjector.get().inject(this);
        ButterKnife.inject(this);

        postsPresenter.injectDependencies();
        postsPresenter.initRecyclerView(this);
        postsPresenter.loadPostsFromAPI();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void initRecyclerViewUI() {
        postsRecyclerView.setHasFixedSize(true);
        postsRecyclerView.setLayoutManager(new LinearLayoutManager(postsRecyclerView.getContext()));
        postsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        postsRecyclerView.addItemDecoration(new DividerItemDecoration(postsRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL_LIST));
    }

    public void initRecyclerViewAdapter() {
        postsListAdapter = new PostsListAdapter();
        postsRecyclerView.setAdapter(postsListAdapter);
    }

    public void onEventMainThread(NewPostsEvent newPostsEvent) {
        hideError();
        postsListAdapter.addPosts(newPostsEvent.getPosts());
    }

    public void onEventMainThread(ErrorEvent errorEvent) {
        showError();
    }

    private void hideError() {
        postsRecyclerView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
    }

    private void showError() {
        postsRecyclerView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
    }
}
