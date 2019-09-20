package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.control.NavigationDrawer;
import javafx.scene.Node;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.classes.UXControl;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXNavigationDrawerFooter")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXNavigationDrawerFooter extends UXControl<NavigationDrawer.Footer> {
    public UXNavigationDrawerFooter(Environment env, NavigationDrawer.Footer wrappedObject) {
        super(env, wrappedObject);
    }

    public UXNavigationDrawerFooter(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(String title, Node graphic) {
        __wrappedObject = new NavigationDrawer.Footer(title, graphic);
    }

    @Reflection.Signature
    public void __construct(String title) {
        __wrappedObject = new NavigationDrawer.Footer(title);
    }

    interface WrappedInterface {
        @Reflection.Property String title();
        @Reflection.Property Node graphic();
    }
}
