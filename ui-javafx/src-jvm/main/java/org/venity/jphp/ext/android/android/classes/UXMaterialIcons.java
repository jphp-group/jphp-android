package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.Node;
import org.venity.jphp.ext.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXMaterialIcons")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXMaterialIcons extends BaseWrapper<MaterialDesignIcon>{
    public UXMaterialIcons(Environment env, MaterialDesignIcon wrappedObject) {
        super(env, wrappedObject);
    }

    public UXMaterialIcons(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(String icon){
        __wrappedObject = MaterialDesignIcon.valueOf(icon.toUpperCase());
    }

    @Reflection.Signature
    public static MaterialDesignIcon of(String icon){
        return MaterialDesignIcon.valueOf(icon.toUpperCase());
    }

    @Reflection.Signature
    public void __construct() {
        __wrappedObject = MaterialDesignIcon.CODE;
    }

    @Reflection.Signature
    public Node graphic() {
        return getWrappedObject().graphic("");
    }

    @Reflection.Signature
    public Node graphic(String styles) {
        return getWrappedObject().graphic(styles);
    }

    @Reflection.Signature
    public Node button() {
        return getWrappedObject().button(null);
    }

    @Reflection.Signature
    public Node button(Invoker callback) {
        return getWrappedObject().button(event -> {
            if (callback != null)
                callback.callNoThrow();
        });
    }

}
