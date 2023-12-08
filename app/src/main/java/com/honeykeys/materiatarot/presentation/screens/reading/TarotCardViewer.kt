package com.honeykeys.materiatarot.presentation.screens.reading

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.honeykeys.materiatarot.R
import com.honeykeys.materiatarot.data.model.TarotCard
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TarotCardCarousel(viewModel: ReadingViewModel) {
    val pagerState: PagerState = rememberPagerState {
        viewModel.getReadingCards().size
    }
    val showBottomSheet by viewModel.showDetails.observeAsState()
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
    ) { page ->
        if (viewModel.getReadingType() == ReadingType.NEW) {
            NewCarouselItem(viewModel.getReadingCards()[page])
        }
        else {
            SavedCarouselItem(card = viewModel.getReadingCards()[page])
        }
        if (showBottomSheet == true) {
            ModalBottomSheet(
                onDismissRequest = {
                    viewModel.toggleDetails()
                },
                sheetState = sheetState
            ) {
                Text(text = stringResource(id = viewModel.getReadingCards()[page].cardName))
                Text(text = stringResource(id = viewModel.getReadingCards()[page].cardUpright))
                Text(text = stringResource(id = viewModel.getReadingCards()[page].cardReversed))
                Button(onClick = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            viewModel.toggleDetails()
                        }
                    }
                }) {
                    Text("Hide bottom sheet")
                }
            }
        }
    }
}
@Composable
fun NewCarouselItem(card: TarotCard) {
    var isCardFlipped by remember { mutableStateOf(true) }

    AnimatedVisibility(
        visible = isCardFlipped,
        enter = slideInHorizontally(initialOffsetX = { -it }) + fadeIn(),
        exit = slideOutHorizontally(targetOffsetX = { -it }) + fadeOut()
    ) {
        Image(
            painter = painterResource(id = R.drawable.cardback),
            contentDescription = "Cardback",
            modifier = Modifier
                .clickable { isCardFlipped = !isCardFlipped }
                .fillMaxSize()
        )
    }

    AnimatedVisibility(
        visible = !isCardFlipped,
        enter = slideInHorizontally(initialOffsetX = { it }) + fadeIn(),
        exit = slideOutHorizontally(targetOffsetX = { it }) + fadeOut()
    ) {
        val rotationAngle = if (card.isReversed) 180F else 0F
        Image(
            painter = painterResource(id = card.cardImage),
            contentDescription = if (card.isReversed) "Reversed Card Image" else "Upright Card Image",
            modifier = Modifier
                .clickable { isCardFlipped = !isCardFlipped }
                .fillMaxSize()
                .graphicsLayer {
                    rotationX = rotationAngle
                    rotationY = 0F
                }
        )
    }
}
@Composable
fun SavedCarouselItem(card: TarotCard) {
    if (card.isReversed) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .rotate(180F),
            painter = painterResource(id = card.cardImage),
            contentDescription = "Reversed Card Image"
        )
    } else {
        Image(
            painterResource(id = card.cardImage),
            modifier = Modifier
                .fillMaxSize(),
            contentDescription = "Upright Card Image"
        )
    }
}

