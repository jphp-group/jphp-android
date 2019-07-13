package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.layout.MobileLayoutPane;
import javafx.scene.Node;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.classes.layout.UXBorderPane;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXMobileLayoutPane")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXMobileLayoutPane extends UXBorderPane {

    public UXMobileLayoutPane(Environment env, MobileLayoutPane wrappedObject) {
        super(env, wrappedObject);
    }

    public UXMobileLayoutPane(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct()
    {
        __wrappedObject = new MobileLayoutPane();
    }

    @Reflection.Signature
    public void __construct(Node center)
    {
        __wrappedObject = new MobileLayoutPane(center);
    }
}
