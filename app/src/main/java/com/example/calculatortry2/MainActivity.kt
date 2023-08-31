package com.example.calculatortry2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculatortry2.ui.theme.CalculatorTry2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberAction(view: View) {
        if(view is Button)
        {
            if(view.text==".")
            {
                if(canAddDecimal)
                    workingsTV.append(view.text)
                canAddDecimal=false
            }
            else
                workingsTV.append(view.text)
            canAddOperation=true
        }
    }
    fun operationAction(view: View) {
        if(view is Button && canAddOperation)
        {
            workingsTV.append(view.text)
            canAddOperation=false
            canAddDecimal=true
        }
    }
    fun allClearAction(view: View) {
        workingsTV.text=""
        resultsTV.text=""
    }
    fun backSpaceAction(view: View) {
        val length =workingsTV.length()
        if(length>0)
            workingsTV.text=workingsTV.text.subSequence(0, length-1)

    }
    fun equalsAction(view: View) {
        resultsTV.text=calculateResults()
    }
    private fun calculateResultes(): Stirng{
        val digitOperators=digitsOperators()
        if(digitsOperators.isEmpty()) return ""

        vla timesDivision= timeDgisionCalcu
    }

    private fun digitsOperators():MutableList<Any>
    {
        val list=mutableListOf<Any>()
        var currentDigit=""
        for(character in workingsTV.text)
        {
            if(character.isDigit()||character==".")
                currentDigit+=character
            else
            {
                 list.add(currentDigit.toFloat())
                currentDigit=""
                list.add(character)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTry2Theme {
        Greeting("Android")
    }
}