package org.venity.jphp.android.classes.widget;

import android.app.Activity;
import android.content.Context;
import android.widget.CheckBox;
import org.venity.jphp.android.AndroidExtension;
import org.venity.jphp.android.classes.view.WrapView;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("CheckBox")
@Reflection.Namespace(AndroidExtension.WIDGET_NS)
public class WrapCheckBox extends WrapView {
    public WrapCheckBox(Environment env, CheckBox wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapCheckBox(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public CheckBox getWrappedObject() {
        return (CheckBox) super.getWrappedObject();
    }

    @Reflection.Signature
    public void __construct(Context activity) {
        __wrappedObject = new CheckBox(activity);
    }

    @Reflection.Getter
    public boolean getChecked() {
        return getWrappedObject().isChecked();
    }

    @Reflection.Setter
    public void setChecked(boolean checked) {
        getWrappedObject().setChecked(checked);
    }
}
