package org.venity.jphp.android.classes.picasso;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import org.venity.jphp.android.AndroidExtension;
import org.venity.jphp.android.AndroidStandaloneLoader;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

import java.io.File;

@Reflection.Name("Picasso")
@Reflection.Namespace(AndroidExtension.PICASSO_NS)
public class WrapPicasso extends BaseWrapper<Picasso> {
    public WrapPicasso(Environment env, Picasso wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapPicasso(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public Picasso getWrappedObject() {
        return super.getWrappedObject();
    }

    @Reflection.Signature
    public static Picasso get() {
        return Picasso.with(AndroidStandaloneLoader.getContext());
    }

    @Reflection.Signature
    public RequestCreator load(Memory arg) {
        Object obj = Memory.unwrap(__env__, arg);

        if (obj instanceof File) return getWrappedObject().load((File) obj);
        else if (obj instanceof String) return getWrappedObject().load((String) obj);
        else if (obj instanceof Integer) return getWrappedObject().load((int) obj);
        else return null;
    }
}
