package com.pixel.mvp.model;

/**
 * Created by pixel on 2017/9/25.
 * <p>
 * Main Model 的第一个实现
 */

public class MainModelImpl implements IMainModel {

    @Override
    public void loadData(final OnLoadOkListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                listener.onOk("这是从移步获取的消息，模拟网络延迟操作。");
            }
        }).start();
    }

}
