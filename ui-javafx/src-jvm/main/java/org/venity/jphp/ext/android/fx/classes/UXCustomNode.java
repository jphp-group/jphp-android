package org.venity.jphp.ext.android.fx.classes;

import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.classes.data.Data;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import org.venity.jphp.ext.android.fx.classes.data.CustomNode;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.memory.ArrayMemory;
import php.runtime.memory.StringMemory;
import php.runtime.reflection.ClassEntity;

import java.util.Map;

@Name("UXCustomNode")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXCustomNode extends UXNode<CustomNode> {
    public UXCustomNode(Environment env, CustomNode wrappedObject) {
        super(env, wrappedObject);
    }

    public UXCustomNode(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public void __construct() {
        __wrappedObject = new Data();
    }

    @Signature
    public void set(String name, String value) {
        getWrappedObject().put(name, value);
    }

    @Signature
    public void clear() {
        getWrappedObject().clear();
    }

    @Signature
    public void remove(String name) {
        getWrappedObject().remove(name);
    }

    @Signature
    public boolean has(String name) {
        return getWrappedObject().containsKey(name);
    }

    @Signature
    public String get(String name) {
        return getWrappedObject().get(name);
    }

    @Signature
    public ArrayMemory toArray() {
        ArrayMemory result = new ArrayMemory();

        for (Map.Entry<String, String> entry : getWrappedObject().entrySet()) {
            result.putAsKeyString(entry.getKey(), StringMemory.valueOf(entry.getValue()));
        }

        return result;
    }
}
