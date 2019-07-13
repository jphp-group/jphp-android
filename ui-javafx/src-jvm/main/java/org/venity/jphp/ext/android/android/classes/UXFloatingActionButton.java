package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.layout.layer.FloatingActionButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.classes.UXNode;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXFloatingActionButton")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXFloatingActionButton extends BaseWrapper<FloatingActionButton> {
    public UXFloatingActionButton(Environment env, FloatingActionButton wrappedObject) {
        super(env, wrappedObject);
    }

    public UXFloatingActionButton(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(){
        __wrappedObject = new FloatingActionButton();
    }

    @Reflection.Signature
    public void setOnAction(Invoker i){
        getWrappedObject().setOnAction(event -> {
            try {
                i.call(null);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    interface WrappedInterface{
        @Reflection.Property String text();
        @Reflection.Property boolean visible();
    }

}
