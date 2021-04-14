package com.adammcneilly.bloom

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf

/**
 * @property[validator] Some function that takes the current text and
 * determines if that input is valid.
 * @property[errorFor] Given the current input, determine what (if any)
 * the error message should be. This allows us to customize the error message
 * based on missing data vs improperly formatted data.
 */
open class TextFieldState(
    private val validator: (String) -> Boolean = { true },
    private val errorFor: (String) -> String = { "" }
) {
    var text: String by mutableStateOf("")

    // Keep track of this so we only show the error
    // if the user has ever focused this field.
    var hasEverBeenFocused: Boolean by mutableStateOf(false)
    var isFocused: Boolean by mutableStateOf(false)
    private var displayErrors: Boolean by mutableStateOf(false)

    val isValid: Boolean
        get() = validator(text)

    val showErrors: Boolean
        get() = displayErrors && !isValid

    fun onFocusChange(focused: Boolean) {
        this.isFocused = focused
        if (focused) this.hasEverBeenFocused = true
    }

    fun enableShowErrors() {
        if (hasEverBeenFocused) {
            displayErrors = true
        }
    }

    fun getError(): String? {
        return if (showErrors) {
            errorFor(text)
        } else {
            null
        }
    }
}
