package com.honeykeys.materiatarot.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import com.honeykeys.materiatarot.R
import com.honeykeys.materiatarot.data.TarotCard
import com.honeykeys.materiatarot.data.fullCards
import com.honeykeys.materiatarot.util.GenerateRandomBoolean
import com.honeykeys.materiatarot.util.shuffleDeck
import java.lang.Boolean.TRUE


@Composable
fun TarotCardViewer() {
    val shuffledDeck = shuffleDeck(fullCards)
    LazyRow () {
        items(shuffledDeck.size) { tarotItem ->
            TarotCardItem(shuffledDeck[tarotItem], TRUE, TRUE)
        }
    }
}

@Composable
fun TarotCardItem(card: TarotCard) {

    val 

    if (isUpright && !isFlipped) {
        Image(
            painter = painterResource(id = card.cardImage),
            contentDescription = "Test Description")
    }
    if (!isUpright && isFlipped){
        Image(
            modifier = Modifier
                .rotate(180.0F),
            painter = painterResource(id = card.cardImage),
            contentDescription = "Test Description")
    }
    else {
        Image(
            painter = painterResource(R.drawable.cardback),
            contentDescription = "Test Cardback"
        )
    }


}