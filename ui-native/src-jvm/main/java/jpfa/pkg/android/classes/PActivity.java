package jpfa.pkg.android.classes;

import android.content.Context;
import android.view.View;
import jpfa.pkg.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseObject;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("Activity")
@Reflection.Namespace(AndroidExtension.NS)
public class PActivity extends BaseObject {
    private PView layout;

    public PActivity(Environment env) {
        super(env);
    }

    protected PActivity(ClassEntity entity) {
        super(entity);
    }

    public PActivity(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    public View makeLayout(Context context) {
        return layout.makeView(context);
    }

    @Reflection.Getter
    public PView getLayout() {
        return layout;
    }

    @Reflection.Setter
    public void setLayout(PView layout) {
        this.layout = layout;
    }
}
