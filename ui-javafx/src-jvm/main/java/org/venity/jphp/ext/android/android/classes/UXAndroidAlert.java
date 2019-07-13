package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.control.Alert;
import com.gluonhq.charm.glisten.control.Dialog;
import org.venity.jphp.ext.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;
import javafx.scene.control.Alert.*;

@Reflection.Name("UXAndroidAlert")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXAndroidAlert extends UXAndroidDialog {


    public UXAndroidAlert(Environment env, Alert wrappedObject) {
        super(env, wrappedObject);
    }

    public UXAndroidAlert(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    public Alert getWrappedObject(){
        return (Alert) __wrappedObject;
    }

    @Reflection.Signature
    public void __construct(String type){
        __wrappedObject = new Alert(AlertType.valueOf(type.toUpperCase()));

    }

    @Reflection.Signature
    public void __construct(){
        __construct("INFORMATIOn");
    }

}
