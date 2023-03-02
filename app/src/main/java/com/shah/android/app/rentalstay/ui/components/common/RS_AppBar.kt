package com.shah.android.app.rentalstay.ui.components.common

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.shah.android.app.rentalstay.R
import com.shah.android.app.rentalstay.activities.AuthActivity
import com.shah.android.app.rentalstay.activities.HomeActivity
import com.shah.android.app.rentalstay.ui.theme.*

@Composable
@Preview
fun RS_AppBar(shouldShowExitButton: Boolean = true) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimen58)
            .background(MaterialTheme.colors.primary)
            .padding(horizontal = Dimen20),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RS_Text(
            text = stringResource(id = R.string.app_name),
            color = MaterialTheme.colors.onPrimary,
            fontSize = TextSize24,
            fontFamily = Jua
        )

        if (shouldShowExitButton) {
            val context = LocalContext.current
            Icon(
                imageVector = Icons.Default.Logout,
                contentDescription = "",
                tint = MaterialTheme.colors.onPrimary,
                modifier = Modifier
                    .clickable {
                        context.startActivity(
                            Intent(context, AuthActivity::class.java).setFlags(
                                Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                            )
                        )
                    }
            )
        }
    }
}
