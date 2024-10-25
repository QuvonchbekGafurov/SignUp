package com.example.signup.uipage

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun MainApp() {
    var currentStep by remember { mutableStateOf(0) } // Step bosqichlarini boshqarish


    // Telefonning orqaga qaytish tugmasini boshqarish
    BackHandler(enabled = currentStep > 0) {
        currentStep -= 1 // Oldingi ekranga qaytish
    }

    when (currentStep) {
        0 -> LoginScreen ( onNext ={currentStep = 1 },)  // Login sahifasi
        1 -> SignUpStep1  ( onNext ={currentStep = 2 },onBack = { currentStep -= 1} )  // Sign-up Step 1
        2 -> SignUpStep2  ( onNext ={currentStep = 3 },onBack = { currentStep -= 1 })  // Sign-up Step 2
        3 -> SignUpStep3  ( onNext ={currentStep = 4 },onBack = { currentStep -= 1} )  // Sign-up Step 3
        4 -> SignUpStep4  ( onBack = { currentStep -= 1 })  // Sign-up Step 4
    }
}