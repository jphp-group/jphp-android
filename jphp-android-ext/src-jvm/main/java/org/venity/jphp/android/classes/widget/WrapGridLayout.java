package org.venity.jphp.android.classes.widget;

import android.app.Activity;
import android.content.Context;
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
    public void __construct(Context activity) {
        __wrappedObject = new GridLayout(activity);
        getWrappedObject().setId(idCounter.getAndIncrement());
    }

    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    public static final int UNDEFINED = -2147483648;
    public static final int ALIGN_BOUNDS = 0;
    public static final int ALIGN_MARGINS = 1;

    public interface WrappedInterface {
        @Reflection.Property int rowCount();
        @Reflection.Property int orientation();
        @Reflection.Property int alignmentMode();
        @Reflection.Property boolean useDefaultMargins();
        @Reflection.Property boolean rowOrderPreserved();
        @Reflection.Property boolean columnOrderPreserved();
    }
}
