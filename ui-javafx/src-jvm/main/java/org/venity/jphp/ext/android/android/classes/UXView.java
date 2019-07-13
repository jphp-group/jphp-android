package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.layout.Layer;
import com.gluonhq.charm.glisten.layout.layer.FloatingActionButton;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.android.classes.support.PView;
import org.venity.jphp.ext.android.fx.classes.UXList;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

import javax.xml.ws.spi.Invoker;

@Reflection.Name("UXView")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXView extends UXMobileLayoutPane {

    public static final String HOME_NAME = "home";


    public UXView(Environment env, View wrappedObject) {
        super(env, wrappedObject);
    }

    public UXView(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }
    
    @Override
    public View getWrappedObject() {
        return (View) __wrappedObject;
    }
    
    @Reflection.Signature
    public void __construct(String name) {
        __wrappedObject = new PView(name);
    }

    @Reflection.Signature
    public void setOnUpdateAppBar(Environment env, php.runtime.invoke.Invoker invoker){
        PView pv = (PView) getWrappedObject();
        pv.setOnAppBarUpdate(invoker, env);
    }

    @Reflection.Signature
    public void __construct() {
        __construct(HOME_NAME);
    }


    @Reflection.Signature
    public boolean isShowing() {
        return getWrappedObject().isShowing();
    }

    @Reflection.Getter
    public String getName() {
        return getWrappedObject().getName();
    }

    @Reflection.Signature
    public void addActionButton(FloatingActionButton fab) {
        getWrappedObject().getLayers().add(fab.getLayer());
    }

    @Reflection.Setter
    public void setName(String name) {
        getWrappedObject().setName(name);
    }
}
