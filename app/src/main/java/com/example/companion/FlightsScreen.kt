package com.example.companion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun FlightsScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight(.85f)
            .verticalScroll(rememberScrollState())
    ) {

            Text(text = "Available flights today", fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)




        Spacer(modifier=Modifier.height(20.dp))
        Row(modifier=Modifier.fillMaxWidth(1f)){
            Box(modifier=Modifier.fillMaxWidth()){
                Image(painter = painterResource(id = R.drawable.berlinlet), contentDescription =null ,
                    modifier = Modifier.fillMaxSize(),
                    contentScale= ContentScale.FillWidth)
                Text("From: Sarajevo\nTo: Berlin ",fontSize = 17.sp, fontWeight = FontWeight.Bold, modifier=Modifier.background(Color(
                    0x97FFFFFF
                )
                ))



            }

        }

        Spacer(modifier=Modifier.height(20.dp))
        Row(modifier=Modifier.fillMaxWidth(1f)){
            Box(modifier=Modifier.fillMaxWidth()){
                Image(painter = painterResource(id = R.drawable.rimlet), contentDescription =null ,
                    modifier = Modifier.fillMaxSize(),
                    contentScale= ContentScale.FillWidth)
                Text("From: Tuzla\nTo: Rome ",fontSize = 17.sp, fontWeight = FontWeight.Bold, modifier=Modifier.background(Color(
                    0x97FFFFFF
                )
                ))



            }

        }
        Spacer(modifier=Modifier.height(20.dp))
        Row(modifier=Modifier.fillMaxWidth(1f)){
            Box(modifier=Modifier.fillMaxWidth()){
                Image(painter = painterResource(id = R.drawable.istanbullet), contentDescription =null ,
                    modifier = Modifier.fillMaxSize(),
                    contentScale= ContentScale.FillWidth)
                Text("From: Sarajevo\nTo: Istanbul ",fontSize = 17.sp, fontWeight = FontWeight.Bold, modifier=Modifier.background(Color(
                    0x97FFFFFF
                )
                ))



            }

        }
        Spacer(modifier=Modifier.height(20.dp))
        Row(modifier=Modifier.fillMaxWidth(1f)){
            Box(modifier=Modifier.fillMaxWidth()){
                Image(painter = painterResource(id = R.drawable.zurichlet), contentDescription =null ,
                    modifier = Modifier.fillMaxSize(),
                    contentScale= ContentScale.FillWidth)
                Text("From: Sarajevo\nTo: Istanbul ",fontSize = 17.sp, fontWeight = FontWeight.Bold, modifier=Modifier.background(Color(
                    0x97FFFFFF
                )
                ))


            }

        }


    }


}