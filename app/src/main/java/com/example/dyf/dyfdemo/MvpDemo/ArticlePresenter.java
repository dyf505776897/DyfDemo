package com.example.dyf.dyfdemo.MvpDemo;

/**
 * Created by john on 2017/2/12.
 */

import java.util.List;

/**
 *Presenter作为View和Model的中间人
 * */
public class ArticlePresenter {

    //ArticleView接口，代表了View接口角色
    ArticleViewInterface mArticleView;
    //文章数据的Model，也就是Model角色
    ArticleModel mArticleModel = new ArticleModeImple();
    //从网络上获取文章的API
    ArticleAPI mAriticleApi = new ArticleAPIImpl();

    public ArticlePresenter(ArticleViewInterface mArticleView) {
        this.mArticleView = mArticleView;
    }

    //获取文章,也就是我们的业务逻辑
    public void fetchArticles(){
        mArticleView.showLoading();
        mAriticleApi.fetchArticles(new DataListener<List<Article>>(){
            @Override
            public void onComplete(List<Article> result) {
                //数据加载完，调用View的showArticles函数将数据传递给View显示
                mArticleView.showArticles(result);
                mArticleView.hideLoading();
                //存储到数据库
                mArticleModel.saveArticles(result);
            }
        });
    }

    public void loadArticlesFromDB(){
        mArticleModel.loadArticlesFromCache(new DataListener<List<Article>>() {
            @Override
            public void onComplete(List<Article> result) {
                //从数据库加载
                mArticleView.showArticles(result);
            }
        });
    }


}
