package org.venity.jphp.ext.android.fx.classes;

import javafx.scene.control.Cell;
import javafx.scene.control.IndexedCell;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Property;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXIndexedCell")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXCell<T extends IndexedCell> extends UXLabeled<Cell> {
    interface WrappedInterface {
        @Property Object item();

        @Property boolean editable();
        @Property boolean editing();
        @Property boolean selected();
        @Property boolean empty();
    }

    public UXCell(Environment env, IndexedCell wrappedObject) {
        super(env, wrappedObject);
    }

    public UXCell(Environment env, Cell wrappedObject) {
        super(env, wrappedObject);
    }

    public UXCell(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public void __construct() {
        __wrappedObject = new Cell<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getWrappedObject() {
        return (T) super.getWrappedObject();
    }

    @Signature
    public void startEdit() {
        getWrappedObject().startEdit();
    }

    @Signature
    public void cancelEdit() {
        getWrappedObject().cancelEdit();
    }

    @Signature
    public void commitEdit(Object newValue) {
        getWrappedObject().commitEdit(newValue);
    }

    @Signature
    public void updateSelected(boolean value) {
        getWrappedObject().updateSelected(value);
    }
}
