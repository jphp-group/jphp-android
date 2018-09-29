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
    public static int string(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.string.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int xml(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.xml.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int style(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.style.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int raw(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.raw.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int plurals(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.plurals.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int mipmap(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.mipmap.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int menu(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.menu.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int layout(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.layout.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int interpolator(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.interpolator.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int integer(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.interpolator.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int fraction(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.fraction.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int id(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.id.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int drawable(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.drawable.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int color(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.color.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int attr(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.attr.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int array(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.array.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int animator(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.animator.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int anim(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.anim.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int dimen(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.dimen.class.getField(name).getInt(null);
    }

    @Reflection.Signature
    public static int bool(String name) throws NoSuchFieldException, IllegalAccessException {
        return android.R.bool.class.getField(name).getInt(null);
    }
}
