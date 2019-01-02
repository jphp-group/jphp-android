package org.venity.jphp.android.classes.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.net.Uri;
import android.widget.ImageView;
import org.venity.jphp.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("NotificationBuilder")
@Reflection.Namespace(AndroidExtension.NOTIFICATION_NS)
public class WrapNotificationBuilder extends BaseWrapper<Notification.Builder> {
    public WrapNotificationBuilder(Environment env, Notification.Builder wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapNotificationBuilder(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(Activity context) {
        __wrappedObject = new Notification.Builder(context);
        __wrappedObject.setContentIntent(
                PendingIntent.getActivity(context, 0, context.getIntent(), PendingIntent.FLAG_UPDATE_CURRENT));
    }

    @Reflection.Signature
    public Notification.Builder setLargeIcon(ImageView view) {
        return __wrappedObject.setLargeIcon(view.getDrawingCache());
    }

    public interface WrappedInterface {
        Notification.Builder setWhen(long when);
        Notification.Builder setUsesChronometer(boolean b);
        Notification.Builder setSmallIcon(int icon);
        Notification.Builder setContentTitle(CharSequence title);
        Notification.Builder setContentText(CharSequence text);
        Notification.Builder setSubText(CharSequence text);
        Notification.Builder setNumber(int number);
        Notification.Builder setContentInfo(CharSequence info);
        Notification.Builder setProgress(int max, int progress, boolean indeterminate);
        Notification.Builder setTicker(CharSequence tickerText);
        Notification.Builder setLights(int argb, int onMs, int offMs);
        Notification.Builder setOngoing(boolean ongoing);
        Notification.Builder setOnlyAlertOnce(boolean onlyAlertOnce);
        Notification.Builder setAutoCancel(boolean autoCancel);
        Notification.Builder setDefaults(int defaults);
        Notification.Builder setPriority(int pri);

        Notification build();
    }
}
