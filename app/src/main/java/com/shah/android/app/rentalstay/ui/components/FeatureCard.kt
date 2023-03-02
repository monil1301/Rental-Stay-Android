package com.shah.android.app.rentalstay.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.shah.android.app.rentalstay.R
import com.shah.android.app.rentalstay.models.FeatureDetails
import com.shah.android.app.rentalstay.ui.components.common.RS_Image
import com.shah.android.app.rentalstay.ui.theme.Dimen12
import com.shah.android.app.rentalstay.ui.theme.Dimen16
import com.shah.android.app.rentalstay.ui.theme.Dimen24
import com.shah.android.app.rentalstay.ui.theme.Dimen8

/**
 * Created by Monil Shah on 02/03/23.
 */

@Composable
fun FeatureCard(
    featureDetails: FeatureDetails
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(Dimen12),
        elevation = Dimen8
    ) {
        Column(
            modifier = Modifier.padding(Dimen16),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = featureDetails.title, style = MaterialTheme.typography.h2, textAlign = TextAlign.Center, color = MaterialTheme.colors.primary)

            Spacer(modifier = Modifier.height(Dimen24))

            Image(modifier = Modifier.fillMaxWidth(), painter = painterResource(id = featureDetails.image), contentDescription = "", contentScale = ContentScale.FillWidth)

            Spacer(modifier = Modifier.height(Dimen16))

            Text(text = featureDetails.description, style = MaterialTheme.typography.body2, textAlign = TextAlign.Center)
        }
    }
}

@Preview
@Composable
fun PreviewFeatureCard() {
    FeatureCard(FeatureDetails(stringResource(id = R.string.best_life_title), R.drawable.best_life_image, stringResource(id = R.string.best_life_desc)))
}
