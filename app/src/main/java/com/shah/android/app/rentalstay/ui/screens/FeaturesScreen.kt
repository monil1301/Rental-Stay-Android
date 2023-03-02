package com.shah.android.app.rentalstay.ui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.shah.android.app.rentalstay.R
import com.shah.android.app.rentalstay.activities.HomeActivity
import com.shah.android.app.rentalstay.models.FeatureDetails
import com.shah.android.app.rentalstay.ui.components.FeatureCard
import com.shah.android.app.rentalstay.ui.components.common.RS_Button
import com.shah.android.app.rentalstay.ui.components.common.RS_Text
import com.shah.android.app.rentalstay.ui.theme.*

/**
 * Created by Monil Shah on 02/03/23.
 */

@Composable
fun FeaturesScreen() {

    val context = LocalContext.current
    val auth by lazy { Firebase.auth }

    val featuresList = arrayListOf(
        FeatureDetails(
            stringResource(id = R.string.best_life_title),
            R.drawable.best_life_image,
            stringResource(id = R.string.best_life_desc)
        ),
        FeatureDetails(
            stringResource(id = R.string.room_title),
            R.drawable.room_image,
            stringResource(id = R.string.room_desc)
        ),
        FeatureDetails(
            stringResource(id = R.string.cleaning_title),
            R.drawable.cleaning_image,
            stringResource(id = R.string.cleaning_desc)
        ),
        FeatureDetails(
            stringResource(id = R.string.meal_title),
            R.drawable.meal_image,
            stringResource(id = R.string.meal_desc)
        ),
        FeatureDetails(
            stringResource(id = R.string.common_area_title),
            R.drawable.common_area_image,
            stringResource(id = R.string.common_area_desc)
        ),
    )

    LazyColumn(
        contentPadding = PaddingValues(Dimen16),
        verticalArrangement = Arrangement.spacedBy(Dimen16)
    ) {
        auth.currentUser?.displayName?.let {
            item {
                RS_Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Dimen20),
                    text = "Welcome $it",
                    fontFamily = Jua,
                    fontSize = TextSize24
                )
            }
        }

        item {
            RS_Button(
                modifier = Modifier.fillMaxWidth().height(100.dp),
                textSize = 18.sp,
                title = "Find Rental Stays",
                onClick = {
                    startActivity(context, Intent(context, HomeActivity::class.java), null)
                }
            )
        }

        item {
            Column(
                modifier = Modifier.padding(Dimen16),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.feature_screen_title),
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onBackground
                )

                Spacer(modifier = Modifier.height(Dimen16))

                Text(
                    text = stringResource(id = R.string.feature_screen_desc),
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(Dimen16))
            }
        }

        items(
            items = featuresList
        ) { featureDetails ->
            FeatureCard(featureDetails = featureDetails)
        }
    }
}
