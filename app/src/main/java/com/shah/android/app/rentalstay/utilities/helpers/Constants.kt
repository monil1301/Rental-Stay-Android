package com.shah.android.app.rentalstay.utilities.helpers

object Constants {

    object Validation {
        const val emailPattern = "[a-zA-Z0-9.-_]+@[a-zA-Z0-9]+\\.+[a-z]+"
        const val userNameMinimumLength = 3
    }

    object DataStore {
        const val name = "userDataStore"

        object Keys {
            const val userName = "userName"
            const val uId = "uId"
        }
    }
}
