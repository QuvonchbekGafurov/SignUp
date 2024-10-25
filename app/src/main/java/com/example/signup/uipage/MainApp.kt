package com.example.signup.uipage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun MainApp() {
    var currentStep by remember { mutableStateOf(0) } // Step bosqichlarini boshqarish

    when (currentStep) {
        0 -> LoginScreen { currentStep = 1 }  // Login sahifasi
        1 -> SignUpStep1 { currentStep = 2 }  // Sign-up Step 1
        2 -> SignUpStep2 { currentStep = 3 }  // Sign-up Step 2
        3 -> SignUpStep3 { currentStep = 4 }  // Sign-up Step 3
        4 -> SignUpStep4 { currentStep = 5 }  // Sign-up Step 4
    }
}