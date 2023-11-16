package com.honeykeys.materiatarot.base

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.honeykeys.materiatarot.presentation.ReadingViewModel
import kotlinx.coroutines.launch

@Composable
fun CardReader(viewModel: ReadingViewModel) {
    val context = LocalContext.current
    var offsetX by remember { mutableStateOf(0f)}
    val coroutineScope = rememberCoroutineScope()
    val isVisible by remember{mutableStateOf(true)}

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .pointerInput(Unit) {
                detectHorizontalDragGestures { change, _ ->
                    offsetX += change.positionChange().x

                    val threshold = 100f

                    if (change.positionChange().x > threshold) {
                        coroutineScope.launch {
                            viewModel.lastCard()
                        }
                        offsetX = 0f
                    }
                    if (change.positionChange().x < -threshold) {
                        coroutineScope.launch {
                            viewModel.nextCard()
                        }
                    }
                }
            },
        color = Color.White,
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) { // Animated visibility based on isVisible state
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(durationMillis = 500)
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { fullWidth -> -fullWidth },
                animationSpec = tween(durationMillis = 500)
            )
        ) {
            val imageResource = viewModel.cardArt.value
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(){
                                viewModel.flipCardFaceUp()
                    },
                contentAlignment = Alignment.Center) {
                if (viewModel.isReversed.value) {
                    Image(
                        painter = painterResource(id = imageResource),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize().rotate(180f),
                        contentScale = ContentScale.Fit
                    )
                }
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            } // Card content or UI here
        }
    }
}