package org.venity.jphp.ext.android.android.classes.services;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.StorageService;
import org.venity.jphp.ext.android.AndroidExtension;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

import java.util.Optional;

@Reflection.Name("StorageService")
@Reflection.Namespace(AndroidExtension.NS_ANDROID_SERVICE)
@Reflection.Abstract
public class PStorageService extends BaseWrapper<StorageService> {
    public PStorageService(Environment env, StorageService wrappedObject) {
        super(env, wrappedObject);
    }

    public PStorageService(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    public static final String SERVICE = StorageService.class.getName();

    @Reflection.Signature
    public static PStorageService get(Environment __env__) {
        return new PStorageService(__env__, (StorageService) Services.get(StorageService.class).get());
    }

    @Reflection.Signature
    public Memory getPrivateStorage() {
        Optional opt = getWrappedObject().getPrivateStorage();

        if (opt.isPresent())
            return Memory.wrap(__env__, opt.get());
        else return Memory.NULL;
    }

    @Reflection.Signature
    public Memory getPublicStorage(String string) {
        Optional opt = getWrappedObject().getPublicStorage(string);

        if (opt.isPresent())
            return Memory.wrap(__env__, opt.get());
        else return Memory.NULL;
    }

    @Reflection.Signature
    public boolean isExternalStorageWritable() {
        return getWrappedObject().isExternalStorageWritable();
    }

    @Reflection.Signature
    public boolean isExternalStorageReadable() {
        return getWrappedObject().isExternalStorageReadable();
    }
}
