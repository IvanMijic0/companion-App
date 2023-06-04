package com.example.companion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun IntroScreen(navController: NavController) {
    IntroBackgroundImage()
    IntroContent(navController)
}

@Composable
fun IntroBackgroundImage() {
    Image(
        painter = painterResource(R.drawable.intro_background),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun IntroContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IntroTopBar()
        Spacer(modifier = Modifier.padding(top = 80.dp))
        IntroText()
        Spacer(modifier = Modifier.padding(top = 180.dp))
        StartButton(navController)
    }
}

@Composable
fun IntroTopBar() {
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
fun IntroText() {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0x8CFAB1B1))
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFFFFEAEA),
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Let's ")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF3C0101),
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Travel")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFFFFEAEA),
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                    )
                ) {
                    append("\n\ntogether")
                }
            },
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun StartButton(navController: NavController) {
    TextButton(
        onClick = {
            navController.navigate(Destination.Signup.route)
        },
        modifier = Modifier
            .clip(RoundedCornerShape(40.dp))
            .background(Color(0x8CFD9A9A))
            .fillMaxWidth(.5f)
            .fillMaxHeight(.2f)
    ) {
        Text(
            text = "Start",
            color = Color(0xFFFFEAEA),
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}
