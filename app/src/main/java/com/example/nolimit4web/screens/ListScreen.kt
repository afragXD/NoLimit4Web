package com.example.nolimit4web.screens

import android.content.Intent
import android.support.v4.os.IResultReceiver.Default
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nolimit4web.ListActivity
import com.example.nolimit4web.RecipeActivity
import com.example.nolimit4web.ui.theme.MainBack
import com.example.nolimit4web.ui.theme.MainText


@Preview(showBackground = true)
@Composable
fun ListScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Быстрый поиск",
            color = MainText,
            fontSize = 33.sp,
            modifier = Modifier
                .padding(top = 30.dp),
        )
        val names = listOf("Натуральный йогурт 1", "Омлет простой", "Вареники")
        RecyclerView(names)
    }
}

@Composable
fun ListItem(name:String){
    val context = LocalContext.current
    Surface(
        color = MainBack,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = "Название",
                        color = MainText,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = name,
                        fontWeight = FontWeight.ExtraBold,
                        color = MainText,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                OutlinedButton(onClick = {
                    context.startActivity(Intent(context, RecipeActivity::class.java))
                }) {
                    Text(text = "Открыть", color = MainText)
                }
            }
        }
    }
}

@Composable
fun RecyclerView(
    names:List<String>
){
    LazyColumn(
        modifier = Modifier.padding(vertical = 5.dp)
    ){
        items(items = names){name->
            ListItem(name = name)
        }
    }
}
