package org.venity.jphp.android.classes.app;

import android.app.Activity;
import android.app.Application;
import org.venity.jphp.android.AndroidExtension;
import org.venity.jphp.android.AndroidStandaloneLoader;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("Application")
@Reflection.Namespace(AndroidExtension.APP_NS)
public class WrapApplication extends BaseWrapper<Application> {
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
}