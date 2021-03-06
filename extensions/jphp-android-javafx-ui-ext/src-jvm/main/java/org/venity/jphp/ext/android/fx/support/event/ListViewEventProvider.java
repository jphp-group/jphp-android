package org.venity.jphp.ext.android.fx.support.event;

import javafx.event.EventHandler;
import org.venity.jphp.ext.android.fx.support.control.ListViewEx;
import org.venity.jphp.ext.android.fx.support.EventProvider;

public class ListViewEventProvider extends EventProvider<ListViewEx> {
    public Handler actionHandler() {
        return new Handler() {
            @Override
            public void set(ListViewEx target, EventHandler eventHandler) {
                target.setOnAction(eventHandler);
            }

            @Override
            public EventHandler get(ListViewEx target) {
                return target.getOnAction();
            }
        };
    }

    @Override
    public Class<ListViewEx> getTargetClass() {
        return ListViewEx.class;
    }
}
