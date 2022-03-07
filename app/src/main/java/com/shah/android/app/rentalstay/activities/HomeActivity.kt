package com.shah.android.app.rentalstay.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.shah.android.app.rentalstay.application.RentalStayApplication
import com.shah.android.app.rentalstay.ui.components.RS_Text
import com.shah.android.app.rentalstay.ui.theme.RentalStayTheme
import com.shah.android.app.rentalstay.ui.theme.TextSize20
import com.shah.android.app.rentalstay.utilities.helpers.UserHelper

class HomeActivity: ComponentActivity() {

    private val rentalStayApplication by lazy { application as RentalStayApplication }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UserHelper.getUserDetails(rentalStayApplication)
        setContent {
            RentalStayTheme {
                MessageCard(UserHelper.user?.name ?: "")
            }
        }
    }
}

@Composable
fun MessageCard(name: String) {
    RS_Text(text = "Hello $name!", fontSize = TextSize20, fontWeight = FontWeight.Bold)
}

@Preview(showBackground = true)
@Composable
fun DefaultHomePreview() {
    RentalStayTheme {
        MessageCard(name = "Monil")
    }
}
