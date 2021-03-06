package com.example.tr.myapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tr.myapplication.MyApplication;
import com.example.tr.myapplication.R;
import com.example.tr.myapplication.view.mvp.MainActivityPresenter;
import com.example.tr.myapplication.view.mvp.view.IMainActivityView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements IMainActivityView {

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ((MyApplication) getApplication())
                .getAppComponent()
                .inject(MainActivity.this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start();
        presenter.setView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    public void onPause() {
        presenter.pause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        presenter.stop();
        super.onStop();
    }

    @Override
    public void showResultsFromJob(long time) {

    }


}
