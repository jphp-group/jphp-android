package jpfa.pkg.android;

import android.app.Activity;
import android.os.Bundle;
import jpfa.pkg.android.classes.PActivity;
import jpfa.pkg.android.classes.PApplication;

public class AppActivity extends Activity {

    private static boolean jphpRuning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PApplication.setShowActivityCallback(() -> {
            PActivity activity = PApplication.getActivities().get(
                    PApplication.getCurrentActivity());

            setContentView(activity.makeLayout(this));
        });

        if (!jphpRuning) {
            AndroidStandaloneLoader.INSTANCE.run(this);
            jphpRuning = true;
        } else {
            AndroidStandaloneLoader.INSTANCE.setMainActivity(this);
            PApplication.getShowActivityCallback().run();
        }
    }
}