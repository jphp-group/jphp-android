package org.venity.jphp.ext.android.fx.support.event;

import javafx.scene.media.MediaPlayer;
import org.venity.jphp.ext.android.fx.support.EventProvider;

// TODO
public class MediaPlayerEventProvider extends EventProvider<MediaPlayer> {
    public MediaPlayerEventProvider() {
    }

    @Override
    public Class<MediaPlayer> getTargetClass() {
        return MediaPlayer.class;
    }
}
