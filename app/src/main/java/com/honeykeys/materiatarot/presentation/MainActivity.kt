package com.honeykeys.materiatarot.presentation

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.honeykeys.materiatarot.MateriaTarotApp
import com.honeykeys.materiatarot.R
import com.honeykeys.materiatarot.presentation.component.MateriaBottomAppBar
import com.honeykeys.materiatarot.presentation.component.MateriaTopAppBar
import com.honeykeys.materiatarot.presentation.theme.MateriaTarotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appContainer = MateriaTarotApp.instance.appContainer

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
/* USING THE BELOW TABLE TO BUILD PREVIEWS */

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Composable
fun ReadingScreenPreview() {

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { MateriaTopAppBar() },
        bottomBar = { MateriaBottomAppBar()},
        content = { innerPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                color = MaterialTheme.colorScheme.surface
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize(1f)
                        .shadow(1.dp)
                        .padding(36.dp),
                    painter = painterResource(id = R.drawable.fool),
                    contentDescription = "test"
                )
            }
            ModalBottomSheet(
                sheetState = sheetState,
                onDismissRequest = { showBottomSheet = false }
            ) {
                Column {
                    Button(
                        onClick = { showBottomSheet = false }
                    ) {
                        Text("Close Drawer")
                    }
                }
            }
        }
    )
}