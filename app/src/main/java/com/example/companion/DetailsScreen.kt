package com.example.companion

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale.Companion.FillWidth
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.companion.data.Cities
import com.example.companion.data.Cities.Companion.getAllCities
import com.example.companion.data.getItem

@Composable
fun DetailsScreen(itemId: Int,modifier: Modifier) {

    val item = getItem(itemId)
    var city : Cities = item as Cities

    val painter = painterResource(id = city.resId)
    val name= item.cityname
    val description = item.desc

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight(.89f).verticalScroll(rememberScrollState())

    ) {
        Text(text = "City information", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        painter?.let{
            Image(painter=painter,contentDescription=null,modifier=Modifier.fillMaxWidth(),contentScale=FillWidth)
        }
        name?.let{
                Text(text=it, fontWeight = FontWeight.Bold,fontSize=25.sp,modifier= Modifier.padding(8.dp))
        }

        description?.let{
            Text(text=it,fontSize=12.sp,modifier=Modifier.padding(8.dp), textAlign= TextAlign.Justify)
        }
    }

}