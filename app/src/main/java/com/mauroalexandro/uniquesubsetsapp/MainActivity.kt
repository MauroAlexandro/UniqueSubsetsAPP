package com.mauroalexandro.uniquesubsetsapp

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
import com.mauroalexandro.uniquesubsetsapp.ui.theme.UniqueSubsetsAPPTheme

class MainActivity : ComponentActivity() {
    private lateinit var integerSet: IntegerSet
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UniqueSubsetsAPPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    getAllUniqueSubSets()
                }
            }
        }

    }

    @Composable
    private fun getAllUniqueSubSets() {
        integerSet = IntegerSet.getInstance()

        //Create and Array of Integers - Set
        val integerSetArray: MutableList<Int> = ArrayList()
        integerSetArray.add(1)
        integerSetArray.add(2)
        integerSetArray.add(3)

        //Call to the getUniqueSubset Function in order to retrieve all unique subsets
        val allUniqueSubSets = integerSet.getUniqueSubset(integerSetArray)
        var uniqueSubSetList = ""
        for (i in allUniqueSubSets.indices) {
            val integerSubSet = allUniqueSubSets[i]
            var subSetGroup = ""

            for (j in integerSubSet.indices) {
                subSetGroup += integerSubSet[j].toString()+" "
            }
            uniqueSubSetList += subSetGroup+"\r\n"
        }
        SubSetList(uniqueSubSetList)
    }
}

@Composable
fun SubSetList(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UniqueSubsetsAPPTheme {
        SubSetList("Android")
    }
}