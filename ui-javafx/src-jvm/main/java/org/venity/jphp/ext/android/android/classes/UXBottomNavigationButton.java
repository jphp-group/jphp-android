package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.control.BottomNavigationButton;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.classes.UXControl;
import org.venity.jphp.ext.android.fx.classes.UXNode;
import org.venity.jphp.ext.android.fx.classes.UXToggleButton;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

import javax.xml.ws.spi.Invoker;

@Reflection.Name("UXBottomNavigationButton")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXBottomNavigationButton extends UXControl<BottomNavigationButton> {


    public UXBottomNavigationButton(Environment env, BottomNavigationButton wrappedObject) {
        super(env, wrappedObject);
    }

    public UXBottomNavigationButton(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(){
        __wrappedObject = new BottomNavigationButton();
    }

    @Reflection.Setter
    public void setText(String text){
        getWrappedObject().setText(text);
    }

    @Reflection.Getter
    public String getText(){
        return getWrappedObject().getText();
    }

    @Reflection.Setter
    public void setGraphic(Node graphic){
        getWrappedObject().setGraphic(graphic);
    }

    @Reflection.Signature
    public void setOnAction(php.runtime.invoke.Invoker i) {
        getWrappedObject().setOnAction(event -> {
            try {
                i.call();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    @Reflection.Getter
    public Node getGraphic(){
        return getWrappedObject().getGraphic();
    }

}
