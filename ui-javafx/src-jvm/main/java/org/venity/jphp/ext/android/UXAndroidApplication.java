package org.venity.jphp.ext.android;

import com.gluonhq.charm.glisten.application.MobileApplication;

import javafx.scene.Scene;
import com.gluonhq.charm.down.Platform;
import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.DisplayService;
import javafx.stage.Stage;
import org.venity.jphp.ext.android.android.classes.UXMobileApplication;

import java.io.IOException;

public class UXAndroidApplication extends MobileApplication {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws IOException {
		StandaloneAndroidLoader loader = new StandaloneAndroidLoader();
		loader.setClassLoader(getClass().getClassLoader());
		loader.loadLibrary();
		loader.run();
	}

    @Override
    public void postInit(Scene scene) {
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

        UXMobileApplication.getCallback().callNoThrow();
    }
}
