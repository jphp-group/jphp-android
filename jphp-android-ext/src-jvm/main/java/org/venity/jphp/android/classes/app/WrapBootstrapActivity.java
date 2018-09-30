package org.venity.jphp.android.classes.app;

import android.os.Bundle;
import org.venity.jphp.android.AndroidExtension;
import org.venity.jphp.android.AndroidStandaloneLoader;
import php.runtime.annotation.Reflection;

@Reflection.Name("BootstrapActivity")
@Reflection.Namespace(AndroidExtension.APP_NS)
public class WrapBootstrapActivity extends WrapActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreateClearly(savedInstanceState);

        AndroidStandaloneLoader.INSTANCE.run(this);

        getEnvironment().invokeMethodNoThrow(this, "onCreate");
    }
}