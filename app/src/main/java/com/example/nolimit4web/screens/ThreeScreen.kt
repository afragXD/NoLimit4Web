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
fun ThreeScreen() {
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
            "Шаги",
            color = MainText,
            fontSize = 28.sp,
            modifier = Modifier
                .padding(top = 30.dp),
        )
        Text(
            "1. Вскипятить молоко в кастрюле на плите. Подождать, пока молоко остынет до температуры до 35-40 °С, снять пенку.\n" +
                    "2. Отлить немного молока и тщательно размешать в нем закваску.\n" +
                    "3. Налить молоко в чашу, добавить закваску, перемешать.\n" +
                    "4. Закрыть крышку и включить режим «Мультиповар», задать температуру 35°С на 8 часов.\n" +
                    "5. Приготовленный йогурт переложить в порционные баночки или формочки. Хранить в холодильнике.\n" +
                    "6. Перед подачей в каждую порцию положить 1 ч.л. мелко нарезанных фруктов или ягод.",
            color = MainText,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = 30.dp, start = 5.dp, end = 5.dp).fillMaxWidth()
        )
    }
}