package org.venity.jphp.ext.android.fx.classes;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.*;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXToggleButton")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXToggleButton extends UXButtonBase<ToggleButton> {
    interface WrappedInterface {
        @Property boolean selected();
    }

    public UXToggleButton(Environment env, ToggleButton wrappedObject) {
        super(env, wrappedObject);
    }

    public UXToggleButton(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public void __construct() {
        __wrappedObject = new ToggleButton();
    }

    @Signature
    public void __construct(String text) {
        __wrappedObject = new ToggleButton(text);
    }

    @Setter
    public void setToggleGroup(@Nullable ToggleGroup group) {
        getWrappedObject().setToggleGroup(group);
    }

    @Getter
    public ToggleGroup getToggleGroup() {
        return getWrappedObject().getToggleGroup();
    }
}
