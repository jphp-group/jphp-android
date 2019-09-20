package org.venity.jphp.ext.android.android.classes.services.notifications;

import com.gluonhq.charm.down.plugins.Notification;
import org.venity.jphp.ext.android.AndroidExtension;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.ext.core.classes.stream.Stream;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

import java.time.ZonedDateTime;

@Reflection.Name("Notification")
@Reflection.Namespace(AndroidExtension.NS_ANDROID_SERVICE)
public class PNotification extends BaseWrapper<Notification> {
    public PNotification(Environment env, Notification wrappedObject) {
        super(env, wrappedObject);
    }

    public PNotification(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(String id, String title, String text, Memory imageLocation, Invoker invoker) {
        __wrappedObject = new Notification(
                id, title, text, Stream.getInputStream(__env__, imageLocation), ZonedDateTime.now(),
                () -> invoker.callNoThrow()
        );
    }

    @Reflection.Signature
    public void __construct(String id, String title, String text, Memory imageLocation) {
        __wrappedObject = new Notification(
                id, title, text, Stream.getInputStream(__env__, imageLocation), ZonedDateTime.now(),
                () -> {}
        );
    }
}
