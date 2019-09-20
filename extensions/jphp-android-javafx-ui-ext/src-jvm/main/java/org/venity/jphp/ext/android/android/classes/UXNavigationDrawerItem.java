package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.control.NavigationDrawer;
import javafx.scene.Node;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.classes.UXControl;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXNavigationDrawerItem")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXNavigationDrawerItem extends UXControl<NavigationDrawer.Item> {
    public UXNavigationDrawerItem(Environment env, NavigationDrawer.Item wrappedObject) {
        super(env, wrappedObject);
    }

    public UXNavigationDrawerItem(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }


    @Reflection.Signature
    public void __construct(String title, Node graphic) {
        __wrappedObject = new NavigationDrawer.Item(title, graphic);
    }

    @Reflection.Signature
    public void __construct(String title) {
        __wrappedObject = new NavigationDrawer.Item(title);
    }

    @Reflection.Signature
    public void setOnAction(Invoker callback) {
        getWrappedObject().selectedProperty().addListener((var1, var2, var3) -> callback.callNoThrow());
    }

    interface WrappedInterface {
        @Reflection.Property String title();
        @Reflection.Property boolean selected();
        @Reflection.Property boolean autoClose();
        @Reflection.Property Node graphic();
    }
}
