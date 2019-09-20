package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.control.NavigationDrawer;
import javafx.scene.Node;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.classes.UXControl;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXNavigationDrawerHeader")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXNavigationDrawerHeader extends UXControl<NavigationDrawer.Header> {
    public UXNavigationDrawerHeader(Environment env, NavigationDrawer.Header wrappedObject) {
        super(env, wrappedObject);
    }

    public UXNavigationDrawerHeader(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(String title, String subtitle, Node graphic) {
        __wrappedObject = new NavigationDrawer.Header(title, subtitle, graphic);
    }

    @Reflection.Signature
    public void __construct(String title, String subtitle) {
        __wrappedObject = new NavigationDrawer.Header(title, subtitle);
    }

    @Reflection.Signature
    public void __construct(String title) {
        __wrappedObject = new NavigationDrawer.Header(title);
    }

    @Reflection.Signature
    public void setOnAction(Invoker callback) {
        getWrappedObject().setOnAction(actionEvent -> callback.callNoThrow());
    }

    interface WrappedInterface {
        @Reflection.Property String title();
        @Reflection.Property String subtitle();
        @Reflection.Property Node graphic();
    }
}
