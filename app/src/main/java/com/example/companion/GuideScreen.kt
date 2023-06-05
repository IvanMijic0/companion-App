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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GuideScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight(.89f)
            .verticalScroll(rememberScrollState()).background(Color(0xD0FFF2E0))
    ) {
        Text(text = "Crucial Travel Advices", fontSize = 27.sp, fontWeight = FontWeight.Bold)
        
        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier
            .background(Color.Transparent)
            .padding(20.dp)) {

            Image(
                painter = painterResource(id = R.drawable.info),
                contentDescription = null, modifier=Modifier.fillMaxSize(.15f)

            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "When traveling to a new destination, it is essential to stay informed about the local customs and traditions to ensure you show respect and avoid unpleasant situations.",
                textAlign = TextAlign.Left, fontSize = 15.sp, color = Color.DarkGray
            )
        }


        Row(modifier = Modifier
            .background(Color.Transparent)
            .padding(20.dp)) {

            Image(
                painter = painterResource(id = R.drawable.sec2),
                contentDescription = null, modifier=Modifier.fillMaxSize(.15f)

            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Keeping your travel documents safe and secure is of utmost importance while traveling to ensure a smooth and hassle-free journey. Store your passport, visas, ID cards, and other important documents in a secure and easily accessible place, such as a travel document organizer or a hotel safe.",
                textAlign = TextAlign.Left, fontSize = 15.sp, color = Color.DarkGray
            )
        }
        Row(modifier = Modifier
            .background(Color.Transparent)
            .padding(20.dp)) {

            Image(
                painter = painterResource(id = R.drawable.planputovanja),
                contentDescription = null, modifier=Modifier.fillMaxSize(.15f)

            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Making a plan when traveling is vital to ensure a well-organized and enjoyable trip. Start by researching your destination, identifying key attractions, and determining the best time to visit. Create a rough itinerary that includes accommodation, transportation, and a list of must-see places or activities.",
                textAlign = TextAlign.Left, fontSize = 15.sp, color = Color.DarkGray
            )
        }

        Row(modifier = Modifier
            .background(Color.Transparent)
            .padding(20.dp)) {

            Image(
                painter = painterResource(id = R.drawable.torba),
                contentDescription = null, modifier=Modifier.fillMaxSize(.15f)

            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Packing light and smart is essential to enhance your travel experience by reducing the burden of carrying heavy luggage and ensuring convenience during your journey.Remember to research the weather conditions and specific requirements of your destination to pack accordingly, and consider using packing cubes or compression bags to optimize space and keep your belongings organized.",
                textAlign = TextAlign.Left, fontSize = 15.sp, color = Color.DarkGray
            )
        }

    }
}