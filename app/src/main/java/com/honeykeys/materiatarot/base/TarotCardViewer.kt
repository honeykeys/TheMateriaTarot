package com.honeykeys.materiatarot.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import com.honeykeys.materiatarot.R
import com.honeykeys.materiatarot.data.TarotCard
import com.honeykeys.materiatarot.data.fullCards
import com.honeykeys.materiatarot.ui.MainViewModel
import com.honeykeys.materiatarot.util.GenerateRandomBoolean
import com.honeykeys.materiatarot.util.shuffleDeck
import java.lang.Boolean.TRUE


 @Composable
fun TarotCardViewer() {
    LazyRow () {
        items(shuffledDeck.size) { tarotItem ->
            TarotCardItem(shuffledDeck[tarotItem])
        }
    }
}

@Composable
fun TarotCardItem(card: TarotCard) {
}
