package com.adammcneilly.bloom

import java.util.regex.Pattern

// Consider an email valid if there's some text before and after a "@"
private const val EMAIL_VALIDATION_REGEX = "^(.+)@(.+)\$"

class EmailState : TextFieldState(
    validator = ::isEmailValid,
    errorFor = ::emailValidationError
)

private fun emailValidationError(email: String): String {
    return if (email.isBlank()) {
        "Please provide an email."
    } else {
        "Invalid email: $email."
    }
}

private fun isEmailValid(email: String): Boolean {
    return Pattern.matches(EMAIL_VALIDATION_REGEX, email)
}
