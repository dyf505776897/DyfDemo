package com.example.dyf.dyfdemo.MvpDemo;

import java.util.List;

/**
 * Created by john on 2017/2/12.
 */

public interface ArticleModel {

    public void saveArticles(List<Article> articles);
    public void loadArticlesFromCache(DataListener<List<Article>> listener);


}
