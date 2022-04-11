package com.example.jeckpackcompose

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController


class RecipelistFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply { 
            setContent { 
                Column() {
                    Text(text = "Hello", fontSize = 20.sp)
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(onClick = {findNavController().navigate(R.id.action_recipelistFragment_to_recipeFragment) }) {
                        Text(text = "ClickMe")
                    }
                }
            }
        }
    }

    @Composable
    fun SupperScripText(
        normalText: String,
        supperText: String,
        fontSizeNormaText: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
        fontSizeNormaSupperText: TextUnit = MaterialTheme.typography.overline.fontSize
    ) {
        Text(text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(fontSize = fontSizeNormaText)
            ) {
                append(normalText)
            }

            withStyle(
                style = SpanStyle(
                    fontSize = fontSizeNormaSupperText,
                    fontWeight = FontWeight.Bold,
                    baselineShift = BaselineShift.Superscript
                )
            ) {
                append(supperText)
            }
        })

    }


    @Preview
    @Composable
    fun TestTextField() {
        var text by remember {
            mutableStateOf("...")
        }


        OutlinedTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
//        readOnly = true,
//        enabled = false
            label = {
                Text(text = "Label")
            },
            singleLine = true,
//        maxLines = 2,
            leadingIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "Email", tint = MaterialTheme.colors.primary)
                }
            },
            trailingIcon = {
                if (text.length > 10){
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Check, contentDescription = "Email", tint = MaterialTheme.colors.primary)
                    }
                }

            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Go,

                ),

            keyboardActions = KeyboardActions(
                onSearch = {
                    Log.e("CheckLog","Click")
                },
                onGo = {
                    Log.e("CheckLog","Click")
                }
            )
        )
    }

    @Composable
    fun TextFieldPassword () {
        var password by rememberSaveable { mutableStateOf("") }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }

        OutlinedTextField(
            value = password,

            onValueChange = { password = it },

            label = { Text("Password") },

            singleLine = true,

            placeholder = { Text("Password") },

            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "Email", tint = MaterialTheme.colors.primary)
                }
            },
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.ShoppingCart
                else Icons.Filled.Check

                // Please provide localized description for accessibility services
                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = {passwordVisible = !passwordVisible}){
                    Icon(imageVector  = image, description)
                }
            }


        )
    }


    @Composable
    fun MyCustomTextView (){
        Column (modifier = Modifier.padding(10.dp)){
            var textState by remember { mutableStateOf("") }
            val maxLength = 110
            val lightBlue = Color(0xffd8e6ff)
            val blue = Color(0xff76a9ff)
            Text(
                text = "Caption",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp),
                textAlign = TextAlign.Start,
                color = blue
            )

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = textState,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = lightBlue,
                    cursorColor = Color.Black,
                    disabledLabelColor = lightBlue,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                onValueChange = {
                    if (it.length <= maxLength) textState = it
                },
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                trailingIcon = {
                    if (textState.isNotEmpty()) {
                        IconButton(onClick = { textState = "" }) {
                            Icon(
                                imageVector = Icons.Outlined.Close,
                                contentDescription = null
                            )
                        }
                    }
                }
            )


            Text(
                text = "${textState.length} / $maxLength",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                textAlign = TextAlign.End,
                color = blue
            )
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposableTheme {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    TestTextField()
                }
            }

        }
    }


    val Purple200 = Color(0xFFBB86FC)
    val Purple500 = Color(0xFF6200EE)
    val Purple700 = Color(0xFF3700B3)
    val Teal200 = Color(0xFF03DAC5)

    private val DarkColorPalette = darkColors(
        primary = Purple200,
        primaryVariant = Purple700,
        secondary = Teal200,
    )

    private val LightColorPalette = lightColors(
        primary = Purple500,
        primaryVariant = Purple700,
        secondary = Teal200,


        @Composable
        fun ComposableTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
            val colors = if (darkTheme) {
                DarkColorPalette
            } else {
                LightColorPalette
            }

            MaterialTheme(
                colors = colors,
                typography = Typography,
                shapes = Shapes,
                content = content
            )
        }

}