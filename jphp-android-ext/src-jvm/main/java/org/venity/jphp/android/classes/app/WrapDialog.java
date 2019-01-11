package org.venity.jphp.android.classes.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import org.venity.jphp.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("Dialog")
@Reflection.Namespace(AndroidExtension.APP_NS)
public class WrapDialog extends BaseWrapper<Dialog> {
    public WrapDialog(Environment env, Dialog wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapDialog(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(Context context) {
        __wrappedObject = new Dialog(context);
    }

    @Reflection.Signature
    public void setContentViewById(int id)
    {
        getWrappedObject().setContentView(id);
    }

    @Reflection.Signature
    public void setTitleById(int id)
    {
        getWrappedObject().setTitle(id);
    }

    public interface WrappedInterface {
        @Reflection.Property Activity ownerActivity();

        View getCurrentFocus();
        View findViewById(int id);

        void setContentView(View view);
        void setTitle(CharSequence title);
        void show();
        void hide();
        void dismiss();
        void cancel();

        boolean isShowing();
    }
}
