package org.venity.jphp.ext.android.fx.classes;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.Abstract;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.exceptions.CriticalException;
import php.runtime.exceptions.CustomErrorException;
import php.runtime.ext.core.classes.stream.ResourceStream;
import php.runtime.ext.core.classes.stream.Stream;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

import java.awt.*;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Abstract
@Name("UXApplication")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXApplication extends BaseWrapper<Application> {
    private static Invoker onStart;
    private static boolean shutdown = false;

    public UXApplication(Environment env, Application wrappedObject) {
        super(env, wrappedObject);
    }

    public UXApplication(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public static String getPid() {
        // Should return something like '<pid>@<hostname>', at least in SUN / Oracle JVMs
        final String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        final int index = jvmName.indexOf('@');

        String pid = jvmName.substring(0, index);
        return pid;
    }

    @Signature
    public static boolean isShutdown() {
        return false; // lol
    }

    @Signature
    public static void setImplicitExit(boolean value) {
        Platform.setImplicitExit(value);
    }

    @Signature
    public static boolean isImplicitExit() {
        return Platform.isImplicitExit();
    }

    @Signature
    public static boolean isUiThread() {
        return Platform.isFxApplicationThread();
    }

    @Signature
    public static Memory runLaterAndWait(final Invoker callback) throws Throwable {
        if (isShutdown()) {
            return Memory.NULL;
        }

        if (Platform.isFxApplicationThread()) {
            return callback.call();
        }

        new JFXPanel();

        FutureTask<Memory> futureTask = new FutureTask<>(() -> {
            try {
                return callback.callNoThrow();
            } catch (Exception e) {
                callback.getEnvironment().catchUncaught(e);
                return Memory.NULL;
            }
        });

        Platform.runLater(futureTask);

        try {
            return futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new CriticalException(e);
        }
    }

    @Signature
    public static void runLater(final Invoker callback) {
        if (isShutdown()) {
            return;
        }

        new JFXPanel(); // lol WTF!?

        Platform.runLater(() -> {
            try {
                callback.callNoThrow();
            } catch (Exception e) {
                callback.getEnvironment().catchUncaught(e);
            }
        });
    }

    @Signature
    public static void shutdown() {
        shutdown = true;
        Platform.exit();

        Window[] windows = Window.getWindows();

        for (Window window : windows) {
            window.dispose();
        }
    }
}
