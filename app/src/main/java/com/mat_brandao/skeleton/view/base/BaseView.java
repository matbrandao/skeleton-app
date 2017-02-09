package com.mat_brandao.skeleton.view.base;

import android.content.Intent;

/**
 * Created by Mateus Brandão on 04-Apr-16.
 */
public interface BaseView {

    void showToast(String text);

    void goToActivity(Class<?> activity);

    void goToActivity(Intent intent);

    void finishActivity();

    interface NormalView extends BaseView {

    }

    interface BaseProgressView extends BaseView {
        void showNoConnectionSnackBar();

        void showProgressDialog(String message);

        void dismissProgressDialog();
    }
}