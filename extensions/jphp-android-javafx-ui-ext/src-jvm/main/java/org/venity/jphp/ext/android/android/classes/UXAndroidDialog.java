package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.control.Dialog;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.Node;
import javafx.scene.control.ButtonBase;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.classes.UXList;
import org.venity.jphp.ext.android.fx.classes.event.UXEvent;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

import java.util.List;

@Reflection.Name("UXAndroidDialog")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXAndroidDialog extends BaseWrapper<Dialog>{

    public UXAndroidDialog(Environment env, Dialog wrappedObject) {
        super(env, wrappedObject);
    }

    public UXAndroidDialog(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(){
        __wrappedObject = new Dialog();
    }

    @Reflection.Signature
    public void show(){
        getWrappedObject().showAndWait();
    }

    @Reflection.Signature
    public void hide(){
        getWrappedObject().hide();
    }

    @Reflection.Signature
    public boolean isFullscreen(){
        return getWrappedObject().isFullscreen();
    }

    @Reflection.Signature
    public boolean isAutoHide(){
        return getWrappedObject().isAutoHide();
    }

    @Reflection.Signature
    public boolean isShowing(){
        return getWrappedObject().isShowing();
    }

    @Reflection.Getter
    public Node getTitle(){
        return getWrappedObject().getTitle();
    }

    @Reflection.Setter
    public void setTitle(Node N){
        getWrappedObject().setTitle(N);
    }

    @Reflection.Getter
    public UXList<ButtonBase> getItems(){
        return new UXList<ButtonBase>(__env__, getWrappedObject().getButtons());
    }

    @Reflection.Getter
    public Node getContent(){
        return getWrappedObject().getContent();
    }

    @Reflection.Setter
    public void setContent(Node N){
        getWrappedObject().setContent(N);
    }


    @Reflection.Setter
    public void setOnHide(Invoker i){
        getWrappedObject().setOnHiding((e) -> {
            try {
                i.call(null);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    @Reflection.Getter
    public Node getGraphic(){
        return getWrappedObject().getGraphic();
    }

    @Reflection.Setter
    public void setGraphic(Node N){
        getWrappedObject().setGraphic(N);
    }

}
