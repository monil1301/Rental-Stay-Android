package com.shah.android.app.rentalstay.ui.components.property

import android.Manifest
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.shah.android.app.rentalstay.models.PropertyDetails
import com.shah.android.app.rentalstay.ui.components.common.RS_Button
import com.shah.android.app.rentalstay.ui.components.common.RS_Text
import com.shah.android.app.rentalstay.ui.theme.*
import com.shah.android.app.rentalstay.R
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.ui.platform.LocalContext
import com.shah.android.app.rentalstay.activities.PgDetailsActivity

@Composable
fun PropertyCard(modifier: Modifier = Modifier, propertyDetails: PropertyDetails) {
    val context = LocalContext.current
    val requestPermission =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                val intent = Intent(Intent.ACTION_CALL)

                intent.data = Uri.parse("tel:" + propertyDetails.mobile)
                context.startActivity(intent)
            }
        }

    Surface(
        modifier = modifier
            .padding(vertical = Dimen12, horizontal = Dimen12)
            .clickable {
                       context.startActivity(Intent(context, PgDetailsActivity::class.java)
                           .putExtra("propertyDetails", propertyDetails)
                       )
            },
        shape = RoundedCornerShape(Dimen8),
        elevation = Dimen14
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(Dimen12)
        ) {
            PropertyImageSlider(
                Modifier.height(230.dp),
                propertyDetails.images
            )

            Column(
                modifier = Modifier
                    .padding(horizontal = Dimen16),
                verticalArrangement = Arrangement.spacedBy(Dimen4)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = propertyDetails.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = TextSize16,
                        color = Color.Black
                    )

                    ForMaleOrFemale(forMale = propertyDetails.gender == "male")
                }

                RS_Text(
                    text = propertyDetails.location,
                    fontSize = TextSize12,
                    color = Color.DarkGray
                )
            }

            Column(
                modifier = Modifier
                    .padding(horizontal = Dimen16)
                    .padding(bottom = Dimen12),
                verticalArrangement = Arrangement.spacedBy(Dimen12)
            ) {

                PropertyRoomSharing(
                    sharing = propertyDetails.roomSharing
                )

                PropertyFeatures(features = propertyDetails.roomFeatures)

                Divider(modifier = modifier.fillMaxWidth())

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Dimen4),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    PropertyPrice(price = propertyDetails.price)

                    RS_Button(
                        modifier = Modifier,
                        title = "Call Now",
                        drawableResource = R.drawable.icon_call
                    ) {
                        requestPermission.launch(Manifest.permission.CALL_PHONE)
                    }
                }
            }
        }
    }
}
