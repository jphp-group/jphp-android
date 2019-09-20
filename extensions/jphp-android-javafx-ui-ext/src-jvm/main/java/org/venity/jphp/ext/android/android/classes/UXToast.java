package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.control.Toast;
import javafx.util.Duration;
import org.venity.jphp.ext.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseObject;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXToast")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXToast extends BaseWrapper<Toast> {

    public UXToast(Environment env, Toast wrappedObject) {
        super(env, wrappedObject);
    }

    public UXToast(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(){
        __wrappedObject = new Toast();
    }

    @Reflection.Signature
    public void cancel(){
        getWrappedObject().cancel();
    }

    @Reflection.Signature
    public void show(){
        getWrappedObject().show();
    }

    @Reflection.Setter
    public void setText(String text){
        getWrappedObject().setMessage(text);
    }

    @Reflection.Getter
    public String getText(){
        return getWrappedObject().getMessage();
    }

    @Reflection.Setter
    public void setDuration(int ms){
        getWrappedObject().setDuration(new Duration(ms));
    }

    @Reflection.Getter
    public int getDuration(){
        return (int) getWrappedObject().getDuration().toMillis();
    }

}
