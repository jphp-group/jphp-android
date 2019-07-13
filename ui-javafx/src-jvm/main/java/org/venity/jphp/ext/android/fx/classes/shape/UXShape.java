package org.venity.jphp.ext.android.fx.classes.shape;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import org.venity.jphp.ext.android.fx.classes.UXNode;
import php.runtime.annotation.Reflection.*;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Name("php\\gui\\shape\\UXShape")
public abstract class UXShape<T extends Shape> extends UXNode<Shape> {
    interface WrappedInterface {
        @Property boolean smooth();
        @Property double strokeWidth();
        @Property StrokeType strokeType();
    }

    public UXShape(Environment env, T wrappedObject) {
        super(env, wrappedObject);
    }

    public UXShape(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public T getWrappedObject() {
        return (T) super.getWrappedObject();
    }

    @Setter
    public void setFillColor(@Nullable Color color) {
        getWrappedObject().setFill(color);
    }

    @Getter
    public Color getFillColor() {
        Paint fill = getWrappedObject().getFill();

        if (fill instanceof Color) {
            return (Color) fill;
        }

        return null;
    }

    @Setter
    public void setStrokeColor(@Nullable Color color) {
        getWrappedObject().setStroke(color);
    }

    @Getter
    public Color getStrokeColor() {
        Paint fill = getWrappedObject().getStroke();

        if (fill instanceof Color) {
            return (Color) fill;
        }

        return null;
    }
}
