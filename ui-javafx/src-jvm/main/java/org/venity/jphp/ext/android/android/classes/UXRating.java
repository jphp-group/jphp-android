package org.venity.jphp.ext.android.android.classes;

import com.gluonhq.charm.glisten.control.Rating;
import javafx.geometry.Orientation;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.classes.UXControl;
import org.venity.jphp.ext.android.fx.classes.paint.UXColor;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("UXRating")
@Reflection.Namespace(AndroidExtension.NS_ANDROID)
public class UXRating extends UXControl<Rating> {

    @Reflection.Getter
    public int getMax() {
        return getWrappedObject().getMax();
    }

    @Reflection.Setter
    public void setMax(int max) {
        getWrappedObject().setMax(max);
    }

    @Reflection.Getter
    public String getOrientation() {
        return getWrappedObject().getOrientation().name();
    }

    @Reflection.Setter
    public void setOrientation(String or) {
        getWrappedObject().setOrientation(Orientation.valueOf(or));
    }

    @Reflection.Getter
    public boolean getPartialRating() {
        return getWrappedObject().isPartialRating();
    }

    @Reflection.Setter
    public void setPartialRating(boolean PA) {
        getWrappedObject().setPartialRating(PA);
    }

    @Reflection.Getter
    public Double getRating() {
        return getWrappedObject().getRating();
    }

    @Reflection.Setter
    public void setRating(Double r) {
        getWrappedObject().setRating(r);
    }

    @Reflection.Getter
    public boolean getUpdateOnHover() {
        return getWrappedObject().isUpdateOnHover();
    }

    @Reflection.Setter
    public void setUpdateOnHover(boolean u) {
        getWrappedObject().setUpdateOnHover(u);
    }

    @Reflection.Signature
    public void __construct(){
        __wrappedObject = new Rating();
    }

    public UXRating(Environment env, Rating wrappedObject) {
        super(env, wrappedObject);
    }

    public UXRating(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }


}
