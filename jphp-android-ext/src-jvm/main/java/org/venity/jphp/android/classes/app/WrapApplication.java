package org.venity.jphp.android.classes.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import org.venity.jphp.android.AndroidExtension;
import org.venity.jphp.android.AndroidStandaloneLoader;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

import java.io.File;

@Reflection.Name("Application")
@Reflection.Namespace(AndroidExtension.APP_NS)
public class WrapApplication extends BaseWrapper<Application> {

    private static Invoker mainActivityHandler;

    public WrapApplication(Environment env, Application wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapApplication(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public static Activity getMainActivity()
    {
        return AndroidStandaloneLoader.getMainActivity();
    }

    @Reflection.Signature
    public static Context getContext() {
        try {
            return AndroidStandaloneLoader.getContext().getApplicationContext();
        } catch (NullPointerException e) {
            return getMainActivity();
        }
    }

    @Reflection.Signature
    public static void setMainActivityHandler(Invoker callback) {
        mainActivityHandler = callback;
    }

    public static void updateActivity(Environment environment) {
        try {
            if (mainActivityHandler != null) {
                System.out.println("Calling invoker from setMainActivityHandler ...");
                mainActivityHandler.call(Memory.wrap(environment, getMainActivity()));
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Reflection.Signature
    public static File getFilesDir() {
        return getMainActivity().getFilesDir();
    }
}