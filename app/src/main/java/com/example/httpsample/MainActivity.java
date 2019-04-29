package com.example.httpsample;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.httpsample.bean.article.Article;
import com.example.httpsample.bean.article.ArticleList;
import com.example.httpsample.http.HttpManager;
import com.example.httpsample.http.api.ArticleApi;
import com.example.httpsample.utils.RxUtils;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_text = findViewById(R.id.tv_text);
        findViewById(R.id.btn_click).setOnClickListener(v -> {
            HttpManager.getInstance().create(ArticleApi.class)
                    .getArticles(0)
                    .compose(RxUtils.rxObSchedulerHelper())
                    .compose(RxUtils.handResult())
                    .subscribeWith(new BaseErrorObserver<ArticleList>(context) {
                        @Override
                        public void onNext(ArticleList articleList) {
                            tv_text.setText(articleList.getPageCount()+"123");
                        }
                    });
        });
    }
}
