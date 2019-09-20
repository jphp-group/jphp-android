package jpfa.pkg.android;

import jpfa.pkg.android.classes.PActivity;
import jpfa.pkg.android.classes.PApplication;
import jpfa.pkg.android.classes.PButton;
import jpfa.pkg.android.classes.PView;
import php.runtime.env.CompileScope;
import php.runtime.ext.support.Extension;

public class AndroidExtension extends Extension {
    public static final String NS = "php\\android";

    @Override
    public String getName() {
        return "JPFA Native API";
    }

    @Override
    public Status getStatus() {
        return Status.EXPERIMENTAL;
    }
    
    @Override
    public void onRegister(CompileScope scope) {
        registerClass(scope, PActivity.class, PApplication.class, PView.class, PButton.class);
    }
}