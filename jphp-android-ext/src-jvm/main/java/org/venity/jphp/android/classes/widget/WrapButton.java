package org.venity.jphp.android.classes.widget;

import android.widget.Button;
import android.widget.TextView;
import org.venity.jphp.android.classes.app.WrapActivity;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

public class WrapButton extends WrapTextView {
    public WrapButton(Environment env, Button wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapButton(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public Button getWrappedObject() {
        return (Button) super.getWrappedObject();
    }

    @Reflection.Signature
    public void __construct(WrapActivity activity) {
        __wrappedObject = new Button(activity);
        getWrappedObject().setId(idCounter.getAndIncrement());
    }
}
