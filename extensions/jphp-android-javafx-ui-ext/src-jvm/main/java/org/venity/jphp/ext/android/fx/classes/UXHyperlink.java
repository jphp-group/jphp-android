package org.venity.jphp.ext.android.fx.classes;

import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Property;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Name("UXHyperlink")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXHyperlink extends UXButtonBase {
    interface WrappedInterface {
        @Property boolean visited();

        void fire();
    }

    public UXHyperlink(Environment env, Hyperlink wrappedObject) {
        super(env, wrappedObject);
    }

    public UXHyperlink(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public Hyperlink getWrappedObject() {
        return (Hyperlink) super.getWrappedObject();
    }


    @Signature
    public void __construct() {
        __wrappedObject = new Hyperlink();
    }

    @Signature
    public void __construct(String text) {
        __wrappedObject = new Hyperlink(text);
    }

    @Signature
    public void __construct(String text, @Reflection.Nullable Node graphic) {
        __wrappedObject = new Hyperlink(text, graphic);
    }
}
