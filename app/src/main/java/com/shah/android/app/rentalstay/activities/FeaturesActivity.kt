package com.shah.android.app.rentalstay.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import com.shah.android.app.rentalstay.application.RentalStayApplication
import com.shah.android.app.rentalstay.ui.components.common.RS_AppBar
import com.shah.android.app.rentalstay.ui.screens.FeaturesScreen
import com.shah.android.app.rentalstay.ui.theme.RentalStayTheme
import com.shah.android.app.rentalstay.utilities.helpers.UserHelper

/**
 * Created by Monil Shah on 02/03/23.
 */
class FeaturesActivity : ComponentActivity() {

    private val rentalStayApplication by lazy { application as RentalStayApplication }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UserHelper.getUserDetails(rentalStayApplication)
        setContent {
            RentalStayTheme {
                Scaffold(
                    topBar = { RS_AppBar() }
                ) {
                   FeaturesScreen()
                }
            }
        }

    }
}