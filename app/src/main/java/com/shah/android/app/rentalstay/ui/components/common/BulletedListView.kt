package com.shah.android.app.rentalstay.ui.components.common

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.shah.android.app.rentalstay.R
import com.shah.android.app.rentalstay.ui.theme.Lato
import com.shah.android.app.rentalstay.ui.theme.TextSize12
import com.shah.android.app.rentalstay.ui.theme.TextSize14

@Composable
fun BulletedListView(modifier: Modifier = Modifier, list: Array<String>) {
    Column(
        modifier = modifier
    ) {
        list.forEach {
            RS_Text(
                text = stringResource(id = R.string.bulleted_string, it),
                fontSize = TextSize14,
                fontFamily = Lato
            )
        }
    }
}
