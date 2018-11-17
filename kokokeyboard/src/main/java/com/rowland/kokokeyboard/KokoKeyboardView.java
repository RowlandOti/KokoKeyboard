package com.rowland.kokokeyboard;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.view.WindowManager;

public class KokoKeyboardView extends KeyboardView {

    public KokoKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KokoKeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        //this.setOnKeyboardActionListener(new );
        // Hide stock keyboard
        ((Activity) getContext()).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

}
