package org.venity.jphp.android.classes.widget;

import android.view.View;
import android.widget.TextView;
import org.venity.jphp.android.AndroidExtension;
import org.venity.jphp.android.classes.app.WrapActivity;
import org.venity.jphp.android.classes.view.WrapView;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("TextView")
@Reflection.Namespace(AndroidExtension.WIDGET_NS)
public class WrapTextView extends WrapView {
    public WrapTextView(Environment env, TextView wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapTextView(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public TextView getWrappedObject() {
        return (TextView) super.getWrappedObject();
    }

    @Override
    @Reflection.Signature
    public void __construct(WrapActivity activity) {
        __wrappedObject = new TextView(activity);
        getWrappedObject().setId(idCounter.getAndIncrement());
    }

    @Reflection.Setter
    public void setText(String text) {
        getWrappedObject().setText(text);
    }

    @Reflection.Getter
    public CharSequence getText() {
        return getWrappedObject().getText();
    }

    @Reflection.Setter
    public void setInputType(int type) {
        getWrappedObject().setInputType(type);
    }

    @Reflection.Getter
    public int getInputType() {
        return getWrappedObject().getInputType();
    }
}
