package org.venity.jphp.ext.android;

import com.gluonhq.charm.glisten.application.MobileApplication;
import java.io.IOException;

import com.gluonhq.charm.glisten.control.TextArea;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Scene;
import com.gluonhq.charm.glisten.control.ExceptionDialog;
import javafx.scene.control.Label;
import org.venity.jphp.ext.android.android.classes.UXMobileApplication;

public class UXAndroidApplication extends MobileApplication {

    @Override
    public void postInit(Scene scene) {
		try {
			StandaloneAndroidLoader loader = new StandaloneAndroidLoader();
			System.out.println("Starting JPHP android application");
				System.out.println("Code with love by venity");

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
