package com.example.dyf.dyfdemo.MvpDemo;

import java.util.List;

/**
 * Created by john on 2017/2/12.
 */

public interface ArticleViewInterface {

    public void  showArticles(List<Article> articles);//展示数据
    public void showLoading();
    public void hideLoading();

}
