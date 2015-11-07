package com.anupcowkur.mvpsample.ui.presenters;

import com.anupcowkur.mvpsample.model.PostsAPI;
import com.anupcowkur.mvpsample.model.pojo.Post;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Observable.class, AndroidSchedulers.class})
public class PostsPresenterTest{

    private PostsPresenter postsPresenter;

    @Before
    public void setUp() throws Exception {
        postsPresenter = spy(new PostsPresenter(mock(PostsAPI.class)));

    }

    @Test
    public void testShouldSchedulePostsLoadFromAPIOnBackgroundThread() {

        //create mocks
        Observable<List<Post>> postsObservable = (Observable<List<Post>>) mock(Observable.class);

        //define return values
        when(postsPresenter.postsAPI.getPostsObservable()).thenReturn(postsObservable);
        when(postsObservable.subscribeOn(Schedulers.io())).thenReturn(postsObservable);
        when(postsObservable.observeOn(AndroidSchedulers.mainThread())).thenReturn(postsObservable);

        //call test method
        postsPresenter.loadPostsFromAPI();

        //verify if all methods in the chain are called with correct arguments
        verify(postsPresenter.postsAPI).getPostsObservable();
        verify(postsObservable).subscribeOn(Schedulers.io());
        verify(postsObservable).observeOn(AndroidSchedulers.mainThread());
        verify(postsObservable).subscribe(Matchers.<Subscriber<List<Post>>>any());
    }

}
