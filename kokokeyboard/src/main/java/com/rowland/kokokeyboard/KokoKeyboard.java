package com.rowland.kokokeyboard;


import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.inputmethodservice.Keyboard;

public class KokoKeyboard extends Keyboard {


    public KokoKeyboard(Context context, int xmlLayoutResId) {
        super(context, xmlLayoutResId);
    }
}
