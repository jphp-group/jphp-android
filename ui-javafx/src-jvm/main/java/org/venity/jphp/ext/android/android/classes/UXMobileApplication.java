package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.application.StatusBar;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.NavigationDrawer;
import com.gluonhq.charm.glisten.layout.Layer;
import com.gluonhq.charm.glisten.layout.layer.SidePopupView;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Node;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.StandaloneAndroidLoader;
import org.venity.jphp.ext.android.UXAndroidApplication;
import org.venity.jphp.ext.android.fx.classes.UXApplication;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXMobileApplication")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXMobileApplication extends UXApplication {

    public UXMobileApplication(Environment env, MobileApplication wrappedObject) {
        super(env, wrappedObject);
    }

    public UXMobileApplication(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public static void setSwatch(Swatch swatch)
    {
        UXAndroidApplication.getInstance().setSwatch(swatch);
    }

    @Reflection.Signature
    public static AppBar getAppBar()
    {
        return UXAndroidApplication.getInstance().getAppBar();
    }

    @Reflection.Signature
    public static void addView(String name, View view)
    {
        UXAndroidApplication.getInstance().addViewFactory(name, () -> view);
    }

    @Reflection.Signature
    public static StatusBar getStatusbar(){
        return UXAndroidApplication.getInstance().getStatusBar();
    }

    @Reflection.Signature
    public static void addLayout(String name, SidePopupView spv)
    {
        UXAndroidApplication.getInstance().addLayerFactory(name, () -> spv);
    }

    @Reflection.Signature
    public static void showLayout(String name)
    {
        UXAndroidApplication.getInstance().showLayer(name);
    }

    @Reflection.Signature
    public static void showView(String name)
    {
        UXAndroidApplication.getInstance().switchView(name);
    }
}
