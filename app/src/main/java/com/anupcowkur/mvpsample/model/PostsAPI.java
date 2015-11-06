package com.anupcowkur.mvpsample.model;

import com.anupcowkur.mvpsample.model.pojo.Post;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.http.GET;
import rx.Observable;

public class PostsAPI {

    private interface PostService {
        @GET("/posts")
        Observable<List<Post>> getPostsList();
    }

    private Observable<List<Post>> postsObservable = new RestAdapter.Builder()
            .setEndpoint("http://jsonplaceholder.typicode.com")
            .build().create(PostService.class).getPostsList().cache();


    public Observable<List<Post>> getPostsObservable() {
        return postsObservable;
    }

}
