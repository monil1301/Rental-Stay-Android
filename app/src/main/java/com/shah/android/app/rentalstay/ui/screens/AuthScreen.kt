package com.shah.android.app.rentalstay.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.shah.android.app.rentalstay.ui.components.auth.AuthHeader
import com.shah.android.app.rentalstay.ui.components.auth.SignInSheet
import com.shah.android.app.rentalstay.ui.components.auth.SignUpSheet
import com.shah.android.app.rentalstay.ui.theme.*

@Composable
fun AuthScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.secondary),
        verticalArrangement = Arrangement.spacedBy(Dimen20)
    ) {
        var isSigningIn by remember { mutableStateOf(true) }
        AuthHeader(isSigningIn) {
            isSigningIn = it
        }

        Surface(
            shape = RoundedCornerShape(
                topStart = Dimen20,
                topEnd = Dimen20,
            )
        ) {
            if (isSigningIn)
                SignInSheet()
            else
                SignUpSheet()
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_XL)
@Composable
fun PreviewSignUpScreen() {
    RentalStayTheme(darkTheme = false) {
        AuthScreen()
    }
}
