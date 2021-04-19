package com.xici.library.simpletipdialog;

import android.graphics.Color;

public class BuilderFactory {

    public static SimpleTipDialog.Builder newSucessBuilder() {
        return SimpleTipDialog.Builder.builder()
                .title("Suceess Tip")
                .mainTip("BuilderFactory.newSucessBuilder")
                .showLeftBtn(false)
                .rightBtnTxt("Close")
                .rightBtnColor(Color.WHITE)
                .rightBtnBgColor(0xff009933).build();
    }

    public static SimpleTipDialog.Builder newWarnBuilder() {
        return SimpleTipDialog.Builder.builder()
                .title("Warn Tip")
                .mainTip("BuilderFactory.newWarnBuilder")
                .showLeftBtn(false)
                .rightBtnTxt("Close")
                .rightBtnColor(Color.WHITE)
                .rightBtnBgColor(0xffFF9900).build();
    }

    public static SimpleTipDialog.Builder newInfoBuilder() {
        return SimpleTipDialog.Builder.builder()
                .title("Info Tip")
                .mainTip("BuilderFactory.newInfoBuilder")
                .showLeftBtn(false)
                .rightBtnTxt("Close")
                .rightBtnColor(Color.WHITE)
                .rightBtnBgColor(0xff0099FF).build();
    }

    public static SimpleTipDialog.Builder newErrorBuilder() {
        return SimpleTipDialog.Builder.builder()
                .title("Error Tip")
                .mainTip("BuilderFactory.newErrorBuilder")
                .showLeftBtn(false)
                .rightBtnTxt("Close")
                .rightBtnColor(Color.WHITE)
                .rightBtnBgColor(Color.RED).build();
    }

}
