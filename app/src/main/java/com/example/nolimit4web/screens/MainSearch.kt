package com.example.nolimit4web.screens

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.nolimit4web.ListActivity
import com.example.nolimit4web.R
import com.example.nolimit4web.RecipeActivity
import com.example.nolimit4web.ui.theme.MainText
import com.example.nolimit4web.ui.theme.Zero
import org.json.JSONException
import org.json.JSONObject

private val url = "https://searchplatform.rospatent.gov.ru/patsearch/v0.2/search"
private val key = "193692a8f81a4d9286964658a811141c"

@Preview(showBackground = true)
@Composable
fun MainSearch() {

    var searchStr by remember {
        mutableStateOf("")
    }
    val maxSearchStr = 10

    val icon = painterResource(id = R.drawable.baseline_search_24)
    val context = LocalContext.current

    //sharking(context,searchStr)


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
        Text(
            "Быстрый поиск \uD83D\uDE0A",
            color = MainText,
            fontSize = 28.sp,
            modifier = Modifier
                .padding(top = 172.dp),
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 41.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(id = R.drawable.search_back),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
            )

            TextField(value = searchStr, onValueChange = { newText->
                if (newText.length <= maxSearchStr)
                    searchStr = newText
            },
                label = {
                    Text(
                        text = "Искать рецепт",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                trailingIcon = {
                               IconButton(onClick = {
                                   getRecipe(context,searchStr)
                               }) {
                                   Icon(painter = icon,
                                       contentDescription = "search icon"
                                   )
                               }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Zero
                ),
                modifier = Modifier.padding(start = 31.dp, end = 31.dp)
            )
        }
    }
}
private fun getRecipe(context:Context,input:String){
    if (!input.isNullOrBlank()){
        val postData = JSONObject()
        try {
            postData.put("qn", "пиво")
            postData.put("limit", 1)
        } catch (e: JSONException){
            Log.d("MyLog", e.toString())
        }
        val requestQueue = Volley.newRequestQueue(context)
        val stringRequest = object: JsonObjectRequest(Method.POST, url, postData, { response ->
            try {
                Log.d("MyLog", response.toString())
                context.startActivity(Intent(context, ListActivity::class.java))
            } catch (e : JSONException){
                Log.d("MyLog", e.toString())
            }
        }, {
                error ->
            Log.d("MyLog", error.toString())
        }){
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Authorization"] = "Bearer $key"
                headers["Content-Type"] = "application/json"
                return headers
            }
        }
        requestQueue.add(stringRequest)
    }
}
private fun sharking(context:Context, input:String){
    val sensorManager = context.getSystemService(SensorManager::class.java) as SensorManager
    val sensorShake = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    val sensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(p0: SensorEvent?) {
            if (p0!=null){
                val x_accl: Float = p0.values.get(0)
                val y_accl: Float = p0.values.get(1)
                val z_accl: Float = p0.values.get(2)

                val floatSum = Math.abs(x_accl) + Math.abs(y_accl) + Math.abs(z_accl)

                if (floatSum > 14){
                    Log.d("MyLog", "YES")
                    //searchStr = "YES"
                }
                else {
                    Log.d("MyLog", "NO")
                }
            }
        }

        override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
            TODO("Not yet implemented")
        }

    }
    sensorManager.registerListener(sensorEventListener, sensorShake, SensorManager.SENSOR_DELAY_NORMAL)
}