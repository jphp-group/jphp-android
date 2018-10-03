package org.venity.jphp.android.events;

import android.view.DragEvent;
import android.view.View;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;

public class DragEventProvider extends EventProvider {
    @Override
    public String getCode() {
        return "drag";
    }

    @Override
    public void bind(Environment env, View view, Invoker invoker) {
        view.setOnDragListener((view1, dragEvent) -> invoker.callAny(view1).toBoolean());
    }

    @Override
    public void unbind(Environment env, View view) {
        view.setOnDragListener(null);
    }

    @Override
    public void trigger(Environment env, View view) {
        // noup
    }
}
