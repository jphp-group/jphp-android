package org.venity.jphp.android;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import org.venity.jphp.android.classes.WrapR;
import org.venity.jphp.android.classes.app.WrapActivity;
import org.venity.jphp.android.classes.app.WrapApplication;
import org.venity.jphp.android.classes.content.WrapContext;
import org.venity.jphp.android.classes.picasso.WrapPicasso;
import org.venity.jphp.android.classes.picasso.WrapRequestCreator;
import org.venity.jphp.android.classes.view.WrapView;
import org.venity.jphp.android.classes.view.WrapViewGroup;
import org.venity.jphp.android.classes.widget.*;
import org.venity.jphp.android.events.*;
import php.runtime.env.CompileScope;
import php.runtime.env.Environment;
import php.runtime.ext.support.Extension;
import php.runtime.invoke.Invoker;

import java.util.HashMap;
import java.util.Map;

public class AndroidExtension extends Extension {

    public static final String NS = "php\\android";
    public static final String VIEW_NS = NS + "\\view";
    public static final String CONTENT_NS = NS + "\\content";
    public static final String APP_NS = NS + "\\app";
    public static final String WIDGET_NS = NS + "\\widget";

    // picasso lib
    public static final String PICASSO_NS = NS + "\\picasso";

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

        // classes
        registerClass(scope, WrapR.class);
        registerWrapperClass(scope, Context.class, WrapContext.class);
        registerWrapperClass(scope, View.class, WrapView.class);
        registerWrapperClass(scope, ViewGroup.class, WrapViewGroup.class);
        registerWrapperClass(scope, Application.class, WrapApplication.class);
        registerWrapperClass(scope, Activity.class, WrapActivity.class);

        registerWrapperClass(scope, TextView.class, WrapTextView.class);
        registerWrapperClass(scope, Button.class, WrapButton.class);
        registerWrapperClass(scope, EditText.class, WrapEditText.class);
        registerWrapperClass(scope, Toast.class, WrapToast.class);
        registerWrapperClass(scope, CheckBox.class, WrapCheckBox.class);
        registerWrapperClass(scope, ImageView.class, WrapImageView.class);

        registerWrapperClass(scope, GridLayout.class, WrapGridLayout.class);
        registerWrapperClass(scope, LinearLayout.class, WrapLinearLayout.class);
        registerWrapperClass(scope, FrameLayout.class, WrapFrameLayout.class);

        registerWrapperClass(scope, Picasso.class, WrapPicasso.class);
        registerWrapperClass(scope, RequestCreator.class, WrapRequestCreator.class);

        // events
        registerEventProvider(new ClickEventProvider());
        registerEventProvider(new LongClickEventProvider());
        registerEventProvider(new TouchEventProvider());
        registerEventProvider(new KeyEventProvider());
        registerEventProvider(new FocusEventProvider());
        registerEventProvider(new DragEventProvider());
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