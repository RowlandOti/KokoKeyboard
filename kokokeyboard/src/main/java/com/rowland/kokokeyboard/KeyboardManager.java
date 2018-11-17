package com.rowland.kokokeyboard;

import android.view.inputmethod.InputConnection;

import java.util.List;

public class KeyboardManager {

    public static final int KEYCODE_BACKSPACE = -1;
    public static final int KEYCODE_MODE_CHANGE = -2;
    public static final int KEYCODE_SPACE = -3;
    public static final int KEYCODE_DONE = -4;

    private int cursorPosition = 0;
    private String inputText = "";

    private List<KeyboardListener> listeners;
    private InputConnection inputConnection;

    public interface KeyboardListener {
        void characterClicked(char c);
        void specialKeyClicked(int keyCode);
    }

    public KeyboardManager(InputConnection inputConnection) {
        this.inputConnection = inputConnection;
    }

    protected void handleKeyStroke(int key) {
        switch (key) {
            case KEYCODE_BACKSPACE:
                if (cursorPosition == 0)
                    return;
                inputConnection.deleteSurroundingText(1, 0);
                StringBuilder builder = new StringBuilder(this.inputText);
                inputText = builder.deleteCharAt(--cursorPosition).toString();
                break;
            case KEYCODE_SPACE :
                this.handleKeyStroke(' ');
                break;
            case KEYCODE_DONE:
                // ToDo: Process action to view
            default:
                break;
        }
    }

    protected void handleKeyStroke(char c) {
        inputConnection.commitText(Character.toString(c), 1);

        if (cursorPosition++ >= inputText.length()) {
            inputText = inputText + c;
        } else {
            inputText = inputText.substring(0, cursorPosition - 1) + c + inputText.substring(cursorPosition - 1);
        }
    }

    protected void onKeyStroke(char c) {
        CharSequence beforeText = inputConnection.getTextBeforeCursor(100, 0).toString();
        CharSequence afterText = inputConnection.getTextAfterCursor(100, 0).toString();
        cursorPosition = beforeText.length();
        inputText = beforeText.toString() + afterText.toString();

        handleKeyStroke(c);
        for (KeyboardListener listener : listeners) {
            listener.characterClicked(c);
        }
    }


    protected void onKeyStroke(int keyCode) {
        CharSequence beforeText = inputConnection.getTextBeforeCursor(100, 0).toString();
        CharSequence afterText = inputConnection.getTextAfterCursor(100, 0).toString();
        cursorPosition = beforeText.length();
        inputText = beforeText.toString() + afterText.toString();

        handleKeyStroke(keyCode);
        for (KeyboardListener listener : listeners) {
            listener.specialKeyClicked(keyCode);
        }
    }

    public void registerListener(KeyboardListener listener) {
        listeners.add(listener);
    }
}
