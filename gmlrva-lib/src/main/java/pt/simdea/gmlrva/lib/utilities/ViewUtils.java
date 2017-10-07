package pt.simdea.gmlrva.lib.utilities;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.WindowManager;

/**
 * TODO...
 * Created by Paulo on 10/7/2017.
 */
@SuppressWarnings("unused") public final class ViewUtils {

    private static int deviceScreenHeight = 0;
    private static int deviceScreenWidth = 0;

    /**
     * Instantiates a new ViewUtil.
     * Private to prevent instantiation.
     */
    private ViewUtils() {
        throw new AssertionError("Instantiating utility class.");  // Throw an exception if this *is* ever called
    }

    /**
     * Procedure meant to provide the device's screen height in pixels.
     * @param context the application's current {@link Context}.
     * @return an Integer value representing the device's screen height, in pixels.
     */
    public static int getDeviceScreenHeight(@NonNull final Context context) {
        if (deviceScreenHeight == 0) {
            final WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            final Display display = windowManager.getDefaultDisplay();
            final Point size = new Point();
            display.getSize(size);
            deviceScreenHeight = size.y;
        }
        return deviceScreenHeight;
    }

    /**
     * Procedure meant to provide the device's screen width in pixels.
     * @param context the application's current {@link Context}.
     * @return an Integer value representing the device's screen width, in pixels.
     */
    public static int getDeviceScreenWidth(@NonNull final Context context) {
        if (deviceScreenWidth == 0) {
            final WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            final Display display = windowManager.getDefaultDisplay();
            final Point size = new Point();
            display.getSize(size);
            deviceScreenWidth = size.x;
        }
        return deviceScreenWidth;
    }

}
