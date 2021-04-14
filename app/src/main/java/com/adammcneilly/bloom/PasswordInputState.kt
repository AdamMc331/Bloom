package com.adammcneilly.bloom

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf

class PasswordInputState : TextFieldState(
    validator = ::isValidPassword,
    errorFor = ::passwordValidationError
) {
    var shouldHidePassword: Boolean by mutableStateOf(true)
}

private fun passwordValidationError(password: String): String {
    return "Please provide a password."
}

private fun isValidPassword(password: String): Boolean {
    return password.isNotEmpty()
}
