package org.venity.jphp.ext.android.fx.classes;

import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.control.Separator;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Property;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXSeparator")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXSeparator extends UXControl<Separator> {
    interface WrappedInterface {
        @Property Orientation orientation();
        @Property("hAlignment") HPos halignment();
        @Property("vAlignment") VPos valignment();
    }

    public UXSeparator(Environment env, Separator wrappedObject) {
        super(env, wrappedObject);
    }

    public UXSeparator(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public void __construct() {
        __wrappedObject = new Separator();
    }

    @Signature
    public void __construct(Orientation orientation) {
        __wrappedObject = new Separator(orientation);
    }
}
