package org.venity.jphp.android.classes.view;

import android.app.Activity;
import android.view.View;
import org.venity.jphp.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

import java.util.concurrent.atomic.AtomicInteger;

@Reflection.Name("View")
@Reflection.Namespace(AndroidExtension.VIEW_NS)
public class WrapView extends BaseWrapper<View> {
    protected final static AtomicInteger idCounter = new AtomicInteger(100000);

    public WrapView(Environment env, View wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapView(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(Activity activity)
    {
        __wrappedObject = new View(activity);
    }

    @Reflection.Signature
    public void on(String event, Invoker callback) {
        AndroidExtension.bindEvent(__env__, this.getWrappedObject(), event, callback);
    }

    @Reflection.Signature
    public void off(String event) {
        AndroidExtension.unbindEvent(__env__, this.getWrappedObject(), event);
    }

    @Reflection.Signature
    public void trigger(String event) {
        AndroidExtension.triggerEvent(__env__, this.getWrappedObject(), event);
    }

    @Reflection.Setter
    public void setId(int id) {
        getWrappedObject().setId(id);
    }

    @Reflection.Getter
    public int getId() {
        return getWrappedObject().getId();
    }

    @Reflection.Setter
    public void setTop(int top) {
        getWrappedObject().setTop(top);
    }

    @Reflection.Getter
    public int getTop() {
        return getWrappedObject().getTop();
    }

    @Reflection.Setter
    public void setBottom(int bottom) {
        getWrappedObject().setBottom(bottom);
    }

    @Reflection.Getter
    public int getBottom() {
        return getWrappedObject().getBottom();
    }

    @Reflection.Setter
    public void setLeft(int left) {
        getWrappedObject().setLeft(left);
    }

    @Reflection.Getter
    public int getLeft() {
        return getWrappedObject().getLeft();
    }

    @Reflection.Setter
    public void setRight(int right) {
        getWrappedObject().setRight(right);
    }

    @Reflection.Getter
    public int getRight() {
        return getWrappedObject().getRight();
    }

    @Reflection.Setter
    public void setRotation(float rotation) {
        getWrappedObject().setRotation(rotation);
    }

    @Reflection.Getter
    public float getRotation() {
        return getWrappedObject().getRotation();
    }
}
