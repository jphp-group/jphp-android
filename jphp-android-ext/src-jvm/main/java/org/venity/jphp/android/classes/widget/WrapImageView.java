package org.venity.jphp.android.classes.widget;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import org.venity.jphp.android.AndroidExtension;
import org.venity.jphp.android.classes.view.WrapView;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("ImageView")
@Reflection.Namespace(AndroidExtension.WIDGET_NS)
public class WrapImageView extends WrapView {
    public WrapImageView(Environment env, ImageView wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapImageView(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public ImageView getWrappedObject() {
        return (ImageView) super.getWrappedObject();
    }

    @Reflection.Signature
    public void __construct(Context activity) {
        __wrappedObject = new ImageView(activity);
    }

    @Reflection.Setter
    public void setScaleType(String scaleType) {
        getWrappedObject().setScaleType(ImageView.ScaleType.valueOf(scaleType));
    }

    @Reflection.Getter
    public String getScaleType() {
        return getWrappedObject().getScaleType().toString();
    }

    interface WrappedInterface {
        @Reflection.Property int maxWidth();
        @Reflection.Property int maxHeight();
    }
}
