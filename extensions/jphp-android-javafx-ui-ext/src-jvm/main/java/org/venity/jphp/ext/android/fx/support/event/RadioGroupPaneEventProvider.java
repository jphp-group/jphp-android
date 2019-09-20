package org.venity.jphp.ext.android.fx.support.event;

import javafx.event.EventHandler;
import org.venity.jphp.ext.android.fx.support.control.RadioGroupPane;
import org.venity.jphp.ext.android.fx.support.EventProvider;

public class RadioGroupPaneEventProvider extends EventProvider<RadioGroupPane> {
    public Handler actionHandler() {
        return new Handler() {
            @Override
            public void set(RadioGroupPane target, EventHandler eventHandler) {
                target.setOnAction(eventHandler);
            }

            @Override
            public EventHandler get(RadioGroupPane target) {
                return target.getOnAction();
            }
        };
    }

    @Override
    public Class<RadioGroupPane> getTargetClass() {
        return RadioGroupPane.class;
    }
}
