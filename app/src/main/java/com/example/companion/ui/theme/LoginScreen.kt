package com.example.companion.ui.theme

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.companion.Destination
import com.example.companion.MainActivity
import com.example.companion.R
import com.example.companion.data.User
import com.example.companion.data.UserDB
import com.example.companion.ui.theme.states.EmailState
import com.example.companion.ui.theme.states.PasswordState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController,
    database: UserDB,
    showToast: MutableState<Boolean>,
) {
    LoginContent(navController = navController, database = database, showToast = showToast)
}

@Composable
fun LoginBackgroundImage() {
    Image(
        painter = painterResource(R.drawable.login_background),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth(1f),
        contentScale = ContentScale.FillWidth,
    )
}

@Composable
fun LoginContent(navController: NavController, database: UserDB, showToast: MutableState<Boolean>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)

        ) {
            LoginBackgroundImage()
            Column(
                verticalArrangement = Arrangement.spacedBy(70.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                LoginTopBar()
                LoginText()
            }
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color(0xFFFFEBEB))
                .fillMaxSize()
        ) {

            val localFocusManager = LocalFocusManager.current
            val emailState = remember { EmailState() }

            Spacer(modifier = Modifier.padding(top = 40.dp))
            LoginEmail(
                emailState.text,
                emailState.error,
                onEmailChanged = {
                    emailState.text = it
                    emailState.validate()
                },
                onImeAction = {
                    localFocusManager.moveFocus(FocusDirection.Down)
                }
            )
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            val passwordState = remember { PasswordState() }
            LoginPassword(
                passwordState.text,
                passwordState.error,
                onPasswordChanged = {
                    passwordState.text = it
                    passwordState.validate()
                },
                onImeAction = {
                    localFocusManager.clearFocus()
                    if (emailState.isValid() && passwordState.isValid()) {
                        login(emailState.text, passwordState.text)
                    }
                }
            )
            Spacer(modifier = Modifier.padding(horizontal = 50.dp))

            LoginButton(
                enabled = emailState.isValid() && passwordState.isValid(),
                email = emailState.text,
                password = passwordState.text,
                database = database,
                navController = navController,
                showToast = showToast
            )

        }
    }

}

fun login(email: String, password: String) {
    Log.d("TEST", "email $email, password $password")
}

@Composable
fun LoginTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp, top = 25.dp)
            .background(Color.Transparent),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0x8CFAB1B1))
        ) {
            Text(
                text = "Companion.",
                color = Color(0xFF3C0101),
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth(.2f)
                    .height(4.dp)
                    .background(Color(0xFFFFDCDC), RoundedCornerShape(4.dp))
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            )
        }
    }
}

@Composable
fun LoginText() {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0x8CFAB1B1))
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF3C0101),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Welcome,")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFFFFEAEA),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                    )
                ) {
                    append("\n\nSignup to continue")
                }
            },
            textAlign = TextAlign.Start,
        )
    }
}

@Composable
fun LoginEmail(
    email: String,
    error: String?,
    onEmailChanged: (String) -> Unit,
    onImeAction: () -> Unit,
) {
    OutlinedTextField(
        value = email,
        shape = RoundedCornerShape(16.dp),
        onValueChange = { value -> onEmailChanged(value) },
        label = {
            Text(
                text = "email",
                color = Color(0xFF3C0101),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
                    .background(Color(0xFFFFB1B1))
                    .padding(4.dp)
            )
        },
        isError = error != null,
        placeholder = { Text(text = "smtn@stu.ibu.edu.ba", color = Color(0x8C3C0101)) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color(0xFF3C0101),
            unfocusedTextColor = Color(0xFF3C0101),
            errorTextColor = Color(0xFF5E0000),
            focusedContainerColor =  Color(0xFFFFB1B1),
            unfocusedContainerColor =  Color(0xFFFFB1B1),
            disabledContainerColor = AlertDialogDefaults.containerColor,
            errorContainerColor = Color(0xFFFF9595),
            cursorColor = Color(0xFF3C0101),
            errorCursorColor = Color(0xFFD60000),
            focusedBorderColor = Color(0xFF3C0101),
            unfocusedBorderColor = Color(0xFF521616),
            errorBorderColor = Color(0xFFD60000),
            errorLabelColor = Color(0xFFD60000),
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                onImeAction()
            }
        ),
        modifier = Modifier.fillMaxWidth(.9f)
    )

    error?.let { LoginErrorField(it) }
}

@Composable
fun LoginErrorField(error: String) {
    Text(
        text = error,
        color = Color(0xFFD60000),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xC8FFB1B1))
            .padding(4.dp)
    )
}

@Composable
fun LoginPassword(
    password: String,
    error: String?,
    onPasswordChanged: (String) -> Unit,
    onImeAction: () -> Unit,
) {

    val showPassword = remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        shape = RoundedCornerShape(16.dp),
        onValueChange = { value -> onPasswordChanged(value) },
        label = {
            Text(
                text = "password",
                color = Color(0xFF3C0101),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp))
                    .background(Color(0xFFFFB1B1))
                    .padding(4.dp)
            )
        },
        placeholder = { Text(text = "....", color = Color(0x8C3C0101)) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color(0xFF3C0101),
            unfocusedTextColor = Color(0xFF3C0101),
            errorTextColor = Color(0xFF5E0000),
            focusedContainerColor =  Color(0xFFFFB1B1),
            unfocusedContainerColor =  Color(0xFFFFB1B1),
            disabledContainerColor = AlertDialogDefaults.containerColor,
            errorContainerColor = Color(0xFFFF9595),
            cursorColor = Color(0xFF3C0101),
            errorCursorColor = Color(0xFFD60000),
            focusedBorderColor = Color(0xFF3C0101),
            unfocusedBorderColor = Color(0xFF521616),
            errorBorderColor = Color(0xFFD60000),
            errorLabelColor = Color(0xFFD60000),
        ),
        visualTransformation = if (showPassword.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
        }),
        trailingIcon = {
            if (showPassword.value) {
                IconButton(onClick = { showPassword.value = false }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_visibility_on),
                        contentDescription = stringResource(id = R.string.hide_password),
                        tint = Color(0xFF3C0101)
                    )
                }
            } else {
                IconButton(onClick = { showPassword.value = true }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_visibility_off),
                        contentDescription = stringResource(id = R.string.hide_password),
                        tint = Color(0xFF3C0101)
                    )
                }
            }
        },
        isError = error != null,
        modifier = Modifier.fillMaxWidth(.9f)
    )

    error?.let { ErrorField(error = it) }
}

@Composable
fun LoginButton(
    enabled: Boolean,
    email: String,
    password: String,
    database: UserDB,
    navController: NavController,
    showToast: MutableState<Boolean>
) {

    val ctx = LocalContext.current

    TextButton(onClick = { /*TODO*/ }) {
        Text(text = "Forgot Password?", color = Color(0xFF3C0101), fontWeight = FontWeight.Bold)
    }
    Spacer(modifier = Modifier.padding(vertical = 10.dp))
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(text = "or", color = Color(0xFF3C0101))
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF682B2B))
                    .width(40.dp)
                    .height(40.dp)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
            }
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF682B2B))
                    .width(40.dp)
                    .height(40.dp)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_meta),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
            }
        }
        Button(
            onClick = {
                val user = User(email = email, password = password)
                CoroutineScope(Dispatchers.IO).launch {
                    if (database.userDao().getUserByEmail(email) == user.email && database.userDao()
                            .getUserByPassword(password) == user.password
                    ) {
                        val mainActivityIntent = Intent(ctx, MainActivity::class.java)
                        ctx.startActivity(mainActivityIntent)
                    } else {
                        showToast.value = true
                    }

//                val user = database.userDao().getUser(4).firstOrNull()
//                user?.let {
//                    database.userDao().deleteUser(user)
//                }
                }
            },
            modifier = Modifier.fillMaxWidth(.6f),
            colors = ButtonDefaults.buttonColors(Color(0xFFFFB1B1)),
            enabled = enabled
        ) {
            Text(
                text = "Login",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3C0101)
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Don't have an account?",
                color = Color(0xFF3C0101),
                fontSize = 12.sp,

                )
            TextButton(
                onClick = { navController.navigate(Destination.Signup.route) },
                modifier = Modifier
            ) {
                Text(
                    text = "Sign Up",
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    color = Color(0xFF3C0101),
                    fontSize = 15.sp
                )
            }
        }

    }
    ShowToast(message = "User does not exist, please sign up", showToast = showToast)
}
