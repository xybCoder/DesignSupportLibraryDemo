package com.xybcoder.designsupportlibrarydemo;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.animation.DecelerateInterpolator;

import butterknife.Bind;

/**
 * Created by dell on 2016/4/23.
 */
public abstract class ToolBarActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    protected Toolbar toolbar;
    @Bind(R.id.app_bar)
    protected AppBarLayout appBar;

    protected ActionBar actionBar;
    protected boolean isToolBarHiding = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar();
    }

    protected void initToolBar() {
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            switch (setHomeAsUpIndicator()){
                case 0://显示默认的箭头
                    break;
                default://显示自定义图标
                    actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
                    break;
            }
            actionBar.setDisplayHomeAsUpEnabled(canBack());
        }
    }

    /**
     * 设置home icon显示的图标类型
     * 默认返回0即显示箭头
     * 返回其他数字则自定义图标
     * @return
     */
    protected int setHomeAsUpIndicator() {
       return 0;
    }

    /**
     * 设置 home icon 是否可见
     *
     * @return
     */
    protected boolean canBack() {
        return true;
    }

    protected void hideOrShowToolBar() {
        appBar.animate()
                .translationY(isToolBarHiding ? 0 : -appBar.getHeight())
                .setInterpolator(new DecelerateInterpolator(2))
                .start();
        isToolBarHiding = !isToolBarHiding;
    }

}
