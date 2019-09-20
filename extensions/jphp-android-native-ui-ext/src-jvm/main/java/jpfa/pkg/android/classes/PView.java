package jpfa.pkg.android.classes;

import android.content.Context;
import android.view.View;
import jpfa.pkg.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseObject;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("View")
@Reflection.Namespace(AndroidExtension.NS)
public class PView extends BaseObject {
    public PView(Environment env) {
        super(env);
    }

    protected PView(ClassEntity entity) {
        super(entity);
    }

    public PView(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    public View makeView(Context context) {
        return new View(context);
    }
}
