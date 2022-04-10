package com.example.jeckpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF123456))
            ) {
                Column(
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                        .border(
                            border = BorderStroke(width = 1.dp, color = Color(0xff000000))
                        )
                        .background(Color(0xFFFFFFFF)),
                    verticalArrangement = Arrangement.SpaceEvenly,
//                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Column",
                        modifier = Modifier
                            .border(
                                BorderStroke(
                                    1.dp, Color(
                                        0xFFFF0000
                                    )
                                )
                            )
                            .align(Alignment.CenterHorizontally)

                    )


                    Text(
                        text = "Column",
                        modifier = Modifier
                            .border(
                                BorderStroke(
                                    1.dp, Color(
                                        0xFFFF0000
                                    )
                                )
                            )
                    )
                }

                Spacer(modifier = Modifier.padding(10.dp))

                Row(
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                        .border(border = BorderStroke(width = 1.dp, color = Color(0xff000000)))
                        .background(Color(0xFFFFFFFF)),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "row",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .border(
                                BorderStroke(
                                    1.dp, Color(
                                        0xFFFF0000
                                    )
                                )
                            )
                    )

                    Text(
                        text = "row",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .border(
                                BorderStroke(
                                    1.dp, Color(
                                        0xFFFF0000
                                    )
                                )
                            )
                    )
                }
            }


        }

        //TODO Colum
//        setContent {
//
//            Column(
//                Modifier.fillMaxWidth()
//                    .fillMaxHeight()
//                    .verticalScroll(state = ScrollState(0), enabled = true)
//                    .background(Color(0x8C000000))
//
//            ) {
//                Image(
//                    painterResource(R.drawable.screenshot_2022_03_18_135722),
//                    contentDescription = "hello",
//                    contentScale = ContentScale.Fit,
//                    modifier = Modifier.size(200.dp)
//                )
//
//                Spacer(modifier = Modifier.padding(10.dp))
//
//                Column {
//                    Text(
//                        buildAnnotatedString {
//                            withStyle(style = SpanStyle(color = Color.Blue)) {
//                                append("H")
//                            }
//                            append("ello ")
//
//                            withStyle(
//                                style = SpanStyle(
//                                    fontWeight = FontWeight.Bold,
//                                    color = Color.Red
//                                )
//                            ) {
//                                append("W")
//                            }
//                            append("orld")
//                        }
//                    )
//                    Spacer(modifier = Modifier.padding(10.dp))
//                }
//            }
//        }
    }
}