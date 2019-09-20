package org.venity.jphp.ext.android.fx.classes;

import javafx.scene.control.IndexRange;
import javafx.scene.control.TextInputControl;
import javafx.scene.text.Font;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.classes.text.UXFont;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.*;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Abstract
@Name("UXTextInputControl")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXTextInputControl<T extends TextInputControl> extends UXControl {
    interface WrappedInterface {
        @Property int anchor();
        @Property int caretPosition();
        @Property int length();
        @Property String promptText();
        @Property String selectedText();
        @Property String text();

        @Property boolean editable();

        void appendText(String text);
        void backward();
        void clear();
        void copy();
        void cut();

        void deselect();

        void end();
        void endOfNextWord();

        void extendSelection(int pos);
        void forward();
        void home();

        void insertText(int index, String text);
        void replaceSelection(String replacement);
        void replaceText(int start, int end, String text);
        void deleteText(int start, int end);

        void paste();
        void positionCaret(int pos);

        void nextWord();
        void previousWord();
        void selectAll();
        void selectBackward();
        void selectEnd();
        void selectEndOfNextWord();
        void selectForward();
        void selectHome();
        void selectNextWord();
        void selectPositionCaret(int pos);
        void selectPreviousWord();
        void selectRange(int anchor, int caretPosition);

        void undo();
        void redo();
        void cancelEdit();
        void commitValue();
    }

    public UXTextInputControl(Environment env, T wrappedObject) {
        super(env, wrappedObject);
    }

    public UXTextInputControl(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    public T getWrappedObject() {
        return (T) super.getWrappedObject();
    }

    @Getter
    public IndexRange getSelection() {
        return getWrappedObject().getSelection();
    }

    @Setter
    protected void setSelectedText(String value) {
        getWrappedObject().replaceSelection(value);
    }

    @Getter
    public UXFont getFont(Environment env) {
        return new UXFont(env, getWrappedObject().getFont(), font -> getWrappedObject().setFont(font));
    }

    @Setter
    public void setFont(Font font) {
        getWrappedObject().setFont(font);
    }
}
