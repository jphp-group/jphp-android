package org.venity.jphp.ext.android;

import com.gluonhq.charm.glisten.application.MobileApplication;

import com.gluonhq.charm.glisten.control.TextArea;
import com.gluonhq.charm.glisten.layout.Layer;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import com.gluonhq.charm.down.Platform;
import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.DisplayService;
import javafx.stage.Stage;

public class UXAndroidApplication extends MobileApplication {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() {

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

		try {
			StandaloneAndroidLoader loader = new StandaloneAndroidLoader();
			loader.setClassLoader(getClass().getClassLoader());
			loader.loadLibrary();
			loader.run();
		} catch (Exception e) {
			getAppBar().setNavIcon(MaterialDesignIcon.CLOSE.button(event -> {
				System.exit(1);
			}));
			getAppBar().setTitleText("Экзептион");
			View errView = new View("errView");
			TextArea t = new TextArea();
			Label l = new Label();
			l.setText("Unхунделед экзептион окуред ин йоар апплликатион. фикс ит плз");
			errView.setCenter(t);
			errView.setTop(l);
			t.setText("Произошла ашибка - " + e.getMessage() + ".\r\nДобавьте try или найдите прямые руки");
			addViewFactory("errView", () -> errView);
			switchView("errView");
			e.printStackTrace();
		}
    }
}
