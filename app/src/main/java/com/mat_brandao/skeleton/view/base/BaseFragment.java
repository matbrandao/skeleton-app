package com.mat_brandao.skeleton.view.base;

import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.mat_brandao.skeleton.R;
import com.mat_brandao.skeleton.domain.di.component.ActivityComponent;
import com.mat_brandao.skeleton.domain.di.component.DaggerActivityComponent;
import com.mat_brandao.skeleton.domain.di.module.ActivityModule;
import com.mat_brandao.skeleton.view.App;


/**
 * Created by Mateus Brandão on 04-Apr-16.
 */
public abstract class BaseFragment extends Fragment {

    private ProgressDialog mProgressDialog;
    private ActivityComponent mActivityComponent;

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        getPresenter().onPause();
    }

    @Override
    public void onDestroy() {
        getPresenter().onDestroy();
        super.onDestroy();
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//            setupWindowAnimations();
//        }
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(getActivity()))
                .applicationComponent(((App) getActivity().getApplication()).getComponent())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

//    @SuppressLint("NewApi")
//    private void setupWindowAnimations() {
//        Transition slideLeft = TransitionInflater.from(this).inflateTransition(android.R.transition.slide_left);
//        Transition slideRight = TransitionInflater.from(this).inflateTransition(android.R.transition.slide_right);
//        getActivity().getWindow().setExitTransition(slideLeft);
//        getWindow().setEnterTransition(slideRight);
//        getWindow().setBackgroundDrawable(new ColorDrawable(Color.DKGRAY));
//    }

    protected void showToast(String text) {
        Toast toast = Toast.makeText(getContext(), text, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    protected void goToActivity(Class<?> activity) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            try {
                startActivity(new Intent(getContext(), activity), ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
            } catch (Exception e) {
                startActivity(new Intent(getContext(), activity));
            }
        } else {
            startActivity(new Intent(getContext(), activity));
        }
    }

    protected void goToActivity(Intent intent) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
        } else {
            startActivity(intent);
        }
    }

    protected void showConnectionError(View coordinatorLayout, View.OnClickListener listener) {
        try {
            Snackbar.make(coordinatorLayout, getString(R.string.connection_error_snack), Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.connection_retry, listener)
                    .show();
        } catch (Exception e) {}
    }

    protected void showProgressDialog(Context context, String message) {
        if (mProgressDialog == null)
            mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(message);
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.setCancelable(true);
        mProgressDialog.show();
    }

    protected void dismissProgressDialog() {
        try {
            mProgressDialog.dismiss();
        } catch (Exception e) {}
    }

    protected abstract BasePresenter getPresenter();
}