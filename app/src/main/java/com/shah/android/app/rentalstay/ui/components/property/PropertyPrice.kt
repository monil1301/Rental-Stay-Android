package com.shah.android.app.rentalstay.ui.components.property

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.shah.android.app.rentalstay.R
import com.shah.android.app.rentalstay.ui.components.common.RS_Text
import com.shah.android.app.rentalstay.ui.theme.TextSize12
import com.shah.android.app.rentalstay.ui.theme.TextSize14
import com.shah.android.app.rentalstay.utilities.helpers.toRupees

@Composable
fun PropertyPrice(price: Int) {
    Column {
        RS_Text(text = "Starts from", fontSize = TextSize12, color = Color.DarkGray)
        RS_Text(
            text = stringResource(id = R.string.rent_per_month, price.toRupees()),
            fontSize = TextSize14,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}
