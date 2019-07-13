package org.venity.jphp.ext.android.fx.classes.layout;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import org.venity.jphp.ext.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXBorderPane")
@Reflection.Namespace("php\\gui\\layout")
public class UXBorderPane extends UXPane<BorderPane> {

    public UXBorderPane(Environment env, BorderPane wrappedObject) {
        super(env, wrappedObject);
    }

    public UXBorderPane(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public BorderPane getWrappedObject() {
        return super.getWrappedObject();
    }

    @Reflection.Signature
    public void __construct() {
        __wrappedObject = new BorderPane();
    }

    @Reflection.Setter
    public void setTop(Node node) {
        getWrappedObject().setTop(node);
    }

    @Reflection.Getter
    public Node getTop() {
        return getWrappedObject().getTop();
    }

    @Reflection.Setter
    public void setBottom(Node node) {
        getWrappedObject().setBottom(node);
    }

    @Reflection.Getter
    public Node getBottom() {
        return getWrappedObject().getBottom();
    }

    @Reflection.Setter
    public void setLeft(Node node) {
        getWrappedObject().setLeft(node);
    }

    @Reflection.Getter
    public Node getLeft() {
        return getWrappedObject().getLeft();
    }

    @Reflection.Setter
    public void setRight(Node node) {
        getWrappedObject().setRight(node);
    }

    @Reflection.Getter
    public Node getRight() {
        return getWrappedObject().getRight();
    }

    @Reflection.Setter
    public void setCenter(Node node) {
        getWrappedObject().setCenter(node);
    }

    @Reflection.Getter
    public Node getCenter() {
        return getWrappedObject().getCenter();
    }
}
