package com.leozhao.login;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Route(path = "/test/activity")
public class LoginActivity extends MvpActivity<MyCustomView,MyCustomPresenter> implements MyCustomView {
    private static final String TAG = "zztest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.button1).setOnClickListener(view -> getPresenter().doLogin());
    }

    @NonNull
    @Override
    public MyCustomPresenter createPresenter() {
        return new MyCustomPresenter();
    }
    
    @Override
    public void onLoginResult(String result) {
        Log.d(TAG, "onLoginResult: ");
        runOnUiThread(()->((TextView)findViewById(R.id.textview)).setText(result));
    }
}