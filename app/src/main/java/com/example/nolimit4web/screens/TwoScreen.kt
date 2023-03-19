package com.example.nolimit4web.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nolimit4web.R
import com.example.nolimit4web.ui.theme.MainText

@Preview(showBackground = true)

@Composable
fun TwoScreen() {
    Image(
        painter = painterResource(id = R.drawable.main_bg),
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Состав",
            color = MainText,
            fontSize = 28.sp,
            modifier = Modifier
                .padding(top = 30.dp),
        )
        Text(
            "Молоко - 1000 мл.\n" +
                    "Закваска (простокваша 1%) - 1 упак.\n" +
                    "Ягоды свежие любые - 150 гр.",
            color = MainText,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = 30.dp, start = 5.dp, end = 5.dp).fillMaxWidth()
        )
    }
}