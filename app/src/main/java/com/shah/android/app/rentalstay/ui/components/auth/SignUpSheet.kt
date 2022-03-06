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
fun SignUpSheet(onSignUp: (name: String, email: String, password: String, confirmationPassword: String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
            .padding(horizontal = Dimen30, vertical = Dimen30),
    ) {
        var name = ""
        var email = ""
        var password = ""
        var confirmPassword = ""

        RS_TextFieldWithIcon(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Dimen10),
            icon = R.drawable.icon_profile,
            iconDescription = stringResource(R.string.profile_icon),
            label = stringResource(R.string.name),
            text = name,
            onValueChanged = { name = it }
        )

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

        RS_TextFieldWithIcon(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Dimen10),
            icon = R.drawable.icon_lock,
            iconDescription = stringResource(R.string.lock_icon),
            label = stringResource(R.string.confirm_password),
            keyboardType = KeyboardType.Password,
            onValueChanged = { confirmPassword = it }
        )

        RS_Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Dimen30)
                .height(Dimen58),
            title = stringResource(R.string.sign_up),
            textSize = TextSize20,
            shape = RoundedCornerShape(Dimen10)
        ) {
            onSignUp(name, email, password, confirmPassword)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen() {
    RentalStayTheme(darkTheme = true) {
        SignUpSheet { _, _, _, _ -> }
    }
}
