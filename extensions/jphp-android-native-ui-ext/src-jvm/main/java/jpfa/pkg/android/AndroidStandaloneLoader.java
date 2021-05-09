package jpfa.pkg.android;

import android.app.Activity;
import android.content.Context;
import php.runtime.Memory;
import php.runtime.env.Environment;
import php.runtime.env.TraceInfo;
import php.runtime.exceptions.CriticalException;
import php.runtime.ext.core.classes.WrapClassLoader;
import php.runtime.ext.support.Extension;
import php.runtime.launcher.LaunchException;
import php.runtime.loader.StandaloneLoader;
import php.runtime.reflection.ClassEntity;
import php.runtime.reflection.ModuleEntity;
import php.runtime.reflection.support.ReflectionUtils;

import java.io.IOException;
import java.util.Iterator;
import java.util.ServiceLoader;

public class AndroidStandaloneLoader extends StandaloneLoader {
    public static final AndroidStandaloneLoader INSTANCE;

    private Activity mainActivity;
    private Context context;

    public AndroidStandaloneLoader() {
        super();
    }

    public void run(Activity mainActivity) {
        this.mainActivity = mainActivity;

        try {
            this.setClassLoader(this.getClass().getClassLoader());
            this.loadLibrary();
            this.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadExtensions() {
        ServiceLoader<Extension> loader = ServiceLoader.load(Extension.class, this.getClass().getClassLoader());

        for (Extension extension : loader) {
            System.out.println("Register jPHP Extension: " + extension.getName() + " [" + extension.getVersion() + "]");
            this.scope.registerExtension(extension);
        }
    }

    public void run() {
        readConfig();

        String classLoader = config.getProperty(
                "env.classLoader",
                ReflectionUtils.getClassName(WrapClassLoader.WrapLauncherClassLoader.class)
        );

        if (classLoader != null && !(classLoader.isEmpty())) {
            ClassEntity classLoaderEntity = env.fetchClass(classLoader);

            if (classLoaderEntity == null) {
                throw new LaunchException("Class loader class is not found: " + classLoader);
            }

            try {
                WrapClassLoader loader = classLoaderEntity.newObject(env, TraceInfo.UNKNOWN, true);
                env.invokeMethod(loader, "register", Memory.TRUE);
            } catch (Throwable e) {
                throw new CriticalException(e);
            }
        }

        run("index.php");
    }

    protected void run(String bootstrapScriptName) {
        loadExtensions();

        try {
            loadLibrary();

            ModuleEntity bootstrap = fetchModule(bootstrapScriptName);

            if (bootstrap != null) {
                bootstrap.includeNoThrow(env);
            } else {
                throw new CriticalException("(!) Cannot find bootstrap script.");
            }
        } catch (IOException e) {
            throw new CriticalException(e);
        }
    }
    public void setMainActivity(Activity activity) {
        INSTANCE.mainActivity = activity;
    }

    public static Activity getMainActivity() {
        return INSTANCE.mainActivity;
    }

    public static Environment getEnvironment() {
        return INSTANCE == null ? null : INSTANCE.env;
    }

    public static Context getContext() {
        return INSTANCE.mainActivity.getApplicationContext();
    }

    static {
        INSTANCE = new AndroidStandaloneLoader();
    }
}