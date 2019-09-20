package org.venity.jphp.ext.android.fx.classes;

import javafx.beans.value.ObservableValue;
import javafx.scene.web.WebHistory;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.support.JavaFxUtils;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Abstract;
import php.runtime.annotation.Reflection.Property;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.memory.ArrayMemory;
import php.runtime.reflection.ClassEntity;

@Abstract
@Reflection.Name("UXWebHistory")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXWebHistory extends BaseWrapper<WebHistory> {
    interface WrappedInterface {
        @Property int currentIndex();
        @Property int maxSize();

        void go(int index);
    }

    public UXWebHistory(Environment env, WebHistory wrappedObject) {
        super(env, wrappedObject);
    }

    public UXWebHistory(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public void goBack() {
        getWrappedObject().go(-1);
    }

    @Signature
    public void goForward() {
        getWrappedObject().go(1);
    }

    @Signature
    public ObservableValue observer(String property) {
        return JavaFxUtils.findObservable(this, property);
    }

    @Signature
    public ArrayMemory getEntries() {
        ArrayMemory result = new ArrayMemory();

        for (WebHistory.Entry entry : getWrappedObject().getEntries()) {
            ArrayMemory item = new ArrayMemory();
            item.refOfIndex("url").assign(entry.getUrl());
            item.refOfIndex("title").assign(entry.getTitle());
            item.refOfIndex("lastVisited").assign(entry.getLastVisitedDate().getTime());

            result.add(result);
        }

        return result.toConstant();
    }
}
