package org.venity.jphp.ext.android.fx.classes;

import javafx.scene.paint.Color;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.support.control.FlatButton;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Nullable;
import php.runtime.annotation.Reflection.Property;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXFlatButton")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXFlatButton extends UXButtonBase<FlatButton> {
    interface WrappedInterface {
        @Property Color color();
        @Property @Nullable Color hoverColor();
        @Property @Nullable Color clickColor();
        @Property double borderRadius();
    }

    public UXFlatButton(Environment env, FlatButton wrappedObject) {
        super(env, wrappedObject);
    }

    public UXFlatButton(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct() {
        __wrappedObject = new FlatButton();
    }

    @Reflection.Signature
    public void __construct(String text) {
        __wrappedObject = new FlatButton(text);
    }
}
