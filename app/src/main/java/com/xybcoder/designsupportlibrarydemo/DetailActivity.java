package com.xybcoder.designsupportlibrarydemo;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;

import butterknife.Bind;

public class DetailActivity extends ToolBarActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CollapsingToolbarLayout collapsingToolbar=(CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("详情");
    }
}
