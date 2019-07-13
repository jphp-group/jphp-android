package org.venity.jphp.ext.android.fx.classes.event;

import javafx.scene.input.ContextMenuEvent;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Property;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Name("UXContextMenuEvent")
@Reflection.Namespace("php\\gui\\event")
public class UXContextMenuEvent extends UXEvent {
    interface WrappedInterface {
        @Property double sceneX();
        @Property double sceneY();

        @Property double screenX();
        @Property double screenY();

        @Property double x();
        @Property double y();

        @Property boolean keyboardTrigger();
    }

    public UXContextMenuEvent(Environment env, ContextMenuEvent wrappedObject) {
        super(env, wrappedObject);
    }

    public UXContextMenuEvent(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public ContextMenuEvent getWrappedObject() {
        return (ContextMenuEvent) super.getWrappedObject();
    }
}
