package org.venity.jphp.android.classes.widget;

import android.app.Activity;
import android.view.View;
import android.widget.GridLayout;
import org.venity.jphp.android.AndroidExtension;
import org.venity.jphp.android.classes.view.WrapViewGroup;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("GridLayout")
@Reflection.Namespace(AndroidExtension.WIDGET_NS)
public class WrapGridLayout extends WrapViewGroup {
    public WrapGridLayout(Environment env, GridLayout wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapGridLayout(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(Activity activity) {
        __wrappedObject = new GridLayout(activity);
        getWrappedObject().setId(idCounter.getAndIncrement());
    }
}
