package com.example.companion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.companion.data.UserDB
import com.example.companion.ui.theme.IntroScreen
import com.example.companion.ui.theme.LoginScreen
import com.example.companion.ui.theme.SignUpScreen
import com.example.companion.ui.theme.theme.CompanionTheme

sealed class Destination(val route: String) {
    object Intro : Destination("Intro")
    object Login : Destination("Login")
    object Signup : Destination("Signup")
}

class IntroActivity : ComponentActivity() {
    private lateinit var database: UserDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Room.databaseBuilder(
            applicationContext,
            UserDB::class.java,
            "my-database"
        ).build()
        setContent {
            CompanionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    val showToast = remember { mutableStateOf(false) }
                    val showSuccess = remember { mutableStateOf(false) }
                    val navController = rememberNavController()
                    Intro(
                        navController = navController,
                        database,
                        showToast,
                        showSuccess
                    )
                }
            }
        }
    }
}

@Composable
fun Intro(
    navController: NavHostController,
    database: UserDB,
    showToast: MutableState<Boolean>,
    showSuccess: MutableState<Boolean>
) {

    NavHost(navController = navController, startDestination = Destination.Intro.route) {
        composable(Destination.Intro.route) { IntroScreen(navController = navController) }
        composable(Destination.Signup.route) {
            SignUpScreen(
                navController = navController,
                database = database,
                showToast = showToast,
                showSuccess
            )
        }
        composable(Destination.Login.route) {
            LoginScreen(
                navController = navController,
                database = database,
                showToast,
            )
        }
    }

}