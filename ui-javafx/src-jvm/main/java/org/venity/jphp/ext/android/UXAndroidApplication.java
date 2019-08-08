package org.venity.jphp.ext.android;

import com.gluonhq.charm.glisten.application.MobileApplication;

import javafx.scene.Scene;
import com.gluonhq.charm.down.Platform;
import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.DisplayService;
import javafx.stage.Stage;
import org.venity.jphp.ext.android.android.classes.UXMobileApplication;
import php.runtime.Memory;

public class UXAndroidApplication extends MobileApplication {

    private StandaloneAndroidLoader loader;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() {
	    addViewFactory("$$$Splash$$$", SplashView::new);

	    new Thread(() -> {
	        // load jPHP
	        try {
                loader = new StandaloneAndroidLoader();
                loader.setClassLoader(getClass().getClassLoader());
                loader.loadLibrary();
                loader.run();
            } catch (Throwable exception) {
	            exception.printStackTrace();
            }
        }).start();
	}

    @Override
    public void postInit(Scene scene) {
	    switchView("$$$Splash$$$");

        if (Platform.isDesktop()) {
            Services.get(DisplayService.class)
                 .ifPresent(service -> {
                        if (service.isTablet()) {
                            scene.getWindow().setWidth(600);
                            scene.getWindow().setHeight(800);
                        }
                 });

            Stage stage = (Stage) scene.getWindow();
            stage.setTitle("jPHP For Android sandbox");
        }

        new Thread(() -> {
            while (true) {
                if (loader.isLoaded()) {
                    javafx.application.Platform.runLater(() -> {
                        if (UXMobileApplication.getCallback() != null)
                            UXMobileApplication.getCallback().callNoThrow(Memory.wrap(loader.env, scene));
                    });

                    break;
                }
            }
        }).start();
    }
}
