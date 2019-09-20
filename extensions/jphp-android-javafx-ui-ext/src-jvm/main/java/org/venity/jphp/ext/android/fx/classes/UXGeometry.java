package org.venity.jphp.ext.android.fx.classes;

import javafx.geometry.Point2D;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Abstract;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.lang.BaseObject;
import php.runtime.reflection.ClassEntity;

@Abstract
@Reflection.Name("UXGeometry")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXGeometry extends BaseObject {
    public UXGeometry(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public static double distance(double x1, double y1, double x2, double y2) {
        return new Point2D(x1, y1).distance(x2, y2);
    }
}
