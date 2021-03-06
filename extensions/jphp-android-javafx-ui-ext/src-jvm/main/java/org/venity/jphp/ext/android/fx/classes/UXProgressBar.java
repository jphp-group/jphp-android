package org.venity.jphp.ext.android.fx.classes;

import javafx.scene.control.ProgressBar;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Name("UXProgressBar")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXProgressBar extends UXProgressIndicator {
    public UXProgressBar(Environment env, ProgressBar wrappedObject) {
        super(env, wrappedObject);
    }

    public UXProgressBar(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public ProgressBar getWrappedObject() {
        return (ProgressBar) super.getWrappedObject();
    }

    @Override
    @Signature
    public void __construct() {
        __wrappedObject = new ProgressBar();
    }

    @Override
    @Signature
    public void __construct(double progress) {
        __wrappedObject = new ProgressBar(progress);
    }
}
