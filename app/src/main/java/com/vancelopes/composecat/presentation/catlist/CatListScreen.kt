package com.vancelopes.composecat.presentation.catlist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vancelopes.composecat.presentation.CatsViewModel
import com.vancelopes.composecat.presentation.ui.item.CatViewItem

@Composable
fun CatListScreen(catsViewModel: CatsViewModel = hiltViewModel()) {
    val state = catsViewModel.state.value

    LazyColumn(
        Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom=16.dp)
    ) {
        items(state.cats.size) { i ->
            CatViewItem(cat = state.cats[i])
        }
    }

}