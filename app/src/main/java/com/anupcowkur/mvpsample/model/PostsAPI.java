package com.anupcowkur.mvpsample.model;

import com.anupcowkur.mvpsample.model.pojo.Post;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

public class PostsAPI {

    private interface PostService {
        @GET("posts")
        Observable<List<Post>> getPostsList();
    }

    private Observable<List<Post>> postsObservable = new Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(PostService.class).getPostsList().cache();


    public Observable<List<Post>> getPostsObservable() {
        return postsObservable;
    }

}
