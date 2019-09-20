package org.venity.jphp.ext.android.android.classes.services;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.LocalNotificationsService;
import com.gluonhq.charm.down.plugins.Notification;
import org.venity.jphp.ext.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

import java.util.ArrayList;
import java.util.List;

@Reflection.Name("NotificationService")
@Reflection.Namespace(AndroidExtension.NS_ANDROID_SERVICE)
@Reflection.Abstract
public class PNotificationService extends BaseWrapper<LocalNotificationsService> {
    public PNotificationService(Environment env, LocalNotificationsService wrappedObject) {
        super(env, wrappedObject);
    }

    public PNotificationService(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public static PNotificationService get(Environment __env__) {
        return new PNotificationService(__env__, (LocalNotificationsService)
                Services.get(LocalNotificationsService.class).get());
    }

    @Reflection.Signature
    public void notify(Notification notification) {
        getWrappedObject().getNotifications().add(notification);
    }

    @Reflection.Signature
    public void remove(Notification notification) {
        getWrappedObject().getNotifications().remove(notification);
    }

    @Reflection.Signature
    public List<Notification> getAllNotifications() {
        return new ArrayList<>(getWrappedObject().getNotifications());
    }
}
