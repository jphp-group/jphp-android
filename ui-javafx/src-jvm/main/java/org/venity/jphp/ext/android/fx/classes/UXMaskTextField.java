package org.venity.jphp.ext.android.fx.classes;

import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.support.control.MaskTextField;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Property;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Name("UXMaskTextField")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXMaskTextField extends UXTextField<MaskTextField> {
    interface WrappedInterface {
        @Property String plainText();
        @Property String placeholder();
        @Property String mask();
        @Property String whatMask();
    }

    public UXMaskTextField(Environment env, MaskTextField wrappedObject) {
        super(env, wrappedObject);
    }

    public UXMaskTextField(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    @Signature
    public void __construct(String text) {
        __wrappedObject = new MaskTextField(text);
        fixContextMenu();
    }
}
