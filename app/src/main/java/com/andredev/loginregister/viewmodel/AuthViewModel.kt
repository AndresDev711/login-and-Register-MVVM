package com.andredev.loginregister.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.andredev.loginregister.repository.AuthenticationRepository
import com.google.firebase.auth.FirebaseUser


class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: AuthenticationRepository = AuthenticationRepository(application)
    val userData: MutableLiveData<FirebaseUser?> = repository.firebaseUserMutableLiveData
    val loggedStatus: MutableLiveData<Boolean> = repository.userLoggedMutableLiveData

    fun register(email: String?, pass: String?) {
        repository.register(email, pass)
    }

    fun signIn(email: String?, pass: String?) {
        repository.login(email, pass)
    }

    fun signOut() {
        repository.signOut()
    }

}