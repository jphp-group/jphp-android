package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.Node;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.classes.UXControl;
import org.venity.jphp.ext.android.fx.classes.UXList;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXAppBar")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXAppBar extends UXControl<AppBar> {

    public UXAppBar(Environment env, AppBar wrappedObject) {
        super(env, wrappedObject);
    }

    public UXAppBar(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(){
        __wrappedObject = new AppBar();
    }

    @Reflection.Signature
    public void clear(){
        getWrappedObject().clear();
    }

    @Reflection.Getter
    public double getSpacing(){
        return getWrappedObject().getSpacing();
    }

    @Reflection.Setter
    public void setSpacing(double s){
        getWrappedObject().setSpacing(s);
    }

    @Reflection.Getter
    public double getProgress(){
        return getWrappedObject().getProgress();
    }


    @Reflection.Setter
    public void setProgress(double p){
        getWrappedObject().setProgress(p);
    }

    @Reflection.Getter
    public Node getNavIcon(){
        return getWrappedObject().getNavIcon();
    }

    @Reflection.Getter
    public UXList<Node> getItems(){
        return new UXList<Node>(__env__, getWrappedObject().getActionItems());
    }

    @Reflection.Setter
    public void setNavIcon(Node N){
        getWrappedObject().setNavIcon(N);
    }

    @Reflection.Getter
    public Node getTitle(){
        return getWrappedObject().getTitle();
    }

    @Reflection.Setter
    public void setTitle(Node N){
        getWrappedObject().setTitle(N);
    }

}
