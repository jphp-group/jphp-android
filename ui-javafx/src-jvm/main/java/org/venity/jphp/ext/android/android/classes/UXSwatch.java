package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.visual.Swatch;
import org.venity.jphp.ext.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseObject;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXSwatch")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXSwatch extends BaseWrapper<Swatch> {

    public UXSwatch(Environment env, Swatch wrappedObject) {
        super(env, wrappedObject);
    }

    public UXSwatch(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public static Swatch of(String color){
        return Swatch.valueOf(color.toUpperCase());
    }
}
