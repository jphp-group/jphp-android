package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.control.NavigationDrawer;
import javafx.scene.Node;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.classes.UXControl;
import org.venity.jphp.ext.android.fx.classes.UXList;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXNavigationDrawer")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXNavigationDrawer extends UXControl<NavigationDrawer> {

    public UXNavigationDrawer(Environment env, NavigationDrawer wrappedObject) {
        super(env, wrappedObject);
    }

    public UXNavigationDrawer(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(){
        __wrappedObject = new NavigationDrawer();
    }

    @Reflection.Getter
    public Node getFooter(){
        return getWrappedObject().getFooter();
    }

    @Reflection.Getter
    public Node getHeader(){
        return getWrappedObject().getHeader();
    }

    @Reflection.Setter
    public void setHeader(Node N){
        getWrappedObject().setHeader(N);
    }

    @Reflection.Setter
    public void setFooter(Node N){
        getWrappedObject().setFooter(N);
    }

    @Reflection.Getter
    public UXList<Node> getItems(){
        return new UXList<Node>(__env__, getWrappedObject().getItems());
    }

    @Reflection.Getter
    public Node getSelectedItem(){
        return getWrappedObject().getSelectedItem();
    }

    @Reflection.Setter
    public void setSelectedItem(Node N){
        getWrappedObject().setSelectedItem(N);
    }

    @Reflection.Signature
    public void open(){
        getWrappedObject().open();
    }

    @Reflection.Signature
    public void close(){
        getWrappedObject().close();
    }
}
