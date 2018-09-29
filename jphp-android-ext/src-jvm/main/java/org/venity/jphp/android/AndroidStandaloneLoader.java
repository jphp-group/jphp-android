package org.venity.jphp.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import php.runtime.Memory;
import php.runtime.env.Environment;
import php.runtime.env.TraceInfo;
import php.runtime.exceptions.CriticalException;
import php.runtime.ext.core.classes.WrapClassLoader;
import php.runtime.launcher.LaunchException;
import php.runtime.loader.StandaloneLoader;
import php.runtime.reflection.ClassEntity;
import php.runtime.reflection.support.ReflectionUtils;

import java.io.IOException;

public class AndroidStandaloneLoader extends StandaloneLoader {
    public static final AndroidStandaloneLoader INSTANCE;

    protected Activity mainActivity;
    protected AssetManager assetManager;

    public AndroidStandaloneLoader() {
        super();
    }

    public void run(Activity mainActivity) {
        this.mainActivity = mainActivity;
        this.assetManager = mainActivity.getAssets();

        try {
            super.setClassLoader(mainActivity.getClassLoader());
            super.loadLibrary();
            this.run();
        } catch (IOException e) {

        }
    }

    public void run() {
        this.readConfig();
        String classLoader = super.config.getProperty("env.classLoader", ReflectionUtils.getClassName(WrapClassLoader.WrapLauncherClassLoader.class));
        if (classLoader != null && !classLoader.isEmpty()) {
            ClassEntity classLoaderEntity = this.env.fetchClass(classLoader);
            if (classLoaderEntity == null) {
                throw new LaunchException("Class loader class is not found: " + classLoader);
            }

            try {
                WrapClassLoader loader = (WrapClassLoader)classLoaderEntity.newObject(this.env, TraceInfo.UNKNOWN, true, new Memory[0]);
                this.env.invokeMethod(loader, "register", new Memory[]{Memory.TRUE});
            } catch (Throwable var4) {
                throw new CriticalException(var4);
            }
        }

        super.run("index.php");
    }

    public static Activity getMainActivity() {
        return INSTANCE.mainActivity;
    }

    public static Context getContext() {
        return INSTANCE.mainActivity.getApplicationContext();
    }

    public static Environment getEnvironment() {
        return INSTANCE == null ? null : INSTANCE.env;
    }

    static {
        INSTANCE = new AndroidStandaloneLoader();
    }
}
