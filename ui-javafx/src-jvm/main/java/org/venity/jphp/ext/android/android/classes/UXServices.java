package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.down.Services;
import org.venity.jphp.ext.android.AndroidExtension;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.ext.java.JavaException;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

import java.util.Optional;

@Reflection.Name("UXServices")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXServices extends BaseWrapper<Services> {
    public UXServices(Environment env, Services wrappedObject) {
        super(env, wrappedObject);
    }

    public UXServices(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public static Memory get(Environment __env__, String className) {
        Optional opt = Optional.empty();

        try {
            opt = Services.get(Class.forName(className));
        } catch (ClassNotFoundException exeption) {
            __env__.__throwException(new JavaException(__env__, exeption));
        }

        if (opt != null && opt.isPresent())
            return Memory.wrap(__env__, opt.get());
        else return Memory.UNDEFINED;
    }
}
