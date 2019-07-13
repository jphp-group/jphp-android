package org.venity.jphp.ext.android.fx.classes;

import javafx.collections.ObservableList;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Property;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Name("UXContextMenu")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXContextMenu<T extends ContextMenu> extends UXPopupWindow<ContextMenu> {
    interface WrappedInterface {
        @Property ObservableList<MenuItem> items();
    }

    public UXContextMenu(Environment env, ContextMenu wrappedObject) {
        super(env, wrappedObject);
    }

    public UXContextMenu(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getWrappedObject() {
        return (T) super.getWrappedObject();
    }

    @Signature
    public void __construct() {
        __wrappedObject = new ContextMenu();
    }
}
