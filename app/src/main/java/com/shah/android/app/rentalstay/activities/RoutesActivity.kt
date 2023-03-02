package com.shah.android.app.rentalstay.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.shah.android.app.rentalstay.application.RentalStayApplication
import com.shah.android.app.rentalstay.utilities.helpers.Constants
import kotlinx.coroutines.runBlocking

class RoutesActivity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()

        navigateToActivity(getDestinationActivityIntent())
    }

    private fun navigateToActivity(destinationIntent: Intent) {
        startActivity(destinationIntent)
    }

    private fun getDestinationActivityIntent(): Intent {
        return runBlocking {
            return@runBlocking if ((application as RentalStayApplication).userPreferences?.getString(
                    Constants.DataStore.Keys.uId) == null) {
                Intent(this@RoutesActivity, AuthActivity::class.java)
            } else {
                Intent(this@RoutesActivity, FeaturesActivity::class.java)
            }
        }
    }
}
