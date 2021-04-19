package com.xici.library.androidsimpletipdialog;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xici.library.simpletipdialog.BuilderFactory;
import com.xici.library.simpletipdialog.SimpleTipDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Context context;

    Button defaultDialog;
    Button successDialog;
    Button infoDialog;
    Button warnDialog;
    Button errorDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
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
                new SimpleTipDialog(context, SimpleTipDialog.Builder.builder().build()).show();
                break;
            case R.id.successDialog:
                new SimpleTipDialog(context, BuilderFactory.newSucessBuilder()).show();
                break;
            case R.id.infoDialog:
                new SimpleTipDialog(context, BuilderFactory.newInfoBuilder()).show();
                break;
            case R.id.warnDialog:
                new SimpleTipDialog(context, BuilderFactory.newWarnBuilder()).show();
                break;
            case R.id.errorDialog:
                new SimpleTipDialog(context, BuilderFactory.newErrorBuilder()).show();
                break;
        }
    }

    private void test() {
        SimpleTipDialog.Builder builder = SimpleTipDialog.Builder.builder()
                .title("Your title")
                .mainTip("Main tip message")
                .subTip("Sub tip message")
                .leftBtnTxt("Left btn")
                .rightBtnTxt("Right Btn")
                .leftClickListener(new SimpleTipDialog.OnClickListener() {
                    @Override
                    public void onClick(SimpleTipDialog dialog) {
                        //your code,do not forget call dismisss();
                        dialog.dismiss();
                    }
                })
                .rightClickListener(new SimpleTipDialog.OnClickListener() {
                    @Override
                    public void onClick(SimpleTipDialog dialog) {
                        //your code,do not forget call dismisss();
                        dialog.dismiss();
                    }
                })
                .build();
        SimpleTipDialog dialog = new SimpleTipDialog(context, builder);
        dialog.show();
    }

}
