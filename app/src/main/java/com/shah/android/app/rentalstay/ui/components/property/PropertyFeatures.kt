package com.shah.android.app.rentalstay.ui.components.property

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KingBed
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shah.android.app.rentalstay.ui.components.common.RS_Text
import com.shah.android.app.rentalstay.ui.theme.Dimen10

@Composable
fun PropertyFeatures(modifier: Modifier = Modifier, features: List<String>) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Dimen10)
    ) {
        Icon(imageVector = Icons.Outlined.Restaurant, contentDescription = "")

        var featuresText = ""
        features.take(2).forEach {
            featuresText = "$featuresText $it,"
        }

        if (features.size > 2)
        featuresText = "$featuresText and +${features.size - 2} more"

        RS_Text(text = featuresText)
    }
}

@Composable
fun PropertyRoomSharing(modifier: Modifier = Modifier, sharing: List<String>) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Dimen10)
    ) {
        Icon(imageVector = Icons.Outlined.KingBed, contentDescription = "")

        RS_Text(text = sharing.joinToString())
    }
}


@Preview
@Composable
fun PreviewPropertyFeatures() {
    Column {
    PropertyFeatures(features = listOf("WiFi", "laundry", "many more"))
        PropertyRoomSharing(sharing = listOf("double, triple. quadruple"))
    }
}
