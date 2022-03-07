package com.shah.android.app.rentalstay.ui.screens

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.shah.android.app.rentalstay.R
import com.shah.android.app.rentalstay.activities.HomeActivity
import com.shah.android.app.rentalstay.application.RentalStayApplication
import com.shah.android.app.rentalstay.ui.components.auth.AuthHeader
import com.shah.android.app.rentalstay.ui.components.auth.SignInSheet
import com.shah.android.app.rentalstay.ui.components.auth.SignUpSheet
import com.shah.android.app.rentalstay.ui.theme.Dimen20
import com.shah.android.app.rentalstay.ui.theme.RentalStayTheme
import com.shah.android.app.rentalstay.view_models.AuthViewModel
import kotlinx.coroutines.runBlocking

@Composable
fun AuthScreen(rentalStayApplication: RentalStayApplication?) {
    val viewModel = remember { AuthViewModel() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary),
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
            val context = LocalContext.current
            if (isSigningIn)
                SignInSheet { email: String, password: String ->
                    viewModel.signIn(email, password) { isSuccess, errorMessage ->
                        if (isSuccess) {
                            runBlocking {
                                viewModel.saveUserDetailsToDevice(rentalStayApplication)
                            }
                            Toast.makeText(context, context.getString(R.string.sign_in_success), Toast.LENGTH_LONG).show()
                            context.startActivity(Intent(context, HomeActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
                        } else {
                            Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
                        }
                    }
                } else
                SignUpSheet { name: String, email: String, password: String, confirmationPassword: String ->
                    viewModel.signUp(name, email, password, confirmationPassword) { isSuccess, errorMessage ->
                        if (isSuccess) {
                            runBlocking {
                                viewModel.saveUserDetailsToDevice(rentalStayApplication)
                            }
                            Toast.makeText(context, context.getString(R.string.sign_up_success), Toast.LENGTH_LONG).show()
                            context.startActivity(Intent(context, HomeActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
                        } else {
                            Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
                        }
                    }
                }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_XL)
@Composable
fun PreviewSignUpScreen() {
    RentalStayTheme(darkTheme = false) {
        AuthScreen(null)
    }
}
