package com.rowland.kokokeyboard.keypad;

import android.app.Activity;
import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.rowland.kokokeyboard.R;
import com.rowland.kokokeyboard.layouts.KeyboardLayout;
import com.rowland.kokokeyboard.manager.KeyboardManager;

import java.util.HashMap;

public class KokoKeyboardView extends ExpandableRelativeLayout {

    public static final int INPUT_TYPE_NUM = -10;
    public static final int INPUT_TYPE_QWERTY = -20;

    private EditText activeEditField;
    private HashMap<EditText, KeyboardLayout> keyboards = new HashMap<>();
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
                        collapse();
                        break;
                }
            }
        };

        setListener(new ExpandableLayoutListenerAdapter() {
            @Override
            public void onOpened() {
                super.onOpened();
                // ToDo: Do something creative
            }

            @Override
            public void onClosed() {
                super.onClosed();
                // ToDo: Do something creative
            }
        });
    }

    public void registerEditText(int type, final EditText field) {
        if (!field.isEnabled()) {
            return;
        }
        field.setRawInputType(InputType.TYPE_CLASS_TEXT);
        field.setShowSoftInputOnFocus(false);
        field.setSoundEffectsEnabled(false);
        field.setLongClickable(false);

        InputConnection inputConnection = field.onCreateInputConnection(new EditorInfo());
        KeyboardLayout keyboard = generateCorrectKeyboard(type, inputConnection);

        keyboards.put(field, keyboard);
        keyboards.get(field).registerListener(keyboardListener);

        field.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(field.getWindowToken(), 0);

                    activeEditField = field;
                    removeAllViews();

                    KeyboardLayout keyboard = keyboards.get(activeEditField);
                    addView(keyboard);

                    if (!isExpanded()) {
                        toggle();
                    }
                } else {
                    if (isExpanded()) {
                        for (EditText editText : keyboards.keySet()) {
                            if (editText.hasFocus()) {
                                return;
                            }
                        }
                        toggle();
                    }
                }
            }
        });

        field.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isExpanded()) {
                    toggle();
                }
            }
        });
    }

    public void unregisterEditText(EditText field) {
        keyboards.remove(field);
    }

    private KeyboardLayout generateCorrectKeyboard(int type, InputConnection ic) {
        KeyboardLayout keypad = new KeyboardLayout(getContext(), new KeyboardManager(ic));
        View view;

        switch (type) {
            case INPUT_TYPE_NUM:
                view = LayoutInflater.from(getContext()).inflate(R.layout.qwerty_keypad, null);
                keypad.addView(view);
                return keypad;
            case INPUT_TYPE_QWERTY:
                view = LayoutInflater.from(getContext()).inflate(R.layout.qwerty_keypad, null);
                keypad.addView(view);
                return keypad;
            default:
                view = LayoutInflater.from(getContext()).inflate(R.layout.qwerty_keypad, null);
                keypad.addView(view);
                return keypad;
        }
    }
}
