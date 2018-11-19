package com.rowland.keyboard;

import android.os.Bundle;
import android.widget.EditText;

import com.rowland.keyboard.sample.R;
import com.rowland.kokokeyboard.keypad.KokoKeyboardView;

import androidx.appcompat.app.AppCompatActivity;

public class KeyboardActivity extends AppCompatActivity {

    private KokoKeyboardView keyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);

        EditText qwertyEditText = findViewById(R.id.input_text);
        EditText qwertyNonNumEditText = findViewById(R.id.input_text_non_num);

        keyboard = findViewById(R.id.keyboardview);
        keyboard.registerEditText(KokoKeyboardView.INPUT_TYPE_QWERTY_NUM, qwertyEditText);
        keyboard.registerEditText(KokoKeyboardView.INPUT_TYPE_QWERTY, qwertyNonNumEditText);
    }

    @Override
    public void onBackPressed() {
        if (keyboard.isExpanded()) {
            keyboard.toggle();
        } else {
            super.onBackPressed();
        }
    }
}
