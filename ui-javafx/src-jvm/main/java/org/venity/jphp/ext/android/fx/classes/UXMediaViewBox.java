package org.venity.jphp.ext.android.fx.classes;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.classes.layout.UXPanel;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import org.venity.jphp.ext.android.fx.support.control.MediaViewBox;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Nullable;
import php.runtime.annotation.Reflection.Property;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

import java.io.File;

@Reflection.Name("UXMediaViewBox")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXMediaViewBox extends UXPanel<MediaViewBox> {
    interface WrappedInterface {
        @Property("player") @Nullable MediaPlayer mediaPlayer();
        @Property boolean proportional();
        @Property boolean smooth();
    }

    public UXMediaViewBox(Environment env, MediaViewBox wrappedObject) {
        super(env, wrappedObject);
    }

    public UXMediaViewBox(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Override
    @Signature
    public void __construct() {
        __wrappedObject = new MediaViewBox();
    }

    @Signature
    public void open(String fileName) {
        open(fileName, true);
    }

    @Signature
    public void open(String fileName, boolean autoPlay) {
        getWrappedObject().setMediaPlayer(new MediaPlayer(new Media(new File(fileName).toURI().toString())));

        if (autoPlay) {
            play();
        }
    }

    @Signature
    public boolean play() {
        if (getWrappedObject().getMediaPlayer() == null) {
            return false;
        }

        getWrappedObject().getMediaPlayer().play();
        return true;
    }

    @Signature
    public boolean stop() {
        if (getWrappedObject().getMediaPlayer() == null) {
            return false;
        }

        getWrappedObject().getMediaPlayer().stop();
        return true;
    }

    @Signature
    public boolean pause() {
        if (getWrappedObject().getMediaPlayer() == null) {
            return false;
        }

        getWrappedObject().getMediaPlayer().pause();
        return true;
    }
}
