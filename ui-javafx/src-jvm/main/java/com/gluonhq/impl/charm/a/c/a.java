package com.gluonhq.impl.charm.a.c;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.StorageService;
import com.gluonhq.charm.glisten.license.License;
import javafx.application.Platform;

import java.io.*;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class a {
    private static final Logger a = Logger.getLogger(a.class.getName());
    private static File b;

    public a() {
    }

    public static boolean a(final String var0, License var1, final Runnable var2) {
        return true;
    }

    public static String a(String var0) {
        try {
            var0 = "C!@rm" + var0 + "Licen$e";
            MessageDigest var1;
            (var1 = MessageDigest.getInstance("SHA-256")).update(var0.getBytes("UTF-8"));
            byte[] var5 = var1.digest();
            StringBuilder var6 = new StringBuilder();

            for(int var2 = 0; var2 < var5.length; ++var2) {
                String var3;
                if ((var3 = Integer.toHexString(255 & var5[var2])).length() == 1) {
                    var6.append("0");
                }

                var6.append(var3);
            }

            return var6.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException var4) {
            return "";
        }
    }

    static {
        try {
            b = (File) Services.get(StorageService.class).flatMap(StorageService::getPrivateStorage).orElseThrow(() -> {
                return new IOException("Private storage file not available");
            });
        } catch (IOException var1) {
            a.log(Level.SEVERE, (String)null, var1);
        }
    }
}
