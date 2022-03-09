package com.shah.android.app.rentalstay.ui.screens

import android.widget.Toast
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.shah.android.app.rentalstay.ui.components.property.PropertyCard
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
