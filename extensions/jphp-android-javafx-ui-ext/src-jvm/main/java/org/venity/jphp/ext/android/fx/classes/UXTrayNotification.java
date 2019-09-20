package org.venity.jphp.ext.android.fx.classes;

import javafx.event.Event;
import javafx.scene.image.Image;
import javafx.util.Duration;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.support.EventProvider;
import org.venity.jphp.ext.android.fx.support.tray.animations.AnimationType;
import org.venity.jphp.ext.android.fx.support.tray.notification.NotificationLocation;
import org.venity.jphp.ext.android.fx.support.tray.notification.NotificationType;
import org.venity.jphp.ext.android.fx.support.tray.notification.TrayNotification;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Nullable;
import php.runtime.annotation.Reflection.Property;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Name("UXTrayNotification")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXTrayNotification extends BaseWrapper<TrayNotification> {
    interface WrappedInterface {
        @Property String title();
        @Property String message();
        @Property @Nullable Image image();
        @Property @Nullable Image trayIcon();
        @Property
        NotificationType notificationType();
        @Property
        NotificationLocation location();
        @Property
        AnimationType animationType();

        @Property double horGap();
        @Property double verGap();

        void showAndWait();
    }

    public UXTrayNotification(Environment env, TrayNotification wrappedObject) {
        super(env, wrappedObject);
    }

    public UXTrayNotification(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public void __construct() {
        __wrappedObject = new TrayNotification();
        getWrappedObject().setAnimationType(AnimationType.FADE);
    }

    @Signature
    public void __construct(String title) {
        __construct(title, "");
    }

    @Signature
    public void __construct(String title, String message) {
        __construct(title, message, NotificationType.NOTICE);
    }

    @Signature
    public void __construct(String title, String message, NotificationType type) {
        __wrappedObject = new TrayNotification(title, message, type);
        getWrappedObject().setAnimationType(AnimationType.FADE);
    }

    @Signature
    public void show() {
        getWrappedObject().showAndDismiss(Duration.seconds(5));
    }

    @Signature
    public void hide() {
        getWrappedObject().dismiss();
    }

    @Signature
    public void show(long millis) {
        getWrappedObject().showAndDismiss(Duration.millis(millis));
    }

    @Reflection.Signature
    @SuppressWarnings("unchecked")
    public void on(String event, Invoker invoker, String group) {
        EventProvider eventProvider = EventProvider.get(getWrappedObject(), event);

        if (eventProvider != null) {
            eventProvider.on(getWrappedObject(), event, group, invoker);
        } else {
            throw new IllegalArgumentException("Unable to find the '"+event+"' event type");
        }
    }

    @Reflection.Signature
    public void on(String event, Invoker invoker) {
        on(event, invoker, "general");
    }

    @Reflection.Signature
    @SuppressWarnings("unchecked")
    public void off(String event, @Reflection.Nullable String group) {
        EventProvider eventProvider = EventProvider.get(getWrappedObject(), event);

        if (eventProvider != null) {
            eventProvider.off(getWrappedObject(), event, group);
        } else {
            throw new IllegalArgumentException("Unable to find the '"+event+"' event type");
        }
    }

    @Reflection.Signature
    public void off(String event) {
        off(event, null);
    }

    @Reflection.Signature
    public void trigger(String event, @Reflection.Nullable Event e) {
        EventProvider eventProvider = EventProvider.get(getWrappedObject(), event);

        if (eventProvider != null) {
            eventProvider.trigger(getWrappedObject(), event, e);
        } else {
            throw new IllegalArgumentException("Unable to find the '"+event+"' event type");
        }
    }
}
