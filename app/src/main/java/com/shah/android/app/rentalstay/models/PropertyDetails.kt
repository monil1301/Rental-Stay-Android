package com.shah.android.app.rentalstay.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PropertyDetails(
    val name: String,
    val location: String,
    val price: Int,
    val gender: String,
    val mobile: String,
    val roomSharing: List<String>,
    val roomFeatures: List<String>,
    val images: List<String>
) : Parcelable
