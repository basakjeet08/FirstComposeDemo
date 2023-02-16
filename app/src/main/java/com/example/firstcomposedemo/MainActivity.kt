package com.example.firstcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcomposedemo.ui.theme.FirstComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage(stringResource(R.string.happy_birthday_text), stringResource(R.string.from))
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithImage(message : String , from : String){
    val image = painterResource(id = R.drawable.background)
    Box{
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = image,
            contentDescription = null
        )
        BirthdayGreetingWithText(message = message, from = from)
    }

}

@Composable
fun BirthdayGreetingWithText(message: String, from: String) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
            ){
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(
                    align = Alignment.Start
                )
                .padding(start = 16.dp , top = 16.dp),
            text = message,
            fontSize = 36.sp,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.End)
                .padding(end = 16.dp , bottom = 16.dp),
            text = from,
            fontSize = 36.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    FirstComposeDemoTheme {
        BirthdayGreetingWithImage( stringResource(R.string.happy_birthday_text), stringResource(R.string.from))
    }
}