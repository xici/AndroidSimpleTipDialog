package com.xici.library.androidsimpletipdialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xici.library.simpletipdialog.BuilderFactory;
import com.xici.library.simpletipdialog.SimpleTipDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Activity activity;

    Button defaultDialog;
    Button successDialog;
    Button infoDialog;
    Button warnDialog;
    Button errorDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        defaultDialog = findViewById(R.id.defaultDialog);
        defaultDialog.setOnClickListener(this);
        successDialog = findViewById(R.id.successDialog);
        successDialog.setOnClickListener(this);
        infoDialog = findViewById(R.id.infoDialog);
        infoDialog.setOnClickListener(this);
        warnDialog = findViewById(R.id.warnDialog);
        warnDialog.setOnClickListener(this);
        errorDialog = findViewById(R.id.errorDialog);
        errorDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.defaultDialog:
                new SimpleTipDialog(activity, SimpleTipDialog.Builder.builder().build()).show();
                break;
            case R.id.successDialog:
                new SimpleTipDialog(activity, BuilderFactory.newSucessBuilder()).show();
                break;
            case R.id.infoDialog:
                new SimpleTipDialog(activity, BuilderFactory.newInfoBuilder()).show();
                break;
            case R.id.warnDialog:
                new SimpleTipDialog(activity, BuilderFactory.newWarnBuilder()).show();
                break;
            case R.id.errorDialog:
                new SimpleTipDialog(activity, BuilderFactory.newErrorBuilder()).show();
                break;
        }
    }

}
