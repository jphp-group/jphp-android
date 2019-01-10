package org.venity.jphp.android;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import org.venity.jphp.android.classes.WrapKeyCodes;
import org.venity.jphp.android.classes.WrapR;
import org.venity.jphp.android.classes.app.WrapActivity;
import org.venity.jphp.android.classes.app.WrapApplication;
import org.venity.jphp.android.classes.content.WrapContext;
import org.venity.jphp.android.classes.notification.WrapNotification;
import org.venity.jphp.android.classes.notification.WrapNotificationBuilder;
import org.venity.jphp.android.classes.picasso.WrapPicasso;
import org.venity.jphp.android.classes.picasso.WrapRequestCreator;
import org.venity.jphp.android.classes.view.WrapView;
import org.venity.jphp.android.classes.view.WrapViewGroup;
import org.venity.jphp.android.classes.widget.*;
import php.runtime.env.CompileScope;
import php.runtime.ext.support.Extension;

public class AndroidExtension extends Extension {

    public static final String NS = "php\\android";
    public static final String VIEW_NS = NS + "\\view";
    public static final String CONTENT_NS = NS + "\\content";
    public static final String APP_NS = NS + "\\app";
    public static final String WIDGET_NS = NS + "\\widget";
    public static final String NOTIFICATION_NS = NS + "\\notification";

    // picasso lib
    public static final String PICASSO_NS = NS + "\\picasso";
    
    @Override
    public Status getStatus() {
        return Status.EXPERIMENTAL;
    }

    @Override
    public String getName() {
        return "jPHP for Android";
    }

    @Override
    public String getVersion() {
        return "2.2.0 " + getStatus().toString();
    }

    @Override
    public void onRegister(CompileScope scope) {
        System.out.println("jPHP for android version: " + getVersion());

        // classes
        registerClass(scope, WrapR.class, WrapKeyCodes.class);

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
        registerWrapperClass(scope, Switch.class, WrapSwitch.class);

        registerWrapperClass(scope, GridLayout.class, WrapGridLayout.class);
        registerWrapperClass(scope, LinearLayout.class, WrapLinearLayout.class);
        registerWrapperClass(scope, FrameLayout.class, WrapFrameLayout.class);

        registerWrapperClass(scope, Picasso.class, WrapPicasso.class);
        registerWrapperClass(scope, RequestCreator.class, WrapRequestCreator.class);

        registerWrapperClass(scope, Notification.class, WrapNotification.class);
        registerWrapperClass(scope, Notification.Builder.class, WrapNotificationBuilder.class);
    }
}