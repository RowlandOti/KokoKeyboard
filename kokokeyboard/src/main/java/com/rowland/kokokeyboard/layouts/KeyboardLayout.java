package com.rowland.kokokeyboard.layouts;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;


import com.rowland.kokokeyboard.manager.KeyboardManager;

import androidx.annotation.Nullable;

public class KeyboardLayout extends LinearLayout {

    private KeyboardManager keyboardManager;

    public KeyboardLayout(Context context, KeyboardManager keyboardManager) {
        super(context);
        this.keyboardManager = keyboardManager;
        init();
    }

    public KeyboardLayout(Context context, KeyboardManager keyboardManager, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.keyboardManager = keyboardManager;
        init();
    }

    private void init() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
        setOrientation(LinearLayout.VERTICAL);
    }

    public void registerListener(KeyboardManager.KeyboardListener listener) {
        keyboardManager.registerListener(listener);
    }
}
