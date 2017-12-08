package com.pixel.mvp.persenter;

import android.os.Bundle;

import java.lang.ref.WeakReference;

/**
 *
 * @author pixel
 * @date 2017/9/24
 * <p>
 * Presenter基础，持有View与Model。
 */

public abstract class BasePresenter<V, M> {

    /* 弱引用View控件 */
    protected WeakReference<V> view;   // WeakReference

    /* Model引用 */
    protected M model;

    public V getView() {
        return view.get();
    }

    public BasePresenter(V view) {
        this.view = new WeakReference<>(view);
        this.model = createModel();
    }

    /* 创建Model */
    protected abstract M createModel();

    /* 绑定视图 */
    public abstract void doAttachView(Bundle bundle);

    /* 视图解绑 */
    public abstract void doDetachedView();

    /* 生命周期方法绑定 最好所有的方法都从写一遍 */
    public void onResume() {
    }

}
