package com.capgemini.composeapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Welcome(modifier: Modifier = Modifier,
            onBtnClick: ()->Unit){
    // Text, Image, Button
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Welcome to Capgemini",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Blue, fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier.size(40.dp))
        Surface(shape = CircleShape,
            border = BorderStroke(4.dp, Color.Red)) {

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "logo",
                modifier = Modifier.background(Color.Black)
            )
        }
        Spacer(modifier = Modifier.size(40.dp))
        Button(  onClick = {
            onBtnClick()
        }) {
            Text(text = "CONTINUE", fontSize = 24.sp)
        }
       // Divider(thickness = 5.dp, color = Color.Red)
    }

}

//@Preview
//@Composable
//fun PreviewWelcome(){
//    Welcome()
//}