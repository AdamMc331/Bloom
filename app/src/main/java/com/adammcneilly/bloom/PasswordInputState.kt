package com.adammcneilly.bloom

class PasswordInputState : TextFieldState(
    validator = ::isValidPassword,
    errorFor = ::passwordValidationError
)

private fun passwordValidationError(password: String): String {
    return "Please provide a password."
}

private fun isValidPassword(password: String): Boolean {
    return password.isNotEmpty()
}
