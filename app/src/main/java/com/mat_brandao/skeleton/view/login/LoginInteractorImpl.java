package com.mat_brandao.skeleton.view.login;

import android.content.Context;

import com.mat_brandao.skeleton.domain.di.ActivityContext;
import com.mat_brandao.skeleton.domain.repository.UserRepositoryImpl;

import javax.inject.Inject;

public class LoginInteractorImpl implements LoginInteractor {

    private final Context mContext;

    @Inject
    UserRepositoryImpl mUserRepository;

    @Inject
    public LoginInteractorImpl(@ActivityContext Context context) {
        mContext = context;
//        mUserRepository = new UserRepositoryImpl();
    }
}