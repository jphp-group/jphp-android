package org.venity.jphp.android.classes.widget;

import android.app.Activity;
import android.content.Context;
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

    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_END = 4;

    @Reflection.Signature
    public void __construct(Context activity) {
        __wrappedObject = new LinearLayout(activity);
        getWrappedObject().setId(idCounter.getAndIncrement());
    }

    public interface WrappedInterface {
        @Reflection.Property int showDividers();
        @Reflection.Property int orientation();
    }
}