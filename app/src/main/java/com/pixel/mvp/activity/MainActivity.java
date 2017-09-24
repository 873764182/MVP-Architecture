package com.pixel.mvp.activity;

import android.widget.TextView;

import com.pixel.mvp.R;
import com.pixel.mvp.persenter.MainPresenter;
import com.pixel.mvp.view.MainView;

/**
 * MainView的第一个实现
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    private TextView mText;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int $() {
        return R.layout.activity_main;
    }

    @Override
    public void initWidget() {
        mText = (TextView) findViewById(R.id.text);
    }

    @Override
    public void showData(String data) {
        mText.setText(data);
    }

}
