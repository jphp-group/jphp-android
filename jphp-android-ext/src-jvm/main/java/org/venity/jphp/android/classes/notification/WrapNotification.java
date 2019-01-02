package org.venity.jphp.android.classes.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import org.venity.jphp.android.AndroidExtension;
import org.venity.jphp.android.AndroidStandaloneLoader;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("Notification")
@Reflection.Namespace(AndroidExtension.NOTIFICATION_NS)
public class WrapNotification extends BaseWrapper<Notification> {

    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final int DEFAULT_LIGHTS = 4;

    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_FOREGROUND_SERVICE = 64;

    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MIN = -2;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_MAX = 2;

    public WrapNotification(Environment env, Notification wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapNotification(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public static void notify(Notification notification, int id) {
        NotificationManager manager = (NotificationManager)
                AndroidStandaloneLoader.getMainActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(id, notification);
    }

    @Reflection.Signature
    public static void cancel(int id) {
        NotificationManager manager = (NotificationManager)
                AndroidStandaloneLoader.getMainActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        manager.cancel(id);
    }

    @Reflection.Signature
    public static void cancelAll() {
        NotificationManager manager = (NotificationManager)
                AndroidStandaloneLoader.getMainActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        manager.cancelAll();
    }
}
