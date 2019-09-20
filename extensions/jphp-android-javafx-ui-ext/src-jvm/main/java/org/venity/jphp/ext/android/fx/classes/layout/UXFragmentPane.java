package org.venity.jphp.ext.android.fx.classes.layout;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.venity.jphp.ext.android.fx.support.control.FragmentPane;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Property;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

import java.util.List;

@Reflection.Name("UXFragmentPane")
@Reflection.Namespace("php\\gui\\layout")
public class UXFragmentPane<T extends FragmentPane> extends UXVBox<FragmentPane> {
    interface WrappedInterface {
        @Property
        Parent layout();

        void applyFragment(@Reflection.Nullable Stage form);
    }

    public UXFragmentPane(Environment env, T wrappedObject) {
        super(env, wrappedObject);
    }

    public UXFragmentPane(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public void __construct() {
        __wrappedObject = new FragmentPane();
    }

    @Signature
    public void __construct(List<Node> children) {
        __construct(children, 0);
    }

    @Signature
    public void __construct(List<Node> children, double spacing) {
        __wrappedObject = new FragmentPane(children.toArray(new Node[children.size()]));
        getWrappedObject().setSpacing(spacing);
    }
}
