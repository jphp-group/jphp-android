package org.venity.jphp.ext.android.fx.support.event;

import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import org.venity.jphp.ext.android.fx.support.EventProvider;

public class ContextMenuEventProvider extends EventProvider<ContextMenu> {
    public Handler actionHandler() {
        return new Handler() {
            @Override
            public void set(ContextMenu target, EventHandler eventHandler) {
                target.setOnAction(eventHandler);
            }

            @Override
            public EventHandler get(ContextMenu target) {
                return target.getOnAction();
            }
        };
    }

    @Override
    public Class<ContextMenu> getTargetClass() {
        return ContextMenu.class;
    }
}
