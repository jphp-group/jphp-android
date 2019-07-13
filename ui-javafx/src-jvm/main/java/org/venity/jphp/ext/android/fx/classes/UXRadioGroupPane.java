package org.venity.jphp.ext.android.fx.classes;

import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.classes.layout.UXVBox;
import org.venity.jphp.ext.android.fx.classes.text.UXFont;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import org.venity.jphp.ext.android.fx.support.control.RadioGroupPane;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Property;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

import java.util.List;

@Name("UXRadioGroupPane")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXRadioGroupPane extends UXVBox<RadioGroupPane> {
    interface WrappedInterface {
        @Property ObservableList items();
        @Property Object selected();
        @Property int selectedIndex();
        @Property Orientation orientation();

        @Property Color textColor();

        void update();
    }

    public UXRadioGroupPane(Environment env, RadioGroupPane wrappedObject) {
        super(env, wrappedObject);
    }

    public UXRadioGroupPane(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public RadioGroupPane getWrappedObject() {
        return (RadioGroupPane) super.getWrappedObject();
    }

    @Override
    @Signature
    public void __construct() {
        __wrappedObject = new RadioGroupPane<>();
    }

    @Override
    @Signature
    public void __construct(List<Node> children) {
        __construct();
    }


    @Reflection.Getter
    public UXFont getFont(Environment env) {
        return new UXFont(env, getWrappedObject().getFont(), font -> getWrappedObject().setFont(font));
    }

    @Reflection.Setter
    public void setFont(Font font) {
        getWrappedObject().setFont(font);
    }
}
