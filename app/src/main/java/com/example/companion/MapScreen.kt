package com.example.companion

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun MapScreen() {
    val hadzici = LatLng(43.82222,   18.20667)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(hadzici, 10f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxHeight(.89f),
        cameraPositionState = cameraPositionState,
        uiSettings = MapUiSettings(
            zoomControlsEnabled = false,
            compassEnabled = true,
            myLocationButtonEnabled = true
        )
    ) {
        Marker(
            state = rememberMarkerState(position = hadzici),
            draggable = true,
            title = "Hadžići",
            snippet = "Marker in Hadžići",
            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)
        )
    }
}