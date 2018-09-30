package org.venity.jphp.android.classes.content;

import android.content.Context;
import org.venity.jphp.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Abstract
@Reflection.Name("Context")
@Reflection.Namespace(AndroidExtension.CONTENT_NS)
public class WrapContext extends BaseWrapper<Context> {
    public WrapContext(Environment env, Context wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapContext(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }
}
