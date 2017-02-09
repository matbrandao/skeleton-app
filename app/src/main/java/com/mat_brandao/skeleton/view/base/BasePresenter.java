package com.mat_brandao.skeleton.view.base;

/**
 * Created by Mateus Brandão on 04-Apr-16.
 */
public interface BasePresenter<V extends BaseView> {
    void onResume();

    void onAttach(V view);

    void onPause();

    void onDestroy();

    void onRetryClicked();
}
