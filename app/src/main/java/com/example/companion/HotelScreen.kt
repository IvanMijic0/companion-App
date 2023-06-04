package com.example.companion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun HotelScreen() {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        HotelInfo()
        HotelNearby()
    }
}
@Composable
fun HotelInfo() {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(0xFF000000),
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Nearby Hotels")
            }
        },
        textAlign = TextAlign.Left,
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp,)
    )
}

@Composable
fun HotelNearby() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .background(Color(0xFFFFFFFF))
            .padding(horizontal = 20.dp,)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Card(modifier = Modifier
            .background(Color(0xFFFFFFFF))
            .padding(12.dp)
            .wrapContentHeight()
            .wrapContentWidth()) {
            Box(modifier = Modifier.padding(8.dp)){
                Text(text = "Swissotel Sarajevo", fontSize = 30.sp, fontWeight = FontWeight.Bold, modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Center))
            }
            Box(modifier = Modifier.padding(8.dp)){
                Image(
                    painter = painterResource(R.drawable.swiss_hotel),
                    contentDescription = null,
                    contentScale =  ContentScale.Crop,

                    modifier = Modifier
                        .size(270.dp)
                        .padding(8.dp)
                        .align(Alignment.Center)
                )
            }
        }
        Card(modifier = Modifier
            .background(Color(0xFFFFFFFF))
            .padding(12.dp)
            .wrapContentHeight()
            .wrapContentWidth()) {
            Box(modifier = Modifier.padding(8.dp)){
                Text(text = "Holiday Sarajevo", fontSize = 30.sp, fontWeight = FontWeight.Bold, modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Center))
            }
            Box(modifier = Modifier.padding(8.dp)){
                Image(
                    painter = painterResource(R.drawable.holiday_hotel),
                    contentDescription = null,
                    contentScale =  ContentScale.Crop,

                    modifier = Modifier
                        .size(270.dp)
                        .padding(8.dp)
                        .align(Alignment.Center)
                )
            }
        }
        Card(modifier = Modifier
            .background(Color(0xFFFFFFFF))
            .padding(12.dp)
            .wrapContentHeight()
            .wrapContentWidth()) {
            Box(modifier = Modifier.padding(8.dp)){
                Text(text = "Pino Nature", fontSize = 30.sp, fontWeight = FontWeight.Bold, modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Center))
            }
            Box(modifier = Modifier.padding(8.dp)){
                Image(
                    painter = painterResource(R.drawable.pino_hotel),
                    contentDescription = null,
                    contentScale =  ContentScale.Crop,

                    modifier = Modifier
                        .size(270.dp)
                        .padding(8.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}