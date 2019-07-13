package org.venity.jphp.ext.android.fx.support.event;

import javafx.event.EventHandler;
import javafx.scene.control.MenuButton;
import org.venity.jphp.ext.android.fx.support.EventProvider;
import org.venity.jphp.ext.android.fx.support.JavaFxUtils;

public class MenuButtonEventProvider extends EventProvider<MenuButton> {
    public Handler showingHandler() {
        return new Handler() {
            @Override
            public void set(MenuButton target, EventHandler eventHandler) {
                target.addEventHandler(MenuButton.ON_SHOWING, eventHandler);
                JavaFxUtils.saveEventHandler(target, "showing", eventHandler);
            }

            @Override
            public EventHandler get(MenuButton target) {
                return JavaFxUtils.loadEventHandler(target, "showing");
            }
        };
    }

    public Handler showHandler() {
        return new Handler() {
            @Override
            public void set(MenuButton target, EventHandler eventHandler) {
                target.addEventHandler(MenuButton.ON_SHOWN, eventHandler);
                JavaFxUtils.saveEventHandler(target, "show", eventHandler);
            }

            @Override
            public EventHandler get(MenuButton target) {
                return JavaFxUtils.loadEventHandler(target, "show");
            }
        };
    }

    public Handler hidingHandler() {
        return new Handler() {
            @Override
            public void set(MenuButton target, EventHandler eventHandler) {
                target.addEventHandler(MenuButton.ON_HIDING, eventHandler);
                JavaFxUtils.saveEventHandler(target, "hiding", eventHandler);
            }

            @Override
            public EventHandler get(MenuButton target) {
                return JavaFxUtils.loadEventHandler(target, "hiding");
            }
        };
    }

    public Handler hideHandler() {
        return new Handler() {
            @Override
            public void set(MenuButton target, EventHandler eventHandler) {
                target.addEventHandler(MenuButton.ON_HIDDEN, eventHandler);
                JavaFxUtils.saveEventHandler(target, "hide", eventHandler);
            }

            @Override
            public EventHandler get(MenuButton target) {
                return JavaFxUtils.loadEventHandler(target, "hide");
            }
        };
    }

    @Override
    public Class<MenuButton> getTargetClass() {
        return MenuButton.class;
    }
}
