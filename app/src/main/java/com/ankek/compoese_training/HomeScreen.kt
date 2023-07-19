package com.ankek.compoese_training

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun HomeScreen(state: State<Int> = mutableStateOf(0), onClickListener: (() -> Unit) = {}) {

    Row(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            listOf(
                "green bnt",
                "huilka btn",
                "counter",
                "start call",
                "end call",
                "people"
            ).forEach {
                Button(onClick = onClickListener) {
                    Text(text = it)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Box(
                modifier = Modifier
                    .width(180.dp)
                    .height(140.dp)
                    .background(Color.Green, shape = CutCornerShape(20.dp))
            )

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .width(160.dp)
                    .height(120.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(Color.Red, Color.Yellow, Color.Green),
                        ),
                        shape = RoundedCornerShape(20.dp),
                    )
                    .border(
                        width = 2.dp,
                        shape = RoundedCornerShape(20.dp),
                        brush = Brush.linearGradient(
                            colors = listOf(Color.Green, Color.Red, Color.Yellow),
                        ),
                    )
            )

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .width(140.dp)
                    .height(140.dp)
                    .background(color = Color.Red, shape = CircleShape),
            ) {
                Text(
                    text = "Counter: ${state.value}",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Image(
                painter = painterResource(id = androidx.core.R.drawable.ic_call_answer),
                contentDescription = null,
            )

            Icon(
                painter = painterResource(id = androidx.core.R.drawable.ic_call_decline),
                contentDescription = null
            )

            AsyncImage(
                model = "https://developer.android.com/images/android-go/next-billion-users_856.png",
                contentDescription = null
            )
        }
    }
}

@Composable
fun Info(text: String, modifier: Modifier) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 32.sp,
        color = Color.White,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Center,
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}