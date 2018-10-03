package org.venity.jphp.android.classes.widget;

import android.view.View;
import android.widget.Toast;
import org.venity.jphp.android.AndroidExtension;
import org.venity.jphp.android.AndroidStandaloneLoader;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("Toast")
@Reflection.Namespace(AndroidExtension.WIDGET_NS)
public class WrapToast extends BaseWrapper<Toast> {

    public static final int SHORT = 0;
    public static final int LONG  = 1;

    public WrapToast(Environment env, Toast wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapToast(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public Toast getWrappedObject() {
        return super.getWrappedObject();
    }

    @Reflection.Signature
    public void __construct() {
        __wrappedObject = new Toast(AndroidStandaloneLoader.getContext());
        getWrappedObject().setDuration(Toast.LENGTH_LONG);
    }

    @Reflection.Signature
    public void show() {
        getWrappedObject().show();
    }

    @Reflection.Signature
    public void cancel() {
        getWrappedObject().cancel();
    }

    @Reflection.Setter
    public void setView(View v) {
        getWrappedObject().setView(v);
    }

    @Reflection.Getter
    public View getView() {
        return getWrappedObject().getView();
    }

    @Reflection.Setter
    public void setDuration(int duration) {
        getWrappedObject().setDuration(duration);
    }

    @Reflection.Getter
    public int getDuration() {
        return getWrappedObject().getDuration();
    }

    @Reflection.Signature
    public void setText(String text) {
        getWrappedObject().setText(text);
    }

    @Reflection.Signature
    public static Toast make(String text, int duration) {
        return Toast.makeText(AndroidStandaloneLoader.getContext(), text, duration);
    }
}
