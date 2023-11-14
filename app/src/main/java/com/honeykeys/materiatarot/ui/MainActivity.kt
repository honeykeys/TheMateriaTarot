package com.honeykeys.materiatarot.ui

import android.os.Bundle
import android.provider.Settings.Secure.getString
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.honeykeys.materiatarot.R
import com.honeykeys.materiatarot.data.EMPEROR
import com.honeykeys.materiatarot.data.EMPRESS
import com.honeykeys.materiatarot.data.ReadingDatabase
import com.honeykeys.materiatarot.data.TarotCard
import com.honeykeys.materiatarot.src.theme.MateriaTarotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val db = Room.databaseBuilder(
            applicationContext,
            ReadingDatabase::class.java, "reading"
        ).build()
        super.onCreate(savedInstanceState)
        setContent {
            MateriaTarotTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxHeight(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun Greeting() {
}

@Preview(showBackground = true)
@Composable
fun TarotPreview() {
    MateriaTarotTheme {
        Greeting()
    }
}