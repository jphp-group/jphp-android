package org.venity.jphp.android;

import android.app.Notification;
import android.app.NotificationManager;
import android.view.View;
import org.venity.jphp.android.classes.WrapR;
import org.venity.jphp.android.events.ClickEventProvider;
import org.venity.jphp.android.events.EventProvider;
import org.venity.jphp.android.events.LongClickEventProvider;
import php.runtime.env.CompileScope;
import php.runtime.env.Environment;
import php.runtime.ext.support.Extension;
import php.runtime.invoke.Invoker;

import java.util.HashMap;
import java.util.Map;

public class AndroidExtension extends Extension {

    public static final String NS = "php\\android";

    public final static Map<String, EventProvider> eventProviders = new HashMap<String, EventProvider>();
    
    @Override
    public Status getStatus() {
        return Status.EXPERIMENTAL;
    }

    @Override
    public String getName() {
        return "JPHP for Android";
    }

    @Override
    public String getVersion() {
        return "2.0 " + getStatus().toString();
    }

    @Override
    public void onRegister(CompileScope scope) {
        System.out.println("JPHP for android version: " + getVersion());

        registerClass(scope, WrapR.class);

        // events
        registerEventProvider(new ClickEventProvider());
        registerEventProvider(new LongClickEventProvider());
    }

    public static void registerEventProvider(EventProvider eventProvider) {
        eventProviders.put(eventProvider.getCode().toLowerCase(), eventProvider);
    }

    public static void bindEvent(Environment env, View view, String event, final Invoker invoker) {
        EventProvider provider = eventProviders.get(event.toLowerCase());

        if (provider != null) {
            provider.bind(env, view, invoker);
        }
    }

    public static void unbindEvent(Environment env, View view, String event) {
        EventProvider provider = eventProviders.get(event.toLowerCase());

        if (provider != null) {
            provider.unbind(env, view);
        }
    }

    public static void triggerEvent(Environment env, View view, String event) {
        EventProvider provider = eventProviders.get(event.toLowerCase());

        if (provider != null) {
            provider.trigger(env, view);
        }
    }
}