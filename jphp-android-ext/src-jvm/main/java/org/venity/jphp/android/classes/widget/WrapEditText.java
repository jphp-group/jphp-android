package org.venity.jphp.android.classes.widget;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import org.venity.jphp.android.AndroidExtension;
import org.venity.jphp.android.classes.app.WrapActivity;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("EditText")
@Reflection.Namespace(AndroidExtension.WIDGET_NS)
public class WrapEditText extends WrapTextView {
    public WrapEditText(Environment env, EditText wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapEditText(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(Context activity) {
        __wrappedObject = new EditText(activity);
        getWrappedObject().setId(idCounter.getAndIncrement());
    }

    @Override
    public EditText getWrappedObject() {
        return (EditText) super.getWrappedObject();
    }
}