package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.ui.theme.TodoListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    var item by remember {
        mutableStateOf("")
    }

    var items = mutableListOf<String>()
    TodoListTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(text = "TODO List!",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(12.dp),
                )
                Row() {
                    OutlinedTextField(
                        value = item,
                        onValueChange = { item = it},
                        modifier = Modifier.semantics { contentDescription = "OutLinedTextField" },
                        label = {
                            Text(text = "New Item", modifier = Modifier.semantics { contentDescription = "NewItemTextField" })
                        }
                    )

                    Button(onClick = {
                        if (item.isNotEmpty()) {
                            items.add(item)
                            item = ""
                        }
                    }, modifier =  Modifier.padding(14.dp).semantics { contentDescription = "SaveButton" }) {
                        Text(text = "Save")
                    }
                }
                
                Divider()
                
                Column() {
                    for (item in items) {
                     ToDoListItem(name = item)   
                    }
                }
            }
        }
    }
}

@Composable
fun ToDoListItem(name: String) {
    var isSelected by remember {
        mutableStateOf(false)
    }

    var color = MaterialTheme.colors.background
    if (isSelected) {
        color = MaterialTheme.colors.primary
    }
    Surface(
        color = color,
        modifier = Modifier.clickable {
            isSelected = !isSelected
        }
    ) {
        Text(text = name, modifier = Modifier.padding(12.dp))
        Divider()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    App()
}