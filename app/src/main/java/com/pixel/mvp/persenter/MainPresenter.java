package com.pixel.mvp.persenter;

import android.app.Activity;
import android.os.Bundle;

import com.pixel.mvp.model.IMainModel;
import com.pixel.mvp.model.MainModelImpl;
import com.pixel.mvp.view.MainView;

/**
 * Created by pixel on 2017/9/25.
 * <p>
 * Presenter是核心，一般不能替换。
 */

public class MainPresenter extends BasePresenter<MainView, IMainModel> {

    public MainPresenter(MainView view) {
        super(view);    // 如果需要修改UI层则在此修改，必须实现MainView接口，界面入口还是要从配置文件理修改。Presenter不拿指定Activity，只拿接口操作。
    }

    @Override
    protected IMainModel createModel() {
        return new MainModelImpl(); // 如果需要替换Model层从这里修改。Presenter不拿指定Model，只拿接口操作。
    }

    @Override
    public void doAttachView(Bundle bundle) {
        model.loadData(new MainModelImpl.OnLoadOkListener() {
            @Override
            public void onOk(final String data) {
                ((Activity) getView()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        getView().showData(data);
                    }
                });
            }
        });
    }

    @Override
    public void doDetachedView() {
        view.clear();   // 清楚内存引用
    }

}
