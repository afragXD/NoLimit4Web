package com.example.nolimit4web

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource

sealed class BottomBar(
    val route: String,
    val title:String,
    val icon:ImageVector
) {
    object One : BottomBar(
        route = "one",
        title = "One",
        icon = Icons.Default.Info
    )
    object Two : BottomBar(
        route = "two",
        title = "Two",
        icon = Icons.Default.List
    )
    object Three : BottomBar(
        route = "three",
        title = "Three",
        icon = Icons.Default.Menu
    )
}