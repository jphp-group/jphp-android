package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.mvc.View;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.android.classes.support.PView;
import org.venity.jphp.ext.android.fx.classes.UXNode;
import org.venity.jphp.ext.android.fx.classes.layout.UXBorderPane;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXView")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXView extends UXBorderPane {

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
    public void __construct() {
        __wrappedObject = new PView();
    }

    @Reflection.Signature
    public void __construct(UXNode node) {
        __wrappedObject = new PView(node.getWrappedObject());
    }

    @Reflection.Signature
    public void setOnUpdateAppBar(Environment env, php.runtime.invoke.Invoker invoker){
        PView pv = (PView) getWrappedObject();
        pv.setOnAppBarUpdate(invoker, env);
    }

    @Reflection.Signature
    public boolean isShowing() {
        return getWrappedObject().isShowing();
    }
}
