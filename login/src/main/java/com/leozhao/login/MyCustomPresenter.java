package com.leozhao.login;

import android.util.Log;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import org.greenrobot.eventbus.EventBus;

public class MyCustomPresenter extends MvpBasePresenter<MyCustomView> {
    private static final String TAG = "zztest";
    String result="failure";
    public MyCustomPresenter() {
        Log.d(TAG, "MyCustomPresenter: ");
    }

    public void doLogin() {
        Log.d(TAG, "doLogin: ");
        new Thread(()->{
            try{
                Thread.sleep(10000);
                result = "success";
                Log.d(TAG, "doLogin: done");
                if (isViewAttached()) {
                    getView().onLoginResult(result);
                }
            }catch (Exception e){

            }

        }).start();




    }

}
