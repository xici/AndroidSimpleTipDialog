package com.xici.library.simpletipdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xici.library.simpletipdialog.util.SimpleTipDialogUtil;

import lombok.Data;

public class SimpleTipDialog extends Dialog {

    private SimpleTipDialog dialog;
    private Builder builder;

    private TextView title;
    private TextView mainTip;
    private TextView subTip;
    private Button leftBtn;
    private View sepLine;
    private Button rightBtn;
    private LinearLayout closeBtn;

    public SimpleTipDialog(@NonNull Context context, Builder builder) {
        super(context);
        if (null == builder) {
            builder = Builder.builder().build();
        }
        this.builder = builder;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_simple_tip);
        dialog = this;
        initComponent();
    }

    private void initComponent() {
        title = findViewById(R.id.title);
        mainTip = findViewById(R.id.mainTip);
        subTip = findViewById(R.id.subTip);
        leftBtn = findViewById(R.id.leftBtn);
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != builder.leftClickListener) {
                    builder.leftClickListener.onClick(dialog);
                } else {
                    dismiss();
                }
            }
        });
        sepLine = findViewById(R.id.sepLine);
        rightBtn = findViewById(R.id.rightBtn);
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != builder.rightClickListener) {
                    builder.rightClickListener.onClick(dialog);
                } else {
                    dismiss();
                }
            }
        });
        closeBtn = findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        setCancelable(builder.cancelable);
        setCanceledOnTouchOutside(builder.canceledOnTouchOutside);
        if (SimpleTipDialogUtil.isNotBlank(builder.title)) {
            title.setText(builder.title);
        }
        if (builder.titleColor > 0) {
            title.setTextColor(builder.titleColor);
        }
        if (SimpleTipDialogUtil.isNotBlank(builder.mainTip)) {
            mainTip.setText(builder.mainTip);
        }
        if (builder.mainTipColor != 0) {
            mainTip.setTextColor(builder.mainTipColor);
        }
        if (SimpleTipDialogUtil.isNotBlank(builder.subTip)) {
            subTip.setText(builder.subTip);
            if (builder.subTipClor != 0) {
                subTip.setTextColor(builder.subTipClor);
            }
        } else {
            subTip.setVisibility(View.GONE);
        }
        if (SimpleTipDialogUtil.isNotBlank(builder.leftBtnTxt)) {
            leftBtn.setText(builder.leftBtnTxt);
        }
        if (builder.leftBtnColor != 0) {
            leftBtn.setTextColor(builder.leftBtnColor);
        }
        if (builder.leftBtnBgColor != 0) {
            leftBtn.setBackgroundColor(builder.leftBtnBgColor);
        }
        if (SimpleTipDialogUtil.isNotBlank(builder.rightBtnTxt)) {
            rightBtn.setText(builder.rightBtnTxt);
        }
        if (builder.rightBtnColor != 0) {
            rightBtn.setTextColor(builder.rightBtnColor);
        }
        if (builder.rightBtnBgColor != 0) {
            rightBtn.setBackgroundColor(builder.rightBtnBgColor);
        }
        if (builder.showLeftBtn) {
            leftBtn.setVisibility(View.VISIBLE);
            sepLine.setVisibility(View.VISIBLE);
        } else {
            leftBtn.setVisibility(View.GONE);
            sepLine.setVisibility(View.GONE);
        }
        if (builder.showCloseBtn) {
            closeBtn.setVisibility(View.VISIBLE);
        } else {
            closeBtn.setVisibility(View.GONE);
        }
    }

    @Data
    @lombok.Builder
    public static class Builder {
        private String title;
        private int titleColor;
        private String mainTip;
        private int mainTipColor;
        private String subTip;
        private int subTipClor;
        private String leftBtnTxt;
        private int leftBtnBgColor;
        private int leftBtnColor;
        private OnClickListener leftClickListener;
        private String rightBtnTxt;
        private int rightBtnBgColor;
        private int rightBtnColor;
        private OnClickListener rightClickListener;
        @lombok.Builder.Default
        private boolean showLeftBtn = true;
        @lombok.Builder.Default
        private boolean showCloseBtn = true;
        @lombok.Builder.Default
        private boolean cancelable = true;
        @lombok.Builder.Default
        private boolean canceledOnTouchOutside = true;
    }

    public interface OnClickListener {

        void onClick(SimpleTipDialog dialog);

    }

}
