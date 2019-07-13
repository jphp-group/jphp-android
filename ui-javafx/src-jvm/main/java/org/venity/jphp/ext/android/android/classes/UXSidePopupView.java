package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.layout.layer.SidePopupView;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.classes.layout.UXPane;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXSidePopupView")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXSidePopupView extends UXPane<SidePopupView> {

    public UXSidePopupView(Environment env, SidePopupView wrappedObject) {
        super(env, wrappedObject);
    }

    public UXSidePopupView(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(Node nd){
        __wrappedObject = new SidePopupView(nd);
    }

    @Reflection.Signature
    public void __construct(){
        __wrappedObject = new SidePopupView(null);
    }

    @Reflection.Setter
    public void setShowSide(String pos){
        getWrappedObject().setSide( Side.valueOf( pos.toUpperCase() ) );
    }

    @Reflection.Getter
    public String getShowSide(){
        return getWrappedObject().getSide().name();
    }

}
