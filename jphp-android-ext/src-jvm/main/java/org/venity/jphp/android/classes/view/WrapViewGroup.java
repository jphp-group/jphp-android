package org.venity.jphp.android.classes.view;

import android.view.View;
import android.view.ViewGroup;
import org.venity.jphp.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("ViewGroup")
@Reflection.Namespace(AndroidExtension.VIEW_NS)
public class WrapViewGroup extends WrapView {
    public WrapViewGroup(Environment env, ViewGroup wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapViewGroup(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public ViewGroup getWrappedObject() {
        return (ViewGroup) super.getWrappedObject();
    }

    @Reflection.Signature
    public void addView(View view)
    {
        getWrappedObject().addView(view);
    }

    @Reflection.Signature
    public void addView(View view, int index)
    {
        getWrappedObject().addView(view, index);
    }

    @Reflection.Signature
    public void addView(View view, int width, int height)
    {
        getWrappedObject().addView(view, width, height);
    }
}
