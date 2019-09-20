package org.venity.jphp.ext.android.android.classes;


import com.gluonhq.charm.glisten.application.StatusBar;
import javafx.scene.paint.Color;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.UXAndroidApplication;
import org.venity.jphp.ext.android.fx.classes.paint.UXColor;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXStatusBar")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXStatusBar extends BaseWrapper<StatusBar> {


    public UXStatusBar(Environment env, StatusBar wrappedObject) {
        super(env, wrappedObject);
    }

    public UXStatusBar(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Getter
    public Color getColor(){
        return getWrappedObject().getColor();
    }


    @Reflection.Setter
    public void setColor(String c){
        getWrappedObject().setColor(UXColor.of(c));
    }

    @Reflection.Signature
    public void setUXColor(Color c){
        getWrappedObject().setColor(c);
    }

}
