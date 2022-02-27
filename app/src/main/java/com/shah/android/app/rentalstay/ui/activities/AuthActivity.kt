package com.shah.android.app.rentalstay.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.shah.android.app.rentalstay.ui.screens.AuthScreen
import com.shah.android.app.rentalstay.ui.theme.RentalStayTheme

class AuthActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RentalStayTheme {
                AuthScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RentalStayTheme {
        AuthScreen()
    }
}
