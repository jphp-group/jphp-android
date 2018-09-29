package org.venity.jphp.android;

import android.app.Notification;
import android.app.NotificationManager;
import org.venity.jphp.android.classes.WrapR;
import php.runtime.env.CompileScope;
import php.runtime.ext.support.Extension;

public class AndroidExtension extends Extension {
    public static final String NS = "php\\android";
    
    @Override
    public Status getStatus() {
        return Status.EXPERIMENTAL;
    }

    @Override
    public String getName() {
        return "JPHP for Android";
    }

    @Override
    public String getVersion() {
        return "2.0 " + getStatus().toString();
    }

    @Override
    public void onRegister(CompileScope scope) {
        System.out.println("JPHP for android version: " + getVersion());

        registerClass(scope, WrapR.class);
    }
}