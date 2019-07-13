package org.venity.jphp.ext.android.fx.classes;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Property;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXListCell")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXListCell extends UXCell<ListCell> {
    interface WrappedInterface {
        @Property
        ListView listView();
    }

    public UXListCell(Environment env, ListCell wrappedObject) {
        super(env, wrappedObject);
    }

    public UXListCell(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public void __construct() {
        __wrappedObject = new ListCell<>();
    }
}
