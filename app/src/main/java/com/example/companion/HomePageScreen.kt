package com.example.companion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.companion.data.Cities

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageScreen(navController: NavController) {
    val text = remember { mutableStateOf("") }
    val active = remember { mutableStateOf(false) }
    val items = remember {
        mutableStateListOf(
            "Ivan",
            "Android Dev"
        )
    }


    Column() {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .padding(top = 5.dp),
            colors = SearchBarDefaults.colors(
                containerColor = Color(0xFFEEEEEE)
            ),
            query = text.value,
            onQueryChange = { text.value = it },
            onSearch = {
                items.add(text.value)
                active.value = false
                text.value = ""
            },
            active = active.value,
            onActiveChange = {
                active.value = it
            },
            placeholder = { Text(text = "Search", color = Color.Black) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.search),
                    tint = Color.Black
                )
            },
            trailingIcon = {
                if (active.value) {
                    Icon(
                        modifier = Modifier.clickable {
                            if (text.value.isNotEmpty()) {
                                text.value = ""
                            } else {
                                active.value = false
                            }
                        },
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(id = R.string.close)
                    )
                }
            }
        ) {
            items.forEach {
                Row(modifier = Modifier.padding(14.dp)) {
                    Icon(
                        modifier = Modifier.padding(end = 10.dp),
                        painter = painterResource(id = R.drawable.ic_history),
                        contentDescription = "stringResource(id = R.string.history)"
                    )
                    Text(text = it)
                }
            }
        }
        val cities = remember { mutableStateOf(Cities.getAllCities()) }
        val pageSize = 5
        var currentPage = 0
        LazyColumn(modifier = Modifier.background(Color(0x5EC5FAE3)).fillMaxHeight(0.87f)) {
           // for list of cities in lazy row
            val citiesFrom = currentPage * pageSize
            var citiesTo = (currentPage + 1 * pageSize)
            if (cities.value.size < citiesTo)
                citiesTo = cities.value.size
            val nextCity = cities.value.subList(citiesFrom, citiesTo)

            item{ Text(text="Cities to visit: ", textAlign = TextAlign.Left,fontWeight = FontWeight.Bold)}

            item {
                LazyRow(
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .height(250.dp)
                ) {
                    items(nextCity) {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .width(150.dp)
                                .padding(5.dp)
                                .clip(
                                    RoundedCornerShape(20.dp)
                                )
                                .clickable {
                                    navController.navigate(
                                        Destinations.Detail.createRoute(
                                            it.id
                                        )
                                    )
                                }
                        ){
                            Image(painter = painterResource(id = it.resId), contentDescription =null ,
                                modifier = Modifier.fillMaxHeight(0.90f),
                                contentScale= ContentScale.Crop)

                        }

                    }

                }
            }
            currentPage++

            item{

                Text(text="Best places to visit right now!",fontWeight = FontWeight.Bold)
                Row(modifier =Modifier.background(Color.Transparent).padding(10.dp)){

                    Image(painter = painterResource(id = R.drawable.svica) , contentDescription =null ,
                        contentScale= ContentScale.Crop, modifier = Modifier.clip(RoundedCornerShape(30.dp))
                        )

                    Text(text="Discover the joy of skiing in Switzerland's stunning alpine wonderland. Join us on the slopes for an unforgettable winter adventure!",
                        textAlign = TextAlign.Center, fontSize = 20.sp,color= Color.Gray)
                }
                Row(modifier =Modifier.background(Color.Transparent).padding(10.dp)){

                    Image(painter = painterResource(id = R.drawable.capajevo) , contentDescription =null ,
                        contentScale= ContentScale.Crop, modifier = Modifier.clip(RoundedCornerShape(20.dp))
                    )

                    Text(text="Welcome to Sarajevo! \n"+ "Place where the spirit of Ramadan fills the air, and the city comes alive with vibrant traditions and warm hospitality.",
                        textAlign = TextAlign.Center, fontSize = 20.sp,color= Color.Gray)
                }
                Row(modifier =Modifier.background(Color.Transparent).padding(10.dp)){

                    Image(painter = painterResource(id = R.drawable.florence) , contentDescription =null ,
                        contentScale= ContentScale.Crop, modifier = Modifier.clip(RoundedCornerShape(20.dp))
                    )

                    Text(text="Welcome to Florence, a city of artistic wonders and captivating beauty. Discover the essence of the Renaissance as you explore its enchanting streets and immerse yourself in its rich cultural heritage.",
                        textAlign = TextAlign.Center, fontSize = 18.sp,color= Color.Gray)
                }
                Row(modifier =Modifier.background(Color.Transparent).padding(10.dp)){

                    Image(painter = painterResource(id = R.drawable.amsterdam) , contentDescription =null ,
                        contentScale= ContentScale.Crop, modifier = Modifier.clip(RoundedCornerShape(20.dp))
                    )

                    Text(text="Let's create lifelong memories together in the captivating streets of Amsterdam.Involve yourself in the enchanting canals, vibrant culture, and rich history that this beautiful city has to offer. ",
                        textAlign = TextAlign.Center, fontSize = 18.sp,color= Color.Gray)
                }

            }
        }
    }


}
