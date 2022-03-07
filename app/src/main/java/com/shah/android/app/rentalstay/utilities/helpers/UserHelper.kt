package com.shah.android.app.rentalstay.utilities.helpers

import com.shah.android.app.rentalstay.application.RentalStayApplication
import com.shah.android.app.rentalstay.models.UserDetails
import kotlinx.coroutines.runBlocking

object UserHelper {

    var user: UserDetails? = null

    fun getUserDetails(rentalStayApplication: RentalStayApplication) {
        user = runBlocking {
            UserDetails(
                name = rentalStayApplication.userPreferences?.getString(Constants.DataStore.Keys.userName) ?: "",
                uId = rentalStayApplication.userPreferences?.getString(Constants.DataStore.Keys.uId) ?: ""
            )
        }
    }
}
