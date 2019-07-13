package org.venity.jphp.ext.android.fx.classes;

import javafx.scene.control.CheckBox;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Property;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Name("UXCheckbox")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXCheckbox extends UXButtonBase {
    interface WrappedInterface {
        @Property boolean selected();
        @Property boolean indeterminate();
        @Property boolean allowIndeterminate();
    }

    public UXCheckbox(Environment env, CheckBox wrappedObject) {
        super(env, wrappedObject);
    }

    public UXCheckbox(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public void __construct() {
        __wrappedObject = new CheckBox();

        getWrappedObject().setMnemonicParsing(false);
    }

    @Signature
    public void __construct(String text) {
        __wrappedObject = new CheckBox(text);

        getWrappedObject().setMnemonicParsing(false);
    }

    @Override
    public CheckBox getWrappedObject() {
        return (CheckBox) super.getWrappedObject();
    }
}
