/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.lib.utilities

import android.content.Context
import android.graphics.Point
import androidx.annotation.IntRange
import android.view.Display
import android.view.WindowManager

/**
 * Auxiliary View related Utils class.
 *
 * Created by Paulo Ribeiro on 7/7/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class ViewUtils
/**
 * Instantiates a new ViewUtil.
 * Private to prevent instantiation.
 * @throws AssertionError if this constructor is ever called. Utility classes should not be instantiated.
 */
private constructor() {

    init {
        throw AssertionError(GMLRVAConstants.ASSERTION_ERROR)  // Throw an exception if this *is* ever called
    }

    companion object {

        @IntRange(from = 0)
        private var sDeviceScreenHeight: Int = 0
        @IntRange(from = 0)
        private var sDeviceScreenWidth: Int = 0

        /**
         * Procedure meant to provide the device's screen height in pixels.
         * @param context the application's current [Context].
         * @return an Integer value representing the device's screen height, in pixels.
         */
        @IntRange(from = 0)
        fun getDeviceScreenHeight(context: Context): Int {
            synchronized(ViewUtils::class.java) {
                if (sDeviceScreenHeight == 0) {
                    val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
                    if (windowManager != null) {
                        val display = windowManager.defaultDisplay
                        val size = Point()
                        display.getSize(size)
                        sDeviceScreenHeight = size.y
                    }
                }
            }
            return sDeviceScreenHeight
        }

        /**
         * Procedure meant to provide the device's screen width in pixels.
         * @param context the application's current [Context].
         * @return an Integer value representing the device's screen width, in pixels.
         */
        @IntRange(from = 0)
        fun getDeviceScreenWidth(context: Context): Int {
            synchronized(ViewUtils::class.java) {
                if (sDeviceScreenWidth == 0) {
                    val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
                    if (windowManager != null) {
                        val display = windowManager.defaultDisplay
                        val size = Point()
                        display.getSize(size)
                        sDeviceScreenWidth = size.x
                    }
                }
            }
            return sDeviceScreenWidth
        }
    }

}
