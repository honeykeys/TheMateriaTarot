package com.honeykeys.materiatarot.presentation.screens.reading

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.honeykeys.materiatarot.R
import com.honeykeys.materiatarot.presentation.component.MateriaTopAppBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReadingScreen(viewModel: ReadingViewModel, navController: NavController) {

    val animateCardOut = remember {MutableTransitionState(false)}
    val isFaceDown by viewModel.isFaceDown.collectAsState()
    val navController = rememberNavController()
    var showBottomSheet by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()

    Scaffold(
        topBar = { MateriaTopAppBar(navController) },
        bottomBar = {
            BottomAppBar(
            actions = {
                IconButton(onClick = {  }) {
                    Icon(
                        Icons.Filled.Info,
                        contentDescription = "Show Card Info",
                    )
                }
                IconButton(onClick = { viewModel.saveNewReading()}) {
                    Icon(
                        Icons.Filled.FavoriteBorder,
                        contentDescription = "Save Reading",
                    )
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { viewModel.startNewReading()},
                    containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                ) {
                    Icon(Icons.Default.Add, "Localized description")
                }
            }
        )
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            if (dragAmount.x > 100) {
                                viewModel.nextCard()
                            }
                        }
                    }
            ) {
                AnimatedVisibility(
                    visibleState = animateCardOut,
                    exit = fadeOut() + slideOutHorizontally(targetOffsetX = {-it}),
                    enter = fadeIn() + slideInHorizontally()
                ){
                    Crossfade(
                        targetState = isFaceDown, label = "card-flip animation"
                    ) { isFaceDown ->
                        if (isFaceDown) {
                            Image(
                                modifier = Modifier
                                    .fillMaxSize(1f)
                                    .padding(24.dp)
                                    .pointerInput(Unit) {
                                        detectTapGestures {
                                            viewModel.flipCardFaceUp()
                                        }
                                    },
                                painter = painterResource(id = R.drawable.fool),
                                contentDescription = "test"
                            )
                        }
                    }
                }
            }
            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState
                ) {
                    Text(text = stringResource(id = viewModel.getCardName()))
                    Text(text = stringResource(id = viewModel.getCardUpright()))
                    Text(text = stringResource(id = viewModel.getCardReversed()))
                    Button(onClick = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                showBottomSheet = false
                            }
                        }
                    }) {
                        Text("Hide bottom sheet")
                    }
                }
            }

        }
    )
}
