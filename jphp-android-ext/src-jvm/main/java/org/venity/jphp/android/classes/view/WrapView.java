package org.venity.jphp.android.classes.view;

import android.content.Context;
import android.view.View;
import org.venity.jphp.android.AndroidExtension;
import org.venity.jphp.android.classes.app.WrapActivity;
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
    public void __construct(WrapActivity activity)
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
}
