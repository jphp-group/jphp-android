package org.venity.jphp.ext.android.fx.classes;

import javafx.collections.ObservableList;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Property;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Name("UXColorPicker")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXColorPicker extends UXComboBoxBase {
    interface WrappedInterface {
        @Property ObservableList<Color> customColors();
        @Property Color value();
    }

    public UXColorPicker(Environment env, ColorPicker wrappedObject) {
        super(env, wrappedObject);
    }

    public UXColorPicker(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public ColorPicker getWrappedObject() {
        return (ColorPicker) super.getWrappedObject();
    }

    @Signature
    public void __construct() {
        __wrappedObject = new ColorPicker();
    }

    @Signature
    public void __construct(Color color) {
        __wrappedObject = new ColorPicker(color);
    }
}
