package com.example.dyf.dyfdemo.MvpDemo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by john on 2017/2/12.
 */

public class ArticleModeImple implements  ArticleModel{


    List<Article> mCacheArticles = new LinkedList<>();

    @Override
    public void saveArticles(List<Article> articles) {
        mCacheArticles.addAll(articles);
    }

    @Override
    public void loadArticlesFromCache(DataListener<List<Article>> listener) {
        listener.onComplete(mCacheArticles);
    }


}
