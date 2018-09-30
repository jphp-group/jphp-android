package org.venity.jphp.android.events;

import android.view.View;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;

public class LongClickEventProvider extends EventProvider {
    @Override
    public String getCode() {
        return "longClick";
    }

    @Override
    public void bind(Environment env, View view, Invoker invoker) {
        view.setOnLongClickListener(args -> invoker.callAny(args).toBoolean());
    }

    @Override
    public void unbind(Environment env, View view) {
        view.setOnLongClickListener(null);
    }

    @Override
    public void trigger(Environment env, View view) {
        // noup
    }
}
