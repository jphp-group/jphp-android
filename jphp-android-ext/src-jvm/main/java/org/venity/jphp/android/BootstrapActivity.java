package org.venity.jphp.android;

import android.content.res.Configuration;
import android.os.Bundle;
import org.venity.jphp.android.classes.app.WrapApplication;
import org.venity.jphp.android.support.JPHPActivity;

public class BootstrapActivity extends JPHPActivity {

    private static final AndroidStandaloneLoader loader;
    private static boolean isRun;

    static {
        loader = AndroidStandaloneLoader.INSTANCE;
        isRun = false;
    }

    public BootstrapActivity() {
        super();

        if (!BootstrapActivity.isRun) {
            System.out.println("Starting jPHP ...");
            BootstrapActivity.isRun = true;
            loader.run(this);
        } else {
            System.out.println("Updating main activity ...");
            loader.setMainActivity(this);
            WrapApplication.updateActivity(AndroidStandaloneLoader.getEnvironment());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("Updating main activity ...");
        loader.setMainActivity(this);
        WrapApplication.updateActivity(AndroidStandaloneLoader.getEnvironment());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        System.out.println("Updating main activity ...");
        loader.setMainActivity(this);
        WrapApplication.updateActivity(AndroidStandaloneLoader.getEnvironment());
    }
}