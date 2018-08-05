/*
 * Copyright (c) 2017. Simdea.
 */

package pt.simdea.gmlrva.sample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Class responsible for the Splash Screen screen.
 *
 * Created by Paulo Ribeiro on 7/16/2017.
 * Simdea © All Rights Reserved.
 * paulo.ribeiro@simdea.pt
 */
class SplashActivity : AppCompatActivity() {

    /**
     * Called when SplashActivity is first created.
     * @param savedInstanceState Bundle object containing the activity's previously saved state.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SampleActivity.start(this) // Start home activity
        finish() // close splash activity
    }

}
