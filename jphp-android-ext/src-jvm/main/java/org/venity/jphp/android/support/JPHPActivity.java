package org.venity.jphp.android.support;

import android.app.Activity;
import android.os.Bundle;

public class JPHPActivity extends Activity {

    public Runnable onCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (onCreate != null)
            onCreate.run();
    }
}
