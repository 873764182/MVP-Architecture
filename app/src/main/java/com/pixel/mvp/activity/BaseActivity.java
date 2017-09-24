package com.pixel.mvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.pixel.mvp.persenter.BasePresenter;

/**
 * Created by pixel on 2017/9/24.
 * <p>
 * Activity基础
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView($());

        presenter = createPresenter();

        presenter.doAttachView(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.doDetachedView();
    }

    protected abstract int $();

    protected abstract P createPresenter();

}
