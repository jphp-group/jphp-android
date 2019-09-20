package org.venity.jphp.ext.android.fx;

import org.venity.jphp.ext.android.AndroidExtension;

public class JavaFXExtension {

    public static final String NS = AndroidExtension.NS_FX + "\\"; // lol

    public static boolean isJigsaw()
    {
        return AndroidExtension.isJigsaw();
    }
}