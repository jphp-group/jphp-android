package org.venity.jphp.android.classes.widget;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import org.venity.jphp.android.AndroidExtension;
import org.venity.jphp.android.classes.view.WrapViewGroup;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("LinearLayout")
@Reflection.Namespace(AndroidExtension.WIDGET_NS)
public class WrapLinearLayout extends WrapViewGroup {
    public WrapLinearLayout(Environment env, LinearLayout wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapLinearLayout(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(Activity activity) {
        __wrappedObject = new LinearLayout(activity);
        getWrappedObject().setId(idCounter.getAndIncrement());
    }
}
