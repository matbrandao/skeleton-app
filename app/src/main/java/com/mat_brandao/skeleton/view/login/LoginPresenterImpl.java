package com.mat_brandao.skeleton.view.login;

import android.content.Context;

import com.mat_brandao.skeleton.domain.di.ActivityContext;
import com.mat_brandao.skeleton.view.base.BaseView;

import javax.inject.Inject;

public class LoginPresenterImpl implements LoginPresenter {

    private Context context;
    private LoginView mView;

    @Inject
    LoginInteractorImpl mInteractor;

    @Inject
    public LoginPresenterImpl(@ActivityContext Context context) {
        this.context = context;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onAttach(BaseView view) {
        mView = (LoginView) view;
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        mView = null;
    }

    @Override
    public void onRetryClicked() {
        // TODO:
    }
}