package org.venity.jphp.android.classes.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import org.venity.jphp.android.AndroidExtension;
import org.venity.jphp.android.classes.content.WrapContext;
import org.venity.jphp.android.support.JPHPActivity;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;
import php.runtime.memory.LongMemory;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("Activity")
@Reflection.Namespace(AndroidExtension.APP_NS)
public class WrapActivity extends WrapContext {
    public WrapActivity(Environment env, Activity wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapActivity(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public Activity getWrappedObject() {
        return (Activity) super.getWrappedObject();
    }

    @Reflection.Signature
    public void __construct()
    {
        __wrappedObject = new JPHPActivity();
    }

    @Reflection.Signature
    public void setTitle(String title)
    {
        getWrappedObject().setTitle(title);
    }

    @Reflection.Signature
    public void setContentView(View view)
    {
        getWrappedObject().setContentView(view);
    }
    
    @Reflection.Signature
    public void setContentViewById(int id)
    {
        getWrappedObject().setContentView(id);
    }

    @Reflection.Signature
    public View findById(int id)
    {
        return getWrappedObject().findViewById(id);
    }

    @Reflection.Signature
    public void setOnCreate(Invoker invoker) {
        ((JPHPActivity) __wrappedObject).onCreate = () -> invoker.callNoThrow(Memory.NULL);
    }

    @Reflection.Signature
    public void setOnKeyDown(Invoker invoker) {
        ((JPHPActivity) __wrappedObject).onKeyDown =
                keyCode -> invoker.callNoThrow(new LongMemory((long) keyCode)).toBoolean();
    }

    @Reflection.Signature
    public void setOnKeyUp(Invoker invoker) {
        ((JPHPActivity) __wrappedObject).onKeyUp =
                keyCode -> invoker.callNoThrow(new LongMemory((long) keyCode)).toBoolean();
    }

    @Reflection.Signature
    public void setOnKeyLongPress(Invoker invoker) {
        ((JPHPActivity) __wrappedObject).onKeyLongPress =
                keyCode -> invoker.callNoThrow(new LongMemory((long) keyCode)).toBoolean();
    }

    @Reflection.Signature
    public void setOnKeyMultiple(Invoker invoker) {
        ((JPHPActivity) __wrappedObject).onKeyMultiple =
                keyCode -> invoker.callNoThrow(new LongMemory((long) keyCode)).toBoolean();
    }

    @Reflection.Signature
    public void setOnKeyShortcut(Invoker invoker) {
        ((JPHPActivity) __wrappedObject).onKeyShortcut =
                keyCode -> invoker.callNoThrow(new LongMemory((long) keyCode)).toBoolean();
    }
}
