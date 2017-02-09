package com.mat_brandao.skeleton.view;

import android.app.Application;

import com.mat_brandao.skeleton.domain.di.component.ApplicationComponent;
import com.mat_brandao.skeleton.domain.di.component.DaggerApplicationComponent;
import com.mat_brandao.skeleton.domain.di.module.ApplicationModule;

/**
 * Created by Mateus Brandão on 09-Feb-17.
 */

public class App extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
