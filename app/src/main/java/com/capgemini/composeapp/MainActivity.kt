package com.capgemini.composeapp

import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.capgemini.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier){
    val isContinueClicked = remember {
        mutableStateOf(false)
    }
    if (isContinueClicked.value) {
        ShowList(names = listOf("John", "Merry", "Robert", "Mark"))
    } else {
        Welcome(){
            isContinueClicked.value = true
        }
    }
}

@Composable
fun ShowList(names: List<String>){
    LazyColumn {
        items(names.size){
            val isClicked = remember {
                mutableStateOf(false)
            }
            if (isClicked.value) {
                Card(
                    modifier = Modifier.clickable {
                        isClicked.value = !isClicked.value
                    }, shape = RectangleShape,
                    border = BorderStroke(5.dp, Color.Blue)
                ) {
                    Greeting(name = names[it])
                }
            }
            else {
                Card(
                    modifier = Modifier.clickable {
                        isClicked.value = !isClicked.value
                    }, shape = RectangleShape,
                    border = BorderStroke(5.dp, Color.Red)
                ) {
                    Greeting(name = names[it])
                }
            }
        }
        items(10){
            Card (shape = CircleShape) {
                Greeting(name = "$it")
            }

        }
    }
    
}


@Composable
fun BoxExample(){
    Box(modifier = Modifier
        .size(400.dp)
        .background(Color.Cyan),
        ){
        Text(text = "Android", fontSize = 36.sp)
        Text(text = "Development", fontSize = 20.sp,
            modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.LightGray)
        .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(
            text = "Hello",
            modifier = modifier,
            //fontSize = 24.sp,
            color = Color.Blue,
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
        Text(
            text = "$name!",
            modifier = modifier,
            //fontSize = 24.sp,
            color = Color.Blue,
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeAppTheme {
        Greeting("Shridevi")
    }
}

@Preview(showBackground = true)
@Composable
fun BoxPreview(){
    BoxExample()
}