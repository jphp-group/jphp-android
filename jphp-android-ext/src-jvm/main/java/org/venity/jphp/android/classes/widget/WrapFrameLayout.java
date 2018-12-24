package org.venity.jphp.android.classes.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import org.venity.jphp.android.AndroidExtension;
import org.venity.jphp.android.classes.view.WrapViewGroup;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("FrameLayout")
@Reflection.Namespace(AndroidExtension.WIDGET_NS)
public class WrapFrameLayout extends WrapViewGroup {
    public WrapFrameLayout(Environment env, FrameLayout wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapFrameLayout(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public FrameLayout getWrappedObject() {
        return (FrameLayout) super.getWrappedObject();
    }

    @Override
    @Reflection.Signature
    public void __construct(Context activity) {
        __wrappedObject = new FrameLayout(activity);
        __wrappedObject.setId(idCounter.getAndIncrement());
    }

    public interface WrappedInterface {
        @Reflection.Property int foregroundGravity();
    }
}