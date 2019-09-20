package jpfa.pkg.android.classes;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import jpfa.pkg.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("Button")
@Reflection.Namespace(AndroidExtension.NS)
public class PButton extends PView {
    public PButton(Environment env) {
        super(env);
    }

    protected PButton(ClassEntity entity) {
        super(entity);
    }

    public PButton(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public View makeView(Context context) {
        return new Button(context);
    }
}
