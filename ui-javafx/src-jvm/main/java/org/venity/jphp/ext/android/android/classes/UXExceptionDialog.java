package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.control.Dialog;
import com.gluonhq.charm.glisten.control.ExceptionDialog;
import org.venity.jphp.ext.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;
import java.lang.Exception;

@Reflection.Name("UXExceptionDialog")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXExceptionDialog extends UXAndroidDialog {


    public UXExceptionDialog(Environment env, ExceptionDialog wrappedObject) {
        super(env, wrappedObject);
    }

    public UXExceptionDialog(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(){
        __wrappedObject = new ExceptionDialog();
    }


    interface WrappedInterface{
        @Reflection.Property Exception exception();
        @Reflection.Property String    introText();
    }

}
