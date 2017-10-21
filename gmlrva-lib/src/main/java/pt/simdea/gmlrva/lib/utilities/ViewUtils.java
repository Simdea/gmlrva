/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.utilities;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.WindowManager;

/**
 * Auxiliary View related Utils class.
 *
 * Created by Paulo Ribeiro on 7/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
@SuppressWarnings("unused")
public final class ViewUtils {

    @IntRange(from = 0)
    private static int sDeviceScreenHeight;
    @IntRange(from = 0)
    private static int sDeviceScreenWidth;

    /**
     * Instantiates a new ViewUtil.
     * Private to prevent instantiation.
     */
    private ViewUtils() {
        throw new AssertionError(GMLRVAConstants.ASSERTION_ERROR);  // Throw an exception if this *is* ever called
    }

    /**
     * Procedure meant to provide the device's screen height in pixels.
     * @param context the application's current {@link Context}.
     * @return an Integer value representing the device's screen height, in pixels.
     */
    @IntRange(from = 0) public static int getDeviceScreenHeight(@NonNull final Context context) {
        if (sDeviceScreenHeight == 0) {
            final WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            final Display display = windowManager.getDefaultDisplay();
            final Point size = new Point();
            display.getSize(size);
            sDeviceScreenHeight = size.y;
        }
        return sDeviceScreenHeight;
    }

    /**
     * Procedure meant to provide the device's screen width in pixels.
     * @param context the application's current {@link Context}.
     * @return an Integer value representing the device's screen width, in pixels.
     */
    @IntRange(from = 0) public static int getDeviceScreenWidth(@NonNull final Context context) {
        if (sDeviceScreenWidth == 0) {
            final WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            final Display display = windowManager.getDefaultDisplay();
            final Point size = new Point();
            display.getSize(size);
            sDeviceScreenWidth = size.x;
        }
        return sDeviceScreenWidth;
    }

}
