package org.venity.jphp.ext.android.fx.classes;

import javafx.geometry.Pos;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TextField;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.support.BugFix8Utils;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Property;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Name("UXTextField")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXTextField<T extends TextField> extends UXTextInputControl<T> {
    interface WrappedInterface {
        @Property Pos alignment();
        @Property int prefColumnCount();
    }

    public UXTextField(Environment env, T wrappedObject) {
        super(env, wrappedObject);
    }

    public UXTextField(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public T getWrappedObject() {
        return (T) super.getWrappedObject();
    }

    @Signature
    public void __construct() {
        __construct("");
    }

    @Signature
    public void __construct(String text) {
        __wrappedObject = new TextField(text);
        fixContextMenu();
    }

    protected void fixContextMenu() {
        getWrappedObject().setContextMenu(new ContextMenu());

        if (!JavaFXExtension.isJigsaw()) {
            BugFix8Utils.disableContextMenu(getWrappedObject());
        }
    }
}
