package org.venity.jphp.ext.android.fx.classes;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Abstract;
import php.runtime.annotation.Reflection.Property;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

import java.util.List;

@Abstract
@Reflection.Name("UXScreen")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXScreen extends BaseWrapper<Screen> {
    interface WrappedInterface {
        @Property double dpi();
        @Property Rectangle2D bounds();
        @Property Rectangle2D visualBounds();
    }

    public UXScreen(Environment env, Screen wrappedObject) {
        super(env, wrappedObject);
    }

    public UXScreen(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public static Screen getPrimary() {
        return Screen.getPrimary();
    }

    @Reflection.Signature
    public static double getWidth()
    {
        return Screen.getPrimary().getVisualBounds().getWidth();
    }

    @Reflection.Signature
    public static double getHeight()
    {
        return Screen.getPrimary().getVisualBounds().getHeight();
    }

    @Reflection.Signature
    public static List<Screen> getScreens() {
        return Screen.getScreens();
    }
}
