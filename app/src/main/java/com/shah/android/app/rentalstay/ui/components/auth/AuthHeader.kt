package com.shah.android.app.rentalstay.ui.components.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.shah.android.app.rentalstay.R
import com.shah.android.app.rentalstay.ui.components.common.RS_Button
import com.shah.android.app.rentalstay.ui.components.common.RS_Text
import com.shah.android.app.rentalstay.ui.theme.*

@Composable
fun AuthHeader(isSigningIn: Boolean, callBack: (Boolean) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimen30, vertical = Dimen10)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(Dimen30),
                imageVector = Icons.Filled.Home,
                contentDescription = "",
                tint = MaterialTheme.colors.onPrimary
            )

            Row {
                RS_Button(
                    modifier = Modifier,
                    title = stringResource(id = R.string.sign_in),
                    backgroundColor = Color.Transparent,
                    borderStroke = null,
                    elevation = if (isSigningIn) ButtonDefaults.elevation() else null
                ) {
                    callBack(true)
                }

                RS_Button(
                    modifier = Modifier,
                    title = stringResource(id = R.string.sign_up),
                    backgroundColor = Color.Transparent,
                    borderStroke = null,
                    elevation = if (isSigningIn) null else ButtonDefaults.elevation()
                ) {
                    callBack(false)
                }
            }
        }

        RS_Text(
            modifier = Modifier.padding(top = Dimen30),
            text = if (isSigningIn) stringResource(R.string.welcome_back) else stringResource(id = R.string.get_on_board),
            fontSize = TextSize30,
            color = MaterialTheme.colors.onPrimary,
            fontWeight = FontWeight.Bold
        )

        RS_Text(
            modifier = Modifier
                .padding(vertical = Dimen10),
            text = if (isSigningIn) stringResource(R.string.sign_in_to_continue) else stringResource(R.string.sign_up_to_continue),
            fontSize = TextSize14,
            color = MaterialTheme.colors.onPrimary
        )
    }
}
