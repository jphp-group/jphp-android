package org.venity.jphp.android.classes.picasso;

import android.widget.ImageView;
import com.squareup.picasso.RequestCreator;
import org.venity.jphp.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("RequestCreator")
@Reflection.Namespace(AndroidExtension.PICASSO_NS)
public class WrapRequestCreator extends BaseWrapper<RequestCreator> {
    public WrapRequestCreator(Environment env, RequestCreator wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapRequestCreator(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public WrapRequestCreator into(ImageView view) {
        getWrappedObject().into(view);

        return this;
    }

    @Reflection.Signature
    public WrapRequestCreator noPlaceholder() {
        getWrappedObject().noPlaceholder();

        return this;
    }

    @Reflection.Signature
    public WrapRequestCreator resize(int width, int height) {
        getWrappedObject().resize(width, height);

        return this;
    }
}
