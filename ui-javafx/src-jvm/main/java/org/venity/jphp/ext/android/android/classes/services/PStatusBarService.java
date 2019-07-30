package org.venity.jphp.ext.android.android.classes.services;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.StatusBarService;
import javafx.scene.paint.Color;
import org.venity.jphp.ext.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("StatusBarService")
@Reflection.Namespace(AndroidExtension.NS_ANDROID_SERVICE)
@Reflection.Abstract
public class PStatusBarService extends BaseWrapper<StatusBarService> {

    public PStatusBarService(Environment env, StatusBarService wrappedObject) {
        super(env, wrappedObject);
    }

    public PStatusBarService(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public static PStatusBarService get(Environment __env__) {
        return new PStatusBarService(__env__, Services.get(StatusBarService.class).get());
    }

    interface WrappedInterface {
        void setColor(Color color);
    }
}
