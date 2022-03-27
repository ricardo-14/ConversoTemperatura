package com.example.converttemp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.example.converttemp.ui.theme.ConvertTempTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConvertTempTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    var valorC by remember {
        mutableStateOf(0)
    }

    var valorF by remember {
        mutableStateOf(0)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            //value = "${valor}",
            value = valorC.toString(),
            onValueChange = {
                if (it.length == 0) {
                    valorC = 0
                }
                else {
                    if (it.isDigitsOnly()) {
                        valorC = it.toInt()
                    }
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number),

        label = { Text(text = "Digite o valor em °C")}
        )

        MostrarValorF(valorC)

        OutlinedTextField(
            //value = "${valor}",
            value = valorF.toString(),
            onValueChange = {
                if (it.length == 0) {
                    valorF = 0
                }
                else {
                    if (it.isDigitsOnly()) {
                        valorF = it.toInt()
                    }
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number),

            label = { Text(text = "Digite o valor em °F")}
        )

        MostrarValorC(valorF)

    }

}

@Composable
fun MostrarValorF(valor: Int) {
    //val df = DecimalFormat("0.00")
    //Text(text = "${df.format(valor)}", style = MaterialTheme.typography.subtitle1)
    Text(text = "${valor * 1.8 + 32} °F", style = MaterialTheme.typography.subtitle1)
}

@Composable
fun MostrarValorC(valor: Int) {
    //val df = DecimalFormat("0.00")
    //Text(text = "${df.format(valor)}", style = MaterialTheme.typography.subtitle1)
    Text(text = "${(valor -32) / 1.8} °C", style = MaterialTheme.typography.subtitle1)
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ConvertTempTheme {
        MyApp()
    }
}