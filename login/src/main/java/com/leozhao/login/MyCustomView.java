package com.leozhao.login;

import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface MyCustomView extends MvpView {


    void onLoginResult(String result);

}