package com.shah.android.app.rentalstay.ui.components

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KingBed
import androidx.compose.material.icons.outlined.LocalLaundryService
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.shah.android.app.rentalstay.R
import com.shah.android.app.rentalstay.models.PropertyDetails
import com.shah.android.app.rentalstay.ui.components.common.BulletedListView
import com.shah.android.app.rentalstay.ui.components.common.RS_Button
import com.shah.android.app.rentalstay.ui.components.common.RS_Text
import com.shah.android.app.rentalstay.ui.components.property.ForMaleOrFemale
import com.shah.android.app.rentalstay.ui.components.property.PropertyImageSlider
import com.shah.android.app.rentalstay.ui.components.property.PropertyPrice
import com.shah.android.app.rentalstay.ui.theme.*

@Composable
fun PropertyDetailScreen(propertyDetails: PropertyDetails) {
    val context = LocalContext.current
    val requestPermission =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                val intent = Intent(Intent.ACTION_CALL)

                intent.data = Uri.parse("tel:" + propertyDetails.mobile)
                context.startActivity(intent)
            }
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        PropertyImageSlider(
            Modifier.height(280.dp),
            propertyDetails.images
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimen16, vertical = Dimen10),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = propertyDetails.name,
                fontWeight = FontWeight.Bold,
                fontSize = TextSize20,
                color = Color.Black
            )

            PropertyPrice(price = propertyDetails.price, textSize = TextSize20)
        }

        RS_Text(
            modifier = Modifier.padding(horizontal = 18.dp),
            text = "Location: " + propertyDetails.location,
            fontSize = TextSize16,
            color = Color.DarkGray
        )

        ForMaleOrFemale(
            modifier = Modifier.padding(horizontal = Dimen16, vertical = Dimen12),
            forMale = propertyDetails.gender == "male"
        )

        Row(
            modifier = Modifier.padding(horizontal = 18.dp),
            horizontalArrangement = Arrangement.spacedBy(Dimen8),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Outlined.KingBed, contentDescription = "")

            RS_Text(
                text = "Available Room Sharing",
                fontSize = TextSize16,
                color = Color.Black
            )
        }

        Column(
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            BulletedListView(list = propertyDetails.roomSharing.toTypedArray())
        }

        Row(
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .padding(top = Dimen20),
            horizontalArrangement = Arrangement.spacedBy(Dimen8),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Outlined.LocalLaundryService, contentDescription = "")

            RS_Text(
                text = "Features and Amenities",
                fontSize = TextSize16,
                color = Color.Black
            )
        }

        Column(
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            BulletedListView(list = propertyDetails.roomFeatures.toTypedArray())
        }

        RS_Button(
            modifier = Modifier.fillMaxWidth().padding(Dimen16),
            title = "Call Now",
            drawableResource = R.drawable.icon_call
        ) {
            requestPermission.launch(Manifest.permission.CALL_PHONE)
        }
    }
}