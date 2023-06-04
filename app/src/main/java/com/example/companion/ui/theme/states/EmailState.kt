package com.example.companion.ui.theme.states

import java.util.regex.Pattern

private const val EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9.!#\$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*\$"

class EmailState : TextFieldState(
    validator = ::isEmailValid,
    errorMessage = ::emailErrorMessage
)

private fun isEmailValid(email: String): Boolean {
    return Pattern.matches(EMAIL_VALIDATION_REGEX, email)
}
private fun emailErrorMessage(email: String) = "Email $email is invalid."