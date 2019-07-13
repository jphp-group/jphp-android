package org.venity.jphp.ext.android.fx.classes.effect;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Property;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Name("UXColorAdjustEffect")
@Reflection.Namespace("php\\gui\\effect")
public class UXColorAdjustEffect extends UXEffect<ColorAdjust> {
    interface WrappedInterface {
        @Property double brightness();
        @Property double contrast();
        @Property double hue();
        @Property double saturation();

        @Property Effect input();
    }

    public UXColorAdjustEffect(Environment env, ColorAdjust wrappedObject) {
        super(env, wrappedObject);
    }

    public UXColorAdjustEffect(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public void __construct() {
        __wrappedObject = new ColorAdjust();
    }
}
