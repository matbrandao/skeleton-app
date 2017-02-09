/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.mat_brandao.skeleton.domain.di.module;

import android.app.Activity;
import android.content.Context;

import com.mat_brandao.skeleton.domain.di.ActivityContext;
import com.mat_brandao.skeleton.domain.di.PerActivity;
import com.mat_brandao.skeleton.view.login.LoginInteractor;
import com.mat_brandao.skeleton.view.login.LoginInteractorImpl;
import com.mat_brandao.skeleton.view.login.LoginPresenter;
import com.mat_brandao.skeleton.view.login.LoginPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @PerActivity
    LoginPresenter provideLoginPresenter(LoginPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginInteractor provideLoginInteractor(LoginInteractorImpl interactor) {
        return interactor;
    }
//
//    @Provides
//    UserRepository provideUserRepository(UserRepositoryImpl interactor) {
//        return interactor;
//    }

//    @Provides
//    @PerActivity
//    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
//        return presenter;
//    }
}
