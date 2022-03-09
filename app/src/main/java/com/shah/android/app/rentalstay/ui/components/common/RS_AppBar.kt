package com.shah.android.app.rentalstay.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.shah.android.app.rentalstay.R
import com.shah.android.app.rentalstay.ui.theme.*

@Composable
@Preview
fun RS_AppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimen58)
            .background(MaterialTheme.colors.primary)
            .padding(horizontal = Dimen20),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RS_Text(
            text = stringResource(id = R.string.app_name),
            color = MaterialTheme.colors.onPrimary,
            fontSize = TextSize24,
            fontFamily = Jua
        )
    }
}
