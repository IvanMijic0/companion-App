package com.example.companion.ui.theme.states

class PasswordState : TextFieldState(
    validator = ::isPasswordValid,
    errorMessage = { passwordErrorMessage() }
)

fun isPasswordValid(password: String): Boolean = password.length >= 4

fun passwordErrorMessage() = "Password is invalid."
