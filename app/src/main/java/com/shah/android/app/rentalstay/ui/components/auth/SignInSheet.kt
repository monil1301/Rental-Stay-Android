package com.shah.android.app.rentalstay.ui.components.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.shah.android.app.rentalstay.R
import com.shah.android.app.rentalstay.ui.components.RS_Button
import com.shah.android.app.rentalstay.ui.components.RS_TextFieldWithIcon
import com.shah.android.app.rentalstay.ui.theme.*

@Composable
fun SignInSheet(onSignIn: (email: String, password: String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
            .padding(horizontal = Dimen30, vertical = Dimen58),
    ) {
        var email = ""
        var password = ""

        RS_TextFieldWithIcon(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Dimen10),
            icon = R.drawable.icon_message,
            iconDescription = stringResource(R.string.message_icon),
            label = stringResource(R.string.email_address),
            keyboardType = KeyboardType.Email,
            onValueChanged = { email = it }
        )

        RS_TextFieldWithIcon(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Dimen10),
            icon = R.drawable.icon_lock,
            iconDescription = stringResource(R.string.lock_icon),
            label = stringResource(R.string.password),
            keyboardType = KeyboardType.Password,
            onValueChanged = { password = it }
        )

        RS_Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Dimen58)
                .height(Dimen58),
            title = stringResource(R.string.sign_in),
            textSize = TextSize20,
            shape = RoundedCornerShape(Dimen10)
        ) {
            onSignIn(email, password)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignInScreen() {
    RentalStayTheme(darkTheme = true) {
        SignInSheet{ _, _ -> }
    }
}
