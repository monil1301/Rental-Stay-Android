package com.shah.android.app.rentalstay.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.shah.android.app.rentalstay.application.RentalStayApplication
import com.shah.android.app.rentalstay.ui.screens.AuthScreen
import com.shah.android.app.rentalstay.ui.theme.RentalStayTheme

class AuthActivity : ComponentActivity() {

    private val rentalStayApplication by lazy { application as RentalStayApplication }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RentalStayTheme {
                AuthScreen(rentalStayApplication)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RentalStayTheme {
        AuthScreen(null)
    }
}
