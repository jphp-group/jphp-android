package org.venity.jphp.ext.android.fx.classes;

import javafx.scene.Group;
import javafx.scene.Node;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

import java.util.List;

@Reflection.Name("UXGroup")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXGroup<T extends Group> extends UXParent<Group> {
    interface WrappedInterface {
    }

    public UXGroup(Environment env, T wrappedObject) {
        super(env, wrappedObject);
    }

    public UXGroup(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public void __construct() {
        __wrappedObject = new Group();
    }

    @Signature
    public void __construct(List<Node> children) {
        __wrappedObject = new Group(children.toArray(new Node[children.size()]));
    }
}
