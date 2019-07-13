package org.venity.jphp.ext.android.fx.classes;

import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.ext.java.JavaException;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("JSException")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class WrapJSException extends JavaException {
    public WrapJSException(Environment env, Throwable throwable) {
        super(env, throwable);
    }

    public WrapJSException(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }
}