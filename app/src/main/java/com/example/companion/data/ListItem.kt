package com.example.companion.data

abstract class ListItem {
    companion object {
        private var id = 0
        fun getUUID() = id++
    }
}
fun getItem(uuid: Int): ListItem? {
    for (cities in Cities.getAllCities())
        if (cities.id == uuid)
            return cities

    return null
}
