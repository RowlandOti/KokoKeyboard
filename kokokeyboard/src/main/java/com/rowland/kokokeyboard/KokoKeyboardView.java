package com.rowland.kokokeyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.HashMap;

public class KokoKeyboardView extends ExpandableRelativeLayout {

    private EditText mActiveEditField;
    private HashMap<EditText, KeyboardLayout> keyboards;
    private KeyboardManager.KeyboardListener keyboardListener;

    public KokoKeyboardView(Context context) {
        super(context);
        init();
    }

    public KokoKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public KokoKeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected void init() {
        keyboardListener = new KeyboardManager.KeyboardListener() {
            @Override
            public void characterClicked(char c) {

            }

            @Override
            public void specialKeyClicked(int keyCode) {
                switch (keyCode) {
                    case KeyboardManager.KEYCODE_BACKSPACE:
                        // Handle Backspace key
                        break;
                    case KeyboardManager.KEYCODE_SPACE:
                        // ToDo: Handle Space key
                        break;
                    case KeyboardManager.KEYCODE_DONE:
                        // ToDo: Handle Done key
                        break;
                }
            }
        };

        setListener(new ExpandableLayoutListenerAdapter() {
            @Override
            public void onOpened() {
                super.onOpened();
            }

            @Override
            public void onClosed() {
                super.onClosed();
            }
        });
    }
}
