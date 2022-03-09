package com.shah.android.app.rentalstay.view_models

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import com.shah.android.app.rentalstay.application.RentalStayApplication
import com.shah.android.app.rentalstay.utilities.helpers.Constants

class AuthViewModel : ViewModel() {

    private val auth by lazy { Firebase.auth }

    fun signUp(
        name: String,
        email: String,
        password: String,
        confirmationPassword: String,
        onComplete: (isSuccess: Boolean, errorMessage: String?) -> Unit,
    ) {
        if (areUserDetailsValid(name, email, password, confirmationPassword)) {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                     updateUserProfile(name) { isSuccess, errorMessage ->
                        onComplete(isSuccess, errorMessage)
                    }
                } else {
                    onComplete(it.isSuccessful, it.exception?.message)
                }
            }
        } else {
            onComplete(false,"Something wrong with your input.")
        }
    }

    fun signIn(
        email: String,
        password: String,
        onComplete: (isSuccess: Boolean, errorMessage: String?) -> Unit,
    ) {
        if (areUserDetailsValid(email, password)) {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                onComplete(it.isSuccessful, it.exception?.message)
            }
        } else {
            onComplete(false,"Something wrong with your input.")
        }
    }

    fun sendPasswordResetLink(
        email: String,
        onComplete: (isSuccess: Boolean, errorMessage: String?) -> Unit
    ) {
        if (isEmailValid(email)) {
            auth.sendPasswordResetEmail(email).addOnCompleteListener {
                onComplete(it.isSuccessful, it.exception?.message)
            }
        } else {
            onComplete(false, "Invalid email")
        }
    }

    private fun updateUserProfile(name: String, onComplete: (Boolean, String?) -> Unit) {
        val user = Firebase.auth.currentUser

        val profileUpdates = userProfileChangeRequest {
            displayName = name
        }

        user?.updateProfile(profileUpdates)
            ?.addOnCompleteListener { task ->
                onComplete(task.isSuccessful, task.exception?.message)
            }
    }

    suspend fun saveUserDetailsToDevice(rentalStayApplication: RentalStayApplication?) {
        auth.currentUser?.displayName?.let { userName ->
            auth.currentUser?.uid?.let { uId ->
                val userData = hashMapOf(
                    Constants.DataStore.Keys.userName to userName,
                    Constants.DataStore.Keys.uId to uId
                )
                rentalStayApplication?.userPreferences?.saveStringData(userData)
            }
        }
    }

    private fun areUserDetailsValid(email: String, password: String): Boolean {
        return isEmailValid(email) && password.isNotBlank()
    }

    private fun areUserDetailsValid(name: String, email: String, password: String, confirmationPassword: String): Boolean {
        return isUserNameValid(name) && isEmailValid(email) && doPasswordsMatch(password, confirmationPassword)
    }

    private fun isUserNameValid(name: String): Boolean = name.isNotBlank() && name.length >= Constants.Validation.userNameMinimumLength

    private fun isEmailValid(email: String): Boolean = email.matches(Constants.Validation.emailPattern.toRegex())

    private fun doPasswordsMatch(password: String, confirmationPassword: String): Boolean = password.isNotBlank() && password == confirmationPassword
}
