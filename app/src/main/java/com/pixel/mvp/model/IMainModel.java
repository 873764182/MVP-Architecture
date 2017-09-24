package com.pixel.mvp.model;

/**
 * Created by pixel on 2017/9/25.
 */

public interface IMainModel {

    void loadData(OnLoadOkListener listener);

    interface OnLoadOkListener {
        void onOk(String data);
    }
}
