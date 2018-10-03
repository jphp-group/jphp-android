package org.venity.jphp.android.events;

import android.view.View;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;

public class KeyEventProvider extends EventProvider {
    @Override
    public String getCode() {
        return "key";
    }

    @Override
    public void bind(Environment env, View view, Invoker invoker) {
        view.setOnKeyListener((view1, i, keyEvent) -> invoker.callAny(view1).toBoolean());
    }

    @Override
    public void unbind(Environment env, View view) {
        view.setOnKeyListener(null);
    }

    @Override
    public void trigger(Environment env, View view) {
        // noup
    }
}
