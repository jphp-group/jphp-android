package org.venity.jphp.ext.android.fx.classes;

import javafx.scene.Node;
import javafx.stage.Stage;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.support.control.DraggableTab;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.*;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXDraggableTab")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXDraggableTab extends UXTab {
    interface WrappedInterface {
        @Property boolean disableDragFirst();
        @Property boolean disableDragLast();

        @Property boolean detachable();
        @Property boolean draggable();
        @Property("detachedForm") Stage detachedStage();
    }

    public UXDraggableTab(Environment env, DraggableTab wrappedObject) {
        super(env, wrappedObject);
    }

    public UXDraggableTab(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public void __construct() {
        __wrappedObject = new DraggableTab("");
    }

    @Signature
    public void __construct(String title) {
        __wrappedObject = new DraggableTab(title);
    }

    @Signature
    public void __construct(String title, Node content) {
        __wrappedObject = new DraggableTab(title);
        __wrappedObject.setContent(content);
    }

    @Override
    public DraggableTab getWrappedObject() {
        return (DraggableTab) super.getWrappedObject();
    }

    @Getter
    @Override
    public String getText() {
        return getWrappedObject().getLabelText();
    }

    @Setter
    @Override
    public void setText(String value) {
        getWrappedObject().setLabelText(value);
    }

    @Getter
    @Override
    public Node getGraphic() {
        return getWrappedObject().getLabelGraphic();
    }

    @Setter
    @Override
    public void setGraphic(@Nullable Node node) {
        getWrappedObject().setLabelGraphic(node);
    }
}
