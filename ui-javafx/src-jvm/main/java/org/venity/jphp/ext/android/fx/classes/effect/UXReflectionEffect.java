package org.venity.jphp.ext.android.fx.classes.effect;

import javafx.scene.effect.Reflection;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection.*;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Name("UXReflectionEffect")
@php.runtime.annotation.Reflection.Namespace("php\\gui\\effect")
public class UXReflectionEffect extends UXEffect<Reflection> {
    interface WrappedInterface {
        @Property double topOffset();
        @Property double topOpacity();
        @Property double bottomOpacity();
    }

    public UXReflectionEffect(Environment env, Reflection wrappedObject) {
        super(env, wrappedObject);
    }

    public UXReflectionEffect(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public void __construct() {
        __wrappedObject = new Reflection();
    }
}
