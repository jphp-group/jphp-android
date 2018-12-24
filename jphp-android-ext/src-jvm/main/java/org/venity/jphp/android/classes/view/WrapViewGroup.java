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

    public static final int FOCUS_BEFORE_DESCENDANTS = 131072;
    public static final int FOCUS_AFTER_DESCENDANTS = 262144;
    public static final int FOCUS_BLOCK_DESCENDANTS = 393216;
    public static final int PERSISTENT_NO_CACHE = 0;
    public static final int PERSISTENT_ANIMATION_CACHE = 1;
    public static final int PERSISTENT_SCROLLING_CACHE = 2;
    public static final int PERSISTENT_ALL_CACHES = 3;

    public interface WrappedInterface {
        @Reflection.Property int descendantFocusability();

        void removeView(View view);
        void removeViewAt(int index);
        void removeViews(int start, int count);
        void removeViewsInLayout(int start, int count);
        void removeAllViews();
        void removeAllViewsInLayout();

        int indexOfChild(View child);
        int getChildCount();
        View getChildAt(int index);
    }
}
