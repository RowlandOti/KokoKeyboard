package com.rowland.keyboard;

import android.os.Bundle;

import com.rowland.keyboard.sample.R;
import com.rowland.kokokeyboard.keypad.KokoKeyboardView;

import androidx.appcompat.app.AppCompatActivity;

public class KeyboardActivity extends AppCompatActivity {

    private KokoKeyboardView keyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);

        keyboard = findViewById(R.id.keyboardview);
        keyboard.registerEditText(KokoKeyboardView.INPUT_TYPE_QWERTY_NUM, findViewById(R.id.input_text));
        keyboard.registerEditText(KokoKeyboardView.INPUT_TYPE_QWERTY, findViewById(R.id.input_text_non_num));
    }

    @Override
    public void onBackPressed() {
        if (keyboard.isExpanded()) {
            keyboard.toggle();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        keyboard.unregisterEditText(findViewById(R.id.input_text));
        keyboard.unregisterEditText(findViewById(R.id.input_text_non_num));
    }
}
