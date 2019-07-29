package org.venity.jphp.ext.android.android.classes.services;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.DeviceService;
import org.venity.jphp.ext.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("DeviceService")
@Reflection.Namespace(AndroidExtension.NS_ANDROID_SERVICE)
@Reflection.Abstract
public class PDeviceService extends BaseWrapper<DeviceService> {
    public PDeviceService(Environment env, DeviceService wrappedObject) {
        super(env, wrappedObject);
    }

    public PDeviceService(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }


    @Reflection.Signature
    public static PDeviceService get(Environment __env__) {
        return new PDeviceService(__env__, (DeviceService) Services.get(DeviceService.class).get());
    }

    interface WrappedInterface {
        String getModel();
        String getUuid();
        String getPlatform();
        String getVersion();
        String getSerial();
        boolean isWearable();
    }
}
