package com.example.dyf.dyfdemo.MvpDemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.dyf.dyfdemo.R;

/**
 * Created by john on 2017/2/12.
 */

public class MainActivity extends Activity implements ArticleViewInterface {

    RecyclerView mRecycleView;
    ProgressBar progressBar;
    List<Article> mArticles = new LinkedList<Article>();
    ArticleAdapter mAdapter;
    ArticlePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initViews();
        //初始化请求队列
        //....
        //构建ArticlePresenter,与ArticleActity建立关联
        mPresenter = new ArticlePresenter(this);
        //请求文章数据
        mPresenter.fetchArticles();
    }

    private void initViews() {
        //省略代码
        //....
    }


    @Override
    public void showArticles(List<Article> result) {
        mArticles.addAll(result);//更新数据源
        mAdapter.notifyDataSetChanged();//更新UI
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
