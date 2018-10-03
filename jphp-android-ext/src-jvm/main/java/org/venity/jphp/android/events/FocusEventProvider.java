package org.venity.jphp.android.events;

import android.view.View;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;

public class FocusEventProvider extends EventProvider {
    @Override
    public String getCode() {
        return "focus";
    }

    @Override
    public void bind(Environment env, View view, Invoker invoker) {
        view.setOnFocusChangeListener((view1, b) -> invoker.callAny(view1, b));
    }

    @Override
    public void unbind(Environment env, View view) {
        view.setOnFocusChangeListener(null);
    }

    @Override
    public void trigger(Environment env, View view) {

    }
}
