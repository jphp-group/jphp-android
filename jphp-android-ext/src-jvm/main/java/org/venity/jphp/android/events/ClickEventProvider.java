package org.venity.jphp.android.events;

import android.view.View;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;

public class ClickEventProvider extends EventProvider {
    @Override
    public String getCode() {
        return "click";
    }

    @Override
    public void bind(Environment env, View view, Invoker invoker) {
        view.setOnClickListener(v -> invoker.callAny(v.getClass().cast(v)));
    }

    @Override
    public void unbind(Environment env, View view) {
        view.setOnClickListener(null);
    }

    @Override
    public void trigger(Environment env, View view) {
        view.callOnClick();
    }
}
