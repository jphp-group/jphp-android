package org.venity.jphp.ext.android;

import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class SplashView extends View {

    public SplashView() {
        super();

        setCenter(new ImageView(new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("splash_image.png")))));
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        super.updateAppBar(appBar);

        appBar.setVisible(false);
    }
}
