package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Pink40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                
                
                MyScreen()
                
                }
            }
        }
    }


@Composable
fun MyScreen(){
    
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
    ) {
        var amt by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = amt,
            onValueChange = {
                            if (it.toDoubleOrNull() !=null){
                                amt = it
                            }
            },
            label = { Text(text = "Enter bill amount: ")}
        )
        val amount = amt.toDoubleOrNull()?:0.0;
        val tip = calculateTip(amount);

        Text(text = "discount you get :" + tip)
    }
    
    
}

private fun calculateTip(amt:Double) : Double {
    val tip = amt* 0.15;
    return tip;
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
    }
}