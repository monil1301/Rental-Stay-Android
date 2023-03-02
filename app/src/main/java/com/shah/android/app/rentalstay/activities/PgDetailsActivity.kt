package com.shah.android.app.rentalstay.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import com.shah.android.app.rentalstay.models.PropertyDetails
import com.shah.android.app.rentalstay.ui.components.PropertyDetailScreen
import com.shah.android.app.rentalstay.ui.components.common.RS_AppBar
import com.shah.android.app.rentalstay.ui.theme.RentalStayTheme

class PgDetailsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RentalStayTheme {
                val propertyDetails = intent.getParcelableExtra<PropertyDetails>("propertyDetails")
                Scaffold(
                    topBar = { RS_AppBar(shouldShowExitButton = false) }
                ) {
                    propertyDetails?.let { PropertyDetailScreen(propertyDetails = it) }
                }
            }
        }
    }
}