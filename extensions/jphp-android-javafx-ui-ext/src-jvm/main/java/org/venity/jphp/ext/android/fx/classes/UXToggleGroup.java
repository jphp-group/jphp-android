package org.venity.jphp.ext.android.fx.classes;

import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.*;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.lang.IObject;
import php.runtime.reflection.ClassEntity;

@Name("UXToggleGroup")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXToggleGroup extends BaseWrapper<ToggleGroup> {
    interface WrappedInterface {
        @Property Object userData();
    }

    public UXToggleGroup(Environment env, ToggleGroup wrappedObject) {
        super(env, wrappedObject);
    }

    public UXToggleGroup(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public void __construct() {
        __wrappedObject = new ToggleGroup();
    }

    @Getter
    public Memory getSelected(Environment env) {
        return Memory.wrap(env, getWrappedObject().getSelectedToggle());
    }

    @Setter
    public void setSelected(Environment env, @Nullable IObject value) {
        if (value instanceof BaseWrapper && ((BaseWrapper) value).getWrappedObject() instanceof Toggle) {
            getWrappedObject().selectToggle((Toggle) ((BaseWrapper) value).getWrappedObject());
        } else {
            getWrappedObject().selectToggle(null);
        }
    }
}
