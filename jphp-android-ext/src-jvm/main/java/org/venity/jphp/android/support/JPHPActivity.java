package org.venity.jphp.android.support;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;

public class JPHPActivity extends Activity {

    public Runnable onCreate;

    public KeyEventCallback onKeyDown;
    public KeyEventCallback onKeyUp;
    public KeyEventCallback onKeyLongPress;
    public KeyEventCallback onKeyMultiple;
    public KeyEventCallback onKeyShortcut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (onCreate != null)
            onCreate.run();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (onKeyDown != null)
            return onKeyDown.pres(keyCode);

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (onKeyUp != null)
            return onKeyUp.pres(keyCode);

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (onKeyLongPress != null)
            return onKeyLongPress.pres(keyCode);

        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        if (onKeyMultiple != null)
            return onKeyMultiple.pres(keyCode);

        return super.onKeyMultiple(keyCode, repeatCount, event);
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        if (onKeyShortcut != null)
            return onKeyShortcut.pres(keyCode);

        return super.onKeyShortcut(keyCode, event);
    }

    public interface KeyEventCallback {
        boolean pres(int keyCode);
    }
}
