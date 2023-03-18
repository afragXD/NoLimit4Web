package com.example.nolimit4web.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nolimit4web.R
import com.example.nolimit4web.ui.theme.MainBack
import com.example.nolimit4web.ui.theme.MainText
import com.example.nolimit4web.ui.theme.Zero


@Preview(showBackground = true)
@Composable
fun MainSearch() {

    var search_str by remember {
        mutableStateOf("")
    }
    val maxSearchStr = 10

    Image(
        painter = painterResource(id = R.drawable.main_bg),
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Быстрый поиск \uD83D\uDE0A",
            color = MainText,
            fontSize = 28.sp,
            modifier = Modifier
                .padding(top = 172.dp),
        )
        TextField(value = search_str, onValueChange = { newText->
            if (newText.length <= maxSearchStr)
                search_str = newText
        },
            label = {
                Text(
                    text = "Искать рецепт",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Zero
            ),
            modifier = Modifier.
            padding(top = 41.dp, start = 25.dp, end = 25.dp),
        )
    }
}