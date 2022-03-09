package com.shah.android.app.rentalstay.ui.components.property

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.shah.android.app.rentalstay.ui.components.common.RS_Text
import com.shah.android.app.rentalstay.ui.theme.Dimen4

@Composable
fun ForMaleOrFemale(forMale: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Dimen4)
    ) {
        Icon(imageVector = if (forMale) Icons.Default.Male else Icons.Default.Female, contentDescription = "")

        RS_Text(text = if (forMale) "Male" else "Female")
    }
}

@Preview
@Composable
fun PreviewMaleFemale() {
    ForMaleOrFemale(forMale = true)
}
