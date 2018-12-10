package org.venity.jphp.android;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.res.AssetManager;
import php.runtime.Memory;
import php.runtime.env.Environment;
import php.runtime.env.TraceInfo;
import php.runtime.exceptions.CriticalException;
import php.runtime.ext.core.classes.WrapClassLoader;
import php.runtime.ext.support.Extension;
import php.runtime.launcher.LaunchException;
import php.runtime.loader.StandaloneLoader;
import php.runtime.reflection.ClassEntity;
import php.runtime.reflection.support.ReflectionUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.ServiceLoader;

public class AndroidStandaloneLoader extends StandaloneLoader {
    public static final AndroidStandaloneLoader INSTANCE;

    private Activity mainActivity;
    private Context context;

    public AndroidStandaloneLoader() {
        super();
    }

    public void run(Activity mainActivity) {
        this.mainActivity = mainActivity;

        try {
            this.setClassLoader(this.getClass().getClassLoader());
            this.loadLibrary();
            this.run();
        } catch (IOException e) {

        }
    }

    @Override
    public void loadExtensions() {
        ServiceLoader<Extension> loader = ServiceLoader.load(Extension.class, this.getClass().getClassLoader());
        Iterator var2 = loader.iterator();

        while(var2.hasNext()) {
            Extension extension = (Extension) var2.next();
            System.out.println("Register jPHP Extension: " + extension.getName() + " [" + extension.getVersion() + "]");
            this.scope.registerExtension(extension);
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

    public void setMainActivity(Activity activity) {
        INSTANCE.mainActivity = activity;
    }

    public static Activity getMainActivity() {
        return INSTANCE.mainActivity;
    }

    public static Environment getEnvironment() {
        return INSTANCE == null ? null : INSTANCE.env;
    }

    public static Context getContext() {
        return INSTANCE.mainActivity.getApplicationContext();
    }

    static {
        INSTANCE = new AndroidStandaloneLoader();
    }
}
