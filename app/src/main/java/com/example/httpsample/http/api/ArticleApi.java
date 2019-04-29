package com.example.httpsample.http.api;

import com.example.httpsample.bean.BaseResponse;
import com.example.httpsample.bean.article.ArticleList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ArticleApi {
    @GET("article/list/{page}/json")
    public Observable<BaseResponse<ArticleList>> getArticles(@Path("page") int page);
}
