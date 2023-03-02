package com.shah.android.app.rentalstay.models

import androidx.annotation.DrawableRes

/**
 * Created by Monil Shah on 02/03/23.
 */
data class FeatureDetails(
    val title: String,
    @DrawableRes val image: Int,
    val description: String
)
