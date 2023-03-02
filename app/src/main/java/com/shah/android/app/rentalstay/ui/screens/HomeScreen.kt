package com.shah.android.app.rentalstay.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.shah.android.app.rentalstay.ui.components.common.RS_Text
import com.shah.android.app.rentalstay.ui.components.property.PropertyCard
import com.shah.android.app.rentalstay.ui.theme.Dimen20
import com.shah.android.app.rentalstay.ui.theme.Dimen58
import com.shah.android.app.rentalstay.ui.theme.Jua
import com.shah.android.app.rentalstay.ui.theme.TextSize16
import com.shah.android.app.rentalstay.view_models.HomeViewModel

@Composable
fun HomeScreen() {
    val viewModel = remember { HomeViewModel() }
    val context = LocalContext.current

    viewModel.getAvailableRentalStays {
        if (!it) Toast.makeText(context, "Failed to load data", Toast.LENGTH_SHORT).show()
    }

    LazyColumn {
        items(
            items = viewModel.propertyList
        ) { propertyDetails ->
            PropertyCard(propertyDetails = propertyDetails)
        }
    }
}
