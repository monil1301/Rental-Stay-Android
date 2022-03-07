package com.shah.android.app.rentalstay.application

import android.app.Application
import com.shah.android.app.rentalstay.data.UserPreferences

class RentalStayApplication: Application() {

    val userPreferences: UserPreferences? by lazy { UserPreferences(this) }
}
