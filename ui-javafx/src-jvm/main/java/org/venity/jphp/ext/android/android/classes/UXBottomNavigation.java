package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.control.BottomNavigation;
import com.gluonhq.charm.glisten.control.BottomNavigationButton;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.classes.UXControl;
import org.venity.jphp.ext.android.fx.classes.UXList;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;

import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXBottomNavigation")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXBottomNavigation extends UXControl<BottomNavigation> {
    public UXBottomNavigation(Environment env, BottomNavigation wrappedObject) {
        super(env, wrappedObject);
    }

    public UXBottomNavigation(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(){
        __wrappedObject = new BottomNavigation();
    }

    @Reflection.Signature
    public void __construct(String type){
        __wrappedObject = new BottomNavigation(BottomNavigation.Type.valueOf(type.toUpperCase()));
    }

    @Reflection.Getter
    public String getType(){
        return getWrappedObject().getType().name();
    }

    @Reflection.Setter
    public void setType(String type){
        getWrappedObject().setType(BottomNavigation.Type.valueOf(type.toUpperCase()));
    }

    @Reflection.Getter
    public UXList<Node> getItems(){
        return new UXList<Node>(__env__, (ObservableList) getWrappedObject().getActionItems());
    }

}
