package com.example.demoapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.demoapplication.ui.theme.DemoApplicationTheme
import com.example.demoapplication.ui.theme.Purple80
import com.example.demoapplication.util.CalculationUtil

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(topBar = {
                        TopAppBar(
                            title = { Text(text = "CI / CD assignment") },
                            modifier = Modifier.padding(end = 5.dp),
                            navigationIcon = {
                                IconButton(onClick = { finish() }) {
                                    Icon(Icons.Filled.Close, contentDescription = "Back button")
                                }
                            },
                        )
                    }) {
                        Surface(modifier = Modifier.padding(it)) {
                            HomeScreen()
                        }
                    }
                }
            }
        }
    }
}

/**
 * Home screen composable which is the main screen shown with two buttons to navigate to add book
 * show book list screen.
 *
 * @param viewModel For navigating to other screens.
 */
@OptIn(ExperimentalUnitApi::class, ExperimentalMaterial3Api::class)
@Composable
@Preview
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxHeight(fraction = 0.8f)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var number1 by rememberSaveable { mutableStateOf(0) }
        var number2 by rememberSaveable { mutableStateOf(0) }
        var result by rememberSaveable { mutableStateOf("") }
        Icon(
            Icons.Filled.Home,
            modifier = Modifier.size(100.dp),
            contentDescription = "Home icon",
            tint = Purple80
        )

        Text(text = "Enter two number and get the sum.", fontSize = TextUnit(24F, TextUnitType(0)))

        TextField(
            value = number1.toString(),
            modifier = Modifier.fillMaxWidth(0.4f),
            label = { Text(text = "First number") },
            singleLine = true,
            onValueChange = { value ->
                number1 = if (value.isNotBlank()) {
                    value.toInt()
                } else {
                    0
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Done
            )
        )

        TextField(
            value = number2.toString(),
            modifier = Modifier.fillMaxWidth(0.4f),
            label = { Text(text = "Second number") },
            singleLine = true,
            onValueChange = { value ->
                number2 = if (value.isNotBlank()) {
                    value.toInt()
                } else {
                    0
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal, imeAction = ImeAction.Done
            )
        )

        Text(text = result, fontSize = TextUnit(24F, TextUnitType(0)))

        // Button to navigate to add a book screen.
        Button(onClick = { result = CalculationUtil().getSumOfTwoNumber(number1, number2) }) {
            Text(text = "Add two numbers")
        }
        // Button to navigate to add a book screen.
        Button(onClick = {
            result = CalculationUtil().getDifferenceOfTwoNumber(number1, number2)
        }) {
            Text(text = "Difference of two numbers")
        }
        // Button to navigate to add a book screen.
        Button(onClick = { result = CalculationUtil().getMultipleOfTwoNumber(number1, number2) }) {
            Text(text = "Multiply two numbers")
        }

    }
}