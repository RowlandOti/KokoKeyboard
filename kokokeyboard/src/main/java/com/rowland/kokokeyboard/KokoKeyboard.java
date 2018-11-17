package com.rowland.kokokeyboard;


import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.inputmethodservice.Keyboard;

public class KokoKeyboard extends Keyboard {

    public KokoKeyboard(Context context, int xmlLayoutResId) {
        super(context, xmlLayoutResId);
    }

    public KokoKeyboard(Context context, int xmlLayoutResId, int modeId, int width, int height) {
        super(context, xmlLayoutResId, modeId, width, height);
    }

    public KokoKeyboard(Context context, int xmlLayoutResId, int modeId) {
        super(context, xmlLayoutResId, modeId);
    }

    public KokoKeyboard(Context context, int layoutTemplateResId, CharSequence characters, int columns, int horizontalPadding) {
        super(context, layoutTemplateResId, characters, columns, horizontalPadding);
    }

    class KokoKey extends Key {

        public KokoKey(Row parent) {
            super(parent);
        }

        public KokoKey(Resources res, Row parent, int x, int y, XmlResourceParser parser) {
            super(res, parent, x, y, parser);
        }
    }
}
