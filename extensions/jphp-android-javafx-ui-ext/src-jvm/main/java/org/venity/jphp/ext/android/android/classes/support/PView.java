package org.venity.jphp.ext.android.android.classes.support;

import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.beans.NamedArg;
import javafx.scene.Node;
import org.venity.jphp.ext.android.android.classes.UXAppBar;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;
import php.runtime.memory.ObjectMemory;

public class PView extends View {

    private Invoker updateAppBar;
    private Environment env;

    public PView(@NamedArg("content") Node content) {
        super(content);
    }
    public PView() {
        super();
    }

    public final void updateAppBar(AppBar a){
        if (this.updateAppBar != null){
            try {
                this.updateAppBar.call(new ObjectMemory(new UXAppBar(env, a)));
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public void setOnAppBarUpdate(Invoker i, Environment env){
        this.updateAppBar = i;
        this.env = env;
    }
}
