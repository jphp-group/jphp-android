package jpfa.pkg.android.classes;

import jpfa.pkg.android.AndroidExtension;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.ext.java.JavaException;
import php.runtime.lang.BaseObject;
import php.runtime.reflection.ClassEntity;

import java.util.HashMap;
import java.util.Map;

@Reflection.Name("Application")
@Reflection.Namespace(AndroidExtension.NS)
public class PApplication extends BaseObject {
    private static Map<String, PActivity> activities = new HashMap<>();
    private static String currentActivity;
    private static Runnable showActivityCallback;

    public PApplication(Environment env) {
        super(env);
    }

    protected PApplication(ClassEntity entity) {
        super(entity);
    }

    public PApplication(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public static void addActivity(String name, PActivity activity) {
        activities.put(name, activity);
    }

    @Reflection.Signature
    public static void showActivity(Environment environment, String name) {
        if (activities.containsKey(name)) {
            currentActivity = name;

            if (showActivityCallback != null)
                showActivityCallback.run();
        } else {
            environment.__throwException(
                    new JavaException(environment,
                            new IllegalArgumentException("Activity " + name + " don`t exists")));
        }
    }

    public static Map<String, PActivity> getActivities() {
        return activities;
    }

    public static void setShowActivityCallback(Runnable showActivityCallback) {
        PApplication.showActivityCallback = showActivityCallback;
    }

    public static String getCurrentActivity() {
        return currentActivity;
    }

    public static Runnable getShowActivityCallback() {
        return showActivityCallback;
    }
}
