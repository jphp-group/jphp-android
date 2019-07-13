package org.venity.jphp.ext.android.fx.support.event;

import javafx.event.EventHandler;
import org.venity.jphp.ext.android.fx.support.EventProvider;
import org.venity.jphp.ext.android.fx.support.tray.notification.TrayNotification;

public class TrayNotificationEventProvider extends EventProvider<TrayNotification> {
    public Handler clickHandler() {
        return new Handler() {
            @Override
            public void set(TrayNotification target, EventHandler eventHandler) {
                target.setOnClick(eventHandler);
            }

            @Override
            public EventHandler get(TrayNotification target) {
                return target.getOnClick();
            }
        };
    }

    public Handler showHandler() {
        return new Handler() {
            @Override
            public void set(TrayNotification target, EventHandler eventHandler) {
                target.setOnShown(eventHandler);
            }

            @Override
            public EventHandler get(TrayNotification target) {
                return target.getOnShown();
            }
        };
    }

    public Handler hideHandler() {
        return new Handler() {
            @Override
            public void set(TrayNotification target, EventHandler eventHandler) {
                target.setOnDismiss(eventHandler);
            }

            @Override
            public EventHandler get(TrayNotification target) {
                return target.getOnDismissed();
            }
        };
    }

    public Class<TrayNotification> getTargetClass() {
        return TrayNotification.class;
    }
}
