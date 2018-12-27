package org.venity.jphp.android.classes.widget;

import android.content.Context;
import android.widget.TextView;
import org.venity.jphp.android.AndroidExtension;
import org.venity.jphp.android.classes.view.WrapView;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Reflection.Name("TextView")
@Reflection.Namespace(AndroidExtension.WIDGET_NS)
public class WrapTextView extends WrapView {
    public WrapTextView(Environment env, TextView wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapTextView(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public TextView getWrappedObject() {
        return (TextView) super.getWrappedObject();
    }

    @Reflection.Signature
    public void __construct(Context activity) {
        __wrappedObject = new TextView(activity);
        getWrappedObject().setId(idCounter.getAndIncrement());
    }

    @Reflection.Setter
    public void setText(String text) {
        getWrappedObject().setText(text);
    }

    @Reflection.Getter
    public CharSequence getText() {
        return getWrappedObject().getText();
    }

    @Reflection.Setter
    public void setInputType(int type) {
        getWrappedObject().setInputType(type);
    }

    @Reflection.Getter
    public int getInputType() {
        return getWrappedObject().getInputType();
    }

    public interface WrappedInterface {
        @Reflection.Property int highlightColor();
        @Reflection.Property int gravity();
        @Reflection.Property int paintFlags();
        @Reflection.Property int minLines();
        @Reflection.Property int minHeight();
        @Reflection.Property int maxLines();
        @Reflection.Property int maxHeight();
        @Reflection.Property int minWidth();
        @Reflection.Property int maxWidth();
        @Reflection.Property int minEms();
        @Reflection.Property int maxEms();
        @Reflection.Property float textSize();
        @Reflection.Property float textScaleX();
        @Reflection.Property boolean freezesText();
        @Reflection.Property boolean cursorVisible();
        @Reflection.Property CharSequence hint();

        int getShadowColor();
        float getLineSpacingMultiplier();
        float getLineSpacingExtra();
        float getShadowRadius();
        float getShadowDx();
        float getShadowDy();
        void append(CharSequence text, int start, int end);
        void setLineSpacing(float add, float mult);
        void setShadowLayer(float radius, float dx, float dy, int color);
    }
}
