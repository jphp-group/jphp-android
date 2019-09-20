package org.venity.jphp.ext.android.fx.classes.effect;

import javafx.scene.effect.Bloom;
import javafx.scene.effect.Effect;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.*;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Name("UXBloomEffect")
@Reflection.Namespace("php\\gui\\effect")
public class UXBloomEffect extends UXEffect<Bloom> {
    interface WrappedInterface {
        @Property double threshold();
        @Property Effect input();
    }

    public UXBloomEffect(Environment env, Bloom wrappedObject) {
        super(env, wrappedObject);
    }

    public UXBloomEffect(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public void __construct() {
        __wrappedObject = new Bloom();
    }

    @Signature
    public void __construct(double threshold) {
        __wrappedObject = new Bloom(threshold);
    }
}
