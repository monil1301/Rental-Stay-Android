package com.shah.android.app.rentalstay.view_models

import android.util.Log
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.shah.android.app.rentalstay.models.PropertyDetails

class HomeViewModel: ViewModel() {

    private val database = Firebase.database
    private val availableRentalStays = database.getReference("availableRentalStays")
    val propertyList = SnapshotStateList<PropertyDetails>()

    fun getAvailableRentalStays(onComplete: (Boolean) -> Unit) {
        availableRentalStays.get().addOnCompleteListener {
            onComplete(it.isSuccessful)
            if (it.isSuccessful) {
                it.result.children.forEach { snapshot ->
                    val roomFeatures = arrayListOf<String>()
                    val roomSharing = arrayListOf<String>()
                    val images = arrayListOf<String>()

                    snapshot.child("roomFeatures").children.forEach { feature ->
                        roomFeatures.add(feature.value.toString())
                    }

                    snapshot.child("roomSharing").children.forEach { sharing ->
                        roomSharing.add(sharing.value.toString())
                    }

                    snapshot.child("images").children.forEach { image ->
                        images.add(image.value.toString())
                    }

                    propertyList.add(
                        PropertyDetails(
                            name = snapshot.child("name").value.toString(),
                            location = snapshot.child("location").value.toString(),
                            gender = snapshot.child("gender").value.toString(),
                            price = snapshot.child("price").value.toString().toIntOrNull()
                                ?: 10000,
                            mobile = snapshot.child("mobile").value.toString(),
                            roomFeatures = roomFeatures,
                            roomSharing = roomSharing,
                            images = images
                        )
                    )
                }
            } else {
                Log.d("RS_log", it.exception.toString())
            }
        }
    }
}
