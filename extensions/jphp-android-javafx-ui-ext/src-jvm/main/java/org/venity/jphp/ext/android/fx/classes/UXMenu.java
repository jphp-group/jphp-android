package org.venity.jphp.ext.android.fx.classes;

import javafx.collections.ObservableList;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Nullable;
import php.runtime.annotation.Reflection.Property;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Name("UXMenu")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXMenu extends UXMenuItem {
    interface WrappedInterface {
        @Property boolean showing();
        @Property ObservableList<MenuItem> items();

        void show();
        void hide();
    }

    public UXMenu(Environment env, Menu wrappedObject) {
        super(env, wrappedObject);
    }

    public UXMenu(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public Menu getWrappedObject() {
        return (Menu) super.getWrappedObject();
    }

    @Override
    @Signature
    public void __construct() {
        __wrappedObject = new Menu();
    }

    @Override
    @Signature
    public void __construct(String text) {
        __wrappedObject = new Menu(text);
    }

    @Override
    @Signature
    public void __construct(String text, @Nullable UXNode graphic) {
        __wrappedObject = new Menu(text, graphic == null ? null : graphic.getWrappedObject());
    }
}
