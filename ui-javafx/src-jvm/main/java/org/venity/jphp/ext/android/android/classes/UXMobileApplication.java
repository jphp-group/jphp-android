package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.application.StatusBar;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.layout.layer.SidePopupView;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.Swatch;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.UXAndroidApplication;
import org.venity.jphp.ext.android.fx.classes.UXApplication;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXMobileApplication")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXMobileApplication extends UXApplication {

    public static Invoker getCallback() {
        return callback;
    }

    public static void setCallback(Invoker c) {
        callback = c;
    }

    protected static Invoker callback;

    public UXMobileApplication(Environment env, MobileApplication wrappedObject) {
        super(env, wrappedObject);
    }

    public UXMobileApplication(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public static void setSwatch(Swatch swatch) {
        UXAndroidApplication.getInstance().setSwatch(swatch);
    }

    @Reflection.Signature
    public static AppBar getAppBar() {
        return UXAndroidApplication.getInstance().getAppBar();
    }

    @Reflection.Signature
    public static void addView(String name, View view) {
        UXAndroidApplication.getInstance().addViewFactory(name, () -> view);
    }

    @Reflection.Signature
    public static StatusBar getStatusbar() {
        return UXAndroidApplication.getInstance().getStatusBar();
    }

    @Reflection.Signature
    public static void addLayout(String name, SidePopupView spv) {
        UXAndroidApplication.getInstance().addLayerFactory(name, () -> spv);
    }

    @Reflection.Signature
    public static void showLayout(String name) {
        UXAndroidApplication.getInstance().showLayer(name);
    }

    @Reflection.Signature
    public static void showView(String name) {
        UXAndroidApplication.getInstance().switchView(name);
    }

    @Reflection.Signature
    public static void hideLayout(String name) {
        UXAndroidApplication.getInstance().hideLayer(name);
    }

    @Reflection.Signature
    public static void goHome() {
        UXAndroidApplication.getInstance().goHome();
    }

    @Reflection.Signature
    public static boolean isLayerPresent(String name) {
        return UXAndroidApplication.getInstance().isLayerPresent(name);
    }

    @Reflection.Signature
    public static boolean isViewPresent(String name) {
        return UXAndroidApplication.getInstance().isViewPresent(name);
    }

    @Reflection.Signature
    public static View getView() {
        return UXAndroidApplication.getInstance().getView();
    }

    @Reflection.Signature
    public static String getTitle() {
        return UXAndroidApplication.getInstance().getTitle();
    }

    @Reflection.Signature
    public static double getScreenWidth() {
        return UXAndroidApplication.getInstance().getScreenWidth();
    }

    @Reflection.Signature
    public static double getScreenHeight() {
        return UXAndroidApplication.getInstance().getScreenHeight();
    }

    @Reflection.Signature
    public static void setTitle(String title) {
        UXAndroidApplication.getInstance().titleProperty().setValue(title);
    }

    @Reflection.Signature
    public static void launch(Invoker invoker) {
        setCallback(invoker);
    }
}
