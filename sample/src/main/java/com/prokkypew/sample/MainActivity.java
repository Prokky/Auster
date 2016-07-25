package com.prokkypew.sample;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;
import android.widget.Toast;

import com.prokkypew.auster.MvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends MvpActivity<MainMvpPresenter> implements MainMvpView {
    private ProgressDialog progressDialog;
    private Unbinder unbinder;

    @BindView(R.id.ip_text)
    TextView ipTextView;

    @OnClick(R.id.button_get_ip)
    void onGetIpClick() {
        ipTextView.setText("");
        presenter.loadIp();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    @NonNull
    @Override
    protected MainMvpPresenter getPresenter() {
        return new MainMvpPresenter();
    }

    @Override
    public void onError(int errorCode, String errorText) {
        Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setProgress(boolean visible) {
        if (visible) {
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(this);
                progressDialog.setCancelable(false);
            }
            progressDialog.show();
        } else {
            if (progressDialog != null && progressDialog.isShowing())
                progressDialog.hide();
        }
    }

    @Override
    public void onIpLoaded(String text) {
        ipTextView.setText(text);
    }
}
