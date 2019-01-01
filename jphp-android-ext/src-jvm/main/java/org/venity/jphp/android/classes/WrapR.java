package org.venity.jphp.android.classes;

import org.venity.jphp.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseObject;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("R")
@Reflection.Namespace(AndroidExtension.NS)
public class WrapR extends BaseObject {

    public WrapR(Environment env) {
        super(env);
    }

    protected WrapR(ClassEntity entity) {
        super(entity);
    }

    public WrapR(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public static int string(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$string").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int xml(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$xml").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int style(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$style").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int raw(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$raw").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int plurals(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$plurals").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int mipmap(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$mipmap").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int menu(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$menu").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int layout(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$layout").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int interpolator(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$interpolator").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int integer(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$integer").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int fraction(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$fraction").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int id(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$id").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int drawable(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$drawable").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int color(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$color").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int attr(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$attr").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int array(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$array").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int animator(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$animator").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int anim(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$anim").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int dimen(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$dimen").getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int bool(String name) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        return Class.forName("org.venity.jphp.android.R$bool").getField(name).getInt(null);
    }
}