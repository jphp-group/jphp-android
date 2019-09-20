package org.venity.jphp.ext.android.fx.classes;

import javafx.scene.Node;
import javafx.scene.control.Button;
import org.venity.jphp.ext.android.AndroidExtension;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Namespace;
import php.runtime.annotation.Reflection.Nullable;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Name("UXButton")
@Namespace(AndroidExtension.NS_FX)
public class UXButton extends UXButtonBase {
    interface WrappedInterface {
    }

    public UXButton(Environment env, Button wrappedObject) {
        super(env, wrappedObject);
    }

    public UXButton(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public Button getWrappedObject() {
        return (Button) super.getWrappedObject();
    }

    @Signature
    public void __construct() {
        __wrappedObject = new Button();
        getWrappedObject().setMnemonicParsing(false);
    }

    @Signature
    public void __construct(String text) {
        __wrappedObject = new Button(text);
    }
    @Signature
    public void __construct(String text, @Nullable Node graphic) {
        __wrappedObject = new Button(text, graphic);
    }
}
