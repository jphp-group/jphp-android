package org.venity.jphp.android.classes.widget;

import android.content.Context;
import android.widget.Switch;
import org.venity.jphp.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("Switch")
@Reflection.Namespace(AndroidExtension.WIDGET_NS)
public class WrapSwitch extends WrapButton {
    public WrapSwitch(Environment env, Switch wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapSwitch(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    private boolean checked;

    @Override
    public Switch getWrappedObject() {
        return (Switch) super.getWrappedObject();
    }

    @Override
    public void __construct(Context activity) {
        __wrappedObject = new Switch(activity);
        __wrappedObject.setId(idCounter.getAndIncrement());

        getWrappedObject().setOnCheckedChangeListener((compoundButton, b) -> checked = b);
    }

    @Reflection.Getter
    public boolean getChecked() {
        return checked;
    }

    @Reflection.Setter
    public void setChecked(boolean checked) {
        this.checked = checked;
        getWrappedObject().setChecked(checked);
    }

    public interface WrappedInterface {
        @Reflection.Property int switchPadding();
        @Reflection.Property int switchMinWidth();
        @Reflection.Property int thumbTextPadding();
        @Reflection.Property CharSequence textOn();
        @Reflection.Property CharSequence textOff();
    }
}